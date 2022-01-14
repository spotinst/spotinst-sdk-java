package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupUpdateCapacityResponse {

    @JsonIgnore
    private Set<String>                         isSet;
    private ElastigroupCapacityConfiguration capacity;

    public ElastigroupUpdateCapacityResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ElastigroupCapacityConfiguration getCapacity() {
        return capacity;
    }

    public void setCapacity(ElastigroupCapacityConfiguration capacity) {
        isSet.add("capacity");
        this.capacity = this.capacity;
    }

    public static class Builder {
        private ElastigroupUpdateCapacityResponse items;

        private Builder() {
            this.items = new ElastigroupUpdateCapacityResponse();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setCapacity(ElastigroupCapacityConfiguration capacity) {
            items.setCapacity(capacity);
            return this;
        }

        public ElastigroupUpdateCapacityResponse build() {
            return items;
        }
    }

    @JsonIgnore
    public boolean isCapacitySet() {
        return isSet.contains("capacity");
    }


}

