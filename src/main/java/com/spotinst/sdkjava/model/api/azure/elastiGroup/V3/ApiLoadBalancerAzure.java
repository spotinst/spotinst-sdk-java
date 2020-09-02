package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yossi.elman on 12/03/20.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiLoadBalancerAzure implements IPartialUpdateEntity {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String> isSet = new HashSet<>();
    private String      name;
    private String      arn;
    private String      type;
    //endregion

    //region Getters & Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    public String getArn() {
        return arn;
    }

    public void setArn(String arn) {
        isSet.add("arn");
        this.arn = arn;
    }

    @JsonIgnore
    public boolean isArnSet() {
        return isSet.contains("arn");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        isSet.add("type");
        this.type = type;
    }

    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }

    @Override
    public Set<String> getIsSet() {
        return isSet;
    }
    //endregion
}
