package com.example.happy.service.impl;

import com.example.happy.model.News;
import com.example.happy.repository.NewsRepository;
import com.example.happy.service.NewsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository){
        this.newsRepository = newsRepository;
    }
    @Override
    public List<News> getPickNews(String id) {
        List<News> news_list = new ArrayList<>();

        if (newsRepository.findById(id) == null) {
            return null;
        }
        else{
            news_list.addAll(newsRepository.getById(id));
            news_list.addAll(newsRepository.getPickRandomSample(9, id));
            return news_list;
        }
    }

    @Override
    public List<News> getAllNews(){
        return newsRepository.getRandomSample(10);
    }

}
