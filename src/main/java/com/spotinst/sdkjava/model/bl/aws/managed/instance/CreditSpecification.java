package com.spotinst.sdkjava.model.bl.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chandra on 08/06/21.
 */

public class CreditSpecification {

    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      cpuCredits;


    //region Constructor

    private CreditSpecification() {
        isSet = new HashSet<>();
    }
    //endregion

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

//For future use
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        CreditSpecification creditSpecification = (CreditSpecification) o;
//
//        if (cpuCredits != null ? !cpuCredits.equals(creditSpecification.cpuCredits) : creditSpecification.cpuCredits != null) {
//            return false;
//        }
//        return true;
//
//    }

    @Override
    public int hashCode() {
        int result = cpuCredits != null ? cpuCredits.hashCode() : 0;
        return result;
    }

    //region Builder class
    public static class Builder {
        private CreditSpecification creditSpecification;

        private Builder() {
            this.creditSpecification = new CreditSpecification();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setCpuCredits(final String cpuCredits) {
            creditSpecification.setCpuCredits(cpuCredits);
            return this;
        }

        public CreditSpecification build() {
            // TODO : Validations
            return creditSpecification;
        }
    }
    //endregion

    //region isSet methods
    // Is cpuCredits Set boolean method
    @JsonIgnore
    public boolean isCpuCreditsSet() {
        return isSet.contains("cpuCredits");
    }

    //endregion
}
