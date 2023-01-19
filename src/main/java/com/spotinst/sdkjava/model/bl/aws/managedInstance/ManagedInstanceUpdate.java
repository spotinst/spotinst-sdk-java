package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ManagedInstanceUpdate {

    @JsonIgnore
    private Set<String> isSet;
    private String      managedInstanceId;
    private String      state;

    private ManagedInstanceUpdate() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getManagedInstanceId() {
        return managedInstanceId;
    }

    public void setManagedInstanceId(String managedInstanceId) {
        this.managedInstanceId = managedInstanceId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public static class Builder {
        private ManagedInstanceUpdate managedInstanceUpdate;

        private Builder() {
            this.managedInstanceUpdate = new ManagedInstanceUpdate();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setManagedInstanceId(final String managedInstanceId) {
            managedInstanceUpdate.setManagedInstanceId(managedInstanceId);
            return this;
        }

        public Builder setState(final String state) {
            managedInstanceUpdate.setState(state);
            return this;
        }

        public ManagedInstanceUpdate build() {
            return managedInstanceUpdate;
        }
    }


    @JsonIgnore
    public boolean isManagedInstanceIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isStateSet() {
        return isSet.contains("state");
    }

}

