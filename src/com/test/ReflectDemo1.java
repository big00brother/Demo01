package com.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo1 {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<TargetObject> targetObjectClass = (Class<TargetObject>) Class.forName("com.test.TargetObject");
        TargetObject targetObject = targetObjectClass.newInstance();

        Method[] methods = targetObjectClass.getDeclaredMethods();
        for(Method method : methods) {
            System.out.println(method.getName());
        }

        Method publicMethod = targetObjectClass.getDeclaredMethod("publicMethod",String.class);
        publicMethod.invoke(targetObject, "java");

        Field field = targetObjectClass.getDeclaredField("value");
        field.setAccessible(true);
        field.set(targetObject, "python");
        System.out.println(field.get(targetObject));

        Method privateMethod = targetObjectClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);
    }
}
