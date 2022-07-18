package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AksInitiateRoll {
    @JsonIgnore
    private Set<String>                     isSet;
    private Integer            batchSizePercentage;
    private String                         comment;
    private List<String>                   vmNames;
    private List<String>        virtualNodeGroupIds;

    private AksInitiateRoll() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getBatchSizePercentage() {
        return batchSizePercentage;
    }

    public void setBatchSizePercentage(Integer batchSizePercentage) {
        isSet.add("batchSizePercentage");
        this.batchSizePercentage = batchSizePercentage;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        isSet.add("comment");
        this.comment = comment;
    }

    public List<String> getVmNames() {
        return vmNames;
    }

    public void setVmNames(List<String> vmNames) {
        isSet.add("vmNames");
        this.vmNames = vmNames;
    }

    public List<String> getVirtualNodeGroupIds() {
        return virtualNodeGroupIds;
    }

    public void setVirtualNodeGroupIds(List<String> virtualNodeGroupIds) {
        isSet.add("virtualNodeGroupIds");
        this.virtualNodeGroupIds = virtualNodeGroupIds;
    }

    public static class Builder {
        private AksInitiateRoll initiateRoll;

        private Builder() {
            this.initiateRoll = new AksInitiateRoll();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setBatchSizePercentage(final Integer batchSizePercentage) {
            initiateRoll.setBatchSizePercentage(batchSizePercentage);
            return this;
        }

        public Builder setComment(final String comment) {
            initiateRoll.setComment(comment);
            return this;
        }

        public Builder setVmNames(final List<String> vmNames) {
            initiateRoll.setVmNames(vmNames);
            return this;
        }

        public Builder setVirtualNodeGroupIds(final List<String> launchSpecIds) {
            initiateRoll.setVirtualNodeGroupIds(launchSpecIds);
            return this;
        }

        public AksInitiateRoll build() {
            return initiateRoll;
        }
    }

    @JsonIgnore
    public boolean isBatchSizePercentageSet() {
        return isSet.contains("batchSizePercentage");
    }

    @JsonIgnore
    public boolean isCommentSet() {
        return isSet.contains("comment");
    }

    @JsonIgnore
    public boolean isVmNamesSet() {
        return isSet.contains("vmNames");
    }

    @JsonIgnore
    public boolean isVirtualNodeGroupIdsSet() {
        return isSet.contains("virtualNodeGroupIds");
    }

}