package com.spotinst.sdkjava.model.api.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.ApiScalingDimension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Sobhana Priyadarshani
 * @since: 20/09/2023
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiMetrics implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                          isSet;
    private List<ApiScalingDimension>            dimensions;
    private String                               extendedStatistic;
    private String                               metricName;
    private String                               name;
    private String                               namespace;
    private String                               statistic;
    private String                               unit;

    //endregion

    //region Constructor

    public ApiMetrics() {
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        isSet.add("unit");
        this.unit = unit;
    }

    public List<ApiScalingDimension> getDimensions() {
        return dimensions;
    }

    public void setDimensions(List<ApiScalingDimension> dimensions) {
        isSet.add("dimensions");
        this.dimensions = dimensions;
    }

    public String getExtendedStatistic() {
        return extendedStatistic;
    }

    public void setExtendedStatistic(String extendedStatistic) {
        isSet.add("extendedStatistic");
        this.extendedStatistic = extendedStatistic;
    }

    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        isSet.add("metricName");
        this.metricName = metricName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        isSet.add("namespace");
        this.namespace = namespace;
    }

    public String getStatistic() {
        return statistic;
    }

    public void setStatistic(String statistic) {
        isSet.add("statistic");
        this.statistic = statistic;
    }

    //endregion

    //name isSet methods
    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    //unit isSet methods
    @JsonIgnore
    public boolean isUnitSet() {
        return isSet.contains("unit");
    }

    //dimensions isSet methods
    @JsonIgnore
    public boolean isDimensionSet() {
        return isSet.contains("dimensions");
    }

    //extendedStatistic isSet methods
    @JsonIgnore
    public boolean isExtendedStatisticSet() {
        return isSet.contains("extendedStatistic");
    }

    //metricName isSet methods
    @JsonIgnore
    public boolean isMetricNameSet() {
        return isSet.contains("metricName");
    }

    //namespace isSet methods
    @JsonIgnore
    public boolean isNamespaceSet() {
        return isSet.contains("namespace");
    }

    //statistic isSet methods
    @JsonIgnore
    public boolean isStatisticSet() {
        return isSet.contains("statistic");
    }


    //endregion
}
