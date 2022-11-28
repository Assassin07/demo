package com.example.demo.infra.untils;

import java.text.MessageFormat;

public class LogUtil {
    /**
     * print current method stack
     */
    public static String getStackTrace() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if(stackTrace == null) {
            return "no stack...";
        }
        StringBuffer stackTraceSB = new StringBuffer();
        for(StackTraceElement stackTraceElement : stackTrace) {
            if(stackTraceSB.length() > 0) {
                stackTraceSB.append(" <- ");
                stackTraceSB.append(System.getProperty("line.separator"));
            }
            stackTraceSB.append(MessageFormat.format("{0}.{1}() {2}"
                    ,stackTraceElement.getClassName()
                    ,stackTraceElement.getMethodName()
                    ,stackTraceElement.getLineNumber()));
        }
        return stackTraceSB.toString();
    }
}
