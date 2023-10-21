package com.spotinst.sdkjava.model.api.mrScaler.aws;

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
public class ApiMrScalerAwsFileParams implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      bucket;
    private String      key;

    // endregion

    //region Constructor
    public ApiMrScalerAwsFileParams() {  isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getBucket(){ return bucket; }

    public void setBucket(String bucket) {
        isSet.add("bucket");
        this.bucket = bucket;
    }

    public String getKey(){ return key; }

    public void setKey(String key) {
        isSet.add("key");
        this.key = key;
    }

    @JsonIgnore
    public Boolean isBucketSet(){ return isSet.contains("bucket"); }

    @JsonIgnore
    public Boolean isKeySet(){ return isSet.contains("key"); }
}
