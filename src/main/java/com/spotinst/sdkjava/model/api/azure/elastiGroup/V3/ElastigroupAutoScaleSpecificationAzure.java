package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.ElastigroupAttributesSpecification;
import com.spotinst.sdkjava.model.ElastigroupDownSpecification;
import com.spotinst.sdkjava.model.ElastigroupHeadroomSpecification;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElastigroupAutoScaleSpecificationAzure {
    //region Members
    @JsonIgnore
    private Set<String>                              isSet;
    private Boolean                                  isEnabled;
    private Integer                                  cooldown;
    private ElastigroupDownSpecificationAzure             down;
    private ElastigroupHeadroomSpecificationAzure         headroom;
    private Boolean                                  isAutoConfig;
    private Boolean                                  shouldScaleDownNonServiceTasks;
    private List<ElastigroupAttributesSpecificationAzure> attributes;
    //endregion

    //region Constructor

    private ElastigroupAutoScaleSpecificationAzure() {
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

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        isSet.add("isEnabled");
        this.isEnabled = isEnabled;
    }

    public Integer getCooldown() {
        return cooldown;
    }

    public ElastigroupDownSpecificationAzure getDown() {
        return down;
    }

    public void setDown(ElastigroupDownSpecificationAzure down) {
        isSet.add("down");
        this.down = down;
    }

    public ElastigroupHeadroomSpecificationAzure getHeadroom() {
        return headroom;
    }

    public void setHeadroom(ElastigroupHeadroomSpecificationAzure headroom) {
        isSet.add("headroom");
        this.headroom = headroom;
    }

    public void setCooldown(Integer cooldown) {
        isSet.add("cooldown");
        this.cooldown = cooldown;
    }

    public Boolean getAutoConfig() {
        return isAutoConfig;
    }

    public void setIsAutoConfig(Boolean isAutoConfig) {
        isSet.add("isAutoConfig");
        this.isAutoConfig = isAutoConfig;
    }

    public Boolean getShouldScaleDownNonServiceTasks() {
        return shouldScaleDownNonServiceTasks;
    }

    public void setShouldScaleDownNonServiceTasks(Boolean shouldScaleDownNonServiceTasks) {
        isSet.add("shouldScaleDownNonServiceTasks");
        this.shouldScaleDownNonServiceTasks = shouldScaleDownNonServiceTasks;
    }

    public List<ElastigroupAttributesSpecificationAzure> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<ElastigroupAttributesSpecificationAzure> attributes) {
        isSet.add("attributes");
        this.attributes = attributes;
    }

    //endregion
    //region Builder class
    public static class Builder {
        private ElastigroupAutoScaleSpecificationAzure AutoScale;

        private Builder() {
            this.AutoScale = new ElastigroupAutoScaleSpecificationAzure();
        }

        public static ElastigroupAutoScaleSpecificationAzure.Builder get() {
            ElastigroupAutoScaleSpecificationAzure.Builder builder = new ElastigroupAutoScaleSpecificationAzure.Builder();
            return builder;
        }

        public Builder setIsEnabled(final Boolean isEnabled) {
            AutoScale.setIsEnabled(isEnabled);
            return this;
        }

        public Builder setCooldown(final Integer cooldown) {
            AutoScale.setCooldown(cooldown);
            return this;
        }

        public Builder setDown(final ElastigroupDownSpecificationAzure Down) {
            AutoScale.setDown(Down);
            return this;
        }

        public Builder setHeadroom(final ElastigroupHeadroomSpecificationAzure headroom) {
            AutoScale.setHeadroom(headroom);
            return this;
        }

        public Builder setIsAutoConfig(final Boolean isAutoConfig) {
            AutoScale.setIsAutoConfig(isAutoConfig);
            return this;
        }

        public Builder setShouldScaleDownNonServiceTasks(final Boolean shouldScaleDownNonServiceTasks) {
            AutoScale.setShouldScaleDownNonServiceTasks(shouldScaleDownNonServiceTasks);
            return this;
        }

        public Builder setAttributes(final List<ElastigroupAttributesSpecificationAzure> attributes) {
            AutoScale.setAttributes(attributes);
            return this;
        }

        public ElastigroupAutoScaleSpecificationAzure build() {
            return AutoScale;
        }
    }
    //endregion

    //region isSet methods
    // Is isEnabled Set boolean method
    @JsonIgnore
    public boolean isIsEnabledSet() {
        return isSet.contains("isEnabled");
    }

    // Is cooldown Set boolean method
    @JsonIgnore
    public boolean isCooldownSet() {
        return isSet.contains("cooldown");
    }

    // Is Down Set boolean method
    @JsonIgnore
    public boolean isDownSet() {
        return isSet.contains("down");
    }

    // Is Down Set boolean method
    @JsonIgnore
    public boolean isHeadroomSet() {
        return isSet.contains("headroom");
    }

    // Is isAutoConfig Set boolean method
    @JsonIgnore
    public boolean isIsAutoConfigSet() {
        return isSet.contains("isAutoConfig");
    }

    // Is shouldScaleDownNonServiceTasks Set boolean method
    @JsonIgnore
    public boolean isShouldScaleDownNonServiceTasksSet() {
        return isSet.contains("shouldScaleDownNonServiceTasks");
    }

    // Is attributes Set boolean method
    @JsonIgnore
    public boolean isAttributesSet() {
        return isSet.contains("attributes");
    }

    //endregion

}
