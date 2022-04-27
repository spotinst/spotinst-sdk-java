package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterGkeConfiguration {
    @JsonIgnore
    private Set<String> isSet;
    private String      clusterName;
    private String      masterLocation;

    public ClusterGkeConfiguration() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        isSet.add("clusterName");
        this.clusterName = clusterName;
    }

    public String getMasterLocation() {
        return masterLocation;
    }

    public void setMasterLocation(String masterLocation) {
        isSet.add("masterLocation");
        this.masterLocation = masterLocation;
    }

    public static class Builder {
        private ClusterGkeConfiguration gke;

        private Builder() {
            this.gke = new ClusterGkeConfiguration();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setClusterName(final String clusterName) {
            gke.setClusterName(clusterName);
            return this;
        }

        public Builder setMasterLocation(final String masterLocation) {
            gke.setMasterLocation(masterLocation);
            return this;
        }

        public ClusterGkeConfiguration build() {
            return gke;
        }
    }

    @JsonIgnore
    public boolean isClusterNameSet() {
        return isSet.contains("clusterName");
    }

    @JsonIgnore
    public boolean isMasterLocationSet() {
        return isSet.contains("masterLocation");
    }
}
