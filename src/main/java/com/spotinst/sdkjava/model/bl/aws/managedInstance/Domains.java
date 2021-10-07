package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Domains {

    @JsonIgnore
    private Set<String>         isSet;
    private String              hostedZoneId;
    private List<RecordSets>    recordSets;
    private String              recordSetType;
    private String              spotinstAccountId;

    private Domains() {
        isSet = new HashSet<>();
    }

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

    public List<RecordSets> getRecordSets() {
        return recordSets;
    }

    public void setRecordSets(List<RecordSets> recordSets) {
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

    public static class Builder {
        private Domains domains;

        private Builder() {
            this.domains = new Domains();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setHostedZoneId(final String hostedZoneId) {
            domains.setHostedZoneId(hostedZoneId);
            return this;
        }

        public Builder setRecordSets(final List<RecordSets> recordSets) {
            domains.setRecordSets(recordSets);
            return this;
        }

        public Builder setRecordSetType(final String recordSetType) {
            domains.setRecordSetType(recordSetType);
            return this;
        }

        public Builder setSpotinstAccountId(final String spotinstAccountId) {
            domains.setSpotinstAccountId(spotinstAccountId);
            return this;
        }

        public Domains build() {
            return domains;
        }
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

}
