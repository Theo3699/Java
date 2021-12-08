package ro.theo.lab7.beans;

import ro.theo.lab7.entities.Document;
import ro.theo.lab7.repositories.DocumentRepository;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.event.Observes;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static ro.theo.lab7.config.Logger.log;

@ManagedBean
@ViewScoped
public class Database {

    private List<Document> documents;
    @EJB
    private DocumentRepository documentRepo;

    @PostConstruct
    public void init() {
        documents = documentRepo.getAll();
    }

    public void submit(DocumentBean documentBean) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (hour <= 24 && hour >= 0) {
            documentRepo.save(documentBean);
            System.out.println("Document submitted successfully");
            log("Document has been submitted -> Author: " + documentBean.getAuthor() + " Name: " + documentBean.getName() + " Content: " + documentBean.getContent() + "Registration number: " + documentBean.getId());

        } else {
            System.out.println("Can't submit document now. Try later!");
        }
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public void updatedDatabase(@Observes Document doc) {
        System.out.println("A new document has been added!");
        log("An event-based communication has occured for type Document");
    }
}
