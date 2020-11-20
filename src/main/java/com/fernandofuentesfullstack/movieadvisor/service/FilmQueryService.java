package com.fernandofuentesfullstack.movieadvisor.service;

import com.fernandofuentesfullstack.movieadvisor.model.Film;

import java.util.Collection;

public interface FilmQueryService {

    Collection<Film> exec();

    FilmQueryService anyGenre(String... genres);

    FilmQueryService allGenres(String... genres);

    FilmQueryService year(String year);

    FilmQueryService betweenYears(String from, String to);

    FilmQueryService titleContains(String title);

}
