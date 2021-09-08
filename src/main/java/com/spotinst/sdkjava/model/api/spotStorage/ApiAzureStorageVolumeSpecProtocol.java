package com.spotinst.sdkjava.model.api.spotStorage;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiAzureStorageVolumeSpecProtocol implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                                   isSet;
    private List<String>                                  types;
    private String                                        mountPath;
    private ApiAzureStorageVolumeSpecProtocolExportPolicy exportPolicy;
    private Boolean                                       kerberosEnabled;
    private String                                        securityStyle;
    //endregion

    //region Constructor
    public ApiAzureStorageVolumeSpecProtocol() {
        isSet = new HashSet<>();
    }
    //endregion

    //region getters &setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        isSet.add("types");
        this.types = types;
    }

    public String getMountPath() {
        return mountPath;
    }

    public void setMountPath(String mountPath) {
        isSet.add("mountPath");
        this.mountPath = mountPath;
    }

    public ApiAzureStorageVolumeSpecProtocolExportPolicy getExportPolicy() {
        return exportPolicy;
    }

    public void setExportPolicy(ApiAzureStorageVolumeSpecProtocolExportPolicy exportPolicy) {
        isSet.add("exportPolicy");
        this.exportPolicy = exportPolicy;
    }

    public Boolean getKerberosEnabled() {
        return kerberosEnabled;
    }

    public void setKerberosEnabled(Boolean kerberosEnabled) {
        isSet.add("kerberosEnabled");
        this.kerberosEnabled = kerberosEnabled;
    }

    public String getSecurityStyle() {
        return securityStyle;
    }

    public void setSecurityStyle(String securityStyle) {
        isSet.add("securityStyle");
        this.securityStyle = securityStyle;
    }
    //end region

    //region isSet methods
    // Is types Set boolean method
    @JsonIgnore
    public boolean isTypesSet() {
        return isSet.contains("types");
    }

    // Is mountPath Set boolean method
    @JsonIgnore
    public boolean isMountPathSet() {
        return isSet.contains("mountPath");
    }

    // Is exportPolicy Set boolean method
    @JsonIgnore
    public boolean isExportPolicySet() {
        return isSet.contains("exportPolicy");
    }

    // Is kerberosEnabled Set boolean method
    @JsonIgnore
    public boolean isKerberosEnabledSet() {
        return isSet.contains("kerberosEnabled");
    }

    // Is securityStyle Set boolean method
    @JsonIgnore
    public boolean isSecurityStyleSet() {
        return isSet.contains("securityStyle");
    }
    //endregion
}
