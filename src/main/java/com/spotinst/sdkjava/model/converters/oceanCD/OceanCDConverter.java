package com.spotinst.sdkjava.model.converters.oceanCD;

import com.spotinst.sdkjava.model.api.oceanCD.*;
import com.spotinst.sdkjava.model.bl.oceanCD.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Janetlin Kiruba on 11/08/2022.
 */

public class OceanCDConverter {

    public static ApiStrategy toDal(Strategy src) {
        ApiStrategy apiStrategy = null;

        if (src != null) {
            apiStrategy = new ApiStrategy();

            if (src.isNameSet()) {
                apiStrategy.setName(src.getName());
            }
            if (src.isCanarySet()) {
                apiStrategy.setCanary(toDal(src.getCanary()));
            }
        }

        return apiStrategy;
    }

    public static ApiStrategyCanary toDal(StrategyCanary src) {
        ApiStrategyCanary apiStrategy = null;

        if (src != null) {
            apiStrategy = new ApiStrategyCanary();

            if (src.isBackgroundVerificationSet()) {
                apiStrategy.setBackgroundVerification(toDal(src.getBackgroundVerification()));
            }
            if (src.isStepsSet()) {
                List<ApiCanarySteps> canarySteps = src.getSteps().stream().map(OceanCDConverter::toDal)
                                .collect(Collectors.toList());
                apiStrategy.setSteps(canarySteps);
            }
        }

        return apiStrategy;
    }

    public static ApiCanaryBackgroundVerification toDal(CanaryBackgroundVerification src) {
        ApiCanaryBackgroundVerification apiCanaryBackgroundVerification = null;

        if (src != null) {
            apiCanaryBackgroundVerification = new ApiCanaryBackgroundVerification();

            if (src.isTemplateNamesSet()) {
                apiCanaryBackgroundVerification.setTemplateNames(src.getTemplateNames());
            }
            if (src.isArgsSet()) {
                List<ApiBackgroundVerificationArgs> args = src.getArgs().stream().map(OceanCDConverter::toDal)
                        .collect(Collectors.toList());
                apiCanaryBackgroundVerification.setArgs(args);
            }
        }

        return apiCanaryBackgroundVerification;
    }

    public static ApiBackgroundVerificationArgs toDal(BackgroundVerificationArgs src) {
        ApiBackgroundVerificationArgs apiBackgroundVerificationArgs = null;

        if (src != null) {
            apiBackgroundVerificationArgs = new ApiBackgroundVerificationArgs();

            if (src.isNameSet()) {
                apiBackgroundVerificationArgs.setName(src.getName());
            }
            if (src.isValueSet()) {
                apiBackgroundVerificationArgs.setValue(src.getValue());
            }
            if (src.isValueFromSet()) {
                apiBackgroundVerificationArgs.setValueFrom(toDal(src.getValueFrom()));
            }
        }

        return apiBackgroundVerificationArgs;
    }

    public static ApiArgsValueFrom toDal(ArgsValueFrom src) {
        ApiArgsValueFrom apiArgsValueFrom = null;

        if (src != null) {
            apiArgsValueFrom = new ApiArgsValueFrom();

            if (src.isSecretRefSet()) {
                apiArgsValueFrom.setSecretRef(toDal(src.getSecretRef()));
            }
            if (src.isFiledRefSet()) {
                apiArgsValueFrom.setFiledRef(toDal(src.getFiledRef()));
            }
        }

        return apiArgsValueFrom;
    }

    public static ApiValueFromSecretRef toDal(ValueFromSecretRef src) {
        ApiValueFromSecretRef apiValueFromSecretRef = null;

        if (src != null) {
            apiValueFromSecretRef = new ApiValueFromSecretRef();

            if (src.isNameSet()) {
                apiValueFromSecretRef.setName(src.getName());
            }
            if (src.isKeySet()) {
                apiValueFromSecretRef.setKey(src.getKey());
            }
        }

        return apiValueFromSecretRef;
    }

    public static ApiValueFromFiledRef toDal(ValueFromFiledRef src) {
        ApiValueFromFiledRef apiValueFromFiledRef = null;

        if (src != null) {
            apiValueFromFiledRef = new ApiValueFromFiledRef();

            if (src.isFieldPathSet()) {
                apiValueFromFiledRef.setFieldPath(src.getFieldPath());
            }
        }

        return apiValueFromFiledRef;
    }


    public static ApiCanarySteps toDal(CanarySteps src) {
        ApiCanarySteps apiCanarySteps = null;

        if (src != null) {
            apiCanarySteps = new ApiCanarySteps();

            if (src.isNameSet()) {
                apiCanarySteps.setName(src.getName());
            }
            if (src.isPauseSet()) {
                apiCanarySteps.setPause(toDal(src.getPause()));
            }
            if (src.isSetWeightSet()) {
                apiCanarySteps.setSetWeight(src.getSetWeight());
            }
            if (src.isVerificationSet()) {
                apiCanarySteps.setVerification(toDal(src.getVerification()));
            }
            if (src.isSetCanaryScaleSet()) {
                apiCanarySteps.setSetCanaryScale(toDal(src.getSetCanaryScale()));
            }
        }

        return apiCanarySteps;
    }

