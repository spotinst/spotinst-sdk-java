package com.spotinst.sdkjava.model.requests.elastigroup.aws;

import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.ElastigroupConverter;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiElastigroupCodeDeployBGDeployment;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ElastigroupCodeDeployBGDeployment;

/**
 * @author: Saikumar Jalda
 * @since: 01/03/2022
 */
public class ElastigroupCreateCodeDeployRequest {

    private ElastigroupCodeDeployBGDeployment deployment;

    private ElastigroupCreateCodeDeployRequest() {
    }

    public ElastigroupCodeDeployBGDeployment getCodeDeployBGDeployment() {
        return deployment;
    }

    public void setCodeDeployBGDeployment(ElastigroupCodeDeployBGDeployment deployment) {
        this.deployment = deployment;
    }

    public static class Builder {
        private ElastigroupCreateCodeDeployRequest createCodeDeployRequest;

        private Builder() {
            this.createCodeDeployRequest = new ElastigroupCreateCodeDeployRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setCodeDeployBGDeployment(ElastigroupCodeDeployBGDeployment deployment) {
            createCodeDeployRequest.setCodeDeployBGDeployment(deployment);
            return this;
        }

        public ElastigroupCreateCodeDeployRequest build() {
            return createCodeDeployRequest;
        }
    }

    //region Json methods
    public String toJson() {
        ApiElastigroupCodeDeployBGDeployment createCodeDeployRequest = ElastigroupConverter.toDal(deployment);
        String                        codeDeploy              = JsonMapper.toJson(createCodeDeployRequest);
        return codeDeploy;
    }

    //endregion

}
