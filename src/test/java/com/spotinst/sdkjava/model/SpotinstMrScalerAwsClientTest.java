package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerAws;
import com.spotinst.sdkjava.model.requests.mrScaler.aws.ApiMrScalerAwsCreationRequest;
import com.spotinst.sdkjava.model.requests.mrScaler.aws.ApiMrScalerAwsDeleteRequest;
import com.spotinst.sdkjava.model.requests.mrScaler.aws.ApiMrScalerAwsGetRequest;
import com.spotinst.sdkjava.model.requests.mrScaler.aws.ApiMrScalerAwsUpdateRequest;
import org.junit.Test;
import org.junit.Before;
import static org.mockito.Mockito.*;

public class SpotinstMrScalerAwsClientTest {
    public ISpotinstMrScalerAwsRepo mockedRepo;
    public String auth_token = "";
    public String account = "";
    public RepoGenericResponse response;
    public SpotinstMrScalerAwsClient spotinstClientSpy;


    @Before
    public void startUp(){
        mockedRepo = mock(ISpotinstMrScalerAwsRepo.class);

        spotinstClientSpy = spy(new SpotinstMrScalerAwsClient(auth_token, account));

        response = mock(RepoGenericResponse.class);
    }

    @Test
    public void createMrScaler() {
        System.out.println("SpotinstMrScalerClientTest.createMrScaler()");

        ApiMrScalerAwsCreationRequest.Builder mrScalerBuilder = ApiMrScalerAwsCreationRequest.Builder.get();
        ApiMrScalerAwsCreationRequest mrScaler = mrScalerBuilder.build();

        ApiMrScalerAws clusterToCreate = mrScaler.getMrScaler();

        when(response.isRequestSucceed())
                .thenReturn(Boolean.TRUE);
        when(mockedRepo.create(clusterToCreate,auth_token,account))
                .thenReturn(response);

        when(spotinstClientSpy.getSpotinstMrScalerRepo())
                .thenReturn(mockedRepo);

        spotinstClientSpy.createMrScaler(mrScaler);
    }

    @Test
    public void updateMrScaler() {
        System.out.println("SpotinstMrScalerClientTest.updateMrScaler()");

        ApiMrScalerAwsUpdateRequest.Builder mrScalerBuilder = ApiMrScalerAwsUpdateRequest.Builder.get();
        ApiMrScalerAwsUpdateRequest         mrScaler        = mrScalerBuilder.build();

        ApiMrScalerAws clusterToUpdate = mrScaler.getMrScaler();

        when(response.isRequestSucceed())
                .thenReturn(Boolean.TRUE);
        when(mockedRepo.update("sims-1234567",clusterToUpdate,auth_token,account))
                .thenReturn(response);

        when(spotinstClientSpy.getSpotinstMrScalerRepo())
                .thenReturn(mockedRepo);

        spotinstClientSpy.updateMrScaler(mrScaler, "sims-1234567");
    }

    @Test
    public void deleteMrScaler() {
        System.out.println("SpotinstMrScalerClientTest.deleteMrScaler()");

        ApiMrScalerAwsDeleteRequest.Builder mrScalerBuilder = ApiMrScalerAwsDeleteRequest.Builder.get();
        ApiMrScalerAwsDeleteRequest         mrScaler        = mrScalerBuilder.build();

        String clusterToDelete = mrScaler.getMrScalerId();

        when(response.isRequestSucceed())
                .thenReturn(Boolean.TRUE);
        when(mockedRepo.delete(clusterToDelete,auth_token,account))
                .thenReturn(response);

        when(spotinstClientSpy.getSpotinstMrScalerRepo())
                .thenReturn(mockedRepo);

        spotinstClientSpy.deleteMrScaler(mrScaler);
    }

    @Test
    public void getMrScaler() {
        System.out.println("SpotinstMrScalerClientTest.getMrScaler()");

        ApiMrScalerAwsGetRequest.Builder mrScalerBuilder = ApiMrScalerAwsGetRequest.Builder.get();
        ApiMrScalerAwsGetRequest         mrScaler        = mrScalerBuilder.build();

        String clusterToGet = mrScaler.getMrScalerId();

        when(response.isRequestSucceed())
                .thenReturn(Boolean.TRUE);
        when(mockedRepo.get(clusterToGet,auth_token,account))
                .thenReturn(response);

        when(spotinstClientSpy.getSpotinstMrScalerRepo())
                .thenReturn(mockedRepo);

        spotinstClientSpy.getMrScaler(mrScaler);
    }

    @Test
    public void getAllMrScalers() {
        System.out.println("SpotinstMrScalerClientTest.getAllMrScaler()");

        when(response.isRequestSucceed())
                .thenReturn(Boolean.TRUE);
        when(mockedRepo.getAll(null, auth_token,account))
                .thenReturn(response);

        when(spotinstClientSpy.getSpotinstMrScalerRepo())
                .thenReturn(mockedRepo);

        spotinstClientSpy.getAllMrScalers();
    }
}