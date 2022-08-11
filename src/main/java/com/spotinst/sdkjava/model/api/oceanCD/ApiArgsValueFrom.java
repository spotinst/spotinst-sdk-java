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
public class ApiArgsValueFrom implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                               isSet;
    private ApiValueFromSecretRef secretRef;
    private ApiValueFromFiledRef filedRef;

    public ApiArgsValueFrom() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiValueFromSecretRef getSecretRef() {
        return secretRef;
    }

    public void setSecretRef(ApiValueFromSecretRef secretRef) {
        isSet.add("secretRef");
        this.secretRef = secretRef;
    }

    public ApiValueFromFiledRef getFiledRef() {
        return filedRef;
    }

    public void setFiledRef(ApiValueFromFiledRef filedRef) {
        isSet.add("filedRef");
        this.filedRef = filedRef;
    }

    public static class Builder {
        private ApiArgsValueFrom argsValueFrom;

        private Builder() {
            this.argsValueFrom = new ApiArgsValueFrom();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setSecretRef(final ApiValueFromSecretRef secretRef) {
            argsValueFrom.setSecretRef(secretRef);
            return this;
        }

        public Builder setFiledRef(final ApiValueFromFiledRef filedRef) {
            argsValueFrom.setFiledRef(filedRef);
            return this;
        }

        public ApiArgsValueFrom build() {
            return argsValueFrom;
        }
    }

    @JsonIgnore
    public boolean isSecretRefSet() {
        return isSet.contains("secretRef");
    }

    @JsonIgnore
    public boolean isFiledRefSet() {
        return isSet.contains("filedRef");
    }
}