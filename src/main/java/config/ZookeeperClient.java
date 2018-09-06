package config;

import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by zhuocongbin
 * date 2018/8/30
 */
public class ZookeeperClient {
    private static String ipPort = "172.19.3.10:2181,172.19.3.11:2181,172.19.3.12:2181";
    private static class ZookeeperBuild {
        private static ZooKeeper zk;
        static {
            try {
                zk = new ZooKeeper(ipPort, 2000, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private ZookeeperClient(){}
    public static ZooKeeper getZookeeper() {
        return ZookeeperBuild.zk;
    }
}
