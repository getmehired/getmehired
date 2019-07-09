package co.getmehired.getmehired.service;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by Dell on 09-Jul-19.
 */

@Service
public class FileService {


    public static final String BUCKET_NAME = "";  // Your bucket name
    public static final String S3_ACCESS_KEY = ""; // Your access key
    public static final String S3_SECRET_KEY = ""; // Your secret key

    public void uploadFile(MultipartFile file) {

        BasicAWSCredentials credentials = new BasicAWSCredentials(S3_ACCESS_KEY, S3_SECRET_KEY);
        AmazonS3Client client = new AmazonS3Client(credentials);

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

        client.putObject(BUCKET_NAME,"test/test.txt", new ByteInputStream(fileBytes, fileBytes.length), metadata);
//
//
//        client.putObject(BUCKET_NAME, "test/test.txt", (File) file);

        System.out.println("hello");
    }

    public InputStream getFile(String path){

        BasicAWSCredentials credentials = new BasicAWSCredentials(S3_ACCESS_KEY, S3_SECRET_KEY);
        AmazonS3Client client = new AmazonS3Client(credentials);

        S3Object object = client.getObject(BUCKET_NAME, path);
        InputStream objectData = object.getObjectContent();

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            IOUtils.copy(objectData, baos);
            objectData.close();

            System.out.print(baos.toByteArray());

            return objectData;
        } catch (Exception ex) {

        }
        return null;
    }

    public void delete() {

        BasicAWSCredentials credentials = new BasicAWSCredentials(S3_ACCESS_KEY, S3_SECRET_KEY);
        AmazonS3Client client = new AmazonS3Client(credentials);

        client.deleteObject(BUCKET_NAME, "test/test.txt");

    }


}
