package com.w1nd.rpc.codec;

import junit.framework.TestCase;

public class JSONDecoderTest extends TestCase {

    public void testDecoder() {
        Encoder encoder = new JSONEncoder();

        TestBean bean = new TestBean();
        bean.setName("w1nd");
        bean.setAge(18);

        byte[] bytes = encoder.encode(bean);

        JSONDecoder decoder = new JSONDecoder();
        TestBean bean1 = decoder.decoder(bytes, TestBean.class);

        assertEquals(bean1.getName(), bean.getName());
        assertEquals(bean1.getAge(), bean.getAge());
    }
}