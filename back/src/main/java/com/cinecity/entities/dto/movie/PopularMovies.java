package com.cinecity.entities.dto.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.io.Serializable;

public class PopularMovies implements Serializable {

    private Long page;

    @JsonProperty("total_results")
    private Long totalResults;

    @JsonProperty("total_pages")
    private Long totalPages;
    private Movie[] results;

    public PopularMovies() {
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
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
