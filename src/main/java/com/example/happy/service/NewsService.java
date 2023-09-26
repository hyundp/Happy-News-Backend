package com.example.happy.service;

import com.example.happy.model.News;

import java.util.List;

public interface NewsService {

    List<News> getAllNews();
    List<News> getPickNews(String id);

}
