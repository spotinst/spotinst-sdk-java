package com.spotinst.sdkjava.model.bl.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Route53 {

    //region Members
    @JsonIgnore
    private Set<String>         isSet;
    private List<Domains>       domains;

    //endregion

    //region constructor
    private Route53() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Setters&Getters

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

    //endregion

    //region Builder class
    public static class Builder {
        private Route53 route53;

        private Builder() {
            this.route53 = new Route53();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setDomains(final List<Domains> domains) {
            route53.setDomains(domains);
            return this;
        }

        public Route53 build() {
            // TODO : Validations
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
