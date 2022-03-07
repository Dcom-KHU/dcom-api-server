package dcom.homepage.api.global.config;

import dcom.homepage.api.global.dto.ExceptionMessageDto;
import dcom.homepage.api.global.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler()
    public ResponseEntity<ExceptionMessageDto> handle404(NotFoundException e) {
        return new ResponseEntity<>(ExceptionMessageDto.builder().message(e.getMessage()).build(), HttpStatus.NOT_FOUND);
    }
}
