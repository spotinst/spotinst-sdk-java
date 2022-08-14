package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RolloutSpecStrategy {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    name;
    private List<BackgroundVerificationArgs>          args;

    private RolloutSpecStrategy() {
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

    public List<BackgroundVerificationArgs> getArgs() {
        return args;
    }

    public void setArgs(List<BackgroundVerificationArgs> args) {
        isSet.add("args");
        this.args = args;
    }

    public static class Builder {
        private RolloutSpecStrategy rolloutSpecStrategy;

        private Builder() {
            this.rolloutSpecStrategy = new RolloutSpecStrategy();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            rolloutSpecStrategy.setName(name);
            return this;
        }

        public Builder setArgs(final List<BackgroundVerificationArgs> args) {
            rolloutSpecStrategy.setArgs(args);
            return this;
        }

        public RolloutSpecStrategy build() {
            return rolloutSpecStrategy;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isArgsSet() {
        return isSet.contains("args");
    }
}