package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Anurag Sharma
 * @since: 17/08/2023
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequiredVCpuMemoryGpu {
    //region Members
    @JsonIgnore
    private Set<String>                 isSet;
    private Integer                   minimum;
    private Integer                   maximum;
    //endregion

    //region Constructor

    public RequiredVCpuMemoryGpu() {
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

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        isSet.add("minimum");
        this.minimum = minimum;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        isSet.add("maximum");
        this.maximum = maximum;
    }

    //endregion

    //region Builder class
    public static class Builder {
        //region Members
        private RequiredVCpuMemoryGpu required;
        //endregion


        private Builder() {
            this.required = new RequiredVCpuMemoryGpu();
        }

        public static Builder get() {
            return new Builder();
        }

        //region Build methods
        public Builder setMinimum(final Integer minimum) {
            required.setMinimum(minimum);
            return this;
        }

        public Builder setMaximum(final Integer maximum) {
            required.setMaximum(maximum);
            return this;
        }

        public RequiredVCpuMemoryGpu build() {
            // Validations
            return required;
        }
        //endregion
    }
    //endregion


    //region isSet methods
    // Is minimum Set boolean method
    @JsonIgnore
    public boolean isMinimumSet() {
        return isSet.contains("minimum");
    }

    // Is maximum Set boolean method
    @JsonIgnore
    public boolean isMaximumSet() {
        return isSet.contains("maximum");
    }

    //endregion
}
