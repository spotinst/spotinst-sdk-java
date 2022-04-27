package com.spotinst.sdkjava.model.bl.admin.organization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyContent {
    @JsonIgnore
    private Set<String>           isSet;
    private List<PolicyStatement> statements;

    public PolicyContent() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<PolicyStatement> getStatements() {
        return statements;
    }

    public void setStatements(List<PolicyStatement> statements) {
        isSet.add("statements");
        this.statements = statements;
    }

    public static class Builder {
        private PolicyContent content;

        private Builder() {
            this.content = new PolicyContent();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setStatements(final List<PolicyStatement> statements) {
            content.setStatements(statements);
            return this;
        }

        public PolicyContent build() {
            return content;
        }
    }

    @JsonIgnore
    public boolean isStatementSet() {
        return isSet.contains("statements");
    }

}