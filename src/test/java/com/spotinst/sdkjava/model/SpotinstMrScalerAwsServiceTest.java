package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.response.*;
import com.spotinst.sdkjava.client.rest.*;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.MrScalerAws;
import com.spotinst.sdkjava.model.responses.mrScaler.aws.MrScalerApiResponse;
import com.spotinst.sdkjava.model.service.mrScaler.aws.SpotinstMrScalerAwsService;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({RestClient.class, SpotinstHttpContext.class, BaseSpotinstService.class})
public class SpotinstMrScalerAwsServiceTest {
    SpotinstMrScalerAwsService spotinstMrScalerAwsService;
    String auth_token = "";
    String account = "";
    RestResponse RestResponse;
    Map<String, String> queryParams;
    Map<String, String> headers;
    Map<String, MrScalerAws> mrScalerRequest;
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
        mrScalerRequest = new HashMap<>();
        headers = new HashMap<>();

        when(SpotinstHttpContext.getConfiguration())
                .thenReturn(SpotinstHttpConfig);
        when(SpotinstHttpContext.getInstance())
                .thenReturn(SpotinstHttpContext);

        spotinstMrScalerAwsService = new SpotinstMrScalerAwsService();
    }

    @Test
    public void createMrScaler() {
        System.out.println("SpotinstMrScalerServiceTest.createMrScaler()");

        MrScalerAws mrScalerAws = mock(MrScalerAws.class);

        mrScalerRequest.put("mrScaler", mrScalerAws);
        String body = JsonMapper.toJson(mrScalerRequest);

        queryParams.put("accountId", account);

        when(RestClient.sendPost("null/aws/emr/mrScaler",body, headers, queryParams))
                .thenReturn(RestResponse);


        MrScalerApiResponse mrScalerApiResponse = mock(MrScalerApiResponse.class);
        ItemsInnerResponse ItemsInnerResponse = mock(ItemsInnerResponse.class);

        when(BaseSpotinstService.getCastedResponse(RestResponse, MrScalerApiResponse.class))
                .thenReturn(mrScalerApiResponse);

        when(ItemsInnerResponse.getCount())
                .thenReturn(0);
        when(mrScalerApiResponse.getResponse())
                .thenReturn(ItemsInnerResponse);


        spotinstMrScalerAwsService.createMrScaler(mrScalerAws, auth_token, account);
    }

    @Test
    public void updateMrScaler() {
    }

    @Test
    public void deleteMrScaler() {
        System.out.println("SpotinstMrScalerServiceTest.deleteMrScaler()");

        queryParams.put("accountId", account);

        when(RestClient.sendDelete("null/aws/emr/mrScaler/sims-1234567", null, headers, queryParams))
                .thenReturn(RestResponse);

        BaseServiceEmptyResponse emptyResponse = mock(BaseServiceEmptyResponse.class);

        BaseInnerResponse innerResponse = new BaseInnerResponse();
        ResponseStatus status = new ResponseStatus();

        status.setCode(HttpStatus.SC_OK);
        innerResponse.setStatus(status);
        emptyResponse.setResponse(innerResponse);

        when(BaseSpotinstService.getCastedResponse(RestResponse, BaseServiceEmptyResponse.class))
                .thenReturn(emptyResponse);

        when(emptyResponse.getResponse())
                .thenReturn(innerResponse);

        spotinstMrScalerAwsService.deleteMrScaler("sims-1234567", auth_token, account);
    }

    @Test
    public void getMrScaler() {
        System.out.println("SpotinstMrScalerServiceTest.getMrScaler()");

        queryParams.put("accountId", account);

        when(RestClient.sendGet("null/aws/emr/mrScaler/sims-1234567", headers, queryParams))
                .thenReturn(RestResponse);


        MrScalerApiResponse mrScalerApiResponse = mock(MrScalerApiResponse.class);
        ItemsInnerResponse ItemsInnerResponse = mock(ItemsInnerResponse.class);

        when(BaseSpotinstService.getCastedResponse(RestResponse, MrScalerApiResponse.class))
                .thenReturn(mrScalerApiResponse);

        when(ItemsInnerResponse.getCount())
                .thenReturn(0);
        when(mrScalerApiResponse.getResponse())
                .thenReturn(ItemsInnerResponse);


        spotinstMrScalerAwsService.getMrScaler("sims-1234567", auth_token, account);
    }

    @Test
    public void getAllMrScaler() {
        System.out.println("SpotinstMrScalerServiceTest.getAllMrScaler()");

        queryParams.put("accountId", account);

        when(RestClient.sendGet("null/aws/emr/mrScaler", headers, queryParams))
                .thenReturn(RestResponse);


        MrScalerApiResponse mrScalerApiResponse = mock(MrScalerApiResponse.class);
        ItemsInnerResponse ItemsInnerResponse = mock(ItemsInnerResponse.class);

        when(BaseSpotinstService.getCastedResponse(RestResponse, MrScalerApiResponse.class))
                .thenReturn(mrScalerApiResponse);

        when(ItemsInnerResponse.getCount())
                .thenReturn(0);
        when(mrScalerApiResponse.getResponse())
                .thenReturn(ItemsInnerResponse);


        spotinstMrScalerAwsService.getAllMrScaler(auth_token, account);
    }
}