package ro.theo.lab7.services;

import ro.theo.lab7.beans.DocumentBean;
import ro.theo.lab7.entities.Document;
import ro.theo.lab7.repositories.DocumentRepository;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

@Path("/documents")
@ApplicationScoped
public class AddDocumentService {

    @EJB
    private DocumentRepository documentRepo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDocumentAndResponse(Document document) {
        DocumentBean docBean = new DocumentBean(document.getId(), document.getName(), document.getAuthor(), document.getContent());
        documentRepo.save(docBean);
        URI uri = UriBuilder.fromResource(this.getClass())
                .path("" + document.getId()).build();
        return Response.created(uri).entity(document).build();
    }
}
