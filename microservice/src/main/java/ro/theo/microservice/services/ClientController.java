package ro.theo.microservice.services;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import ro.theo.microservice.entities.Document;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/client")
@ApplicationScoped
public class ClientController {

    @Inject
    @RestClient
    private ViewDocumentServiceInterface service;

    @GET
    @Path("/secondService")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Document> onClientSide(){
        return service.getDocuments();
    }
}
