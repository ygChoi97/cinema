package com.kgedu1d.cinema.movie.api;

import com.kgedu1d.cinema.movie.dto.FindAllDTO;
import com.kgedu1d.cinema.movie.dto.MovieMainDTO;
import com.kgedu1d.cinema.movie.entity.Movie;
import com.kgedu1d.cinema.movie.service.MovieRegService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@Slf4j
@RequestMapping("/api/movie")
@RequiredArgsConstructor
@CrossOrigin
public class MovieRegApiController {

    private final MovieRegService service;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Movie newMovie) {

        log.info("/api/movie POST request! - {}", newMovie);

        try {

            if (newMovie == null) {
                return ResponseEntity.notFound().build();
            }

            FindAllDTO dtos = service.createServe(newMovie);
            if (dtos == null) {
                return ResponseEntity.notFound().build();
            }
            log.info("dtos: {}", dtos);
            return ResponseEntity.ok().body(dtos);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @DeleteMapping("/{movieCd}")
    public ResponseEntity<?> delete(@PathVariable String movieCd) {

        log.info("/api/movie/{} DELETE request!", movieCd);

        try {
            FindAllDTO dtos = service.deleteServ(movieCd);
            return ResponseEntity.ok().body(dtos);
        }catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{movieCd}")
    public  ResponseEntity<?> findOne(@PathVariable String movieCd) {

        log.info("api/movie/{} GET request!", movieCd);
        if(movieCd == null) return ResponseEntity.badRequest().build();

        MovieMainDTO dto = service.findOneServ(movieCd);

        if(dto == null) ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity<?> movies() {
        log.info("/api/movie GET request!");
        return ResponseEntity.ok().body(service.findAllServ());
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Movie movie) {
        log.info("api/movie PUT request!");

        try {
            FindAllDTO dtos = service.updateServ(movie);
            return ResponseEntity.ok().body(dtos);
        }catch(Exception e) {
            return ResponseEntity.notFound().build();
        }

    }







}