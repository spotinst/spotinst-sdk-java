package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstNotSupportedException;
import com.spotinst.sdkjava.model.bl.gcp.OceanGKELaunchSpec;

import java.util.List;

public interface ISpotinstOceanGKECreateLaunchSpecRepo extends IRepositoryGcp<OceanGKELaunchSpec, GroupFilter, String>  {

    default  RepoGenericResponse<List<OceanGKELaunchSpec>> getAllLaunchSpecs(String authToken, String account, String oceanId)
        {
            throw new SpotinstNotSupportedException();
        }
}
