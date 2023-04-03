package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupInstanceTypesGcp {
    //region Members
    @JsonIgnore
    private Set<String>                         isSet;
    private List<String>                        preemptible;
    private String                              ondemand;
    private ElastigroupCustomInstanceTypesGcp   custom;
    private ElastigroupPreferredInstanceTypesGcp preferred;

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

    public ElastigroupCustomInstanceTypesGcp getCustom() {
        return custom;
    }

    public void setCustom(ElastigroupCustomInstanceTypesGcp custom) {
        isSet.add("custom");
        this.custom = custom;
    }

    public ElastigroupPreferredInstanceTypesGcp getPreferred() {
        return preferred;
    }

    public void setPreferred(ElastigroupPreferredInstanceTypesGcp preferred) {
        isSet.add("preferred");
        this.preferred = preferred;
    }


    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupInstanceTypesGcp instanceTypes;

        private Builder() {
            this.instanceTypes = new ElastigroupInstanceTypesGcp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setPreemptible(final List<String> preemptible) {
            instanceTypes.setPreemptible(preemptible);
            return this;
        }

        public Builder setOndemand(final String ondemand) {
            instanceTypes.setOndemand(ondemand);
            return this;
        }

        public Builder setCustom(final ElastigroupCustomInstanceTypesGcp custom) {
            instanceTypes.setCustom(custom);
            return this;
        }

        public Builder setPreferred(final ElastigroupPreferredInstanceTypesGcp preferred) {
            instanceTypes.setPreferred(preferred);
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

    @JsonIgnore
    public boolean isCustomSet() { return isSet.contains("custom"); }

    @JsonIgnore
    public boolean isPreferredSet() { return isSet.contains("preferred"); }
    //endregion
}
