package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupScaleUpResponseGcp {

    @JsonIgnore
    private Set<String>                                     isSet;
    private List<ElastigroupScaleUpNewInstancesGcp>  newPreemptibles;
    private List<ElastigroupScaleUpNewInstancesGcp>     newInstances;

    public ElastigroupScaleUpResponseGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ElastigroupScaleUpNewInstancesGcp> getNewPreemptibles() {
        return newPreemptibles;
    }

    public void setNewPreemptibles(List<ElastigroupScaleUpNewInstancesGcp> newPreemptibles) {
        isSet.add("newPreemptibles");
        this.newPreemptibles = newPreemptibles;
    }

    public List<ElastigroupScaleUpNewInstancesGcp> getNewInstances() {
        return newInstances;
    }

    public void setNewInstances(List<ElastigroupScaleUpNewInstancesGcp> newInstances) {
        isSet.add("newInstances");
        this.newInstances = newInstances;
    }


    public static class Builder {
        private ElastigroupScaleUpResponseGcp elastigroupScaleUpResponseGcp;

        private Builder() {
            this.elastigroupScaleUpResponseGcp = new ElastigroupScaleUpResponseGcp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setNewPreemptibles(final List<ElastigroupScaleUpNewInstancesGcp> newPreemptibles) {
            elastigroupScaleUpResponseGcp.setNewPreemptibles(newPreemptibles);
            return this;
        }

        public Builder setNewInstances(final List<ElastigroupScaleUpNewInstancesGcp> newInstances) {
            elastigroupScaleUpResponseGcp.setNewInstances(newInstances);
            return this;
        }
        public ElastigroupScaleUpResponseGcp build() {
            return elastigroupScaleUpResponseGcp;
        }

    }

    @JsonIgnore
    public boolean isNewPreemptiblesSet() {
        return isSet.contains("newPreemptibles");
    }

    @JsonIgnore
    public boolean isNewInstancesSet() {
        return isSet.contains("newInstances");
    }

}
