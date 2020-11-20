package com.fernandofuentesfullstack.movieadvisor.repository;

import com.fernandofuentesfullstack.movieadvisor.config.AppConfig;
import com.fernandofuentesfullstack.movieadvisor.model.Film;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class FilmRepositoryImplMemory implements FilmRepository {

    List<Film> films = new ArrayList<>();

    @Autowired
    private AppConfig appConfig;

    void init() {
        films = UtilFilmFileReader.readFile(appConfig.getFile(), appConfig.getSeparator(), appConfig.getListSeparator());
    }

    @Override
    public Film findById(long id) {
        Optional<Film> result = films
                .stream()
                .filter(film -> film.getId() == id)
                .findFirst();
        return result.orElse(null);
    }

    @Override
    public Collection<Film> findAll() {
        return films;
    }

    @Override
    public void insert(Film film) {
        films.add(film);
    }

    @Override
    public void edit(Film film) {
        int index = getIndexOf(film.getId());
        if (index != -1)
            films.set(index, film);
    }

    @Override
    public void delete(long id) {
        int index = getIndexOf(id);
        if (index != -1) {
            films.remove(index);
        }
    }

    private int getIndexOf(long id) {
        boolean found = false;
        int index = 0;

        while (!found && index < films.size()) {
            if ( films.get(index).getId() == id ) {
                found = true;
            } else {
                index++;
            }
        }
        if (found) return index;
        return -1;
    }
}
