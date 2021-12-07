package ro.theo.lab7.beans;

import ro.theo.lab7.repositories.DocumentRepository;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Database {
    @EJB
    private DocumentRepository documentRepo;

    public void submit(DocumentBean documentBean){
        documentRepo.save(documentBean);
    }
}
