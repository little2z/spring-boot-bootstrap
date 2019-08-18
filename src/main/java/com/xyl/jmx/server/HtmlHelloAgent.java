package com.xyl.jmx.server;

import com.sun.jdmk.comm.HtmlAdaptorServer;
import com.xyl.jmx.mbean.Hello;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class HtmlHelloAgent {

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {


        MBeanServer server = ManagementFactory.getPlatformMBeanServer();

        //ObjectName中的取名是有一定规范的，格式为：“域名：name=MBean名称”，其中域名和MBean的名称可以任意取。这样定义后，就可以唯一标识我们定义的这个MBean的实现类了
        ObjectName helloName = new ObjectName("jmxBean:name=hello");

        //create mbean and register mbean
        ObjectInstance objectInstance = server.registerMBean(new Hello(), helloName);

        ObjectName adapterName = new ObjectName("HtmlHelloAgent:name=htmladapter,port=8082");

        HtmlAdaptorServer adapter = new HtmlAdaptorServer();

        server.registerMBean(adapter, adapterName);

        adapter.start();

    }

}
