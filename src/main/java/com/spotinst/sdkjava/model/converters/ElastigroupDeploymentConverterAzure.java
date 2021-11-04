package com.spotinst.sdkjava.model.converters;

import com.spotinst.sdkjava.enums.GroupDeploymentStateEnumAzure;
import com.spotinst.sdkjava.enums.HealthCheckTypeEnumAzure;
import com.spotinst.sdkjava.enums.AzureUnitEnum;
import com.spotinst.sdkjava.model.GroupDeploymentCreationRequestAzure;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment.*;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentProgressIndicatorAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.GroupDeploymentCreateAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.GroupDeploymentGetAzure;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ElastigroupDeploymentConverterAzure {
    public static ApiGroupDeploymentRequestAzure toDal(GroupDeploymentCreationRequestAzure src) {
        ApiGroupDeploymentRequestAzure retVal = null;

        if (src != null) {
            retVal = new ApiGroupDeploymentRequestAzure();

            if (src.isBatchSizePercentageSet()) {
                retVal.setBatchSizePercentage(src.getBatchSizePercentage());

            }

            if (src.isHealthCheckTypesSet()) {
                List<HealthCheckTypeEnumAzure> blHealthChecks = src.getHealthCheckTypes();
                List<String> dalHealthCheckTypes = null;

                if (blHealthChecks != null) {
                    dalHealthCheckTypes =
                            blHealthChecks.stream().filter(Objects::nonNull).map(HealthCheckTypeEnumAzure::getName)
                                          .collect(Collectors.toList());

                }
                retVal.setHealthCheckTypes(dalHealthCheckTypes);
            }

            if (src.isDrainingTimeoutSet()) {
                retVal.setDrainingTimeout(src.getDrainingTimeout());
            }

            if (src.isBatchMinHealthyPercentageSet()) {
                retVal.setBatchMinHealthyPercentage(src.getBatchMinHealthyPercentage());
            }

            if (src.isGracePeriodSet()) {
                retVal.setGracePeriod(src.getGracePeriod());
            }
        }

        return retVal;
    }

    public static GroupDeploymentCreateAzure toBlCreate(ApiCreateDeploymentAzure src) {
        GroupDeploymentCreateAzure retVal = null;

        if (src != null) {
            retVal = new GroupDeploymentCreateAzure();

            if (src.isIdSet()) {
                retVal.setId(src.getId());
            }

            if (src.isCreatedAtSet()) {
                retVal.setCreatedAt(src.getCreatedAt());
            }

            if (src.isUpdatedAtSet()) {
                retVal.setUpdatedAt(src.getUpdatedAt());
            }

            if (src.isCurrentBatchSet()) {
                retVal.setCurrentBatch(src.getCurrentBatch());
            }

            if (src.isGroupIdSet()) {
                retVal.setGroupId(src.getGroupId());
            }

            if (src.isNumOfBatchesSet()) {
                retVal.setNumOfBatches(src.getNumOfBatches());
            }

            if (src.isStatusSet()) {
                String dalStatus = src.getStatus();
                GroupDeploymentStateEnumAzure blStatus = null;

                if (dalStatus != null) {
                    blStatus = GroupDeploymentStateEnumAzure.fromName(dalStatus);
                }

                retVal.setStatus(blStatus);

            }

            if (src.isProgressSet()) {
                ApiDeploymentProgressIndicatorAzure dalProgressIndicator = src.getProgress();
                DeploymentProgressIndicatorAzure blProgressIndicator = null;

                if (dalProgressIndicator != null) {
                    blProgressIndicator = toBlProgress(dalProgressIndicator);
                }

                retVal.setProgress(blProgressIndicator);

            }

        }

        return retVal;
    }

    public static GroupDeploymentGetAzure toBlGet(ApiGetDeploymentAzure src) {
        GroupDeploymentGetAzure retVal = null;

        if (src != null) {
            retVal = new GroupDeploymentGetAzure();

            if (src.isIdSet()) {
                retVal.setId(src.getId());
            }

            if (src.isCreatedAtSet()) {
                retVal.setCreatedAt(src.getCreatedAt());
            }

            if (src.isProgressSet()) {
                ApiDeploymentProgressIndicatorAzure dalProgressIndicator = src.getProgress();
                DeploymentProgressIndicatorAzure blProgressIndicator = null;

                if (dalProgressIndicator != null) {
                    blProgressIndicator = toBlProgress(dalProgressIndicator);
                }

                retVal.setProgress(blProgressIndicator);

            }

            if (src.isStatusSet()) {
                String dalStatus = src.getStatus();
                GroupDeploymentStateEnumAzure blStatus = null;

                if (dalStatus != null) {
                    blStatus = GroupDeploymentStateEnumAzure.fromName(dalStatus);
                }

                retVal.setStatus(blStatus);

            }

            if (src.isUpdatedAtSet()) {
                retVal.setUpdatedAt(src.getUpdatedAt());
            }

        }

        return retVal;
    }

    private static DeploymentProgressIndicatorAzure toBlProgress(ApiDeploymentProgressIndicatorAzure src) {
        DeploymentProgressIndicatorAzure retVal = null;

        if (src != null) {
            retVal = new DeploymentProgressIndicatorAzure();

            if (src.isValueSet()) {
                retVal.setValue(src.getValue());
            }

            if (src.isUnitSet()) {
                String unit = src.getUnit();
                AzureUnitEnum blUnit = null;
                if (unit != null) {

                    // GetDeployment and CreateDeployment responses return different strings for the same Enum
                    // so we convert here.
                    if (unit.equals("percent")) {
                        unit = "percentage";
                    }

                    blUnit = AzureUnitEnum.fromName(unit);
                }

                retVal.setUnit(blUnit);

            }

        }

        return retVal;
    }

}
