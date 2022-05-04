package com.spotinst.sdkjava.model.bl.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bansi Chapla on 23/11/2021.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecExtensionsProtectedSettings {

    @JsonIgnore
    private Set<String> isSet;
    private String      script;

    private LaunchSpecExtensionsProtectedSettings() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        isSet.add("script");
        this.script = script;
    }

    public static class Builder {
        private LaunchSpecExtensionsProtectedSettings extensionsProtectedSettings;

        private Builder() {
            this.extensionsProtectedSettings = new LaunchSpecExtensionsProtectedSettings();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setScript(final String script) {
            extensionsProtectedSettings.setScript(script);
            return this;
        }

        public LaunchSpecExtensionsProtectedSettings build() {
            return extensionsProtectedSettings;
        }
    }

    @JsonIgnore
    public boolean isScriptSet() {
        return isSet.contains("script");
    }

}