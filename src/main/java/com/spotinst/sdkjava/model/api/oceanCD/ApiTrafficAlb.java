package com.spotinst.sdkjava.model.api.oceanCD;

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
public class ApiTrafficAlb implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     ingress;
    private Integer                    servicePort;
    private String                     rootService;
    private String                     annotationPrefix;
    private ApiAlbStickinessConfig stickinessConfig;

    public ApiTrafficAlb() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getIngress() {
        return ingress;
    }

    public void setIngress(String ingress) {
        isSet.add("ingress");
        this.ingress = ingress;
    }

    public Integer getServicePort() {
        return servicePort;
    }

    public void setServicePort(Integer servicePort) {
        isSet.add("servicePort");
        this.servicePort = servicePort;
    }

    public String getRootService() {
        return rootService;
    }

    public void setRootService(String rootService) {
        isSet.add("rootService");
        this.rootService = rootService;
    }

    public String getAnnotationPrefix() {
        return annotationPrefix;
    }

    public void setAnnotationPrefix(String annotationPrefix) {
        isSet.add("annotationPrefix");
        this.annotationPrefix = annotationPrefix;
    }

    public ApiAlbStickinessConfig getStickinessConfig() {
        return stickinessConfig;
    }

    public void setStickinessConfig(ApiAlbStickinessConfig stickinessConfig) {
        isSet.add("stickinessConfig");
        this.stickinessConfig = stickinessConfig;
    }

    @JsonIgnore
    public boolean isIngressSet() {
        return isSet.contains("ingress");
    }

    @JsonIgnore
    public boolean isServicePortSet() {
        return isSet.contains("servicePort");
    }

    @JsonIgnore
    public boolean isRootServiceSet() {
        return isSet.contains("rootService");
    }

    @JsonIgnore
    public boolean isStickinessConfigSet() {
        return isSet.contains("stickinessConfig");
    }

    @JsonIgnore
    public boolean isAnnotationPrefixSet() {
        return isSet.contains("annotationPrefix");
    }
}