package felixhttpservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {
    private ServiceTracker httpTracker;

    public void start(BundleContext context) throws Exception {
        httpTracker = new ServiceTracker(context, HttpService.class.getName(), null) {
            public void removedService(ServiceReference reference, Object service) {
                // HTTP service is no longer available, unregister our servlet...
                try {
                    ((HttpService) service).unregister("/hello");
                    System.out.println("Unregistered service");
                } catch (IllegalArgumentException exception) {
                    // Ignore; servlet registration probably failed earlier on...
                }
            }

            public Object addingService(ServiceReference reference) {
                // HTTP service is available, register our servlet...
                HttpService httpService = (HttpService) this.context.getService(reference);
                try {
                    httpService.registerServlet("/hello", new HelloWorldServlet(), null, null);
                    System.out.println("Registered service");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                return httpService;
            }
        };
        // start tracking all HTTP services...
        httpTracker.open();
    }

    public void stop(BundleContext context) throws Exception {
        // stop tracking all HTTP services...
        httpTracker.close();
    }
}
