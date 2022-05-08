package com.spotinst.sdkjava.model.bl.admin.organization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.admin.organization.PolicyTypeEnum;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Policy {
    @JsonIgnore
    private Set<String>    isSet;
    private String         id;
    private String         name;
    private String         description;
    private PolicyTypeEnum type;
    private PolicyContent  policyContent;
    private Date           createdAt;
    private Date           updatedAt;


    public Policy() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        isSet.add("description");
        this.description = description;
    }

    public PolicyTypeEnum getType() {
        return type;
    }

    public void setType(PolicyTypeEnum type) {
        isSet.add("type");
        this.type = type;
    }

    public PolicyContent getPolicyContent() {
        return policyContent;
    }

    public void setPolicyContent(PolicyContent policyContent) {
        isSet.add("policyContent");
        this.policyContent = policyContent;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        isSet.add("updatedAt");
        this.updatedAt = updatedAt;
    }

    public static class Builder {
        private Policy policy;

        private Builder() {
            this.policy = new Policy();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setId(final String id) {
            policy.setId(id);
            return this;
        }

        public Builder setName(final String name) {
            policy.setName(name);
            return this;
        }

        public Builder setDescription(final String description) {
            policy.setDescription(description);
            return this;
        }

        public Builder setType(final PolicyTypeEnum type) {
            policy.setType(type);
            return this;
        }

        public Builder setPolicyContent(final PolicyContent content) {
            policy.setPolicyContent(content);
            return this;
        }

        public Builder setCreatedAt(final Date createdAt) {
            policy.setCreatedAt(createdAt);
            return this;
        }

        public Builder setUpdatedAt(final Date updatedAt) {
            policy.setUpdatedAt(updatedAt);
            return this;
        }
        public Policy build() {
            return policy;
        }

    }

    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isDescriptionSet() {
        return isSet.contains("description");
    }

    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }

    @JsonIgnore
    public boolean isPolicyContentSet() {
        return isSet.contains("policyContent");
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