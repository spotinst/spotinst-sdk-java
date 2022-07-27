package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Set;

public class ElastigroupStatefulInstanceAvalilabilityZones {
    //region Members
    private Set<String>  isSet;
    private String       name;
    private List<String> subnetIds;
    // endregion

    //region Constructor
    private ElastigroupStatefulInstanceAvalilabilityZones() { }
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
    // endregion

    public static class Builder {
        private ElastigroupStatefulInstanceAvalilabilityZones availabilityZone;

        private Builder(){ this.availabilityZone = new ElastigroupStatefulInstanceAvalilabilityZones(); }

        public static Builder get(){
            return new Builder();
        }

        // region build methods
        public Builder setName(final String name){
            availabilityZone.setName(name);
            return this;
        }
        public Builder setSubnetIds(final List<String> subnetIds){
            availabilityZone.setSubnetIds(subnetIds);
            return this;
        }

        public ElastigroupStatefulInstanceAvalilabilityZones build(){
            return availabilityZone;
        }
        // endregion
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isSubnetIdsSet() {
        return isSet.contains("subnetIds");
    }
}
