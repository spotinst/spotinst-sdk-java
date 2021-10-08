package com.spotinst.sdkjava.model.converters;

import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.ApiSuspendgroupProcessesAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.SuspendGroupProcessesAzure;

import java.util.ArrayList;
import java.util.List;

public class ElastigroupConverterSuspendAzure {

    public static List<ApiSuspendgroupProcessesAzure> toDal(List<SuspendGroupProcessesAzure> suspendGroupProcesses) {

        List<ApiSuspendgroupProcessesAzure> retVal = null;
        if (suspendGroupProcesses != null) {
            retVal = new ArrayList<ApiSuspendgroupProcessesAzure>();
            for(SuspendGroupProcessesAzure process : suspendGroupProcesses) {
                ApiSuspendgroupProcessesAzure apiProcess = new ApiSuspendgroupProcessesAzure();
                if (process.isNameSet()) {
                    apiProcess.setName(process.getName());
                }
                if (process.isTtlInMinutesSet()) {
                    apiProcess.setTtlInMinutes(process.getTtlInMinutes());
                }
                retVal.add(apiProcess);
            }
        }
        return retVal;
    }

}
