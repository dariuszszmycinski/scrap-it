package dasz.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;
import java.util.Objects;

@Entity
@JsonFilter("basicFilter")
public class FileInfo implements Serializable {

    @Id
    @GeneratedValue
    private Long fileId;
    @NotNull
    @NotEmpty
    private String fileName;
    private int numRows;
    @NotNull
    private Date createdAt;
    @NotNull
    @Max(500000000)
    private Long size;

    public FileInfo() {
    }

    public FileInfo(MultipartFile file) throws IOException {
        File file1 = convert(file);
        BasicFileAttributes attr = Files.readAttributes(file1.toPath(), BasicFileAttributes.class);
        this.fileName = file.getOriginalFilename();
        this.numRows = getNumRows(file1);
        this.createdAt = new Date(attr.creationTime().toMillis());
        this.size = attr.size();
        Files.delete(file1.toPath());
    }

    private File convert(MultipartFile file) {
        File convFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return convFile;
    }

    private int getNumRows(File file) {
        int result = 0;
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            try {
                while (br.readLine() != null) {
                    result++;
                }
            } finally {
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Long getFileId() {
        return fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Long getSize() {
        return size;
    }

    public int getNumRows() {
        return numRows;
    }
}
