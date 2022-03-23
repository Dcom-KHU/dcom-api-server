package dcom.homepage.api.domain.group.dto;

import dcom.homepage.api.domain.group.Group;
import dcom.homepage.api.domain.users.User;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

public class GroupResponseDto {

    @ApiModel("유저 목록 없는 그룹 프로필")
    @Builder
    @Getter @Setter
    @AllArgsConstructor
    public static class SimpleInfo {
        private String name;
        private String imagePath;
        private String imageName;
        private String imageUri;

        public static SimpleInfo of(Group group) {
            return SimpleInfo.builder()
                    .name(group.getName())
                    .imagePath(group.getImagePath())
                    .imageName(group.getImageName())
                    .imageUri(group.getImageUri())
                    .build();
        }
    }

    @ApiModel("유저 목록 있는 그룹 프로필")
    @Builder
    @Getter @Setter
    @AllArgsConstructor
    public static class Info {
        private String name;
        private String imagePath;
        private String imageName;
        private String imageUri;
        private Set<User> users;

        public static Info of(Group group) {
            return Info.builder()
                    .name(group.getName())
                    .imagePath(group.getImagePath())
                    .imageName(group.getImageName())
                    .imageUri(group.getImageUri())
                    .users(group.getUsers())
                    .build();
        }
    }
}
