package com.spotinst.sdkjava.model.api.oceanCD;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiProviderDatadog implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    duration;
    private String                                    query;

    public ApiProviderDatadog() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        isSet.add("duration");
        this.duration = duration;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        isSet.add("query");
        this.query = query;
    }

    @JsonIgnore
    public boolean isQuerySet() {
        return isSet.contains("query");
    }

    @JsonIgnore
    public boolean isDurationSet() {
        return isSet.contains("duration");
    }
}