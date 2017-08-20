package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.SubscriptionEventTypeEnum;
import com.spotinst.sdkjava.enums.SubscriptionProtocolEnum;

/**
 * Created by talzur on 18/01/2017.
 */
public class SubscriptionConverter {
    //region BL -> DAL
    public static ApiSubscription toDal(Subscription subscription) {
        ApiSubscription apiSubscription = null;

        if (subscription != null) {
            apiSubscription = new ApiSubscription();

            apiSubscription.setResourceId(subscription.getResourceId());
            apiSubscription.setProtocol(subscription.getProtocol().getName());
            apiSubscription.setEventType(subscription.getEventType().getName());
            apiSubscription.setEndpoint(subscription.getEndpoint());
            if (subscription.getEventFormat() != null) {
                apiSubscription.setEventFormat(subscription.getEventFormat());
            }

        }

        return apiSubscription;
    }

    //endregion

    //region DAL -> BL
    public static Subscription toBl(ApiSubscription apiSubscription) {
        Subscription retVal = null;

        if (apiSubscription != null) {
            Subscription.Builder subscriptionBuilder = Subscription.Builder.get();

            subscriptionBuilder.setResourceId(apiSubscription.getResourceId());
            subscriptionBuilder.setProtocol(SubscriptionProtocolEnum.fromName(apiSubscription.getProtocol()));
            subscriptionBuilder.setEventType(SubscriptionEventTypeEnum.fromName(apiSubscription.getEventType()));
            subscriptionBuilder.setEndpoint(apiSubscription.getEndpoint());
            if (apiSubscription.getEventFormat() != null) {
                subscriptionBuilder.setEventFormat(apiSubscription.getEventFormat());
            }

            subscriptionBuilder.setId(apiSubscription.getId());

            retVal = subscriptionBuilder.build();
        }

        return retVal;
    }

    //endregion
}
