package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StepsPause {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     duration;

    private StepsPause() {
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

    public static class Builder {
        private StepsPause stepsPause;

        private Builder() {
            this.stepsPause = new StepsPause();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDuration(final String duration) {
            stepsPause.setDuration(duration);
            return this;
        }

        public StepsPause build() {
            return stepsPause;
        }
    }

    @JsonIgnore
    public boolean isDurationSet() {
        return isSet.contains("duration");
    }
}