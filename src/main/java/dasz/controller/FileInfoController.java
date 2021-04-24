package dasz.controller;

import dasz.model.FileInfo;
import dasz.repository.FileInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
//@Controller
public class FileInfoController {

    private FileInfoRepository fileRepo;

    @Autowired
    public FileInfoController(FileInfoRepository fileRepo) {
        this.fileRepo = fileRepo;
    }

    @GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FileInfo> getFiles(){
        List<FileInfo> files = fileRepo.findAll();
        return files;
    }


}
