package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Janetlin Kiruba on 06/07/22.
 */
public class Images {

    // Partial Update support
    @JsonIgnore
    private Set<String> isSet;
    private String id;

    //region Constructor

    private Images() {
        isSet = new HashSet<>();
    }
    //endregion

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    //region Builder class
    public static class Builder {
        private Images images;

        private Builder() {
            this.images = new Images();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setId(final String id) {
            images.setId(id);
            return this;
        }

        public Images build() {
            // TODO : Validations
            return images;
        }
    }
    //endregion
    //region isSet methods
    // Is Id Set boolean method
    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    //endregion
}
