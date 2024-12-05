package com.spotinst.sdkjava.model.api.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiConstraints implements IPartialUpdateEntity {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String>                 isSet;
    private String                    key;
    private String                    value;
    //endregion

    //region Constructor

    public ApiConstraints() {
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        isSet.add("key");
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        isSet.add("value");
        this.value = value;
    }

    //endregion
    //region isSet methods
    // Is key Set boolean method
    @JsonIgnore
    public boolean isKeySet() {
        return isSet.contains("key");
    }

    // Is value Set boolean method
    @JsonIgnore
    public boolean isValueSet() {
        return isSet.contains("value");
    }
    //endregion
}
