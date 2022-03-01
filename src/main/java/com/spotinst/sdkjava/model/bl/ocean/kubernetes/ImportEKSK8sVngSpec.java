package com.spotinst.sdkjava.model.bl.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ImportEKSK8sVngSpec {
    @JsonIgnore
    private Set<String>                     isSet;
    private String                          name;
	private List<K8sVngLabels>			 	labels;

    private ImportEKSK8sVngSpec() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public List<K8sVngLabels> getLabels() {
        return labels;
    }
    
    public void setLabels(List<K8sVngLabels> labels) {
        isSet.add("labels");
        this.labels = labels;
    }

    public static class Builder {
        private ImportEKSK8sVngSpec launchSpecification;

        private Builder() {
            this.launchSpecification = new ImportEKSK8sVngSpec();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setName(final String name) {
            launchSpecification.setName(name);
            return this;
        }

        public Builder setLabels(final List<K8sVngLabels> labels) {
            launchSpecification.setLabels(labels);
            return this;
        }

        public ImportEKSK8sVngSpec build() {
            // Validations
            return launchSpecification;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isLabelsSet() {
        return isSet.contains("labels");
    }
}