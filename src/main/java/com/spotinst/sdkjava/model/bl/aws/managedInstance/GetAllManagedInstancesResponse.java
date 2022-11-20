package com.spotinst.sdkjava.model.bl.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetAllManagedInstancesResponse {

        @JsonIgnore
        private Set<String>             isSet;
        private ManagedInstance         config;
        private Date                    createdAt;
        private Date                    updatedAt;
        private String                  id;


        private GetAllManagedInstancesResponse() {
            isSet = new HashSet<>();
        }

        public Set<String> getIsSet() {
            return isSet;
        }

        public void setIsSet(Set<String> isSet) {
            this.isSet = isSet;
        }

        public ManagedInstance getConfig() {
            return config;
        }

        public void setConfig(ManagedInstance config) {
            isSet.add("config");
            this.config = config;
        }

        public Date getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
            isSet.add("createdAt");
            this.createdAt = createdAt;
        }

        public Date getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Date updatedAt) {
            isSet.add("updatedAt");
            this.updatedAt = updatedAt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            isSet.add("id");
            this.id = id;
        }

        public static class Builder {
            private GetAllManagedInstancesResponse getAllmanagedInstance;

            private Builder() {
                this.getAllmanagedInstance = new GetAllManagedInstancesResponse();
            }

            public static Builder get() {
                return new Builder();
            }

            public Builder setConfig(final ManagedInstance config) {
                getAllmanagedInstance.setConfig(config);
                return this;
            }

            public Builder setCreatedAt(final Date createdAt) {
                getAllmanagedInstance.setCreatedAt(createdAt);
                return this;
            }

            public Builder setUpdatedAt(final Date updatedAt) {
                getAllmanagedInstance.setUpdatedAt(updatedAt);
                return this;
            }

            public Builder setId(final String id) {
                getAllmanagedInstance.setId(id);
                return this;
            }

            public GetAllManagedInstancesResponse build() {
                return getAllmanagedInstance;
            }
        }

        @JsonIgnore
        public boolean isConfigSet() {
            return isSet.contains("config");
        }

        @JsonIgnore
        public boolean isCreatedAtSet() {
            return isSet.contains("createdAt");
        }

        @JsonIgnore
        public boolean isUpdatedAtSet() {
            return isSet.contains("updatedAt");
        }

        @JsonIgnore
        public boolean isIdSet() {
            return isSet.contains("id");
        }

}
