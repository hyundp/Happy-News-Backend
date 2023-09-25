package com.example.happy.controller;

import com.example.happy.domain.News;
import com.example.happy.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService){
        this.newsService = newsService;
    }

    @GetMapping("/title")
    public News getTitle(@PathVariable String title){
        return newsService.getTitle(title);
    }
}
