package com.spotinst.sdkjava.model.bl.gcp;

public class OceanGKEShieldedInstanceConfig {

    private boolean enableSecureBoot;
    private boolean enableIntegrityMonitoring;

    public boolean getEnableSecureBoot() {
        return enableSecureBoot;
    }

    public void setEnableSecureBoot(boolean enableSecureBoot) {
        this.enableSecureBoot = enableSecureBoot;
    }

    public boolean getEnableIntegrityMonitoring() {
        return enableIntegrityMonitoring;
    }

    public void setEnableIntegrityMonitoring(boolean enableIntegrityMonitoring) {
        this.enableIntegrityMonitoring = enableIntegrityMonitoring;
    }


}
