package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupDeploymentStatusInstances {

    @JsonIgnore
    private Set<String>                                     isSet;
    private List<ElastigroupDeploymentStatusInstancesBlue>  blue;
    private List<ElastigroupDeploymentStatusInstancesGreen> green;

    public ElastigroupDeploymentStatusInstances() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ElastigroupDeploymentStatusInstancesBlue> getBlue() {
        return blue;
    }

    public void setBlue(List<ElastigroupDeploymentStatusInstancesBlue> blue) {
        isSet.add("blue");
        this.blue = blue;
    }

    public List<ElastigroupDeploymentStatusInstancesGreen> getGreen() {
        return green;
    }

    public void setGreen(List<ElastigroupDeploymentStatusInstancesGreen> green) {
        isSet.add("green");
        this.green = green;
    }


    public static class Builder {
        private ElastigroupDeploymentStatusInstances elastigroupGetDeploymentStatusInstances;

        private Builder() {
            this.elastigroupGetDeploymentStatusInstances = new ElastigroupDeploymentStatusInstances();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setBlue(final List<ElastigroupDeploymentStatusInstancesBlue> blue) {
            elastigroupGetDeploymentStatusInstances.setBlue(blue);
            return this;
        }

        public Builder setGreen(final List<ElastigroupDeploymentStatusInstancesGreen> green) {
            elastigroupGetDeploymentStatusInstances.setGreen(green);
            return this;
        }

        public ElastigroupDeploymentStatusInstances build() {
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
