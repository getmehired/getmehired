package co.getmehired.getmehired.rest;

import co.getmehired.getmehired.model.FileMeta;
import co.getmehired.getmehired.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Optional;

/**
 * Created by Dell on 09-Jul-19.
 */

@RestController
public class FileResource {

	@Autowired
	private FileService fileService;

	//TODO follow post mapping of talent resource
	@PutMapping("/api/files")
	public FileMeta upload(@RequestParam("file") @PathVariable("test") @RequestBody MultipartFile file) {

		fileService.uploadFile(file,"test");
		FileMeta fileMeta=new FileMeta(null, file.getOriginalFilename(), "test", "test" + "/" + file.getOriginalFilename(),"Active");
		return fileMeta;

	}

	// TODO pass file id in path variable
	// TODO use the file id to get file path

	@GetMapping("/api/files/{Id}")
	public InputStream getFileById(@PathVariable String Id) {
		InputStream fileObject=fileService.getfilebyId(Id);
		System.out.print("object got");
		return fileObject;
	}

	@GetMapping("/api/files/show")
	public void getFile(@RequestParam String path, HttpServletResponse response) {
		ByteArrayOutputStream baos = fileService.getFile(path);
		try {
			response.getOutputStream().write(baos.toByteArray());
			response.getOutputStream().flush();
		}catch (Exception ex) {

		}
		return;
	}

	// TODO pass file id in @PathVariable
	@GetMapping("/api/files/download/{Id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String Id,  HttpServletRequest request) {

		// TODO get path from database
		Optional<FileMeta> fileMeta= fileService.getfileMetabyId(Id);
		String path=fileMeta.get().getPath();

		// Try to determine file's content type
		String contentType=request.getServletContext().getMimeType(path);

		// Fallback to the default content type if type could not be determined
		if(contentType == null) {
			contentType = "application/octet-stream";
		}

		ByteArrayOutputStream baos = fileService.getFile(path);
		ByteArrayResource resource = new ByteArrayResource(baos.toByteArray());

		// TODO get actual filename from database
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileMeta.get().getFileName() + "\"")
				.body(resource);
	}


	// TODO update this resource - pass the file id
	@DeleteMapping("/api/files/{Id}")
	public void deleteFile(@PathVariable String Id) {

		fileService.delete(Id);
	}


}
