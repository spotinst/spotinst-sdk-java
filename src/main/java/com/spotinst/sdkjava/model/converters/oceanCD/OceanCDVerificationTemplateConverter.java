package com.spotinst.sdkjava.model.converters.oceanCD;

import com.spotinst.sdkjava.model.api.oceanCD.*;
import com.spotinst.sdkjava.model.bl.oceanCD.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Janetlin Kiruba on 04/10/2022.
 */

public class OceanCDVerificationTemplateConverter {

    public static ApiVerificationTemplate toDal(VerificationTemplate src) {
        ApiVerificationTemplate apiVerificationTemplate = null;

        if (src != null) {
            apiVerificationTemplate = new ApiVerificationTemplate();

            if (src.isNameSet()) {
                apiVerificationTemplate.setName(src.getName());
            }
            if (src.isArgsSet()) {
                List<ApiVerificationTemplateArgs> args = src.getArgs().stream().map(OceanCDVerificationTemplateConverter::toDal)
                        .collect(Collectors.toList());
                apiVerificationTemplate.setArgs(args);
            }
            if (src.isMetricsSet()) {
                List<ApiVerificationTemplateMetrics> metrics = src.getMetrics().stream().map(OceanCDVerificationTemplateConverter::toDal)
                        .collect(Collectors.toList());
                apiVerificationTemplate.setMetrics(metrics);
            }
        }

        return apiVerificationTemplate;
    }

    public static ApiVerificationTemplateArgs toDal(VerificationTemplateArgs src) {
        ApiVerificationTemplateArgs apiVerificationTemplateArgs = null;

        if (src != null) {
            apiVerificationTemplateArgs = new ApiVerificationTemplateArgs();

            if (src.isNameSet()) {
                apiVerificationTemplateArgs.setName(src.getName());
            }
        }

        return apiVerificationTemplateArgs;
    }

    public static ApiVerificationTemplateMetrics toDal(VerificationTemplateMetrics src) {
        ApiVerificationTemplateMetrics apiVerificationTemplateMetrics = null;

        if (src != null) {
            apiVerificationTemplateMetrics = new ApiVerificationTemplateMetrics();

            if (src.isNameSet()) {
                apiVerificationTemplateMetrics.setName(src.getName());
            }
            if (src.isIntervalSet()) {
                apiVerificationTemplateMetrics.setInterval(src.getInterval());
            }
            if (src.isInitialDelaySet()) {
                apiVerificationTemplateMetrics.setInitialDelay(src.getInitialDelay());
            }
            if (src.isCountSet()) {
                apiVerificationTemplateMetrics.setCount(src.getCount());
            }
            if (src.isSuccessConditionSet()) {
                apiVerificationTemplateMetrics.setSuccessCondition(src.getSuccessCondition());
            }
            if (src.isFailureConditionSet()) {
                apiVerificationTemplateMetrics.setFailureCondition(src.getFailureCondition());
            }
            if (src.isFailureLimitSet()) {
                apiVerificationTemplateMetrics.setFailureLimit(src.getFailureLimit());
            }
            if (src.isInconclusiveLimitSet()) {
                apiVerificationTemplateMetrics.setInconclusiveLimit(src.getInconclusiveLimit());
            }
            if (src.isConsecutiveErrorLimitSet()) {
                apiVerificationTemplateMetrics.setConsecutiveErrorLimit(src.getConsecutiveErrorLimit());
            }
            if (src.isProviderSet()) {
                apiVerificationTemplateMetrics.setProvider(toDal(src.getProvider()));
            }
        }

        return apiVerificationTemplateMetrics;
    }

