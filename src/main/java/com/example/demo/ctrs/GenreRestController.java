package com.example.demo.ctrs;

import com.example.demo.dto.AuthorDTO;
import com.example.demo.dto.GenreDTO;
import com.example.demo.jpa.Author;
import com.example.demo.jpa.Genre;
import com.example.demo.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class GenreRestController {

    @Autowired
    private GenreService genreService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("genre")
    public Collection<Genre> getGenres(){
        return genreService.findAllObjects();
    }

    @GetMapping("genre/{id}")
    public Genre getGenreById(@PathVariable("id") Integer id){
        return genreService.getObjectById(id);
    }

    @GetMapping("genre/name/{name}")
    public Collection<Genre> getGenreByName(@PathVariable("name") String name){
        return genreService.getObjectByName(name);
    }

    /*@PostMapping("genre")
    public ResponseEntity<Genre> insertGenre(@RequestBody Genre genre){
        if(!genreService.existsObjectById(genre.getId())){
            genreService.saveObject(genre);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }
    }

     */

//    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostMapping("genre")
    public ResponseEntity addGenre(@RequestBody GenreDTO genreDTO){
        Genre genre = new Genre();
        genre.setId(genreDTO.getId());
        genre.setName(genreDTO.getName());
         genreService.save(genre);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    /*sa tutoriala*/
    @PutMapping("genre/{id}")
    public  ResponseEntity<Genre>  updateAuthor(@PathVariable("id") Integer id, @RequestBody GenreDTO genreDTO){
        Genre genre = genreService.getObjectById(id);
        genre.setName(genreDTO.getName());
        Genre updatetGenre = genreService.save(genre);
        return ResponseEntity.ok(updatetGenre);
    }


/*
    @PutMapping("genre")
    public ResponseEntity<Genre> updateGenre(@RequestBody Genre genre){
        if(!genreService.existsObjectById(genre.getId())){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            genreService.saveObject(genre);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

 */






    @Transactional
    @DeleteMapping("genre/{id}")
    public ResponseEntity<Genre> deleteGenre(@PathVariable("id") Integer id){
        if(!genreService.existsObjectById(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            jdbcTemplate.execute("delete  from book where book_type_id =" +id);
            genreService.deleteObjectById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
