package com.eclan.springplayground.adapter.in.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eclan.springplayground.app.port.in.HelloWorldUseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/hello-world")
public class HelloWorldController {

    private final HelloWorldUseCase useCase;

    @GetMapping
    String getHelloWorld() {
        return useCase.getHelloWorld();
    }
}
