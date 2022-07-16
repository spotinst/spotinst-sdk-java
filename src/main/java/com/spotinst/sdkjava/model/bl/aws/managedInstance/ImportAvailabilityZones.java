package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ImportAvailabilityZones {

    @JsonIgnore
    private Set<String>  isSet;
    private String       name;
    private List<String> subnetIds;

    private ImportAvailabilityZones() {
        isSet = new HashSet<>();
    }

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

    public List<String> getSubnetIds() {
        return subnetIds;
    }

    public void setSubnetIds(List<String> subnetIds) {
        isSet.add("subnetIds");
        this.subnetIds = subnetIds;
    }

    public static class Builder {
        private ImportAvailabilityZones ImportAvailabilityZonesBuilder;

        private Builder() {
            this.ImportAvailabilityZonesBuilder = new ImportAvailabilityZones();
        }

        public Builder setName(final String name) {
            ImportAvailabilityZonesBuilder.setName(name);
            return this;
        }

        public Builder setSubnetIds(final List<String> subnetIds) {
            ImportAvailabilityZonesBuilder.setSubnetIds(subnetIds);
            return this;
        }

        public static Builder get() {
            return new Builder();
        }

        public ImportAvailabilityZones build() {
            return ImportAvailabilityZonesBuilder;
        }
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
