package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerificationProviderCloudWatch {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    iamArn;

    private VerificationProviderCloudWatch() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getIamArn() {
        return iamArn;
    }

    public void setIamArn(String iamArn) {
        isSet.add("iamArn");
        this.iamArn = iamArn;
    }

    public static class Builder {
        private VerificationProviderCloudWatch verificationProviderCloudWatch;

        private Builder() {
            this.verificationProviderCloudWatch = new VerificationProviderCloudWatch();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setIamArn(final String iamArn) {
            verificationProviderCloudWatch.setIamArn(iamArn);
            return this;
        }

        public VerificationProviderCloudWatch build() {
            return verificationProviderCloudWatch;
        }
    }

    @JsonIgnore
    public boolean isIamArnSet() {
        return isSet.contains("iamArn");
    }
}