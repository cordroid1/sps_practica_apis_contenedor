package com.sps.practica.Services;

import com.sps.practica.DTOs.AnswerDTO;
import com.sps.practica.DTOs.QuestDTO;
import com.sps.practica.Enums.AnswersEnum;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VideoGamesService {
    public AnswerDTO askToMagicConch(final String snake, final QuestDTO quest){
        if(quest.getQuest().contains("snake") && snake.equals("snake"))
            return AnswerDTO.builder().answer("Kept you waiting huh?").build();
        String answer = AnswersEnum.randomAnswer().toString().replace("_", " ");
        return AnswerDTO.builder().answer(answer).build();
    }
}
