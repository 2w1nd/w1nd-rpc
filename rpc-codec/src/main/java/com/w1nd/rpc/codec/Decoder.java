package com.w1nd.rpc.codec;

/**
 * 反序列化
 */
public interface Decoder {
    <T> T decoder(byte[] bytes, Class<T> clazz);
}
