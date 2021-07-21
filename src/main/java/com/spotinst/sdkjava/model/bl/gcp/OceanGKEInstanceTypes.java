package com.spotinst.sdkjava.model.bl.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OceanGKEInstanceTypes {

    private Set<String>  isSet;
    private List<String> instanceTypes;

    private OceanGKEInstanceTypes()
        {
            isSet = new HashSet<>();
        }
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getInstanceTypes() {
        return instanceTypes;
    }

    public void setInstanceTypes(List<String> instanceTypes) {
        isSet.add("instanceTypes");
        this.instanceTypes = instanceTypes;
    }

    public static class Builder {
        private OceanGKEInstanceTypes gkeInstanceTypes;

        private Builder() {
            this.gkeInstanceTypes = new OceanGKEInstanceTypes();
        }

        public static OceanGKEInstanceTypes.Builder get() {
            OceanGKEInstanceTypes.Builder builder = new OceanGKEInstanceTypes.Builder();
            return builder;
        }

        public OceanGKEInstanceTypes.Builder setInstanceType(final List<String> InstanceType) {
            gkeInstanceTypes.setInstanceTypes(InstanceType);
            return this;
        }

        public OceanGKEInstanceTypes build() {
            return gkeInstanceTypes;
        }
    }


    @JsonIgnore
    public boolean isInstanceTypeSet() {
        return isSet.contains("instanceType");
    }

}
