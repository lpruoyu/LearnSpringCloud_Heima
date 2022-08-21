package cn.itcast.mq.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAMQPTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendSimpleQueue() {
        String queueName = "simple.queue";
        String message = "Hello, SpringAMQP! I am LP!";
        rabbitTemplate.convertAndSend(queueName, message);
    }

    @Test
    public void testSendWorkQueue() throws Exception {
        String queueName = "simple.queue";
        String message = "Hello, I am ";
        for (int i = 1; i <= 50; i++) {
            rabbitTemplate.convertAndSend(queueName, message + i);
            // 1秒钟等于1000毫秒
            // 模拟1秒发送50条消息
            TimeUnit.MILLISECONDS.sleep(20);
        }
    }

    @Test
    public void testFanoutExchangeQueue() {
        String exchangeName = "itcast.fanout";
        String message = "Hello, I am lpruoyu!";
        rabbitTemplate.convertAndSend(exchangeName, "", message);
    }

    @Test
    public void testDirectExchangeQueue() {
        String exchangeName = "itcast.direct";

//        String message = "Hello, blue!";
//        发送消息，参数依次为：交换机名称，RoutingKey，消息
//        rabbitTemplate.convertAndSend(exchangeName, "blue", message);

//        String message = "Hello, yellow!";
//        rabbitTemplate.convertAndSend(exchangeName, "yellow", message);

        String message = "Hello, red!";
        rabbitTemplate.convertAndSend(exchangeName, "red", message);
    }

    @Test
    public void testTopicExchangeQueue() {
        String exchangeName = "itcast.topic";

//        String message = "新闻：传智教育【教育行业IPO第一股】上市了！";
//        rabbitTemplate.convertAndSend(exchangeName, "china.news", message);

        String message = "天气：晴天，34摄氏度";
        rabbitTemplate.convertAndSend(exchangeName, "china.weather", message);
    }

    @Test
    public void testObjectQueue() {
        String queueName = "object.queue";
        Map<String, Object> message = new HashMap<>();
        message.put("name", "lp");
        message.put("age", 22);
        rabbitTemplate.convertAndSend(queueName, message);
    }
}
