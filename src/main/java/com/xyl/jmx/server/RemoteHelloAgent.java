package com.xyl.jmx.server;

import com.sun.jdmk.comm.HtmlAdaptorServer;
import com.xyl.jmx.mbean.Hello;

import javax.management.*;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RemoteHelloAgent {

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {


        MBeanServer server = ManagementFactory.getPlatformMBeanServer();

        //ObjectName中的取名是有一定规范的，格式为：“域名：name=MBean名称”，其中域名和MBean的名称可以任意取。这样定义后，就可以唯一标识我们定义的这个MBean的实现类了
        ObjectName helloName = new ObjectName("jmxBean:name=hello");

        //create mbean and register mbean
        server.registerMBean(new Hello(), helloName);


        //这个步骤很重要，注册一个端口，绑定url后用于客户端通过rmi方式连接JMXConnectorServer
        try {
            LocateRegistry.createRegistry(9999);

            //URL路径的结尾可以随意指定，但如果需要用Jconsole来进行连接，则必须使用jmxrmi
            JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi");

            JMXConnectorServer jcs = JMXConnectorServerFactory.newJMXConnectorServer(url, null, server);

            System.out.println("begin rmi start");

            jcs.start();
            System.out.println("rmi start");


        } catch (RemoteException e) {
            e.printStackTrace();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }


    }

}
