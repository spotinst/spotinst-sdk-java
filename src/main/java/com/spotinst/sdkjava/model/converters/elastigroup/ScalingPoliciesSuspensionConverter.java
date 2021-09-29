package com.spotinst.sdkjava.model.converters.elastigroup;

import com.spotinst.sdkjava.model.api.elastigroup.ApiScalingPolicySuspension;
import com.spotinst.sdkjava.model.api.elastigroup.ApiSuspendedScalingPoliciesList;
import com.spotinst.sdkjava.model.api.elastigroup.ApiSuspendedScalingPolicy;
import com.spotinst.sdkjava.model.bl.elastigroup.ScalingPolicySuspension;
import com.spotinst.sdkjava.model.bl.elastigroup.SuspendedScalingPoliciesList;
import com.spotinst.sdkjava.model.bl.elastigroup.SuspendedScalingPolicy;

import java.util.List;
import java.util.stream.Collectors;

public class ScalingPoliciesSuspensionConverter {

    public static ApiScalingPolicySuspension toDal(ScalingPolicySuspension suspension) {
        ApiScalingPolicySuspension retVal = null;

        if(suspension != null) {
            retVal = new ApiScalingPolicySuspension();

            if (suspension.isTtlInMinutesSet()) {
                retVal.setTtlInMinutes(suspension.getTtlInMinutes());
            }
        }
        return retVal;
    }

    public static SuspendedScalingPolicy toBl(ApiSuspendedScalingPolicy ApiSuspendedScalingPolicy) {

        SuspendedScalingPolicy retVal = null ;

        if(ApiSuspendedScalingPolicy != null ) {
            SuspendedScalingPolicy.Builder suspendedScalingPolicies = SuspendedScalingPolicy.Builder.get();

            if (ApiSuspendedScalingPolicy.isExpiresAtSet()) {
                suspendedScalingPolicies.setExpiresAt(ApiSuspendedScalingPolicy.getExpiresAt());
            }
            if (ApiSuspendedScalingPolicy.isGroupIdSet()) {
                suspendedScalingPolicies.setGroupId(ApiSuspendedScalingPolicy.getGroupId());
            }
            if (ApiSuspendedScalingPolicy.isPolicyNameSet()) {
                suspendedScalingPolicies.setPolicyName(ApiSuspendedScalingPolicy.getPolicyName());
            }
            if (ApiSuspendedScalingPolicy.isStateSet()) {
                suspendedScalingPolicies.setState(ApiSuspendedScalingPolicy.getState());
            }
            retVal = suspendedScalingPolicies.build();
        }
        return retVal;
    }

    public static SuspendedScalingPoliciesList toBl(ApiSuspendedScalingPoliciesList apiPolicyList) {

        SuspendedScalingPoliciesList retVal = null ;

        if(apiPolicyList != null ) {
            SuspendedScalingPoliciesList.Builder suspendedScalingPolicies = SuspendedScalingPoliciesList.Builder.get();

            if (apiPolicyList.isScalePolicySuspensionsSet()) {
                List<SuspendedScalingPolicy> policies =
                        apiPolicyList.getScalePolicySuspensions().stream().map(ScalingPoliciesSuspensionConverter::toBl).collect(Collectors.toList());
                suspendedScalingPolicies.setScalePolicySuspensions(policies);
            }
            retVal = suspendedScalingPolicies.build();
        }
        return retVal;
    }
}
