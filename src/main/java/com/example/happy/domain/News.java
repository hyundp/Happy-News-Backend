package com.example.happy.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "news")
public class News {

    private int id;
    private String title;
    private String link;
    private String summary;
    private float prob;
    private String time;

}
