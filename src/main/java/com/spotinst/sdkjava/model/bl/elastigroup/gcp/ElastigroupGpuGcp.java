package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupGpuGcp {

    @JsonIgnore
    private Set<String>     isSet;
    private Integer         count;
    private String          type;

    private ElastigroupGpuGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        isSet.add("count");
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        isSet.add("type");
        this.type = type;
    }

    public static class Builder {
        private ElastigroupGpuGcp gpu;

        private Builder() {
            this.gpu = new ElastigroupGpuGcp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setCount(final Integer count) {
            gpu.setCount(count);
            return this;
        }

        public Builder setType(final String type) {
            gpu.setType(type);
            return this;
        }
        public ElastigroupGpuGcp build() {
            return gpu;
        }
    }

    @JsonIgnore
    public boolean isCountSet() { return isSet.contains("count"); }

    @JsonIgnore
    public boolean isTypeSet() { return isSet.contains("type"); }
}
