package com.example.demo.ctrs;

import com.example.demo.dto.AuthorDTO;
import com.example.demo.dto.BookDTO;
import com.example.demo.dto.BookPostDTO;
import com.example.demo.dto.GenreDTO;
import com.example.demo.jpa.Book;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import com.example.demo.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.naming.InsufficientResourcesException;
import javax.transaction.Transactional;
import java.util.Collection;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BookRestController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private GenreService genreService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("book")
    public Collection<Book> getBooks(){
        return bookService.findAllObjects();
    }


    @GetMapping("book/{id}")
    public Book getBookById(@PathVariable("id") Integer id){
        return bookService.getObjectById(id);
    }

    @GetMapping("book/name/{name}")
    public Book getBookByName(@PathVariable("name") String name){
        return bookService.getObjectByName(name);
    }

    /*@PostMapping("book")
    public ResponseEntity<Book> insertBook(@RequestBody Book book){
        if(!bookService.existsObjectById(book.getId())){
            bookService.saveObject(book);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

     */
    @PostMapping("book")
    public ResponseEntity addBook(@RequestBody BookPostDTO bookPostDTO){
        Book book = new Book();

        book.setId(bookPostDTO.getId());
        book.setName(bookPostDTO.getName());
        book.setAuthor(authorService.getObjectById(bookPostDTO.getAuthorid()));
        book.setGenre(genreService.getObjectById(bookPostDTO.getGenreid()));
        bookService.save(book);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }






    @PutMapping("book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Integer id ,@RequestBody BookPostDTO bookPostDTO){
       Book book = bookService.getObjectById(id);
//        book.setId(bookPostDTO.getId());
        book.setName(bookPostDTO.getName());
        book.setAuthor(authorService.getObjectById(bookPostDTO.getAuthorid()));
        book.setGenre(genreService.getObjectById(bookPostDTO.getGenreid()));
        Book updateBook = bookService.save(book);
        return ResponseEntity.ok(updateBook);
    }

    @Transactional
    @DeleteMapping("book/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id){
        if(!bookService.existsObjectById(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            jdbcTemplate.execute("delete from book_order where bookid=" +id);
            jdbcTemplate.execute("delete from rent where bookid ="+id);

            bookService.deleteObjectById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


}
