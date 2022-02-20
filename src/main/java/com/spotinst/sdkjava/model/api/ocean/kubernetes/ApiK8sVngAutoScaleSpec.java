package com.spotinst.sdkjava.model.api.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiK8sVngAutoScaleSpec implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                         isSet;
    private List<ApiK8sVngHeadroomSpec>         headrooms;
    private Integer                             autoHeadroomPercentage;

    public ApiK8sVngAutoScaleSpec() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiK8sVngHeadroomSpec> getHeadrooms() {
        return headrooms;
    }

    public void setHeadrooms(List<ApiK8sVngHeadroomSpec> headrooms) {
        isSet.add("headrooms");
        this.headrooms = headrooms;
    }

    public Integer getAutoHeadroomPercentage() {
        return autoHeadroomPercentage;
    }

    public void setAutoHeadroomPercentage(Integer autoHeadroomPercentage) {
        isSet.add("autoHeadroomPercentage");
        this.autoHeadroomPercentage = autoHeadroomPercentage;
    }

    @JsonIgnore
    public boolean isHeadroomSet() {
        return isSet.contains("headrooms");
    }

    @JsonIgnore
    public boolean isAutoHeadroomPercentageSet() {
        return isSet.contains("autoHeadroomPercentage");
    }
}
