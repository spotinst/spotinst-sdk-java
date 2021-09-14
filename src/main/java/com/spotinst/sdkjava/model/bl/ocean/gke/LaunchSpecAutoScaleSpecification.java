package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecAutoScaleSpecification {

    private List<LaunchSpecHeadroomsSpecification> headrooms;

    private Set<String> isSet;

    public LaunchSpecAutoScaleSpecification(){ isSet = new HashSet<>();
    }

    public List<LaunchSpecHeadroomsSpecification> getHeadrooms(){
        return headrooms;
    }

    public void setHeadrooms(List<LaunchSpecHeadroomsSpecification> headrooms){
        isSet.add("headrooms");
        this.headrooms = headrooms;
    }

    public static class Builder {
        private LaunchSpecAutoScaleSpecification gkeAutoScale;

        private Builder() {
            this.gkeAutoScale = new LaunchSpecAutoScaleSpecification();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setHeadrooms(final List<LaunchSpecHeadroomsSpecification> headrooms) {
            gkeAutoScale.setHeadrooms(headrooms);
            return this;
        }

        public LaunchSpecAutoScaleSpecification build() {
            return gkeAutoScale;
        }
    }


    @JsonIgnore
    public boolean isHeadroomsSet() {
        return isSet.contains("headrooms");
    }
}
