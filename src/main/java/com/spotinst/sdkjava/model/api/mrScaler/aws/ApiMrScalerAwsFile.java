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
public class ApiMrScalerAwsFile implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>              isSet;
    private ApiMrScalerAwsFileParams file;

    public ApiMrScalerAwsFile() {  isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiMrScalerAwsFileParams getFile(){ return file; }

    public void setFile(ApiMrScalerAwsFileParams file) {
        isSet.add("file");
        this.file = file;
    }

    @JsonIgnore
    public Boolean isFileSet(){ return isSet.contains("file"); }

}
