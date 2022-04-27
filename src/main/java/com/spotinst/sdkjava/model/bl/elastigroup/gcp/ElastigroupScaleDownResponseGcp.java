package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElastigroupScaleDownResponseGcp {

    @JsonIgnore
    private Set<String>                                     isSet;
    private List<ElastigroupScaleDownVictimGcp>  victimPreemptibles;
    private List<ElastigroupScaleDownVictimGcp> victimInstances;

    public ElastigroupScaleDownResponseGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ElastigroupScaleDownVictimGcp> getVictimPreemptibles() {
        return victimPreemptibles;
    }

    public void setVictimPreemptibles(List<ElastigroupScaleDownVictimGcp> victimPreemptibles) {
        isSet.add("victimPreemptibles");
        this.victimPreemptibles = victimPreemptibles;
    }

    public List<ElastigroupScaleDownVictimGcp> getVictimInstances() {
        return victimInstances;
    }

    public void setVictimInstances(List<ElastigroupScaleDownVictimGcp> victimInstances) {
        isSet.add("victimInstances");
        this.victimInstances = victimInstances;
    }


    public static class Builder {
        private ElastigroupScaleDownResponseGcp elastigroupScaleDownResponseGcp;

        private Builder() {
            this.elastigroupScaleDownResponseGcp = new ElastigroupScaleDownResponseGcp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setVictimPreemptibles(final List<ElastigroupScaleDownVictimGcp> victimPreemptibles) {
            elastigroupScaleDownResponseGcp.setVictimPreemptibles(victimPreemptibles);
            return this;
        }

        public Builder setVictimInstances(final List<ElastigroupScaleDownVictimGcp> victimInstances) {
            elastigroupScaleDownResponseGcp.setVictimInstances(victimInstances);
            return this;
        }
        public ElastigroupScaleDownResponseGcp build() {
            return elastigroupScaleDownResponseGcp;
        }

    }

    @JsonIgnore
    public boolean isVictimPreemptiblesSet() {
        return isSet.contains("victimPreemptibles");
    }

    @JsonIgnore
    public boolean isVictimInstancesSet() {
        return isSet.contains("victimInstances");
    }

}
