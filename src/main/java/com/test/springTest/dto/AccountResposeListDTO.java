package com.test.springTest.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class AccountResposeListDTO {

    private List<AccountResponsDTO> accountResponsDTOS;

    public AccountResposeListDTO(List<AccountResponsDTO> accountResponsDTOS) {
        this.accountResponsDTOS = accountResponsDTOS;
    }
}
