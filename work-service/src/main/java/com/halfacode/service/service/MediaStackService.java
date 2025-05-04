package com.halfacode.service.service;

import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface MediaStackService {

    Mono<ResponseEntity<String>> sendRequest(String date);

}
