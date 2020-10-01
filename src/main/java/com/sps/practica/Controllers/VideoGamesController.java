package com.sps.practica.Controllers;

import com.sps.practica.DTOs.AnswerDTO;
import com.sps.practica.DTOs.QuestDTO;
import com.sps.practica.Services.VideoGamesService;
import com.sps.practica.VOs.AnswerVO;
import com.sps.practica.VOs.QuestVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class VideoGamesController {

    @Autowired
    private VideoGamesService videogamesService;
    
    @PostMapping("/sps/helloworld/v1")
    public ResponseEntity askToMagicConch(
        @RequestParam(name = "easterEgg", required = false)  final String easterEgg,
        @RequestBody final QuestVO quest
    ){  
        if(quest.getAsk() == null || quest.getAsk().isEmpty())
            return new ResponseEntity<String>("REQUEST BODY ERR: ask is required",HttpStatus.BAD_REQUEST);
        QuestDTO questDTO = QuestDTO.builder().quest(quest.getAsk()).build();
        AnswerDTO answerDTO = videogamesService.askToMagicConch(easterEgg, questDTO);
        AnswerVO answer = new AnswerVO();
        answer.setAnswer(answerDTO.getAnswer());

        return new ResponseEntity<AnswerVO>(answer,HttpStatus.OK);
    }

}
