package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.admin.account.*;

import java.util.List;

public interface ISpotAccountAdminRepo extends IRepository<BlAccountAdmin, Void, String> {
    RepoGenericResponse<User> createUser(User userRequest, String authToken,
                                                            String account);

    RepoGenericResponse<UserDetails> getUserDetails(String userId,String authToken, String account);

    RepoGenericResponse<ProgrammaticUserResponse> createProgrammaticUser(ProgrammaticUser createRequest, String shouldGenerateToken, String authToken, String account) ;

    RepoGenericResponse<List<OrganizationUsers>> getOrganizationUsers(String authToken, String account);

    RepoGenericResponse<Boolean> updateGroupsOfUser(String userId, List<String> groupIds, String authToken, String account);

    RepoGenericResponse<Boolean> updateUserDirectPolicies(String userId, UpdateUserDirectPoliciesRequest updateRequest, String authToken, String account);

    RepoGenericResponse<Policy> createPolicy(Policy createRequest,String authToken, String account);

    RepoGenericResponse<Boolean> updatePolicy(String policyId, Policy createRequest,String authToken, String account);

    RepoGenericResponse<List<Policy>> getAllPolicies(String authToken, String account);

    RepoGenericResponse<Boolean> deletePolicy(String policyId, String authToken, String account);
}
