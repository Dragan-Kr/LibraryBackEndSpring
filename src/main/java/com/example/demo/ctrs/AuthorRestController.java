package com.example.demo.ctrs;


import com.example.demo.dto.AuthorDTO;
import com.example.demo.jpa.Author;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;
//import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AuthorRestController  {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @GetMapping("author")
    public Collection<Author> getAuthors(){
        return authorService.findAllObjects();
    }

    @GetMapping("author/{id}")
    public Author getAuthorById(@PathVariable("id") Integer id){
        return  authorService.getObjectById(id);
    }

    @GetMapping("author/name/{name}")
    private Collection<Author> getAuthorByName(@PathVariable("name") String name){
        return authorService.getObjectByName(name);
    }

    @GetMapping("author/surname/{surname}")
    public Collection<Author> getAuthorBySurname(@PathVariable("surname") String surname){
        return  authorService.getObjectBySurname(surname);
    }


  /*  @PostMapping("author")
    public ResponseEntity<Author> insertAuthor(@RequestBody Author author){
        if(!authorService.existsObjectById(author.getId())){
            authorService.saveObject(author);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

   */

//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostMapping("author")
    public ResponseEntity addAuthor(@RequestBody AuthorDTO authorDTO){
        Author author = new Author();
        author.setId(authorDTO.getId());
        author.setName(authorDTO.getName());
        author.setSurname(authorDTO.getSurname());
        author = authorService.save(author);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }




/*
    @PutMapping("author")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author){
        if(!authorService.existsObjectById(author.getId())){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            authorService.saveObject(author);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
*/

  /*sa tutoriala*/
//  @PreAuthorize("hasRole('USER')")
  @PutMapping("author/{id}")
  public  ResponseEntity<Author>  updateAuthor(@PathVariable("id") Integer id,@RequestBody AuthorDTO authorDTO){
      Author author = authorService.getObjectById(id);
      author.setName(authorDTO.getName());
      author.setSurname(authorDTO.getSurname());

      Author updatedAuthor = authorService.save(author);
      return ResponseEntity.ok(updatedAuthor);
  }


/**//*
    @Transactional
    @DeleteMapping("author/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable("id") Integer id){
        if(!authorService.existsObjectById(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            jdbcTemplate.execute("delete  from book where author =" +id);
            authorService.deleteObjectById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    */

    @Transactional
    @DeleteMapping("author/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteAuthor(@PathVariable("id") Integer id){
//        Author author = authorService.getObjectById(id);
//        //jdbcTemplate.execute("delete  from rent where bookid =" +id);
//
//        jdbcTemplate.execute("delete  from book where authorid =" +id);
//        authorService.deleteObjectById(id);
//
//        Map<String,Boolean> response = new HashMap<>();
//        response.put("deleted",Boolean.TRUE);
//        return ResponseEntity.ok(response);



        if(!authorService.existsObjectById(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            jdbcTemplate.execute("delete  from book where authorid =" +id);
            authorService.deleteObjectById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
