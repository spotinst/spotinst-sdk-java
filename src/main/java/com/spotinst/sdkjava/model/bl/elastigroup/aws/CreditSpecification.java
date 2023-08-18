package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.enums.aws.elastigroup.AwsCpuCreditsEnum;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Anurag Sharma
 * @since: 14/08/2023
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class CreditSpecification implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                               isSet;
    private AwsCpuCreditsEnum                    cpuCredits;
    //endregion

    //region Constructor

    public CreditSpecification() {
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

    public AwsCpuCreditsEnum getCpuCredits() {
        return cpuCredits;
    }

    public void setCpuCredits(AwsCpuCreditsEnum credits) {
        isSet.add("cpuCredits");
        this.cpuCredits = credits;
    }

    //endregion

    //region Builder class
    public static class Builder {
        //region Members
        private CreditSpecification cpuCredits;
        //endregion

        private Builder() {
            this.cpuCredits = new CreditSpecification();
        }

        public static Builder get() {
            return new Builder();
        }

        //region Build methods
        public Builder setCpuCredits(final AwsCpuCreditsEnum credits) {
            cpuCredits.setCpuCredits(credits);
            return this;
        }

        public CreditSpecification build() {
            // Validations
            return cpuCredits;
        }
        //endregion
    }
    //endregion


    //region isSet methods
    @JsonIgnore
    public boolean isCpuCreditsSet() {
        return isSet.contains("cpuCredits");
    }

    //endregion
}
