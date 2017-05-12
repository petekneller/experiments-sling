package example2;

import example2.service.HelloService;
import example2.service.HelloServiceFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceEvent;

public class Activator implements BundleActivator, ServiceListener
{
    public void start(BundleContext context)
    {
        HelloService hello = HelloServiceFactory.create();
        hello.sayHello();
    }

    public void stop(BundleContext context)
    {
    }

    public void serviceChanged(ServiceEvent serviceEvent) {

    }
}