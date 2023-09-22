package com.spotinst.sdkjava.model.api.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiTlsConfig implements IPartialUpdateEntity {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String>                              isSet;
    private String                                   certificate;
    private String                                   privateKey;
    private String                                   tlsEnabled;
    //endregion

    //region Constructor

    public ApiTlsConfig() {
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
