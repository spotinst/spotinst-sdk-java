package com.spotinst.sdkjava.model.bl.admin.messageCenter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Metadata {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String banner;
    //endregion

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        isSet.add("banner");
        this.banner = banner;
    }

    //region Constructor
    public Metadata() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private Metadata createMessage;

        private Builder() {
            this.createMessage = new Metadata();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setBanner(final String banner) {
            createMessage.setBanner("banner");
            return this;
        }

        public Metadata build() {
            return createMessage;
        }
    }
    //endregion

    //region isSet methods
    // Is banner Set boolean method
    @JsonIgnore
    public boolean isBannerSet() {
        return isSet.contains("banner");
    }
    //endregion
}
