package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValueFromFiledRef {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     fieldPath;

    private ValueFromFiledRef() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getFieldPath() {
        return fieldPath;
    }

    public void setFieldPath(String fieldPath) {
        isSet.add("fieldPath");
        this.fieldPath = fieldPath;
    }

    public static class Builder {
        private ValueFromFiledRef valueFromFiledRef;

        private Builder() {
            this.valueFromFiledRef = new ValueFromFiledRef();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setFieldPath(final String fieldPath) {
            valueFromFiledRef.setFieldPath(fieldPath);
            return this;
        }

        public ValueFromFiledRef build() {
            return valueFromFiledRef;
        }
    }

    @JsonIgnore
    public boolean isFieldPathSet() {
        return isSet.contains("fieldPath");
    }
}