package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditSpecification {

    @JsonIgnore
    private Set<String> isSet;
    private String      cpuCredits;

    private CreditSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getCpuCredits() {
        return cpuCredits;
    }

    public void setCpuCredits(String cpuCredits) {
        isSet.add("cpuCredits");
        this.cpuCredits = cpuCredits;
    }

    public static class Builder {
        private CreditSpecification creditSpecification;

        private Builder() {
            this.creditSpecification = new CreditSpecification();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setCpuCredits(final String cpuCredits) {
            creditSpecification.setCpuCredits(cpuCredits);
            return this;
        }

        public CreditSpecification build() {
            return creditSpecification;
        }
    }

    @JsonIgnore
    public boolean isCpuCreditsSet() {
        return isSet.contains("cpuCredits");
    }

}
