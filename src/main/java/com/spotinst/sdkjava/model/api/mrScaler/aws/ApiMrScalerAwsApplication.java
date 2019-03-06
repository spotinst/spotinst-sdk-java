package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiMrScalerAwsApplication {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String name;
    private String version;

    // endregion

    //region Constructor
    public ApiMrScalerAwsApplication() {  isSet = new HashSet<>(); }
    // endregion


    // region methods
    // region name
    public String getName(){ return name; }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public Boolean isNameSet(){ return isSet.contains("name"); }
    // endregion

    // region version
    public String getVersion(){ return version; }

    public void setVersion(String version) {
        isSet.add("version");
        this.version = version;
    }

    public Boolean isVersionSet(){ return isSet.contains("version"); }
    // endregion
    // endregion

    public static class Builder {
        private ApiMrScalerAwsApplication application;

        private Builder(){ this.application = new ApiMrScalerAwsApplication(); }

        public static  Builder get(){
            return new Builder();
        }

        // region build methods
        public Builder setName(final String name){
            application.setName(name);
            return this;
        }
        public Builder setVersion(final String version){
            application.setVersion(version);
            return this;
        }

        public ApiMrScalerAwsApplication build(){
            return application;
        }
        // endregion
    }
}
