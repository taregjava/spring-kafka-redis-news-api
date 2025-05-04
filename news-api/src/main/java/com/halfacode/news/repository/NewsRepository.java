package com.halfacode.news.repository;

import reactor.core.publisher.Mono;

public interface NewsRepository {

    Mono<Object> getNews(String date);

}
