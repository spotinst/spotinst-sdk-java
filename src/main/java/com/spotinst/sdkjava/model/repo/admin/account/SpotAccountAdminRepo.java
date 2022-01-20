package com.spotinst.sdkjava.model.repo.admin.account;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotAccountAdminRepo;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.api.admin.account.*;
import com.spotinst.sdkjava.model.bl.admin.account.*;
import com.spotinst.sdkjava.model.converters.admin.account.AccountAdminConverter;
import com.spotinst.sdkjava.model.service.admin.account.SpotAccountAdminService;

import java.util.List;
import java.util.stream.Collectors;

public class SpotAccountAdminRepo implements ISpotAccountAdminRepo {

    // To Do
    @Override
    // The base 'IRepository' class getAll() method requires 3 parameters but this implementation needs only
    // 'authToken' and 'cloudAccountId', therefore, 'filter' parameter is unused.
    public RepoGenericResponse<List<BlAccountAdmin>> getAll(Void filter, String authToken, String cloudAccountId) {
        RepoGenericResponse<List<BlAccountAdmin>> retVal;

        try {
            List<ApiAccountAdmin> apiAccountsList = SpotAccountAdminService.listAccounts(cloudAccountId, authToken);
            List<BlAccountAdmin> accountsList = apiAccountsList.stream().map(AccountConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(accountsList);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }


    @Override
    // the in our case the client only gets token that's why the account identifier to delete,
    // and the account who deletes are the same one. (delete in repo gets 3 attributes)
    public RepoGenericResponse<Boolean> delete(String identifier, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean updated = SpotAccountAdminService.deleteAccount(identifier, authToken);
            retVal = new RepoGenericResponse<>(updated);

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<User> createUser(User userRequest,String authToken, String account) {
        RepoGenericResponse<User> retVal;

        try {

            ApiUser apiUserRequest = AccountAdminConverter.toDal(userRequest);

            ApiUser apiResponse =
                    SpotAccountAdminService.createUser(apiUserRequest, authToken, account);
            User userResponse = AccountAdminConverter.toBl(apiResponse);

            retVal = new RepoGenericResponse<>(userResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<UserDetails> getUserDetails(String userId,String authToken, String account) {
        RepoGenericResponse<UserDetails> retVal;

        try {

            ApiUserDetails apiResponse =
                    SpotAccountAdminService.getUserDetails(userId, authToken, account);
            UserDetails userResponse = AccountAdminConverter.toBl(apiResponse);

            retVal = new RepoGenericResponse<>(userResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<ProgrammaticUserResponse> createProgrammaticUser(ProgrammaticUser createRequest, String shouldGenerateToken, String authToken, String account) {
        RepoGenericResponse<ProgrammaticUserResponse> retVal;

        try {

            ApiProgrammaticUser apiCreateRequest = AccountAdminConverter.toDal(createRequest);

            ApiProgrammaticUserResponse apiResponse =
                    SpotAccountAdminService.createProgrammaticUser(apiCreateRequest, shouldGenerateToken,authToken, account);
            ProgrammaticUserResponse userResponse = AccountAdminConverter.toBl(apiResponse);

            retVal = new RepoGenericResponse<>(userResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<OrganizationUsers>> getOrganizationUsers(String authToken, String account) {
        RepoGenericResponse<List<OrganizationUsers>> retVal;

        try {

            List<ApiOrganizationUsers> apiResponse =
                    SpotAccountAdminService.getOrganizationUsers(authToken, account);
            List<OrganizationUsers> getResponse =
                    apiResponse.stream().map(AccountAdminConverter::toBl).collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(getResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> updateGroupsOfUser(String userId, List<String> groupIds, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {

            Boolean updateResponse =
                    SpotAccountAdminService.updateGroupsOfUser(userId, groupIds, authToken, account);

            retVal = new RepoGenericResponse<>(updateResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> updateUserDirectPolicies(String userId, UpdateUserDirectPoliciesRequest updateRequest, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {

            ApiUpdateUserDirectPoliciesRequest apiUpdateRequest = AccountAdminConverter.toDal(updateRequest);
            Boolean updateResponse =
                    SpotAccountAdminService.updateUserDirectPolicies(userId, apiUpdateRequest, authToken, account);

            retVal = new RepoGenericResponse<>(updateResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Policy> createPolicy(Policy createRequest,String authToken, String account) {
        RepoGenericResponse<Policy> retVal;

        try {

            ApiPolicy apiCreateRequest = AccountAdminConverter.toDal(createRequest);

            ApiPolicy apiResponse =
                    SpotAccountAdminService.createPolicy(apiCreateRequest, authToken, account);
            Policy createResponse = AccountAdminConverter.toBl(apiResponse);

            retVal = new RepoGenericResponse<>(createResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> updatePolicy(String policyId, Policy createRequest,String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {

            ApiPolicy apiCreateRequest = AccountAdminConverter.toDal(createRequest);

            Boolean updateStatus=
                    SpotAccountAdminService.updatePolicy(policyId,apiCreateRequest, authToken, account);

            retVal = new RepoGenericResponse<>(updateStatus);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<Policy>> getAllPolicies(String authToken, String account) {
        RepoGenericResponse<List<Policy>> retVal;

        try {
            List<ApiPolicy> apiResponse =
                    SpotAccountAdminService.getAllPolicies( authToken, account);
            List<Policy> getResponse =
                    apiResponse.stream().map(AccountAdminConverter::toBl).collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(getResponse);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> deletePolicy(String policyId, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean updateStatus=
                    SpotAccountAdminService.deletePolicy(policyId, authToken, account);

            retVal = new RepoGenericResponse<>(updateStatus);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

}
