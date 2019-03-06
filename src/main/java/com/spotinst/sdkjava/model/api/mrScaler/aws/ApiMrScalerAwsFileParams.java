package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiMrScalerAwsFileParams {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String bucket;
    private String key;

    // endregion

    //region Constructor
    public ApiMrScalerAwsFileParams() {  isSet = new HashSet<>(); }
    // endregion

    // region methods
    // region bucket
    public String getBucket(){ return bucket; }

    public void setBucket(String bucket) {
        isSet.add("bucket");
        this.bucket = bucket;
    }

    public Boolean isBucketSet(){ return isSet.contains("bucket"); }
    // endregion

    // region key
    public String getKey(){ return key; }

    public void setKey(String key) {
        isSet.add("key");
        this.key = key;
    }

    public Boolean isKeySet(){ return isSet.contains("key"); }
    // endregion
    // endregion

    public static class Builder {
        private ApiMrScalerAwsFileParams fileParams;

        private Builder(){ this.fileParams = new ApiMrScalerAwsFileParams(); }

        public static Builder get(){
            return new Builder();
        }

        // region builder methods
        public Builder setBucket(final String bucket){
            fileParams.setBucket(bucket);
            return this;
        }
        public Builder setKey(final String key){
            fileParams.setKey(key);
            return this;
        }

        public ApiMrScalerAwsFileParams build(){
            return fileParams;
        }
        // endregion
    }
}
