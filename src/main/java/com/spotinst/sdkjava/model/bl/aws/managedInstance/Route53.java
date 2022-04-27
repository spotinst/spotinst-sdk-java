package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Route53 {

    @JsonIgnore
    private Set<String>         isSet;
    private List<Domains>       domains;

    private Route53() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<Domains> getDomains() {
        return domains;
    }

    public void setDomains(List<Domains> domains) {
        isSet.add("domains");
        this.domains = domains;
    }

    public static class Builder {
        private Route53 route53;

        private Builder() {
            this.route53 = new Route53();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDomains(final List<Domains> domains) {
            route53.setDomains(domains);
            return this;
        }

        public Route53 build() {
            return route53;
        }
    }

    @JsonIgnore
    public boolean isDomainsSet() {
        return isSet.contains("domains");
    }
}
