package com.w1nd.rpc.server;

import com.w1nd.rpc.Request;
import com.w1nd.rpc.ServiceDesc;
import com.w1nd.rpc.common.utils.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;

import javax.xml.ws.Service;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 管理rpc暴露的服务
 */
@Slf4j
public class ServiceManager {
    private Map<ServiceDesc, ServiceInstance> services;

    public ServiceManager() {
        this.services = new ConcurrentHashMap<>();
    }

    /**
     *
     * @param interfaceClass 接口的Class
     * @param bean 接口实例对象
     */
    public <T> void register(Class<T> interfaceClass, T bean) {
        Method[] methods = ReflectionUtils.getPublicMethods(interfaceClass);
        for (Method method : methods) {
            ServiceInstance sis = new ServiceInstance(bean, method);
            ServiceDesc sdp = ServiceDesc.from(interfaceClass, method);

            services.put(sdp, sis);
            log.info("register service: {} {}", sdp.getClassName(), sdp.getMethodName());
        }
    }

    public ServiceInstance lookup(Request request) {
        ServiceDesc sdp = request.getServiceDesc();
        return services.get(sdp);
    }
}
