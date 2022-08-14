package com.spotinst.sdkjava.model.api.oceanCD;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiAlbStickinessConfig implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                isSet;
    private Boolean                    enabled;
    private Integer                    durationSeconds;

    public ApiAlbStickinessConfig() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        isSet.add("enabled");
        this.enabled = enabled;
    }

    public Integer getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(Integer durationSeconds) {
        isSet.add("durationSeconds");
        this.durationSeconds = durationSeconds;
    }

    @JsonIgnore
    public boolean isEnabledSet() {
        return isSet.contains("enabled");
    }

    @JsonIgnore
    public boolean isDurationSecondsSet() {
        return isSet.contains("durationSeconds");
    }
}