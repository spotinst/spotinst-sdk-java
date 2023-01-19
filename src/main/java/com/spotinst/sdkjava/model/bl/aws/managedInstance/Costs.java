package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Costs {

    @JsonIgnore
    private Set<String> isSet;
    private Integer      actual;
    private Integer      potential;

    private Costs() {
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

    public static class Builder {
        private Costs costs;

        private Builder() {
            this.costs = new Costs();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setActual(final Integer actual) {
            costs.setActual(actual);
            return this;
        }

        public Builder setPotential(final Integer potential) {
            costs.setPotential(potential);
            return this;
        }

        public Costs build() {
            return costs;
        }
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
