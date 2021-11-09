import com.theo.databaselaborator3facultate.Exam;
import com.theo.repositories.ExamRepository;
import org.hibernate.cfg.Environment;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestRepository {

    @Test
    public void nullNameNotAllowed(){
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("ExamManagerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Exam exam = new Exam(null, "10:40", "60");
        em.persist(exam);
        em.getTransaction().commit();
        em.close();
        emf.close();
//        ExamRepository er = new ExamRepository("ceva");
//        er.save(exam);
    }
}
