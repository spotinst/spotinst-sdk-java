package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.ProcessNameEnum;
import com.spotinst.sdkjava.exception.SpotinstValidationException;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by yossi.elman on 24/05/2020.
 */

public class ElastigroupSuspendProcessesRequest {
    //region Members
    private String                  elastigroupId;
    private List<ProcessSuspension> suspensions;
    //endregion


    public String getElastigroupId() {
        return elastigroupId;
    }

    private void setElastigroupId(String elastigroupId) {
        this.elastigroupId = elastigroupId;
    }

    public List<ProcessSuspension> getSuspensions() {
        return suspensions;
    }

    private void setSuspensions(List<ProcessSuspension> suspensions) {
        this.suspensions = suspensions;
    }

    //region Builder
    public static class Builder {
        private ElastigroupSuspendProcessesRequest request;

        private Builder() {
            this.request = new ElastigroupSuspendProcessesRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setElastigroupId(final String elastigroupId) {
            request.setElastigroupId(elastigroupId);
            return this;
        }

        public Builder setSuspensions(final List<ProcessSuspension> suspensions) {
            request.setSuspensions(suspensions);
            return this;
        }

        public ElastigroupSuspendProcessesRequest build() {

            if (request.getElastigroupId() == null) {
                throw new SpotinstValidationException(
                        "Invalid Request - elastigroupId must be set");
            }

            List<ProcessSuspension> suspensions = request.getSuspensions();

            List<ProcessNameEnum> withDuplicates =
                    suspensions.stream().map(ProcessSuspension::getName).collect(Collectors.toList());

            Set<ProcessNameEnum> unique =
                    suspensions.stream().map(ProcessSuspension::getName).collect(Collectors.toSet());

            if (unique.size() != withDuplicates.size()) {
                throw new SpotinstValidationException(
                        "Invalid Request - suspensions cannot contain 2 elements with the same 'name'");
            }

            return request;
        }
    }
    //endregion
}
