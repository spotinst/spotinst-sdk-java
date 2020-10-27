package com.spotinst.sdkjava.model.converters;

import com.spotinst.sdkjava.enums.DeploymentInstanceStatusEnumAzure;
import com.spotinst.sdkjava.enums.GenerationEnumAzure;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment.*;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails.*;
import com.spotinst.sdkjava.enums.GroupDeploymentStateEnumAzure;
import com.spotinst.sdkjava.enums.HealthCheckTypeEnumAzure;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ElastigroupDeploymentDetailsConverterAzure {

    public static GroupDeploymentDetailsAzure toBl(ApiGroupDeploymentDetailsAzure apiGroupDeploymentDetailsAzure) {

        GroupDeploymentDetailsAzure          deploymentDetails = new GroupDeploymentDetailsAzure();
        ApiDeploymentDetailsOverviewAzure    dalOverview       = apiGroupDeploymentDetailsAzure.getDetailsOverview();
        List<ApiDeploymentDetailsBatchAzure> dalBatches        = apiGroupDeploymentDetailsAzure.getBatches();
        List<ApiDeploymentDetailsEventAzure> dalEvents         = apiGroupDeploymentDetailsAzure.getEvents();

        if (dalOverview != null) {
            DeploymentDetailsOverviewAzure overview = toBlOverview(dalOverview);
            deploymentDetails.setDetailsOverview(overview);
        }

        if (dalBatches != null) {
            List<DeploymentDetailsBatchAzure> batches = toBlBatches(dalBatches);
            deploymentDetails.setBatches(batches);
        }

        if (dalEvents != null) {
            List<DeploymentDetailsEventAzure> events = toBlEvents(dalEvents);
            deploymentDetails.setEvents(events);
        }

        return deploymentDetails;
    }

    private static DeploymentDetailsOverviewAzure toBlOverview(ApiDeploymentDetailsOverviewAzure dalOverview) {
        DeploymentDetailsOverviewAzure retVal = new DeploymentDetailsOverviewAzure();
        retVal.setDeploymentId(dalOverview.getDeploymentId());
        retVal.setNumberOfBatches(dalOverview.getNumberOfBatches());
        retVal.setCurrentBatch(dalOverview.getCurrentBatch());
        retVal.setGracePeriod(dalOverview.getGracePeriod());
        retVal.setBlueInstances(dalOverview.getBlueVms());
        retVal.setGreenInstances(dalOverview.getGreenVms());
        retVal.setCreatedAt(dalOverview.getCreatedAt());
        String description  = dalOverview.getDescription();
        String errorMessage = dalOverview.getErrorMessage();

        if (description != null) {
            retVal.setDescription(description);
        }

        if (errorMessage != null) {
            retVal.setErrorMessage(errorMessage);
        }


        List<String> dalHealthChecks = dalOverview.getHealthCheck();

        if (dalHealthChecks != null) {
            List<HealthCheckTypeEnumAzure> blHealthChecks =
                    dalHealthChecks.stream().filter(Objects::nonNull).filter(x -> x.isEmpty() == false)
                                   .map(HealthCheckTypeEnumAzure::fromName).collect(Collectors.toList());

            retVal.setHealthCheck(blHealthChecks);
        }

        return retVal;
    }

    private static List<DeploymentDetailsEventAzure> toBlEvents(List<ApiDeploymentDetailsEventAzure> dalEvents) {
        List<DeploymentDetailsEventAzure> retVal = new LinkedList<>();

        for (ApiDeploymentDetailsEventAzure dalEvent : dalEvents) {
            DeploymentDetailsEventAzure blEvent = toBlEvent(dalEvent);
            retVal.add(blEvent);
        }

        return retVal;
    }

    private static DeploymentDetailsEventAzure toBlEvent(ApiDeploymentDetailsEventAzure dalEvent) {
        DeploymentDetailsEventAzure   retVal    = new DeploymentDetailsEventAzure();
        String                        eventType = dalEvent.getEventType();
        Date                          timestamp = dalEvent.getTimestamp();
        String                        dalStatus = dalEvent.getStatus();
        GroupDeploymentStateEnumAzure blStatus  = GroupDeploymentStateEnumAzure.fromName(dalStatus);

        retVal.setEventType(eventType);
        retVal.setTimestamp(timestamp);
        retVal.setStatus(blStatus);

        return retVal;
    }

    private static List<DeploymentDetailsBatchAzure> toBlBatches(List<ApiDeploymentDetailsBatchAzure> dalBatches) {
        List<DeploymentDetailsBatchAzure> retVal = new LinkedList<>();

        for (ApiDeploymentDetailsBatchAzure dalBatch : dalBatches) {
            DeploymentDetailsBatchAzure blBatch = toBlBatch(dalBatch);
            retVal.add(blBatch);
        }

        return retVal;
    }

    private static DeploymentDetailsBatchAzure toBlBatch(ApiDeploymentDetailsBatchAzure dalBatch) {
        DeploymentDetailsBatchAzure       retVal    = new DeploymentDetailsBatchAzure();
        Integer                           batch     = dalBatch.getBatch();
        List<ApiDeploymentDetailsVmAzure> dalBlues  = dalBatch.getBlue();
        List<ApiDeploymentDetailsVmAzure> dalGreens = dalBatch.getGreen();
        List<DeploymentDetailsVmAzure> blBlues =
                dalBlues.stream().filter(Objects::nonNull).map(ElastigroupDeploymentDetailsConverterAzure::toBlInstance)
                        .collect(Collectors.toList());
        List<DeploymentDetailsVmAzure> blGreens =
                dalGreens.stream().filter(Objects::nonNull).map(ElastigroupDeploymentDetailsConverterAzure::toBlInstance)
                         .collect(Collectors.toList());
        retVal.setBatch(batch);
        retVal.setBlue(blBlues);
        retVal.setGreen(blGreens);

        return retVal;
    }

    private static DeploymentDetailsVmAzure toBlInstance(
            ApiDeploymentDetailsVmAzure apiDeploymentDetailsVmAzure) {
        DeploymentDetailsVmAzure retVal       = new DeploymentDetailsVmAzure();
        Integer                  batchNum     = apiDeploymentDetailsVmAzure.getBatchNum();
        String                   instanceName = apiDeploymentDetailsVmAzure.getVmName();
        Date                     updatedAt    = apiDeploymentDetailsVmAzure.getUpdatedAt();
        String                   dalStatus    = apiDeploymentDetailsVmAzure.getStatus();
        String                   dalType      = apiDeploymentDetailsVmAzure.getType();

        DeploymentInstanceStatusEnumAzure blStatus = DeploymentInstanceStatusEnumAzure.fromName(dalStatus);
        GenerationEnumAzure               blType   = GenerationEnumAzure.fromName(dalType);

        retVal.setBatchNum(batchNum);
        retVal.setVmName(instanceName);
        retVal.setUpdatedAt(updatedAt);
        retVal.setStatus(blStatus);
        retVal.setType(blType);

        return retVal;
    }

}
