package dcom.homepage.api.domain.group.service;

import dcom.homepage.api.domain.group.Group;
import dcom.homepage.api.domain.group.dto.GroupResponseDto;
import dcom.homepage.api.domain.group.repository.GroupRepository;
import dcom.homepage.api.domain.users.User;
import dcom.homepage.api.domain.users.dto.UserResponseDto;
import dcom.homepage.api.domain.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    @Override
    public List<GroupResponseDto.SimpleInfo> getGroupList() {
        return groupRepository.findAll().stream()
                .map(GroupResponseDto.SimpleInfo::of).collect(Collectors.toList());
    }

    @Override
    public List<User> getUserList(Group group) {
        return new ArrayList<>(group.getUsers());
    }

    @Override
    public GroupResponseDto.Info getGroupByName(String name) {
        Group group = groupRepository.getGroupByName(name).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "그룹을 찾지 못했습니다.")
        );
        return GroupResponseDto.Info.of(group);
    }
}
