package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.ProcessNameEnum;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.ElastigroupAzure;

import java.util.List;

interface ISpotinstElastigroupRepoAzure extends IRepositoryAzure<ElastigroupAzure, GroupFilter, String> {
}
