package com.spotinst.sdkjava.model.bl.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.HashSet;
import java.util.Set;
import java.util.List;

/**
 * Created by chandra on 08/06/2021.
 */
public class InstanceTypes {

    //region Members
    @JsonIgnore
    private Set<String>     isSet;
    private String          preferredType;
    private List<String>    types;

    //endregion

    //region Constructor
    private InstanceTypes() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters
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

    @Override
    public int hashCode() {
        int result = preferredType != null ? preferredType.hashCode() : 0;
        result = 31 * result + (types != null ? types.hashCode() : 0);
        return result;
    }

    //region Builder class
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
    }
    //endregion

    //region isSet methods
    // Is preferredType Set boolean method
    @JsonIgnore
    public boolean isPreferredTypeSet() {
        return isSet.contains("preferredType");
    }

    // Is types Set boolean method
    @JsonIgnore
    public boolean isTypesSet() {
        return isSet.contains("types");
    }

    //endregion

}
