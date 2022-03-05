package com.w1nd.rpc.codec;

import junit.framework.TestCase;

public class JSONEncoderTest extends TestCase {

    public void testEncode() {
        Encoder encoder = new JSONEncoder();

        TestBean bean = new TestBean();
        bean.setName("w1nd");
        bean.setAge(18);

        byte[] bytes = encoder.encode(bean);

        assertNotNull(bytes);
    }
}