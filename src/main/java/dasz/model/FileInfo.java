package dasz.model;

import com.fasterxml.jackson.annotation.JsonFilter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@JsonFilter("basicFilter")
public class FileInfo implements Serializable {

    @Id
    @GeneratedValue
    private Long fileId;
    @NotNull
    @NotEmpty
    private String fileName;
    @NotNull
    private Date createdAt;
    @NotNull
    @Max(500000000)
    private Long size;

    public FileInfo() {
    }

    public FileInfo(String fileName, Date createdAt, Long size) {
        this.fileName = fileName;
        this.createdAt = createdAt;
        this.size = size;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

}
