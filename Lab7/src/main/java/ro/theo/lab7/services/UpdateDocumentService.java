package ro.theo.lab7.services;

import ro.theo.lab7.beans.DocumentBean;
import ro.theo.lab7.entities.Document;
import ro.theo.lab7.repositories.DocumentRepository;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/documents")
@ApplicationScoped
public class UpdateDocumentService {

    @EJB
    private DocumentRepository documentRepo;

    @PUT
    @Path("/{nameOfUser}")
    public Response changeName(@PathParam("nameOfUser") String nameOfUser, @QueryParam("name") String name) {
        Document document = documentRepo.getAll().stream().filter(d -> d.getAuthor().equals(nameOfUser)).findAny().orElse(null);
        System.out.println(nameOfUser);
        if (document != null){
            document.setAuthor(name);
            DocumentBean docBean = new DocumentBean(document.getId(), document.getName(), document.getAuthor(), document.getContent());
            documentRepo.save(docBean);
            return Response.ok().build();
        }
        System.out.println("no " + nameOfUser + " in the database");
        return Response.noContent().build();
    }
}
