package com.spotinst.sdkjava.model.api.elastigroup.aws;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anurag Sharma on 14/8/2023.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiCreditSpecification {
    //region Members
    @JsonIgnore
    private Set<String>        isSet;
    private String        cpuCredits;
    //endregion

    //region Constructor

    public ApiCreditSpecification() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getter and Setter methods

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getCpuCredits() {
        return cpuCredits;
    }

    public void setCpuCredits(String credits) {
        isSet.add("cpuCredits");
        this.cpuCredits = credits;
    }

    //endregion

    //endregion

    //region Builder class
    public static class Builder {
        private ApiCreditSpecification creditSpec;

        private Builder() {
            this.creditSpec = new ApiCreditSpecification();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setCpuCredits(final String cpuCredits) {
            creditSpec.setCpuCredits(cpuCredits);
            return this;
        }

        public ApiCreditSpecification build() {
            // TODO : Validations
            return creditSpec;
        }
    }
    //endregion

    //region isSet methods
    @JsonIgnore
    public boolean isCpuCreditsSet() {
        return isSet.contains("cpuCredits");
    }

    //endregion
}
