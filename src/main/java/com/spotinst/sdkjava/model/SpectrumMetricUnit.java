package com.spotinst.sdkjava.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum SpectrumMetricUnit {

    SECONDS("seconds"),
    MICROSECONDS("microseconds"),
    MILLISECONDS("milliseconds"),
    BYTES("bytes"),
    KILOBYTES("kilobytes"),
    MEGABYTES("megabytes"),
    GIGABYTES("gigabytes"),
    TERABYTES("terabytes"),
    BITS("bits"),
    KILOBITS("kilobits"),
    MEGABITS("megabits"),
    GIGABITS("gigabits"),
    TERABITS("terabits"),
    PERCENT("percent"),
    COUNT("count"),
    BYTES_PER_SECOND("bytes/second"),
    KILOBYTES_PER_SECOND("kilobytes/second"),
    MEGABYTES_PER_SECOND("megabytes/second"),
    GIGABYTES_PER_SECOND("gigabytes/second"),
    TERABYTES_PER_SECOND("terabytes/second"),
    BITS_PER_SECOND("bits/second"),
    KILOBITS_PER_SECOND("kilobits/second"),
    MEGABITS_PER_SECOND("megabits/second"),
    GIGABITS_PER_SECOND("gigabits/second"),
    TERABITS_PER_SECOND("terabits/second"),
    COUNT_PER_SECOND("count/second"),
    NONE("none");

  private static final Logger LOGGER = LoggerFactory.getLogger(SpectrumMetricUnit.class);
  private final String name;

  SpectrumMetricUnit(String name) {
    this.name = name;
  }

  public static SpectrumMetricUnit fromName(String name) {
    SpectrumMetricUnit retVal = null;
    for (SpectrumMetricUnit spectrumMetricUnit : SpectrumMetricUnit.values()) {
      if (name.equals(spectrumMetricUnit.name)) {
        retVal = spectrumMetricUnit;
        break;
      }
    }

    if (retVal == null) {
      LOGGER.error("Tried to create spectrum metric unit enum for: " + name + ", but we don't support such type ");
    }
    return retVal;
  }

  public String getName() {
    return this.name;
  }
}
