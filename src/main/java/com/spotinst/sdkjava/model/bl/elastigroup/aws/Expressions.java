package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Sobhana Priyadarshani
 * @since: 20/09/2023
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Expressions {
    //region Members
    @JsonIgnore
    private Set<String>                                    isSet;
    private String                               expression;
    private String                               name;
    //endregion

    //region Constructor

    public Expressions() {
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

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        isSet.add("expression");
        this.expression = expression;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    //endregion

    //region Builder class
    public static class Builder {
        //region Members
        private Expressions expressions;
        //endregion

        private Builder() {
            this.expressions = new Expressions();
        }

        public static Builder get() {
            return new Builder();
        }

        //region Build methods
        public Builder setExpression(final String expression) {
            expressions.setExpression(expression);
            return this;
        }

        public Builder setName(final String name) {
            expressions.setName(name);
            return this;
        }

        public Expressions build() {
            // Validations
            return expressions;
        }
        //endregion
    }
    //endregion


    //region isSet methods
    @JsonIgnore
    public boolean isExpressionSet() {
        return isSet.contains("expression");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    //endregion
}