    public static ApiStepsPause toDal(StepsPause src) {
        ApiStepsPause apiStepsPause = null;

        if (src != null) {
            apiStepsPause = new ApiStepsPause();

            if (src.isDurationSet()) {
                apiStepsPause.setDuration(src.getDuration());
            }
        }
        return apiStepsPause;
    }

    public static ApiStepsSetCanaryScale toDal(StepsSetCanaryScale src) {
        ApiStepsSetCanaryScale apiStepsSetCanaryScale = null;

        if (src != null) {
            apiStepsSetCanaryScale = new ApiStepsSetCanaryScale();

            if (src.isMatchTrafficWeightSet()) {
                apiStepsSetCanaryScale.setMatchTrafficWeight(src.getMatchTrafficWeight());
            }

            if (src.isReplicasSet()) {
                apiStepsSetCanaryScale.setReplicas(src.getReplicas());
            }

            if (src.isWeightSet()) {
                apiStepsSetCanaryScale.setWeight(src.getWeight());
            }
        }
        return apiStepsSetCanaryScale;
    }

    public static ApiRolloutSpec toDal(RolloutSpec src) {
        ApiRolloutSpec apiRolloutSpec = null;

        if (src != null) {
            apiRolloutSpec = new ApiRolloutSpec();

            if (src.isNameSet()) {
                apiRolloutSpec.setName(src.getName());
            }
            if (src.isSpotDeploymentSet()) {
                apiRolloutSpec.setSpotDeployment(toDal(src.getSpotDeployment()));
            }
            if (src.isStrategySet()) {
                apiRolloutSpec.setStrategy(toDal(src.getStrategy()));
            }
            if (src.isTrafficSet()) {
                apiRolloutSpec.setTraffic(toDal(src.getTraffic()));
            }
            if (src.isFailurePolicySet()) {
                apiRolloutSpec.setFailurePolicy(toDal(src.getFailurePolicy()));
            }
        }

        return apiRolloutSpec;
    }

    public static ApiRolloutSpecFailurePolicy toDal(RolloutSpecFailurePolicy src) {
        ApiRolloutSpecFailurePolicy apiRolloutSpecFailurePolicy = null;

        if (src != null) {
            apiRolloutSpecFailurePolicy = new ApiRolloutSpecFailurePolicy();

            if (src.isActionSet()) {
                apiRolloutSpecFailurePolicy.setAction(src.getAction());
            }
        }

        return apiRolloutSpecFailurePolicy;
    }

    public static ApiRolloutSpecSpotDeployment toDal(RolloutSpecSpotDeployment src) {
        ApiRolloutSpecSpotDeployment apiRolloutSpecSpotDeployment = null;

        if (src != null) {
            apiRolloutSpecSpotDeployment = new ApiRolloutSpecSpotDeployment();

            if (src.isClusterIdSet()) {
                apiRolloutSpecSpotDeployment.setClusterId(src.getClusterId());
            }
            if (src.isNameSet()) {
                apiRolloutSpecSpotDeployment.setName(src.getName());
            }
            if (src.isNamespaceSet()) {
                apiRolloutSpecSpotDeployment.setNamespace(src.getNamespace());
            }
        }

        return apiRolloutSpecSpotDeployment;
    }

    public static ApiRolloutSpecStrategy toDal(RolloutSpecStrategy src) {
        ApiRolloutSpecStrategy apiRolloutSpecStrategy = null;

        if (src != null) {
            apiRolloutSpecStrategy = new ApiRolloutSpecStrategy();

            if (src.isNameSet()) {
                apiRolloutSpecStrategy.setName(src.getName());
            }
            if (src.isArgsSet()) {
                List<ApiBackgroundVerificationArgs> args = src.getArgs().stream().map(OceanCDConverter::toDal)
                        .collect(Collectors.toList());
                apiRolloutSpecStrategy.setArgs(args);
            }
        }

        return apiRolloutSpecStrategy;
    }

    public static ApiRolloutSpecTraffic toDal(RolloutSpecTraffic src) {
        ApiRolloutSpecTraffic apiRolloutSpecTraffic = null;

        if (src != null) {
            apiRolloutSpecTraffic = new ApiRolloutSpecTraffic();

            if (src.isCanaryServiceSet()) {
                apiRolloutSpecTraffic.setCanaryService(src.getCanaryService());
            }
            if (src.isStableServiceSet()) {
                apiRolloutSpecTraffic.setStableService(src.getStableService());
            }
            if (src.isIstioSet()) {
                apiRolloutSpecTraffic.setIstio(toDal(src.getIstio()));
            }
            if (src.isNginxSet()) {
                apiRolloutSpecTraffic.setNginx(toDal(src.getNginx()));
            }
            if (src.isAlbSet()) {
                apiRolloutSpecTraffic.setAlb(toDal(src.getAlb()));
            }
            if (src.isSmiSet()) {
                apiRolloutSpecTraffic.setSmi(toDal(src.getSmi()));
            }
            if (src.isAmbassadorSet()) {
                apiRolloutSpecTraffic.setAmbassador(toDal(src.getAmbassador()));
            }
            if (src.isAppMeshSet()) {
                apiRolloutSpecTraffic.setAppMesh(toDal(src.getAppMesh()));
            }
            if (src.isPingPongSet()) {
                apiRolloutSpecTraffic.setPingPong(toDal(src.getPingPong()));
            }
        }

        return apiRolloutSpecTraffic;
    }

