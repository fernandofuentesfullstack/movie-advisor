package com.fernandofuentesfullstack.movieadvisor.repository;

import com.fernandofuentesfullstack.movieadvisor.model.Film;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FilmRepositoryImplMemory implements FilmRepository {

    List<Film> films = new ArrayList<>();

    void init() {
        // Films = ...
    }

    @Override
    public Film findById(long id) {
        return null;
    }

    @Override
    public Collection<Film> findAll() {
        return null;
    }

    @Override
    public void insert(Film film) {

    }

    @Override
    public void edit(Film film) {

    }

    @Override
    public void delete(long id) {

    }
}
