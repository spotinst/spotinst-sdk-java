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
public class ApiStepsPause implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     duration;

    public ApiStepsPause() {
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
        private ApiStepsPause stepsPause;

        private Builder() {
            this.stepsPause = new ApiStepsPause();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDuration(final String duration) {
            stepsPause.setDuration(duration);
            return this;
        }

        public ApiStepsPause build() {
            return stepsPause;
        }
    }

    @JsonIgnore
    public boolean isDurationSet() {
        return isSet.contains("duration");
    }
}