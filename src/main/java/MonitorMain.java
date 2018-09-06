import component.ChildrenListener;
import config.ZookeeperClient;
import handlerThread.Monitor;
import org.apache.zookeeper.ZooKeeper;

/**
 * Created by zhuocongbin
 * date 2018/8/30
 */
public class MonitorMain {
    private static final String PATH = "/ztest";
    public static void main(String[] args) throws InterruptedException {
        ZooKeeper zooKeeper = ZookeeperClient.getZookeeper();

        ChildrenListener watcher = new ChildrenListener(zooKeeper, PATH);
        Thread thread = new Thread(new Monitor(zooKeeper, PATH, watcher));
        thread.start();
    }
}
