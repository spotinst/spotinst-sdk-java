package com.spotinst.sdkjava.model.api.ocean.aks;

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
public class ApiClusterVngLaunchSpecification implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                         isSet;
    private List<ApiClusterTagAks>              tags;
    private ApiClusterVngOsDisk                 osDisk;

    public ApiClusterVngLaunchSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiClusterTagAks> getTags() {
        return tags;
    }

    public void setTags(List<ApiClusterTagAks> tags) {
        isSet.add("tags");
        this.tags = tags;
    }

    public ApiClusterVngOsDisk getOsDisk() {
        return osDisk;
    }

    public void setOsDisk(ApiClusterVngOsDisk osDisk) {
        isSet.add("osDisk");
        this.osDisk = osDisk;
    }

    @JsonIgnore
    public boolean isTagsSet() {
        return isSet.contains("tags");
    }

    @JsonIgnore
    public boolean isOsDiskSet() {
        return isSet.contains("osDisk");
    }
}
