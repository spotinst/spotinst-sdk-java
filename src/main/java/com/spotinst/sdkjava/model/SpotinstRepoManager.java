package com.spotinst.sdkjava.model;
import com.spotinst.sdkjava.model.repo.ocean.gke.SpotOceanGKELaunchSpecRepo;
import com.spotinst.sdkjava.model.repo.aws.managedInstance.SpotAwsManagedInstanceRepo;
import com.spotinst.sdkjava.model.repo.ocean.ecs.SpotOceanEcsLaunchSpecRepo;
import com.spotinst.sdkjava.model.repo.ocean.ecs.SpotOceanEcsClusterRepo;


/**
 * Created by talzur on 12/01/2017.
 */
class SpotinstRepoManager {

    private static SpotinstRepoManager                         instance = new SpotinstRepoManager();

    //region Members
    private ISpotinstElastigroupRepo                spotinstElastigroupRepo;
    private ISpotinstElastigroupActiveInstanceRepo  spotinstElastigroupActiveInstanceRepo;
    private ISpotinstSubscriptionRepo               spotinstSubscriptionRepo;
    private ISpotinstSpectrumRepo                       spotinstSpectrumRepo;
    private ISpotinstMrScalerAwsRepo                    spotinstMrScalerAwsRepo;
    private ISpotinstElastigroupInstanceHealthinessRepo spotinstInstanceHealthinessRepo;
    private ISpotinstElastigroupInstanceStatusRepoGcp   spotinstInstanceHealthinessRepoGcp;
    private ISpotOceanK8sClusterRepo                    spotinstOceanClusterRepo;
    private ISpotinstElastigroupRepoAzure           spotinstElastigroupRepoAzure;
    private ISpotinstElastigroupDeploymentRepoAzure spotinstElastigroupDeploymentRepoAzure;
    private ISpotinstElastigroupRepoGcp             spotinstElastigroupRepoGcp;
    private ISpotinstMrScalerOperatorAwsRepo        spotinstMrScalerOperatorAwsRepo;
    private ISpotOceanAzureAksClusterRepo           spotOceanAzureAksClusterRepo;
    private ISpotinstEventsLogsRepo                 spotinstElastigroupEventLogRepo;
    private ISpotAccountAdminRepo                   spotAdminAccountRepo;
    private ISpotOceanGKELaunchSpecRepo             spotinstOceanGKELaunchSpecRepo;
    private ISpotOceanEcsClusterRepo                spotinstOceanEcsClusterRepo;
    private ISpotOceanEcsLaunchSpecRepo             spotOceanEcsLaunchSpecRepo;
    private ISpotStorageAzureVolumeRepo             spotStorageAzureVolumeRepo;
    private ISpotAwsManagedInstanceRepo             spotAwsManagedInstanceRepo;
    //endregion

