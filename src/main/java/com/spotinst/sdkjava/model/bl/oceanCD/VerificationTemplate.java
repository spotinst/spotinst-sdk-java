package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerificationTemplate {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    name;
    private List<VerificationTemplateArgs>            args;
    private List<VerificationTemplateMetrics>         metrics;

    private VerificationTemplate() {
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

    public List<VerificationTemplateArgs> getArgs() {
        return args;
    }

    public void setArgs(List<VerificationTemplateArgs> args) {
        isSet.add("args");
        this.args = args;
    }

    public List<VerificationTemplateMetrics> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<VerificationTemplateMetrics> metrics) {
        isSet.add("metrics");
        this.metrics = metrics;
    }

    public static class Builder {
        private VerificationTemplate verificationTemplate;

        private Builder() {
            this.verificationTemplate = new VerificationTemplate();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            verificationTemplate.setName(name);
            return this;
        }

        public Builder setArgs(final List<VerificationTemplateArgs> args) {
            verificationTemplate.setArgs(args);
            return this;
        }

        public Builder setMetrics(final List<VerificationTemplateMetrics> metrics) {
            verificationTemplate.setMetrics(metrics);
            return this;
        }

        public VerificationTemplate build() {
            return verificationTemplate;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isArgsSet() {
        return isSet.contains("args");
    }

    @JsonIgnore
    public boolean isMetricsSet() {
        return isSet.contains("metrics");
    }
}