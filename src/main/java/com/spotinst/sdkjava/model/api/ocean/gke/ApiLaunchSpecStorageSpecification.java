package com.spotinst.sdkjava.model.api.ocean.gke;

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
public class ApiLaunchSpecStorageSpecification implements IPartialUpdateEntity {

    private Set<String> isSet;
    private Integer         localSsdCount;

    public ApiLaunchSpecStorageSpecification(){ isSet = new HashSet<>();
    }
    public Integer getLocalSsdCount() {
        return localSsdCount;
    }

    public void setLocalSsdCount(Integer localSsdCount) {
        isSet.add("localSsdCount");
        this.localSsdCount = localSsdCount;
    }

    @JsonIgnore
    public boolean isLocalSsdCountSet() {
        return isSet.contains("localSsdCount");
    }

    @Override
    public Set<String> getIsSet() {
        return isSet;
    }
}
