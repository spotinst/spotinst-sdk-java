package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetProtectedVmsReponseAzure {

    @JsonIgnore
    private Set<String> isSet;
    private String      vmName;
    private String      groupId;

    private GetProtectedVmsReponseAzure() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getVmName() {
        return vmName;
    }

    public void setVmName(String vmName) {
        isSet.add("vmName");
        this.vmName = vmName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        isSet.add("groupId");
        this.groupId = groupId;
    }

    public static class Builder {
        private GetProtectedVmsReponseAzure protectedVms;

        private Builder() {
            this.protectedVms = new GetProtectedVmsReponseAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setGroupId(final String groupId) {
            protectedVms.setGroupId(groupId);
            return this;
        }

        public Builder setVmName(final String vmName) {
            protectedVms.setVmName(vmName);
            return this;
        }

        public GetProtectedVmsReponseAzure build() {
            return protectedVms;
        }
    }

    @JsonIgnore
    public boolean isGroupIdSet() {
        return isSet.contains("groupId");
    }

    @JsonIgnore
    public boolean isVmNameSet() {
        return isSet.contains("vmName");
    }
}
