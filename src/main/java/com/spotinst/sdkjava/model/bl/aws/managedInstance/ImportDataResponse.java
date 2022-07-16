package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ImportDataResponse {

    @JsonIgnore
    private Set<String> isSet;
    private String      originalInstanceId;
    private Boolean     shouldKeepPrivateIp;

    private ImportDataResponse() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getOriginalInstanceId() {
        return originalInstanceId;
    }

    public void setOriginalInstanceId(String originalInstanceId) {
        isSet.add("originalInstanceId");
        this.originalInstanceId = originalInstanceId;
    }

    public Boolean getShouldKeepPrivateIp() {
        return shouldKeepPrivateIp;
    }

    public void setShouldKeepPrivateIp(Boolean shouldKeepPrivateIp) {
        isSet.add("shouldKeepPrivateIp");
        this.shouldKeepPrivateIp = shouldKeepPrivateIp;
    }


    public static class Builder {
        private ImportDataResponse importDataBuilder;

        private Builder() {
            this.importDataBuilder = new ImportDataResponse();
        }

        public Builder setOriginalInstanceId(final String originalInstanceId) {
            importDataBuilder.setOriginalInstanceId(originalInstanceId);
            return this;
        }

        public Builder setShouldKeepPrivateIp(final Boolean shouldKeepPrivateIp) {
            importDataBuilder.setShouldKeepPrivateIp(shouldKeepPrivateIp);
            return this;
        }


        public static Builder get() {
            return new Builder();
        }

        public ImportDataResponse build() {
            return importDataBuilder;
        }
    }

    @JsonIgnore
    public boolean isOriginalInstanceIdSet() {
        return isSet.contains("originalInstanceId");
    }

    @JsonIgnore
    public boolean isShouldKeepPrivateIpSet() {
        return isSet.contains("shouldKeepPrivateIp");
    }

}
