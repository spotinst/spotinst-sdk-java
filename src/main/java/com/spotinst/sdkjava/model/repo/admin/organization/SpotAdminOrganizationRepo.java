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
    public RepoGenericResponse<User> createUser(User userRequest, Boolean generateToken, String authToken) {
        RepoGenericResponse<User> retVal;

        try {

            ApiUser apiUserRequest = AdminOrganizationConverter.toDal(userRequest);

            ApiUser apiResponse =
                    SpotAdminOrganizationService.createUser(apiUserRequest, generateToken, authToken);
            User userResponse = AdminOrganizationConverter.toBl(apiResponse);

            retVal = new RepoGenericResponse<>(userResponse);
        } catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<Users>> getUsers(String authToken) {
        RepoGenericResponse<List<Users>> retVal;

        try {

            List<ApiUsers> apiResponse =
                    SpotAdminOrganizationService.getOrganizationUsers(authToken );
            List<Users> getResponse =
                    apiResponse.stream().map(AdminOrganizationConverter::toBl).collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(getResponse);
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
    public RepoGenericResponse<Boolean> updateUserGroupMappingOfUser(String userId, List<String> userGroupIds, String authToken) {
        RepoGenericResponse<Boolean> retVal;

        try {

            Boolean updateResponse = SpotAdminOrganizationService.updateUserGroupMappingOfUser(userId, userGroupIds, authToken );

            retVal = new RepoGenericResponse<>(updateResponse);
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
    public RepoGenericResponse<Boolean> updatePolicyMappingOfUser(String userId, UpdatePoliciesRequest updateRequest, String authToken) {
        RepoGenericResponse<Boolean> retVal;

        try {

            ApiUpdatePoliciesRequest apiUpdateRequest = AdminOrganizationConverter.toDal(updateRequest);
            Boolean updateResponse =
                    SpotAdminOrganizationService.updatePolicyMappingOfUser(userId, apiUpdateRequest, authToken );

            retVal = new RepoGenericResponse<>(updateResponse);
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
    public RepoGenericResponse<List<UserGroups>> getUserGroups(String authToken) {
        RepoGenericResponse<List<UserGroups>> retVal;

        try {

            List<ApiUserGroups> apiResponse =
                    SpotAdminOrganizationService.getUserGroups(authToken );
            List<UserGroups> getResponse = apiResponse.stream().map(AdminOrganizationConverter::toBl).collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(getResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<UserGroupDetails> getUserGroupDetails(String groupId,String authToken ) {
        RepoGenericResponse<UserGroupDetails> retVal;

        try {

            ApiUserGroupDetails apiResponse =
                    SpotAdminOrganizationService.getUserGroupDetails(groupId, authToken );
            UserGroupDetails getResponse = AdminOrganizationConverter.toBl(apiResponse);

            retVal = new RepoGenericResponse<>(getResponse);
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
    public RepoGenericResponse<Boolean> updateUserMappingOfUserGroup(String groupId, List<String> userIds, String authToken ) {
        RepoGenericResponse<Boolean> retVal;

        try {

            Boolean status =
                    SpotAdminOrganizationService.updateUserMappingOfUserGroup(groupId, userIds, authToken );

            retVal = new RepoGenericResponse<>(status);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> updatePolicyMappingOfUserGroup(String groupId, UpdatePoliciesRequest updateRequest, String authToken) {
        RepoGenericResponse<Boolean> retVal;

        try {

            ApiUpdatePoliciesRequest apiUpdateRequest = AdminOrganizationConverter.toDal(updateRequest);

            Boolean status =
                    SpotAdminOrganizationService.updatePolicyMappingOfUserGroup(groupId, apiUpdateRequest, authToken );

            retVal = new RepoGenericResponse<>(status);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<GetAccountUserMapping>> getAccountUserMapping(String userEmail, String authToken) {
        RepoGenericResponse<List<GetAccountUserMapping>> retVal;

        try {

            List<ApiGetAccountUserMapping> apiResponse =
                    SpotAdminOrganizationService.getAccountUserMapping(userEmail, authToken );
            List<GetAccountUserMapping> getResponse = apiResponse.stream().map(AdminOrganizationConverter::toBl).collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(getResponse);
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
    public RepoGenericResponse<CreateOrganizationResponse> createOrganization(CreateOrganization createRequest, String authToken) {
        RepoGenericResponse<CreateOrganizationResponse> retVal;

        try {

            ApiCreateOrganization apiCreateRequest = AdminOrganizationConverter.toDal(createRequest);

            ApiCreateOrganizationResponse apiResponse =
                    SpotAdminOrganizationService.createOrganization(apiCreateRequest, authToken);
            CreateOrganizationResponse userResponse = AdminOrganizationConverter.toBl(apiResponse);

            retVal = new RepoGenericResponse<>(userResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> deleteOrganization(String organizationId, String authToken) {
        RepoGenericResponse<Boolean> retVal;

        try {

            Boolean status =
                    SpotAdminOrganizationService.deleteOrganization(organizationId, authToken );

            retVal = new RepoGenericResponse<>(status);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Policy> createAccessPolicy(Policy createRequest, String authToken) {
        RepoGenericResponse<Policy> retVal;

        try {

            ApiPolicy apiCreateRequest = AdminOrganizationConverter.toDal(createRequest);

            ApiPolicy apiResponse =
                    SpotAdminOrganizationService.createAccessPolicy(apiCreateRequest, authToken );
            Policy createResponse = AdminOrganizationConverter.toBl(apiResponse);

            retVal = new RepoGenericResponse<>(createResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> updateAccessPolicy(String policyId, Policy createRequest,String authToken ) {
        RepoGenericResponse<Boolean> retVal;

        try {

            ApiPolicy apiCreateRequest = AdminOrganizationConverter.toDal(createRequest);

            Boolean updateStatus=
                    SpotAdminOrganizationService.updateAccessPolicy(policyId,apiCreateRequest, authToken );

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
    public RepoGenericResponse<Boolean> deleteAccessPolicy(String policyId, String authToken ) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean updateStatus=
                    SpotAdminOrganizationService.deleteAccessPolicy(policyId, authToken );

            retVal = new RepoGenericResponse<>(updateStatus);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }
}