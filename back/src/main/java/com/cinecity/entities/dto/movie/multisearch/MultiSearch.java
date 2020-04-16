package com.cinecity.entities.dto.movie.multisearch;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class MultiSearch implements Serializable {

    private Long page;
    private MediaType[] results;
    @JsonProperty("total_results")
    private Long totalResults;
    @JsonProperty("total_pages")
    private Long totalPages;

    public MultiSearch() {
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public MediaType[] getResults() {
        return results;
    }

    public void setResults(MediaType[] results) {
        this.results = results;
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
}
