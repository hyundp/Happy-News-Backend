package com.example.happy.service.impl;

import com.example.happy.domain.News;
import com.example.happy.repository.NewsRepository;
import com.example.happy.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsRepository newsRepository){
        this.newsRepository = newsRepository;
    }
    @Override
    public News getId(int id) {
        return null;
    }

    @Override
    public News getLink(String link) {
        return null;
    }

    @Override
    public News getTitle(String title) {
        return newsRepository.findById(title).orElse(null);
    }

    @Override
    public News getSummary(String summary) {
        return null;
    }

    @Override
    public News getProb(float prob) {
        return null;
    }
}
