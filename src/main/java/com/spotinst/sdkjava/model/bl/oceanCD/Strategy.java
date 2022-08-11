package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Strategy {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    name;
    private StrategyCanary                            canary;
    private Date                                      createdAt;
    private Date                                      updatedAt;

    private Strategy() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public StrategyCanary getCanary() {
        return canary;
    }

    public void setCanary(StrategyCanary canary) {
        isSet.add("canary");
        this.canary = canary;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        isSet.add("updatedAt");
        this.updatedAt = updatedAt;
    }

    public static class Builder {
        private Strategy createStrategy;

        private Builder() {
            this.createStrategy = new Strategy();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            createStrategy.setName(name);
            return this;
        }

        public Builder setCanary(final StrategyCanary canary) {
            createStrategy.setCanary(canary);
            return this;
        }

        public Builder setCreatedAt(final Date createdAt) {
            createStrategy.setCreatedAt(createdAt);
            return this;
        }

        public Builder setUpdatedAt(final Date updatedAt) {
            createStrategy.setUpdatedAt(updatedAt);
            return this;
        }

        public Strategy build() {
            return createStrategy;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isCanarySet() {
        return isSet.contains("canary");
    }

    // Is createdAt Set boolean method
    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }

    // Is updatedAt Set boolean method
    @JsonIgnore
    public boolean isUpdatedAtSet() {
        return isSet.contains("updatedAt");
    }
}