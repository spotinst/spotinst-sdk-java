package com.spotinst.sdkjava.model.requests.elastigroup;

import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.ApiElastigroupVmSignalAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ElastigroupConverterAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ElastigroupVmSignalAzure;

public class ElastigroupCreateVmSignalRequestAzure {

    private ElastigroupVmSignalAzure vmSignalAzure;

    private ElastigroupCreateVmSignalRequestAzure() {
    }

    public ElastigroupVmSignalAzure getVmSignalAzure() {
        return vmSignalAzure;
    }

    public void setVmSignalAzure(ElastigroupVmSignalAzure vmSignalAzure) {
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

        public ElastigroupCreateVmSignalRequestAzure.Builder setVmSignalAzure(final ElastigroupVmSignalAzure vmSignalAzure) {
            elastigroupVmSignal.setVmSignalAzure(vmSignalAzure);
            return this;
        }

        public ElastigroupCreateVmSignalRequestAzure build() {
            return elastigroupVmSignal;
        }

    }

    public String toJson() {
        ApiElastigroupVmSignalAzure apiVmSignal = ElastigroupConverterAzure.toDal(vmSignalAzure);
        String elastigroupJson = JsonMapper.toJson(apiVmSignal);

        return elastigroupJson;
    }
}