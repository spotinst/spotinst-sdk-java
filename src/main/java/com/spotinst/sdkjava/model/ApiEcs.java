package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFilter("PartialUpdateEntityFilter")
class ApiEcs {
    //region Members
    @JsonIgnore
    private Set<String>                       isSet;
    private String                            clusterName;
    private ElastigroupAutoScaleSpecification autoScale;
    //endregion

    //region Constructor
    public ApiEcs(){isSet = new HashSet<>();}
    //endregion

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        isSet.add("clusterName");
        this.clusterName = clusterName;
    }

    public ElastigroupAutoScaleSpecification getAutoScale() {
        return autoScale;
    }

    public void setAutoScale(ElastigroupAutoScaleSpecification autoScale) {
        isSet.add("autoScale");
        this.autoScale = autoScale;
    }
    //endregion
    // Is product Set boolean method
    @JsonIgnore
    public boolean isAutoScaleSet() {
        return isSet.contains("autoScale");
    }

    // Is product Set boolean method
    @JsonIgnore
    public boolean isClusterNameSet() {
        return isSet.contains("clusterName");
    }

    //endregion
}
