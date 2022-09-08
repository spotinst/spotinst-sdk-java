package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Args {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    name;
    private String                                    value;
    private ArgsValueFrom                             valueFrom;

    private Args() {
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

    public ArgsValueFrom getValueFrom() {
        return valueFrom;
    }

    public void setValueFrom(ArgsValueFrom valueFrom) {
        isSet.add("valueFrom");
        this.valueFrom = valueFrom;
    }

    public static class Builder {
        private Args backgroundVerificationArgs;

        private Builder() {
            this.backgroundVerificationArgs = new Args();
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

        public Builder setValueFrom(final ArgsValueFrom valueFrom) {
            backgroundVerificationArgs.setValueFrom(valueFrom);
            return this;
        }

        public Args build() {
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