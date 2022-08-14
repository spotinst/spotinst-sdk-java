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
public class ApiRolloutSpecTraffic implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>              isSet;
    private String                   canaryService;
    private String                   stableService;
    private ApiTrafficIstio istio;
    private ApiTrafficNginx nginx;
    private ApiTrafficAlb alb;
    private ApiTrafficSmi smi;
    private ApiTrafficAmbassador ambassador;
    private ApiTrafficAppMesh appMesh;
    private ApiTrafficPingPong pingPong;

    public ApiRolloutSpecTraffic() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getCanaryService() {
        return canaryService;
    }

    public void setCanaryService(String canaryService) {
        isSet.add("canaryService");
        this.canaryService = canaryService;
    }

    public String getStableService() {
        return stableService;
    }

    public void setStableService(String stableService) {
        isSet.add("stableService");
        this.stableService = stableService;
    }

    public ApiTrafficIstio getIstio() {
        return istio;
    }

    public void setIstio(ApiTrafficIstio istio) {
        isSet.add("istio");
        this.istio = istio;
    }

    public ApiTrafficNginx getNginx() {
        return nginx;
    }

    public void setNginx(ApiTrafficNginx nginx) {
        isSet.add("nginx");
        this.nginx = nginx;
    }

    public ApiTrafficAlb getAlb() {
        return alb;
    }

    public void setAlb(ApiTrafficAlb alb) {
        isSet.add("alb");
        this.alb = alb;
    }

    public ApiTrafficSmi getSmi() {
        return smi;
    }

    public void setSmi(ApiTrafficSmi smi) {
        isSet.add("smi");
        this.smi = smi;
    }

    public ApiTrafficAmbassador getAmbassador() {
        return ambassador;
    }

    public void setAmbassador(ApiTrafficAmbassador ambassador) {
        isSet.add("ambassador");
        this.ambassador = ambassador;
    }

    public ApiTrafficAppMesh getAppMesh() {
        return appMesh;
    }

    public void setAppMesh(ApiTrafficAppMesh appMesh) {
        isSet.add("appMesh");
        this.appMesh = appMesh;
    }

    public ApiTrafficPingPong getPingPong() {
        return pingPong;
    }

    public void setPingPong(ApiTrafficPingPong pingPong) {
        isSet.add("pingPong");
        this.pingPong = pingPong;
    }

    @JsonIgnore
    public boolean isCanaryServiceSet() {
        return isSet.contains("canaryService");
    }

    @JsonIgnore
    public boolean isStableServiceSet() {
        return isSet.contains("stableService");
    }

    @JsonIgnore
    public boolean isIstioSet() {
        return isSet.contains("istio");
    }

    @JsonIgnore
    public boolean isNginxSet() {
        return isSet.contains("nginx");
    }

    @JsonIgnore
    public boolean isAlbSet() {
        return isSet.contains("alb");
    }

    @JsonIgnore
    public boolean isSmiSet() {
        return isSet.contains("smi");
    }

    @JsonIgnore
    public boolean isAmbassadorSet() {
        return isSet.contains("ambassador");
    }

    @JsonIgnore
    public boolean isAppMeshSet() {
        return isSet.contains("appMesh");
    }

    @JsonIgnore
    public boolean isPingPongSet() {
        return isSet.contains("pingPong");
    }
}