package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterAccessConfigsSpecification {

    @JsonIgnore
    private Set<String> isSet;
    private String      name;
    private String      type;

    private ClusterAccessConfigsSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() { return name; }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getType() { return type; }

    public void setType(String type) {
        isSet.add("type");
        this.type = type;
    }

    public static class Builder {
        private ClusterAccessConfigsSpecification accessConfigs;

        private Builder() {
            this.accessConfigs = new ClusterAccessConfigsSpecification();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }
        
        public Builder setName(final String name) {
            accessConfigs.setName(name);
            return this;
        }

        public Builder setType(final String type) {
            accessConfigs.setType(type);
            return this;
        }

        public ClusterAccessConfigsSpecification build() {
            return accessConfigs;
        }
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
