package com.spotinst.sdkjava.model.requests.elastigroup.azure;

import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.ApiVmSignalAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ElastigroupConverterAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.VmSignalAzure;

public class ElastigroupCreateVmSignalRequestAzure {

    private VmSignalAzure vmSignalAzure;

    private ElastigroupCreateVmSignalRequestAzure() {
    }

    public VmSignalAzure getVmSignalAzure() {
        return vmSignalAzure;
    }

    public void setVmSignalAzure(VmSignalAzure vmSignalAzure) {
        this.vmSignalAzure = vmSignalAzure;
    }

    public static class Builder {
        private ElastigroupCreateVmSignalRequestAzure elastigroupVmSignal;

        private Builder() {
            this.elastigroupVmSignal = new ElastigroupCreateVmSignalRequestAzure();
        }

        public static ElastigroupCreateVmSignalRequestAzure.Builder get() {
            ElastigroupCreateVmSignalRequestAzure.Builder builder = new ElastigroupCreateVmSignalRequestAzure.Builder();
            return builder;
        }

        public ElastigroupCreateVmSignalRequestAzure.Builder setVmSignalAzure(final VmSignalAzure vmSignalAzure) {
            elastigroupVmSignal.setVmSignalAzure(vmSignalAzure);
            return this;
        }

        public ElastigroupCreateVmSignalRequestAzure build() {
            return elastigroupVmSignal;
        }

    }

    public String toJson() {
        ApiVmSignalAzure apiVmSignal = ElastigroupConverterAzure.toDal(vmSignalAzure);
        String elastigroupJson = JsonMapper.toJson(apiVmSignal);

        return elastigroupJson;
    }
}