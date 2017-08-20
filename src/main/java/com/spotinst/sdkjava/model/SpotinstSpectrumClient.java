package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SpotinstSpectrumClient {

  private static final Logger LOGGER = LoggerFactory.getLogger(SpotinstSpectrumClient.class);

  //region Members
  private String authToken;
  private ISpotinstSpectrumRepo spotinstSpectrumRepo;

  public SpotinstSpectrumClient(String authToken) {
    this.authToken = authToken;
    this.spotinstSpectrumRepo = SpotinstRepoManager.getInstance().getSpotinstSpectrumRepo();
  }

  public void publishMetricData(SpectrumMetricDataRequest spectrumMetricDataRequest) {
    RepoGenericResponse<SpectrumMetricDataRequest> creationResponse = spotinstSpectrumRepo.create(spectrumMetricDataRequest, authToken);
    if (!creationResponse.isRequestSucceed()) {
      List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
      HttpError httpException = httpExceptions.get(0);
      LOGGER.error(String.format("Error encountered while attempting to publish metric data. Code: %s. Message: %s.", httpException.getCode(), httpException.getMessage()));
      throw new SpotinstHttpException(httpException.getMessage());
    }
  }

}
