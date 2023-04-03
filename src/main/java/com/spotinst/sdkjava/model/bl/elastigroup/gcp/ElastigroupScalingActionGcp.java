package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupScalingActionGcp {

    @JsonIgnore
    private Set<String>     isSet;
    private String          type;
    private Integer         adjustment;

    private ElastigroupScalingActionGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        isSet.add("type");
        this.type = type;
    }

    public Integer getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(Integer adjustment) {
        isSet.add("adjustment");
        this.adjustment = adjustment;
    }

    public static class Builder {
        private ElastigroupScalingActionGcp scalingAction;

        private Builder() {
            this.scalingAction = new ElastigroupScalingActionGcp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setType(final String type) {
            scalingAction.setType(type);
            return this;
        }

        public Builder setAdjustment(final Integer adjustment) {
            scalingAction.setAdjustment(adjustment);
            return this;
        }

        public ElastigroupScalingActionGcp build() {
            return scalingAction;
        }
    }

    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }

    @JsonIgnore
    public boolean isAdjustmentSet() {
        return isSet.contains("adjustment");
    }
}
