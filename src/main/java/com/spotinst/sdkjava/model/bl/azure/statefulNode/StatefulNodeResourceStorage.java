package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatefulNodeResourceStorage {

    @JsonIgnore
    private Set<String>                                 isSet;
    private List<StatefulNodeResourceDataDisks>         dataDisks;
    private StatefulNodeResourceOsDisk                  osDisk;

    private StatefulNodeResourceStorage() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<StatefulNodeResourceDataDisks> getDataDisks() {
        return dataDisks;
    }

    public void setDataDisks(List<StatefulNodeResourceDataDisks> dataDisks) {
        isSet.add("dataDisks");
        this.dataDisks = dataDisks;
    }

    public StatefulNodeResourceOsDisk getOsDisk() {
        return osDisk;
    }

    public void setOsDisk(StatefulNodeResourceOsDisk osDisk) {
        isSet.add("osDisk");
        this.osDisk = osDisk;
    }

    public static class Builder {

        private StatefulNodeResourceStorage nodeResourceStorage;

        private Builder() {
            this.nodeResourceStorage = new StatefulNodeResourceStorage();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setDataDisks(final List<StatefulNodeResourceDataDisks> dataDisks) {
            nodeResourceStorage.setDataDisks(dataDisks);
            return this;
        }

        public Builder setOsDisk(final StatefulNodeResourceOsDisk osDisk) {
            nodeResourceStorage.setOsDisk(osDisk);
            return this;
        }

        public StatefulNodeResourceStorage build() {
            return nodeResourceStorage;
        }
    }

    @JsonIgnore
    public boolean isDataDisksSet() {
        return isSet.contains("dataDisks");
    }

    @JsonIgnore
    public boolean isOsDiskSet() { return isSet.contains("osDisk"); }
}
