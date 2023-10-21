package com.spotinst.sdkjava.model.api.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.enums.aws.elastigroup.Route53RecordSetType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiRoute53Domains implements IPartialUpdateEntity {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String>                 isSet;
    private String               hostedZoneId;
    private List<ApiRecordSets>     recordSets;
    private Route53RecordSetType recordSetType;
    private String               spotinstAccountId;
    //endregion

    //region Constructor

    public ApiRoute53Domains() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters


    public String getHostedZoneId() {
        return hostedZoneId;
    }

    public void setHostedZoneId(String hostedZoneId) {
        isSet.add("hostedZoneId");
        this.hostedZoneId = hostedZoneId;
    }

    public List<ApiRecordSets> getRecordSets() {
        return recordSets;
    }

    public void setRecordSets(List<ApiRecordSets> recordSets) {
        isSet.add("recordSets");
        this.recordSets = recordSets;
    }

    public Route53RecordSetType getRecordSetType() {
        return recordSetType;
    }

    public void setRecordSetType(Route53RecordSetType recordSetType) {
        isSet.add("recordSetType");
        this.recordSetType = recordSetType;
    }

    public String getSpotinstAccountId() {
        return spotinstAccountId;
    }

    public void setSpotinstAccountId(String spotinstAccountId) {
        isSet.add("spotinstAccountId");
        this.spotinstAccountId = spotinstAccountId;
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    //endregion
    //region Builder class
    public static class Builder {
        private ApiRoute53Domains route53;

        private Builder() {
            this.route53 = new ApiRoute53Domains();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setHostedZoneId(final String hostedZoneId) {
            route53.setHostedZoneId(hostedZoneId);
            return this;
        }

        public Builder setRecordSets(final List<ApiRecordSets> recordSets) {
            route53.setRecordSets(recordSets);
            return this;
        }

        public Builder  setRecordSetType(final Route53RecordSetType recordSetType) {
            route53.setRecordSetType(recordSetType);
            return this;
        }

        public Builder setSpotinstAccountId(final String spotinstAccountId) {
            route53.setSpotinstAccountId(spotinstAccountId);
            return this;
        }

        public ApiRoute53Domains build() {
            return route53;
        }
    }
    //endregion

    //region isSet methods
    // Is hostedZoneId Set boolean method
    @JsonIgnore
    public boolean isHostedZoneIdSet() {
        return isSet.contains("hostedZoneId");
    }

    // Is recordSets Set boolean method
    @JsonIgnore
    public boolean isRecordSetsSet() {
        return isSet.contains("recordSets");
    }

    // Is recordSetType Set boolean method
    @JsonIgnore
    public boolean isRecordSetTypeSet() {
        return isSet.contains("recordSetType");
    }

    // Is spotinstAccountId Set boolean method
    @JsonIgnore
    public boolean isSpotinstAccountIdSet() {
        return isSet.contains("spotinstAccountId");
    }
    //endregion
}
