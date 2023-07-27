package com.train.resource_server.service;

import com.train.resource_server.entity.Statistic;
import com.train.resource_server.entity.UserSelection;
import com.train.resource_server.repository.StatisticRepository;
import com.train.resource_server.repository.UserSelectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {

    private final StatisticRepository statisticRepository;

    private final UserSelectionRepository userSelectionRepository;

    @Autowired
    public StatisticService(StatisticRepository statisticRepository, UserSelectionRepository userSelectionRepository) {
        this.statisticRepository = statisticRepository;
        this.userSelectionRepository = userSelectionRepository;
    }

    public List<Statistic> getStatistics(){
        return statisticRepository.findAll();
    }

    public List<UserSelection> findAll(){return userSelectionRepository.findAll();}
}
