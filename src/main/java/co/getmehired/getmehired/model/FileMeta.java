package co.getmehired.getmehired.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "fileMetas")
@AllArgsConstructor
public class FileMeta {

	// TODO add required fields
}
