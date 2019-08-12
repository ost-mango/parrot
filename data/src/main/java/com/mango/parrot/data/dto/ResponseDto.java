package com.mango.parrot.data.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto<T> {

    private Boolean success;
    private T data;
    private List<ErrorDto> errors;

    public ResponseDto(T data, Boolean success) {
        this.success = success;
        this.data = data;
    }

    public static <T> ResponseDto<T> of(T data) {
        return new ResponseDto<>(true, data, null);
    }

    public static <T> ResponseDto<T> error(List<ErrorDto> errors) {
        return new ResponseDto<>(false, null, errors);
    }

}
