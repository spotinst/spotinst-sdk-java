package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.mrScaler.aws.MrScalerAws;
import com.spotinst.sdkjava.model.requests.mrScaler.aws.MrScalerAwsCreationRequest;
import com.spotinst.sdkjava.model.requests.mrScaler.aws.MrScalerAwsDeleteRequest;
import com.spotinst.sdkjava.model.requests.mrScaler.aws.MrScalerAwsGetRequest;
import com.spotinst.sdkjava.model.requests.mrScaler.aws.MrScalerAwsUpdateRequest;
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

        MrScalerAwsCreationRequest.Builder mrScalerBuilder = MrScalerAwsCreationRequest.Builder.get();
        MrScalerAwsCreationRequest mrScaler = mrScalerBuilder.build();

        MrScalerAws clusterToCreate = mrScaler.getMrScaler();

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

        MrScalerAwsUpdateRequest.Builder mrScalerBuilder = MrScalerAwsUpdateRequest.Builder.get();
        MrScalerAwsUpdateRequest mrScaler        = mrScalerBuilder.build();

        MrScalerAws clusterToUpdate = mrScaler.getMrScaler();

        when(response.isRequestSucceed())
                .thenReturn(Boolean.TRUE);
        when(mockedRepo.update("mrScaleId",clusterToUpdate,auth_token,account))
                .thenReturn(response);

        when(spotinstClientSpy.getSpotinstMrScalerRepo())
                .thenReturn(mockedRepo);

        spotinstClientSpy.updateMrScaler(mrScaler, "mrScaleId");
    }

    @Test
    public void deleteMrScaler() {
        System.out.println("SpotinstMrScalerClientTest.deleteMrScaler()");

        MrScalerAwsDeleteRequest.Builder mrScalerBuilder = MrScalerAwsDeleteRequest.Builder.get();
        MrScalerAwsDeleteRequest         mrScaler        = mrScalerBuilder.build();

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

        MrScalerAwsGetRequest.Builder mrScalerBuilder = MrScalerAwsGetRequest.Builder.get();
        MrScalerAwsGetRequest mrScaler        = mrScalerBuilder.build();

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