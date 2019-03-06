package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiMrScalerAwsFile {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private ApiMrScalerAwsFileParams file;
    // endregion

    //region Constructor
    public ApiMrScalerAwsFile() {  isSet = new HashSet<>(); }
    // endregion

    // region methods
    // region file
    public ApiMrScalerAwsFileParams getFile(){ return file; }

    public void setFile(ApiMrScalerAwsFileParams file) {
        isSet.add("file");
        this.file = file;
    }

    public Boolean isFileSet(){ return isSet.contains("file"); }
    // endregion
    // endregion

    public static class Builder {
        private ApiMrScalerAwsFile file;

        private Builder(){ this.file = new ApiMrScalerAwsFile(); }

        public static Builder get(){
            return new Builder();
        }

        // region builder methods
        public Builder setFile(ApiMrScalerAwsFileParams fileParams){
            file.setFile(fileParams);
            return this;
        }

        public ApiMrScalerAwsFile build(){
            return file;
        }
        // endregion
    }
}
