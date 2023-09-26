package com.example.happy.repository;

import com.example.happy.model.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends MongoRepository<News, String>{
    List<News> getRandomSample(int sampleSize);
    List<News> getPickRandomSample(int sampleSize, String id);
    List<News> getById(String id);
}
