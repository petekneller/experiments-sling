package example3;

import example3.service.HelloService;
import example3.service.impl.HelloServiceImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    ServiceRegistration helloServiceRegistration;
    public void start(BundleContext context) throws Exception {
        HelloService helloService = new HelloServiceImpl();
        helloServiceRegistration =context.registerService("HelloService", helloService, null);
    }
    public void stop(BundleContext context) throws Exception {
        helloServiceRegistration.unregister();
    }
}