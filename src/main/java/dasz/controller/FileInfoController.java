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
    public List<FileInfo> getFiles(){
        return fileRepo.findAll();
    }

    @GetMapping(path = "/list/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<FileInfo> getFile(@PathVariable long id){
        return fileRepo.findById(id);
    }

    public static void addFileInfoToRepo(FileInfo fileInfo){
        fileRepo.save(fileInfo);
    }


}
