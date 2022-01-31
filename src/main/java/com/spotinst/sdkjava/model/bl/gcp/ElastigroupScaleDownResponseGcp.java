package com.spotinst.sdkjava.model.bl.gcp;

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
    private List<ElastigroupScaleDownVictimPreemptiblesListGcp>  victimPreemptiblesList;
    private List<ElastigroupScaleDownVictimInstancesListGcp> victimInstancesList;

    public ElastigroupScaleDownResponseGcp() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ElastigroupScaleDownVictimPreemptiblesListGcp> getVictimPreemptibles() {
        return victimPreemptiblesList;
    }

    public void setVictimPreemptibles(List<ElastigroupScaleDownVictimPreemptiblesListGcp> victimPreemptiblesList) {
        isSet.add("victimPreemptiblesList");
        this.victimPreemptiblesList = victimPreemptiblesList;
    }

    public List<ElastigroupScaleDownVictimInstancesListGcp> getVictimInstancesList() {
        return victimInstancesList;
    }

    public void setVictimInstancesList(List<ElastigroupScaleDownVictimInstancesListGcp> victimInstancesList) {
        isSet.add("victimInstancesList");
        this.victimInstancesList = victimInstancesList;
    }


    public static class Builder {
        private ElastigroupScaleDownResponseGcp elastigroupScaleDownResponseGcp;

        private Builder() {
            this.elastigroupScaleDownResponseGcp = new ElastigroupScaleDownResponseGcp();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setVictimPreemptibles(final List<ElastigroupScaleDownVictimPreemptiblesListGcp> victimPreemptiblesList) {
            elastigroupScaleDownResponseGcp.setVictimPreemptibles(victimPreemptiblesList);
            return this;
        }

        public Builder setVictimInstancesList(final List<ElastigroupScaleDownVictimInstancesListGcp> victimInstancesList) {
            elastigroupScaleDownResponseGcp.setVictimInstancesList(victimInstancesList);
            return this;
        }
        public ElastigroupScaleDownResponseGcp build() {
            return elastigroupScaleDownResponseGcp;
        }

    }

    @JsonIgnore
    public boolean isVictimPreemptiblesListSet() {
        return isSet.contains("victimPreemptiblesList");
    }

    @JsonIgnore
    public boolean isVictimInstancesListSet() {
        return isSet.contains("victimInstancesList");
    }

}
