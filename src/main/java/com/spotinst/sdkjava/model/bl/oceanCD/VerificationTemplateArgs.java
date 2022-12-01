package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerificationTemplateArgs {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    name;

    private VerificationTemplateArgs() {
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

    public static class Builder {
        private VerificationTemplateArgs verificationTemplateArgs;

        private Builder() {
            this.verificationTemplateArgs = new VerificationTemplateArgs();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            verificationTemplateArgs.setName(name);
            return this;
        }

        public VerificationTemplateArgs build() {
            return verificationTemplateArgs;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }
}