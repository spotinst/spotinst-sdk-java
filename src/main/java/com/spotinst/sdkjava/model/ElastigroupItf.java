package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class ElastigroupItf {
    //region Members
    @JsonIgnore
    private Set<String>                    isSet;
    private String                         weightStrategy;
    private Integer                        migrationHealthinessThreshold;
    private Boolean                        fixedTargetGroups;
    private ElastigroupTargetGroupConfig   targetGroupConfig;
    private List<ElastigroupListenerRules> listenerRules;
    //endregion

    //region Constructor

    private ElastigroupItf() {
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

    public String getWeightStrategy() {
        return weightStrategy;
    }

    public void setWeightStrategy(String weightStrategy) {
        isSet.add("weightStrategy");
        this.weightStrategy = weightStrategy;
    }

    public Integer getMigrationHealthinessThreshold() {
        return migrationHealthinessThreshold;
    }

    public void setMigrationHealthinessThreshold(Integer migrationHealthinessThreshold) {
        isSet.add("migrationHealthinessThreshold");
        this.migrationHealthinessThreshold = migrationHealthinessThreshold;
    }

    public Boolean getFixedTargetGroups() {
        return fixedTargetGroups;
    }

    public void setFixedTargetGroups(Boolean fixedTargetGroups) {
        isSet.add("fixedTargetGroups");
        this.fixedTargetGroups = fixedTargetGroups;
    }

    public ElastigroupTargetGroupConfig getTargetGroupConfig() {
        return targetGroupConfig;
    }

    public void setTargetGroupConfig(ElastigroupTargetGroupConfig targetGroupConfig) {
        isSet.add("targetGroupConfig");
        this.targetGroupConfig = targetGroupConfig;
    }

    public List<ElastigroupListenerRules> getListenerRules() {
        return listenerRules;
    }

    public void setListenerRules(List<ElastigroupListenerRules> listenerRules) {
        isSet.add("listenerRules");
        this.listenerRules = listenerRules;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupItf itf;

        private Builder() {
            this.itf = new ElastigroupItf();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setWeightStrategy(final String weightStrategy) {
            itf.setWeightStrategy(weightStrategy);
            return this;
        }

        public Builder setMigrationHealthinessThreshold(final Integer migrationHealthinessThreshold) {
            itf.setMigrationHealthinessThreshold(migrationHealthinessThreshold);
            return this;
        }

        public Builder setTargetGroupConfig(final ElastigroupTargetGroupConfig targetGroupConfig) {
            itf.setTargetGroupConfig(targetGroupConfig);
            return this;
        }

        public Builder setFixedTargetGroups(final Boolean fixedTargetGroups) {
            itf.setFixedTargetGroups(fixedTargetGroups);
            return this;
        }

        public Builder setListenerRules(final List<ElastigroupListenerRules> listenerRules) {
            itf.setListenerRules(listenerRules);
            return this;
        }

        public ElastigroupItf build() {
            return itf;
        }
    }
    //endregion
    //region isSet methods

    // Is weightStrategy Set boolean method
    @JsonIgnore
    public boolean isWeightStrategySet() {
        return isSet.contains("weightStrategy");
    }

    // Is migrationHealthinessThreshold Set boolean method
    @JsonIgnore
    public boolean isMigrationHealthinessThresholdSet() {
        return isSet.contains("migrationHealthinessThreshold");
    }

    // Is fixedTargetGroups Set boolean method
    @JsonIgnore
    public boolean isFixedTargetGroupsSet() {
        return isSet.contains("fixedTargetGroups");
    }


    // Is targetGroupConfig Set boolean method
    @JsonIgnore
    public boolean isTargetGroupConfigSet() {
        return isSet.contains("targetGroupConfig");
    }

    // Is listenerRules Set boolean method
    @JsonIgnore
    public boolean isListenerRulesSet() {
        return isSet.contains("listenerRules");
    }
    //endregion
}