    public static ApiTrafficAppMesh toDal(TrafficAppMesh src) {
        ApiTrafficAppMesh apiTrafficAppMesh = null;

        if (src != null) {
            apiTrafficAppMesh = new ApiTrafficAppMesh();

            if (src.isVirtualServiceSet()) {
                apiTrafficAppMesh.setVirtualService(toDal(src.getVirtualService()));
            }
            if (src.isVirtualNodeGroupSet()) {
                apiTrafficAppMesh.setVirtualNodeGroup(toDal(src.getVirtualNodeGroup()));
            }

        }

        return apiTrafficAppMesh;
    }

    public static ApiAppMeshVirtualService toDal(AppMeshVirtualService src) {
        ApiAppMeshVirtualService apiAppMeshVirtualService = null;

        if (src != null) {
            apiAppMeshVirtualService = new ApiAppMeshVirtualService();

            if (src.isNameSet()) {
                apiAppMeshVirtualService.setName(src.getName());
            }
            if (src.isRoutesSet()) {
                apiAppMeshVirtualService.setRoutes(src.getRoutes());
            }
        }

        return apiAppMeshVirtualService;
    }

    public static ApiAppMeshVirtualNodeGroup toDal(AppMeshVirtualNodeGroup src) {
        ApiAppMeshVirtualNodeGroup apiAppMeshVirtualNodeGroup = null;

        if (src != null) {
            apiAppMeshVirtualNodeGroup = new ApiAppMeshVirtualNodeGroup();

            if (src.isCanaryVirtualNodeRefSet()) {
                apiAppMeshVirtualNodeGroup.setCanaryVirtualNodeRef(toDal(src.getCanaryVirtualNodeRef()));
            }
            if (src.isStableVirtualNodeRefSet()) {
                apiAppMeshVirtualNodeGroup.setStableVirtualNodeRef(toDal(src.getStableVirtualNodeRef()));
            }
        }

        return apiAppMeshVirtualNodeGroup;
    }

    public static ApiVirtualNodeGroupCanaryStableVirtualNodeRef toDal(VirtualNodeGroupCanaryStableVirtualNodeRef src) {
        ApiVirtualNodeGroupCanaryStableVirtualNodeRef apiVirtualNodeGroupCanaryStableVirtualNodeRef = null;

        if (src != null) {
            apiVirtualNodeGroupCanaryStableVirtualNodeRef = new ApiVirtualNodeGroupCanaryStableVirtualNodeRef();

            if (src.isNameSet()) {
                apiVirtualNodeGroupCanaryStableVirtualNodeRef.setName(src.getName());
            }
        }

        return apiVirtualNodeGroupCanaryStableVirtualNodeRef;
    }

    public static ApiTrafficPingPong toDal(TrafficPingPong src) {
        ApiTrafficPingPong apiTrafficPingPong = null;

        if (src != null) {
            apiTrafficPingPong = new ApiTrafficPingPong();

            if (src.isPingServiceSet()) {
                apiTrafficPingPong.setPingService(src.getPingService());
            }
            if (src.isPongServiceSet()) {
                apiTrafficPingPong.setPongService(src.getPongService());
            }
        }

        return apiTrafficPingPong;
    }

    public static ApiTrafficAlb toDal(TrafficAlb src) {
        ApiTrafficAlb apiTrafficAlb = null;

        if (src != null) {
            apiTrafficAlb = new ApiTrafficAlb();

            if (src.isIngressSet()) {
                apiTrafficAlb.setIngress(src.getIngress());
            }
            if (src.isServicePortSet()) {
                apiTrafficAlb.setServicePort(src.getServicePort());
            }
            if (src.isRootServiceSet()) {
                apiTrafficAlb.setRootService(src.getRootService());
            }
            if (src.isAnnotationPrefixSet()) {
                apiTrafficAlb.setAnnotationPrefix(src.getAnnotationPrefix());
            }
            if (src.isStickinessConfigSet()) {
                apiTrafficAlb.setStickinessConfig(toDal(src.getStickinessConfig()));
            }

        }

        return apiTrafficAlb;
    }

    public static ApiTrafficAmbassador toDal(TrafficAmbassador src) {
        ApiTrafficAmbassador apiTrafficAmbassador = null;

        if (src != null) {
            apiTrafficAmbassador = new ApiTrafficAmbassador();

            if (src.isMappingsSet()) {
                apiTrafficAmbassador.setMappings(src.getMappings());
            }

        }

        return apiTrafficAmbassador;
    }

