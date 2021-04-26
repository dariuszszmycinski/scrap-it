package dasz.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class FileInfo implements Serializable {

    @Id
    @GeneratedValue
    private Long fileId;
    private String fileName;
    private Date createdAt;
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

    @Override
    public String toString() {
        return "FileInfo{" +
                "fileId=" + fileId +
                ", fileName='" + fileName + '\'' +
                ", createdAt=" + createdAt +
                ", size= lalal " + size +
                '}';
    }
}