    public static ApiMetricsProvider toDal(MetricsProvider src) {
        ApiMetricsProvider apiMetricsProvider = null;

        if (src != null) {
            apiMetricsProvider = new ApiMetricsProvider();

            if (src.isPrometheusSet()) {
                apiMetricsProvider.setPrometheus(toDal(src.getPrometheus()));
            }
            if (src.isNewRelicSet()) {
                apiMetricsProvider.setNewRelic(toDal(src.getNewRelic()));
            }
            if (src.isDatadogSet()) {
                apiMetricsProvider.setDatadog(toDal(src.getDatadog()));
            }
            if (src.isCloudWatchSet()) {
                apiMetricsProvider.setCloudWatch(toDal(src.getCloudWatch()));
            }
            if (src.isWebSet()) {
                apiMetricsProvider.setWeb(toDal(src.getWeb()));
            }
        }

        return apiMetricsProvider;
    }



    public static ApiProviderPrometheus toDal(ProviderPrometheus src) {
        ApiProviderPrometheus apiProviderPrometheus = null;

        if (src != null) {
            apiProviderPrometheus = new ApiProviderPrometheus();

            if (src.isQuerySet()) {
                apiProviderPrometheus.setQuery(src.getQuery());
            }
        }

        return apiProviderPrometheus;
    }

    public static ApiProviderNewRelic toDal(ProviderNewRelic src) {
        ApiProviderNewRelic apiProviderNewRelic = null;

        if (src != null) {
            apiProviderNewRelic = new ApiProviderNewRelic();

            if (src.isQuerySet()) {
                apiProviderNewRelic.setQuery(src.getQuery());
            }
            if (src.isProfileSet()) {
                apiProviderNewRelic.setProfile(src.getProfile());
            }
        }

        return apiProviderNewRelic;
    }

    public static ApiProviderDatadog toDal(ProviderDatadog src) {
        ApiProviderDatadog apiProviderDatadog = null;

        if (src != null) {
            apiProviderDatadog = new ApiProviderDatadog();

            if (src.isQuerySet()) {
                apiProviderDatadog.setQuery(src.getQuery());
            }
            if (src.isDurationSet()) {
                apiProviderDatadog.setDuration(src.getDuration());
            }
        }

        return apiProviderDatadog;
    }

    public static ApiProviderWeb toDal(ProviderWeb src) {
        ApiProviderWeb apiProviderWeb = null;

        if (src != null) {
            apiProviderWeb = new ApiProviderWeb();

            if (src.isMethodSet()) {
                apiProviderWeb.setMethod(src.getMethod());
            }
            if (src.isUrlSet()) {
                apiProviderWeb.setUrl(src.getUrl());
            }
            if (src.isBodySet()) {
                apiProviderWeb.setBody(src.getBody());
            }
            if (src.isTimeoutSecondsSet()) {
                apiProviderWeb.setTimeoutSeconds(src.getTimeoutSeconds());
            }
            if (src.isJsonPathSet()) {
                apiProviderWeb.setJsonPath(src.getJsonPath());
            }
            if (src.isInsecureSet()) {
                apiProviderWeb.setInsecure(src.getInsecure());
            }
            if (src.isHeadersSet()) {
                List<ApiWebHeaders> headers = src.getHeaders().stream().map(OceanCDVerificationTemplateConverter::toDal)
                        .collect(Collectors.toList());
                apiProviderWeb.setHeaders(headers);
            }
        }

        return apiProviderWeb;
    }

    public static ApiWebHeaders toDal(WebHeaders src) {
        ApiWebHeaders apiWebHeaders = null;

        if (src != null) {
            apiWebHeaders = new ApiWebHeaders();

            if (src.isKeySet()) {
                apiWebHeaders.setKey(src.getKey());
            }
            if (src.isValueSet()) {
                apiWebHeaders.setValue(src.getValue());
            }
        }

        return apiWebHeaders;
    }

    public static ApiProviderCloudWatch toDal(ProviderCloudWatch src) {
        ApiProviderCloudWatch apiProviderCloudWatch = null;

        if (src != null) {
            apiProviderCloudWatch = new ApiProviderCloudWatch();

            if (src.isDurationSet()) {
                apiProviderCloudWatch.setDuration(src.getDuration());
            }
            if (src.isMetricDataQueriesSet()) {
                List<ApiCloudWatchMetricDataQueries> headers = src.getMetricDataQueries().stream().map(OceanCDVerificationTemplateConverter::toDal)
                        .collect(Collectors.toList());
                apiProviderCloudWatch.setMetricDataQueries(headers);
            }
        }

        return apiProviderCloudWatch;
    }

