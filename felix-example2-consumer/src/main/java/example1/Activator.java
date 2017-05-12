/*
 * Apache Felix OSGi tutorial.
 * http://felix.apache.org/documentation/tutorials-examples-and-presentations/apache-felix-osgi-tutorial/apache-felix-tutorial-example-1.html
**/

package example1;

import example2.service.HelloService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceEvent;

public class Activator implements BundleActivator, ServiceListener
{
    public void start(BundleContext context)
    {
        HelloService hello = example2.service.HelloServiceFactory.create();
        hello.sayHello();
    }

    public void stop(BundleContext context)
    {
    }

    public void serviceChanged(ServiceEvent serviceEvent) {

    }
}