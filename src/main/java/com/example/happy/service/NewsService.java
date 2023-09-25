package com.example.happy.service;

import com.example.happy.domain.News;

public interface NewsService {
    News getId(int id);
    News getLink(String link);
    News getTitle(String title);
    News getSummary(String summary);
    News getProb(float prob);

}
