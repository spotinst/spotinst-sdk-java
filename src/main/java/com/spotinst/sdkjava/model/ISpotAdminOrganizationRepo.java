package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.admin.organization.*;

import java.util.List;

public interface ISpotAdminOrganizationRepo extends IRepository<OrganizationUsers, Void, String> {
    RepoGenericResponse<User> createUser(User userRequest, Boolean shouldGenerateToken, String authToken);

    RepoGenericResponse<UserDetails> getUserDetails(String userId, String authToken);

    RepoGenericResponse<ProgrammaticUserResponse> createProgrammaticUser(ProgrammaticUser createRequest,
                                                                         String authToken) ;

    RepoGenericResponse<List<OrganizationUsers>> getOrganizationUsers(String authToken);

    RepoGenericResponse<Boolean> updateGroupsOfUser(String userId, List<String> groupIds, String authToken);

    RepoGenericResponse<Boolean> updateUserDirectPolicies(String userId, UpdatePoliciesRequest updateRequest,
                                                          String authToken);

    RepoGenericResponse<Policy> createPolicy(Policy createRequest, String authToken);

    RepoGenericResponse<Boolean> updatePolicy(String policyId, Policy createRequest, String authToken);

    RepoGenericResponse<List<Policy>> getAllPolicies(String authToken);

    RepoGenericResponse<Boolean> deletePolicy(String policyId, String authToken);

    RepoGenericResponse<UserGroup> createUserGroup(UserGroup createRequest, String authToken);

    RepoGenericResponse<Boolean> updateUserGroupMappedPolicies(String groupId,
                                                               UpdatePoliciesRequest apiUpdateRequest,
                                                               String authToken);

    RepoGenericResponse<Boolean> updateUserGroupMappedUsers(String groupId, List<String> userIds, String authToken);

    RepoGenericResponse<Boolean> updateUserGroupDetails(String groupId, String name, String description,
                                                        String authToken);

    RepoGenericResponse<Boolean> deleteUserGroup(String groupId, String authToken);

    RepoGenericResponse<Boolean> deleteUser(String userId, String authToken);

    RepoGenericResponse<UserGroupDetails> getUserGroup(String groupId, String authToken);

    RepoGenericResponse<List<OrganizationUserGroups>> getOrganizationUserGroups(String authToken);
}
