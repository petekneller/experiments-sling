package example2.service.impl;

import example2.service.HelloService;

public class HelloServiceImpl implements HelloService {
    public String sayHello() {
        System.out.println("Inside HelloServiceImpl.sayHello()");
        return "Say Hello";
    }
}
