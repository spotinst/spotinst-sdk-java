package com.spotinst.sdkjava.model.api.elastigroup.aws;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anurag Sharma on 14/8/2023.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiMetadataOptions implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                                 isSet;
    private Integer                   httpPutResponseHopLimit;
    private String                                 httpTokens;
    private String                       instanceMetadataTags;
    //endregion

    //region Constructor

    public ApiMetadataOptions() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getter and Setter methods

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getHttpPutResponseHopLimit() {
        return httpPutResponseHopLimit;
    }

    public void setHttpPutResponseHopLimit(Integer httpPutResponseHopLimit) {
        isSet.add("httpPutResponseHopLimit");
        this.httpPutResponseHopLimit = httpPutResponseHopLimit;
    }

    public String getHttpTokens() {
        return httpTokens;
    }

    public void setHttpTokens(String tokens) {
        isSet.add("httpTokens");
        this.httpTokens = tokens;
    }

    public String getInstanceMetadataTags() {
        return instanceMetadataTags;
    }

    public void setInstanceMetadataTags(String tags) {
        isSet.add("instanceMetadataTags");
        this.instanceMetadataTags = tags;
    }


    //endregion

    //endregion

    //region isSet methods
    @JsonIgnore
    public boolean isHttpPutResponseHopLimitSet() {
        return isSet.contains("httpPutResponseHopLimit");
    }

    @JsonIgnore
    public boolean isHttpTokensSet() {
        return isSet.contains("httpTokens");
    }

    @JsonIgnore
    public boolean isInstanceMetadataTagsSet() {
        return isSet.contains("instanceMetadataTags");
    }

    //endregion
}
