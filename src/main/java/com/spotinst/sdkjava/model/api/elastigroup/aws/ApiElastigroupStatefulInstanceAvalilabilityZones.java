package com.spotinst.sdkjava.model.api.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiElastigroupStatefulInstanceAvalilabilityZones implements IPartialUpdateEntity {
    //region Members
    private Set<String>  isSet;
    private String       name;
    private List<String> subnetIds;
    // endregion

    //region Constructor
    private ApiElastigroupStatefulInstanceAvalilabilityZones() { }
    // endregion

    // region methods
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }
    // region name
    public String getName(){ return name; }

    public void setName(String name) {
        this.name = name;
    }
    // endregion

    // region subnetId
    public List<String> getSubnetIds(){ return subnetIds; }

    public void setSubnetIds(List<String> subnetIds) {
        this.subnetIds = subnetIds;
    }
    // endregion

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isSubnetIdsSet() {
        return isSet.contains("subnetIds");
    }
}
