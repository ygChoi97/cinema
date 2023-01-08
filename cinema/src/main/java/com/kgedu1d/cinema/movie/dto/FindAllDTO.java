package com.kgedu1d.cinema.movie.dto;

import com.kgedu1d.cinema.movie.dto.MovieMainDTO;
import com.kgedu1d.cinema.movie.entity.Movie;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class FindAllDTO {

    private int count;
    private List<MovieMainDTO> movies;

    public FindAllDTO(List<Movie> movieList) {
        this.count = movieList.size();
        this.convertDtoList(movieList);
    }

    // List<Movie>를 받으면 List<MovieMainDTO>로 변환하는 메서드
    public void convertDtoList(List<Movie> movieList) {
        List<MovieMainDTO> dtos = new ArrayList<>();

        for (Movie movie : movieList) {
            dtos.add(new MovieMainDTO(movie));
        }
        this.movies = dtos;
    }
}
