package com.mango.parrot.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAssociationDto {

    @NotNull
    private String userId;
    private Map<String, String> associationByKey;
}
