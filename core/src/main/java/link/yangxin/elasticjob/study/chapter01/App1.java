package link.yangxin.elasticjob.study.chapter01;

import link.yangxin.elasticjob.study.common.Constant;
import org.apache.shardingsphere.elasticjob.api.JobConfiguration;
import org.apache.shardingsphere.elasticjob.infra.env.IpUtils;
import org.apache.shardingsphere.elasticjob.lite.api.bootstrap.impl.ScheduleJobBootstrap;
import org.apache.shardingsphere.elasticjob.reg.base.CoordinatorRegistryCenter;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperConfiguration;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperRegistryCenter;

import java.lang.reflect.Field;

/**
 * @author yangxin
 * @date 2021/12/7
 */
public class App1 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
/*        Class<IpUtils> ipUtilsClass = IpUtils.class;
        Field cachedIpAddress = ipUtilsClass.getDeclaredField("cachedIpAddress");
        cachedIpAddress.setAccessible(true);
        cachedIpAddress.set(null, "192.168.1.49");*/

        System.setProperty("elasticjob.preferred.network.ip","192.168.1.49");

        new ScheduleJobBootstrap(createRegistryCenter(), new MyJob(), createJobConfiguration()).schedule();
    }

    private static CoordinatorRegistryCenter createRegistryCenter() {
        ZookeeperConfiguration zookeeperConfiguration = new ZookeeperConfiguration(Constant.ZK_SERVER, "chapter-01");
        zookeeperConfiguration.setBaseSleepTimeMilliseconds(10000);
        zookeeperConfiguration.setMaxSleepTimeMilliseconds(10000);
        CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(zookeeperConfiguration);
        regCenter.init();
        return regCenter;
    }

    private static JobConfiguration createJobConfiguration() {
        // 创建作业配置
        // ...
        return JobConfiguration
                .newBuilder("chapter-01-my-job", 1)
                .cron("0/5 * * * * ?")
                .build();
    }
}
