package co.getmehired.getmehired.rest;

import co.getmehired.getmehired.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * Created by Dell on 09-Jul-19.
 */

@RestController
public class FileResource {

    @Autowired
    private FileService fileService;


    @PutMapping("/api/files")
    public void upload(@RequestParam("file") MultipartFile file) {

       fileService.uploadFile(file);

    }

    @GetMapping("/api/files")
    public InputStream getFile(@RequestParam String path) {

        return fileService.getFile(path);

    }


    @DeleteMapping("/api/files")
    public void deleteFile() {

        fileService.delete();

    }


}
