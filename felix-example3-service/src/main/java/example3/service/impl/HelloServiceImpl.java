package example3.service.impl;

import example3.service.HelloService;

public class HelloServiceImpl implements HelloService {
    public String sayHello() {
        System.out.println("Inside HelloServiceImpl.sayHello()");
        return "Say Hello";
    }
}
