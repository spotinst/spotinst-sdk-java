package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.enums.aws.elastigroup.AwsInstanceMetadataTagsEnum;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Anurag Sharma
 * @since: 14/08/2023
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class MetadataOptions implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                                             isSet;
    private Integer                               httpPutResponseHopLimit;
    private String                                             httpTokens;
    private AwsInstanceMetadataTagsEnum              instanceMetadataTags;
    //endregion

    //region Constructor

    public MetadataOptions() {
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

    public Integer getHttpPutResponseHopLimit() {
        return httpPutResponseHopLimit;
    }

    public void setHttpPutResponseHopLimit(Integer limit) {
        isSet.add("httpPutResponseHopLimit");
        this.httpPutResponseHopLimit = limit;
    }

    public String getHttpTokens() {
        return httpTokens;
    }

    public void setHttpTokens(String token) {
        isSet.add("httpTokens");
        this.httpTokens = token;
    }

    public AwsInstanceMetadataTagsEnum getInstanceMetadataTags() {
        return instanceMetadataTags;
    }

    public void setInstanceMetadataTags(AwsInstanceMetadataTagsEnum tags) {
        isSet.add("instanceMetadataTags");
        this.instanceMetadataTags = tags;
    }



    //endregion

    //region Builder class
    public static class Builder {
        //region Members
        private MetadataOptions options;
        //endregion

        private Builder() {
            this.options = new MetadataOptions();
        }

        public static Builder get() {
            return new Builder();
        }

        //region Build methods
        public Builder setHttpPutResponseHopLimit(final Integer limit) {
            options.setHttpPutResponseHopLimit(limit);
            return this;
        }

        public Builder setHttpTokens(final String token) {
            options.setHttpTokens(token);
            return this;
        }

        public Builder setInstanceMetadataTags(final AwsInstanceMetadataTagsEnum tag) {
            options.setInstanceMetadataTags(tag);
            return this;
        }

        public MetadataOptions build() {
            // Validations
            return options;
        }
        //endregion
    }
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
