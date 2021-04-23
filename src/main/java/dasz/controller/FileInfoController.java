package dasz.controller;

import dasz.model.FileInfo;
import dasz.repository.FileInfoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
@RequestMapping("/files")
public class FileInfoController {
    private FileInfoRepository fileRepo;

    public FileInfoController(FileInfoRepository fileRepo) {
        this.fileRepo = fileRepo;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FileInfo> getFiles(){
        List<FileInfo> files = fileRepo.findAll();
        return files;
    }
}
