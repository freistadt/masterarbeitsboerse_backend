package com.masterarbeitsboerse.masterarbeitsboerse.service;

import com.masterarbeitsboerse.masterarbeitsboerse.exception.NoResultExecption;
import com.masterarbeitsboerse.masterarbeitsboerse.model.Paper;
import com.masterarbeitsboerse.masterarbeitsboerse.repository.PaperRepo;
import org.hibernate.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaperService {
    private final PaperRepo paperRepo;

    //when this Service gets constructed it creates the PaperRepository
    @Autowired
    public PaperService(PaperRepo paperRepo) {
        this.paperRepo = paperRepo;
    }

    //Create a Paper Instance in the database --> The JPA Repository does all the heavy work with cretaing the SQL Statments
    public Paper addPaper(Paper paper) {

        //This should not be filled by the User so it is autognerated
        paper.setPaperCode(UUID.randomUUID().toString());
        return paperRepo.save(paper);
    }

    public List<Paper> findAllPapers() {
        return paperRepo.findAll();
    }

    //save a specific paper
    public Paper updatePaper(Paper paper) {
        return paperRepo.save(paper);
    }

    //delte a specifix paper with the passed ID
    public void deletePaper(Long id) {
        paperRepo.deletePaperById(id);
    }

    //find gets  translated by Spring to a select statement that returns the Paper with the input id. If no Paper with the ID is found an Expeption gets created and thrown
    public Paper findPaperById(Long id) {
        return paperRepo.findPaperById(id).orElseThrow(()
                -> new NoResultExecption("The Paper with the passed ID: " +id+ " was not found"));
    }


}
