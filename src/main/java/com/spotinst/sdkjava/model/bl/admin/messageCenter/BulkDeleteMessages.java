package com.spotinst.sdkjava.model.bl.admin.messageCenter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BulkDeleteMessages {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private List<String> ids;
    //endregion

    //region Getters & Setters


    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        isSet.add("ids");
        this.ids = ids;
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    //endregion
    //region Constructor
    public BulkDeleteMessages() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Builder class
    public static class Builder {
        private BulkDeleteMessages deleteMessages;

        private Builder() {
            this.deleteMessages = new BulkDeleteMessages();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setIds(List<String> ids) {
            deleteMessages.setIds(ids);
            return this;
        }

        public BulkDeleteMessages build() {
            return deleteMessages;
        }
    }
    //endregion

    //region isSet methods
    // Is Ids Set boolean method
    @JsonIgnore
    public boolean isIdsSet() {
        return isSet.contains("ids");
    }
    //endregion
}
