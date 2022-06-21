package dcom.homepage.api.domain.jokbo.dto;

import dcom.homepage.api.domain.jokbo.JokboContent;
import dcom.homepage.api.domain.users.dto.UserResponseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@Getter @Setter
@ApiModel(value = "족보 DTO")
public class JokboContentResponseDto {
    private Integer id;
    private String content;
    private Integer semester;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private UserResponseDto.SimpleProfile writer;

    public static JokboContentResponseDto of(JokboContent jokboContent) {
        return JokboContentResponseDto.builder()
                .id(jokboContent.getId())
                .content(jokboContent.getContent())
                .semester(jokboContent.getSemester())
                .createdAt(jokboContent.getCreatedAt())
                .updatedAt(jokboContent.getUpdatedAt())
                .writer(UserResponseDto.SimpleProfile.of(jokboContent.getWriter()))
                .build();
    }

    public static List<JokboContentResponseDto> of(List<JokboContent> contents) {
        return contents.stream()
                .map(JokboContentResponseDto::of)
                .collect(Collectors.toList());
    }

    public static Set<JokboContentResponseDto> of(Set<JokboContent> contents) {
        return contents.stream()
                .map(JokboContentResponseDto::of)
                .collect(Collectors.toSet());
    }
}
