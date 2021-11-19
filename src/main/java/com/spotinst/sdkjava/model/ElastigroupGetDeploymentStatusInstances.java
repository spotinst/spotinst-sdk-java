package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupGetDeploymentStatusInstances {

    @JsonIgnore
    private Set<String> isSet;
    private List<ElastigroupGetDeploymentStatusInstancesBlue>   blue;
    private List<ElastigroupGetDeploymentStatusInstancesGreen>  green;

    public ElastigroupGetDeploymentStatusInstances() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ElastigroupGetDeploymentStatusInstancesBlue> getBlue() {
        return blue;
    }

    public void setBlue(List<ElastigroupGetDeploymentStatusInstancesBlue> blue) {
        isSet.add("blue");
        this.blue = blue;
    }

    public List<ElastigroupGetDeploymentStatusInstancesGreen> getGreen() {
        return green;
    }

    public void setGreen(List<ElastigroupGetDeploymentStatusInstancesGreen> green) {
        isSet.add("green");
        this.green = green;
    }


    public static class Builder {
        private ElastigroupGetDeploymentStatusInstances elastigroupGetDeploymentStatusInstances;

        private Builder() {
            this.elastigroupGetDeploymentStatusInstances = new ElastigroupGetDeploymentStatusInstances();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setBlue(final List<ElastigroupGetDeploymentStatusInstancesBlue> blue) {
            elastigroupGetDeploymentStatusInstances.setBlue(blue);
            return this;
        }

        public Builder setGreen(final List<ElastigroupGetDeploymentStatusInstancesGreen> green) {
            elastigroupGetDeploymentStatusInstances.setGreen(green);
            return this;
        }

        public ElastigroupGetDeploymentStatusInstances build() {
            return elastigroupGetDeploymentStatusInstances;
        }

    }

    @JsonIgnore
    public boolean isBlueSet() {
        return isSet.contains("blue");
    }

    @JsonIgnore
    public boolean isGreenSet() {
        return isSet.contains("green");
    }

}
