package ro.theo.microservice.repositories;

import ro.theo.microservice.beans.DocumentBean;
import ro.theo.microservice.entities.Document;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class DocumentRepository {

    @Inject
    protected EntityManager userManagerPU;

    public DocumentRepository() {
    }

    public void save(DocumentBean doc) {
        userManagerPU.getTransaction().begin();
        Document documentEntity = new Document();
        documentEntity.setAuthor(doc.getAuthor());
        documentEntity.setContent(doc.getContent());
        documentEntity.setName(doc.getName());
        userManagerPU.persist(documentEntity);
        userManagerPU.getTransaction().commit();
    }

    public List<Document> getAll() {
        Query query = userManagerPU.createNamedQuery("Document.getAll");
        return ((Collection<Document>) query.getResultList()).stream().collect(Collectors.toList());
    }

    public Document findByName(String name) {
        Query query = userManagerPU.createNamedQuery("Document.find");
        query.setParameter("name", name);
        Collection documentResults = query.getResultList();
        return (Document) documentResults.iterator().next();
    }

    public void remove(String name) {
        Query query = userManagerPU.createNamedQuery("Document.find");
        query.setParameter("name", name);
        Collection documentResults = query.getResultList();
        Document entryToBeRemoved = findByName(name);
        userManagerPU.getTransaction().begin();
        userManagerPU.remove(entryToBeRemoved);
        userManagerPU.getTransaction().commit();
    }
}
