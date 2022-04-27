package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.azure.statefulNode.AzureStatefulNodeDiskTypeEnum;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecOsDiskSpecification {
    @JsonIgnore
    private Set<String>                     isSet;
    private Integer                         sizeGB;
    private AzureStatefulNodeDiskTypeEnum type;

    public LaunchSpecOsDiskSpecification() {
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

    public AzureStatefulNodeDiskTypeEnum getType() {
        return type;
    }

    public void setType(AzureStatefulNodeDiskTypeEnum type) {
        isSet.add("type");
        this.type = type;
    }

    public static class Builder {
        private LaunchSpecOsDiskSpecification osDiskSpecification;

        private Builder() {
            this.osDiskSpecification = new LaunchSpecOsDiskSpecification();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setSizeGB(final Integer sizeGB) {
            osDiskSpecification.setSizeGB(sizeGB);
            return this;
        }

        public Builder setType(final AzureStatefulNodeDiskTypeEnum type) {
            osDiskSpecification.setType(type);
            return this;
        }

        public LaunchSpecOsDiskSpecification build() {
            return osDiskSpecification;
        }
    }

    @JsonIgnore
    public boolean isSetSizeGBSet() { return isSet.contains("sizeGB"); }

    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }

}
