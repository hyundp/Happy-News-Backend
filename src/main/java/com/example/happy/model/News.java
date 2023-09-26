package com.example.happy.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "news")
public class News {

    private String _id;
    private String title;
    private String link;
    private String summary;
    private float prob;
    private String time;

}
