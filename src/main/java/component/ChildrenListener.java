package component;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by zhuocongbin
 * date 2018/8/30
 */
public class ChildrenListener implements Watcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChildrenListener.class);
    private ZooKeeper zk;
    private String path;
    public ChildrenListener(ZooKeeper zk, String path) {
        this.zk = zk;
        this.path = path;
    }
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged) {
            try {
                List<String> children = zk.getChildren(path, this);
                System.err.println(children);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
