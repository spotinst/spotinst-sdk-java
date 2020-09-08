package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.enums.LbTypeEnum;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yossi.elman on 12/03/20.
 */
public class LoadBalancerAzure {
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
        private LoadBalancerAzure loadBalancer;

        private Builder() {
            this.loadBalancer = new LoadBalancerAzure();
        }

        public static LoadBalancerAzure.Builder get() {
            LoadBalancerAzure.Builder builder = new LoadBalancerAzure.Builder();
            return builder;
        }

        public LoadBalancerAzure.Builder setName(final String name) {
            loadBalancer.setName(name);
            return this;
        }

        public LoadBalancerAzure.Builder setArn(final String arn) {
            loadBalancer.setArn(arn);
            return this;
        }

        public LoadBalancerAzure.Builder setType(final LbTypeEnum type) {
            loadBalancer.setType(type);
            return this;
        }

        public LoadBalancerAzure build() {
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
