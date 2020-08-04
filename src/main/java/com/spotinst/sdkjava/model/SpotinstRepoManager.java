package com.spotinst.sdkjava.model;

/**
 * Created by talzur on 12/01/2017.
 */
class SpotinstRepoManager {

    private static SpotinstRepoManager                         instance = new SpotinstRepoManager();
    //endregion
    //region Members
    private        ISpotinstElastigroupRepo                    spotinstElastigroupRepo;
    private        ISpotinstElastigroupActiveInstanceRepo      spotinstElastigroupActiveInstanceRepo;
    private        ISpotinstSubscriptionRepo                   spotinstSubscriptionRepo;
    private        ISpotinstSpectrumRepo                       spotinstSpectrumRepo;
    private        ISpotinstMrScalerAwsRepo                    spotinstMrScalerAwsRepo;
    private        ISpotinstElastigroupInstanceHealthinessRepo spotinstInstanceHealthinessRepo;
    private        ISpotinstOceanClusterRepo                   spotinstOceanClusterRepo;

    //region Constructor
    private SpotinstRepoManager() {
        this.spotinstElastigroupRepo = new SpotinstElastigroupRepo();
        this.spotinstElastigroupActiveInstanceRepo = new SpotinstElastigroupActiveInstanceRepo();
        this.spotinstSubscriptionRepo = new SpotinstSubscriptionRepo();
        this.spotinstSpectrumRepo = new SpotinstSpectrumRepo();
        this.spotinstMrScalerAwsRepo = new SpotinstMrScalerAwsRepo();
        this.spotinstInstanceHealthinessRepo = new SpotinstElastigroupInstanceHealthinessRepo();
        this.spotinstOceanClusterRepo = new SpotinstOceanClusterRepo();
    }
    //endregion

    //region Singleton
    public static SpotinstRepoManager getInstance() {
        return instance;
    }
    //endregion

    //region Getter and Setter methods

    public ISpotinstElastigroupRepo getSpotinstElastigroupRepo() {
        return spotinstElastigroupRepo;
    }

    public void setSpotinstElastigroupRepo(ISpotinstElastigroupRepo spotinstElastigroupRepo) {
        this.spotinstElastigroupRepo = spotinstElastigroupRepo;
    }

    public ISpotinstElastigroupActiveInstanceRepo getSpotinstElastigroupActiveInstanceRepo() {
        return spotinstElastigroupActiveInstanceRepo;
    }

    public void setSpotinstElastigroupActiveInstanceRepo(ISpotinstElastigroupActiveInstanceRepo spotinstElastigroupActiveInstanceRepo) {
        this.spotinstElastigroupActiveInstanceRepo = spotinstElastigroupActiveInstanceRepo;
    }

    public ISpotinstSubscriptionRepo getSpotinstSubscriptionRepo() {
        return spotinstSubscriptionRepo;
    }

    public void setSpotinstSubscriptionRepo(ISpotinstSubscriptionRepo spotinstSubscriptionRepo) {
        this.spotinstSubscriptionRepo = spotinstSubscriptionRepo;
    }

    public ISpotinstSpectrumRepo getSpotinstSpectrumRepo() {
        return this.spotinstSpectrumRepo;
    }

    public void setSpotinstSpectrumRepo(ISpotinstSpectrumRepo spotinstSpectrumRepo) {
        this.spotinstSpectrumRepo = spotinstSpectrumRepo;
    }

    public ISpotinstMrScalerAwsRepo getSpotinstMrScalerAwsRepo(){ return  spotinstMrScalerAwsRepo; }

    public void setSpotinstMrScalerAwsRepo(ISpotinstMrScalerAwsRepo spotinstMrScalerAwsRepo){
        this.spotinstMrScalerAwsRepo = spotinstMrScalerAwsRepo;
    }

    public ISpotinstElastigroupInstanceHealthinessRepo getSpotinstInstanceHealthinessRepo() {
        return spotinstInstanceHealthinessRepo;
    }

    public void setSpotinstInstanceHealthinessRepo(
            ISpotinstElastigroupInstanceHealthinessRepo spotinstInstanceHealthinessRepo) {
        this.spotinstInstanceHealthinessRepo = spotinstInstanceHealthinessRepo;
    }

    public ISpotinstOceanClusterRepo getSpotinstOceanClusterRepo() {
        return spotinstOceanClusterRepo;
    }

    public void setSpotinstOceanClusterRepo(ISpotinstOceanClusterRepo spotinstOceanClusterRepo) {
        this.spotinstOceanClusterRepo = spotinstOceanClusterRepo;
    }
    //endregion

}
