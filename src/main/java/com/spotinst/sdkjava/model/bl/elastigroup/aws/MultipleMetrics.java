package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Sobhana Priyadarshani
 * @since: 20/09/2023
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MultipleMetrics {
    //region Members
    @JsonIgnore
    private Set<String>       isSet;
    private List<Expressions> expressions;
    private List<Metrics>     metrics;
    //endregion

    //region Constructor

    public MultipleMetrics() {
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

    public List<Expressions> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Expressions> expressions) {
        isSet.add("expressions");
        this.expressions = expressions;
    }

    public List<Metrics> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<Metrics> metrics) {
        isSet.add("metrics");
        this.metrics = metrics;
    }

    //endregion

    //region Builder class
    public static class Builder {
        //region Members
        private MultipleMetrics cpuThreads;
        //endregion

        private Builder() {
            this.cpuThreads = new MultipleMetrics();
        }

        public static Builder get() {
            return new Builder();
        }

        //region Build methods
        public Builder setExpressions(final List<Expressions> expressions) {
            cpuThreads.setExpressions(expressions);
            return this;
        }

        public Builder setMetrics(final List<Metrics> metrics) {
            cpuThreads.setMetrics(metrics);
            return this;
        }

        public MultipleMetrics build() {
            // Validations
            return cpuThreads;
        }
        //endregion
    }
    //endregion


    //expressions isSet methods
    @JsonIgnore
    public boolean isExpressionsSet() {
        return isSet.contains("expressions");
    }

    //metrics isSet methods
    @JsonIgnore
    public boolean isMetricssSet() {
        return isSet.contains("metrics");
    }

    //endregion
}
