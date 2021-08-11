package com.spotinst.sdkjava.model.api.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ApiDomains {

    @JsonIgnore
    private Set<String>         isSet;
    private String              hostedZoneId;
    private List<ApiRecordSets> recordSets;
    private String              recordSetType;
    private String              spotinstAccountId;

    //endregion

    //region constructor
    private ApiDomains() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Setters&Getters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getHostedZoneId() {
        return hostedZoneId;
    }

    public void setHostedZoneId(String hostedZoneId) {
        isSet.add("hostedZoneId");
        this.hostedZoneId = hostedZoneId;
    }

    public List<ApiRecordSets> getLoadBalancers() {
        return recordSets;
    }

    public void setRecordSets(List<ApiRecordSets> recordSets) {
        isSet.add("recordSets");
        this.recordSets = recordSets;
    }

    public String getRecordSetType() {
        return recordSetType;
    }

    public void setRecordSetType(String recordSetType) {
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

    @JsonIgnore
    public boolean isHostedZoneIdSet() {
        return isSet.contains("hostedZoneId");
    }

    @JsonIgnore
    public boolean isRecordSetsSet() {
        return isSet.contains("recordSets");
    }

    @JsonIgnore
    public boolean isRecordSetTypeSet() {
        return isSet.contains("recordSetType");
    }

    @JsonIgnore
    public boolean isSpotinstAccountIdSet() {
        return isSet.contains("spotinstAccountId");
    }

    //endregion
}
