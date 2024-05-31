package com.project.DASBackend.controller;

import com.project.DASBackend.dto.AssessmentPaperDto;
import com.project.DASBackend.entity.AssessmentPaper;
import com.project.DASBackend.service.AssessmentPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/assessmentPapers")
public class AssessmentPaperController {

    @Autowired
    private AssessmentPaperService assessmentPaperService;

    @PostMapping
    public ResponseEntity<AssessmentPaperDto> createAssessmentPaper(AssessmentPaperDto assessmentPaperDto){
        return new ResponseEntity<>(assessmentPaperService.createAssessmentPaper(assessmentPaperDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<AssessmentPaperDto> getAssessmentPaperById(@PathVariable("id") Integer paperId){
        AssessmentPaperDto assessmentPaperDto = assessmentPaperService.getAssessmentPaperById(paperId);
        return ResponseEntity.ok(assessmentPaperDto);
    }

    @GetMapping
    public ResponseEntity<List<AssessmentPaperDto>> getAllAssessmentPapers(){
        List<AssessmentPaperDto> assessmentPaperDtos = assessmentPaperService.getAllAssessmentPapers();
        return ResponseEntity.ok(assessmentPaperDtos);
    }

    @PutMapping("{id}")
    public ResponseEntity<AssessmentPaperDto> updateAssessmentPaper(@RequestBody AssessmentPaperDto assessmentPaperDto,
                                                                      @PathVariable("id") Integer paperId){
        return ResponseEntity.ok(assessmentPaperService.updateAssessmentPaper(assessmentPaperDto, paperId));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAssessmentPaper(@PathVariable("id") Integer paperId){
        assessmentPaperService.deleteAssessmentPaper(paperId);
        return ResponseEntity.ok("Assessment paper deleted successfully");
    }
}
