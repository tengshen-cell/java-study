package com.yin.util;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/12/3 14:02
 */
public class JvmUtil {
    public static int getProcessID() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        String jvmInstanceName = runtimeMXBean.getName();
        return Integer.valueOf(jvmInstanceName.split("@")[0]).intValue();
    }
}
