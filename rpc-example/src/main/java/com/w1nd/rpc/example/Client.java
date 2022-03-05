package com.w1nd.rpc.example;

import com.w1nd.rpc.client.RpcClient;

public class Client {
    public static void main(String[] args) {
        RpcClient client = new RpcClient();
        CalcService service = client.getProxy(CalcService.class);

        int sum = service.add(1, 2);
        int minus = service.minus(10, 5);

        System.out.println(sum + "\n" + minus);
    }
}
