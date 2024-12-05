package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiConstraints;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.Constraints;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiAutoScale implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>         isSet;
    private Boolean             isEnabled;
    private Integer             cooldown;
    private ApiDown             down;
    private ApiHeadroom         headroom;
    private Boolean             isAutoConfig;
    private Boolean             shouldScaleDownNonServiceTasks;
    private List<ApiAttributes> attributes;
    private List<ApiConstraints>         constraints;
    //endregion

    //region Constructor
    public ApiAutoScale() {
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

    public List<ApiConstraints> getConstraints() {
        return constraints;
    }

    public void setConstraints(List<ApiConstraints> constraints) {
        isSet.add("constraints");
        this.constraints = constraints;
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

    public ApiDown getDown() {
        return down;
    }

    public void setDown(ApiDown down) {
        isSet.add("down");
        this.down = down;
    }

    public ApiHeadroom getHeadroom() {
        return headroom;
    }

    public void setHeadroom(ApiHeadroom headroom) {
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

    public List<ApiAttributes> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<ApiAttributes> attributes) {
        isSet.add("attributes");
        this.attributes = attributes;
    }

    //endregion
    //region isSet methods
    // Is constraints Set boolean method
    @JsonIgnore
    public boolean isConstraintsSet() {
        return isSet.contains("constraints");
    }
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
