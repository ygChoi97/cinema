package com.kgedu1d.cinema.movie.dto;

import com.kgedu1d.cinema.movie.entity.Movie;
import lombok.*;

@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class MovieMainDTO {
    private String movieCd;         // 영화코드
    private String movieNm;         // 영화명(국문)
    private String movieNmEn;       // 영화명(영문)
    private String prdtYear;        // 제작연도
    private String showTm;          // 상영시간
    private String openDt;          // 개봉연도
    private String nations;         // 제작국가
    private String genres;          // 장르
    private String directors;       // 감독
    private String actors;          // 배우
    private int screeningType;      // 상영타입(0:현재상영 1:상영예정(예매가능) 2:상영예정(예매불가능) 3:상영종료
    private String plot;            // 줄거리
    private String imgURL;          // 영화이미지
    private String showTypes;       // 상영형태
    private String watchGradeNm;    // 관람등급 명칭
    public MovieMainDTO(Movie movie) {
        movieCd = movie.getMovieCd();
        movieNm = movie.getMovieNm();
        movieNmEn = movie.getMovieNmEn();
        prdtYear = movie.getPrdtYear();
        showTm = movie.getShowTm();
        openDt = movie.getOpenDt();
        nations = movie.getNations();
        genres = movie.getGenres();
        directors = movie.getDirectors();
        actors = movie.getActors();
        screeningType = movie.getScreeningType();
        plot = movie.getPlot();
        imgURL = movie.getImgURL();
        showTypes = movie.getShowTypes();
        watchGradeNm = movie.getWatchGradeNm();
    }
}
