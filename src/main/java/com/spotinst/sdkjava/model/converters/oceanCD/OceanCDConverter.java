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
            if (src.isSetCanaryScaleSet()) {
                apiCanarySteps.setSetWeight(src.getSetWeight());
            }
            if (src.isVerificationSet()) {
                apiCanarySteps.setVerification(toDal(src.getVerification()));
            }
            if (src.isVerificationSet()) {
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

            if (src.isMatchTrafficWeightSet()) {
                apiStepsSetCanaryScale.setReplicas(src.getReplicas());
            }

            if (src.isWeightSet()) {
                apiStepsSetCanaryScale.setWeight(src.getWeight());
            }
        }
        return apiStepsSetCanaryScale;
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
            if (src.isCreatedAtSet()) {
                strategyBuilder.setCreatedAt(src.getCreatedAt());
            }
            if (src.isUpdatedAtSet()) {
                strategyBuilder.setUpdatedAt(src.getUpdatedAt());
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
            if (src.isSetCanaryScaleSet()) {
                canaryStepsBuilder.setSetWeight(src.getSetWeight());
            }
            if (src.isVerificationSet()) {
                canaryStepsBuilder.setVerification(toBl(src.getVerification()));
            }
            if (src.isVerificationSet()) {
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

            if (src.isMatchTrafficWeightSet()) {
                stepsSetCanaryScaleBuilder.setReplicas(src.getReplicas());
            }

            if (src.isWeightSet()) {
                stepsSetCanaryScaleBuilder.setWeight(src.getWeight());
            }
            stepsSetCanaryScale = stepsSetCanaryScaleBuilder.build();
        }
        return stepsSetCanaryScale;
    }
}