    public static ApiCloudWatchMetricDataQueries toDal(CloudWatchMetricDataQueries src) {
        ApiCloudWatchMetricDataQueries apiCloudWatchMetricDataQueries = null;

        if (src != null) {
            apiCloudWatchMetricDataQueries = new ApiCloudWatchMetricDataQueries();

            if (src.isIdSet()) {
                apiCloudWatchMetricDataQueries.setId(src.getId());
            }
            if (src.isExpressionSet()) {
                apiCloudWatchMetricDataQueries.setExpression(src.getExpression());
            }
            if (src.isLabelSet()) {
                apiCloudWatchMetricDataQueries.setLabel(src.getLabel());
            }
            if (src.isPeriodSet()) {
                apiCloudWatchMetricDataQueries.setPeriod(src.getPeriod());
            }
            if (src.isReturnDataSet()) {
                apiCloudWatchMetricDataQueries.setReturnData(src.getReturnData());
            }
            if (src.isMetricStatSet()) {
                apiCloudWatchMetricDataQueries.setMetricStat(toDal(src.getMetricStat()));
            }
        }

        return apiCloudWatchMetricDataQueries;
    }

    public static ApiMetricDataQueriesMetricStat toDal(MetricDataQueriesMetricStat src) {
        ApiMetricDataQueriesMetricStat apiMetricDataQueriesMetricStat = null;

        if (src != null) {
            apiMetricDataQueriesMetricStat = new ApiMetricDataQueriesMetricStat();

            if (src.isStatSet()) {
                apiMetricDataQueriesMetricStat.setStat(src.getStat());
            }
            if (src.isExpressionSet()) {
                apiMetricDataQueriesMetricStat.setExpression(src.getExpression());
            }
            if (src.isUnitSet()) {
                apiMetricDataQueriesMetricStat.setUnit(src.getUnit());
            }
            if (src.isPeriodSet()) {
                apiMetricDataQueriesMetricStat.setPeriod(src.getPeriod());
            }
            if (src.isMetricSet()) {
                apiMetricDataQueriesMetricStat.setMetric(toDal(src.getMetric()));
            }
        }

        return apiMetricDataQueriesMetricStat;
    }

    public static ApiMetricStatMetric toDal(MetricStatMetric src) {
        ApiMetricStatMetric apiMetricStatMetric = null;

        if (src != null) {
            apiMetricStatMetric = new ApiMetricStatMetric();

            if (src.isMetricNameSet()) {
                apiMetricStatMetric.setMetricName(src.getMetricName());
            }
            if (src.isNamespaceSet()) {
                apiMetricStatMetric.setNamespace(src.getNamespace());
            }
            if (src.isDimensionsSet()) {
                List<ApiMetricDimensions> dimensions = src.getDimensions().stream().map(OceanCDVerificationTemplateConverter::toDal)
                        .collect(Collectors.toList());
                apiMetricStatMetric.setDimensions(dimensions);
            }
        }

        return apiMetricStatMetric;
    }

    public static ApiMetricDimensions toDal(MetricDimensions src) {
        ApiMetricDimensions apiMetricDimensions = null;

        if (src != null) {
            apiMetricDimensions = new ApiMetricDimensions();

            if (src.isNameSet()) {
                apiMetricDimensions.setName(src.getName());
            }
            if (src.isValueSet()) {
                apiMetricDimensions.setValue(src.getValue());
            }
        }

        return apiMetricDimensions;
    }

