package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class Placement {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String> isSet;
    private String azName;
    private List<String> subnetIds;
    private String placementGroupName;
    //endregion

    //region Constructors
    private Placement() {
        isSet = new HashSet<>();
    }

    public Placement(String azName, List<String> subnetIds) {
        this.setAzName(azName);
        this.setSubnetIds(subnetIds);
    }

    public Placement(String azName, String subnetId) {
        this.setAzName(azName);
        this.setSubnetIds(Arrays.asList(subnetId));
    }

    public Placement(Placement src) {
        if (src != null) {
            this.azName = src.azName;

            if (src.subnetIds != null) {
                this.subnetIds = src.subnetIds.stream().map(String::new).collect(Collectors.toList());
            }
        }
    }
    //endregion

    //region Getters & Setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getAzName() {
        return azName;
    }

    public void setAzName(String azName) {
        isSet.add("azName");
        this.azName = azName;
    }


    public List<String> getSubnetIds() {
        return subnetIds;
    }

    public void setSubnetIds(List<String> subnetIds) {
        isSet.add("subnetIds");
        this.subnetIds = subnetIds;
    }

    public String getPlacementGroupName() {
        return placementGroupName;
    }

    public void setPlacementGroupName(String placementGroupName) {
        isSet.add("placementGroupName");
        this.placementGroupName = placementGroupName;
    }
    //endregion

    //region Object overrides

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Placement that = (Placement) o;

        if (!Objects.equals(azName, that.azName)) return false;
        return Objects.equals(subnetIds, that.subnetIds);

    }

    @Override
    public int hashCode() {
        int result = azName != null ? azName.hashCode() : 0;
        result = 31 * result + (subnetIds != null ? subnetIds.hashCode() : 0);
        return result;
    }

    //endregion

    //region isSet methods
    // Is azName Set boolean method
    @JsonIgnore
    public boolean isAzNameSet() {
        return isSet.contains("azName");
    }

    // Is subnetIds Set boolean method
    @JsonIgnore
    public boolean isSubnetIdsSet() {
        return isSet.contains("subnetIds");
    }

    // Is subnetIds Set boolean method
    @JsonIgnore
    public boolean isPlacementGroupNamesSet() {
        return isSet.contains("placementGroupName");
    }

    //endregion

    //region Builder class
    public static class Builder {
        private Placement placement;

        private Builder() {
            this.placement = new Placement();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setSubnetIds(final List<String> subnetIds) {
            placement.setSubnetIds(subnetIds);
            return this;
        }

        public Builder setAvailabilityZoneName(final String azName) {
            placement.setAzName(azName);
            return this;
        }

        public Builder setPlacementGroupName(final String placementGroupName) {
            placement.setPlacementGroupName(placementGroupName);
            return this;
        }

        public Placement build() {
            // TODO : Validations
            return placement;
        }
    }

    //endregion
}
