package dcom.homepage.api.domain.group.service;

import dcom.homepage.api.domain.group.Group;
import dcom.homepage.api.domain.group.dto.GroupResponseDto;
import dcom.homepage.api.domain.users.User;
import dcom.homepage.api.domain.users.dto.UserResponseDto;

import java.util.List;

public interface GroupService {
    List<GroupResponseDto.SimpleInfo> getGroupList();
    List<User> getUserList(Group group);
    GroupResponseDto.Info getGroupByName(String name);
    GroupResponseDto.Info addUserToGroup(User user, Group group);
}