    public static ApiAlbStickinessConfig toDal(AlbStickinessConfig src) {
        ApiAlbStickinessConfig apiAlbStickinessConfig = null;

        if (src != null) {
            apiAlbStickinessConfig = new ApiAlbStickinessConfig();

            if (src.isEnabledSet()) {
                apiAlbStickinessConfig.setEnabled(src.getEnabled());
            }
            if (src.isDurationSecondsSet()) {
                apiAlbStickinessConfig.setDurationSeconds(src.getDurationSeconds());
            }

        }

        return apiAlbStickinessConfig;
    }

    public static ApiTrafficSmi toDal(TrafficSmi src) {
        ApiTrafficSmi apiTrafficSmi = null;

        if (src != null) {
            apiTrafficSmi = new ApiTrafficSmi();

            if (src.isRootServiceSet()) {
                apiTrafficSmi.setRootService(src.getRootService());
            }
            if (src.isTrafficSplitNameSet()) {
                apiTrafficSmi.setTrafficSplitName(src.getTrafficSplitName());
            }

        }

        return apiTrafficSmi;
    }

    public static ApiTrafficIstio toDal(TrafficIstio src) {
        ApiTrafficIstio apiTrafficIstio = null;

        if (src != null) {
            apiTrafficIstio = new ApiTrafficIstio();

            if (src.isVirtualServicesSet()) {
                apiTrafficIstio.setVirtualServices(toDal(src.getVirtualServices()));
            }
            if (src.isDestinationRuleSet()) {
                apiTrafficIstio.setDestinationRule(toDal(src.getDestinationRule()));
            }

        }

        return apiTrafficIstio;
    }

    public static ApiIstioVirtualServices toDal(IstioVirtualServices src) {
        ApiIstioVirtualServices apiIstioVirtualServices = null;

        if (src != null) {
            apiIstioVirtualServices = new ApiIstioVirtualServices();

            if (src.isNameSet()) {
                apiIstioVirtualServices.setName(src.getName());
            }
            if (src.isRoutesSet()) {
                apiIstioVirtualServices.setRoutes(src.getRoutes());
            }
            if (src.isTlsRoutesSet()) {
                List<ApiVirtualServicesTlsRoutes> args = src.getTlsRoutes().stream().map(OceanCDConverter::toDal)
                        .collect(Collectors.toList());
                apiIstioVirtualServices.setTlsRoutes(args);
            }
        }

        return apiIstioVirtualServices;
    }

    public static ApiVirtualServicesTlsRoutes toDal(VirtualServicesTlsRoutes src) {
        ApiVirtualServicesTlsRoutes apiVirtualServicesTlsRoutes = null;

        if (src != null) {
            apiVirtualServicesTlsRoutes = new ApiVirtualServicesTlsRoutes();

            if (src.isPortSet()) {
                apiVirtualServicesTlsRoutes.setPort(src.getPort());
            }
            if (src.isSniHostsSet()) {
                apiVirtualServicesTlsRoutes.setSniHosts(src.getSniHosts());
            }
        }

        return apiVirtualServicesTlsRoutes;
    }

    public static ApiIstioDestinationRule toDal(IstioDestinationRule src) {
        ApiIstioDestinationRule apiIstioDestinationRule = null;

        if (src != null) {
            apiIstioDestinationRule = new ApiIstioDestinationRule();

            if (src.isNameSet()) {
                apiIstioDestinationRule.setName(src.getName());
            }
            if (src.isCanarySubsetNameSet()) {
                apiIstioDestinationRule.setCanarySubsetName(src.getCanarySubsetName());
            }
            if (src.isStableSubsetNameSet()) {
                apiIstioDestinationRule.setStableSubsetName(src.getStableSubsetName());
            }
        }

        return apiIstioDestinationRule;
    }

    public static ApiTrafficNginx toDal(TrafficNginx src) {
        ApiTrafficNginx apiTrafficNginx = null;

        if (src != null) {
            apiTrafficNginx = new ApiTrafficNginx();

            if (src.isAnnotationPrefixSet()) {
                apiTrafficNginx.setAnnotationPrefix(src.getAnnotationPrefix());
            }
            if (src.isStableIngressSet()) {
                apiTrafficNginx.setStableIngress(src.getStableIngress());
            }
            if (src.isAdditionalIngressAnnotationsSet()) {
                apiTrafficNginx.setAdditionalIngressAnnotations(toDal(src.getAdditionalIngressAnnotations()));
            }

        }

        return apiTrafficNginx;
    }

    public static ApiNginxAdditionalIngressAnnotations toDal(NginxAdditionalIngressAnnotations src) {
        ApiNginxAdditionalIngressAnnotations apiNginxAdditionalIngressAnnotations = null;

        if (src != null) {
            apiNginxAdditionalIngressAnnotations = new ApiNginxAdditionalIngressAnnotations();

            if (src.isProperty1Set()) {
                apiNginxAdditionalIngressAnnotations.setProperty1(src.getProperty1());
            }
            if (src.isProperty2Set()) {
                apiNginxAdditionalIngressAnnotations.setProperty2(src.getProperty2());
            }

        }

        return apiNginxAdditionalIngressAnnotations;
    }

