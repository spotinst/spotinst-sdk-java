package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.ProcessNameEnumsAzure;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResumeGroupProcessesAzure {

    @JsonIgnore
    private Set<String> isSet;
    private ProcessNameEnumsAzure name;

    private ResumeGroupProcessesAzure() {
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

    public static class Builder {
        private ResumeGroupProcessesAzure resumeGroupProcesses;

        private Builder() {
            this.resumeGroupProcesses = new ResumeGroupProcessesAzure();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final ProcessNameEnumsAzure name) {
            resumeGroupProcesses.setName(name);
            return this;
        }

        public ResumeGroupProcessesAzure build() {
            return resumeGroupProcesses;
        }

    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

}
