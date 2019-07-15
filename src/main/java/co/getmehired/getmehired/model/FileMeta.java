package co.getmehired.getmehired.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "fileMetas")
@AllArgsConstructor
public class FileMeta {

	// TODO add required fields
    @Id
    private String fileId;

    private String filename;
    private fileType filetype;
    private String path;

    public  FileMeta(){
        this.fileId = fileId;
        this.filename = filename;
        this.filetype = filetype;
        this.path = path;
    }

}
