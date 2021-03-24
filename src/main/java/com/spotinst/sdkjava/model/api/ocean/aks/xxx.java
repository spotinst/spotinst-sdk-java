package com.spotinst.sdkjava.model.api.ocean.aks;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import java.util.HashSet;
import java.util.Set;





public class xxx

        implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String> isSet;
    private String                    marketplace;



    public xxx() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }


    @JsonIgnore
    public boolean isYYYSet() {
        return isSet.contains("yyy");
    }
}
