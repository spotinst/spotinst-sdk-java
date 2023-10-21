package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.model.ApiAutoScale;
import com.spotinst.sdkjava.model.ElastigroupAutoScaleSpecification;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Nomad {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String>                 isSet;
    private String                                   aclToken;
    private List<ElastigroupAutoScaleSpecification>  autoScale;
    private String                                   masterHost;
    private Integer                                  masterPort;
    private TlsConfig                                tlsConfig;
    //endregion

    //region Constructor

    private Nomad() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters


    public String getAclToken() {
        return aclToken;
    }

    public void setAclToken(String aclToken) {
        isSet.add("aclToken");
        this.aclToken = aclToken;
    }

    public List<ElastigroupAutoScaleSpecification> getAutoScale() {
        return autoScale;
    }

    public void setAutoScale(List<ElastigroupAutoScaleSpecification> autoScale) {
        isSet.add("autoScale");
        this.autoScale = autoScale;
    }

    public String getMasterHost() {
        return masterHost;
    }

    public void setMasterHost(String masterHost) {
        isSet.add("masterHost");
        this.masterHost = masterHost;
    }

    public Integer getMasterPort() {
        return masterPort;
    }

    public void setMasterPort(Integer masterPort) {
        isSet.add("masterPort");
        this.masterPort = masterPort;
    }

    public TlsConfig getTlsConfig() {
        return tlsConfig;
    }

    public void setTlsConfig(TlsConfig tlsConfig) {
        isSet.add("tlsConfig");
        this.tlsConfig = tlsConfig;
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
        private Nomad nomad;

        private Builder() {
            this.nomad = new Nomad();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setAclToken(final String aclToken) {
            nomad.setAclToken(aclToken);
            return this;
        }

        public Builder setAutoScale(final List<ElastigroupAutoScaleSpecification> autoScale) {
            nomad.setAutoScale(autoScale);
            return this;
        }

        public Builder setMasterHost(final String masterHost) {
            nomad.setMasterHost(masterHost);
            return this;
        }

        public Builder setMasterPort(final Integer masterPort) {
            nomad.setMasterPort(masterPort);
            return this;
        }

        public Builder setTlsConfig(final TlsConfig tlsConfig) {
            nomad.setTlsConfig(tlsConfig);
            return this;
        }

        public Nomad build() {
            return nomad;
        }
    }
    //endregion

    //region isSet methods
    // Is aclToken Set boolean method
    @JsonIgnore
    public boolean isAclTokenSet() {
        return isSet.contains("aclToken");
    }
    // Is autoScale Set boolean method
    @JsonIgnore
    public boolean isAutoScaleSet() {
        return isSet.contains("autoScale");
    }
    // Is masterHost Set boolean method
    @JsonIgnore
    public boolean isMasterHostSet() {
        return isSet.contains("masterHost");
    }
    // Is masterPort Set boolean method
    @JsonIgnore
    public boolean isMasterPortSet() {
        return isSet.contains("masterPort");
    }
    // Is tlsConfig Set boolean method
    @JsonIgnore
    public boolean isTlsConfigSet() {
        return isSet.contains("tlsConfig");
    }
    //endregion
}
