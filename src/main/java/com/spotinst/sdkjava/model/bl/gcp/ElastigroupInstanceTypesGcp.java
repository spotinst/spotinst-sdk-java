package com.spotinst.sdkjava.model.bl.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElastigroupInstanceTypesGcp {
    //region Members
    @JsonIgnore
    private Set<String>  isSet;
    private List<String> preemptible;
    private String       ondemand;
    //endregion

    //region Constructor
    private ElastigroupInstanceTypesGcp() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getter and Setter methods
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getPreemptible() {
        return preemptible;
    }

    public void setPreemptible(List<String> preemptible) {
        isSet.add("preemptible");
        this.preemptible = preemptible;
    }

    public String getOndemand() {
        return ondemand;
    }

    public void setOndemand(String ondemand) {
        isSet.add("ondemand");
        this.ondemand = ondemand;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupInstanceTypesGcp instanceTypes;

        private Builder() {
            this.instanceTypes = new ElastigroupInstanceTypesGcp();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setPreemptible(final List<String> preemptible) {
            instanceTypes.setPreemptible(preemptible);
            return this;
        }

        public Builder setOndemand(final String ondemand) {
            instanceTypes.setOndemand(ondemand);
            return this;
        }

        public ElastigroupInstanceTypesGcp build() {
            return instanceTypes;
        }
    }
    //endregion

    //region isSet methods
    // Is preemptible Set boolean method
    @JsonIgnore
    public boolean isPreemptibleSet() {
        return isSet.contains("preemptible");
    }

    // Is ondemand Set boolean method
    @JsonIgnore
    public boolean isOndemandSet() { return isSet.contains("ondemand"); }
    //endregion
}
