package com.spotinst.sdkjava.model.bl.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

public class OceanGKEStrategy {

    private int preemptiblePercentage;
    private Set<String> isSet;



    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public int getPreemptiblePercentage() {
        return preemptiblePercentage;
    }

    public void setPreemptiblePercentage(int preemptiblePercentage) {
        isSet.add("preemptiblePercentage");
        this.preemptiblePercentage = preemptiblePercentage;
    }

    public static class Builder {
        private OceanGKEStrategy gkeStartergy;

        private Builder() {
            this.gkeStartergy = new OceanGKEStrategy();
        }

        public static OceanGKEShieldedInstanceConfig.Builder get() {
            OceanGKEStrategy.Builder builder = new OceanGKEStrategy.Builder();
            return builder;
        }

        public OceanGKEStrategy.Builder setEnableSecureBoot(final boolean enableSecureBoot) {
            gkeStartergy.setEnableSecureBoot(enableSecureBoot);
            return this;
        }

        public OceanGKEStrategy.Builder setEnableIntegrityMonitoring(final boolean enableIntegrityMonitoring) {
            gkeStartergy.setEnableIntegrityMonitoring(enableIntegrityMonitoring);
            return this;
        }


        public OceanGKEStrategy build() {
            return gkeStartergy;
        }
    }


    @JsonIgnore
    public boolean isEnableSecureBootSet() {
        return isSet.contains("enableSecureBoot");
    }



}
