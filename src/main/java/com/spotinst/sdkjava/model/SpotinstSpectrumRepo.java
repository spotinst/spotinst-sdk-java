package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;

class SpotinstSpectrumRepo implements ISpotinstSpectrumRepo {

  @Override
  public RepoGenericResponse<SpectrumMetricDataRequest> create(SpectrumMetricDataRequest metricDataRequest, String authToken) {
    RepoGenericResponse<SpectrumMetricDataRequest> retVal;
    try {
      Boolean result = SpotinstSpectrumService.publishMetricData(metricDataRequest, authToken);
      if (result) {
        retVal = new RepoGenericResponse<>(true);
      } else {
        retVal = new RepoGenericResponse<>(false);
      }
    } catch (SpotinstHttpException ex) {
      retVal = ExceptionHelper.handleHttpException(ex);
    }

    return retVal;
  }

}
