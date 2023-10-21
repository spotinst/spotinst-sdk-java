package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerAwsFileParams {
    @JsonIgnore
    private Set<String> isSet;
    private String      bucket;
    private String      key;

    private MrScalerAwsFileParams() {  isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        isSet.add("bucket");
        this.bucket = bucket;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        isSet.add("key");
        this.key = key;
    }


    public static class Builder {
        private MrScalerAwsFileParams fileParams;

        private Builder(){ this.fileParams = new MrScalerAwsFileParams(); }

        public static Builder get(){
            return new Builder();
        }

        public Builder setBucket(final String bucket){
            fileParams.setBucket(bucket);
            return this;
        }
        public Builder setKey(final String key){
            fileParams.setKey(key);
            return this;
        }

        public MrScalerAwsFileParams build(){
            return fileParams;
        }
    }

    @JsonIgnore
    public Boolean isBucketSet(){ return isSet.contains("bucket"); }

    @JsonIgnore
    public Boolean isKeySet(){ return isSet.contains("key"); }
}
