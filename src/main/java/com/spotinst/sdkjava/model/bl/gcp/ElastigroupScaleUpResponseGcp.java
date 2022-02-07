package com.spotinst.sdkjava.model.bl.gcp;

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
    private List<ElastigroupScaleUpNewPreemptiblesListGcp>  newPreemptiblesList;
    private List<ElastigroupScaleUpNewInstancesListGcp>     newInstancesList;

    public ElastigroupScaleUpResponseGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ElastigroupScaleUpNewPreemptiblesListGcp> getNewPreemptiblesList() {
        return newPreemptiblesList;
    }

    public void setNewPreemptibles(List<ElastigroupScaleUpNewPreemptiblesListGcp> newPreemptiblesList) {
        isSet.add("newPreemptiblesList");
        this.newPreemptiblesList = newPreemptiblesList;
    }

    public List<ElastigroupScaleUpNewInstancesListGcp> getNewInstancesList() {
        return newInstancesList;
    }

    public void setNewInstances(List<ElastigroupScaleUpNewInstancesListGcp> newInstancesList) {
        isSet.add("newInstancesList");
        this.newInstancesList = newInstancesList;
    }


    public static class Builder {
        private ElastigroupScaleUpResponseGcp elastigroupScaleUpResponseGcp;

        private Builder() {
            this.elastigroupScaleUpResponseGcp = new ElastigroupScaleUpResponseGcp();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setNewPreemptibles(final List<ElastigroupScaleUpNewPreemptiblesListGcp> newPreemptiblesList) {
            elastigroupScaleUpResponseGcp.setNewPreemptibles(newPreemptiblesList);
            return this;
        }

        public Builder setNewInstances(final List<ElastigroupScaleUpNewInstancesListGcp> newInstancesList) {
            elastigroupScaleUpResponseGcp.setNewInstances(newInstancesList);
            return this;
        }
        public ElastigroupScaleUpResponseGcp build() {
            return elastigroupScaleUpResponseGcp;
        }

    }

    @JsonIgnore
    public boolean isNewPreemptiblesSet() {
        return isSet.contains("newPreemptiblesList");
    }

    @JsonIgnore
    public boolean isNewInstancesSet() {
        return isSet.contains("newInstancesList");
    }

}