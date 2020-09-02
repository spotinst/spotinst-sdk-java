package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.ApiAttributes;
import com.spotinst.sdkjava.model.ApiDown;
import com.spotinst.sdkjava.model.ApiHeadroom;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiAutoScaleAzure implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>              isSet;
    private Boolean                  isEnabled;
    private Integer                  cooldown;
    private ApiDownAzure             down;
    private ApiHeadroomAzure         headroom;
    private Boolean                  isAutoConfig;
    private Boolean                  shouldScaleDownNonServiceTasks;
    private List<ApiAttributesAzure> attributes;
    //endregion

    //region Constructor
    public ApiAutoScaleAzure() {
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

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        isSet.add("isEnabled");
        this.isEnabled = isEnabled;
    }

    public Integer getCooldown() {
        return cooldown;
    }

    public ApiDownAzure getDown() {
        return down;
    }

    public void setDown(ApiDownAzure down) {
        isSet.add("down");
        this.down = down;
    }

    public ApiHeadroomAzure getHeadroom() {
        return headroom;
    }

    public void setHeadroom(ApiHeadroomAzure headroom) {
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

    public Boolean getShouldScaleDownNonServiceTasks() {
        return shouldScaleDownNonServiceTasks;
    }

    public void setShouldScaleDownNonServiceTasks(Boolean shouldScaleDownNonServiceTasks) {
        isSet.add("shouldScaleDownNonServiceTasks");
        this.shouldScaleDownNonServiceTasks = shouldScaleDownNonServiceTasks;
    }

    public List<ApiAttributesAzure> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<ApiAttributesAzure> attributes) {
        isSet.add("attributes");
        this.attributes = attributes;
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
