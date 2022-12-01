package com.spotinst.sdkjava.model.api.oceanCD;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiCanaryBackgroundVerification implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                               isSet;
    private List<String>                              templateNames;
    private List<ApiArgs>          args;

    public ApiCanaryBackgroundVerification() {
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

    public List<ApiArgs> getArgs() {
        return args;
    }

    public void setArgs(List<ApiArgs> args) {
        isSet.add("args");
        this.args = args;
    }

    public static class Builder {
        private ApiCanaryBackgroundVerification canaryBackgroundVerification;

        private Builder() {
            this.canaryBackgroundVerification = new ApiCanaryBackgroundVerification();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setTemplateNames(final List<String> templateNames) {
            canaryBackgroundVerification.setTemplateNames(templateNames);
            return this;
        }

        public Builder setArgs(final List<ApiArgs> args) {
            canaryBackgroundVerification.setArgs(args);
            return this;
        }

        public ApiCanaryBackgroundVerification build() {
            return canaryBackgroundVerification;
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