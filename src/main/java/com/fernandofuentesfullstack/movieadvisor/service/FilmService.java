package com.fernandofuentesfullstack.movieadvisor.service;

import com.fernandofuentesfullstack.movieadvisor.model.Film;
import com.fernandofuentesfullstack.movieadvisor.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    FilmQueryService filmQueryService;

    public Collection<String> findAllGenres() {
        List<String> result = null;

        result = filmRepository.findAll()
                .stream()
                .map(f -> f.getGenres())
                .flatMap(lista -> lista.stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        return result;
    }

    public Collection<Film> findByAnyGenre(String... genres) {

        return filmQueryService.anyGenre(genres).exec();

    }

    public Collection<Film> findByAllGenres(String... genres) {
        return filmQueryService.allGenres(genres).exec();
    }

    public Collection<Film> findByYear(String year) {
        return filmQueryService.year(year).exec();
    }

    public Collection<Film> findBetweenYears(String from, String to) {
        return filmQueryService.betweenYears(from, to).exec();
    }

    public Collection<Film> findByTitleContains(String title) {
        return filmQueryService.titleContains(title).exec();
    }

    public Collection<Film> findAll() {
        return filmRepository.findAll();
    }
}
