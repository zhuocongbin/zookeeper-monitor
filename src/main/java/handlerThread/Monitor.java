package handlerThread;

import component.ChildrenListener;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhuocongbin
 * date 2018/8/30
 */
public class Monitor implements Runnable {
    private ZooKeeper zk;
    private String path;
    private ChildrenListener watcher;

    public Monitor(ZooKeeper zk, String path, ChildrenListener watcher) {
        this.zk = zk;
        this.path = path;
        this.watcher = watcher;
    }

    public void run() {
        try {
            TimeUnit.SECONDS.sleep(10);
            List<String> children = zk.getChildren(path, watcher);
            System.err.println(children);
            while (true){

            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
