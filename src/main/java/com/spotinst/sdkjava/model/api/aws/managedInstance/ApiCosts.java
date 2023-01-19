package com.spotinst.sdkjava.model.api.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiCosts  implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String> isSet;
    private Integer      actual;
    private Integer      potential;

    private ApiCosts() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getActual() {
        return actual;
    }

    public void setActual(Integer actual) {
        isSet.add("actual");
        this.actual = actual;
    }

    public Integer getPotential() {
        return potential;
    }

    public void setPotential(Integer potential) {
        isSet.add("potential");
        this.potential = potential;
    }

    @JsonIgnore
    public boolean isActualSet() {
        return isSet.contains("actual");
    }

    @JsonIgnore
    public boolean isPotentialSet() {
        return isSet.contains("potential");
    }
}
