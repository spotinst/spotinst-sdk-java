package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecOsDiskSpecification {
    @JsonIgnore
    private Set<String> isSet;
    private String      name;
    private Integer     sizeGB;
    private String      type;

    public LaunchSpecOsDiskSpecification() {
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

        public Builder setName(final String name) {
            osDiskSpecification.setName(name);
            return this;
        }

        public Builder setType(final String type) {
            osDiskSpecification.setType(type);
            return this;
        }

        public LaunchSpecOsDiskSpecification build() {
            return osDiskSpecification;
        }
    }

    @JsonIgnore
    public boolean isSetSizeGBSet() {
        return isSet.contains("setSizeGB");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }

}
