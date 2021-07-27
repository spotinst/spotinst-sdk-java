package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElastigroupTargetGroupConfig {
    //region Members
    @JsonIgnore
    private Set<String>                            isSet;
    private String                                 healthCheckPath;
    private Integer                                healthCheckIntervalSeconds;
    private Integer                                healthCheckPort;
    private Integer                               healthCheckTimeoutSeconds;
    private String                                healthCheckProtocol;
    private Integer                               healthyThresholdCount;
    private Integer                               unhealthyThresholdCount;
    private Integer                               port;
    private String                                protocol;
    private String                                protocolVersion;
    private List<ElastigroupTargetGroupConfigTag> tags;
    private ElastigroupMatcher                    matcher;
    //endregion

    //region Constructor

    private ElastigroupTargetGroupConfig() {
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

//    TODO or: check if this methods should be private/package-private - DONE - public
    public String getHealthCheckPath() {
        return healthCheckPath;
    }

    public void setHealthCheckPath(String healthCheckPath) {
        isSet.add("healthCheckPath");
        this.healthCheckPath = healthCheckPath;
    }

    public Integer getHealthCheckIntervalSeconds() {
        return healthCheckIntervalSeconds;
    }

    public void setHealthCheckIntervalSeconds(Integer healthCheckIntervalSeconds) {
        isSet.add("healthCheckIntervalSeconds");
        this.healthCheckIntervalSeconds = healthCheckIntervalSeconds;
    }

    public Integer getHealthCheckPort() {
        return healthCheckPort;
    }

    public void setHealthCheckPort(Integer healthCheckPort) {
        isSet.add("healthCheckPort");
        this.healthCheckPort = healthCheckPort;
    }

    public Integer getHealthCheckTimeoutSeconds() {
        return healthCheckTimeoutSeconds;
    }

    public void setHealthCheckTimeoutSeconds(Integer healthCheckTimeoutSeconds) {
        isSet.add("healthCheckTimeoutSeconds");
        this.healthCheckTimeoutSeconds = healthCheckTimeoutSeconds;
    }

    public Integer getHealthyThresholdCount() {
        return healthyThresholdCount;
    }

    public void setHealthyThresholdCount(Integer healthyThresholdCount) {
        isSet.add("healthyThresholdCount");
        this.healthyThresholdCount = healthyThresholdCount;
    }

    public Integer getUnhealthyThresholdCount() {
        return unhealthyThresholdCount;
    }

    public void setUnhealthyThresholdCount(Integer unhealthyThresholdCount) {
        isSet.add("unhealthyThresholdCount");
        this.unhealthyThresholdCount = unhealthyThresholdCount;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        isSet.add("port");
        this.port = port;
    }

    public String getHealthCheckProtocol() {
        return healthCheckProtocol;
    }

    public void setHealthCheckProtocol(String healthCheckProtocol) {
        isSet.add("healthCheckProtocol");
        this.healthCheckProtocol = healthCheckProtocol;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        isSet.add("protocol");
        this.protocol = protocol;
    }

    public String getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(String protocolVersion) {
        isSet.add("protocolVersion");
        this.protocolVersion = protocolVersion;
    }

    public List<ElastigroupTargetGroupConfigTag> getTags() {
        return tags;
    }

    public void setTags(List<ElastigroupTargetGroupConfigTag> tags) {
        isSet.add("tags");
        this.tags = tags;
    }

    public ElastigroupMatcher getMatcher() {
        return matcher;
    }

    public void setMatcher(ElastigroupMatcher matcher) {
        isSet.add("matcher");
        this.matcher = matcher;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupTargetGroupConfig targetGroupConfig;

        private Builder() {
            this.targetGroupConfig = new ElastigroupTargetGroupConfig();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setHealthCheckPath(final String healthCheckPath) {
            targetGroupConfig.setHealthCheckPath(healthCheckPath);
            return this;
        }

        public Builder setHealthCheckIntervalSeconds(final Integer healthCheckIntervalSeconds) {
            targetGroupConfig.setHealthCheckIntervalSeconds(healthCheckIntervalSeconds);
            return this;
        }

        public Builder setHealthCheckPort(final Integer healthCheckPort) {
            targetGroupConfig.setHealthCheckPort(healthCheckPort);
            return this;
        }

        public Builder setHealthCheckTimeoutSeconds(final Integer healthCheckTimeoutSeconds) {
            targetGroupConfig.setHealthCheckTimeoutSeconds(healthCheckTimeoutSeconds);
            return this;
        }

        public Builder setHealthCheckProtocol(final String healthCheckProtocol) {
            targetGroupConfig.setHealthCheckProtocol(healthCheckProtocol);
            return this;
        }

        public Builder setHealthyThresholdCount(final Integer healthyThresholdCount) {
            targetGroupConfig.setHealthyThresholdCount(healthyThresholdCount);
            return this;
        }

        public Builder setUnhealthyThresholdCount(final Integer unhealthyThresholdCount) {
            targetGroupConfig.setUnhealthyThresholdCount(unhealthyThresholdCount);
            return this;
        }

        public Builder setPort(final Integer port) {
            targetGroupConfig.setPort(port);
            return this;
        }

        public Builder setProtocol(final String protocol) {
            targetGroupConfig.setProtocol(protocol);
            return this;
        }

        public Builder setProtocolVersion(final String protocolVersion) {
            targetGroupConfig.setProtocolVersion(protocolVersion);
            return this;
        }

        public Builder setTags(final List<ElastigroupTargetGroupConfigTag> tags) {
            targetGroupConfig.setTags(tags);
            return this;
        }

        public Builder setMatcher(final ElastigroupMatcher matcher) {
            targetGroupConfig.setMatcher(matcher);
            return this;
        }

        public ElastigroupTargetGroupConfig build() {
            return targetGroupConfig;
        }
    }
    //endregion
    //region isSet methods

    // Is healthCheckPath Set boolean method
    @JsonIgnore
    public boolean isHealthCheckPathSet() {
        return isSet.contains("healthCheckPath");
    }

    // Is healthCheckIntervalSeconds Set boolean method
    @JsonIgnore
    public boolean isHealthCheckIntervalSecondsSet() {
        return isSet.contains("healthCheckIntervalSeconds");
    }

    // Is healthCheckPort Set boolean method
    @JsonIgnore
    public boolean isHealthCheckPortSet() {
        return isSet.contains("healthCheckPort");
    }

    // Is healthCheckTimeoutSeconds Set boolean method
    @JsonIgnore
    public boolean isHealthCheckTimeoutSecondsSet() {
        return isSet.contains("healthCheckTimeoutSeconds");
    }

    // Is healthCheckPort Set boolean method
    @JsonIgnore
    public boolean isHealthyThresholdCountSet() {
        return isSet.contains("healthyThresholdCount");
    }

    // Is unhealthCheckPort Set boolean method
    @JsonIgnore
    public boolean isUnhealthyThresholdCountSet() {
        return isSet.contains("unhealthyThresholdCount");
    }

    // Is port Set boolean method
    @JsonIgnore
    public boolean isPortSet() {
        return isSet.contains("port");
    }

    // Is healthCheckProtocol Set boolean method
    @JsonIgnore
    public boolean isHealthCheckProtocolSet() {
        return isSet.contains("healthCheckProtocol");
    }

    // Is protocol Set boolean method
    @JsonIgnore
    public boolean isProtocolSet() {
        return isSet.contains("protocol");
    }

    // Is protocolVersion Set boolean method
    @JsonIgnore
    public boolean isProtocolVersionSet() {
        return isSet.contains("protocolVersion");
    }

    // Is tags Set boolean method
    @JsonIgnore
    public boolean isTagsSet() {
        return isSet.contains("tags");
    }

    // Is matcher Set boolean method
    @JsonIgnore
    public boolean isMatcherSet() {
        return isSet.contains("matcher");
    }
    //endregion
}
