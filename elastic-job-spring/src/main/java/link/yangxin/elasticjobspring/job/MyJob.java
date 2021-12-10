package link.yangxin.elasticjobspring.job;

import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author yangxin
 * @date 2021/12/10
 */
@Component
public class MyJob implements SimpleJob {

    protected static final Logger logger = LoggerFactory.getLogger(MyJob.class);

    @Override
    public void execute(ShardingContext shardingContext) {
        logger.info("do something by sharding item {},parameter is :{}", shardingContext.getShardingItem(), shardingContext.getJobParameter());
    }
}
