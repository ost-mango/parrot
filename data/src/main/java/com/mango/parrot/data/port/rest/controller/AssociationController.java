package com.mango.parrot.data.port.rest.controller;

import com.mango.parrot.data.dto.ResponseDto;
import com.mango.parrot.data.dto.AssociationDto;
import com.mango.parrot.data.service.MongoAssociationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AssociationController {

    private MongoAssociationService mongoAssociationService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<AssociationDto> createUserAssociation(@Valid @RequestBody AssociationDto associationDto) {
        return ResponseDto.of(mongoAssociationService.createUserAssociation(associationDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDto<AssociationDto> updateUserAssociation(@Valid @RequestBody AssociationDto associationDto){
        return  ResponseDto.of(mongoAssociationService.updateUserAssociation(associationDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/{userId}")
    public ResponseDto<AssociationDto> cacheUserAssociation(@PathVariable("userId") String userId) {
        return ResponseDto.of(mongoAssociationService.cacheUserAssociation(userId));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{userId}")
    public ResponseDto<Map<String, String>> getUserAssociation(@PathVariable("userId") String userId,
                                                               @RequestParam String key,
                                                               @RequestParam(required = false, defaultValue = "1") Integer count) {
        return ResponseDto.of(mongoAssociationService.getUserAssociation(userId, key, count));
    }
}