    public static Strategy toBl(ApiStrategy src) {
        Strategy strategy = null;

        if (src != null) {
            Strategy.Builder strategyBuilder = Strategy.Builder.get();

            if (src.isNameSet()) {
                strategyBuilder.setName(src.getName());
            }
            if (src.isCanarySet()) {
                strategyBuilder.setCanary(toBl(src.getCanary()));
            }
            strategy = strategyBuilder.build();
        }

        return strategy;
    }

    public static StrategyCanary toBl(ApiStrategyCanary src) {
        StrategyCanary strategyCanary = null;

        if (src != null) {
            StrategyCanary.Builder strategyCanaryBuilder = StrategyCanary.Builder.get();

            if (src.isBackgroundVerificationSet()) {
                strategyCanaryBuilder.setBackgroundVerification(toBl(src.getBackgroundVerification()));
            }
            if (src.isStepsSet()) {
                List<CanarySteps> canarySteps = src.getSteps().stream().map(OceanCDConverter::toBl)
                        .collect(Collectors.toList());
                strategyCanaryBuilder.setSteps(canarySteps);
            }
            strategyCanary = strategyCanaryBuilder.build();
        }

        return strategyCanary;
    }

    public static CanaryBackgroundVerification toBl(ApiCanaryBackgroundVerification src) {
        CanaryBackgroundVerification canaryBackgroundVerification = null;

        if (src != null) {
            CanaryBackgroundVerification.Builder canaryBackgroundVerificationBuilder = CanaryBackgroundVerification.Builder.get();

            if (src.isTemplateNamesSet()) {
                canaryBackgroundVerificationBuilder.setTemplateNames(src.getTemplateNames());
            }
            if (src.isArgsSet()) {
                List<BackgroundVerificationArgs> args = src.getArgs().stream().map(OceanCDConverter::toBl)
                        .collect(Collectors.toList());
                canaryBackgroundVerificationBuilder.setArgs(args);
            }
            canaryBackgroundVerification = canaryBackgroundVerificationBuilder.build();
        }

        return canaryBackgroundVerification;
    }

    public static BackgroundVerificationArgs toBl(ApiBackgroundVerificationArgs src) {
        BackgroundVerificationArgs backgroundVerificationArgs = null;

        if (src != null) {
            BackgroundVerificationArgs.Builder backgroundVerificationArgsBuilder = BackgroundVerificationArgs.Builder.get();

            if (src.isNameSet()) {
                backgroundVerificationArgsBuilder.setName(src.getName());
            }
            if (src.isValueSet()) {
                backgroundVerificationArgsBuilder.setValue(src.getValue());
            }
            if (src.isValueFromSet()) {
                backgroundVerificationArgsBuilder.setValueFrom(toBl(src.getValueFrom()));
            }
            backgroundVerificationArgs = backgroundVerificationArgsBuilder.build();
        }

        return backgroundVerificationArgs;
    }

    public static ArgsValueFrom toBl(ApiArgsValueFrom src) {
        ArgsValueFrom argsValueFrom = null;

        if (src != null) {
            ArgsValueFrom.Builder argsValueFromBuilder = ArgsValueFrom.Builder.get();

            if (src.isSecretRefSet()) {
                argsValueFromBuilder.setSecretRef(toBl(src.getSecretRef()));
            }
            if (src.isFiledRefSet()) {
                argsValueFromBuilder.setFiledRef(toBl(src.getFiledRef()));
            }
            argsValueFrom = argsValueFromBuilder.build();
        }

        return argsValueFrom;
    }

    public static ValueFromSecretRef toBl(ApiValueFromSecretRef src) {
        ValueFromSecretRef valueFromSecretRef = null;

        if (src != null) {
            ValueFromSecretRef.Builder valueFromSecretRefBuilder = ValueFromSecretRef.Builder.get();

            if (src.isNameSet()) {
                valueFromSecretRefBuilder.setName(src.getName());
            }
            if (src.isKeySet()) {
                valueFromSecretRefBuilder.setKey(src.getKey());
            }
            valueFromSecretRef = valueFromSecretRefBuilder.build();
        }

        return valueFromSecretRef;
    }

    public static ValueFromFiledRef toBl(ApiValueFromFiledRef src) {
        ValueFromFiledRef valueFromFiledRef = null;

        if (src != null) {
            ValueFromFiledRef.Builder valueFromFiledRefBuilder = ValueFromFiledRef.Builder.get();

            if (src.isFieldPathSet()) {
                valueFromFiledRefBuilder.setFieldPath(src.getFieldPath());
            }
            valueFromFiledRef = valueFromFiledRefBuilder.build();
        }

        return valueFromFiledRef;
    }


    public static CanarySteps toBl(ApiCanarySteps src) {
        CanarySteps canarySteps = null;

        if (src != null) {
            CanarySteps.Builder canaryStepsBuilder = CanarySteps.Builder.get();

            if (src.isNameSet()) {
                canaryStepsBuilder.setName(src.getName());
            }
            if (src.isPauseSet()) {
                canaryStepsBuilder.setPause(toBl(src.getPause()));
            }
            if (src.isSetWeightSet()) {
                canaryStepsBuilder.setSetWeight(src.getSetWeight());
            }
            if (src.isVerificationSet()) {
                canaryStepsBuilder.setVerification(toBl(src.getVerification()));
            }
            if (src.isSetCanaryScaleSet()) {
                canaryStepsBuilder.setSetCanaryScale(toBl(src.getSetCanaryScale()));
            }
            canarySteps = canaryStepsBuilder.build();
        }

        return canarySteps;
    }

