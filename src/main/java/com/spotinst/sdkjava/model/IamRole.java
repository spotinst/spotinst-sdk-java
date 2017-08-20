package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aharontwizer on 8/25/15.
 */
public class IamRole {

    // Partial Update support
    @JsonIgnore
    private Set<String> isSet;
    private String name;
    private String arn;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getArn() {
        return arn;
    }

    public void setArn(String arn) {
        isSet.add("arn");
        this.arn = arn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IamRole iamRole = (IamRole) o;

        if (name != null ? !name.equals(iamRole.name) : iamRole.name != null) return false;
        return !(arn != null ? !arn.equals(iamRole.arn) : iamRole.arn != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (arn != null ? arn.hashCode() : 0);
        return result;
    }
    //region Builder class
    public static class Builder {
        private IamRole iamRole;

        private Builder() {
            this.iamRole = new IamRole();
        }

        public static Builder get(){
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
    // Is name Set boolean method
    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    // Is arn Set boolean method
    @JsonIgnore
    public boolean isArnSet() {
        return isSet.contains("arn");
    }

    //endregion
}
