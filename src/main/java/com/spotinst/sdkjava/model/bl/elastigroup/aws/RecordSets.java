package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.aws.elastigroup.Route53RecordSetType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecordSets {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String>                 isSet;
    private String               name;
    private boolean              usePublicDns;
    private boolean              usePublicIp;
    //endregion

    //region Constructor

    private RecordSets() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public boolean isUsePublicDns() {
        return usePublicDns;
    }

    public void setUsePublicDns(boolean usePublicDns) {
        isSet.add("usePublicDns");
        this.usePublicDns = usePublicDns;
    }

    public boolean isUsePublicIp() {
        return usePublicIp;
    }

    public void setUsePublicIp(boolean usePublicIp) {
        isSet.add("usePublicIp");
        this.usePublicIp = usePublicIp;
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    //endregion
    //region Builder class
    public static class Builder {
        private RecordSets recordSets;

        private Builder() {
            this.recordSets = new RecordSets();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            recordSets.setName(name);
            return this;
        }

        public Builder setUsePublicDns(final boolean usePublicDns) {
            recordSets.setUsePublicDns(usePublicDns);
            return this;
        }

        public Builder  setUsePublicIp(final boolean usePublicIp) {
            recordSets.setUsePublicIp(usePublicIp);
            return this;
        }

        public RecordSets build() {
            return recordSets;
        }
    }
    //endregion

    //region isSet methods
    // Is name Set boolean method
    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    // Is usePublicDns Set boolean method
    @JsonIgnore
    public boolean isUsePublicDnsSet() {
        return isSet.contains("usePublicDns");
    }

    // Is usePublicIp Set boolean method
    @JsonIgnore
    public boolean isUsePublicIpSet() {
        return isSet.contains("usePublicIp");
    }
    //endregion
}
