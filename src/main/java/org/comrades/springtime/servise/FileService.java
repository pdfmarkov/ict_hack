package org.comrades.springtime.servise;

import org.comrades.springtime.module.FileModel;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    public FileModel saveFile(MultipartFile file);

    public FileModel getFile(String fileId);

    public List<FileModel> getListOfFiles();

}
