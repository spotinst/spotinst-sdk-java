package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerAws;
import com.spotinst.sdkjava.model.converters.mrScaler.aws.MrScalerAwsConverter;
import com.spotinst.sdkjava.model.repo.mrScaler.aws.SpotinstMrScalerAwsRepo;
import com.spotinst.sdkjava.model.service.mrScaler.aws.SpotinstMrScalerAwsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SpotinstMrScalerAwsService.class, MrScalerAwsConverter.class})
public class SpotinstMrScalerAwsRepoTest {
    public String auth_token = "";
    public String account = "";

    public SpotinstMrScalerAwsRepo spotinstMrScalerRepo;

    @Before
    public void setUp() throws Exception {
        spotinstMrScalerRepo = new SpotinstMrScalerAwsRepo();

        PowerMockito.mockStatic(SpotinstMrScalerAwsService.class);
        PowerMockito.mockStatic(MrScalerAwsConverter.class);
    }

    @Test
    public void create() {
        System.out.println("SpotinstMrScalerAwsRepo.create()");
        ApiMrScalerAws mrScaler = mock(ApiMrScalerAws.class);

        RepoGenericResponse retVal = new RepoGenericResponse<>(mrScaler);

        assertEquals(spotinstMrScalerRepo.create(mrScaler,auth_token,account).getClass(),retVal.getClass());
    }

    @Test
    public void update() {
        System.out.println("SpotinstMrScalerAwsRepo.create()");
        ApiMrScalerAws mrScaler = mock(ApiMrScalerAws.class);

        RepoGenericResponse<Boolean> retVal = new RepoGenericResponse<>(true);

        assertEquals(spotinstMrScalerRepo.update("sims-1234567",mrScaler,auth_token,account).getClass(),retVal.getClass());
    }

    @Test
    public void delete() {
        System.out.println("SpotinstMrScalerAwsRepo.create()");
        ApiMrScalerAws mrScaler = mock(ApiMrScalerAws.class);

        RepoGenericResponse<Boolean> retVal = new RepoGenericResponse<>(true);

        assertEquals(spotinstMrScalerRepo.delete("sims-1234567",auth_token,account).getClass(),retVal.getClass());
    }

    @Test
    public void get() {
        System.out.println("SpotinstMrScalerAwsRepo.create()");
        ApiMrScalerAws mrScaler = mock(ApiMrScalerAws.class);

        RepoGenericResponse retVal = new RepoGenericResponse<>(mrScaler);

        assertEquals(spotinstMrScalerRepo.get("sims-123456",auth_token,account).getClass(),retVal.getClass());

    }

    @Test
    public void getAll() {
        System.out.println("SpotinstMrScalerAwsRepo.create()");
        ApiMrScalerAws mrScaler = mock(ApiMrScalerAws.class);

        RepoGenericResponse retVal = new RepoGenericResponse<>(mrScaler);

        assertEquals(spotinstMrScalerRepo.getAll(null, auth_token,account).getClass(),retVal.getClass());

    }
}