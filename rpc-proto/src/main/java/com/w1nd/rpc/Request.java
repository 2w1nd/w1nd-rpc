package com.w1nd.rpc;

import lombok.Data;

/**
 *  表示RPC的一个请求
 */
@Data
public class Request {
    private ServiceDesc serviceDesc;
    private Object[] parameters;
}
