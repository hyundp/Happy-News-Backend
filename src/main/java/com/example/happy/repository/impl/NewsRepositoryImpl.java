package com.example.happy.repository.impl;

import com.example.happy.model.News;
import com.example.happy.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class NewsRepositoryImpl implements NewsRepository {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public NewsRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<News> getRandomSample(int sampleSize) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.sample(sampleSize)
        );

        AggregationResults<News> results = this.mongoTemplate.aggregate(aggregation, "news", News.class);

        return results.getMappedResults();
    }

    @Override
    public List<News> getPickRandomSample(int sampleSize, String id){
        Criteria criteria = new Criteria().where("_id").not().in(id);
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(criteria),
                Aggregation.sample(sampleSize)
        );

        AggregationResults<News> results = this.mongoTemplate.aggregate(aggregation, "news", News.class);
        return results.getMappedResults();
    }

    @Override
    public List<News> getById(String id){
        Criteria criteria = new Criteria().where("_id").in(id);
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(criteria)
        );

        AggregationResults<News> results = this.mongoTemplate.aggregate(aggregation, "news", News.class);
        return results.getMappedResults();
    }

    @Override
    public <S extends News> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends News> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends News> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends News> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends News> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends News> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends News> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends News> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends News, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends News> S save(S entity) {
        return null;
    }

    @Override
    public <S extends News> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<News> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<News> findAll() {
        return null;
    }

    @Override
    public List<News> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(News entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends News> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<News> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<News> findAll(Pageable pageable) {
        return null;
    }
}