    public static VerificationTemplate toBl(ApiVerificationTemplate src) {
        VerificationTemplate verificationTemplate = null;

        if (src != null) {
            VerificationTemplate.Builder verificationTemplateBuilder = VerificationTemplate.Builder.get();

            if (src.isNameSet()) {
                verificationTemplateBuilder.setName(src.getName());
            }
            if (src.isArgsSet()) {
                List<VerificationTemplateArgs> args = src.getArgs().stream().map(OceanCDVerificationTemplateConverter::toBl)
                        .collect(Collectors.toList());
                verificationTemplateBuilder.setArgs(args);
            }
            if (src.isMetricsSet()) {
                List<VerificationTemplateMetrics> metrics = src.getMetrics().stream().map(OceanCDVerificationTemplateConverter::toBl)
                        .collect(Collectors.toList());
                verificationTemplateBuilder.setMetrics(metrics);
            }
            verificationTemplate = verificationTemplateBuilder.build();
        }

        return verificationTemplate;
    }

    public static VerificationTemplateArgs toBl(ApiVerificationTemplateArgs src) {
        VerificationTemplateArgs verificationTemplateArgs = null;

        if (src != null) {
            VerificationTemplateArgs.Builder verificationTemplateBuilder = VerificationTemplateArgs.Builder.get();

            if (src.isNameSet()) {
                verificationTemplateBuilder.setName(src.getName());
            }
            verificationTemplateArgs = verificationTemplateBuilder.build();
        }

        return verificationTemplateArgs;
    }

    public static VerificationTemplateMetrics toBl(ApiVerificationTemplateMetrics src) {
        VerificationTemplateMetrics verificationTemplateMetrics = null;

        if (src != null) {
            VerificationTemplateMetrics.Builder verificationTemplateBuilder = VerificationTemplateMetrics.Builder.get();

            if (src.isNameSet()) {
                verificationTemplateBuilder.setName(src.getName());
            }
            if (src.isIntervalSet()) {
                verificationTemplateBuilder.setInterval(src.getInterval());
            }
            if (src.isInitialDelaySet()) {
                verificationTemplateBuilder.setInitialDelay(src.getInitialDelay());
            }
            if (src.isCountSet()) {
                verificationTemplateBuilder.setCount(src.getCount());
            }
            if (src.isSuccessConditionSet()) {
                verificationTemplateBuilder.setSuccessCondition(src.getSuccessCondition());
            }
            if (src.isFailureConditionSet()) {
                verificationTemplateBuilder.setFailureCondition(src.getFailureCondition());
            }
            if (src.isFailureLimitSet()) {
                verificationTemplateBuilder.setFailureLimit(src.getFailureLimit());
            }
            if (src.isInconclusiveLimitSet()) {
                verificationTemplateBuilder.setInconclusiveLimit(src.getInconclusiveLimit());
            }
            if (src.isConsecutiveErrorLimitSet()) {
                verificationTemplateBuilder.setConsecutiveErrorLimit(src.getConsecutiveErrorLimit());
            }
            if (src.isProviderSet()) {
                verificationTemplateBuilder.setProvider(toBl(src.getProvider()));
            }
            verificationTemplateMetrics = verificationTemplateBuilder.build();
        }

        return verificationTemplateMetrics;
    }

    public static MetricsProvider toBl(ApiMetricsProvider src) {
        MetricsProvider metricsProvider = null;

        if (src != null) {
            MetricsProvider.Builder metricsProviderBuilder = MetricsProvider.Builder.get();

            if (src.isPrometheusSet()) {
                metricsProviderBuilder.setPrometheus(toBl(src.getPrometheus()));
            }
            if (src.isNewRelicSet()) {
                metricsProviderBuilder.setNewRelic(toBl(src.getNewRelic()));
            }
            if (src.isDatadogSet()) {
                metricsProviderBuilder.setDatadog(toBl(src.getDatadog()));
            }
            if (src.isCloudWatchSet()) {
                metricsProviderBuilder.setCloudWatch(toBl(src.getCloudWatch()));
            }
            if (src.isWebSet()) {
                metricsProviderBuilder.setWeb(toBl(src.getWeb()));
            }
            metricsProvider = metricsProviderBuilder.build();
        }

        return metricsProvider;
    }



