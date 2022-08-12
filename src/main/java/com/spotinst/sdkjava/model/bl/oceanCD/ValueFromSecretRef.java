package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValueFromSecretRef {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     name;
    private String                     key;

    private ValueFromSecretRef() {
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        isSet.add("key");
        this.key = key;
    }

    public static class Builder {
        private ValueFromSecretRef valueFromSecretRef;

        private Builder() {
            this.valueFromSecretRef = new ValueFromSecretRef();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setName(final String name) {
            valueFromSecretRef.setName(name);
            return this;
        }

        public Builder setKey(final String key) {
            valueFromSecretRef.setKey(key);
            return this;
        }

        public ValueFromSecretRef build() {
            return valueFromSecretRef;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isKeySet() {
        return isSet.contains("key");
    }
}