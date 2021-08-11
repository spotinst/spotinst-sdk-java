package com.spotinst.sdkjava.model.api.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiCreditSpecification {

    @JsonIgnore
    private Set<String> isSet;
    private String      cpuCredits;

    private ApiCreditSpecification() {
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

    @JsonIgnore
    public boolean isCpuCreditsSet() {
        return isSet.contains("cpuCredits");
    }

}
