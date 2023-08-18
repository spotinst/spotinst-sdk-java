package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerificationTemplateMetrics {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    name;
    private String                                    interval;
    private String                                    initialDelay;
    private Integer                                   count;
    private String                                    successCondition;
    private String                                    failureCondition;
    private Integer                                   failureLimit;
    private Integer                                   inconclusiveLimit;
    private Integer                                   consecutiveErrorLimit;
    private MetricsProvider                           provider;

    private VerificationTemplateMetrics() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        isSet.add("interval");
        this.interval = interval;
    }

    public String getInitialDelay() {
        return initialDelay;
    }

    public void setInitialDelay(String initialDelay) {
        isSet.add("initialDelay");
        this.initialDelay = initialDelay;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        isSet.add("count");
        this.count = count;
    }

    public String getSuccessCondition() {
        return successCondition;
    }

    public void setSuccessCondition(String successCondition) {
        isSet.add("successCondition");
        this.successCondition = successCondition;
    }

    public String getFailureCondition() {
        return failureCondition;
    }

    public void setFailureCondition(String failureCondition) {
        isSet.add("failureCondition");
        this.failureCondition = failureCondition;
    }

    public Integer getFailureLimit() {
        return failureLimit;
    }

    public void setFailureLimit(Integer failureLimit) {
        isSet.add("failureLimit");
        this.failureLimit = failureLimit;
    }

    public Integer getInconclusiveLimit() {
        return inconclusiveLimit;
    }

    public void setInconclusiveLimit(Integer inconclusiveLimit) {
        isSet.add("inconclusiveLimit");
        this.inconclusiveLimit = inconclusiveLimit;
    }

    public Integer getConsecutiveErrorLimit() {
        return consecutiveErrorLimit;
    }

    public void setConsecutiveErrorLimit(Integer consecutiveErrorLimit) {
        isSet.add("consecutiveErrorLimit");
        this.consecutiveErrorLimit = consecutiveErrorLimit;
    }

    public MetricsProvider getProvider() {
        return provider;
    }

    public void setProvider(MetricsProvider provider) {
        isSet.add("provider");
        this.provider = provider;
    }

    public static class Builder {
        private VerificationTemplateMetrics verificationTemplateMetrics;

        private Builder() {
            this.verificationTemplateMetrics = new VerificationTemplateMetrics();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            verificationTemplateMetrics.setName(name);
            return this;
        }

        public Builder setInterval(final String interval) {
            verificationTemplateMetrics.setInterval(interval);
            return this;
        }

        public Builder setInitialDelay(final String initialDelay) {
            verificationTemplateMetrics.setInitialDelay(initialDelay);
            return this;
        }

        public Builder setCount(final Integer count) {
            verificationTemplateMetrics.setCount(count);
            return this;
        }

        public Builder setSuccessCondition(final String successCondition) {
            verificationTemplateMetrics.setSuccessCondition(successCondition);
            return this;
        }

        public Builder setFailureCondition(final String failureCondition) {
            verificationTemplateMetrics.setFailureCondition(failureCondition);
            return this;
        }

        public Builder setFailureLimit(final Integer failureLimit) {
            verificationTemplateMetrics.setFailureLimit(failureLimit);
            return this;
        }

        public Builder setInconclusiveLimit(final Integer inconclusiveLimit) {
            verificationTemplateMetrics.setInconclusiveLimit(inconclusiveLimit);
            return this;
        }

        public Builder setConsecutiveErrorLimit(final Integer consecutiveErrorLimit) {
            verificationTemplateMetrics.setConsecutiveErrorLimit(consecutiveErrorLimit);
            return this;
        }

        public Builder setProvider(final MetricsProvider provider) {
            verificationTemplateMetrics.setProvider(provider);
            return this;
        }

        public VerificationTemplateMetrics build() {
            return verificationTemplateMetrics;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isIntervalSet() {
        return isSet.contains("interval");
    }

    @JsonIgnore
    public boolean isInitialDelaySet() {
        return isSet.contains("initialDelay");
    }

    @JsonIgnore
    public boolean isCountSet() {
        return isSet.contains("count");
    }

    @JsonIgnore
    public boolean isSuccessConditionSet() {
        return isSet.contains("successCondition");
    }

    @JsonIgnore
    public boolean isFailureConditionSet() {
        return isSet.contains("failureCondition");
    }

    @JsonIgnore
    public boolean isFailureLimitSet() {
        return isSet.contains("failureLimit");
    }

    @JsonIgnore
    public boolean isInconclusiveLimitSet() {
        return isSet.contains("inconclusiveLimit");
    }

    @JsonIgnore
    public boolean isConsecutiveErrorLimitSet() {
        return isSet.contains("consecutiveErrorLimit");
    }

    @JsonIgnore
    public boolean isProviderSet() {
        return isSet.contains("provider");
    }
}