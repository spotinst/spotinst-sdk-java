package com.spotinst.sdkjava.model.api.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiRoute53 implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>         isSet;
    private List<ApiDomains>       domains;

    public ApiRoute53() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiDomains> getDomains() {
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
