package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ManagedActions {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private BeanstalkPlatformUpdate      platformUpdate;
    //endregion

    //region Constructors
    private ManagedActions() {
        isSet = new HashSet<>();
    }
    //region Getters & Setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public BeanstalkPlatformUpdate getPlatformUpdate() {
        return platformUpdate;
    }

    public void setPlatformUpdate(BeanstalkPlatformUpdate platformUpdate) {
        isSet.add("platformUpdate");
        this.platformUpdate = platformUpdate;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ManagedActions deploymentGroups;

        private Builder() {
            this.deploymentGroups = new ManagedActions();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setPlatformUpdate (final BeanstalkPlatformUpdate platformUpdate){
            deploymentGroups.setPlatformUpdate(platformUpdate);
            return this;
        }

        public ManagedActions build(){return deploymentGroups;}

    }
    //endregion

    //region isSet methods
    // Is platformUpdate Set boolean method
    @JsonIgnore
    public boolean isPlatformUpdateSet() {
        return isSet.contains("platformUpdate");
    }
    //endregion
}
