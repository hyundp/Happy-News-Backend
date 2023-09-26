package com.example.happy.controller;

import com.example.happy.model.News;
import com.example.happy.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(originPatterns="https://happynews-alpha.vercel.app", allowedHeaders = "*")
@RestController
@RequestMapping("/articles")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService){
        this.newsService = newsService;
    }



    @GetMapping("/{id}")
    public List<News> findPickData(@PathVariable String id) {
        return newsService.getPickNews(id);
    }
    @GetMapping("")
    public List<News> findAllData() {
        return newsService.getAllNews();
    }
}
