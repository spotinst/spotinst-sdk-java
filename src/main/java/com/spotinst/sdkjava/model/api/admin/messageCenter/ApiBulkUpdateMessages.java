package com.spotinst.sdkjava.model.api.admin.messageCenter;

import com.fasterxml.jackson.annotation.*;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiBulkUpdateMessages implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private List<ApiEntities> entities;
    //endregion

    //region Getters & Setters


    public List<ApiEntities> getEntities() {
        return entities;
    }

    public void setEntities(List<ApiEntities> entities) {
        isSet.add("entities");
        this.entities = entities;
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    //endregion
    //region Constructor
    public ApiBulkUpdateMessages() {
        isSet = new HashSet<>();
    }
    //endregion

    //region isSet methods
    // Is entities Set boolean method
    @JsonIgnore
    public boolean isEntitiesSet() {
        return isSet.contains("entities");
    }
    //endregion
}
