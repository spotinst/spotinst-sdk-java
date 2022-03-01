package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImportAsgToClusterInstanceTypes {
    @JsonIgnore
    private Set<String>                isSet;
    private List<String>       instanceTypes;

    private ImportAsgToClusterInstanceTypes() {
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
        private ImportAsgToClusterInstanceTypes importAsg;

        private Builder() {
            this.importAsg = new ImportAsgToClusterInstanceTypes();
        }

        public static Builder get() {
            ImportAsgToClusterInstanceTypes.Builder builder = new Builder();
            return builder;
        }

        public Builder setInstanceTypes(final List<String> instanceTypes) {
            importAsg.setInstanceTypes(instanceTypes);
            return this;
        }

        public ImportAsgToClusterInstanceTypes build() {
            return importAsg;
        }
    }

    @JsonIgnore
    public boolean isInstanceTypesSet() {
        return isSet.contains("instanceTypes");
    }
}