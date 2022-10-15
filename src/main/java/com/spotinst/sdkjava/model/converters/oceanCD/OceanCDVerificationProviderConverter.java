package com.spotinst.sdkjava.model.converters.oceanCD;

import com.spotinst.sdkjava.model.api.oceanCD.*;
import com.spotinst.sdkjava.model.bl.oceanCD.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Janetlin Kiruba on 01/10/2022.
 */

public class OceanCDVerificationProviderConverter {

    public static ApiVerificationProvider toDal(VerificationProvider src) {
        ApiVerificationProvider apiVerificationProvider = null;

        if (src != null) {
            apiVerificationProvider = new ApiVerificationProvider();

            if (src.isNameSet()) {
                apiVerificationProvider.setName(src.getName());
            }
            if (src.isClusterIdsSet()) {
                apiVerificationProvider.setClusterIds(src.getClusterIds());
            }
            if (src.isPrometheusSet()) {
                apiVerificationProvider.setPrometheus(toDal(src.getPrometheus()));
            }
            if (src.isDatadogSet()) {
                apiVerificationProvider.setDatadog(toDal(src.getDatadog()));
            }
            if (src.isNewRelicSet()) {
                apiVerificationProvider.setNewRelic(toDal(src.getNewRelic()));
            }
            if (src.isCloudWatchSet()) {
                apiVerificationProvider.setCloudWatch(toDal(src.getCloudWatch()));
            }
        }

        return apiVerificationProvider;
    }

    public static ApiVerificationProviderPrometheus toDal(VerificationProviderPrometheus src) {
        ApiVerificationProviderPrometheus apiVerificationProviderPrometheus = null;

        if (src != null) {
            apiVerificationProviderPrometheus = new ApiVerificationProviderPrometheus();

            if (src.isAddressSet()) {
                apiVerificationProviderPrometheus.setAddress(src.getAddress());
            }
        }

        return apiVerificationProviderPrometheus;
    }

    public static ApiVerificationProviderDatadog toDal(VerificationProviderDatadog src) {
        ApiVerificationProviderDatadog apiVerificationProviderDatadog = null;

        if (src != null) {
            apiVerificationProviderDatadog = new ApiVerificationProviderDatadog();

            if (src.isAddressSet()) {
                apiVerificationProviderDatadog.setAddress(src.getAddress());
            }
            if (src.isApiKeySet()) {
                apiVerificationProviderDatadog.setApiKey(src.getApiKey());
            }
            if (src.isAppKeySet()) {
                apiVerificationProviderDatadog.setAppKey(src.getAppKey());
            }
        }

        return apiVerificationProviderDatadog;
    }

    public static ApiVerificationProviderNewRelic toDal(VerificationProviderNewRelic src) {
        ApiVerificationProviderNewRelic apiVerificationProviderNewRelic = null;

        if (src != null) {
            apiVerificationProviderNewRelic = new ApiVerificationProviderNewRelic();

            if (src.isPersonalApiKeySet()) {
                apiVerificationProviderNewRelic.setPersonalApiKey(src.getPersonalApiKey());
            }
            if (src.isAccountIdSet()) {
                apiVerificationProviderNewRelic.setAccountId(src.getAccountId());
            }
            if (src.isRegionSet()) {
                apiVerificationProviderNewRelic.setRegion(src.getRegion());
            }
            if (src.isBaseUrlRestSet()) {
                apiVerificationProviderNewRelic.setBaseUrlRest(src.getBaseUrlRest());
            }
            if (src.isBaseUrlNerdGraphSet()) {
                apiVerificationProviderNewRelic.setBaseUrlNerdGraph(src.getBaseUrlNerdGraph());
            }
        }

        return apiVerificationProviderNewRelic;
    }

    public static ApiVerificationProviderCloudWatch toDal(VerificationProviderCloudWatch src) {
        ApiVerificationProviderCloudWatch apiVerificationProviderCloudWatch = null;

        if (src != null) {
            apiVerificationProviderCloudWatch = new ApiVerificationProviderCloudWatch();

            if (src.isIamArnSet()) {
                apiVerificationProviderCloudWatch.setIamArn(src.getIamArn());
            }
        }

        return apiVerificationProviderCloudWatch;
    }

