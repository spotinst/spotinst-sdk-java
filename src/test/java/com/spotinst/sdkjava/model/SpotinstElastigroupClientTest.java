package com.spotinst.sdkjava.model;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class SpotinstElastigroupClientTest {
    public ISpotinstElastigroupRepo mockedRepo;
    public ISpotinstElastigroupActiveInstanceRepo mockedActiveRepo;
    public String auth_token = "";
    public String account = "";
    public RepoGenericResponse response;
    public  SpotinstElastigroupClient spotinstClientSpy;


    @Before
    public void startUp(){
        mockedRepo = mock(ISpotinstElastigroupRepo.class);
        mockedActiveRepo = mock(ISpotinstElastigroupActiveInstanceRepo.class);

        spotinstClientSpy = spy(new SpotinstElastigroupClient(auth_token, account));

        response = mock(RepoGenericResponse.class);
    }


    @Test
    public void createElastigroup() {
        System.out.println("SpotinstElastigroupClientTest.createElastigroup()");

        ElastigroupCreationRequest.Builder groupBuilder = ElastigroupCreationRequest.Builder.get();
        ElastigroupCreationRequest group = groupBuilder.build();

        Elastigroup elastigroupToCreate = group.getElastigroup();

        when(response.isRequestSucceed())
                .thenReturn(Boolean.TRUE);
        when(mockedRepo.create(elastigroupToCreate,auth_token,account))
                .thenReturn(response);

        when(spotinstClientSpy.getSpotinstElastigroupRepo())
                .thenReturn(mockedRepo);

        spotinstClientSpy.createElastigroup(group);
    }

    @Test
    public void updateElastigroup() {
    }

    @Test
    public void deleteElastigroup() {
    }

    @Test
    public void detachInstances() {
    }

    @Test
    public void getActiveInstances() {
    }

    @Test
    public void getElastigroup() {
    }

    @Test
    public void scaleGroupUp() {
        System.out.println("SpotinstElastigroupClientTest.scaleGroupUp()");

        ElastigroupScalingRequest.Builder requestBuilder = ElastigroupScalingRequest.Builder.get();
        ElastigroupScalingRequest request = requestBuilder.build();

        when(response.isRequestSucceed())
                .thenReturn(Boolean.TRUE);
        when(mockedRepo.scaleUp(request,auth_token,account))
                .thenReturn(response);

        when(spotinstClientSpy.getSpotinstElastigroupRepo())
                .thenReturn(mockedRepo);

        spotinstClientSpy.scaleGroupUp(request);
    }

    @Test
    public void scaleGroupDown() {
        System.out.println("SpotinstElastigroupClientTest.scaleGroupDown()");

        ElastigroupScalingRequest.Builder requestBuilder = ElastigroupScalingRequest.Builder.get();
        ElastigroupScalingRequest request = requestBuilder.build();

        when(response.isRequestSucceed())
                .thenReturn(Boolean.TRUE);
        when(mockedRepo.scaleDown(request,auth_token,account))
                .thenReturn(response);

        when(spotinstClientSpy.getSpotinstElastigroupRepo())
                .thenReturn(mockedRepo);

        spotinstClientSpy.scaleGroupDown(request);
    }
}