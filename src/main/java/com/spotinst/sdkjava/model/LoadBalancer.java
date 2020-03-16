package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.LbTypeEnum;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yossi.elman on 12/03/20.
 */
public class LoadBalancer {
    // region Members
    @JsonIgnore
    private Set<String> isSet = new HashSet<>();
    private String      name;
    private String      arn;
    private LbTypeEnum  type;
    //endregion

    //region Getters & Setters

    @JsonIgnore
    public String getResourceName() {
        String retval;

        // if the type is target-group and arn is set, get the name from the arn
        if (type.equals(LbTypeEnum.TARGET_GROUP) && arn != null) {
            retval = arn.split("/")[1];
        }
        else {
            retval = this.name;
        }

        return retval;
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

    public LbTypeEnum getType() {
        return type;
    }

    public void setType(LbTypeEnum type) {
        isSet.add("type");
        this.type = type;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private LoadBalancer loadBalancer;

        private Builder() {
            this.loadBalancer = new LoadBalancer();
        }

        public static LoadBalancer.Builder get() {
            LoadBalancer.Builder builder = new LoadBalancer.Builder();
            return builder;
        }

        public LoadBalancer.Builder setName(final String name) {
            loadBalancer.setName(name);
            return this;
        }

        public LoadBalancer.Builder setArn(final String arn) {
            loadBalancer.setArn(arn);
            return this;
        }

        public LoadBalancer.Builder setType(final LbTypeEnum type) {
            loadBalancer.setType(type);
            return this;
        }

        public LoadBalancer build() {
            // TODO : Validations
            return loadBalancer;
        }
    }
    //endregion

    //region isSet Methods
    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isArnSet() {
        return isSet.contains("arn");
    }

    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }
    //endregion
}
