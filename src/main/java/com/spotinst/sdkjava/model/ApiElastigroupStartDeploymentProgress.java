package com.spotinst.sdkjava.model;

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
public class ApiElastigroupStartDeploymentProgress implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String> isSet;
    private String      unit;
    private Integer     value;

    public ApiElastigroupStartDeploymentProgress() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        isSet.add("unit");
        this.unit = unit;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        isSet.add("value");
        this.value = value;
    }

    public static class Builder {
        private ApiElastigroupStartDeploymentProgress elastigroupProgress;

        private Builder() {
            this.elastigroupProgress = new ApiElastigroupStartDeploymentProgress();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setUnit(final String unit) {
            elastigroupProgress.setUnit(unit);
            return this;
        }

        public Builder setValue(final Integer value) {
            elastigroupProgress.setValue(value);
            return this;
        }

        public ApiElastigroupStartDeploymentProgress build() {
            return elastigroupProgress;
        }

    }


    @JsonIgnore
    public boolean isUnitSet() {
        return isSet.contains("unit");
    }

    @JsonIgnore
    public boolean isValueSet() {
        return isSet.contains("value");
    }

}