    public static VerificationProvider toBl(ApiVerificationProvider src) {
        VerificationProvider verificationProvider = null;

        if (src != null) {
            VerificationProvider.Builder verificationProviderBuilder = VerificationProvider.Builder.get();

            if (src.isNameSet()) {
                verificationProviderBuilder.setName(src.getName());
            }
            if (src.isClusterIdsSet()) {
                verificationProviderBuilder.setClusterIds(src.getClusterIds());
            }
            if (src.isPrometheusSet()) {
                verificationProviderBuilder.setPrometheus(toBl(src.getPrometheus()));
            }
            if (src.isDatadogSet()) {
                verificationProviderBuilder.setDatadog(toBl(src.getDatadog()));
            }
            if (src.isNewRelicSet()) {
                verificationProviderBuilder.setNewRelic(toBl(src.getNewRelic()));
            }
            if (src.isCloudWatchSet()) {
                verificationProviderBuilder.setCloudWatch(toBl(src.getCloudWatch()));
            }
            verificationProvider = verificationProviderBuilder.build();
        }

        return verificationProvider;
    }

    public static VerificationProviderPrometheus toBl(ApiVerificationProviderPrometheus src) {
        VerificationProviderPrometheus verificationProviderPrometheus = null;

        if (src != null) {
            VerificationProviderPrometheus.Builder verificationProviderPrometheusBuilder = VerificationProviderPrometheus.Builder.get();

            if (src.isAddressSet()) {
                verificationProviderPrometheusBuilder.setAddress(src.getAddress());
            }
            verificationProviderPrometheus = verificationProviderPrometheusBuilder.build();
        }

        return verificationProviderPrometheus;
    }

    public static VerificationProviderDatadog toBl(ApiVerificationProviderDatadog src) {
        VerificationProviderDatadog verificationProviderDatadog = null;

        if (src != null) {
            VerificationProviderDatadog.Builder verificationProviderDatadogBuilder = VerificationProviderDatadog.Builder.get();

            if (src.isAddressSet()) {
                verificationProviderDatadogBuilder.setAddress(src.getAddress());
            }
            if (src.isApiKeySet()) {
                verificationProviderDatadogBuilder.setApiKey(src.getApiKey());
            }
            if (src.isAppKeySet()) {
                verificationProviderDatadogBuilder.setAppKey(src.getAppKey());
            }
            verificationProviderDatadog = verificationProviderDatadogBuilder.build();
        }

        return verificationProviderDatadog;
    }

    public static VerificationProviderNewRelic toBl(ApiVerificationProviderNewRelic src) {
        VerificationProviderNewRelic verificationProviderNewRelic = null;

        if (src != null) {
            VerificationProviderNewRelic.Builder verificationProviderNewRelicBuilder = VerificationProviderNewRelic.Builder.get();

            if (src.isPersonalApiKeySet()) {
                verificationProviderNewRelicBuilder.setPersonalApiKey(src.getPersonalApiKey());
            }
            if (src.isAccountIdSet()) {
                verificationProviderNewRelicBuilder.setAccountId(src.getAccountId());
            }
            if (src.isRegionSet()) {
                verificationProviderNewRelicBuilder.setRegion(src.getRegion());
            }
            if (src.isBaseUrlRestSet()) {
                verificationProviderNewRelicBuilder.setBaseUrlRest(src.getBaseUrlRest());
            }
            if (src.isBaseUrlNerdGraphSet()) {
                verificationProviderNewRelicBuilder.setBaseUrlNerdGraph(src.getBaseUrlNerdGraph());
            }
            verificationProviderNewRelic = verificationProviderNewRelicBuilder.build();
        }

        return verificationProviderNewRelic;
    }

    public static VerificationProviderCloudWatch toBl(ApiVerificationProviderCloudWatch src) {
        VerificationProviderCloudWatch verificationProviderCloudWatch = null;

        if (src != null) {
            VerificationProviderCloudWatch.Builder verificationProviderCloudWatchBuilder = VerificationProviderCloudWatch.Builder.get();

            if (src.isIamArnSet()) {
                verificationProviderCloudWatchBuilder.setIamArn(src.getIamArn());
            }
            verificationProviderCloudWatch = verificationProviderCloudWatchBuilder.build();
        }

        return verificationProviderCloudWatch;
    }

}
