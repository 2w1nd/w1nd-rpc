package com.w1nd.rpc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 表示服务
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDesc {
    private String className;   // 类名
    private String methodName;  // 方法名
    private String returnType;  // 返回类型
    private String[] parameterTypes; // 参数类型

    public static ServiceDesc from(Class clazz, Method method) {
        ServiceDesc sdp = new ServiceDesc();
        sdp.setClassName(clazz.getName());
        sdp.setMethodName(method.getName());
        sdp.setReturnType(method.getReturnType().getName());

        Class<?>[] parameterClasses = method.getParameterTypes();
        String[] parameterTypes = new String[parameterClasses.length];
        for (int i = 0; i < parameterClasses.length; i++) {
            parameterTypes[i] = parameterClasses[i].getName();
        }
        sdp.setParameterTypes(parameterTypes);
        return sdp;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ServiceDesc that = (ServiceDesc) obj;
        return this.toString().equals(that.toString());
    }

    @Override
    public String toString() {
        return "clazz=" + className
                + ",method=" + methodName
                + ",returnType=" + returnType
                + ",parameterTypes=" + Arrays.toString(parameterTypes);
    }
}
