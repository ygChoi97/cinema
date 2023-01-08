package com.kgedu1d.cinema.movie.service;

import com.kgedu1d.cinema.movie.dto.FindAllDTO;
import com.kgedu1d.cinema.movie.dto.MovieMainDTO;
import com.kgedu1d.cinema.movie.entity.Movie;
import com.kgedu1d.cinema.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieRegService {
    private final MovieRepository repository;

    public FindAllDTO findAllServ() {
        return new FindAllDTO(repository.findAll());
    }

    public FindAllDTO createServe(final Movie newMovie) {

        if(newMovie == null) {
            log.warn("newMovie cannot be null!");
            throw new RuntimeException("newMovie cannot be null!");
        }
        log.info("영화 ({}) 상세정보가 전달되었습니다.", newMovie.getMovieNm());
        boolean flag = repository.save(newMovie);
        if(flag) log.info("영화 ({}) 상세정보가 생성되었습니다.", newMovie.getMovieNm());

        return flag ? findAllServ() : null;
    }

    public FindAllDTO deleteServ(String movieCd) {
        boolean flag = repository.remove(movieCd);
        if(!flag) {
            log.warn("delete fail!! not found movieCd [{}]", movieCd);
            throw new RuntimeException("delete failed");
        }
        return findAllServ();
    }

    public MovieMainDTO findOneServ(String movieCd) {
        Movie movie = repository.findOne(movieCd);
        log.info("findOneServ returns data - {}", movie);

        return movie != null ? new MovieMainDTO(movie) : null;
    }

    public FindAllDTO updateServ(Movie movie) {
        boolean flag = repository.modify(movie);
        if(!flag) {
            log.warn("update fail!! not found");
        }
        return flag ? findAllServ() : new FindAllDTO();
    }




}
