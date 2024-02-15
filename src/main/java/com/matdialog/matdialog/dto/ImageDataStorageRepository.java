package com.matdialog.matdialog.dto;

import com.matdialog.matdialog.entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageDataStorageRepository extends JpaRepository<ImageData,Long> {

    Optional<ImageData> findByName(String fileName);

}
