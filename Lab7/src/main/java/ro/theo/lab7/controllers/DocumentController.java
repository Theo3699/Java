package ro.theo.lab7.controllers;

import ro.theo.lab7.beans.DocumentBean;
import ro.theo.lab7.entities.Document;
import ro.theo.lab7.repositories.DocumentRepository;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
//
//@Path("/documents")
//@ApplicationScoped
//public class DocumentController {
//
////    @EJB
////    private DocumentRepository documentRepo;
////
////    @GET
////    @Produces(MediaType.APPLICATION_JSON)
////    public List<Document> ViewDocumentsService() {
////        return documentRepo.getAll();
////    }
////
////    @GET
////    @Path("/{user}")
////    @Produces(MediaType.APPLICATION_JSON)
////    public List<Document> ViewDocumentService(@PathParam("user") String user) {
////        return documentRepo.getAll().stream().filter(d -> d.getAuthor().equals(user)).collect(Collectors.toList());
////    }
//
////    @POST
////    @Consumes(MediaType.APPLICATION_JSON)
////    @Produces(MediaType.APPLICATION_JSON)
////    public Response createDocumentAndResponse(Document document) {
////        DocumentBean docBean = new DocumentBean(document.getId(), document.getName(), document.getAuthor(), document.getContent());
////        documentRepo.save(docBean);
////        URI uri = UriBuilder.fromResource(this.getClass())
////                .path("" + document.getId()).build();
////        return Response.created(uri).entity(document).build();
////    }
////
////    @PUT
//
//}
