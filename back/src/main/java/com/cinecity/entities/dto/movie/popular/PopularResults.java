package com.cinecity.entities.dto.movie.popular;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class PopularResults implements Serializable {

    private Long page;

    @JsonProperty("total_results")
    private Long totalResults;

    @JsonProperty("total_pages")
    private Long totalPages;
    private PopularMovie[] results;

    public PopularResults() {
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

    public PopularMovie[] getResults() {
        return results;
    }
}
