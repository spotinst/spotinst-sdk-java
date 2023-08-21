package com.spotinst.sdkjava.model.api.elastigroup.aws;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anurag Sharma on 14/8/2023.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiScalingStrategy implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>              isSet;
    private String terminationPolicy;
    //endregion

    //region Constructor

    public ApiScalingStrategy() {
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

    public String getTerminationPolicy() {
        return terminationPolicy;
    }

    public void setTerminationPolicy(String terminationPolicy) {
        isSet.add("terminationPolicy");
        this.terminationPolicy = terminationPolicy;
    }

    //endregion

    //endregion

    //region Builder class
    public static class Builder {
        private ApiScalingStrategy terminationPolicy;

        private Builder() {
            this.terminationPolicy = new ApiScalingStrategy();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setTerminationPolicy(final String policy) {
            terminationPolicy.setTerminationPolicy(policy);
            return this;
        }

        public ApiScalingStrategy build() {
            // TODO : Validations
            return terminationPolicy;
        }
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
