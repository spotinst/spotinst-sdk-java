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
public class ApiValueFromSecretRef implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                isSet;
    private String                     name;
    private String                     key;

    public ApiValueFromSecretRef() {
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
        private ApiValueFromSecretRef valueFromSecretRef;

        private Builder() {
            this.valueFromSecretRef = new ApiValueFromSecretRef();
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

        public ApiValueFromSecretRef build() {
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