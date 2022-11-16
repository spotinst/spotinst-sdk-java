package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.ElastigroupVmSignalEnumAzure;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignalsAzure {

    //regionMembers
    @JsonIgnore
    private Set<String> isSet;
    private Integer timeout;
    private ElastigroupVmSignalEnumAzure type;
    //end region

    //region Constructors
    private SignalsAzure(){
        isSet = new HashSet<>();
    }
    //end region

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        isSet.add("timeout");
        this.timeout = timeout;
    }

    public ElastigroupVmSignalEnumAzure getType() {
        return type;
    }

    public void setType(ElastigroupVmSignalEnumAzure type) {
        isSet.add("type");
        this.type = type;
    }

    //region Builder class
    public static class Builder {
        private SignalsAzure signalsAzure;

        private Builder() {
            this.signalsAzure = new SignalsAzure();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setTimeout(final Integer timeout) {
            signalsAzure.setTimeout(timeout);
            return this;
        }

        public Builder setType(final ElastigroupVmSignalEnumAzure type) {
            signalsAzure.setType(type);
            return this;
        }

        public SignalsAzure build() {
            // TODO : Validations
            return signalsAzure;
        }
    }
    //endregion

    //region isSet methods
    @JsonIgnore
    public boolean isTimeoutSet() {
        return isSet.contains("timeout");
    }

    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }
}
