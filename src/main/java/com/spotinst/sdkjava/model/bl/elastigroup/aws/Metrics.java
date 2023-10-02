package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.aws.elastigroup.AwsMetricAlarmUnit;
import com.spotinst.sdkjava.enums.aws.elastigroup.AwsMetricStatistics;
import com.spotinst.sdkjava.model.ScalingDimension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Sobhana Priyadarshani
 * @since: 20/09/2023
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Metrics {
    //region Members
    @JsonIgnore
    private Set<String>                          isSet;
    private List<ScalingDimension>               dimensions;
    private String                               extendedStatistic;
    private String                               metricName;
    private String                               name;
    private String                               namespace;
    private AwsMetricStatistics                  statistic;
    private AwsMetricAlarmUnit                   unit;

    //endregion

    //region Constructor

    public Metrics() {
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

    public AwsMetricAlarmUnit getUnit() {
        return unit;
    }

    public void setUnit(AwsMetricAlarmUnit unit) {
        isSet.add("unit");
        this.unit = unit;
    }

    public List<ScalingDimension> getDimensions() {
        return dimensions;
    }

    public void setDimensions(List<ScalingDimension> dimensions) {
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

    public AwsMetricStatistics getStatistic() {
        return statistic;
    }

    public void setStatistic(AwsMetricStatistics statistic) {
        isSet.add("statistic");
        this.statistic = statistic;
    }

    //endregion

    //region Builder class
    public static class Builder {
        //region Members
        private Metrics metrics;
        //endregion

        private Builder() {
            this.metrics = new Metrics();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setUnit(final AwsMetricAlarmUnit unit) {
            metrics.setUnit(unit);
            return this;
        }

        public Builder setDimensions(final List<ScalingDimension> dimensions) {
            metrics.setDimensions(dimensions);
            return  this;
        }

        public Builder setExtendedStatistic(final String extendedStatistic) {
            metrics.setExtendedStatistic(extendedStatistic);
            return  this;
        }

        public Builder setMetricName(final String metricName) {
            metrics.setMetricName(metricName);
            return this;
        }

        public Builder setName(final String name) {
            metrics.setName(name);
            return this;
        }

        public Builder setNamespace(final String namespace) {
            metrics.setNamespace(namespace);
            return this;
        }

        public Builder setStatistic(AwsMetricStatistics statistic) {
           metrics.setStatistic(statistic);
           return this;
        }
        //region Build methods

        public Metrics build() {
            // Validations
            return metrics;
        }
        //endregion
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
