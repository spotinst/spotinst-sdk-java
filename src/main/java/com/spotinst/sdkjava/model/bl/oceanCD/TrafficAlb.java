package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrafficAlb {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     ingress;
    private Integer                    servicePort;
    private String                     rootService;
    private String                     annotationPrefix;
    private AlbStickinessConfig        stickinessConfig;

    private TrafficAlb() {
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

    public AlbStickinessConfig getStickinessConfig() {
        return stickinessConfig;
    }

    public void setStickinessConfig(AlbStickinessConfig stickinessConfig) {
        isSet.add("stickinessConfig");
        this.stickinessConfig = stickinessConfig;
    }

    public static class Builder {
        private TrafficAlb trafficAlb;

        private Builder() {
            this.trafficAlb = new TrafficAlb();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setIngress(final String ingress) {
            trafficAlb.setIngress(ingress);
            return this;
        }

        public Builder setServicePort(final Integer servicePort) {
            trafficAlb.setServicePort(servicePort);
            return this;
        }

        public Builder setRootService(final String rootService) {
            trafficAlb.setRootService(rootService);
            return this;
        }

        public Builder setAnnotationPrefix(final String annotationPrefix) {
            trafficAlb.setAnnotationPrefix(annotationPrefix);
            return this;
        }

        public Builder setStickinessConfig(final AlbStickinessConfig stickinessConfig) {
            trafficAlb.setStickinessConfig(stickinessConfig);
            return this;
        }

        public TrafficAlb build() {
            return trafficAlb;
        }
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