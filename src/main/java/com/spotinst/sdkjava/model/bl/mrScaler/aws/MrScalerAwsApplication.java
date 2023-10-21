package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerAwsApplication {
    @JsonIgnore
    private Set<String> isSet;
    private String name;
    private String version;

    private MrScalerAwsApplication()  {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName(){ return name; }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getVersion(){ return version; }

    public void setVersion(String version) {
        isSet.add("version");
        this.version = version;
    }

    public static class Builder {
        private MrScalerAwsApplication application;

        private Builder(){ this.application = new MrScalerAwsApplication(); }

        public static  Builder get(){
            return new Builder();
        }

        public Builder setName(final String name){
            application.setName(name);
            return this;
        }
        public Builder setVersion(final String version){
            application.setVersion(version);
            return this;
        }

        public MrScalerAwsApplication build(){
            return application;
        }
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isVersionSet() {
        return isSet.contains("version");
    }

}
