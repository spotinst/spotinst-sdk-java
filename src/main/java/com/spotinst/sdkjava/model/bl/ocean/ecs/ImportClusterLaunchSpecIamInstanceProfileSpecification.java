package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImportClusterLaunchSpecIamInstanceProfileSpecification {
    @JsonIgnore
    private Set<String> isSet;
    private String      arn;

    private ImportClusterLaunchSpecIamInstanceProfileSpecification() {
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

    public static class Builder {
        private ImportClusterLaunchSpecIamInstanceProfileSpecification iamInstanceProfile;

        private Builder() {
            this.iamInstanceProfile = new ImportClusterLaunchSpecIamInstanceProfileSpecification();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setArn(final String arn) {
            iamInstanceProfile.setArn(arn);
            return this;
        }

        public ImportClusterLaunchSpecIamInstanceProfileSpecification build() {
            return iamInstanceProfile;
        }
    }

    @JsonIgnore
    public boolean isArnSet() {
        return isSet.contains("arn");
    }
}
