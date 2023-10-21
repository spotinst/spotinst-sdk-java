package com.spotinst.sdkjava.model.bl.mrScaler.aws;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerAwsFile {
    @JsonIgnore
    private Set<String>             isSet;
    private MrScalerAwsFileParams file;

    private MrScalerAwsFile() {  isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public MrScalerAwsFileParams getFile() {
        return file;
    }

    public void setFile(MrScalerAwsFileParams file) {
        isSet.add("file");
        this.file = file;
    }

    public static class Builder {
        private MrScalerAwsFile awsFile;

        private Builder(){ this.awsFile = new MrScalerAwsFile(); }

        public static Builder get(){
            return new Builder();
        }

        public Builder setFile(MrScalerAwsFileParams file){
            awsFile.setFile(file);
            return this;
        }

        public MrScalerAwsFile build(){
            return awsFile;
        }
    }

    @JsonIgnore
    public Boolean isFileSet(){ return isSet.contains("file"); }

}
