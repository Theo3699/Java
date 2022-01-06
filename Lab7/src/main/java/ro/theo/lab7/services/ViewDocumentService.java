package ro.theo.lab7.services;

import ro.theo.lab7.entities.Document;
import ro.theo.lab7.repositories.DocumentRepository;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/documents")
@RolesAllowed({"admin", "user"})
@ApplicationScoped
public class ViewDocumentService {

    @EJB
    private DocumentRepository documentRepo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public List<Document> getall() {
        return documentRepo.getAll();
    }

    @GET
    @Path("/{user}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Document> find(@PathParam("user") String user) {
        return documentRepo.getAll().stream().filter(d -> d.getAuthor().equals(user)).collect(Collectors.toList());
    }
}
