package com.w1nd.rpc.client;

import com.w1nd.rpc.Peer;
import com.w1nd.rpc.codec.Decoder;
import com.w1nd.rpc.codec.Encoder;
import com.w1nd.rpc.codec.JSONDecoder;
import com.w1nd.rpc.codec.JSONEncoder;
import com.w1nd.rpc.transport.HTTPTransportClient;
import com.w1nd.rpc.transport.TransportClient;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClass = HTTPTransportClient.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private Class<? extends TransportSelector> selectorClass = RandomTransportSelector.class;
    private int connectCount = 1;
    private List<Peer> servers = Arrays.asList(
            new Peer("127.0.0.1", 3000)
    );
}
