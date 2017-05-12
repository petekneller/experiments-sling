package example3;

import example3.service.HelloService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

    ServiceReference helloServiceReference;

    public void start(BundleContext context) throws Exception {
        System.out.println("Hello World!!");
        helloServiceReference= context.getServiceReference("HelloService");
        HelloService helloService =(HelloService)context.getService(helloServiceReference);
        System.out.println(helloService.sayHello());

    }
    public void stop(BundleContext context) throws Exception {
        System.out.println("Goodbye World!!");
        context.ungetService(helloServiceReference);
    }
}