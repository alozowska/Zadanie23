package pl.javastart.zadanie;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BookRepository {
    private EntityManager entityManager;

    public BookRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<Book> findAll(){
        TypedQuery<Book> query=entityManager.createQuery("select b from Book b", Book.class);
        List<Book> books=query.getResultList();
        return books;
    }
    public Book findById(Long id){
        Book book=entityManager.find(Book.class, id);
        return book;
    }

    public void save(Book book) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }
}
