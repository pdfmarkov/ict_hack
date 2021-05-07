package org.comrades.springtime.module;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "fileuploadDownload")
public class FileModel {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")

    private String fileId;
    private String fileName;
    private String fileType;
    @Lob
    private byte[] fileData;

    public FileModel() {}

    public FileModel(String fileName, String fileType) {
        this.fileName = fileName;
        this.fileType = fileType;

    }

    public FileModel(String fileName, String fileType, byte[] fileData) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileData = fileData;
    }
}