    public static StepsPause toBl(ApiStepsPause src) {
        StepsPause stepsPause = null;

        if (src != null) {
            StepsPause.Builder stepsPauseBuilder = StepsPause.Builder.get();

            if (src.isDurationSet()) {
                stepsPauseBuilder.setDuration(src.getDuration());
            }
            stepsPause = stepsPauseBuilder.build();
        }
        return stepsPause;
    }

    public static StepsSetCanaryScale toBl(ApiStepsSetCanaryScale src) {
        StepsSetCanaryScale stepsSetCanaryScale = null;

        if (src != null) {
            StepsSetCanaryScale.Builder stepsSetCanaryScaleBuilder = StepsSetCanaryScale.Builder.get();

            if (src.isMatchTrafficWeightSet()) {
                stepsSetCanaryScaleBuilder.setMatchTrafficWeight(src.getMatchTrafficWeight());
            }

            if (src.isReplicasSet()) {
                stepsSetCanaryScaleBuilder.setReplicas(src.getReplicas());
            }

            if (src.isWeightSet()) {
                stepsSetCanaryScaleBuilder.setWeight(src.getWeight());
            }
            stepsSetCanaryScale = stepsSetCanaryScaleBuilder.build();
        }
        return stepsSetCanaryScale;
    }

    public static RolloutSpec toBl(ApiRolloutSpec src) {
        RolloutSpec rolloutSpec = null;

        if (src != null) {
            RolloutSpec.Builder rolloutSpecBuilder = RolloutSpec.Builder.get();

            if (src.isNameSet()) {
                rolloutSpecBuilder.setName(src.getName());
            }
            if (src.isSpotDeploymentSet()) {
                rolloutSpecBuilder.setSpotDeployment(toBl(src.getSpotDeployment()));
            }
            if (src.isStrategySet()) {
                rolloutSpecBuilder.setStrategy(toBl(src.getStrategy()));
            }
            if (src.isTrafficSet()) {
                rolloutSpecBuilder.setTraffic(toBl(src.getTraffic()));
            }
            if (src.isFailurePolicySet()) {
                rolloutSpecBuilder.setFailurePolicy(toBl(src.getFailurePolicy()));
            }
            rolloutSpec = rolloutSpecBuilder.build();
        }

        return rolloutSpec;
    }

    public static RolloutSpecFailurePolicy toBl(ApiRolloutSpecFailurePolicy src) {
        RolloutSpecFailurePolicy rolloutSpecFailurePolicy = null;

        if (src != null) {
            RolloutSpecFailurePolicy.Builder builder = RolloutSpecFailurePolicy.Builder.get();

            if (src.isActionSet()) {
                builder.setAction(src.getAction());
            }
            rolloutSpecFailurePolicy = builder.build();
        }

        return rolloutSpecFailurePolicy;
    }

    public static RolloutSpecSpotDeployment toBl(ApiRolloutSpecSpotDeployment src) {
        RolloutSpecSpotDeployment rolloutSpecSpotDeployment = null;

        if (src != null) {
            RolloutSpecSpotDeployment.Builder builder = RolloutSpecSpotDeployment.Builder.get();

            if (src.isClusterIdSet()) {
                builder.setClusterId(src.getClusterId());
            }
            if (src.isNameSet()) {
                builder.setName(src.getName());
            }
            if (src.isNamespaceSet()) {
                builder.setNamespace(src.getNamespace());
            }
            rolloutSpecSpotDeployment = builder.build();
        }

        return rolloutSpecSpotDeployment;
    }

    public static RolloutSpecStrategy toBl(ApiRolloutSpecStrategy src) {
        RolloutSpecStrategy rolloutSpecStrategy = null;

        if (src != null) {
            RolloutSpecStrategy.Builder builder = RolloutSpecStrategy.Builder.get();

            if (src.isNameSet()) {
                builder.setName(src.getName());
            }
            if (src.isArgsSet()) {
                List<BackgroundVerificationArgs> args = src.getArgs().stream().map(OceanCDConverter::toBl)
                        .collect(Collectors.toList());
                builder.setArgs(args);
            }
            rolloutSpecStrategy = builder.build();
        }

        return rolloutSpecStrategy;
    }

