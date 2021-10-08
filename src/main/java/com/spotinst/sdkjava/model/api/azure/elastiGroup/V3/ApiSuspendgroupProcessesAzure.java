package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.enums.ProcessNameEnumsAzure;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiSuspendgroupProcessesAzure implements IPartialUpdateEntity {

        @JsonIgnore
        private Set<String> isSet;
        private ProcessNameEnumsAzure name;
        private Integer               ttlInMinutes;

        public ApiSuspendgroupProcessesAzure() {
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


        @JsonIgnore
        public boolean isNameSet() {
            return isSet.contains("name");
        }

        @JsonIgnore
        public boolean isTtlInMinutesSet() {
            return isSet.contains("ttlInMinutes");
        }

}
