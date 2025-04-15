package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerAwsScalingDimenation {
    @JsonIgnore
    private Set<String> isSet;
    private String      name;
    private String      value;

    private MrScalerAwsScalingDimenation() { isSet = new HashSet<>(); }

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        isSet.add("value");
        this.value = value;
    }

    public static class Builder {
        private MrScalerAwsScalingDimenation scalingDimenation;

        private Builder(){this.scalingDimenation = new MrScalerAwsScalingDimenation();}

        public static Builder get(){
            return new Builder();
        }

        public Builder setName(final String name){
            scalingDimenation.setName(name);
            return this;
        }
        public Builder setValue(final String value){
            scalingDimenation.setValue(value);
            return this;
        }

        public MrScalerAwsScalingDimenation build(){
            return scalingDimenation;
        }
    }

    @JsonIgnore
    public Boolean isNameSet(){
        return isSet.contains("name");
    }

    @JsonIgnore
    public Boolean isValueSet(){
        return isSet.contains("value");
    }
}
