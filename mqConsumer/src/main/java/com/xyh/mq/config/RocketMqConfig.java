package com.xyh.mq.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "rocketmq")
public class RocketMqConfig {

    /**
     * 获取消息队列配置
     */
    @Data
    public static class TopicProperties {
        private String topic;
        private String groupId;
        private String tag;
    }
}
