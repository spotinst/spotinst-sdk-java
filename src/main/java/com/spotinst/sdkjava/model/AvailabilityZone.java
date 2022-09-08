package com.spotinst.sdkjava.model;

public class AvailabilityZone {
    //region Members
    private String name;
    private String subnetId;
    // endregion

    //region Constructor
    private AvailabilityZone() { }
    // endregion

    // region methods
    // region name
    public String getName(){ return name; }

    public void setName(String name) {
        this.name = name;
    }
    // endregion

    // region subnetId
    public String getSubnetId(){ return subnetId; }

    public void setSubnetId(String subnetId) {
        this.subnetId = subnetId;
    }
    // endregion
    // endregion

    public static class Builder {
        private AvailabilityZone availabilityZone;

        private Builder(){ this.availabilityZone = new AvailabilityZone(); }

        public static Builder get(){
            return new Builder();
        }

        // region build methods
        public Builder setName(final String name){
            availabilityZone.setName(name);
            return this;
        }
        public Builder setSubnetId(final String subnetId){
            availabilityZone.setSubnetId(subnetId);
            return this;
        }

        public AvailabilityZone build(){
            return availabilityZone;
        }
        // endregion
    }
}