    public static ProviderPrometheus toBl(ApiProviderPrometheus src) {
        ProviderPrometheus providerPrometheus = null;

        if (src != null) {
            ProviderPrometheus.Builder providerPrometheusBuilder = ProviderPrometheus.Builder.get();

            if (src.isQuerySet()) {
                providerPrometheusBuilder.setQuery(src.getQuery());
            }
            providerPrometheus = providerPrometheusBuilder.build();
        }

        return providerPrometheus;
    }

    public static ProviderNewRelic toBl(ApiProviderNewRelic src) {
        ProviderNewRelic providerNewRelic = null;

        if (src != null) {
            ProviderNewRelic.Builder providerNewRelicBuilder = ProviderNewRelic.Builder.get();

            if (src.isQuerySet()) {
                providerNewRelicBuilder.setQuery(src.getQuery());
            }
            if (src.isProfileSet()) {
                providerNewRelicBuilder.setProfile(src.getProfile());
            }
            providerNewRelic = providerNewRelicBuilder.build();
        }

        return providerNewRelic;
    }

    public static ProviderDatadog toBl(ApiProviderDatadog src) {
        ProviderDatadog providerDatadog = null;

        if (src != null) {
            ProviderDatadog.Builder providerDatadogBuilder = ProviderDatadog.Builder.get();

            if (src.isQuerySet()) {
                providerDatadogBuilder.setQuery(src.getQuery());
            }
            if (src.isDurationSet()) {
                providerDatadogBuilder.setDuration(src.getDuration());
            }
            providerDatadog = providerDatadogBuilder.build();
        }

        return providerDatadog;
    }

    public static ProviderWeb toBl(ApiProviderWeb src) {
        ProviderWeb providerWeb = null;

        if (src != null) {
            ProviderWeb.Builder providerWebBuilder = ProviderWeb.Builder.get();

            if (src.isMethodSet()) {
                providerWebBuilder.setMethod(src.getMethod());
            }
            if (src.isUrlSet()) {
                providerWebBuilder.setUrl(src.getUrl());
            }
            if (src.isBodySet()) {
                providerWebBuilder.setBody(src.getBody());
            }
            if (src.isTimeoutSecondsSet()) {
                providerWebBuilder.setTimeoutSeconds(src.getTimeoutSeconds());
            }
            if (src.isJsonPathSet()) {
                providerWebBuilder.setJsonPath(src.getJsonPath());
            }
            if (src.isInsecureSet()) {
                providerWebBuilder.setInsecure(src.getInsecure());
            }
            if (src.isHeadersSet()) {
                List<WebHeaders> headers = src.getHeaders().stream().map(OceanCDVerificationTemplateConverter::toBl)
                        .collect(Collectors.toList());
                providerWebBuilder.setHeaders(headers);
            }
            providerWeb = providerWebBuilder.build();
        }

        return providerWeb;
    }

    public static WebHeaders toBl(ApiWebHeaders src) {
        WebHeaders webHeaders = null;

        if (src != null) {
            WebHeaders.Builder webHeadersBuilder = WebHeaders.Builder.get();

            if (src.isKeySet()) {
                webHeadersBuilder.setKey(src.getKey());
            }
            if (src.isValueSet()) {
                webHeadersBuilder.setValue(src.getValue());
            }
            webHeaders = webHeadersBuilder.build();
        }

        return webHeaders;
    }

    public static ProviderCloudWatch toBl(ApiProviderCloudWatch src) {
        ProviderCloudWatch providerCloudWatch = null;

        if (src != null) {
            ProviderCloudWatch.Builder providerCloudWatchBuilder = ProviderCloudWatch.Builder.get();

            if (src.isDurationSet()) {
                providerCloudWatchBuilder.setDuration(src.getDuration());
            }
            if (src.isMetricDataQueriesSet()) {
                List<CloudWatchMetricDataQueries> headers = src.getMetricDataQueries().stream().map(OceanCDVerificationTemplateConverter::toBl)
                        .collect(Collectors.toList());
                providerCloudWatchBuilder.setMetricDataQueries(headers);
            }
            providerCloudWatch = providerCloudWatchBuilder.build();
        }

        return providerCloudWatch;
    }

