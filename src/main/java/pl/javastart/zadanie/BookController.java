package pl.javastart.zadanie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @GetMapping("/ksiazka/{id}")
    public String bookDetails(@PathVariable Long id, Model model){
      Book book=bookRepository.findById(id);

      model.addAttribute("book", book);

      return "book";
    }
    @GetMapping("/dodawanie")
    public String formularzDodawania(Model model){
        model.addAttribute("book", new Book());
        return "dodawanie.html";
    }
    @PostMapping("/dodawanie")
    public String dodajKsiazke(Book book){
        bookRepository.save(book);
        return "redirect:/";
    }
}
