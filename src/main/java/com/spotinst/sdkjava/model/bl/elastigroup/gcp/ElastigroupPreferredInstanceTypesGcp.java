package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupPreferredInstanceTypesGcp {

    @JsonIgnore
    private Set<String>                             isSet;
    private List<String>                            preemptible;
    private ElastigroupCustomInstanceTypesGcp       custom;

    private ElastigroupPreferredInstanceTypesGcp() {
        isSet = new HashSet<>();
    }

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

    public ElastigroupCustomInstanceTypesGcp getCustom() {
        return custom;
    }

    public void setCustom(ElastigroupCustomInstanceTypesGcp custom) {
        isSet.add("custom");
        this.custom = custom;
    }

    public static class Builder {
        private ElastigroupPreferredInstanceTypesGcp preferredInstanceTypesGcp;

        private Builder() {
            this.preferredInstanceTypesGcp = new ElastigroupPreferredInstanceTypesGcp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setPreemptible(final List<String> preemptible) {
            preferredInstanceTypesGcp.setPreemptible(preemptible);
            return this;
        }

        public Builder setCustom(final ElastigroupCustomInstanceTypesGcp custom) {
            preferredInstanceTypesGcp.setCustom(custom);
            return this;
        }

        public ElastigroupPreferredInstanceTypesGcp build() {
            return preferredInstanceTypesGcp;
        }
    }

    @JsonIgnore
    public boolean isPreemptibleSet() {
        return isSet.contains("preemptible");
    }

    @JsonIgnore
    public boolean isCustomSet() { return isSet.contains("custom"); }


}
