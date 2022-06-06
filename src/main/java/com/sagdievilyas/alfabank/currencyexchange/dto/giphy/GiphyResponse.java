package com.sagdievilyas.alfabank.currencyexchange.dto.giphy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GiphyResponse {
    private GifObject data;
    private Meta meta;
}
