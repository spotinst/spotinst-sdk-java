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
public class ApiTrafficNginx implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                             isSet;
    private String                                  annotationPrefix;
    private String                                  stableIngress;
    private ApiNginxAdditionalIngressAnnotations additionalIngressAnnotations;

    public ApiTrafficNginx() {
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

    public ApiNginxAdditionalIngressAnnotations getAdditionalIngressAnnotations() {
        return additionalIngressAnnotations;
    }

    public void setAdditionalIngressAnnotations(ApiNginxAdditionalIngressAnnotations additionalIngressAnnotations) {
        isSet.add("additionalIngressAnnotations");
        this.additionalIngressAnnotations = additionalIngressAnnotations;
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