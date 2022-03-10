package com.spotinst.sdkjava.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SpotinstElastigroupService.class, ElastigroupConverter.class, ApiElastigroupScalingResponseConverter.class})
public class SpotinstElastigroupRepoTest {
    public String auth_token = "";
    public String account = "";

    public SpotinstElastigroupRepo spotinstElastigroupRepo;

    @Before
    public void setUp() throws Exception {
        spotinstElastigroupRepo = new SpotinstElastigroupRepo();

        PowerMockito.mockStatic(SpotinstElastigroupService.class);
        PowerMockito.mockStatic(ElastigroupConverter.class);
        PowerMockito.mockStatic(ApiElastigroupScalingResponseConverter.class);
    }

    @Test
    public void create() {
        System.out.println("SpotinstElastigroupRepo.create()");
        Elastigroup group = mock(Elastigroup.class);

        RepoGenericResponse retVal = new RepoGenericResponse<>(group);

        assertEquals(spotinstElastigroupRepo.create(group,auth_token,account).getClass(),retVal.getClass());
    }

    @Test
    public void delete() {
    }

    @Test
    public void detachInstances() {
    }

    @Test
    public void update() {
    }

    @Test
    public void get() {
    }

    @Test
    public void scaleUp() {
        System.out.println("SpotinstElastigroupRepo.scaleUp()");

        ElastigroupScalingRequest scalingRequest = mock(ElastigroupScalingRequest.class);

        RepoGenericResponse retVal = new RepoGenericResponse<>(scalingRequest);

        assertEquals(spotinstElastigroupRepo.scaleUp(scalingRequest, auth_token,account).getClass(), retVal.getClass());
    }

    @Test
    public void scaleDown() {
        System.out.println("SpotinstElastigroupRepo.scaleDown()");

        ElastigroupScalingRequest scalingRequest = mock(ElastigroupScalingRequest.class);

        RepoGenericResponse retVal = new RepoGenericResponse<>(scalingRequest);

        assertEquals(spotinstElastigroupRepo.scaleDown(scalingRequest, auth_token,account).getClass(), retVal.getClass());
    }
}