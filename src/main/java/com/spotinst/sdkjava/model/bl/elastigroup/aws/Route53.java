package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.model.ElastigroupCodeDeploy;
import com.spotinst.sdkjava.model.ElastigroupEcsSpecification;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Route53 {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String>                 isSet;
    private List<Route53Domains> domains;
    //endregion

    //region Constructor

    private Route53() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters


    public List<Route53Domains> getDomains() {
        return domains;
    }

    public void setDomains(List<Route53Domains> domains) {
        isSet.add("domains");
        this.domains = domains;
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    //endregion
    //region Builder class
    public static class Builder {
        private Route53 route53;

        private Builder() {
            this.route53 = new Route53();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDomains(List<Route53Domains> domains) {
            route53.setDomains(domains);
            return this;
        }

        public com.spotinst.sdkjava.model.bl.elastigroup.aws.Route53 build() {
            return route53;
        }
    }
    //endregion

    //region isSet methods
    // Is domains Set boolean method
    @JsonIgnore
    public boolean isDomainsSet() {
        return isSet.contains("domains");
    }
    //endregion
}
