package com.spotinst.sdkjava.model.bl.spotStorage;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VolumeAutoResize {
    //region Members
    @JsonIgnore
    private Set<String>                        isSet;
    private String                             mode;
    private String                             policyType;
    private List<VolumeAutoResizeResizePolicy> resizePolicies;
    //endregion

    //region Constructor
    private VolumeAutoResize() {
        isSet = new HashSet<>();
    }
    //endregion

    //region getters &setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        isSet.add("mode");
        this.mode = mode;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        isSet.add("policyType");
        this.policyType = policyType;
    }

    public List<VolumeAutoResizeResizePolicy> getResizePolicies() {
        return resizePolicies;
    }

    public void setResizePolicies(List<VolumeAutoResizeResizePolicy> resizePolicies) {
        isSet.add("resizePolicies");
        this.resizePolicies = resizePolicies;
    }
    //end region

    //region Builder class
    public static class Builder {
        //region Members
        private VolumeAutoResize volumeAutoResize;
        //endregion


        private Builder() {
            this.volumeAutoResize = new VolumeAutoResize();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        //region Build methods
        public Builder setMode(final String mode) {
            volumeAutoResize.setMode(mode);
            return this;
        }

        public Builder setPolicyType(final String policyType) {
            volumeAutoResize.setPolicyType(policyType);
            return this;
        }

        public Builder setResizePolicies(final List<VolumeAutoResizeResizePolicy> resizePolicies) {
            volumeAutoResize.setResizePolicies(resizePolicies);
            return this;
        }

        public VolumeAutoResize build() {
            // Validations
            return volumeAutoResize;
        }
        //endregion
    }
    //endregion

    //region isSet methods
    // Is mode Set boolean method
    @JsonIgnore
    public boolean isModeSet() {
        return isSet.contains("mode");
    }

    // Is policyType Set boolean method
    @JsonIgnore
    public boolean isPolicyTypeSet() {
        return isSet.contains("policyType");
    }

    // Is resizePolicies Set boolean method
    @JsonIgnore
    public boolean isResizePoliciesSet() {
        return isSet.contains("resizePolicies");
    }
    //endregion
}
