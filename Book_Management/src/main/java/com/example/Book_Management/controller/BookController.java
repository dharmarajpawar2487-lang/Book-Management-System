package com.example.Book_Management.controller;

import com.example.Book_Management.model.Book;
import com.example.Book_Management.service.BookService;  // 👈 Interface import
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;   // 👈 Interface वापर

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @GetMapping("/new")
    public String createBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "create_book";
    }

    @PostMapping
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    // ✅ updated method with null-check
    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);

        // जर Book null असेल तर Error Page कडे redirect करा
        if (book == null) {
            System.out.println("❌ Invalid book Id: " + id);
            model.addAttribute("errorMessage", "Book with ID " + id + " not found!");
            return "error";   // src/main/resources/templates/error.html हवाच
        }

        model.addAttribute("book", book);
        return "edit_book";   // हा template असायलाच हवा
    }

    @PostMapping("/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute("book") Book book) {
        book.setId(id);
        bookService.updateBook(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return "redirect:/books";
       
    }  
    }




