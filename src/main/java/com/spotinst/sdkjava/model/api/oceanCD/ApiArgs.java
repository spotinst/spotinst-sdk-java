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
public class ApiArgs implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    name;
    private String                                    value;
    private ApiArgsValueFrom                          valueFrom;

    public ApiArgs() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        isSet.add("value");
        this.value = value;
    }

    public ApiArgsValueFrom getValueFrom() {
        return valueFrom;
    }

    public void setValueFrom(ApiArgsValueFrom valueFrom) {
        isSet.add("valueFrom");
        this.valueFrom = valueFrom;
    }

    public static class Builder {
        private ApiArgs backgroundVerificationArgs;

        private Builder() {
            this.backgroundVerificationArgs = new ApiArgs();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            backgroundVerificationArgs.setName(name);
            return this;
        }

        public Builder setValue(final String value) {
            backgroundVerificationArgs.setValue(value);
            return this;
        }

        public Builder setValueFrom(final ApiArgsValueFrom valueFrom) {
            backgroundVerificationArgs.setValueFrom(valueFrom);
            return this;
        }

        public ApiArgs build() {
            return backgroundVerificationArgs;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isValueSet() {
        return isSet.contains("value");
    }

    @JsonIgnore
    public boolean isValueFromSet() {
        return isSet.contains("valueFrom");
    }
}