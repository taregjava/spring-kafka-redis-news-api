package com.halfacode.news.controller;

import com.halfacode.news.dto.response.DataResponse;
import com.halfacode.news.service.NewsService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static com.halfacode.news.utils.Constants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/news")
public class NewsController {

    private final NewsService service;

    @GetMapping
    public Mono<ResponseEntity<DataResponse<Object>>> getNews(
        @NotBlank(message = DATE_NOT_BLANK_MESSAGE)
        @Pattern(regexp = DATE_FORMAT, message = DATE_PATTERN_MESSAGE)
        @RequestParam(name = "date") String date) {
        return service.getNews(date)
            .flatMap(data -> Mono.just(
                ResponseEntity.status(HttpStatus.OK)
                    .body(DataResponse.builder()
                        .status(Boolean.TRUE)
                        .message(DATA_FOUND_MESSAGE)
                        .data(data)
                        .build())))
            .switchIfEmpty(Mono.defer(() -> Mono.just(
                ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(DataResponse.builder()
                        .status(Boolean.FALSE)
                        .message(DATA_NOT_FOUND_MESSAGE)
                        .data(null)
                        .build()))));
    }

}
