package pl.javastart.zadanie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.util.List;

@Controller
public class HomeController {

   private BookRepository bookRepository;

    public HomeController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/")
    public String homepage(Model model){

        //1.pobrac liste z bazy
        List<Book> books= bookRepository.findAll();
        //2. przekazac do szablonu;
        model.addAttribute("books", books);
        return "homepage";
    }
}
