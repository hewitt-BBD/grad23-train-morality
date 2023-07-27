package com.train.resource_server.controller;


import com.train.resource_server.entity.Statistic;
import com.train.resource_server.entity.StatsResponse;
import com.train.resource_server.entity.UserSelection;
import com.train.resource_server.service.AnswerService;
import com.train.resource_server.service.StatisticService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StatisticController {

    private StatisticService statisticService;

    private AnswerService answerService;

    public StatisticController(StatisticService statisticService, AnswerService answerService) {
        this.statisticService = statisticService;
        this.answerService = answerService;
    }

    @GetMapping("/stat/{user}")
    public List<StatsResponse> getStats(@PathVariable int user){
        List<Statistic> stats = statisticService.getStatistics();
        List<StatsResponse> response = new ArrayList<>();
        List<UserSelection> userSelections = statisticService.findAll();
        System.out.println(userSelections.toString());
        for(Statistic stat : stats){
            String userChoice = getUserChoice(userSelections, user, stat.getQuestion());
            response.add(new StatsResponse(userChoice, stat));
        }
        return response;
    }

    private String getUserChoice(List<UserSelection> userSelections, int user, int question){
        for(UserSelection us : userSelections){
            if (us != null) {
                if (us.getUser() == user && us.getQuestion() == question) {
                    return us.getOption();
                }
            }
        }
        return "";
    }
}
