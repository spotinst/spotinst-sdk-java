package com.spotinst.sdkjava.model.api.gcp;

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
public class ApiElastigroupGpuGcp implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>     isSet;
    private Integer         count;
    private String          type;

    public ApiElastigroupGpuGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        isSet.add("count");
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        isSet.add("type");
        this.type = type;
    }

    @JsonIgnore
    public boolean isCountSet() { return isSet.contains("count"); }

    @JsonIgnore
    public boolean isTypeSet() { return isSet.contains("type"); }
}
