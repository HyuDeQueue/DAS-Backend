package com.project.DASBackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.DASBackend.dto.CommitmentPaperDto;
import com.project.DASBackend.service.CommitmentPaperService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/commitmentpapers")
public class CommitmentPaperController {

    private CommitmentPaperService commitmentPaperService;

    @PostMapping
    public ResponseEntity<CommitmentPaperDto> createCommitmentPaper(@RequestBody CommitmentPaperDto commitmentPaperDto){
        CommitmentPaperDto savedCommitmentPaperDto = commitmentPaperService.createCommitmentPaper(commitmentPaperDto);
        return new ResponseEntity<>(savedCommitmentPaperDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CommitmentPaperDto> getCommitmentPaperById(@PathVariable("id") Integer commitmentPaperId){
        CommitmentPaperDto commitmentPaperDto = commitmentPaperService.getCommitmentPaperById(commitmentPaperId);
        return ResponseEntity.ok(commitmentPaperDto);
    }

    @GetMapping
    public ResponseEntity<List<CommitmentPaperDto>> getAllCommitmentPapers(){
        List<CommitmentPaperDto> commitmentPaperDto = commitmentPaperService.getAllCommitmentPapers();
        return ResponseEntity.ok(commitmentPaperDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<CommitmentPaperDto> updateCommitment(@RequestBody CommitmentPaperDto commitmentPaperDto,
                                                                        @PathVariable("id") Integer commitmentPaperId) {
        return new ResponseEntity<>(commitmentPaperService.updateCommitmentPaper(commitmentPaperId, commitmentPaperDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCommitmentPaper(@PathVariable("id") Integer commitmentPaperId) {
        commitmentPaperService.deleteCommitmentPaper(commitmentPaperId);
        return new ResponseEntity<>("Commitment paper deleted successfully", HttpStatus.OK);
    }
}
