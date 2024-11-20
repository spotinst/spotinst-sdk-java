package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupCustomInstanceTypesGcp {

    @JsonIgnore
    private Set<String>     isSet;
    private Integer         memoryGiB;
    private Integer         vCPU;

    private ElastigroupCustomInstanceTypesGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getMemoryGiB() {
        return memoryGiB;
    }

    public void setMemoryGiB(Integer memoryGiB) {
        isSet.add("memoryGiB");
        this.memoryGiB = memoryGiB;
    }

    public Integer getVCPU() {
        return vCPU;
    }

    public void setVCPU(Integer vCPU) {
        isSet.add("vCPU");
        this.vCPU = vCPU;
    }

    public static class Builder {
        private ElastigroupCustomInstanceTypesGcp customInstanceTypesGcp;

        private Builder() {
            this.customInstanceTypesGcp = new ElastigroupCustomInstanceTypesGcp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setMemoryGiB(final Integer memoryGiB) {
            customInstanceTypesGcp.setMemoryGiB(memoryGiB);
            return this;
        }

        public Builder setVCPU(final Integer vCPU) {
            customInstanceTypesGcp.setVCPU(vCPU);
            return this;
        }

        public ElastigroupCustomInstanceTypesGcp build() {
            return customInstanceTypesGcp;
        }
    }

    @JsonIgnore
    public boolean isMemoryGiBSet() {
        return isSet.contains("memoryGiB");
    }

    @JsonIgnore
    public boolean isVCPUSet() { return isSet.contains("vCPU"); }
}
