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

    private ElastigroupCodeDeployBGDeployment codeDeployBGDeployment;

    private ElastigroupCreateCodeDeployRequest() {
    }

    public ElastigroupCodeDeployBGDeployment getCodeDeployBGDeployment() {
        return codeDeployBGDeployment;
    }

    public void setCodeDeployBGDeployment(ElastigroupCodeDeployBGDeployment codeDeployBGDeployment) {
        this.codeDeployBGDeployment = codeDeployBGDeployment;
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

        public Builder setCodeDeployBGDeployment(ElastigroupCodeDeployBGDeployment codeDeployBGDeployment) {
            createCodeDeployRequest.setCodeDeployBGDeployment(codeDeployBGDeployment);
            return this;
        }

        public ElastigroupCreateCodeDeployRequest build() {
            return createCodeDeployRequest;
        }
    }

    //region Json methods
    public String toJson() {
        ApiElastigroupCodeDeployBGDeployment createCodeDeployRequest = ElastigroupConverter.toDal(codeDeployBGDeployment);
        String                        codeDeploy              = JsonMapper.toJson(createCodeDeployRequest);
        return codeDeploy;
    }

    //endregion

}
