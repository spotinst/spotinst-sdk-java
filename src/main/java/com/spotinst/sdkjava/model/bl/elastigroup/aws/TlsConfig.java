package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.model.ElastigroupAutoScaleSpecification;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TlsConfig {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String>                              isSet;
    private String                                   certificate;
    private String                                   privateKey;
    private String                                   tlsEnabled;
    //endregion

    //region Constructor

    private TlsConfig() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters


    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        isSet.add("certificate");
        this.certificate = certificate;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        isSet.add("privateKey");
        this.privateKey = privateKey;
    }

    public String getTlsEnabled() {
        return tlsEnabled;
    }

    public void setTlsEnabled(String tlsEnabled) {
        isSet.add("tlsEnabled");
        this.tlsEnabled = tlsEnabled;
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
        private TlsConfig tlsConfig;

        private Builder() {
            this.tlsConfig = new TlsConfig();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setCertificate(final String certificate) {
            tlsConfig.setCertificate(certificate);
            return this;
        }

        public Builder setPrivateKey(final String privateKey) {
            tlsConfig.setPrivateKey(privateKey);
            return this;
        }

        public Builder setTlsEnabled(final String tlsEnabled) {
            tlsConfig.setTlsEnabled(tlsEnabled);
            return this;
        }
        public TlsConfig build() {
            return tlsConfig;
        }
    }
    //endregion

    //region isSet methods
    // Is certificate Set boolean method
    @JsonIgnore
    public boolean isCertificateSet() {
        return isSet.contains("certificate");
    }
    // Is privateKey Set boolean method
    @JsonIgnore
    public boolean isPrivateKeySet() {
        return isSet.contains("privateKey");
    }
    // Is tlsEnabled Set boolean method
    @JsonIgnore
    public boolean isTlsEnabledSet() {
        return isSet.contains("tlsEnabled");
    }

    //endregion
}
