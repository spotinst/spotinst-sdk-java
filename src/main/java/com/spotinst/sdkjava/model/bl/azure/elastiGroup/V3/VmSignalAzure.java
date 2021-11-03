package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.ElastigroupVmSignalEnumAzure;

import java.util.HashSet;
import java.util.Set;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VmSignalAzure {

    @JsonIgnore
    private Set<String>                  isSet;
    private ElastigroupVmSignalEnumAzure signalType;
    private String                       vmName;

    private VmSignalAzure() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ElastigroupVmSignalEnumAzure getSignalType() {
        return signalType;
    }

    public void setSignalType(ElastigroupVmSignalEnumAzure signalType) {
        isSet.add("signalType");
        this.signalType = signalType;
    }

    public String getVmName() {
        return vmName;
    }

    public void setVmName(String vmName) {
        isSet.add("vmName");
        this.vmName = vmName;
    }

    public static class Builder {
        private VmSignalAzure elastigroupVmSignal;

        private Builder() {
            this.elastigroupVmSignal = new VmSignalAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setSignalType(final ElastigroupVmSignalEnumAzure signalType) {
            elastigroupVmSignal.setSignalType(signalType);
            return this;
        }

        public Builder setVmName(final String vmName) {
            elastigroupVmSignal.setVmName(vmName);
            return this;
        }

        public VmSignalAzure build() {
            return elastigroupVmSignal;
        }

    }

    @JsonIgnore
    public boolean isSignalTypeSet() {
        return isSet.contains("signalType");
    }

    @JsonIgnore
    public boolean isVmNameSet() {
        return isSet.contains("vmName");
    }

}
