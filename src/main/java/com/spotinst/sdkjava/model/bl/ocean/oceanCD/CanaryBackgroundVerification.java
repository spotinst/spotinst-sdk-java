package com.spotinst.sdkjava.model.bl.ocean.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CanaryBackgroundVerification {
    @JsonIgnore
    private Set<String>                         isSet;
    private List<String> templateNames;
    private List<BackgroundVerificationArgs>    args;

    public CanaryBackgroundVerification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getTemplateNames() {
        return templateNames;
    }

    public void setTemplateNames(List<String> templateNames) {
        isSet.add("templateNames");
        this.templateNames = templateNames;
    }

    public List<BackgroundVerificationArgs> getArgs() {
        return args;
    }

    public void setArgs(List<BackgroundVerificationArgs> args) {
        isSet.add("args");
        this.args = args;
    }

    public static class Builder {
        private CanaryBackgroundVerification backgroundVerification;

        private Builder() {
            this.backgroundVerification = new CanaryBackgroundVerification();
        }

        public static CanaryBackgroundVerification.Builder get() {
            return new Builder();
        }

        public Builder setTemplateNames(List<String> templateNames) {
            backgroundVerification.setTemplateNames(templateNames);
            return this;
        }

        public Builder setArgs(List<BackgroundVerificationArgs> args) {
            backgroundVerification.setArgs(args);
            return this;
        }

        public CanaryBackgroundVerification build() {
            return backgroundVerification;
        }
    }

    @JsonIgnore
    public boolean isTemplateNamesSet() {
        return isSet.contains("templateNames");
    }

    @JsonIgnore
    public boolean isArgsSet() {
        return isSet.contains("args");
    }

}
