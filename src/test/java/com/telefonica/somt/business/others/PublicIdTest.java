package com.telefonica.somt.business.others;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class PublicIdTest {

    @Autowired
    private PublicId		     publicId;
    @Test
    void test() {
	String  publicIdRequest = "14318987,VOICE;169558,BB";
	publicId.getPublicId(publicIdRequest);
    }

}
