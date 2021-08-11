package com.spotinst.sdkjava.model.api.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ApiInstanceTypes {

    @JsonIgnore
    private Set<String>     isSet;
    private String          preferredType;
    private List<String>    types;

    private ApiInstanceTypes() {
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

    @JsonIgnore
    public boolean isPreferredTypeSet() {
        return isSet.contains("preferredType");
    }

    @JsonIgnore
    public boolean isTypesSet() {
        return isSet.contains("types");
    }

}
