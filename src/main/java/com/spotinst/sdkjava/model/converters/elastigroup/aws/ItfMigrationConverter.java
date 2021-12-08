package com.spotinst.sdkjava.model.converters.elastigroup.aws;

import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiItfMigrationRulesStatus;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ItfMigrationRulesStatus;
import com.spotinst.sdkjava.model.requests.elastigroup.aws.ApiRetryItfMigrationRequest;
import com.spotinst.sdkjava.model.requests.elastigroup.aws.RetryItfMigrationRequest;

public class ItfMigrationConverter {
    public static ItfMigrationRulesStatus toBl(ApiItfMigrationRulesStatus apiItfMigrationRulesStatus) {

        ItfMigrationRulesStatus retVal = null ;

        if(apiItfMigrationRulesStatus != null ) {
            ItfMigrationRulesStatus.Builder itfMigration = ItfMigrationRulesStatus.Builder.get();

            if (apiItfMigrationRulesStatus.isIdSet()) {
                itfMigration.setId(apiItfMigrationRulesStatus.getId());
            }
            if (apiItfMigrationRulesStatus.isGroupIdSet()) {
                itfMigration.setGroupId(apiItfMigrationRulesStatus.getGroupId());
            }
            if (apiItfMigrationRulesStatus.isRuleArnSet()) {
                itfMigration.setRuleArn(apiItfMigrationRulesStatus.getRuleArn());
            }
            if (apiItfMigrationRulesStatus.isRuleArnSet()) {
                itfMigration.setStatus(apiItfMigrationRulesStatus.getStatus());
            }
            if (apiItfMigrationRulesStatus.isCreatedAtSet()) {
                itfMigration.setCreatedAt(apiItfMigrationRulesStatus.getCreatedAt());
            }
            if (apiItfMigrationRulesStatus.isUpdatedAtSet()) {
                itfMigration.setUpdatedAt(apiItfMigrationRulesStatus.getUpdatedAt());
            }
            retVal = itfMigration.build();
        }
        return retVal;
    }

    public static ApiItfMigrationRulesStatus toDal(ItfMigrationRulesStatus itfMigrationRulesStatus) {

        ApiItfMigrationRulesStatus retVal = null ;

        if(itfMigrationRulesStatus != null ) {
            retVal = new ApiItfMigrationRulesStatus();

            if (itfMigrationRulesStatus.isIdSet()) {
                retVal.setId(itfMigrationRulesStatus.getId());
            }
            if (itfMigrationRulesStatus.isGroupIdSet()) {
                retVal.setGroupId(itfMigrationRulesStatus.getGroupId());
            }
            if (itfMigrationRulesStatus.isRuleArnSet()) {
                retVal.setRuleArn(itfMigrationRulesStatus.getRuleArn());
            }
            if (itfMigrationRulesStatus.isStatusSet()) {
                retVal.setStatus(itfMigrationRulesStatus.getStatus());
            }
            if (itfMigrationRulesStatus.isCreatedAtSet()) {
                retVal.setCreatedAt(itfMigrationRulesStatus.getCreatedAt());
            }
            if (itfMigrationRulesStatus.isUpdatedAtSet()) {
                retVal.setUpdatedAt(itfMigrationRulesStatus.getUpdatedAt());
            }
         }
        return retVal;
    }

    public static ApiRetryItfMigrationRequest toDal(RetryItfMigrationRequest retryItfMigrationRequest) {

        ApiRetryItfMigrationRequest retVal = null;

        if (retryItfMigrationRequest != null) {
            retVal = new ApiRetryItfMigrationRequest();

            if (retryItfMigrationRequest.getId() != null) {
                retVal.setId(retryItfMigrationRequest.getId());
            }

            if (retryItfMigrationRequest.getMigration() != null) {
                retVal.setMigration(toDal(retryItfMigrationRequest.getMigration()));
            }
        }
        return retVal;
    }
}
