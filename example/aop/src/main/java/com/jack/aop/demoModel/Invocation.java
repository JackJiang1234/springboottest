package com.jack.aop.demoModel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Invocation {
    private Object[] params;
    private Method method;
    private Object target;

    public Invocation(Method method, Object target, Object[] params) {
        this.params = params;
        this.method = method;
        this.target = target;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target, params);
    }
}
