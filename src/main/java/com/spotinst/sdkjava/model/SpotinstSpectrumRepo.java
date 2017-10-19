package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;

class SpotinstSpectrumRepo implements ISpotinstSpectrumRepo {

  @Override
  public RepoGenericResponse<SpectrumMetricDataRequest> create(SpectrumMetricDataRequest metricDataRequest, String authToken) {
    RepoGenericResponse<SpectrumMetricDataRequest> retVal;
    try {
      SpectrumMetricDataRequest publishMetricData = SpotinstSpectrumService.publishMetricData(metricDataRequest, authToken);
      retVal = new RepoGenericResponse<>(publishMetricData);
    } catch (SpotinstHttpException ex) {
      retVal = ExceptionHelper.handleHttpException(ex);
    }

    return retVal;
  }

}