    public static CloudWatchMetricDataQueries toBl(ApiCloudWatchMetricDataQueries src) {
        CloudWatchMetricDataQueries cloudWatchMetricDataQueries = null;

        if (src != null) {
            CloudWatchMetricDataQueries.Builder cloudWatchMetricDataQueriesBuilder = CloudWatchMetricDataQueries.Builder.get();

            if (src.isIdSet()) {
                cloudWatchMetricDataQueriesBuilder.setId(src.getId());
            }
            if (src.isExpressionSet()) {
                cloudWatchMetricDataQueriesBuilder.setExpression(src.getExpression());
            }
            if (src.isLabelSet()) {
                cloudWatchMetricDataQueriesBuilder.setLabel(src.getLabel());
            }
            if (src.isPeriodSet()) {
                cloudWatchMetricDataQueriesBuilder.setPeriod(src.getPeriod());
            }
            if (src.isReturnDataSet()) {
                cloudWatchMetricDataQueriesBuilder.setReturnData(src.getReturnData());
            }
            if (src.isMetricStatSet()) {
                cloudWatchMetricDataQueriesBuilder.setMetricStat(toBl(src.getMetricStat()));
            }
            cloudWatchMetricDataQueries = cloudWatchMetricDataQueriesBuilder.build();
        }

        return cloudWatchMetricDataQueries;
    }

    public static MetricDataQueriesMetricStat toBl(ApiMetricDataQueriesMetricStat src) {
        MetricDataQueriesMetricStat metricDataQueriesMetricStat = null;

        if (src != null) {
            MetricDataQueriesMetricStat.Builder metricDataQueriesMetricStatBuilder = MetricDataQueriesMetricStat.Builder.get();

            if (src.isStatSet()) {
                metricDataQueriesMetricStatBuilder.setStat(src.getStat());
            }
            if (src.isExpressionSet()) {
                metricDataQueriesMetricStatBuilder.setExpression(src.getExpression());
            }
            if (src.isUnitSet()) {
                metricDataQueriesMetricStatBuilder.setUnit(src.getUnit());
            }
            if (src.isPeriodSet()) {
                metricDataQueriesMetricStatBuilder.setPeriod(src.getPeriod());
            }
            if (src.isMetricSet()) {
                metricDataQueriesMetricStatBuilder.setMetric(toBl(src.getMetric()));
            }
            metricDataQueriesMetricStat = metricDataQueriesMetricStatBuilder.build();
        }

        return metricDataQueriesMetricStat;
    }

    public static MetricStatMetric toBl(ApiMetricStatMetric src) {
        MetricStatMetric metricStatMetric = null;

        if (src != null) {
            MetricStatMetric.Builder metricStatMetricBuilder = MetricStatMetric.Builder.get();

            if (src.isMetricNameSet()) {
                metricStatMetricBuilder.setMetricName(src.getMetricName());
            }
            if (src.isNamespaceSet()) {
                metricStatMetricBuilder.setNamespace(src.getNamespace());
            }
            if (src.isDimensionsSet()) {
                List<MetricDimensions> dimensions = src.getDimensions().stream().map(OceanCDVerificationTemplateConverter::toBl)
                        .collect(Collectors.toList());
                metricStatMetricBuilder.setDimensions(dimensions);
            }
            metricStatMetric = metricStatMetricBuilder.build();
        }

        return metricStatMetric;
    }

    public static MetricDimensions toBl(ApiMetricDimensions src) {
        MetricDimensions metricDimensions = null;

        if (src != null) {
            MetricDimensions.Builder metricDimensionsBuilder = MetricDimensions.Builder.get();

            if (src.isNameSet()) {
                metricDimensionsBuilder.setName(src.getName());
            }
            if (src.isValueSet()) {
                metricDimensionsBuilder.setValue(src.getValue());
            }
            metricDimensions = metricDimensionsBuilder.build();
        }

        return metricDimensions;
    }

}