    public static RolloutSpecTraffic toBl(ApiRolloutSpecTraffic src) {
        RolloutSpecTraffic rolloutSpecTraffic = null;

        if (src != null) {
            RolloutSpecTraffic.Builder builder = RolloutSpecTraffic.Builder.get();

            if (src.isCanaryServiceSet()) {
                builder.setCanaryService(src.getCanaryService());
            }
            if (src.isStableServiceSet()) {
                builder.setStableService(src.getStableService());
            }
            if (src.isIstioSet()) {
                builder.setIstio(toBl(src.getIstio()));
            }
            if (src.isNginxSet()) {
                builder.setNginx(toBl(src.getNginx()));
            }
            if (src.isAlbSet()) {
                builder.setAlb(toBl(src.getAlb()));
            }
            if (src.isSmiSet()) {
                builder.setSmi(toBl(src.getSmi()));
            }
            if (src.isAmbassadorSet()) {
                builder.setAmbassador(toBl(src.getAmbassador()));
            }
            if (src.isAppMeshSet()) {
                builder.setAppMesh(toBl(src.getAppMesh()));
            }
            if (src.isPingPongSet()) {
                builder.setPingPong(toBl(src.getPingPong()));
            }
            rolloutSpecTraffic = builder.build();
        }

        return rolloutSpecTraffic;
    }

    public static TrafficAppMesh toBl(ApiTrafficAppMesh src) {
        TrafficAppMesh trafficAppMesh = null;

        if (src != null) {
            TrafficAppMesh.Builder builder = TrafficAppMesh.Builder.get();

            if (src.isVirtualServiceSet()) {
                builder.setVirtualService(toBl(src.getVirtualService()));
            }
            if (src.isVirtualNodeGroupSet()) {
                builder.setVirtualNodeGroup(toBl(src.getVirtualNodeGroup()));
            }
            trafficAppMesh = builder.build();

        }

        return trafficAppMesh;
    }

    public static AppMeshVirtualService toBl(ApiAppMeshVirtualService src) {
        AppMeshVirtualService appMeshVirtualService = null;

        if (src != null) {
            AppMeshVirtualService.Builder builder = AppMeshVirtualService.Builder.get();

            if (src.isNameSet()) {
                builder.setName(src.getName());
            }
            if (src.isRoutesSet()) {
                builder.setRoutes(src.getRoutes());
            }
            appMeshVirtualService = builder.build();
        }

        return appMeshVirtualService;
    }

    public static AppMeshVirtualNodeGroup toBl(ApiAppMeshVirtualNodeGroup src) {
        AppMeshVirtualNodeGroup appMeshVirtualNodeGroup = null;

        if (src != null) {
            AppMeshVirtualNodeGroup.Builder builder = AppMeshVirtualNodeGroup.Builder.get();

            if (src.isCanaryVirtualNodeRefSet()) {
                builder.setCanaryVirtualNodeRef(toBl(src.getCanaryVirtualNodeRef()));
            }
            if (src.isStableVirtualNodeRefSet()) {
                builder.setStableVirtualNodeRef(toBl(src.getStableVirtualNodeRef()));
            }
            appMeshVirtualNodeGroup = builder.build();
        }

        return appMeshVirtualNodeGroup;
    }

    public static VirtualNodeGroupCanaryStableVirtualNodeRef toBl(ApiVirtualNodeGroupCanaryStableVirtualNodeRef src) {
        VirtualNodeGroupCanaryStableVirtualNodeRef virtualNodeGroupCanaryStableVirtualNodeRef = null;

        if (src != null) {
            VirtualNodeGroupCanaryStableVirtualNodeRef.Builder builder = VirtualNodeGroupCanaryStableVirtualNodeRef.Builder.get();

            if (src.isNameSet()) {
                builder.setName(src.getName());
            }
            virtualNodeGroupCanaryStableVirtualNodeRef = builder.build();
        }

        return virtualNodeGroupCanaryStableVirtualNodeRef;
    }

    public static TrafficPingPong toBl(ApiTrafficPingPong src) {
        TrafficPingPong trafficPingPong = null;

        if (src != null) {
            TrafficPingPong.Builder builder = TrafficPingPong.Builder.get();

            if (src.isPingServiceSet()) {
                builder.setPingService(src.getPingService());
            }
            if (src.isPongServiceSet()) {
                builder.setPongService(src.getPongService());
            }
            trafficPingPong = builder.build();
        }

        return trafficPingPong;
    }

    public static TrafficAlb toBl(ApiTrafficAlb src) {
        TrafficAlb trafficAlb = null;

        if (src != null) {
            TrafficAlb.Builder builder = TrafficAlb.Builder.get();

            if (src.isIngressSet()) {
                builder.setIngress(src.getIngress());
            }
            if (src.isServicePortSet()) {
                builder.setServicePort(src.getServicePort());
            }
            if (src.isRootServiceSet()) {
                builder.setRootService(src.getRootService());
            }
            if (src.isAnnotationPrefixSet()) {
                builder.setAnnotationPrefix(src.getAnnotationPrefix());
            }
            if (src.isStickinessConfigSet()) {
                builder.setStickinessConfig(toBl(src.getStickinessConfig()));
            }
            trafficAlb = builder.build();

        }

        return trafficAlb;
    }

    public static TrafficAmbassador toBl(ApiTrafficAmbassador src) {
        TrafficAmbassador trafficAmbassador = null;

        if (src != null) {
            TrafficAmbassador.Builder builder = TrafficAmbassador.Builder.get();

            if (src.isMappingsSet()) {
                builder.setMappings(src.getMappings());
            }
            trafficAmbassador = builder.build();

        }

        return trafficAmbassador;
    }

