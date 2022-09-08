package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NginxAdditionalIngressAnnotations {
    @JsonIgnore
    private Set<String>                             isSet;
    private String                                  property1;
    private String                                  property2;

    private NginxAdditionalIngressAnnotations() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        isSet.add("property1");
        this.property1 = property1;
    }

    public String getProperty2() {
        return property2;
    }

    public void setProperty2(String property2) {
        isSet.add("property2");
        this.property2 = property2;
    }

    public static class Builder {
        private NginxAdditionalIngressAnnotations nginxAdditionalIngressAnnotations;

        private Builder() {
            this.nginxAdditionalIngressAnnotations = new NginxAdditionalIngressAnnotations();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setProperty1(final String property1) {
            nginxAdditionalIngressAnnotations.setProperty1(property1);
            return this;
        }

        public Builder setProperty2(final String property2) {
            nginxAdditionalIngressAnnotations.setProperty2(property2);
            return this;
        }

        public NginxAdditionalIngressAnnotations build() {
            return nginxAdditionalIngressAnnotations;
        }
    }

    @JsonIgnore
    public boolean isProperty1Set() {
        return isSet.contains("property1");
    }

    @JsonIgnore
    public boolean isProperty2Set() {
        return isSet.contains("property2");
    }
}