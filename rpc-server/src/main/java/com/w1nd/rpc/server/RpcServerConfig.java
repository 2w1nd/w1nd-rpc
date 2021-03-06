package com.w1nd.rpc.server;

import com.w1nd.rpc.codec.Decoder;
import com.w1nd.rpc.codec.Encoder;
import com.w1nd.rpc.codec.JSONDecoder;
import com.w1nd.rpc.codec.JSONEncoder;
import com.w1nd.rpc.transport.HTTPTransportServer;
import com.w1nd.rpc.transport.TransportServer;
import lombok.Data;

/**
 * server配置
 */
@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HTTPTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private int port = 3000;
}
