package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.azure.statefulNode.AzureStatefulNodeSchedulingTaskTypeEnum;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeTasksConfiguration {
    @JsonIgnore
    private Set<String>                   isSet;
    private Boolean                       isEnabled;
    private String                        cronExpression;
    private AzureStatefulNodeSchedulingTaskTypeEnum type;

    public StatefulNodeTasksConfiguration() {
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

    public void setIsEnabled(Boolean isEnabled) {
        isSet.add("isEnabled");
        this.isEnabled = isEnabled;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        isSet.add("cronExpression");
        this.cronExpression = cronExpression;
    }

    public AzureStatefulNodeSchedulingTaskTypeEnum getType() {
        return type;
    }

    public void setType(AzureStatefulNodeSchedulingTaskTypeEnum type) {
        isSet.add("type");
        this.type = type;
    }

    public static class Builder {
        private StatefulNodeTasksConfiguration task;

        private Builder() {
            this.task = new StatefulNodeTasksConfiguration();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setIsEnabled(final Boolean isEnabled) {
            task.setIsEnabled(isEnabled);
            return this;
        }

        public Builder setCronExpression(final String cronExpression) {
            task.setCronExpression(cronExpression);
            return this;
        }

        public Builder setType(final AzureStatefulNodeSchedulingTaskTypeEnum type) {
            task.setType(type);
            return this;
        }

        public StatefulNodeTasksConfiguration build() {
            return task;
        }
    }

    @JsonIgnore
    public Boolean isIsEnabledSet() {
        return isSet.contains("isEnabled");
    }

    @JsonIgnore
    public Boolean isCronExpressionSet() {
        return isSet.contains("cronExpression");
    }

    @JsonIgnore
    public Boolean isTypeSet() {
        return isSet.contains("type");
    }

}
