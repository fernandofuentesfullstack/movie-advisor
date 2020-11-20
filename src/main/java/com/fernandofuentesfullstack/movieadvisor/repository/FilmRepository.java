package com.fernandofuentesfullstack.movieadvisor.repository;

import com.fernandofuentesfullstack.movieadvisor.model.Film;

import java.util.Collection;

public interface FilmRepository {

    Film findById(long id);
    Collection<Film> findAll();
    void insert(Film film);
    void edit(Film film);
    void delete(long id);

}
