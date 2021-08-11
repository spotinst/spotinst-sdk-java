package com.spotinst.sdkjava.model.bl.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chandra on 08/06/21.
 */

public class RecordSets {

    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      name;
    private Boolean     usePublicIp;

    //endregion

    //region constructor
    private RecordSets() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Setters&Getters

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

    public Boolean getAutoWeight() {
        return usePublicIp;
    }

    public void setUsePublicIp(Boolean usePublicIp) {
        isSet.add("usePublicIp");
        this.usePublicIp = usePublicIp;
    }

    //endregion

    //region Builder class
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
            // TODO : Validations
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

    // Is usePublicIp Set boolean method
    @JsonIgnore
    public boolean isUsePublicIpSet() {
        return isSet.contains("usePublicIp");
    }
}
