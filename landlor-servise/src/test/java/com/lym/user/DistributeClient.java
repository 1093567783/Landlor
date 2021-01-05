package com.lym.user;

import org.apache.log4j.BasicConfigurator;
import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author LYM
 * @Description 测试
 * @Date 2021/1/3
 * @Version v1.0.0
 **/public class DistributeClient {

    private String connectString = "127.0.0.1:2181";
    private int sessionTimeout = 2000;
    private ZooKeeper zkClient;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        BasicConfigurator.configure();
        DistributeClient client = new DistributeClient();
        // 获取 zookeeper 集群连接
        client.getConnect();
        // 注册监听
        client.getChlidren();
        Thread.sleep(Long.MAX_VALUE);
    }

    private void getConnect() throws IOException {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                try {
                    // 具体监听业务
                    getChlidren();
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void getChlidren() throws KeeperException, InterruptedException {
        if (zkClient.exists("/servers", false) == null) {
            zkClient.create("/servers", "server".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        // 监听 /servers 节点
        List<String> children = zkClient.getChildren("/servers", true);
        // 存储服务器节点主机名称集合
        ArrayList<String> hosts = new ArrayList<>();
        for (String child : children) {
            // 获取节点内容，即主机名称
            byte[] data = zkClient.getData("/servers/" + child, false, null);
            hosts.add(new String(data));
        }
        System.out.println("在线主机：" + hosts);
    }
}
