package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrafficNginx {
    @JsonIgnore
    private Set<String>                             isSet;
    private String                                  annotationPrefix;
    private String                                  stableIngress;
    private NginxAdditionalIngressAnnotations       additionalIngressAnnotations;

    private TrafficNginx() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getAnnotationPrefix() {
        return annotationPrefix;
    }

    public void setAnnotationPrefix(String annotationPrefix) {
        isSet.add("annotationPrefix");
        this.annotationPrefix = annotationPrefix;
    }

    public String getStableIngress() {
        return stableIngress;
    }

    public void setStableIngress(String stableIngress) {
        isSet.add("stableIngress");
        this.stableIngress = stableIngress;
    }

    public NginxAdditionalIngressAnnotations getAdditionalIngressAnnotations() {
        return additionalIngressAnnotations;
    }

    public void setAdditionalIngressAnnotations(NginxAdditionalIngressAnnotations additionalIngressAnnotations) {
        isSet.add("additionalIngressAnnotations");
        this.additionalIngressAnnotations = additionalIngressAnnotations;
    }

    public static class Builder {
        private TrafficNginx trafficNginx;

        private Builder() {
            this.trafficNginx = new TrafficNginx();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setAnnotationPrefix(final String annotationPrefix) {
            trafficNginx.setAnnotationPrefix(annotationPrefix);
            return this;
        }

        public Builder setStableIngress(final String stableIngress) {
            trafficNginx.setStableIngress(stableIngress);
            return this;
        }

        public Builder setAdditionalIngressAnnotations(final NginxAdditionalIngressAnnotations additionalIngressAnnotations) {
            trafficNginx.setAdditionalIngressAnnotations(additionalIngressAnnotations);
            return this;
        }

        public TrafficNginx build() {
            return trafficNginx;
        }
    }

    @JsonIgnore
    public boolean isAnnotationPrefixSet() {
        return isSet.contains("annotationPrefix");
    }

    @JsonIgnore
    public boolean isStableIngressSet() {
        return isSet.contains("stableIngress");
    }

    @JsonIgnore
    public boolean isAdditionalIngressAnnotationsSet() {
        return isSet.contains("additionalIngressAnnotations");
    }
}