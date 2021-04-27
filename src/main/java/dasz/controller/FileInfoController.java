package dasz.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import dasz.model.FileInfo;
import dasz.repository.FileInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FileInfoController {

    private static FileInfoRepository fileRepo;

    @Autowired
    public FileInfoController(FileInfoRepository fileRepo) {
        FileInfoController.fileRepo = fileRepo;
    }

    @GetMapping(path = "/list")
    MappingJacksonValue getFilesListJson() {
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.serializeAllExcept("createdAt", "size");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("basicFilter", simpleBeanPropertyFilter);
        List<FileInfo> files = fileRepo.findAll();
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(files);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }

    @GetMapping(path = "/list/{id}")
    MappingJacksonValue getOneFileJson(@PathVariable long id) {
        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.serializeAllExcept();
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("basicFilter", simpleBeanPropertyFilter);
        Optional<FileInfo> fileInfo = fileRepo.findById(id);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(fileInfo);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }

    @GetMapping(path = "/csv/{id}")
    public String getOneFileCsv(@PathVariable long id) {
        if (id <= fileRepo.count()) {
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
