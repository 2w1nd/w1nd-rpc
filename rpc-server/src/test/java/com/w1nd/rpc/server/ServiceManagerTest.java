package com.w1nd.rpc.server;

import com.w1nd.rpc.Request;
import com.w1nd.rpc.ServiceDesc;
import com.w1nd.rpc.common.utils.ReflectionUtils;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

public class ServiceManagerTest extends TestCase {

    ServiceManager sm;

    @Before
    public void init() {
        sm = new ServiceManager();

        TestInterface bean = new TestClass();
        sm.register(TestInterface.class, bean);
    }

    @Test
    public void testRegister() {
        sm = new ServiceManager();

        TestInterface bean = new TestClass();
        sm.register(TestInterface.class, bean);
    }

    @Test
    public void testLookup() {
        sm = new ServiceManager();

        TestInterface bean = new TestClass();
        sm.register(TestInterface.class, bean);

        Method method = ReflectionUtils.getPublicMethods(TestInterface.class)[0];
        ServiceDesc sdp = ServiceDesc.from(TestInterface.class, method);

        Request request = new Request();
        request.setServiceDesc(sdp);

        ServiceInstance sis = sm.lookup(request);
        assertNotNull(sis);
    }
}