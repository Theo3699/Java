package ro.theo.lab7.services;

import ro.theo.lab7.entities.Document;
import ro.theo.lab7.repositories.DocumentRepository;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/documents")
@ApplicationScoped
public class DeleteDocumentService {

    @EJB
    private DocumentRepository documentRepo;

    @DELETE
    @Path("/{authorName}")
    public Response deleteDocument (@PathParam("authorName") String authorName){
        Document document = documentRepo.findByName(authorName);
        if (document == null){
            return Response.noContent().build();
        }
        documentRepo.remove(authorName);
        return Response.ok().entity("Document deleted!").build();
    }
}
