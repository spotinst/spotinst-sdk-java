package com.spotinst.sdkjava.model.bl.ocean.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CreateOceanCDStrategy {
    @JsonIgnore
    private Set<String> isSet;
    private String          name;
    private StrategyCanary  canary;

    public CreateOceanCDStrategy() {
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


    public static class Builder {
        private CreateOceanCDStrategy strategy;

        private Builder() {
            this.strategy = new CreateOceanCDStrategy();
        }

        public static CreateOceanCDStrategy.Builder get() {
            return new Builder();
        }

        public Builder setName(String name) {
            strategy.setName(name);
            return this;
        }

        public Builder setCanary(StrategyCanary canary) {
            strategy.setCanary(canary);
            return this;
        }

        public CreateOceanCDStrategy build() {
            return strategy;
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

}
