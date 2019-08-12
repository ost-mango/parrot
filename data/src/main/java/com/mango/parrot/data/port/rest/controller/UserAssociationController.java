package com.mango.parrot.data.port.rest.controller;

import com.mango.parrot.data.dto.ResponseDto;
import com.mango.parrot.data.dto.UserAssociationDto;
import com.mango.parrot.data.service.UserAssociationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserAssociationController {

    private UserAssociationService userAssociationService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<UserAssociationDto> createUserAssociation(@Valid @RequestBody UserAssociationDto userAssociationDto) {
        return ResponseDto.of(userAssociationService.createUserAssociation(userAssociationDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<UserAssociationDto> updateUserAssociation(@Valid @RequestBody UserAssociationDto userAssociationDto){
        return  ResponseDto.of(userAssociationService.updateUserAssociation(userAssociationDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/{userId}")
    public ResponseDto<UserAssociationDto> cacheUserAssociation(@PathVariable("userId") String userId) {
        return ResponseDto.of(userAssociationService.cacheUserAssociation(userId));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{userId}")
    public ResponseDto<List<String>> getUserAssociation(@PathVariable("userId") String userId,
                                                        @RequestParam String key,
                                                        @RequestParam(required = false, defaultValue = "1") Integer count) {
        return ResponseDto.of(userAssociationService.getUserAssociation(userId, key, count));
    }
}
