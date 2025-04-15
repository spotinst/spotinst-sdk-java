package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerOperatorAws {
    @JsonIgnore
    private Set<String>    isSet;
    private String         name;
    private MrScalerAws mrScaler;

    public MrScalerOperatorAws() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public MrScalerAws getMrScaler() {
        return mrScaler;
    }

    public void setMrScaler(MrScalerAws mrScaler) {
        isSet.add("mrScaler");
        this.mrScaler = mrScaler;
    }

    public static class Builder {
        private MrScalerOperatorAws mrScalerOperatorAws;

        private Builder() {
            this.mrScalerOperatorAws = new MrScalerOperatorAws();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setName(final String name) {
            mrScalerOperatorAws.setName(name);
            return this;
        }

        public Builder setMrScaler(final MrScalerAws mrScaler) {
            mrScalerOperatorAws.setMrScaler(mrScaler);
            return this;
        }

        public MrScalerOperatorAws build() {
            return mrScalerOperatorAws;
        }
    }

    @JsonIgnore
    public Boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public Boolean isMrScalerSet() {
        return isSet.contains("mrScaler");
    }
}
