package dcom.homepage.api.domain.jokbo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@ApiModel(value = "족보 등록 DTO")
@Getter @Setter
public class JokboContentRequestDto {

    @ApiModelProperty(value = "내용")
    @NotBlank
    private String content;

    @ApiModelProperty(value = "연도")
    @Min(value = 2000)
    private Integer year;

    @ApiModelProperty(value = "학기, 1과 2만 입력 가능")
    @Min(value = 1) @Max(value = 2)
    private Integer semester;
}
