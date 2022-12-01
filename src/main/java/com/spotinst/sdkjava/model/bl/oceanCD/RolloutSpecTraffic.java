package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RolloutSpecTraffic {
    @JsonIgnore
    private Set<String>              isSet;
    private String                   canaryService;
    private String                   stableService;
    private TrafficIstio             istio;
    private TrafficNginx             nginx;
    private TrafficAlb               alb;
    private TrafficSmi               smi;
    private TrafficAmbassador        ambassador;
    private TrafficAppMesh           appMesh;
    private TrafficPingPong          pingPong;

    private RolloutSpecTraffic() {
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

    public TrafficIstio getIstio() {
        return istio;
    }

    public void setIstio(TrafficIstio istio) {
        isSet.add("istio");
        this.istio = istio;
    }

    public TrafficNginx getNginx() {
        return nginx;
    }

    public void setNginx(TrafficNginx nginx) {
        isSet.add("nginx");
        this.nginx = nginx;
    }

    public TrafficAlb getAlb() {
        return alb;
    }

    public void setAlb(TrafficAlb alb) {
        isSet.add("alb");
        this.alb = alb;
    }

    public TrafficSmi getSmi() {
        return smi;
    }

    public void setSmi(TrafficSmi smi) {
        isSet.add("smi");
        this.smi = smi;
    }

    public TrafficAmbassador getAmbassador() {
        return ambassador;
    }

    public void setAmbassador(TrafficAmbassador ambassador) {
        isSet.add("ambassador");
        this.ambassador = ambassador;
    }

    public TrafficAppMesh getAppMesh() {
        return appMesh;
    }

    public void setAppMesh(TrafficAppMesh appMesh) {
        isSet.add("appMesh");
        this.appMesh = appMesh;
    }

    public TrafficPingPong getPingPong() {
        return pingPong;
    }

    public void setPingPong(TrafficPingPong pingPong) {
        isSet.add("pingPong");
        this.pingPong = pingPong;
    }

    public static class Builder {
        private RolloutSpecTraffic rolloutSpecTraffic;

        private Builder() {
            this.rolloutSpecTraffic = new RolloutSpecTraffic();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setCanaryService(final String canaryService) {
            rolloutSpecTraffic.setCanaryService(canaryService);
            return this;
        }

        public Builder setStableService(final String stableService) {
            rolloutSpecTraffic.setStableService(stableService);
            return this;
        }

        public Builder setIstio(final TrafficIstio istio) {
            rolloutSpecTraffic.setIstio(istio);
            return this;
        }

        public Builder setNginx(final TrafficNginx nginx) {
            rolloutSpecTraffic.setNginx(nginx);
            return this;
        }

        public Builder setAlb(final TrafficAlb alb) {
            rolloutSpecTraffic.setAlb(alb);
            return this;
        }

        public Builder setPingPong(final TrafficPingPong pingPong) {
            rolloutSpecTraffic.setPingPong(pingPong);
            return this;
        }

        public Builder setSmi(final TrafficSmi smi) {
            rolloutSpecTraffic.setSmi(smi);
            return this;
        }

        public Builder setAmbassador(final TrafficAmbassador ambassador) {
            rolloutSpecTraffic.setAmbassador(ambassador);
            return this;
        }

        public Builder setAppMesh(final TrafficAppMesh appMesh) {
            rolloutSpecTraffic.setAppMesh(appMesh);
            return this;
        }

        public RolloutSpecTraffic build() {
            return rolloutSpecTraffic;
        }
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