package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


import java.util.HashSet;
import java.util.Set;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InstanceTypes {

    @JsonIgnore
    private Set<String>     isSet;
    private String          preferredType;
    private List<String>    types;

    private InstanceTypes() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getPreferredType() {
        return preferredType;
    }

    public void setPreferredType(String preferredType) {
        isSet.add("preferredType");
        this.preferredType = preferredType;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        isSet.add("types");
        this.types = types;
    }

    public static class Builder {
        private InstanceTypes instanceTypes;

        private Builder() {
            this.instanceTypes = new InstanceTypes();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setPreferredType(final String preferredType) {
            instanceTypes.setPreferredType(preferredType);
            return this;
        }

        public Builder setTypes(final List<String> types) {
            instanceTypes.setTypes(types);
            return this;
        }

        public InstanceTypes build() {
            return instanceTypes;
        }
    }

    @JsonIgnore
    public boolean isPreferredTypeSet() {
        return isSet.contains("preferredType");
    }

    @JsonIgnore
    public boolean isTypesSet() {
        return isSet.contains("types");
    }
}
