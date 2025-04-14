package com.spotinst.sdkjava.model.api.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.ApiAutoScale;
import com.spotinst.sdkjava.model.ElastigroupAutoScaleSpecification;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiNomad implements IPartialUpdateEntity {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String>                 isSet;
    private String                                   aclToken;
    private List<ApiAutoScale>                       autoScale;
    private String                                   masterHost;
    private Integer                                  masterPort;
    private ApiTlsConfig                             tlsConfig;
    //endregion

    //region Constructor

    public ApiNomad() {
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

    public List<ApiAutoScale> getAutoScale() {
        return autoScale;
    }

    public void setAutoScale(List<ApiAutoScale> autoScale) {
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

    public ApiTlsConfig getTlsConfig() {
        return tlsConfig;
    }

    public void setTlsConfig(ApiTlsConfig tlsConfig) {
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
