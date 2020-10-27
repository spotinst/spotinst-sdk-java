package com.spotinst.sdkjava.model.converters;

import com.spotinst.sdkjava.enums.GroupDeploymentStateEnumAzure;
import com.spotinst.sdkjava.enums.HealthCheckTypeEnumAzure;
import com.spotinst.sdkjava.enums.UnitEnum;
import com.spotinst.sdkjava.model.GroupDeploymentCreationRequestAzure;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment.*;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ElastigroupDeploymentConverterAzure {
    public static ApiGroupDeploymentRequestAzure toDal(GroupDeploymentCreationRequestAzure creationReq) {

        ApiGroupDeploymentRequestAzure retVal                    = new ApiGroupDeploymentRequestAzure();
        Integer                        batchSizePercentage       = creationReq.getBatchSizePercentage();
        List<HealthCheckTypeEnumAzure> healthCheckTypes          = creationReq.getHealthCheckTypes();
        Integer                        drainingTimeout           = creationReq.getDrainingTimeout();
        Integer                        batchMinHealthyPercentage = creationReq.getBatchMinHealthyPercentage();
        Integer                        gracePeriod               = creationReq.getGracePeriod();

        if (batchSizePercentage != null) {
            retVal.setBatchSizePercentage(batchSizePercentage);
        }

        if (healthCheckTypes != null) {
            List<String> dalHealthCheckTypes =
                    healthCheckTypes.stream().filter(Objects::nonNull).map(HealthCheckTypeEnumAzure::getName)
                                    .collect(Collectors.toList());

            retVal.setHealthCheckTypes(dalHealthCheckTypes);
        }

        if (drainingTimeout != null) {
            retVal.setDrainingTimeout(drainingTimeout);
        }

        if (batchMinHealthyPercentage != null) {
            retVal.setBatchMinHealthyPercentage(batchMinHealthyPercentage);
        }

        if (gracePeriod != null) {
            retVal.setGracePeriod(gracePeriod);
        }

        return retVal;
    }

    public static GroupDeploymentAzure toBl(ApiDeploymentAzure apiCreatedDeployment) {
        GroupDeploymentAzure retVal = new GroupDeploymentAzure();

        retVal.setId(apiCreatedDeployment.getId());
        retVal.setCreatedAt(apiCreatedDeployment.getCreatedAt());
        retVal.setUpdatedAt(apiCreatedDeployment.getUpdatedAt());
        retVal.setCurrentBatch(apiCreatedDeployment.getCurrentBatch());
        retVal.setGroupId(apiCreatedDeployment.getGroupId());
        retVal.setNumOfBatches(apiCreatedDeployment.getNumOfBatches());
        String                        dalStatus = apiCreatedDeployment.getStatus();
        GroupDeploymentStateEnumAzure blStatus  = GroupDeploymentStateEnumAzure.fromName(dalStatus);
        retVal.setStatus(blStatus);
        ApiDeploymentProgressIndicatorAzure dalProgressIndicator = apiCreatedDeployment.getProgress();
        DeploymentProgressIndicatorAzure    blProgressIndicator  = toBlProgress(dalProgressIndicator);
        retVal.setProgress(blProgressIndicator);

        return retVal;
    }

    private static DeploymentProgressIndicatorAzure toBlProgress(
            ApiDeploymentProgressIndicatorAzure dalProgressIndicator) {
        DeploymentProgressIndicatorAzure retVal  = new DeploymentProgressIndicatorAzure();
        Float                            value   = dalProgressIndicator.getValue();
        String                           dalUnit = dalProgressIndicator.getUnit();
        UnitEnum                         blUnit  = UnitEnum.fromName(dalUnit);
        retVal.setValue(value);
        retVal.setUnit(blUnit);

        return retVal;
    }

}
