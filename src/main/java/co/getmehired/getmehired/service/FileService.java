package co.getmehired.getmehired.service;

import co.getmehired.getmehired.util.GMHConstants;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
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
import java.util.List;
import java.util.Optional;

/**
 * Created by Dell on 09-Jul-19.
 */

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public FileMeta uploadFile(MultipartFile file, String folder) {

        BasicAWSCredentials creds = new BasicAWSCredentials(GMHConstants.S3_ACCESS_KEY, GMHConstants.S3_SECRET_KEY);
        AmazonS3 client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).withCredentials(new AWSStaticCredentialsProvider(creds)).build();

        byte[] fileBytes = new byte[0];
        try {
            fileBytes = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());
        metadata.setContentLength(fileBytes.length);

        String path = folder + "/" + file.getOriginalFilename();
        FileMeta fileMeta = new FileMeta(null, file.getOriginalFilename(), folder, path, GMHConstants.STATUS_VALID);

        PutObjectResult result = client.putObject(GMHConstants.BUCKET_NAME, path, new ByteArrayInputStream(fileBytes), metadata);

        if (result != null) {
            fileRepository.save(fileMeta);
        }

        return fileMeta;
    }


    public InputStream getFileById(String Id) {

        BasicAWSCredentials creds = new BasicAWSCredentials(GMHConstants.S3_ACCESS_KEY, GMHConstants.S3_SECRET_KEY);
        AmazonS3 client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).withCredentials(new AWSStaticCredentialsProvider(creds)).build();

        Optional<FileMeta> fileMeta = fileRepository.findById(Id);
        String path = fileMeta.get().getPath();
        S3Object object = client.getObject(GMHConstants.BUCKET_NAME, path);
        InputStream objectData = object.getObjectContent();

        return objectData;
    }

    public FileMeta getFileMetaById(String Id) {
        Optional<FileMeta> fileMeta = fileRepository.findById(Id);
        return fileMeta.get();
    }

    public ByteArrayOutputStream getFile(String path) {

        BasicAWSCredentials creds = new BasicAWSCredentials(GMHConstants.S3_ACCESS_KEY, GMHConstants.S3_SECRET_KEY);
        AmazonS3 client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).withCredentials(new AWSStaticCredentialsProvider(creds)).build();

        S3Object object = client.getObject(GMHConstants.BUCKET_NAME, path);
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

    public FileMeta delete(String Id) {

        BasicAWSCredentials creds = new BasicAWSCredentials(GMHConstants.S3_ACCESS_KEY, GMHConstants.S3_SECRET_KEY);
        AmazonS3 client = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_2).withCredentials(new AWSStaticCredentialsProvider(creds)).build();

        // Get file path from database
        FileMeta fileMeta;
        try {
            fileMeta = fileRepository.findById(Id).orElseThrow(() -> new Exception("Invalid file id"));
            String path = fileMeta.getPath();

            client.deleteObject(GMHConstants.BUCKET_NAME, path);

            fileMeta.setFileStatus(GMHConstants.STATUS_DELETED);
            return fileRepository.save(fileMeta);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public List<FileMeta> getAllFiles() {
        return fileRepository.findAll();
    }
}
