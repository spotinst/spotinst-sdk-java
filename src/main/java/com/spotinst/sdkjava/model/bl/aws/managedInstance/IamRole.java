package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class IamRole implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String> isSet;
    private String      arn;
    private String      name;

    private IamRole() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getArn() {
        return arn;
    }

    public void setArn(String arn) {
        isSet.add("arn");
        this.arn = arn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public static class Builder {
        private IamRole iamRole;

        private Builder() {
            this.iamRole = new IamRole();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setArn(final String arn) {
            iamRole.setArn(arn);
            return this;
        }

        public Builder setName(final String name) {
            iamRole.setName(name);
            return this;
        }

        public IamRole build() {
            return iamRole;
        }
    }

    @JsonIgnore
    public boolean isArnSet() {
        return isSet.contains("arn");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }
}
