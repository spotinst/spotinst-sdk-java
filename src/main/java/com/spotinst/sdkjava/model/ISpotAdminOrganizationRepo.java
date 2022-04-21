package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.admin.organization.*;

import java.util.List;

public interface ISpotAdminOrganizationRepo extends IRepository<Users, Void, String> {
    RepoGenericResponse<User> createUser(User userRequest, Boolean shouldGenerateToken, String authToken);

    RepoGenericResponse<List<Users>> getUsers(String authToken);

    RepoGenericResponse<UserDetails> getUserDetails(String userId, String authToken);

    RepoGenericResponse<Boolean> updateUserGroupMappingOfUser(String userId, List<String> userGroupIds, String authToken);

    RepoGenericResponse<Boolean> deleteUser(String userId, String authToken);

    RepoGenericResponse<Boolean> updatePolicyMappingOfUser(String userId, UpdatePoliciesRequest updateRequest,
                                                          String authToken);

    RepoGenericResponse<UserGroup> createUserGroup(UserGroup createRequest, String authToken);

    RepoGenericResponse<List<UserGroups>> getUserGroups(String authToken);

    RepoGenericResponse<UserGroupDetails> getUserGroupDetails(String groupId, String authToken);

    RepoGenericResponse<Boolean> updateUserGroupDetails(String groupId, String name, String description,
                                                        String authToken);

    RepoGenericResponse<Boolean> deleteUserGroup(String groupId, String authToken);

    RepoGenericResponse<Boolean> updateUserMappingOfUserGroup(String groupId, List<String> userIds, String authToken);

    RepoGenericResponse<Boolean> updatePolicyMappingOfUserGroup(String groupId,
                                                               UpdatePoliciesRequest apiUpdateRequest,
                                                               String authToken);

    RepoGenericResponse<List<GetAccountUserMapping>> getAccountUserMapping(String userEmail, String authToken);

    RepoGenericResponse<ProgrammaticUserResponse> createProgrammaticUser(ProgrammaticUser createRequest, String authToken) ;

    RepoGenericResponse<CreateOrganizationResponse> createOrganization(CreateOrganization createRequest, String authToken);

    RepoGenericResponse<Boolean> deleteOrganization(Integer organizationId, String authToken);
}