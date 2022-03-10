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
public class ApiImportEKSK8sVngSpec implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                      isSet;
    private String                           name;
    private List<ApiK8sVngLabel>			 labels;

    public ApiImportEKSK8sVngSpec() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public List<ApiK8sVngLabel> getLabels() {
        return labels;
    }

    public void setLabels (List<ApiK8sVngLabel> labels) {
        isSet.add("labels");
        this.labels = labels;
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isLabelsSet() {
        return isSet.contains("labels");
    }
}