package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.SubscriptionEventTypeEnum;
import com.spotinst.sdkjava.enums.SubscriptionProtocolEnum;
import com.spotinst.sdkjava.model.api.admin.account.ApiSubscription;
import com.spotinst.sdkjava.model.api.admin.account.common.ApiSubscriptionEventFormat;
import com.spotinst.sdkjava.model.api.admin.account.response.ApiSubscriptionResponse;
import com.spotinst.sdkjava.model.bl.admin.account.Subscription;
import com.spotinst.sdkjava.model.bl.admin.account.common.SubscriptionEventFormat;
import com.spotinst.sdkjava.model.bl.admin.account.response.SubscriptionResponse;

/**
 * Created by talzur on 18/01/2017.
 * Modified by Janetlin Kiruba on 25/10/2022
 */
public class SubscriptionConverter {
    //region BL -> DAL
    public static ApiSubscription toDal(Subscription subscription) {
        ApiSubscription apiSubscription = null;

        if (subscription != null) {
            apiSubscription = new ApiSubscription();

            if (subscription.getResourceId() != null) {
                apiSubscription.setResourceId(subscription.getResourceId());
            }
            if (subscription.getProtocol() != null) {
                apiSubscription.setProtocol(subscription.getProtocol().getName());
            }
            if (subscription.getEventType() != null) {
                apiSubscription.setEventType(subscription.getEventType().getName());
            }
            if (subscription.getEndpoint() != null) {
                apiSubscription.setEndpoint(subscription.getEndpoint());
            }
            if (subscription.getEventFormat() != null) {
                apiSubscription.setEventFormat(toDal(subscription.getEventFormat()));
            }

        }

        return apiSubscription;
    }

    public static ApiSubscriptionEventFormat toDal(SubscriptionEventFormat subscription) {
        ApiSubscriptionEventFormat apiSubscription = null;

        if (subscription != null) {
            apiSubscription = new ApiSubscriptionEventFormat();

            if (subscription.getResourceId() != null) {
                apiSubscription.setResourceId(subscription.getResourceId());
            }
            if (subscription.getEvent() != null) {
                apiSubscription.setEvent(subscription.getEvent());
            }
            if (subscription.getResourceName() != null) {
                apiSubscription.setResourceName(subscription.getResourceName());
            }
            if (subscription.getInstanceId() != null) {
                apiSubscription.setInstanceId(subscription.getInstanceId());
            }
            if (subscription.getMyCustomKey() != null) {
                apiSubscription.setMyCustomKey(subscription.getMyCustomKey());
            }
        }

        return apiSubscription;
    }

    //endregion

    //region DAL -> BL
    public static SubscriptionResponse toBl(ApiSubscriptionResponse apiSubscription) {
        SubscriptionResponse retVal = null;

        if (apiSubscription != null) {
            SubscriptionResponse.Builder subscriptionBuilder = SubscriptionResponse.Builder.get();

            if (apiSubscription.getResourceId() != null) {
                subscriptionBuilder.setResourceId(apiSubscription.getResourceId());
            }
            if (apiSubscription.getProtocol() != null) {
                subscriptionBuilder.setProtocol(apiSubscription.getProtocol());
            }
            if (apiSubscription.getEventType() != null) {
                subscriptionBuilder.setEventType(apiSubscription.getEventType());
            }
            if (apiSubscription.getEndpoint() != null) {
                subscriptionBuilder.setEndpoint(apiSubscription.getEndpoint());
            }
            if (apiSubscription.getEventFormat() != null) {
                subscriptionBuilder.setEventFormat(toBl(apiSubscription.getEventFormat()));
            }
            if (apiSubscription.getId() != null) {
                subscriptionBuilder.setId(apiSubscription.getId());
            }
            if (apiSubscription.getResourceName() != null) {
                subscriptionBuilder.setResourceName(apiSubscription.getResourceName());
            }
            if (apiSubscription.getCreatedAt() != null) {
                subscriptionBuilder.setCreatedAt(apiSubscription.getCreatedAt());
            }if (apiSubscription.getUpdatedAt() != null) {
                subscriptionBuilder.setUpdatedAt(apiSubscription.getUpdatedAt());
            }


            retVal = subscriptionBuilder.build();
        }

        return retVal;
    }

    public static SubscriptionEventFormat toBl(ApiSubscriptionEventFormat subscription) {
        SubscriptionEventFormat apiSubscription = null;

        if (subscription != null) {
            SubscriptionEventFormat.Builder subscriptionBuilder = SubscriptionEventFormat.Builder.get();

            if (subscription.getResourceId() != null) {
                subscriptionBuilder.setResourceId(subscription.getResourceId());
            }
            if (subscription.getEvent() != null) {
                subscriptionBuilder.setEvent(subscription.getEvent());
            }
            if (subscription.getResourceName() != null) {
                subscriptionBuilder.setResourceName(subscription.getResourceName());
            }
            if (subscription.getInstanceId() != null) {
                subscriptionBuilder.setInstanceId(subscription.getInstanceId());
            }
            if (subscription.getMyCustomKey() != null) {
                subscriptionBuilder.setMyCustomKey(subscription.getMyCustomKey());
            }
            apiSubscription = subscriptionBuilder.build();
        }

        return apiSubscription;
    }

    //endregion
}
