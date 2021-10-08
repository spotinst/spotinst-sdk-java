package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupDetachedVmsAzure {

    @JsonIgnore
    private Set<String>                       isSet;
    private List<DetachedVmsAzure>            detachedVms;
    private List<NewVmsAzure>                 newVmsAzure;

    private ElastigroupDetachedVmsAzure() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<DetachedVmsAzure> getDetachedVms() {
        return detachedVms;
    }

    public void setDetachedVms(List<DetachedVmsAzure> detachedVms) {
        isSet.add("detachedVms");
        this.detachedVms = detachedVms;
    }

    public List<NewVmsAzure> getNewVmsAzure() {
        return newVmsAzure;
    }

    public void setNewVmsAzure(List<NewVmsAzure> newVmsAzure) {
        isSet.add("newVmsAzure");
        this.newVmsAzure = newVmsAzure;
    }

    public static class Builder {
        private ElastigroupDetachedVmsAzure detachVms;

        private Builder() {
            this.detachVms = new ElastigroupDetachedVmsAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setDetachedVms(final List<DetachedVmsAzure> detachedVms) {
            detachVms.setDetachedVms(detachedVms);
            return this;
        }

        public Builder setNewVmsAzure(final List<NewVmsAzure> newVmsAzure) {
            detachVms.setNewVmsAzure(newVmsAzure);
            return this;
        }

        public ElastigroupDetachedVmsAzure build() {
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
