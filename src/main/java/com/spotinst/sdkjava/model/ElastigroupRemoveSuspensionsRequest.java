package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.ProcessNameEnum;
import com.spotinst.sdkjava.exception.SpotinstValidationException;

import java.util.List;

/**
 * Created by yossi.elman on 24/05/2020.
 */

public class ElastigroupRemoveSuspensionsRequest {
    //region Members
    private String                elastigroupId;
    private List<ProcessNameEnum> processes;
    //endregion

    public String getElastigroupId() {
        return elastigroupId;
    }

    private void setElastigroupId(String elastigroupId) {
        this.elastigroupId = elastigroupId;
    }

    public List<ProcessNameEnum> getProcesses() {
        return processes;
    }

    private void setProcesses(List<ProcessNameEnum> processes) {
        this.processes = processes;
    }

    //region Builder
    public static class Builder {
        private ElastigroupRemoveSuspensionsRequest request;

        private Builder() {
            this.request = new ElastigroupRemoveSuspensionsRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setElastigroupId(final String elastigroupId) {
            request.setElastigroupId(elastigroupId);
            return this;
        }

        public Builder setProcesses(final List<ProcessNameEnum> processes) {
            request.setProcesses(processes);
            return this;
        }


        public ElastigroupRemoveSuspensionsRequest build() {
            if (request.getElastigroupId() == null) {
                throw new SpotinstValidationException(
                        "Invalid Request - elastigroupId must be set");
            }

            return request;
        }
    }
    //endregion
}
