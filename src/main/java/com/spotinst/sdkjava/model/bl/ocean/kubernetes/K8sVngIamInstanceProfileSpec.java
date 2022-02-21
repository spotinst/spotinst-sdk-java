package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class K8sVngIamInstanceProfileSpec {
    @JsonIgnore
    private Set<String> isSet;
    private String      arn;
    private String      name;

    private K8sVngIamInstanceProfileSpec() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getArn() {
        return arn;
    }

    public void setArn(String arn) {
        isSet.add("arn");
        this.arn = arn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public static class Builder {
        private K8sVngIamInstanceProfileSpec iamInstanceProfile;

        private Builder() {
            this.iamInstanceProfile = new K8sVngIamInstanceProfileSpec();
        }

        public static Builder get() {
            Builder builder = new K8sVngIamInstanceProfileSpec.Builder();
            return builder;
        }

        public Builder setArn(final String arn) {
            iamInstanceProfile.setArn(arn);
            return this;
        }

        public Builder setName(final String name) {
            iamInstanceProfile.setName(name);
            return this;
        }

        public K8sVngIamInstanceProfileSpec build() {
            return iamInstanceProfile;
        }
    }

    @JsonIgnore
    public boolean isArnSet() {
        return isSet.contains("arn");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }
}
