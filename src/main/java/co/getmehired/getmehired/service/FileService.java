package co.getmehired.getmehired.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import co.getmehired.getmehired.model.FileMeta;
import co.getmehired.getmehired.repository.FileRepository;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

/**
 * Created by Dell on 09-Jul-19.
 */

@Service
public class FileService {

	@Autowired
	private FileRepository fileRepository;
	public static final String BUCKET_NAME = "";  // Your bucket name
	public static final String S3_ACCESS_KEY = ""; // Your access key
	public static final String S3_SECRET_KEY = "";

	public FileMeta uploadFile(MultipartFile file,String folder) {

		BasicAWSCredentials creds = new BasicAWSCredentials(S3_ACCESS_KEY, S3_SECRET_KEY);
		AmazonS3 client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).withCredentials(new AWSStaticCredentialsProvider(creds)).build();

		byte[] fileBytes = new byte[0];
		try {
			fileBytes = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Uploading a new object to S3 from a file\n");
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentType("text");
		metadata.setContentLength(fileBytes.length);

		String path = folder + "/" + file.getOriginalFilename();
		FileMeta fileMeta=new FileMeta(null, file.getOriginalFilename(), folder, path,"Active");
		client.putObject(BUCKET_NAME, path, new ByteArrayInputStream(fileBytes), metadata);

		// TODO update database (call file repository) if upload is successful
		fileRepository.save( fileMeta);

		// TODO return FileMeta object
		return fileMeta;
	}


	public InputStream getfilebyId(String Id){

		BasicAWSCredentials creds = new BasicAWSCredentials(S3_ACCESS_KEY, S3_SECRET_KEY);
		AmazonS3 client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).withCredentials(new AWSStaticCredentialsProvider(creds)).build();

		Optional<FileMeta> fileMeta= fileRepository.findById(Id);
		String path= fileMeta.get().getPath();
		S3Object object=client.getObject(BUCKET_NAME, path);
		InputStream objectData=object.getObjectContent();

		return objectData;
	}

	public Optional<FileMeta> getfileMetabyId(String Id){
		Optional<FileMeta> fileMeta= fileRepository.findById(Id);
		return fileMeta;
	}

	public ByteArrayOutputStream getFile(String path){

		BasicAWSCredentials creds = new BasicAWSCredentials(S3_ACCESS_KEY, S3_SECRET_KEY);
		AmazonS3 client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).withCredentials(new AWSStaticCredentialsProvider(creds)).build();

		S3Object object = client.getObject(BUCKET_NAME, path);
		InputStream objectData = object.getObjectContent();

		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			IOUtils.copy(objectData, baos);
			objectData.close();

			return baos;
		} catch (Exception ex) {

		}
		return null;
	}


	// TODO Modify the method, take file id as input, search database, delete from amazon, update database
	public void delete(String Id) {

		BasicAWSCredentials creds = new BasicAWSCredentials(S3_ACCESS_KEY, S3_SECRET_KEY);
		AmazonS3 client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).withCredentials(new AWSStaticCredentialsProvider(creds)).build();

		// TODO get file path from database
		FileMeta fileMeta;
		try {
			fileMeta = fileRepository.findById(Id).orElseThrow(() -> new Exception("Invalid file id"));
			String path=fileMeta.getPath();
			System.out.print(fileMeta.getFileStatus());
			fileMeta.setFileStatus("Deleted");
			fileRepository.save(fileMeta);
			client.deleteObject(BUCKET_NAME,path );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}


}
