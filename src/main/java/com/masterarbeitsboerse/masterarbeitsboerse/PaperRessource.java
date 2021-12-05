package com.masterarbeitsboerse.masterarbeitsboerse;

import com.masterarbeitsboerse.masterarbeitsboerse.model.Paper;
import com.masterarbeitsboerse.masterarbeitsboerse.service.PaperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//not the saves but fixes cors error
@CrossOrigin("*")
@RestController
//URL for the this Application
@RequestMapping("/paper")
public class PaperRessource {
    //when contrsucted create an Instance of a PaperService to have access to the Service Logic
    private final PaperService paperService;

    public PaperRessource(PaperService paperService) {
        this.paperService = paperService;
    }


    //Baiscally all the Functions from the Service gets mirrored here and are able to be
    // called by Get/Post Mapping the real logik is still in the ServiceClass

    //ResponseEntity   @GetMapping= Generic --> we say its an List of Paper
    @GetMapping("/findAll")
    public ResponseEntity<List<Paper>> getAllPapers (){
        //call the function from the Service an save it in the List
        List<Paper> papers = paperService.findAllPapers();
        //the OK HTTPStaus code gets returnes so the User gets a 200 (success Message) repsonse
        return new ResponseEntity<>(papers, HttpStatus.OK);
    }


    //first mapping is to /paper --> so this mapping is /paper/find/{id} --> {id} = a passed in ID from the Client
    @GetMapping("/find/{id}")
    //the GetMapping and PathVariable id match so now the id is accessable in the function
    public ResponseEntity<Paper> getPaperById (@PathVariable("id") Long id){
        Paper paper = paperService.findPaperById(id);
        return new ResponseEntity<>(paper, HttpStatus.OK);
    }

    //function to add an a Paper --> we recive Input so PostMapping
    //the Paper is recvied via JSON
    @PostMapping("/add")
    public ResponseEntity<Paper> addPaper(@RequestBody Paper paper) {
        Paper paperNew = paperService.addPaper(paper);
        //HTTPStatus Created because on the Server something got Created
        return new ResponseEntity<>(paperNew, HttpStatus.CREATED);
    }

    //Update a existing Paper
    //TODO CHECK how to do with postmen
    @PutMapping("update")
    public ResponseEntity<Paper> updatePaper(@RequestBody Paper paper) {
            Paper paperUpdate = paperService.updatePaper(paper);
        return new ResponseEntity<>(paperUpdate, HttpStatus.OK);
    }

    //Delete a existing Paper. No return therfore the ? as repsonse Entitiy
    @DeleteMapping("delete/{id}")
    //function here an error this annotation prevents this
    @Transactional
    public ResponseEntity<?> deletePaper(@PathVariable("id") Long id) {
        paperService.deletePaper(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
