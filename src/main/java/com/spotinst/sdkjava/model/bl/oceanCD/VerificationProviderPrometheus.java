package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VerificationProviderPrometheus {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    address;

    private VerificationProviderPrometheus() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        isSet.add("address");
        this.address = address;
    }

    public static class Builder {
        private VerificationProviderPrometheus verificationProviderPrometheus;

        private Builder() {
            this.verificationProviderPrometheus = new VerificationProviderPrometheus();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setAddress(final String address) {
            verificationProviderPrometheus.setAddress(address);
            return this;
        }

        public VerificationProviderPrometheus build() {
            return verificationProviderPrometheus;
        }
    }

    @JsonIgnore
    public boolean isAddressSet() {
        return isSet.contains("address");
    }
}