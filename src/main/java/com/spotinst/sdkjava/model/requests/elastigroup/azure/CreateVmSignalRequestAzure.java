package com.spotinst.sdkjava.model.requests.elastigroup.azure;

import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.ApiVmSignalAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ElastigroupConverterAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.VmSignalAzure;

public class CreateVmSignalRequestAzure {

    private VmSignalAzure vmSignalAzure;

    private CreateVmSignalRequestAzure() {
    }

    public VmSignalAzure getVmSignalAzure() {
        return vmSignalAzure;
    }

    public void setVmSignalAzure(VmSignalAzure vmSignalAzure) {
        this.vmSignalAzure = vmSignalAzure;
    }

    public static class Builder {
        private CreateVmSignalRequestAzure elastigroupVmSignal;

        private Builder() {
            this.elastigroupVmSignal = new CreateVmSignalRequestAzure();
        }

        public static CreateVmSignalRequestAzure.Builder get() {
            return new Builder();
        }

        public CreateVmSignalRequestAzure.Builder setVmSignalAzure(final VmSignalAzure vmSignalAzure) {
            elastigroupVmSignal.setVmSignalAzure(vmSignalAzure);
            return this;
        }

        public CreateVmSignalRequestAzure build() {
            return elastigroupVmSignal;
        }

    }

    public String toJson() {
        ApiVmSignalAzure apiVmSignal = ElastigroupConverterAzure.toDal(vmSignalAzure);

        return JsonMapper.toJson(apiVmSignal);
    }
}