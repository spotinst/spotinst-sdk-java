package com.spotinst.sdkjava.model.bl.admin.messageCenter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BulkUpdateMessages {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private List<Entities> entities;
    //endregion

    //region Getters & Setters


    public List<Entities> getEntities() {
        return entities;
    }

    public void setEntities(List<Entities> entities) {
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
    public BulkUpdateMessages() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Builder class
    public static class Builder {
        private BulkUpdateMessages updateMessage;

        private Builder() {
            this.updateMessage = new BulkUpdateMessages();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setEntities(List<Entities> entities) {
            updateMessage.setEntities(entities);
            return this;
        }

        public BulkUpdateMessages build() {
            return updateMessage;
        }
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
