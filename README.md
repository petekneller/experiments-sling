# Getting started

* /distribution-5.6.2 contains expanded distribution zip
* from there, `java -jar bin/felix.jar` will start the container
** `felix:lb` : list bundles
** `felix:cd` : change directory
* in order to get the required dependency bundles automatically into felix, I've used the maven dependency plugin to copy the deps to the target folder and then told felix (in the run config) to use the target directory as its 'auto-load' directory (`-Dfelix.auto.deploy.dir=../<example_base_dir>/target`)
** NB. OSGi containers cache their bundle jars, which can/will interfere in cases where they're being rebuilt with the same name; use `-Dorg.osgi.framework.storage.clean=onFirstInit` to clean up each start

# Examples
* /felix-example1: a simple example of a service that listens for events inside the container and emits to stdout;  http://felix.apache.org/documentation/tutorials-examples-and-presentations/apache-felix-osgi-tutorial/apache-felix-tutorial-example-1.html
* /felix-jetty: a 'hello world' servlet hosted in jetty within felix; https://examples.javacodegeeks.com/enterprise-java/jetty/jetty-osgi-example/
* /felix-webadmin: based on http://felix.apache.org/documentation/subprojects/apache-felix-web-console.html and http://felix.apache.org/documentation/subprojects/apache-felix-http-service.html
** admin console available at: http://localhost:8080/system/console
