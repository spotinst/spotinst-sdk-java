package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlbStickinessConfig {
    @JsonIgnore
    private Set<String>                isSet;
    private Boolean                    enabled;
    private Integer                    durationSeconds;

    private AlbStickinessConfig() {
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

    public static class Builder {
        private AlbStickinessConfig albStickinessConfig;

        private Builder() {
            this.albStickinessConfig = new AlbStickinessConfig();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setEnabled(final Boolean enabled) {
            albStickinessConfig.setEnabled(enabled);
            return this;
        }

        public Builder setDurationSeconds(final Integer durationSeconds) {
            albStickinessConfig.setDurationSeconds(durationSeconds);
            return this;
        }

        public AlbStickinessConfig build() {
            return albStickinessConfig;
        }
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