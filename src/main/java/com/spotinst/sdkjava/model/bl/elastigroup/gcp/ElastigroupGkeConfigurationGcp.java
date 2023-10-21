package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupGkeConfigurationGcp {

    @JsonIgnore
    private Set<String>                                 isSet;
    private ElastigroupAutoscaleConfigurationGcp        autoScale;
    private Boolean                                     autoUpdate;
    private String                                      clusterIdentifier;
    private String                                      location;


    private ElastigroupGkeConfigurationGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ElastigroupAutoscaleConfigurationGcp getAutoScale() {
        return autoScale;
    }

    public void setAutoScale(ElastigroupAutoscaleConfigurationGcp autoScale) {
        isSet.add("autoScale");
        this.autoScale = autoScale;
    }

    public Boolean getAutoUpdate() {
        return autoUpdate;
    }

    public void setAutoUpdate(Boolean autoUpdate) {
        isSet.add("autoUpdate");
        this.autoUpdate = autoUpdate;
    }

    public String getClusterIdentifier() {
        return clusterIdentifier;
    }

    public void setClusterIdentifier(String clusterIdentifier) {
        isSet.add("clusterIdentifier");
        this.clusterIdentifier = clusterIdentifier;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        isSet.add("location");
        this.location = location;
    }

    public static class Builder {
        private ElastigroupGkeConfigurationGcp gkeConfigurationGcp;

        private Builder() {
            this.gkeConfigurationGcp = new ElastigroupGkeConfigurationGcp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setAutoScale(final ElastigroupAutoscaleConfigurationGcp autoScale) {
            gkeConfigurationGcp.setAutoScale(autoScale);
            return this;
        }

        public Builder setAutoUpdate(final Boolean autoUpdate) {
            gkeConfigurationGcp.setAutoUpdate(autoUpdate);
            return this;
        }

        public Builder setClusterIdentifier(final String clusterIdentifier) {
            gkeConfigurationGcp.setClusterIdentifier(clusterIdentifier);
            return this;
        }

        public Builder setLocation(final String location) {
            gkeConfigurationGcp.setLocation(location);
            return this;
        }

        public ElastigroupGkeConfigurationGcp build() {
            return gkeConfigurationGcp;
        }
    }

    @JsonIgnore
    public boolean isAutoScaleSet() {
        return isSet.contains("autoScale");
    }

    @JsonIgnore
    public boolean isAutoUpdateSet() {
        return isSet.contains("autoUpdate");
    }

    @JsonIgnore
    public boolean isClusterIdentifierSet() {
        return isSet.contains("clusterIdentifier");
    }

    @JsonIgnore
    public boolean isLocationSet() {
        return isSet.contains("location");
    }
}
