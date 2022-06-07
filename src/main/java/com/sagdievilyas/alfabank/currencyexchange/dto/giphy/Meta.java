package com.sagdievilyas.alfabank.currencyexchange.dto.giphy;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Meta {
    private String msg;
    private int status;
    @JsonProperty("response_id")
    private String responseId;
}
