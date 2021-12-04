package com.test.springTest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AcccountRequestDTO {

    private Long id;
    @JsonProperty("name_ru")
    private String nameRu;
    @JsonProperty("name_kz")
    private String nameKz;
    @JsonProperty("state_id")
    private Long stateId;

}
