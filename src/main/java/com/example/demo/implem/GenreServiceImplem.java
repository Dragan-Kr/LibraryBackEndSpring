package com.example.demo.implem;

import com.example.demo.jpa.Genre;
import com.example.demo.repository.GenreRepository;
import com.example.demo.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

@Service
public class GenreServiceImplem implements GenreService {
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Collection<Genre> findAllObjects() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getObjectById(Integer id) {
        return genreRepository.getOne(id);
    }

    @Override
    public boolean existsObjectById(Integer id) {
        return genreRepository.existsById(id);
    }

    @Override
    public void saveObject(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public void deleteObjectById(Integer id) {
        genreRepository.deleteById(id);
    }

    @Override
    public Collection<Genre> getObjectByName(String name) {
        return genreRepository.getObjectByNameContainingIgnoreCase(name);
    }

    @Override
    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

}
