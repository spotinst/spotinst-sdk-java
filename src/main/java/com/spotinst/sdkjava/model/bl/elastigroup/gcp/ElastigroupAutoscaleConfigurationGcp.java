package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupAutoscaleConfigurationGcp {

    @JsonIgnore
    private Set<String>                              isSet;
    private Integer                                  cooldown;
    private ElastigroupDownSpecificationGcp          down;
    private ElastigroupHeadroomSpecificationGcp      headroom;
    private Boolean                                  isAutoConfig;
    private Boolean                                  isEnabled;

    private ElastigroupAutoscaleConfigurationGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getCooldown() {
        return cooldown;
    }

    public ElastigroupDownSpecificationGcp getDown() {
        return down;
    }

    public void setDown(ElastigroupDownSpecificationGcp down) {
        isSet.add("down");
        this.down = down;
    }

    public ElastigroupHeadroomSpecificationGcp getHeadroom() {
        return headroom;
    }

    public void setHeadroom(ElastigroupHeadroomSpecificationGcp headroom) {
        isSet.add("headroom");
        this.headroom = headroom;
    }

    public void setCooldown(Integer cooldown) {
        isSet.add("cooldown");
        this.cooldown = cooldown;
    }

    public Boolean getIsAutoConfig() {
        return isAutoConfig;
    }

    public void setIsAutoConfig(Boolean isAutoConfig) {
        isSet.add("isAutoConfig");
        this.isAutoConfig = isAutoConfig;
    }

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        isSet.add("isEnabled");
        this.isEnabled = isEnabled;
    }

    public static class Builder {
        private ElastigroupAutoscaleConfigurationGcp AutoScale;

        private Builder() {
            this.AutoScale = new ElastigroupAutoscaleConfigurationGcp();
        }

        public static ElastigroupAutoscaleConfigurationGcp.Builder get() {
            return new Builder();
        }

        public Builder setIsEnabled(final Boolean isEnabled) {
            AutoScale.setIsEnabled(isEnabled);
            return this;
        }

        public Builder setCooldown(final Integer cooldown) {
            AutoScale.setCooldown(cooldown);
            return this;
        }

        public Builder setDown(final ElastigroupDownSpecificationGcp Down) {
            AutoScale.setDown(Down);
            return this;
        }

        public Builder setHeadroom(final ElastigroupHeadroomSpecificationGcp headroom) {
            AutoScale.setHeadroom(headroom);
            return this;
        }

        public Builder setIsAutoConfig(final Boolean isAutoConfig) {
            AutoScale.setIsAutoConfig(isAutoConfig);
            return this;
        }

        public ElastigroupAutoscaleConfigurationGcp build() {
            return AutoScale;
        }
    }

    @JsonIgnore
    public boolean isIsEnabledSet() {
        return isSet.contains("isEnabled");
    }

    @JsonIgnore
    public boolean isCooldownSet() {
        return isSet.contains("cooldown");
    }

    @JsonIgnore
    public boolean isDownSet() {
        return isSet.contains("down");
    }

    @JsonIgnore
    public boolean isHeadroomSet() {
        return isSet.contains("headroom");
    }

    @JsonIgnore
    public boolean isIsAutoConfigSet() {
        return isSet.contains("isAutoConfig");
    }
}
