package dcom.homepage.api.global.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Builder
@Getter @Setter
@RequiredArgsConstructor
public class ExceptionMessageDto {
    private final String message;
}
