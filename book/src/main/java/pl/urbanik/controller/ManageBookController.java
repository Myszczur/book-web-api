package pl.urbanik.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.urbanik.model.Book;
import pl.urbanik.repository.BookRepository;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class ManageBookController {
    private final BookRepository bookRepository;

    @GetMapping("/all")
    public String showPosts(Model model) {
        model.addAttribute("listOfBooks", bookRepository.findAll());
        return "/books/all";
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "/books/add";
    }

    @PostMapping("/add")
    public String addBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/add";
        }
        bookRepository.save(book);
        return "redirect:/all";
    }

    @GetMapping("edit/{id}")
    public String editBook(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookRepository.getOne(id));
        return "/books/edit";
    }

    @PostMapping("/edit")
    public String editBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/edit";
        }
        bookRepository.save(book);
        return "redirect:/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/all";
    }

    @GetMapping("/show/{id}")
    public String showBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookRepository.getOne(id));
        return "/books/show";
    }

}
