package org.comrades.springtime.servise.impl;

import org.comrades.springtime.customExceptions.FileErrors;
import org.comrades.springtime.customExceptions.FileNotFoundException;
import org.comrades.springtime.customExceptions.FileSaveException;
import org.comrades.springtime.dao.FileRepo;
import org.comrades.springtime.module.FileModel;
import org.comrades.springtime.servise.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

@Service
public class FileServiceImpl implements FileService {

    final FileRepo fileRepo;

    @Autowired
    public FileServiceImpl(FileRepo fileRepo) {
        this.fileRepo = fileRepo;
    }

    public FileModel saveFile(MultipartFile file) {
        String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        try {
            if (filename.contains("...")) {
                throw new FileSaveException(FileErrors.INVALID_FILE + filename);
            }
            FileModel model = new FileModel(filename, file.getContentType(), file.getBytes());
            return fileRepo.save(model);

        } catch (Exception e) {
            throw new FileSaveException(FileErrors.FILE_NOT_STORED, e);
        }
    }

    public FileModel getFile(String filename) {
        return fileRepo.findFileModelByFileName(filename);
    }

    public List<FileModel> getListOfFiles(){
        return fileRepo.findAll();
    }
}