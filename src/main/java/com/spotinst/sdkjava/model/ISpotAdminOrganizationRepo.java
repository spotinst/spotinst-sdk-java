package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.admin.organization.*;

import java.util.List;

public interface ISpotAdminOrganizationRepo extends IRepository<OrganizationUsers, Void, String> {
    RepoGenericResponse<User> createUser(User userRequest, Boolean shouldGenerateToken, String authToken);

    RepoGenericResponse<List<OrganizationUsers>> getOrganizationUsers(String authToken);

    RepoGenericResponse<UserDetails> getUserDetails(String userId, String authToken);

    RepoGenericResponse<Boolean> updateUserGroupMapping(String userId, List<String> groupIds, String authToken);

    RepoGenericResponse<Boolean> deleteUser(String userId, String authToken);

    RepoGenericResponse<Boolean> updatePolicyMappingOfUser(String userId, UpdatePoliciesRequest updateRequest,
                                                          String authToken);

    RepoGenericResponse<UserGroup> createUserGroup(UserGroup createRequest, String authToken);

    RepoGenericResponse<List<OrganizationUserGroups>> getOrganizationUserGroups(String authToken);

    RepoGenericResponse<UserGroupDetails> getUserGroupDetails(String groupId, String authToken);

    RepoGenericResponse<Boolean> updateUserGroupDetails(String groupId, String name, String description,
                                                        String authToken);

    RepoGenericResponse<Boolean> deleteUserGroup(String groupId, String authToken);

    RepoGenericResponse<Boolean> userGroupUpdateUserMapping(String groupId, List<String> userIds, String authToken);

    RepoGenericResponse<Boolean> userGroupUpdatePolicyMapping(String groupId,
                                                               UpdatePoliciesRequest apiUpdateRequest,
                                                               String authToken);

}