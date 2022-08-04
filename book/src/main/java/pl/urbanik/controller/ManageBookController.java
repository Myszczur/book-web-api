package pl.urbanik.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.urbanik.repository.BookRepository;

@Controller
@RequiredArgsConstructor
public class ManageBookController {
    private final BookRepository bookRepository;

    @GetMapping("/all")
    public String showPosts(Model model){
        model.addAttribute("listOfBooks", bookRepository.findAll());
        return "/books/all";
    }
}
