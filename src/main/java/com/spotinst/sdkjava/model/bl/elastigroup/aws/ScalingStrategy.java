package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.aws.elastigroup.AwsTerminationPolicyEnum;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Anurag Sharma
 * @since: 14/08/2023
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScalingStrategy {
    //region Members
    @JsonIgnore
    private Set<String>                                    isSet;
    private AwsTerminationPolicyEnum           terminationPolicy;
    //endregion

    //region Constructor

    public ScalingStrategy() {
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

    public AwsTerminationPolicyEnum getTerminationPolicy() {
        return terminationPolicy;
    }

    public void setTerminationPolicy(AwsTerminationPolicyEnum terminationPolicy) {
        isSet.add("terminationPolicy");
        this.terminationPolicy = terminationPolicy;
    }

    //endregion

    //region Builder class
    public static class Builder {
        //region Members
        private ScalingStrategy terminationPolicy;
        //endregion

        private Builder() {
            this.terminationPolicy = new ScalingStrategy();
        }

        public static Builder get() {
            return new Builder();
        }

        //region Build methods
        public Builder setTerminationPolicy(final AwsTerminationPolicyEnum policy) {
            terminationPolicy.setTerminationPolicy(policy);
            return this;
        }

        public ScalingStrategy build() {
            // Validations
            return terminationPolicy;
        }
        //endregion
    }
    //endregion


    //region isSet methods
    // Is terminationPolicy Set boolean method
    @JsonIgnore
    public boolean isTerminationPolicySet() {
        return isSet.contains("terminationPolicy");
    }

    //endregion
}
