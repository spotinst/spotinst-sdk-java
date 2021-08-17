package com.spotinst.sdkjava.model.bl.aws.managed.instance;

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

    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      arn;
    private String      name;

    //region Constructor

    private IamRole() {
        isSet = new HashSet<>();
    }
    //endregion

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

    //region Builder class
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
            // TODO : Validations
            return iamRole;
        }
    }
    //endregion

    //region isSet methods
    // Is arn Set boolean method
    @JsonIgnore
    public boolean isArnSet() {
        return isSet.contains("arn");
    }

    // Is name Set boolean method
    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    //endregion
}
