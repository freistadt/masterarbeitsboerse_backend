package com.masterarbeitsboerse.masterarbeitsboerse.repository;

import com.masterarbeitsboerse.masterarbeitsboerse.model.Paper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Paper is the class that is created in the model packet & Long is the ID/PrimaryKey form this class
//JpaRepository provides many useful functions like findAll, saveAll an others
public interface PaperRepo extends JpaRepository<Paper, Long> {
    //query gets created automatically, because of the Naming Convention --> Spring functionality
    void deletePaperById(Long id);
    //Optional to either return the paper or an exception
    Optional<Paper> findPaperById(Long id);
}
