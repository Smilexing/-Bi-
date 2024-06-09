package com.yupi.springbootinit.manager;

import com.yupi.springbootinit.common.ErrorCode;
import com.yupi.springbootinit.exception.BusinessException;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Tom Smile
 * @version 1.0
 * @description: 限流工具类-Redssion实现
 * @date 2024/6/9 14:28
 */


@Service
public class RedisLimiterManager {

    @Resource
    private RedissonClient redissonClient;

    /**
     * 限流操作-令牌桶算法
     * @param key
     */
    // key是为了区分不同限流器设置的
    public void doRateLimit(String key) {
        RRateLimiter rateLimiter = redissonClient.getRateLimiter(key);
        // 设置限流器，参数1指定限流模式（单机or集群） 参数2：单位时间段内通过的请求次数 参数3：单位时间
        // 每秒最多访问 2 次
        rateLimiter.trySetRate(RateType.OVERALL, 2, 1, RateIntervalUnit.SECONDS);
        // 获取令牌，有令牌才有资格可以排队消费
        boolean canOp = rateLimiter.tryAcquire(1);
        if (!canOp) {
            throw new BusinessException(ErrorCode.TOO_MANY_REQUEST);
        }
    }

}

