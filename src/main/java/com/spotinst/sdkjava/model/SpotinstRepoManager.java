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
    private        ISpotOceanK8sClusterRepo                    spotinstOceanClusterRepo;
    private        ISpotinstElastigroupRepoAzure               spotinstElastigroupRepoAzure;


    //region Constructor
    private SpotinstRepoManager() {
        this.spotinstElastigroupRepo = new SpotinstElastigroupRepo();
        this.spotinstElastigroupActiveInstanceRepo = new SpotinstElastigroupActiveInstanceRepo();
        this.spotinstSubscriptionRepo = new SpotinstSubscriptionRepo();
        this.spotinstSpectrumRepo = new SpotinstSpectrumRepo();
        this.spotinstMrScalerAwsRepo = new SpotinstMrScalerAwsRepo();
        this.spotinstInstanceHealthinessRepo = new SpotinstElastigroupInstanceHealthinessRepo();
        this.spotinstOceanClusterRepo = new SpotOceanK8sClusterRepo();
        this.spotinstElastigroupRepoAzure = new SpotinstElastigroupRepoAzure();
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

    public void setSpotinstElastigroupActiveInstanceRepo(
            ISpotinstElastigroupActiveInstanceRepo spotinstElastigroupActiveInstanceRepo) {
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

    public ISpotinstMrScalerAwsRepo getSpotinstMrScalerAwsRepo() {
        return spotinstMrScalerAwsRepo;
    }

    public void setSpotinstMrScalerAwsRepo(ISpotinstMrScalerAwsRepo spotinstMrScalerAwsRepo) {
        this.spotinstMrScalerAwsRepo = spotinstMrScalerAwsRepo;
    }

    public ISpotinstElastigroupInstanceHealthinessRepo getSpotinstInstanceHealthinessRepo() {
        return spotinstInstanceHealthinessRepo;
    }

    public void setSpotinstInstanceHealthinessRepo(
            ISpotinstElastigroupInstanceHealthinessRepo spotinstInstanceHealthinessRepo) {
        this.spotinstInstanceHealthinessRepo = spotinstInstanceHealthinessRepo;
    }

    public ISpotOceanK8sClusterRepo getSpotinstOceanClusterRepo() {
        return spotinstOceanClusterRepo;
    }

    public void setSpotinstOceanClusterRepo(ISpotOceanK8sClusterRepo spotinstOceanClusterRepo) {
        this.spotinstOceanClusterRepo = spotinstOceanClusterRepo;
    }

    public ISpotinstElastigroupRepoAzure getSpotinstElastigroupRepoAzure() {
        return spotinstElastigroupRepoAzure;
    }
    public void setSpotinstElastigroupRepoAzure(ISpotinstElastigroupRepoAzure spotinstElastigroupRepo) {
        this.spotinstElastigroupRepoAzure = spotinstElastigroupRepo;
    }

    //endregion

}
