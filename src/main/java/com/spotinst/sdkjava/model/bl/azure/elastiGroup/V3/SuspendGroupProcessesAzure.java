package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.ProcessNameEnumsAzure;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuspendGroupProcessesAzure{

    @JsonIgnore
    private Set<String>           isSet;
    private ProcessNameEnumsAzure name;
    private Integer               ttlInMinutes;

    private SuspendGroupProcessesAzure() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ProcessNameEnumsAzure getName() {
        return name;
    }

    public void setName(ProcessNameEnumsAzure name) {
        isSet.add("name");
        this.name = name;
    }

    public Integer getTtlInMinutes() {
        return ttlInMinutes;
    }

    public void setTtlInMinutes(Integer ttlInMinutes) {
        isSet.add("ttlInMinutes");
        this.ttlInMinutes = ttlInMinutes;
    }

    public static class Builder {
        private SuspendGroupProcessesAzure suspendGroupProcesses;

        private Builder() {
            this.suspendGroupProcesses = new SuspendGroupProcessesAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setName(final ProcessNameEnumsAzure name) {
            suspendGroupProcesses.setName(name);
            return this;
        }

        public Builder setTtlInMinutes(final Integer ttlInMinutes) {
            suspendGroupProcesses.setTtlInMinutes(ttlInMinutes);
            return this;
        }

        public SuspendGroupProcessesAzure build() {
            return suspendGroupProcesses;
        }

    }


    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isTtlInMinutesSet() {
        return isSet.contains("ttlInMinutes");
    }

}
