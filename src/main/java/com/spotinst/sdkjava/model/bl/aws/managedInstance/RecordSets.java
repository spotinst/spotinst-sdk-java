package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecordSets {


    @JsonIgnore
    private Set<String> isSet;
    private String      name;
    private Boolean     usePublicIp;

    private RecordSets() {
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

    public Boolean getUsePublicIp() {
        return usePublicIp;
    }

    public void setUsePublicIp(Boolean usePublicIp) {
        isSet.add("usePublicIp");
        this.usePublicIp = usePublicIp;
    }

    public static class Builder {
        private RecordSets recordSets;

        private Builder() {
            this.recordSets = new RecordSets();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setName(final String name) {
            recordSets.setName(name);
            return this;
        }

        public Builder setUsePublicIp(final Boolean usePublicIp) {
            recordSets.setUsePublicIp(usePublicIp);
            return this;
        }

        public RecordSets build() {
            return recordSets;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isUsePublicIpSet() {
        return isSet.contains("usePublicIp");
    }
}
