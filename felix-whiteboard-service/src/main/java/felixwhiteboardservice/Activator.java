package felixwhiteboardservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import javax.servlet.Servlet;
import java.util.Hashtable;

public class Activator implements BundleActivator {
    private ServiceRegistration registration;

    public void start(BundleContext context) throws Exception {
        Hashtable props = new Hashtable();
        props.put("osgi.http.whiteboard.servlet.pattern", "/hello");
        props.put("servlet.init.message", "Hello World!");

        this.registration = context.registerService(Servlet.class.getName(), new HelloWorldServlet(), props);
        System.out.println("Registered servlet");
    }

    public void stop(BundleContext context) throws Exception {
        this.registration.unregister();
    }
}