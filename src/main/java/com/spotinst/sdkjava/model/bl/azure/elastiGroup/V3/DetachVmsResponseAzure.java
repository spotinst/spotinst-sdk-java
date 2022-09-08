package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetachVmsResponseAzure {

    @JsonIgnore
    private Set<String>                                 isSet;
    private List<DetachVmsResponseDetachedVmsAzure>     detachedVms;
    private List<DetachVmsResponseNewVmsAzure>          newVmsAzure;

    private DetachVmsResponseAzure() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<DetachVmsResponseDetachedVmsAzure> getDetachedVms() {
        return detachedVms;
    }

    public void setDetachedVms(List<DetachVmsResponseDetachedVmsAzure> detachedVms) {
        isSet.add("detachedVms");
        this.detachedVms = detachedVms;
    }

    public List<DetachVmsResponseNewVmsAzure> getNewVmsAzure() {
        return newVmsAzure;
    }

    public void setNewVmsAzure(List<DetachVmsResponseNewVmsAzure> newVmsAzure) {
        isSet.add("newVmsAzure");
        this.newVmsAzure = newVmsAzure;
    }

    public static class Builder {
        private DetachVmsResponseAzure detachVms;

        private Builder() {
            this.detachVms = new DetachVmsResponseAzure();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDetachedVms(final List<DetachVmsResponseDetachedVmsAzure> detachedVms) {
            detachVms.setDetachedVms(detachedVms);
            return this;
        }

        public Builder setNewVmsAzure(final List<DetachVmsResponseNewVmsAzure> newVmsAzure) {
            detachVms.setNewVmsAzure(newVmsAzure);
            return this;
        }

        public DetachVmsResponseAzure build() {
            return detachVms;
        }

    }


    @JsonIgnore
    public boolean isDetachedVmsSet() {
        return isSet.contains("detachedVms");
    }

    @JsonIgnore
    public boolean isNewVmsAzureSet() {
        return isSet.contains("newVmsAzure");
    }

}
