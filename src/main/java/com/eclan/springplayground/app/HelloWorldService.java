package com.eclan.springplayground.app;

import org.springframework.stereotype.Service;

import com.eclan.springplayground.app.port.in.HelloWorldUseCase;
import com.eclan.springplayground.common.toggle.TogglePoint;

@Service
public class HelloWorldService implements HelloWorldUseCase {

    @TogglePoint(someMethod = "")
    @Override
    public String getHelloWorld() {
        return "Hello World.";
    }

}
