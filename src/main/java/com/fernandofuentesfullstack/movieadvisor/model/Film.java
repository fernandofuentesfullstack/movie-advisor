package com.fernandofuentesfullstack.movieadvisor.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data @AllArgsConstructor
public class Film {

    private long id;
    private String title;
    private String year;
    private List<String> genres;

}
