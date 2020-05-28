package com.spotinst.sdkjava.model;


import com.spotinst.sdkjava.enums.ProcessNameEnum;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yossi.elman on 24/05/2020.
 */
class ApiProcessSuspensionConverter {

    static ApiProcessSuspension toDal(ProcessSuspension apiProcessSuspension) {
        ApiProcessSuspension retVal          = new ApiProcessSuspension();
        ProcessNameEnum      processNameEnum = apiProcessSuspension.getName();

        if (processNameEnum != null) {
            retVal.setName(processNameEnum.getName());
        }

        retVal.setTtlInMinutes(apiProcessSuspension.getTtlInMinutes());

        return retVal;
    }

    public static SuspendedProcesses toBl(ApiSuspendedProcesses apiResponse) {
        SuspendedProcesses retVal = new SuspendedProcesses();

        retVal.setGroupId(apiResponse.getGroupId());
        retVal.setProcesses(apiResponse.getProcesses());

        List<ApiProcessSuspensionResult> apiSuspensions = apiResponse.getSuspensions();

        if (apiSuspensions != null) {
            List<ProcessSuspensionResult> suspensionResults = new LinkedList<>();

            for (ApiProcessSuspensionResult apiResult : apiSuspensions) {
                ProcessSuspensionResult result = toBl(apiResult);
                suspensionResults.add(result);
            }

            retVal.setSuspensions(suspensionResults);
        }

        return retVal;
    }

    private static ProcessSuspensionResult toBl(ApiProcessSuspensionResult apiResult) {
        ProcessSuspensionResult retVal = new ProcessSuspensionResult();

        String processName = apiResult.getName();

        if (processName != null) {
            ProcessNameEnum processNameEnum = ProcessNameEnum.fromName(processName);
            retVal.setName(processNameEnum);
        }

        retVal.setExpiresAt(apiResult.getExpiresAt());

        return retVal;
    }
}
