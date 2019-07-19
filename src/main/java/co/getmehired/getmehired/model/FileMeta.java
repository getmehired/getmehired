package co.getmehired.getmehired.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection ="fileMetas")
@AllArgsConstructor
public class FileMeta {

	// TODO add required fields

	@Id
	private String id;

	private String fileName;

	private String fileType;

	private String path;
	private String fileStatus;

}
