package org.comrades.springtime.dao;

import org.comrades.springtime.module.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FileRepo extends JpaRepository<FileModel, String> {


    @Transactional
    FileModel findFileModelByFileName(String file_name);


}