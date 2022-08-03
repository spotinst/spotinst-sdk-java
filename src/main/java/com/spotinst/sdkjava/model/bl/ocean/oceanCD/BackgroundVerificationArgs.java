package com.spotinst.sdkjava.model.bl.ocean.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class BackgroundVerificationArgs {
    @JsonIgnore
    private Set<String>     isSet;
    private String          name;
    private String          value;
    private ArgsValueFrom   valueFrom;

    public BackgroundVerificationArgs() {
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
        private BackgroundVerificationArgs args;

        private Builder() {
            this.args = new BackgroundVerificationArgs();
        }

        public static BackgroundVerificationArgs.Builder get() {
            return new Builder();
        }

        public Builder setName(String name) {
            args.setName(name);
            return this;
        }

        public Builder setValue(String value) {
            args.setValue(value);
            return this;
        }

        public Builder setValueFrom(ArgsValueFrom valueFrom) {
            args.setValueFrom(valueFrom);
            return this;
        }

        public BackgroundVerificationArgs build() {
            return args;
        }
    }

    @JsonIgnore
    public boolean isTemplateNamesSet() {
        return isSet.contains("templateNames");
    }

    @JsonIgnore
    public boolean isArgsSet() {
        return isSet.contains("args");
    }

}
