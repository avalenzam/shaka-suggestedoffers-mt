package com.telefonica.somt.service;

import com.telefonica.somt.dto.SuggestedOffersMtRequestDto;
import com.telefonica.somt.generated.model.ResponseType;

public interface ISuggestedoffersMt  {

    public ResponseType getSuggestedoffersMt(SuggestedOffersMtRequestDto request) throws Exception;
}
