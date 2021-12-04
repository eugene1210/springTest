package com.test.springTest.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AccountRequestListDTO {

    private List<AcccountRequestDTO> accountRequestListDTOS;

    @JsonCreator
    public AccountRequestListDTO(List<AcccountRequestDTO> accountRequestListDTOS) {
        this.accountRequestListDTOS = accountRequestListDTOS;
    }
}
