package dasz.controller;

import dasz.model.FileInfo;
import dasz.repository.FileInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;
import java.util.Optional;

@RestController
public class FileInfoController {

    private static FileInfoRepository fileRepo;

    @Autowired
    public FileInfoController(FileInfoRepository fileRepo) {
        this.fileRepo = fileRepo;
    }

    @GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FileInfo> getFiles() {
        return fileRepo.findAll();
    }

    @GetMapping(path = "/list/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<FileInfo> getFile(@PathVariable long id) {
        return fileRepo.findById(id);
    }

    @GetMapping(path = "/csv/{id}", produces = MediaType.TEXT_HTML_VALUE)
    public String getCSV(@PathVariable long id) {
        if (id<=fileRepo.count()){
            FileInfo fileInfo = fileRepo.getOne(id);
            return fileInfo.getFileId().toString().toUpperCase() + "|" +
                    fileInfo.getFileName().toUpperCase() + "|" +
                    fileInfo.getCreatedAt().toString().toUpperCase() + "|" +
                    fileInfo.getSize().toString().toUpperCase() + " Bytes";
        }
        return "No such Id in database";
    }

    public static void addFileInfoToRepo(FileInfo fileInfo) {
        fileRepo.save(fileInfo);
    }


}
