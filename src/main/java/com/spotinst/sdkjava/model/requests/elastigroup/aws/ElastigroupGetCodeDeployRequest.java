package com.spotinst.sdkjava.model.requests.elastigroup.aws;

import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.ElastigroupConverter;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiElastigroupCodeDeployBGDeployment;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ElastigroupCodeDeployBGDeployment;

/**
 * @author: Saikumar Jalda
 * @since: 01/03/2022
 */
public class ElastigroupGetCodeDeployRequest {

    private ElastigroupCodeDeployBGDeployment codeDeployBGDeployment;

    private ElastigroupGetCodeDeployRequest() {
    }

    public ElastigroupCodeDeployBGDeployment getCodeDeployBGDeployment() {
        return codeDeployBGDeployment;
    }

    public void setCodeDeployBGDeployment(ElastigroupCodeDeployBGDeployment codeDeployBGDeployment) {
        this.codeDeployBGDeployment = codeDeployBGDeployment;
    }

    public static class Builder {
        private ElastigroupGetCodeDeployRequest getCodeDeployRequest;

        private Builder() {
            this.getCodeDeployRequest = new ElastigroupGetCodeDeployRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setCodeDeployBGDeployment(ElastigroupCodeDeployBGDeployment codeDeployBGDeployment) {
            getCodeDeployRequest.setCodeDeployBGDeployment(codeDeployBGDeployment);
            return this;
        }

        public ElastigroupGetCodeDeployRequest build() {
            return getCodeDeployRequest;
        }
    }

    //region Json methods
    public String toJson() {
        ApiElastigroupCodeDeployBGDeployment getCodeDeployRequest = ElastigroupConverter.toDal(codeDeployBGDeployment);
        String                        getCodeDeploy              = JsonMapper.toJson(getCodeDeployRequest);
        return getCodeDeploy;
    }

    //endregion

}