    //region Constructor
    private SpotinstRepoManager() {
        this.spotinstElastigroupRepo = new SpotinstElastigroupRepo();
        this.spotinstElastigroupActiveInstanceRepo = new SpotinstElastigroupActiveInstanceRepo();
        this.spotinstSubscriptionRepo = new SpotinstSubscriptionRepo();
        this.spotinstSpectrumRepo = new SpotinstSpectrumRepo();
        this.spotinstMrScalerAwsRepo = new SpotinstMrScalerAwsRepo();
        this.spotinstInstanceHealthinessRepo = new SpotinstElastigroupInstanceHealthinessRepo();
        this.spotinstInstanceHealthinessRepoGcp = new SpotinstElastigroupInstanceStatusRepoGcp();
        this.spotinstOceanClusterRepo = new SpotOceanK8sClusterRepo();
        this.spotinstElastigroupRepoAzure = new SpotinstElastigroupRepoAzure();
        this.spotinstElastigroupRepoGcp = new SpotinstElastigroupRepoGcp();
        this.spotinstMrScalerOperatorAwsRepo = new SpotinstMrScalerAwsOperatorRepo();
        this.spotinstElastigroupDeploymentRepoAzure = new SpotinstElastigroupDeploymentRepoAzure();
        this.spotOceanAzureAksClusterRepo = new SpotOceanAzureAksClusterRepo();
        this.spotinstElastigroupEventLogRepo = new SpotinstEventsLogsRepo();
        this.spotAdminAccountRepo = new SpotAccountAdminRepo();
        this.spotinstOceanGKELaunchSpecRepo = new SpotOceanGKELaunchSpecRepo();
        this.spotinstOceanEcsClusterRepo = new SpotOceanEcsClusterRepo();
        this.spotOceanEcsLaunchSpecRepo = new SpotOceanEcsLaunchSpecRepo();
        this.spotStorageAzureVolumeRepo = new SpotStorageAzureVolumeRepo();
        this.spotAwsManagedInstanceRepo = new SpotAwsManagedInstanceRepo();
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

    public ISpotinstMrScalerOperatorAwsRepo getSpotinstMrScalerOperatorAwsRepo() {
        return spotinstMrScalerOperatorAwsRepo;
    }

    public void setSpotinstMrScalerOperatorAwsRepo(ISpotinstMrScalerOperatorAwsRepo spotinstMrScalerOperatorAwsRepo) {
        this.spotinstMrScalerOperatorAwsRepo = spotinstMrScalerOperatorAwsRepo;
    }

    public ISpotinstElastigroupInstanceHealthinessRepo getSpotinstInstanceHealthinessRepo() {
        return spotinstInstanceHealthinessRepo;
    }

    public ISpotinstElastigroupInstanceStatusRepoGcp getSpotinstInstanceHealthinessRepoGcp() {
        return spotinstInstanceHealthinessRepoGcp;
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

    public ISpotinstElastigroupRepoGcp getSpotinstElastigroupRepoGcp() {
        return spotinstElastigroupRepoGcp;
    }

    public ISpotinstElastigroupDeploymentRepoAzure getSpotinstElastigroupDeploymentRepoAzure() {
        return spotinstElastigroupDeploymentRepoAzure;
    }

    public ISpotOceanAzureAksClusterRepo getSpotOceanAzureAksClusterRepo() {
        return spotOceanAzureAksClusterRepo;
    }

    public ISpotinstEventsLogsRepo getSpotinstElastigroupEventLogRepo() {
        return spotinstElastigroupEventLogRepo;
    }

    public ISpotAccountAdminRepo getSpotAdminAccountRepo() {
        return spotAdminAccountRepo;
    }

    public void setSpotinstElastigroupEventLogRepo(ISpotinstEventsLogsRepo spotinstElastigroupEventLogRepo) {
        this.spotinstElastigroupEventLogRepo = spotinstElastigroupEventLogRepo;
    }

    public ISpotOceanEcsLaunchSpecRepo getSpotOceanEcsClusterLaunchSpecRepo() {
        return spotOceanEcsLaunchSpecRepo;
    }

    public void setSpotOceanEcsClusterLaunchSpecRepo(
            ISpotOceanEcsLaunchSpecRepo spotOceanEcsLaunchSpecRepo) {
        this.spotOceanEcsLaunchSpecRepo = spotOceanEcsLaunchSpecRepo;
    }
    public ISpotStorageAzureVolumeRepo getSpotStorageAzureVolumeRepo() {
        return spotStorageAzureVolumeRepo;
    }

    public ISpotAwsManagedInstanceRepo getSpotManagedInstanceRepo() {
        return spotAwsManagedInstanceRepo;
    }

    public void setSpotManagedInstanceRepo(
            ISpotAwsManagedInstanceRepo spotManagedInstanceRepo) {
        this.spotAwsManagedInstanceRepo= spotManagedInstanceRepo;
    }

    public ISpotOceanEcsClusterRepo getSpotinstOceanEcsClusterRepo() { return spotinstOceanEcsClusterRepo; }

    public void setSpotinstOceanEcsClusterRepo (ISpotOceanEcsClusterRepo spotinstOceanEcsClusterRepo) {
        this.spotinstOceanEcsClusterRepo = spotinstOceanEcsClusterRepo;
    }

    public ISpotOceanGKELaunchSpecRepo getSpotinstOceanGKELaunchSpecRepoGcp() {
        return spotinstOceanGKELaunchSpecRepo;
    }
    //endregion
}

