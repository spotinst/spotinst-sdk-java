package com.spotinst.sdkjava.model.api.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ApiRoute53 {

    @JsonIgnore
    private Set<String>         isSet;
    private List<ApiDomains>       domains;

    private ApiRoute53() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiDomains> getLoadBalancers() {
        return domains;
    }

    public void setDomains(List<ApiDomains> domains) {
        isSet.add("domains");
        this.domains = domains;
    }

    @JsonIgnore
    public boolean isDomainsSet() {
        return isSet.contains("domains");
    }

}
