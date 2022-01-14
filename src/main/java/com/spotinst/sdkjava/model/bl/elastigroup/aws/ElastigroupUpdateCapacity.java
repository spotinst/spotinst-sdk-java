package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Janetlin Kiruba
 * @since: 10/01/2022
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ElastigroupUpdateCapacity implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                isSet;
    private String                     id;
    private ElastigroupCapacityConfiguration                capacity;
    //endregion

    //region Constructor

    public ElastigroupUpdateCapacity() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public ElastigroupCapacityConfiguration getCapacity() {
        return capacity;
    }

    public void setCapacity(ElastigroupCapacityConfiguration capacity) {
        isSet.add("capacity");
        this.capacity = capacity;
    }

    //endregion

    //region Builder class
    public static class Builder {
        //region Members
        private ElastigroupUpdateCapacity elastigroup;
        //endregion


        private Builder() {
            this.elastigroup = new ElastigroupUpdateCapacity();
        }

        public static Builder get() {
            ElastigroupUpdateCapacity.Builder builder = new Builder();
            return builder;
        }

        //region Build methods
        protected Builder setId(final String elastigroupId) {
            elastigroup.setId(elastigroupId);
            return this;
        }

        public Builder setCapacity(final ElastigroupCapacityConfiguration capacity) {
            elastigroup.setCapacity(capacity);
            return this;
        }

        public ElastigroupUpdateCapacity build() {
            // Validations
            return elastigroup;
        }
        //endregion
    }
    //endregion


    //region isSet methods
    // Is id Set boolean method
    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    // Is capacity Set boolean method
    @JsonIgnore
    public boolean isCapacitySet() {
        return isSet.contains("capacity");
    }

    //endregion
}
