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
public class ApiInitializeParamsGcp implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Integer     diskSizeGb;
    private String      diskType;
    private String      sourceImage;
    //endregion

    //region Constructor
    public ApiInitializeParamsGcp() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    //region diskSizeGb
    public Integer getDiskSizeGb() {
        return diskSizeGb;
    }

    public void setDiskSizeGb(Integer diskSizeGb) {
        isSet.add("diskSizeGb");
        this.diskSizeGb = diskSizeGb;
    }
    //endregion

    //region sourceImage
    public String getSourceImage() {
        return sourceImage;
    }

    public void setSourceImage(String sourceImage) {
        isSet.add("sourceImage");
        this.sourceImage = sourceImage;
    }
    //endregion

    //region diskType
    public String getDiskType() {
        return diskType;
    }

    public void setDiskType(String diskType) {
        isSet.add("diskType");
        this.diskType = diskType;
    }
    //endregion


    //region isset methods
    // Is diskSizeGb Set boolean method
    @JsonIgnore
    public boolean isDiskSizeGbSet() {
        return isSet.contains("diskSizeGb");
    }

    // Is sourceImage Set boolean method
    @JsonIgnore
    public boolean isSourceImageSet() {
        return isSet.contains("sourceImage");
    }

    //endregion

    // Is diskType Set boolean method
    @JsonIgnore
    public boolean isDiskTypeSet() {
        return isSet.contains("diskType");
    }
    //endregion
}
