package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.client.response.ItemsInnerResponse;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({RestClient.class, SpotinstHttpContext.class, BaseSpotinstService.class})
public class SpotinstElastigroupServiceTest {
    SpotinstElastigroupService spotinstElastigroupService;
    String auth_token = "";
    String account = "";
    RestResponse RestResponse;
    Map<String, String> queryParams;
    Map<String, String> headers;
    Map<String, ApiElastigroup> groupRequest;
    SpotinstHttpContext SpotinstHttpContext;
    SpotinstHttpConfig SpotinstHttpConfig;

    @Before
    public void setUp() throws Exception {
        PowerMockito.mockStatic(RestClient.class);
        PowerMockito.mockStatic(SpotinstHttpContext.class);
        PowerMockito.mockStatic(BaseSpotinstService.class);

        RestResponse = mock(RestResponse.class);
        SpotinstHttpContext = mock(SpotinstHttpContext.class);
        SpotinstHttpConfig = mock(SpotinstHttpConfig.class);

        queryParams = new HashMap<>();
        groupRequest = new HashMap<>();
        headers = new HashMap<>();

        when(SpotinstHttpContext.getConfiguration())
                .thenReturn(SpotinstHttpConfig);
        when(SpotinstHttpContext.getInstance())
                .thenReturn(SpotinstHttpContext);

        spotinstElastigroupService = new SpotinstElastigroupService();
    }

    @Test
    public void createElastigroup() {
        System.out.println("SpotinstElastigroupServiceTest.createElastigroup()");

        ApiElastigroup apiElastigroup = mock(ApiElastigroup.class);

        groupRequest.put("group", apiElastigroup);
        String body = JsonMapper.toJson(groupRequest);

        queryParams.put("accountId", account);

        when(RestClient.sendPost("null/aws/ec2/group",body, headers, queryParams))
                .thenReturn(RestResponse);


        ElastigroupApiResponse ElastigroupApiResponse = mock(ElastigroupApiResponse.class);
        ItemsInnerResponse ItemsInnerResponse = mock(ItemsInnerResponse.class);

        when(BaseSpotinstService.getCastedResponse(RestResponse, ElastigroupApiResponse.class))
                .thenReturn(ElastigroupApiResponse);

        when(ItemsInnerResponse.getCount())
                .thenReturn(0);
        when(ElastigroupApiResponse.getResponse())
                .thenReturn(ItemsInnerResponse);


        spotinstElastigroupService.createElastigroup(apiElastigroup,auth_token, account);
    }

    @Test
    public void deleteElastigroup() {
    }

    @Test
    public void detachInstances() {
    }

    @Test
    public void getGroupActiveInstances() {
    }

    @Test
    public void getGroup() {
    }

    @Test
    public void updateGroup() {
    }

    @Test
    public void scaleGroupUp() {
        System.out.println("SpotinstElastigroupServiceTest.scaleGroupUp()");

        ElastigroupScalingRequest ElastigroupScalingRequest = mock(ElastigroupScalingRequest.class);

        when(ElastigroupScalingRequest.getAdjustment()).thenReturn(1);

        queryParams.put("accountId", account);
        queryParams.put("adjustment","1");

        when(RestClient.sendPut("null/aws/ec2/group/null/scale/up",null, headers, queryParams))
                .thenReturn(RestResponse);


        ApiElastigroupScalingResponseResponse ApiElastigroupScalingResponseResponse = mock(ApiElastigroupScalingResponseResponse.class);
        ItemsInnerResponse ItemsInnerResponse = mock(ItemsInnerResponse.class);

        when(BaseSpotinstService.getCastedResponse(RestResponse, ApiElastigroupScalingResponseResponse.class))
                .thenReturn(ApiElastigroupScalingResponseResponse);

        when(ItemsInnerResponse.getCount())
                .thenReturn(0);
        when(ApiElastigroupScalingResponseResponse.getResponse())
                .thenReturn(ItemsInnerResponse);


        spotinstElastigroupService.scaleGroupUp(ElastigroupScalingRequest,auth_token, account);
    }

    @Test
    public void scaleGroupDown() {
        System.out.println("SpotinstElastigroupServiceTest.scaleGroupDown()");

        ElastigroupScalingRequest ElastigroupScalingRequest = mock(ElastigroupScalingRequest.class);

        when(ElastigroupScalingRequest.getAdjustment()).thenReturn(1);

        queryParams.put("accountId", account);
        queryParams.put("adjustment","1");

        when(RestClient.sendPut("null/aws/ec2/group/null/scale/down",null, headers, queryParams))
                .thenReturn(RestResponse);


        ApiElastigroupScalingResponseResponse ApiElastigroupScalingResponseResponse = mock(ApiElastigroupScalingResponseResponse.class);
        ItemsInnerResponse ItemsInnerResponse = mock(ItemsInnerResponse.class);

        when(BaseSpotinstService.getCastedResponse(RestResponse, ApiElastigroupScalingResponseResponse.class))
                .thenReturn(ApiElastigroupScalingResponseResponse);

        when(ItemsInnerResponse.getCount())
                .thenReturn(0);
        when(ApiElastigroupScalingResponseResponse.getResponse())
                .thenReturn(ItemsInnerResponse);


        spotinstElastigroupService.scaleGroupDown(ElastigroupScalingRequest,auth_token, account);
    }
}