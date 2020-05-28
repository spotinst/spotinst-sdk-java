package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.ProcessNameEnum;
import com.spotinst.sdkjava.exception.SpotinstValidationException;

/**
 * Created by yossi.elman on 24/05/2020.
 */
public class ProcessSuspension {
    //region Members
    private ProcessNameEnum name;
    private Integer         ttlInMinutes;
    //endregion

    //region Getter and Setter methods
    public ProcessNameEnum getName() {
        return name;
    }

    private void setName(ProcessNameEnum name) {
        this.name = name;
    }

    public Integer getTtlInMinutes() {
        return ttlInMinutes;
    }

    private void setTtlInMinutes(Integer ttlInMinutes) {
        this.ttlInMinutes = ttlInMinutes;
    }
    //endregion


    //region Builder
    public static class Builder {
        private ProcessSuspension suspension;

        private Builder() {
            this.suspension = new ProcessSuspension();
        }

        public static ProcessSuspension.Builder get() {
            ProcessSuspension.Builder builder = new ProcessSuspension.Builder();
            return builder;
        }

        public ProcessSuspension.Builder setName(final ProcessNameEnum name) {
            suspension.setName(name);
            return this;
        }

        public ProcessSuspension.Builder setTtlInMinutes(final Integer ttlInMinutes) {
            suspension.setTtlInMinutes(ttlInMinutes);
            return this;
        }

        public ProcessSuspension build() {

            if (suspension.getName() == null) {
                throw new SpotinstValidationException("Invalid Request - suspension name cannot be null");
            }

            return suspension;
        }
    }
    //endregion
}
