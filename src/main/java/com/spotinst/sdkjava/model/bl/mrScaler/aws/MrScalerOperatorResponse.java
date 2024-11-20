package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.AwsMrScalerStateEnum;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerOperatorResponse {
    @JsonIgnore
    private Set<String>          isSet;
    private String               name;
    private String               mrScalerId;
    private AwsMrScalerStateEnum state;

    public MrScalerOperatorResponse() { isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getMrScalerId() {
        return mrScalerId;
    }

    public void setMrScalerId(String mrScalerId) {
        isSet.add("mrScalerId");
        this.mrScalerId = mrScalerId;
    }

    public AwsMrScalerStateEnum getState() {
        return state;
    }

    public void setState(AwsMrScalerStateEnum state) {
        isSet.add("state");
        this.state = state;
    }

    public static class Builder {
        private MrScalerOperatorResponse mrScalerOperatorResponse;

        private Builder() {
            this.mrScalerOperatorResponse = new MrScalerOperatorResponse();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setName(final String name) {
            mrScalerOperatorResponse.setName(name);
            return this;
        }

        public Builder setMrScalerId(final String mrScalerId) {
            mrScalerOperatorResponse.setMrScalerId(mrScalerId);
            return this;
        }

        public Builder setState(final AwsMrScalerStateEnum state) {
            mrScalerOperatorResponse.setState(state);
            return this;
        }

        public MrScalerOperatorResponse build() {
            return mrScalerOperatorResponse;
        }
    }

    @JsonIgnore
    public Boolean isNameSet(){
        return isSet.contains("name");
    }

    @JsonIgnore
    public Boolean isMrScalerIdSet(){
        return isSet.contains("mrScalerId");
    }

    @JsonIgnore
    public Boolean isStateSet(){
        return isSet.contains("state");
    }


}
