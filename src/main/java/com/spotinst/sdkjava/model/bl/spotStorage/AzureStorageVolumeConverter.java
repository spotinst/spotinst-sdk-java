package com.spotinst.sdkjava.model.bl.spotStorage;

import com.spotinst.sdkjava.model.api.spotStorage.*;
import com.spotinst.sdkjava.model.api.spotStorage.ApiAzureStorageVolume;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AzureStorageVolumeConverter {
    //region BL -> DAL

    public static ApiAzureStorageVolume toDal(AzureStorageVolume src) {

        ApiAzureStorageVolume retVal = null;

        if (src != null) {
            retVal = new ApiAzureStorageVolume();

            if (src.isIdSet()) {
                retVal.setId(src.getId());
            }

            if (src.isNameSet()) {
                retVal.setName(src.getName());
            }

            if (src.isRegionSet()) {
                retVal.setRegion(src.getRegion());
            }

            if (src.isCapacitySet()) {
                retVal.setCapacity(toDal(src.getCapacity()));
            }

            if (src.isThroughputSet()) {
                retVal.setThroughput(toDal(src.getThroughput()));
            }

            if (src.isVolumeSpecSet()) {
                retVal.setVolumeSpec(toDal(src.getVolumeSpec()));
            }

            if (src.isAutoResizeSet()) {
                retVal.setAutoResize(toDal(src.getAutoResize()));
            }

            if (src.isStateSet()) {
                retVal.setState(src.getState());
            }

            if (src.isCreatedAtSet()) {
                retVal.setCreatedAt(src.getCreatedAt());
            }

            if (src.isUpdatedAtSet()) {
                retVal.setUpdatedAt(src.getUpdatedAt());
            }
        }

        return retVal;
    }

    private static ApiAzureStorageVolumeCapacity toDal(AzureStorageVolumeCapacity capacity) {
        ApiAzureStorageVolumeCapacity retVal = null;

        if (capacity != null) {
            retVal = new ApiAzureStorageVolumeCapacity();

            if (capacity.isSizeGiBSet()) {
                retVal.setSizeGiB(capacity.getSizeGiB());
            }

            if (capacity.isMinSizeGiBSet()) {
                retVal.setMinSizeGiB(capacity.getMinSizeGiB());
            }

            if (capacity.isMaxSizeGiBSet()) {
                retVal.setMaxSizeGiB(capacity.getMaxSizeGiB());
            }
        }

        return retVal;
    }

    private static ApiAzureStorageVolumeThroughput toDal(AzureStorageVolumeThroughput throughput) {
        ApiAzureStorageVolumeThroughput retVal = null;

        if (throughput != null) {
            retVal = new ApiAzureStorageVolumeThroughput();

            if (throughput.isThroughputMibpsSet()) {
                retVal.setThroughputMibps(throughput.getThroughputMibps());
            }
        }

        return retVal;
    }

    private static ApiAzureStorageVolumeSpec toDal(AzureStorageVolumeSpec volumeSpec) {

        ApiAzureStorageVolumeSpec retVal = null;

        if (volumeSpec != null) {
            retVal = new ApiAzureStorageVolumeSpec();

            if (volumeSpec.isNetworkSet()) {
                retVal.setNetwork(toDal(volumeSpec.getNetwork()));
            }

            if (volumeSpec.isProtocolSet()) {
                retVal.setProtocol(toDal(volumeSpec.getProtocol()));
            }

            if (volumeSpec.isServiceLevelSet()) {
                retVal.setServiceLevel(volumeSpec.getServiceLevel());
            }

            if (volumeSpec.isTagsSet()) {

                if (volumeSpec.getTags() != null) {
                    List<ApiAzureStorageVolumeTag> tags =
                            volumeSpec.getTags().stream().map(AzureStorageVolumeConverter::toDal).collect(Collectors.toList());
                    retVal.setTags(tags);
                }
                else {
                    retVal.setTags(null);

                }
            }
        }

        return retVal;
    }

    private static ApiAzureStorageVolumeAutoResize toDal(AzureStorageVolumeAutoResize volumeAutoResize) {
        ApiAzureStorageVolumeAutoResize retVal = null;

        if (volumeAutoResize != null) {
            retVal = new ApiAzureStorageVolumeAutoResize();

            if (volumeAutoResize.isModeSet()) {
                retVal.setMode(volumeAutoResize.getMode());
            }

            if (volumeAutoResize.isPolicyTypeSet()) {
                retVal.setPolicyType(volumeAutoResize.getPolicyType());
            }

            if (volumeAutoResize.isResizePoliciesSet()) {

                if (volumeAutoResize.getResizePolicies() != null) {
                    List<ApiAzureStorageVolumeAutoResizeResizePolicy> policies =
                            volumeAutoResize.getResizePolicies().stream().map(AzureStorageVolumeConverter::toDal)
                                            .collect(Collectors.toList());
                    retVal.setResizePolicies(policies);
                }
                else {
                    retVal.setResizePolicies(null);

                }
            }
        }

        return retVal;
    }

    private static ApiAzureStorageVolumeSpecNetwork toDal(AzureStorageVolumeSpecNetwork volumeSpecNetwork) {
        ApiAzureStorageVolumeSpecNetwork retVal = null;

        if (volumeSpecNetwork != null) {
            retVal = new ApiAzureStorageVolumeSpecNetwork();

            if (volumeSpecNetwork.isResourceGroupNameSet()) {
                retVal.setResourceGroupName(volumeSpecNetwork.getResourceGroupName());
            }

            if (volumeSpecNetwork.isVirtualNetworkNameSet()) {
                retVal.setVirtualNetworkName(volumeSpecNetwork.getVirtualNetworkName());
            }

            if (volumeSpecNetwork.isSubnetNameSet()) {
                retVal.setSubnetName(volumeSpecNetwork.getSubnetName());
            }
        }

        return retVal;
    }

    private static ApiAzureStorageVolumeSpecProtocol toDal(AzureStorageVolumeSpecProtocol volumeSpecProtocol) {
        ApiAzureStorageVolumeSpecProtocol retVal = null;

        if (volumeSpecProtocol != null) {
            retVal = new ApiAzureStorageVolumeSpecProtocol();

            if (volumeSpecProtocol.isTypesSet()) {

                if (volumeSpecProtocol.getTypes() == null) {
                    retVal.setTypes(null);
                }
                else {
                    retVal.setTypes(new LinkedList<>(volumeSpecProtocol.getTypes()));
                }
            }

            if (volumeSpecProtocol.isMountPathSet()) {
                retVal.setMountPath(volumeSpecProtocol.getMountPath());
            }

            if (volumeSpecProtocol.isExportPolicySet()) {
                retVal.setExportPolicy(toDal(volumeSpecProtocol.getExportPolicy()));
            }

            if (volumeSpecProtocol.isKerberosEnabledSet()) {
                retVal.setKerberosEnabled(volumeSpecProtocol.getKerberosEnabled());
            }

            if (volumeSpecProtocol.isSecurityStyleSet()) {
                retVal.setSecurityStyle(volumeSpecProtocol.getSecurityStyle());
            }
        }

        return retVal;
    }

    private static ApiAzureStorageVolumeTag toDal(AzureStorageVolumeTag volumeTag) {
        ApiAzureStorageVolumeTag retVal = null;

        if (volumeTag != null) {
            retVal = new ApiAzureStorageVolumeTag();

            if (volumeTag.isTagKeySet()) {
                retVal.setTagKey(volumeTag.getTagKey());
            }

            if (volumeTag.isTagValueSet()) {
                retVal.setTagValue(volumeTag.getTagValue());
            }
        }

        return retVal;
    }

    private static ApiAzureStorageVolumeSpecProtocolExportPolicy toDal(
            AzureStorageVolumeSpecProtocolExportPolicy volumeSpecProtocolExportPolicy) {
        ApiAzureStorageVolumeSpecProtocolExportPolicy retVal = null;

        if (volumeSpecProtocolExportPolicy != null) {
            retVal = new ApiAzureStorageVolumeSpecProtocolExportPolicy();

            if (volumeSpecProtocolExportPolicy.isRulesSet()) {

                if (volumeSpecProtocolExportPolicy.getRules() != null) {
                    List<ApiAzureStorageVolumeSpecProtocolExportPolicyRule> resizePolicies =
                            volumeSpecProtocolExportPolicy.getRules().stream().map(AzureStorageVolumeConverter::toDal)
                                                          .collect(Collectors.toList());
                    retVal.setRules(resizePolicies);
                }
                else {
                    retVal.setRules(null);

                }
            }
        }

        return retVal;
    }

    private static ApiAzureStorageVolumeSpecProtocolExportPolicyRule toDal(
            AzureStorageVolumeSpecProtocolExportPolicyRule volumeSpecProtocolExportPolicyRule) {
        ApiAzureStorageVolumeSpecProtocolExportPolicyRule retVal = null;

        if (volumeSpecProtocolExportPolicyRule != null) {
            retVal = new ApiAzureStorageVolumeSpecProtocolExportPolicyRule();


            if (volumeSpecProtocolExportPolicyRule.isIndexSet()) {
                retVal.setIndex(volumeSpecProtocolExportPolicyRule.getIndex());
            }

            if (volumeSpecProtocolExportPolicyRule.isAllowedClientsSet()) {
                retVal.setAllowedClients(volumeSpecProtocolExportPolicyRule.getAllowedClients());
            }

            if (volumeSpecProtocolExportPolicyRule.isAccessSet()) {
                retVal.setAccess(volumeSpecProtocolExportPolicyRule.getAccess());
            }

            if (volumeSpecProtocolExportPolicyRule.isRootSet()) {
                retVal.setRoot(volumeSpecProtocolExportPolicyRule.getRoot());
            }

            if (volumeSpecProtocolExportPolicyRule.isKerberosRuleAccessesSet()) {

                if (volumeSpecProtocolExportPolicyRule.getKerberosRuleAccesses() == null) {
                    retVal.setKerberosRuleAccesses(null);
                }
                else {
                    retVal.setKerberosRuleAccesses(
                            new LinkedList<>(volumeSpecProtocolExportPolicyRule.getKerberosRuleAccesses()));
                }
            }

        }
        return retVal;

    }

    private static ApiAzureStorageVolumeAutoResizeResizePolicy toDal(
            AzureStorageVolumeAutoResizeResizePolicy volumeAutoResizeResizePolicy) {
        ApiAzureStorageVolumeAutoResizeResizePolicy retVal = null;

        if (volumeAutoResizeResizePolicy != null) {
            retVal = new ApiAzureStorageVolumeAutoResizeResizePolicy();

            if (volumeAutoResizeResizePolicy.isPolicyNameSet()) {
                retVal.setPolicyName(volumeAutoResizeResizePolicy.getPolicyName());
            }

            if (volumeAutoResizeResizePolicy.isUsagePercentageSet()) {
                retVal.setUsagePercentage(volumeAutoResizeResizePolicy.getUsagePercentage());
            }

            if (volumeAutoResizeResizePolicy.isOperatorSet()) {
                retVal.setOperator(volumeAutoResizeResizePolicy.getOperator());
            }

            if (volumeAutoResizeResizePolicy.isActionSet()) {
                retVal.setAction(toDal(volumeAutoResizeResizePolicy.getAction()));
            }

            if (volumeAutoResizeResizePolicy.isPeriodSet()) {
                retVal.setPeriod(volumeAutoResizeResizePolicy.getPeriod());
            }

            if (volumeAutoResizeResizePolicy.isConsecutivePeriodsSet()) {
                retVal.setConsecutivePeriods(volumeAutoResizeResizePolicy.getConsecutivePeriods());
            }

            if (volumeAutoResizeResizePolicy.isCooldownSet()) {
                retVal.setCooldown(volumeAutoResizeResizePolicy.getCooldown());
            }

        }
        return retVal;
    }

    private static ApiAzureStorageVolumeAutoResizeResizePolicyAction toDal(
            AzureStorageVolumeAutoResizeResizePolicyAction volumeAutoResizeResizePolicyAction) {
        ApiAzureStorageVolumeAutoResizeResizePolicyAction retVal = null;

        if (volumeAutoResizeResizePolicyAction != null) {
            retVal = new ApiAzureStorageVolumeAutoResizeResizePolicyAction();

            if (volumeAutoResizeResizePolicyAction.isTypeSet()) {
                retVal.setType(volumeAutoResizeResizePolicyAction.getType());
            }

            if (volumeAutoResizeResizePolicyAction.isAdjustmentPercentageSet()) {
                retVal.setAdjustmentPercentage(volumeAutoResizeResizePolicyAction.getAdjustmentPercentage());
            }
        }
        return retVal;
    }
    //endregion

    //region DAL -> BL
    public static AzureStorageVolume toBl(ApiAzureStorageVolume src) {

        AzureStorageVolume retVal = null;

        if (src != null) {
            AzureStorageVolume.Builder builder = AzureStorageVolume.Builder.get();

            if (src.isIdSet()) {
                builder.setId(src.getId());
            }

            if (src.isNameSet()) {
                builder.setName(src.getName());
            }

            if (src.isRegionSet()) {
                builder.setRegion(src.getRegion());
            }

            if (src.isCapacitySet()) {
                builder.setCapacity(toBl(src.getCapacity()));
            }

            if (src.isThroughputSet()) {
                builder.setThroughput(toBl(src.getThroughput()));
            }

            if (src.isVolumeSpecSet()) {
                builder.setVolumeSpec(toBl(src.getVolumeSpec()));
            }

            if (src.isAutoResizeSet()) {
                builder.setAutoResize(toBl(src.getAutoResize()));
            }

            if (src.isStateSet()) {
                builder.setState(src.getState());
            }

            retVal = builder.build();

            // createdAt is not taken from builder since it cannot be set when creating/updating a Volume
            if (src.isCreatedAtSet()) {
                retVal.setCreatedAt(src.getCreatedAt());
            }

            if (src.isUpdatedAtSet()) {
                retVal.setUpdatedAt(src.getUpdatedAt());
            }

        }

        return retVal;
    }

    private static AzureStorageVolumeCapacity toBl(ApiAzureStorageVolumeCapacity capacity) {
        AzureStorageVolumeCapacity retVal = null;

        if (capacity != null) {
            AzureStorageVolumeCapacity.Builder builder = AzureStorageVolumeCapacity.Builder.get();

            if (capacity.isSizeGiBSet()) {
                builder.setSizeGiB(capacity.getSizeGiB());
            }

            if (capacity.isMinSizeGiBSet()) {
                builder.setMinSizeGiB(capacity.getMinSizeGiB());
            }

            if (capacity.isMaxSizeGiBSet()) {
                builder.setMaxSizeGiB(capacity.getMaxSizeGiB());
            }

            retVal = builder.build();

        }

        return retVal;
    }

    private static AzureStorageVolumeThroughput toBl(ApiAzureStorageVolumeThroughput throughput) {
        AzureStorageVolumeThroughput retVal = null;

        if (throughput != null) {
            AzureStorageVolumeThroughput.Builder builder = AzureStorageVolumeThroughput.Builder.get();

            if (throughput.isThroughputMibpsSet()) {
                builder.setThroughputMibps(throughput.getThroughputMibps());
            }

            retVal = builder.build();

        }

        return retVal;
    }

    private static AzureStorageVolumeSpec toBl(ApiAzureStorageVolumeSpec volumeSpec) {

        AzureStorageVolumeSpec retVal = null;

        if (volumeSpec != null) {
            AzureStorageVolumeSpec.Builder builder = AzureStorageVolumeSpec.Builder.get();

            if (volumeSpec.isNetworkSet()) {
                builder.setNetwork(toBl(volumeSpec.getNetwork()));
            }

            if (volumeSpec.isProtocolSet()) {
                builder.setProtocol(toBl(volumeSpec.getProtocol()));
            }

            if (volumeSpec.isServiceLevelSet()) {
                builder.setServiceLevel(volumeSpec.getServiceLevel());
            }

            if (volumeSpec.isTagsSet()) {

                if (volumeSpec.getTags() != null) {
                    List<ApiAzureStorageVolumeTag> apiTags = volumeSpec.getTags();
                    List<AzureStorageVolumeTag>    tags    = apiTags.stream().map(AzureStorageVolumeConverter::toBl).collect(Collectors.toList());
                    builder.setTags(tags);
                }
                else {
                    builder.setTags(null);

                }
            }

            retVal = builder.build();

        }

        return retVal;
    }

    private static AzureStorageVolumeAutoResize toBl(ApiAzureStorageVolumeAutoResize volumeAutoResize) {
        AzureStorageVolumeAutoResize retVal = null;

        if (volumeAutoResize != null) {
            AzureStorageVolumeAutoResize.Builder builder = AzureStorageVolumeAutoResize.Builder.get();

            if (volumeAutoResize.isModeSet()) {
                builder.setMode(volumeAutoResize.getMode());
            }

            if (volumeAutoResize.isPolicyTypeSet()) {
                builder.setPolicyType(volumeAutoResize.getPolicyType());
            }

            if (volumeAutoResize.isResizePoliciesSet()) {
                if (volumeAutoResize.getResizePolicies() != null) {
                    List<ApiAzureStorageVolumeAutoResizeResizePolicy> apiPolicies =
                            volumeAutoResize.getResizePolicies();
                    List<AzureStorageVolumeAutoResizeResizePolicy> policies =
                            apiPolicies.stream().map(AzureStorageVolumeConverter::toBl).collect(Collectors.toList());
                    builder.setResizePolicies(policies);
                }
                else {
                    builder.setResizePolicies(null);

                }
            }

            retVal = builder.build();

        }

        return retVal;
    }

    private static AzureStorageVolumeSpecNetwork toBl(ApiAzureStorageVolumeSpecNetwork volumeSpecNetwork) {
        AzureStorageVolumeSpecNetwork retVal = null;

        if (volumeSpecNetwork != null) {
            AzureStorageVolumeSpecNetwork.Builder builder = AzureStorageVolumeSpecNetwork.Builder.get();

            if (volumeSpecNetwork.isResourceGroupNameSet()) {
                builder.setResourceGroupName(volumeSpecNetwork.getResourceGroupName());
            }

            if (volumeSpecNetwork.isVirtualNetworkNameSet()) {
                builder.setVirtualNetworkName(volumeSpecNetwork.getVirtualNetworkName());
            }

            if (volumeSpecNetwork.isSubnetNameSet()) {
                builder.setSubnetName(volumeSpecNetwork.getSubnetName());
            }

            retVal = builder.build();

        }

        return retVal;
    }

    private static AzureStorageVolumeSpecProtocol toBl(ApiAzureStorageVolumeSpecProtocol volumeSpecProtocol) {
        AzureStorageVolumeSpecProtocol retVal = null;

        if (volumeSpecProtocol != null) {
            AzureStorageVolumeSpecProtocol.Builder builder = AzureStorageVolumeSpecProtocol.Builder.get();

            if (volumeSpecProtocol.isTypesSet()) {

                if (volumeSpecProtocol.getTypes() != null) {
                    builder.setTypes(new LinkedList<>(volumeSpecProtocol.getTypes()));
                }
                else {
                    builder.setTypes(null);
                }
            }

            if (volumeSpecProtocol.isMountPathSet()) {
                builder.setMountPath(volumeSpecProtocol.getMountPath());
            }

            if (volumeSpecProtocol.isExportPolicySet()) {
                builder.setExportPolicy(toBl(volumeSpecProtocol.getExportPolicy()));
            }

            if (volumeSpecProtocol.isKerberosEnabledSet()) {
                builder.setKerberosEnabled(volumeSpecProtocol.getKerberosEnabled());
            }

            if (volumeSpecProtocol.isSecurityStyleSet()) {
                builder.setSecurityStyle(volumeSpecProtocol.getSecurityStyle());
            }

            retVal = builder.build();

        }

        return retVal;
    }

    private static AzureStorageVolumeTag toBl(ApiAzureStorageVolumeTag volumeTag) {
        AzureStorageVolumeTag retVal = null;

        if (volumeTag != null) {
            AzureStorageVolumeTag.Builder builder = AzureStorageVolumeTag.Builder.get();

            if (volumeTag.isTagKeySet()) {
                builder.setTagKey(volumeTag.getTagKey());
            }

            if (volumeTag.isTagValueSet()) {
                builder.setTagValue(volumeTag.getTagValue());
            }

            retVal = builder.build();

        }

        return retVal;
    }

    private static AzureStorageVolumeSpecProtocolExportPolicy toBl(
            ApiAzureStorageVolumeSpecProtocolExportPolicy volumeSpecProtocolExportPolicy) {
        AzureStorageVolumeSpecProtocolExportPolicy retVal = null;

        if (volumeSpecProtocolExportPolicy != null) {
            AzureStorageVolumeSpecProtocolExportPolicy.Builder builder = AzureStorageVolumeSpecProtocolExportPolicy.Builder.get();

            if (volumeSpecProtocolExportPolicy.isRulesSet()) {

                if (volumeSpecProtocolExportPolicy.getRules() != null) {
                    List<ApiAzureStorageVolumeSpecProtocolExportPolicyRule> apiResizePolicies =
                            volumeSpecProtocolExportPolicy.getRules();
                    List<AzureStorageVolumeSpecProtocolExportPolicyRule> resizePolicies =
                            apiResizePolicies.stream().map(AzureStorageVolumeConverter::toBl).collect(Collectors.toList());
                    builder.setRules(resizePolicies);
                }
                else {
                    builder.setRules(null);

                }
            }

            retVal = builder.build();

        }

        return retVal;
    }

    private static AzureStorageVolumeSpecProtocolExportPolicyRule toBl(
            ApiAzureStorageVolumeSpecProtocolExportPolicyRule volumeSpecProtocolExportPolicyRule) {
        AzureStorageVolumeSpecProtocolExportPolicyRule retVal = null;

        if (volumeSpecProtocolExportPolicyRule != null) {
            AzureStorageVolumeSpecProtocolExportPolicyRule.Builder builder = AzureStorageVolumeSpecProtocolExportPolicyRule.Builder.get();


            if (volumeSpecProtocolExportPolicyRule.isIndexSet()) {
                builder.setIndex(volumeSpecProtocolExportPolicyRule.getIndex());
            }

            if (volumeSpecProtocolExportPolicyRule.isAllowedClientsSet()) {
                builder.setAllowedClients(volumeSpecProtocolExportPolicyRule.getAllowedClients());
            }

            if (volumeSpecProtocolExportPolicyRule.isAccessSet()) {
                builder.setAccess(volumeSpecProtocolExportPolicyRule.getAccess());
            }

            if (volumeSpecProtocolExportPolicyRule.isRootSet()) {
                builder.setRoot(volumeSpecProtocolExportPolicyRule.getRoot());
            }

            if (volumeSpecProtocolExportPolicyRule.isKerberosRuleAccessesSet()) {

                if (volumeSpecProtocolExportPolicyRule.getKerberosRuleAccesses() != null) {
                    new LinkedList<>(volumeSpecProtocolExportPolicyRule.getKerberosRuleAccesses());
                }
                else {
                    builder.setKerberosRuleAccesses(null);
                }
            }

            retVal = builder.build();

        }
        return retVal;

    }

    private static AzureStorageVolumeAutoResizeResizePolicy toBl(
            ApiAzureStorageVolumeAutoResizeResizePolicy volumeAutoResizeResizePolicy) {
        AzureStorageVolumeAutoResizeResizePolicy retVal = null;

        if (volumeAutoResizeResizePolicy != null) {
            AzureStorageVolumeAutoResizeResizePolicy.Builder builder = AzureStorageVolumeAutoResizeResizePolicy.Builder.get();

            if (volumeAutoResizeResizePolicy.isPolicyNameSet()) {
                builder.setPolicyName(volumeAutoResizeResizePolicy.getPolicyName());
            }

            if (volumeAutoResizeResizePolicy.isUsagePercentageSet()) {
                builder.setUsagePercentage(volumeAutoResizeResizePolicy.getUsagePercentage());
            }

            if (volumeAutoResizeResizePolicy.isOperatorSet()) {
                builder.setOperator(volumeAutoResizeResizePolicy.getOperator());
            }

            if (volumeAutoResizeResizePolicy.isActionSet()) {
                builder.setAction(toBl(volumeAutoResizeResizePolicy.getAction()));
            }

            if (volumeAutoResizeResizePolicy.isPeriodSet()) {
                builder.setPeriod(volumeAutoResizeResizePolicy.getPeriod());
            }

            if (volumeAutoResizeResizePolicy.isConsecutivePeriodsSet()) {
                builder.setConsecutivePeriods(volumeAutoResizeResizePolicy.getConsecutivePeriods());
            }

            if (volumeAutoResizeResizePolicy.isCooldownSet()) {
                builder.setCooldown(volumeAutoResizeResizePolicy.getCooldown());
            }

            retVal = builder.build();

        }
        return retVal;
    }

    private static AzureStorageVolumeAutoResizeResizePolicyAction toBl(
            ApiAzureStorageVolumeAutoResizeResizePolicyAction volumeAutoResizeResizePolicyAction) {
        AzureStorageVolumeAutoResizeResizePolicyAction retVal = null;

        if (volumeAutoResizeResizePolicyAction != null) {
            AzureStorageVolumeAutoResizeResizePolicyAction.Builder builder = AzureStorageVolumeAutoResizeResizePolicyAction.Builder.get();

            if (volumeAutoResizeResizePolicyAction.istypeSet()) {
                builder.setType(volumeAutoResizeResizePolicyAction.getType());
            }

            if (volumeAutoResizeResizePolicyAction.isadjustmentPercentageSet()) {
                builder.setAdjustmentPercentage(volumeAutoResizeResizePolicyAction.getAdjustmentPercentage());
            }

            retVal = builder.build();

        }
        return retVal;
    }
    //endregion
}
