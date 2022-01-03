package ro.theo.microservice.config;

//import ro.theo.lab7.controllers.DocumentController;

import ro.theo.microservice.services.AddDocumentService;
import ro.theo.microservice.services.ClientController;
import ro.theo.microservice.services.ViewDocumentService;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("/resources")
@ApplicationScoped
public class ApplicationConfig extends Application {
    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ViewDocumentService.class);
        resources.add(AddDocumentService.class);
        resources.add(ClientController.class);
//        resources.add(UpdateDocumentService.class);
//        resources.add(DeleteDocumentService.class);
    }

    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
}