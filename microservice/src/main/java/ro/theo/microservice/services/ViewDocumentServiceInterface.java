package ro.theo.microservice.services;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import ro.theo.microservice.entities.Document;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@RegisterRestClient(baseUri = "http://localhost:8080/microservice/resources")
@ApplicationScoped
public interface ViewDocumentServiceInterface {
    @GET
    @Path("/documents")
    List<Document> getDocuments();
}
