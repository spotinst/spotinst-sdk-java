package com.spotinst.sdkjava.model.bl.oceanCD;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArgsValueFrom {
    @JsonIgnore
    private Set<String>                               isSet;
    private ValueFromSecretRef                        secretRef;
    private ValueFromFiledRef                         filedRef;

    private ArgsValueFrom() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ValueFromSecretRef getSecretRef() {
        return secretRef;
    }

    public void setSecretRef(ValueFromSecretRef secretRef) {
        isSet.add("secretRef");
        this.secretRef = secretRef;
    }

    public ValueFromFiledRef getFiledRef() {
        return filedRef;
    }

    public void setFiledRef(ValueFromFiledRef filedRef) {
        isSet.add("filedRef");
        this.filedRef = filedRef;
    }

    public static class Builder {
        private ArgsValueFrom argsValueFrom;

        private Builder() {
            this.argsValueFrom = new ArgsValueFrom();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setSecretRef(final ValueFromSecretRef secretRef) {
            argsValueFrom.setSecretRef(secretRef);
            return this;
        }

        public Builder setFiledRef(final ValueFromFiledRef filedRef) {
            argsValueFrom.setFiledRef(filedRef);
            return this;
        }

        public ArgsValueFrom build() {
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