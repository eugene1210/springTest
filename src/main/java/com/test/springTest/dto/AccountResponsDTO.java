package com.test.springTest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@AllArgsConstructor
@Getter
public class AccountResponsDTO {

    private Long id;
    @JsonProperty("name_ru")
    private String nameRu;
    @JsonProperty("name_kz")
    private String nameKz;
    @JsonProperty("state_id")
    private Long stateId;
}
