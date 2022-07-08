package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImportClusterOsDiskAks {
    @JsonIgnore
    private Set<String>                         isSet;
    private Integer                             sizeGB;
    private String                              type;


    private ImportClusterOsDiskAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getSizeGB() {
        return sizeGB;
    }

    public void setSizeGB(Integer sizeGB) {
        isSet.add("sizeGB");
        this.sizeGB = sizeGB;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        isSet.add("type");
        this.type = type;
    }

    public static class Builder {

        private ImportClusterOsDiskAks clusterOsDiskAks;
        private Builder() {
            this.clusterOsDiskAks = new ImportClusterOsDiskAks();
        }

        public static ImportClusterOsDiskAks.Builder get() {
            return new Builder();
        }

        public ImportClusterOsDiskAks.Builder setSizeGB(final Integer sizeGB) {
            clusterOsDiskAks.setSizeGB(sizeGB);
            return this;
        }

        public Builder setType(final String type){
            clusterOsDiskAks.setType(type);
            return this;
        }

        public ImportClusterOsDiskAks build() {
            return clusterOsDiskAks;
        }
    }

    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }

    @JsonIgnore
    public boolean isSizeGBSet() {
        return isSet.contains("sizeGB");
    }

}
