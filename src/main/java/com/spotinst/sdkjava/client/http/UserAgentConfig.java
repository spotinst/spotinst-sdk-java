package com.spotinst.sdkjava.client.http;

/**
 * Created by yossi.elman on 04/05/2020.
 */
public class UserAgentConfig {

    //region Members
    private AgentTypeEnum agentType;
    private String        version;
    //endregion

    //region Constructor
    public UserAgentConfig(AgentTypeEnum agentType, String version) {
        this.agentType = agentType;
        this.version = version;
    }
    //endregion

    //region Getters & Setters
    public AgentTypeEnum getAgentType() {
        return agentType;
    }

    public void setAgentType(AgentTypeEnum agentType) {
        this.agentType = agentType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    //endregion

    @Override
    public String toString() {
        return "UserAgentConfig{" + "agentType=" + agentType + ", version='" + version + '\'' + '}';
    }
}
