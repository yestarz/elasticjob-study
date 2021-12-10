package link.yangxin.elasticjob.study.chapter01;

import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.infra.env.IpUtils;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yangxin
 * @date 2021/12/7
 */
public class MyJob implements SimpleJob {
    protected static final Logger logger = LoggerFactory.getLogger(MyJob.class);

    public void execute(ShardingContext shardingContext) {
        switch (shardingContext.getShardingItem()) {
            case 0:
                logger.info("do something by sharding item 0");
                break;
            case 1:
                // do something by sharding item 1
                logger.info("do something by sharding item 1");
                break;
            case 2:
                // do something by sharding item 2
                logger.info("do something by sharding item 2");
                break;
            // case n: ...
            default:
                logger.info("do something by sharding item n");
                break;
        }
    }
}
