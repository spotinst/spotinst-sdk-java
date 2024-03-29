package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.azure.statefulNode.AzureStatefulNodeDiskTypeEnum;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecDataDisksSpecification {
    @JsonIgnore
    private Set<String>                     isSet;
    private Integer                         sizeGB;
    private Integer                         lun;
    private AzureStatefulNodeDiskTypeEnum   type;

    public LaunchSpecDataDisksSpecification() {
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

    public Integer getLun() {
        return lun;
    }

    public void setLun(Integer lun) {
        isSet.add("lun");
        this.lun = lun;
    }

    public AzureStatefulNodeDiskTypeEnum getType() {
        return type;
    }

    public void setType(AzureStatefulNodeDiskTypeEnum type) {
        isSet.add("type");
        this.type = type;
    }

    public static class Builder {
        private LaunchSpecDataDisksSpecification dataDisksSpecification;

        private Builder() {
            this.dataDisksSpecification = new LaunchSpecDataDisksSpecification();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setSizeGB(final Integer sizeGB) {
            dataDisksSpecification.setSizeGB(sizeGB);
            return this;
        }

        public Builder setLun(final Integer lun) {
            dataDisksSpecification.setLun(lun);
            return this;
        }

        public Builder setType(final AzureStatefulNodeDiskTypeEnum type) {
            dataDisksSpecification.setType(type);
            return this;
        }

        public LaunchSpecDataDisksSpecification build() {
            return dataDisksSpecification;
        }
    }

    @JsonIgnore
    public boolean isSetSizeGBSet() {
        return isSet.contains("sizeGB");
    }

    @JsonIgnore
    public boolean isLunSet() {
        return isSet.contains("lun");
    }

    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }

}
