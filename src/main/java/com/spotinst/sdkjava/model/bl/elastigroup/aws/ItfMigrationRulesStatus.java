package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItfMigrationRulesStatus {
    @JsonIgnore
    private Set<String> isSet;
    private String id;
    private String groupId;
    private String ruleArn;
    private String status;
    private String createdAt;
    private String updatedAt;

    private ItfMigrationRulesStatus() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        isSet.add("groupId");
        this.groupId = groupId;
    }

    public String getRuleArn() {
        return ruleArn;
    }

    public void setRuleArn(String ruleArn) {
        isSet.add("ruleArn");
        this.ruleArn = ruleArn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        isSet.add("status");
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        isSet.add("updatedAt");
        this.updatedAt = updatedAt;
    }

    public static class Builder {

        private ItfMigrationRulesStatus itfMigrationRulesStatus;

        private Builder() {
            this.itfMigrationRulesStatus = new ItfMigrationRulesStatus();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setId(final String id) {
            itfMigrationRulesStatus.setId(id);
            return this;
        }

        public Builder setGroupId(final String groupId) {
            itfMigrationRulesStatus.setGroupId(groupId);
            return this;
        }

        public Builder setRuleArn(final String ruleArn) {
            itfMigrationRulesStatus.setRuleArn(ruleArn);
            return this;
        }

        public Builder setStatus(final String status) {
            itfMigrationRulesStatus.setStatus(status);
            return this;
        }

        public Builder setCreatedAt(final String createdAt) {
            itfMigrationRulesStatus.setCreatedAt(createdAt);
            return this;
        }

        public Builder setUpdatedAt(final String updatedAt) {
            itfMigrationRulesStatus.setUpdatedAt(updatedAt);
            return this;
        }

        public ItfMigrationRulesStatus build() {
            return itfMigrationRulesStatus;
        }
    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isGroupIdSet() {
        return isSet.contains("groupId");
    }

    @JsonIgnore
    public boolean isRuleArnSet() {
        return isSet.contains("ruleArn");
    }

    @JsonIgnore
    public boolean isStatusSet() {
        return isSet.contains("status");
    }

    @JsonIgnore
    public boolean isCreatedAtSet() {
        return isSet.contains("createdAt");
    }

    @JsonIgnore
    public boolean isUpdatedAtSet() {
        return isSet.contains("updatedAt");
    }
}
