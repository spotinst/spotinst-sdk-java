package com.spotinst.sdkjava.model.api.ocean.kubernetes;

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
public class ApiK8sVngTag implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String> isSet;
    private String      tagKey;
    private String      tagValue;

    public ApiK8sVngTag() {
        isSet = new HashSet<>();
    }

    public ApiK8sVngTag(String k8sVngTagKey, String k8sVngTagValue) {
        isSet = new HashSet<>();
        this.setTagKey(k8sVngTagKey);
        this.setTagValue(k8sVngTagValue);
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getTagKey() {
        return tagKey;
    }

    public void setTagKey(String k8sVngTagKey) {
        isSet.add("tagKey");
        this.tagKey = k8sVngTagKey;
    }

    public String getTagValue() {
        return tagValue;
    }

    public void setTagValue(String k8sVngTagValue) {
        isSet.add("tagValue");
        this.tagValue = k8sVngTagValue;
    }


    @JsonIgnore
    public boolean isTagKeySet() {
        return isSet.contains("tagKey");
    }

    @JsonIgnore
    public boolean isTagValueSet() {
        return isSet.contains("tagValue");
    }
}
