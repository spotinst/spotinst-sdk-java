package com.spotinst.sdkjava.model.api.oceanCD;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiValueFromFiledRef implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     fieldPath;

    public ApiValueFromFiledRef() {
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
        private ApiValueFromFiledRef valueFromFiledRef;

        private Builder() {
            this.valueFromFiledRef = new ApiValueFromFiledRef();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setFieldPath(final String fieldPath) {
            valueFromFiledRef.setFieldPath(fieldPath);
            return this;
        }

        public ApiValueFromFiledRef build() {
            return valueFromFiledRef;
        }
    }

    @JsonIgnore
    public boolean isFieldPathSet() {
        return isSet.contains("fieldPath");
    }
}