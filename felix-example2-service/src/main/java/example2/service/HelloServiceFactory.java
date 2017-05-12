package example2.service;

import example2.service.impl.HelloServiceImpl;

public class HelloServiceFactory {
    public static HelloService create() {
        return new HelloServiceImpl();
    }
}
