package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstNotSupportedException;
import com.spotinst.sdkjava.model.bl.gcp.OceanGKECreateLaunchSpecRes;

import java.util.List;

public interface ISpotinstOceanGKECreateLaunchSpecRepo extends IRepositoryGcp<OceanGKECreateLaunchSpecRes, GroupFilter, String>  {

    default  RepoGenericResponse<List<OceanGKECreateLaunchSpecRes>> getAllLaunchSpecs(String authToken, String account, String oceanId)
        {
            throw new SpotinstNotSupportedException();
        }
}
