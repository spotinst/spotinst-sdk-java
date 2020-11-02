package com.spotinst.sdkjava.model.converters;

import com.spotinst.sdkjava.enums.DeploymentInstanceStatusEnumAzure;
import com.spotinst.sdkjava.enums.GenerationEnumAzure;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment.*;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails.*;
import com.spotinst.sdkjava.enums.GroupDeploymentStateEnumAzure;
import com.spotinst.sdkjava.enums.HealthCheckTypeEnumAzure;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ElastigroupDeploymentDetailsConverterAzure {

    public static GroupDeploymentDetailsAzure toBl(ApiGroupDeploymentDetailsAzure src) {
        GroupDeploymentDetailsAzure retVal = null;

        if (src != null) {
            retVal = new GroupDeploymentDetailsAzure();

            if (src.isDetailsOverviewSet()) {
                DeploymentDetailsOverviewAzure overview = toBlOverview(src.getDetailsOverview());
                retVal.setDetailsOverview(overview);
            }

            if (src.isBatchesSet()) {
                List<DeploymentDetailsBatchAzure> batches = toBlBatches(src.getBatches());
                retVal.setBatches(batches);
            }

            if (src.isEventsSet()) {
                List<DeploymentDetailsEventAzure> events = toBlEvents(src.getEvents());
                retVal.setEvents(events);
            }

        }

        return retVal;
    }

    private static DeploymentDetailsOverviewAzure toBlOverview(ApiDeploymentDetailsOverviewAzure src) {
        DeploymentDetailsOverviewAzure retVal = null;

        if (src != null) {
            retVal = new DeploymentDetailsOverviewAzure();

            if (src.isDeploymentIdSet()) {
                retVal.setDeploymentId(src.getDeploymentId());
            }

            if (src.isNumberOfBatchesSet()) {
                retVal.setNumberOfBatches(src.getNumberOfBatches());
            }

            if (src.isCurrentBatchSet()) {
                retVal.setCurrentBatch(src.getCurrentBatch());
            }

            if (src.isGracePeriodSet()) {
                retVal.setGracePeriod(src.getGracePeriod());
            }

            if (src.isBlueVmsSet()) {
                retVal.setBlueVms(src.getBlueVms());
            }

            if (src.isGreenVmsSet()) {
                retVal.setGreenVms(src.getGreenVms());
            }

            if (src.isCreatedAtSet()) {
                retVal.setCreatedAt(src.getCreatedAt());
            }

            if (src.isDescriptionSet()) {
                retVal.setDescription(src.getDescription());
            }

            if (src.isErrorMessageSet()) {
                retVal.setErrorMessage(src.getErrorMessage());
            }

            if (src.isHealthCheckSet()) {
                List<String> dalHealthChecks = src.getHealthCheck();
                List<HealthCheckTypeEnumAzure> blHealthChecks = null;

                if (dalHealthChecks != null) {
                    blHealthChecks =
                            dalHealthChecks.stream().filter(Objects::nonNull)
                                           .map(HealthCheckTypeEnumAzure::fromName).collect(Collectors.toList());
                }

                retVal.setHealthCheck(blHealthChecks);
            }

        }

        return retVal;
    }

    private static List<DeploymentDetailsEventAzure> toBlEvents(List<ApiDeploymentDetailsEventAzure> dalEvents) {
        List<DeploymentDetailsEventAzure> retVal = null;


        if (dalEvents != null) {
            retVal = new LinkedList<>();

            for (ApiDeploymentDetailsEventAzure dalEvent : dalEvents) {
                DeploymentDetailsEventAzure blEvent = toBlEvent(dalEvent);
                retVal.add(blEvent);
            }
        }
        return retVal;
    }

    private static DeploymentDetailsEventAzure toBlEvent(ApiDeploymentDetailsEventAzure src) {
        DeploymentDetailsEventAzure retVal = null;

        if (src != null) {
            retVal = new DeploymentDetailsEventAzure();

            if (src.isEventTypeSet()) {
                retVal.setEventType(src.getEventType());
            }

            if (src.isTimestampSet()) {
                retVal.setTimestamp(src.getTimestamp());
            }

            if (src.isStatusSet()) {
                String                        dalStatus = src.getStatus();
                GroupDeploymentStateEnumAzure blStatus  = GroupDeploymentStateEnumAzure.fromName(dalStatus);
                retVal.setStatus(blStatus);
            }

        }

        return retVal;
    }

    private static List<DeploymentDetailsBatchAzure> toBlBatches(List<ApiDeploymentDetailsBatchAzure> dalBatches) {
        List<DeploymentDetailsBatchAzure> retVal = null;

        if (dalBatches != null) {
            retVal = new LinkedList<>();

            for (ApiDeploymentDetailsBatchAzure dalBatch : dalBatches) {
                DeploymentDetailsBatchAzure blBatch = toBlBatch(dalBatch);
                retVal.add(blBatch);
            }

        }

        return retVal;
    }

    private static DeploymentDetailsBatchAzure toBlBatch(ApiDeploymentDetailsBatchAzure src) {
        DeploymentDetailsBatchAzure retVal = null;

        if (src != null) {
            retVal = new DeploymentDetailsBatchAzure();

            if (src.isBatchSet()) {
                retVal.setBatch(src.getBatch());
            }

            if (src.isBlueSet()) {
                List<ApiDeploymentDetailsVirtualMachineAzure> dalBlues = src.getBlue();
                List<DeploymentDetailsVirtualMachineAzure> blBlues = null;

                if (dalBlues != null) {
                    blBlues = dalBlues.stream().filter(Objects::nonNull)
                                      .map(ElastigroupDeploymentDetailsConverterAzure::toBlInstance)
                                      .collect(Collectors.toList());
                }

                retVal.setBlue(blBlues);
            }

            if (src.isGreenSet()) {
                List<ApiDeploymentDetailsVirtualMachineAzure> dalGreens = src.getGreen();
                List<DeploymentDetailsVirtualMachineAzure> blGreens = null;

                if (dalGreens != null) {
                    blGreens = dalGreens.stream().filter(Objects::nonNull)
                                      .map(ElastigroupDeploymentDetailsConverterAzure::toBlInstance)
                                      .collect(Collectors.toList());
                }

                retVal.setGreen(blGreens);
            }

        }

        return retVal;
    }

    private static DeploymentDetailsVirtualMachineAzure toBlInstance(ApiDeploymentDetailsVirtualMachineAzure src) {

        DeploymentDetailsVirtualMachineAzure retVal = null;

        if (src != null) {
            retVal = new DeploymentDetailsVirtualMachineAzure();

            if (src.isBatchNumSet()) {
                retVal.setBatchNum(src.getBatchNum());
            }

            if (src.isVmNameSet()) {
                retVal.setVmName(src.getVmName());
            }

            if (src.isUpdatedAtSet()) {
                retVal.setUpdatedAt(src.getUpdatedAt());
            }

            if (src.isStatusSet()) {
                DeploymentInstanceStatusEnumAzure blStatus =
                        DeploymentInstanceStatusEnumAzure.fromName(src.getStatus());
                retVal.setStatus(blStatus);
            }

            if (src.isTypeSet()) {
                GenerationEnumAzure blType = GenerationEnumAzure.fromName(src.getType());
                retVal.setType(blType);
            }

        }

        return retVal;
    }

}
