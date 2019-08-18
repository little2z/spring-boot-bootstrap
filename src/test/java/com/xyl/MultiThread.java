package com.xyl;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @Author: xieyinglin
 * @Date: 2019/8/4 下午7:01
 */
public class MultiThread {

    public static void main(String[] args) {
        //获取线程管理 MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        //不需要获取同步的 monitor 和 synchronized 信息，仅获取线程极其堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        //遍历打印线程id及名称
        for (ThreadInfo threadInfo : threadInfos){
            System.out.println("[ "+ threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }

    }
}
