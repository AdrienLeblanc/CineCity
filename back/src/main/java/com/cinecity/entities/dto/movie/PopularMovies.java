package com.cinecity.entities.dto.movie;

import java.io.Serializable;

public class PopularMovies implements Serializable {

    private Long id;
    private Long totalResults;
    private Long totalPages;
    private Movie[] results;

    public PopularMovies() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public Movie[] getResults() {
        return results;
    }
}
