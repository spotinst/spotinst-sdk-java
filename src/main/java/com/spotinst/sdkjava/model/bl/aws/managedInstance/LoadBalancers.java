package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoadBalancers {

    @JsonIgnore
    private Set<String> isSet;
    private String      arn;
    private Boolean     autoWeight;
    private Boolean     azAwareness;
    private String      balancerId;
    private String      name;
    private String      targetSetId;
    private String      type;

    private LoadBalancers() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getArn() {
        return arn;
    }

    public void setArn(String arn) {
        isSet.add("arn");
        this.arn = arn;
    }

    public Boolean getAutoWeight() {
        return autoWeight;
    }

    public void setAutoWeight(Boolean autoWeight) {
        isSet.add("autoWeight");
        this.autoWeight = autoWeight;
    }

    public Boolean getAzAwareness() {
        return azAwareness;
    }

    public void setAzAwareness(Boolean azAwareness) {
        isSet.add("azAwareness");
        this.azAwareness = azAwareness;
    }

    public String getBalancerId() {
        return balancerId;
    }

    public void setBalancerId(String balancerId) {
        isSet.add("balancerId");
        this.balancerId = balancerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getTargetSetId() {
        return targetSetId;
    }

    public void setTargetSetId(String targetSetId) {
        isSet.add("targetSetId");
        this.targetSetId = targetSetId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        isSet.add("type");
        this.type = type;
    }

    public static class Builder {
        private LoadBalancers loadBalancers;

        private Builder() {
            this.loadBalancers = new LoadBalancers();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setArn(final String arn) {
            loadBalancers.setArn(arn);
            return this;
        }

        public Builder setAutoWeight(final Boolean autoWeight) {
            loadBalancers.setAutoWeight(autoWeight);
            return this;
        }

        public Builder setAzAwareness(final Boolean azAwareness) {
            loadBalancers.setAzAwareness(azAwareness);
            return this;
        }

        public Builder setBalancerId(final String balancerId) {
            loadBalancers.setBalancerId(balancerId);
            return this;
        }

        public Builder setName(final String name) {
            loadBalancers.setName(name);
            return this;
        }

        public Builder setTargetSetId(final String targetSetId) {
            loadBalancers.setTargetSetId(targetSetId);
            return this;
        }

        public Builder setType(final String type) {
            loadBalancers.setType(type);
            return this;
        }

        public LoadBalancers build() {
            return loadBalancers;
        }
    }

    @JsonIgnore
    public boolean isArnSet() {
        return isSet.contains("arn");
    }

    @JsonIgnore
    public boolean isAutoWeightSet() {
        return isSet.contains("autoWeight");
    }

    @JsonIgnore
    public boolean isAzAwarenessSet() {
        return isSet.contains("azAwareness");
    }

    @JsonIgnore
    public boolean isBalancerIdSet() {
        return isSet.contains("balancerId");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isTargetSetIdSet() {
        return isSet.contains("targetSetId");
    }

    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }
}
