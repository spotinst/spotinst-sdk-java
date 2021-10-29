package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterShutdownHoursSpecification {
    @JsonIgnore
    private Set<String>  isSet;
    private Boolean      isEnabled;
    private List<String> timeWindows;

    private ClusterShutdownHoursSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }


    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean enabled) {
        isSet.add("isEnabled");
        isEnabled = enabled;
    }

    public List<String> getTimeWindows() {
        return timeWindows;
    }

    public void setTimeWindows(List<String> timeWindows) {
        isSet.add("timeWindows");
        this.timeWindows = timeWindows;
    }

    public static class Builder {
        private ClusterShutdownHoursSpecification shutdownHours;

        private Builder() {
            this.shutdownHours = new ClusterShutdownHoursSpecification();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setIsEnabled(final Boolean isEnabled) {
            shutdownHours.setIsEnabled(isEnabled);
            return this;
        }

        public Builder setTimeWindows(final List<String> timeWindows) {
            shutdownHours.setTimeWindows(timeWindows);
            return this;
        }

        public ClusterShutdownHoursSpecification build() {
            return shutdownHours;
        }
    }

    @JsonIgnore
    public boolean isIsEnabledSet() {
        return isSet.contains("isEnabled");
    }
    @JsonIgnore
    public boolean isTimeWindowsSet() {
        return isSet.contains("timeWindows");
    }
}
