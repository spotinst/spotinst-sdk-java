package com.spotinst.sdkjava.model.repo.admin.organization;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotAdminOrganizationRepo;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.api.admin.organization.*;
import com.spotinst.sdkjava.model.bl.admin.organization.*;
import com.spotinst.sdkjava.model.converters.admin.organization.AdminOrganizationConverter;
import com.spotinst.sdkjava.model.service.admin.organization.SpotAdminOrganizationService;

import java.util.List;
import java.util.stream.Collectors;

public class SpotAdminOrganizationRepo implements ISpotAdminOrganizationRepo {

    @Override
    public RepoGenericResponse<User> createUser(User userRequest,Boolean generateToken, String authToken ) {
        RepoGenericResponse<User> retVal;

        try {

            ApiUser apiUserRequest = AdminOrganizationConverter.toDal(userRequest);

            ApiUser apiResponse =
                    SpotAdminOrganizationService.createUser(apiUserRequest, generateToken, authToken );
            User userResponse = AdminOrganizationConverter.toBl(apiResponse);

            retVal = new RepoGenericResponse<>(userResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<UserDetails> getUserDetails(String userId,String authToken ) {
        RepoGenericResponse<UserDetails> retVal;

        try {

            ApiUserDetails apiResponse =
                    SpotAdminOrganizationService.getUserDetails(userId, authToken );
            UserDetails userResponse = AdminOrganizationConverter.toBl(apiResponse);

            retVal = new RepoGenericResponse<>(userResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<ProgrammaticUserResponse> createProgrammaticUser(ProgrammaticUser createRequest, String authToken) {
        RepoGenericResponse<ProgrammaticUserResponse> retVal;

        try {

            ApiProgrammaticUser apiCreateRequest = AdminOrganizationConverter.toDal(createRequest);

            ApiProgrammaticUserResponse apiResponse =
                    SpotAdminOrganizationService.createProgrammaticUser(apiCreateRequest, authToken );
            ProgrammaticUserResponse userResponse = AdminOrganizationConverter.toBl(apiResponse);

            retVal = new RepoGenericResponse<>(userResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<OrganizationUsers>> getOrganizationUsers(String authToken) {
        RepoGenericResponse<List<OrganizationUsers>> retVal;

        try {

            List<ApiOrganizationUsers> apiResponse =
                    SpotAdminOrganizationService.getOrganizationUsers(authToken );
            List<OrganizationUsers> getResponse =
                    apiResponse.stream().map(AdminOrganizationConverter::toBl).collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(getResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> updateGroupsOfUser(String userId, List<String> groupIds, String authToken ) {
        RepoGenericResponse<Boolean> retVal;

        try {

            Boolean updateResponse =
                    SpotAdminOrganizationService.updateGroupsOfUser(userId, groupIds, authToken );

            retVal = new RepoGenericResponse<>(updateResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> updateUserDirectPolicies(String userId, UpdatePoliciesRequest updateRequest, String authToken) {
        RepoGenericResponse<Boolean> retVal;

        try {

            ApiUpdatePoliciesRequest apiUpdateRequest = AdminOrganizationConverter.toDal(updateRequest);
            Boolean updateResponse =
                    SpotAdminOrganizationService.updateUserDirectPolicies(userId, apiUpdateRequest, authToken );

            retVal = new RepoGenericResponse<>(updateResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Policy> createPolicy(Policy createRequest, String authToken) {
        RepoGenericResponse<Policy> retVal;

        try {

            ApiPolicy apiCreateRequest = AdminOrganizationConverter.toDal(createRequest);

            ApiPolicy apiResponse =
                    SpotAdminOrganizationService.createPolicy(apiCreateRequest, authToken );
            Policy createResponse = AdminOrganizationConverter.toBl(apiResponse);

            retVal = new RepoGenericResponse<>(createResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> updatePolicy(String policyId, Policy createRequest,String authToken ) {
        RepoGenericResponse<Boolean> retVal;

        try {

            ApiPolicy apiCreateRequest = AdminOrganizationConverter.toDal(createRequest);

            Boolean updateStatus=
                    SpotAdminOrganizationService.updatePolicy(policyId,apiCreateRequest, authToken );

            retVal = new RepoGenericResponse<>(updateStatus);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<Policy>> getAllPolicies(String authToken ) {
        RepoGenericResponse<List<Policy>> retVal;

        try {
            List<ApiPolicy> apiResponse =
                    SpotAdminOrganizationService.getAllPolicies( authToken );
            List<Policy> getResponse =
                    apiResponse.stream().map(AdminOrganizationConverter::toBl).collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(getResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> deletePolicy(String policyId, String authToken ) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean updateStatus=
                    SpotAdminOrganizationService.deletePolicy(policyId, authToken );

            retVal = new RepoGenericResponse<>(updateStatus);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<UserGroup> createUserGroup(UserGroup createRequest,String authToken ) {
        RepoGenericResponse<UserGroup> retVal;

        try {

            ApiUserGroup apiCreateRequest = AdminOrganizationConverter.toDal(createRequest);

            ApiUserGroup apiResponse =
                    SpotAdminOrganizationService.createUserGroup(apiCreateRequest, authToken );
            UserGroup createResponse = AdminOrganizationConverter.toBl(apiResponse);

            retVal = new RepoGenericResponse<>(createResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> updateUserGroupMappedPolicies(String groupId, UpdatePoliciesRequest updateRequest, String authToken) {
        RepoGenericResponse<Boolean> retVal;

        try {

            ApiUpdatePoliciesRequest apiUpdateRequest = AdminOrganizationConverter.toDal(updateRequest);

            Boolean status =
                    SpotAdminOrganizationService.updateUserGroupMappedPolicies(groupId, apiUpdateRequest, authToken );

            retVal = new RepoGenericResponse<>(status);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> updateUserGroupMappedUsers(String groupId, List<String> userIds, String authToken ) {
        RepoGenericResponse<Boolean> retVal;

        try {

            Boolean status =
                    SpotAdminOrganizationService.updateUserGroupMappedUsers(groupId, userIds, authToken );

            retVal = new RepoGenericResponse<>(status);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> updateUserGroupDetails(String groupId, String name, String description, String authToken ) {
        RepoGenericResponse<Boolean> retVal;

        try {

            Boolean status =
                    SpotAdminOrganizationService.updateUserGroupDetails(groupId, name, description, authToken );

            retVal = new RepoGenericResponse<>(status);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> deleteUserGroup(String groupId, String authToken ) {
        RepoGenericResponse<Boolean> retVal;

        try {

            Boolean status =
                    SpotAdminOrganizationService.deleteUserGroup(groupId, authToken );

            retVal = new RepoGenericResponse<>(status);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> deleteUser(String userId, String authToken ) {
        RepoGenericResponse<Boolean> retVal;

        try {

            Boolean status =
                    SpotAdminOrganizationService.deleteUser(userId, authToken );

            retVal = new RepoGenericResponse<>(status);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<UserGroupDetails> getUserGroup(String groupId,String authToken ) {
        RepoGenericResponse<UserGroupDetails> retVal;

        try {

            ApiUserGroupDetails apiResponse =
                    SpotAdminOrganizationService.getUserGroup(groupId, authToken );
            UserGroupDetails getResponse = AdminOrganizationConverter.toBl(apiResponse);

            retVal = new RepoGenericResponse<>(getResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<OrganizationUserGroups>> getOrganizationUserGroups(String authToken) {
        RepoGenericResponse<List<OrganizationUserGroups>> retVal;

        try {

            List<ApiOrganizationUserGroups> apiResponse =
                    SpotAdminOrganizationService.getOrganizationUserGroups(authToken );
            List<OrganizationUserGroups> getResponse = apiResponse.stream().map(AdminOrganizationConverter::toBl).collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(getResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }
}
