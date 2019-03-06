package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiMrScalerAwsScalingDimenation {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String name;
    private String value;
    //region Constructor
    public ApiMrScalerAwsScalingDimenation() { isSet = new HashSet<>(); }
    // endregion

    //region getters and setters
    // region name
    public String getName(){
        return name;
    }

    public void setName(String name){
        isSet.add("name");
        this.name = name;
    }

    public Boolean isNameSet(){
        return isSet.contains("name");
    }
    // endregion

    // region value
    public String getValue(){
        return value;
    }

    public void setValue(String value){
        isSet.add("value");
        this.value = value;
    }

    public Boolean isValueSet(){
        return isSet.contains("value");
    }
    // endregion
    // endregion

    public static class Builder {
        private ApiMrScalerAwsScalingDimenation scalingDimenation;

        private Builder(){this.scalingDimenation = new ApiMrScalerAwsScalingDimenation();}

        public static Builder get(){
            return new Builder();
        }

        // region build methods
        public Builder setName(final String name){
            scalingDimenation.setName(name);
            return this;
        }
        public Builder setValue(final String value){
            scalingDimenation.setValue(value);
            return this;
        }

        public ApiMrScalerAwsScalingDimenation build(){
            return scalingDimenation;
        }
        // endregion
    }
}