    public static AlbStickinessConfig toBl(ApiAlbStickinessConfig src) {
        AlbStickinessConfig albStickinessConfig = null;

        if (src != null) {
            AlbStickinessConfig.Builder builder = AlbStickinessConfig.Builder.get();

            if (src.isEnabledSet()) {
                builder.setEnabled(src.getEnabled());
            }
            if (src.isDurationSecondsSet()) {
                builder.setDurationSeconds(src.getDurationSeconds());
            }
            albStickinessConfig = builder.build();

        }

        return albStickinessConfig;
    }

    public static TrafficSmi toBl(ApiTrafficSmi src) {
        TrafficSmi trafficSmi = null;

        if (src != null) {
            TrafficSmi.Builder builder = TrafficSmi.Builder.get();

            if (src.isRootServiceSet()) {
                builder.setRootService(src.getRootService());
            }
            if (src.isTrafficSplitNameSet()) {
                builder.setTrafficSplitName(src.getTrafficSplitName());
            }
            trafficSmi = builder.build();

        }

        return trafficSmi;
    }

    public static TrafficIstio toBl(ApiTrafficIstio src) {
        TrafficIstio trafficIstio = null;

        if (src != null) {
            TrafficIstio.Builder builder = TrafficIstio.Builder.get();

            if (src.isVirtualServicesSet()) {
                builder.setVirtualServices(toBl(src.getVirtualServices()));
            }
            if (src.isDestinationRuleSet()) {
                builder.setDestinationRule(toBl(src.getDestinationRule()));
            }
            trafficIstio = builder.build();

        }

        return trafficIstio;
    }

    public static IstioVirtualServices toBl(ApiIstioVirtualServices src) {
        IstioVirtualServices istioVirtualServices = null;

        if (src != null) {
            IstioVirtualServices.Builder builder = IstioVirtualServices.Builder.get();

            if (src.isNameSet()) {
                builder.setName(src.getName());
            }
            if (src.isRoutesSet()) {
                builder.setRoutes(src.getRoutes());
            }
            if (src.isTlsRoutesSet()) {
                List<VirtualServicesTlsRoutes> args = src.getTlsRoutes().stream().map(OceanCDConverter::toBl)
                        .collect(Collectors.toList());
                builder.setTlsRoutes(args);
            }
            istioVirtualServices = builder.build();
        }

        return istioVirtualServices;
    }

    public static VirtualServicesTlsRoutes toBl(ApiVirtualServicesTlsRoutes src) {
        VirtualServicesTlsRoutes virtualServicesTlsRoutes = null;

        if (src != null) {
            VirtualServicesTlsRoutes.Builder builder = VirtualServicesTlsRoutes.Builder.get();

            if (src.isPortSet()) {
                builder.setPort(src.getPort());
            }
            if (src.isSniHostsSet()) {
                builder.setSniHosts(src.getSniHosts());
            }
            virtualServicesTlsRoutes = builder.build();
        }

        return virtualServicesTlsRoutes;
    }

    public static IstioDestinationRule toBl(ApiIstioDestinationRule src) {
        IstioDestinationRule istioDestinationRule = null;

        if (src != null) {
            IstioDestinationRule.Builder builder = IstioDestinationRule.Builder.get();

            if (src.isNameSet()) {
                builder.setName(src.getName());
            }
            if (src.isCanarySubsetNameSet()) {
                builder.setCanarySubsetName(src.getCanarySubsetName());
            }
            if (src.isStableSubsetNameSet()) {
                builder.setStableSubsetName(src.getStableSubsetName());
            }
        }

        return istioDestinationRule;
    }

    public static TrafficNginx toBl(ApiTrafficNginx src) {
        TrafficNginx trafficNginx = null;

        if (src != null) {
            TrafficNginx.Builder builder = TrafficNginx.Builder.get();

            if (src.isAnnotationPrefixSet()) {
                builder.setAnnotationPrefix(src.getAnnotationPrefix());
            }
            if (src.isStableIngressSet()) {
                builder.setStableIngress(src.getStableIngress());
            }
            if (src.isAdditionalIngressAnnotationsSet()) {
                builder.setAdditionalIngressAnnotations(toBl(src.getAdditionalIngressAnnotations()));
            }
            trafficNginx = builder.build();

        }

        return trafficNginx;
    }

    public static NginxAdditionalIngressAnnotations toBl(ApiNginxAdditionalIngressAnnotations src) {
        NginxAdditionalIngressAnnotations nginxAdditionalIngressAnnotations = null;

        if (src != null) {
            NginxAdditionalIngressAnnotations.Builder builder = NginxAdditionalIngressAnnotations.Builder.get();

            if (src.isProperty1Set()) {
                builder.setProperty1(src.getProperty1());
            }
            if (src.isProperty2Set()) {
                builder.setProperty2(src.getProperty2());
            }
            nginxAdditionalIngressAnnotations = builder.build();

        }

        return nginxAdditionalIngressAnnotations;
    }

}
