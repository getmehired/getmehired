package co.getmehired.getmehired.rest;

import co.getmehired.getmehired.model.FileMeta;
import co.getmehired.getmehired.service.FileService;
import co.getmehired.getmehired.util.GMHConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.google.firebase.auth.FirebaseAuth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Dell on 09-Jul-19.
 */

@CrossOrigin
@RestController
public class FileResource {

	@Autowired
	private FileService fileService;

	@PutMapping("/api/files/{fileType}")
	public FileMeta upload(@RequestHeader String idToken,@RequestParam("file") @RequestBody MultipartFile file, @PathVariable(name = "fileType") String fileType) {

		
		if(!isValidUser(idToken)) {
			return null;
		}
		
		FileMeta fileMeta = fileService.uploadFile(file, fileType);
		return fileMeta;

	}

	@GetMapping("/api/files/show/{fileId}")
	public FileMeta getFile(@RequestHeader String idToken,@PathVariable(name = "fileId") String fileId, HttpServletResponse response) {
		FileMeta fileMeta = fileService.getFileMetaById(fileId);
		if(fileMeta != null && GMHConstants.STATUS_VALID.equals(fileMeta.getFileStatus())) {
			ByteArrayOutputStream baos = fileService.getFile(fileMeta.getPath());
			try {
				response.getOutputStream().write(baos.toByteArray());
				response.getOutputStream().flush();
			}catch (Exception ex) {
			}
		}
		return fileMeta;
	}

	@GetMapping("/api/files/download/{fileId}")
	public ResponseEntity<Resource> downloadFile(@RequestHeader String idToken,@PathVariable(name="fileId") String fileId,  HttpServletRequest request) {

		if(!isValidUser(idToken)) {
			return null;
		}
		
		
		// TODO get path from database
		FileMeta fileMeta= fileService.getFileMetaById(fileId);
		if(fileMeta != null && GMHConstants.STATUS_VALID.equals(fileMeta.getFileStatus())) {

			// Try to determine file's content type
			String contentType=request.getServletContext().getMimeType(fileMeta.getPath());

			// Fallback to the default content type if type could not be determined
			if(contentType == null) {
				contentType = "application/octet-stream";
			}

			ByteArrayOutputStream baos = fileService.getFile(fileMeta.getPath());
			ByteArrayResource resource = new ByteArrayResource(baos.toByteArray());

			// TODO get actual filename from database
			return ResponseEntity.ok()
					.contentType(MediaType.parseMediaType(contentType))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileMeta.getFileName() + "\"")
					.body(resource);
		} else {
			return null;
		}
	}


	// TODO update this resource - pass the file id
	@DeleteMapping("/api/files/{fileId}")
	public FileMeta deleteFile(@RequestHeader String idToken,@PathVariable(name="fileId") String fileId) {

		if(!isValidUser(idToken)) {
			return null;
		}
		
		return fileService.delete(fileId);
	}

	@GetMapping("/api/files")
	public List<FileMeta> getFiles(@RequestHeader String idToken) {
		
		if(!isValidUser(idToken)) {
			return null;
		}	
		return fileService.getAllFiles();
	}

	private boolean isValidUser(String idToken) {
		try {
			String uid=FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getUid();
			String name=FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getName();
			String email=FirebaseAuth.getInstance().verifyIdTokenAsync(idToken).get().getEmail();

		} catch (InterruptedException | ExecutionException e) {
			return false;
		}

		return true;
	}

}
