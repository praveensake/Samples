package com.sake.core;

import java.lang.reflect.Method;

public class SimpleUnitTester {

    public int execute(Class clazz) throws Exception {

        int failedCount = 0;

        // Create a new instance of the class passed
        Object object = clazz.newInstance();
        System.out.println("Classname: "+object.getClass().getName());

        //Iterate through the methods from the class
        for(Method m : clazz.getDeclaredMethods()){

            //Filter the methods whose name starts with "test" and the return the type is boolean
            if(m.getName().startsWith("test") && m.getReturnType().equals(Boolean.TYPE)){

                //Print the method name that is being invoked
                System.out.println("Invoking: "+m.getName());
                Object result = m.invoke(object);

                //If the method returns failure, increment the failure count
                if(result.equals(Boolean.FALSE)){
                    failedCount++;
                }
            }
        }

        //Print the count of failed test counts
        System.out.println("No of failed tests: "+failedCount);

        return failedCount;
    }

    public static void main(String[] args) throws Exception {

        //Create an instance and invoke sample unit tester framework
        SimpleUnitTester simpleUnitTester= new SimpleUnitTester();
        simpleUnitTester.execute(Reflection.class);
    }

}