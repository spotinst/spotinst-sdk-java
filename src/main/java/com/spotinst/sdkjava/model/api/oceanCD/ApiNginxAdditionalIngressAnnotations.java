package com.spotinst.sdkjava.model.api.oceanCD;

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
public class ApiNginxAdditionalIngressAnnotations implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                             isSet;
    private String                                  property1;
    private String                                  property2;

    public ApiNginxAdditionalIngressAnnotations() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        isSet.add("property1");
        this.property1 = property1;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        isSet.add("property2");
        this.property2 = property2;
    }

    @JsonIgnore
    public boolean isProperty1Set() {
        return isSet.contains("property1");
    }

    @JsonIgnore
    public boolean isProperty2Set() {
        return isSet.contains("property2");
    }
}