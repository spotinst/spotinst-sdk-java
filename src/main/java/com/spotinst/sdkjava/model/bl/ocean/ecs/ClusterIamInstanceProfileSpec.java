package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ClusterIamInstanceProfileSpec {
    @JsonIgnore
    private Set<String> isSet;
    private String      arn;
    private String      name;

    private ClusterIamInstanceProfileSpec() {
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
        private ClusterIamInstanceProfileSpec iamInstanceProfile;

        private Builder() {
            this.iamInstanceProfile = new ClusterIamInstanceProfileSpec();
        }

        public static Builder get() {
            Builder builder = new ClusterIamInstanceProfileSpec.Builder();
            return builder;
        }

        public Builder setArn(final String arn) {
            iamInstanceProfile.setArn(arn);
            return this;
        }

        public Builder setName(final String name) {
            iamInstanceProfile.setArn(name);
            return this;
        }

        public ClusterIamInstanceProfileSpec build() {
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