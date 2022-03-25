package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ClusterVngOsDisk {

    @JsonIgnore
    private Set<String> isSet;
    private String      type;
    private Integer     sizeGB;
    private Boolean     utilizeEphemeralStorage;

    private ClusterVngOsDisk() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        isSet.add("type");
        this.type = type;
    }

    public Integer getSizeGB() {
        return sizeGB;
    }

    public void setSizeGB(Integer sizeGB) {
        isSet.add("sizeGB");
        this.sizeGB = sizeGB;
    }

    public Boolean getUtilizeEphemeralStorage() {
        return utilizeEphemeralStorage;
    }

    public void setUtilizeEphemeralStorage(Boolean utilizeEphemeralStorage) {
        isSet.add("utilizeEphemeralStorage");
        this.utilizeEphemeralStorage = utilizeEphemeralStorage;
    }

    public static class Builder {
        private ClusterVngOsDisk headroom;

        private Builder() {
            this.headroom = new ClusterVngOsDisk();
        }

        public static ClusterVngOsDisk.Builder get() {
            return new Builder();
        }

        public ClusterVngOsDisk.Builder setType(final String type) {
            headroom.setType(type);
            return this;
        }

        public ClusterVngOsDisk.Builder setSizeGB(final Integer sizeGB) {
            headroom.setSizeGB(sizeGB);
            return this;
        }

        public ClusterVngOsDisk.Builder setUtilizeEphemeralStorage(final Boolean utilizeEphemeralStorage) {
            headroom.setUtilizeEphemeralStorage(utilizeEphemeralStorage);
            return this;
        }

        public ClusterVngOsDisk build() {
            return headroom;
        }
    }

    @JsonIgnore
    public boolean isTypeSet() {return isSet.contains("type");}

    @JsonIgnore
    public boolean isSizeGBSet() {return isSet.contains("sizeGB");}

    @JsonIgnore
    public boolean isUtilizeEphemeralStorageSet() {return isSet.contains("utilizeEphemeralStorage");}

}