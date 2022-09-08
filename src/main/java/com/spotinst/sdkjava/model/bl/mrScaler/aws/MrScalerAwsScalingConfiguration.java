package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerAwsScalingConfiguration {
    @JsonIgnore
    private Set<String>                      isSet;
    private List<MrScalerAwsScalingPolicy> up;
    private List<MrScalerAwsScalingPolicy> down;

    private MrScalerAwsScalingConfiguration() { isSet = new HashSet<>(); }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<MrScalerAwsScalingPolicy> getUp() {
        return up;
    }

    public void setUp(List<MrScalerAwsScalingPolicy> up) {
        isSet.add("up");
        this.up = up;
    }

    public List<MrScalerAwsScalingPolicy> getDown() {
        return down;
    }

    public void setDown(List<MrScalerAwsScalingPolicy> down) {
        isSet.add("down");
        this.down = down;
    }

    public static class Builder {
        private MrScalerAwsScalingConfiguration scaling;

        private Builder(){ this.scaling = new MrScalerAwsScalingConfiguration(); }

        public static Builder get(){
            return new Builder();
        }

        public Builder setUp(final List<MrScalerAwsScalingPolicy> up){
            scaling.setUp(up);
            return this;
        }
        public Builder setDown(final List<MrScalerAwsScalingPolicy> down){
            scaling.setDown(down);
            return this;
        }

        public MrScalerAwsScalingConfiguration build(){
            return scaling;
        }
    }

    @JsonIgnore
    public Boolean isUpSet(){
        return isSet.contains("up");
    }

    @JsonIgnore
    public Boolean isDownSet(){
        return isSet.contains("down");
    }
}
