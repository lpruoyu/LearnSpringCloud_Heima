package cn.itcast.mq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SpringAMQPListener {
    //    @RabbitListener(queues = "simple.queue")
//    public void receiveSimpleQueueMessage(String message) {
//        System.out.println("接收到了simple.queue的消息：【" + message + "】");
//    }
//    @RabbitListener(queues = "simple.queue")
//    public void receiveWorkQueueMessage1(String message) throws Exception {
//        System.out.println("WorkQueueMessage1接收到了消息：【" + message + "】" + LocalTime.now());
////        TimeUnit.MILLISECONDS.sleep(25); // 模拟一秒钟处理40个消息
//        TimeUnit.MILLISECONDS.sleep(20); // 模拟一秒钟处理50个消息
//    }
//
//    @RabbitListener(queues = "simple.queue")
//    public void receiveWorkQueueMessage2(String message) throws Exception {
//        System.err.println("WorkQueueMessage2-----------接收到了消息：【" + message + "】" + LocalTime.now());
////        TimeUnit.MILLISECONDS.sleep(50); // 模拟一秒钟处理20个消息
////        TimeUnit.MILLISECONDS.sleep(500); // 模拟一秒钟处理2个消息
//        TimeUnit.MILLISECONDS.sleep(100); // 模拟一秒钟处理10个消息
//    }

//    @RabbitListener(queues = "fanout.queue1")
//    public void listenFanoutQueue1(String message) {
//        System.err.println("fanoutQueue1-----------接收到了消息：【" + message + "】");
//    }
//
//    @RabbitListener(queues = "fanout.queue2")
//    public void listenFanoutQueue2(String message) {
//        System.err.println("fanoutQueue2接收到了消息：【" + message + "】");
//    }

//    @RabbitListener(
//            bindings = @QueueBinding(
//                    value = @Queue(name = "direct.queue1"),
//                    exchange = @Exchange(name = "itcast.direct", type = "direct"),
//                    key = {"blue", "red"}
//            )
//    )
//    public void listenDirectExchangeQueue1(String message) {
//        System.out.println("listenDirectExchangeQueue1：message：【" + message + "】");
//    }
//
//    @RabbitListener(
//            bindings = @QueueBinding(
//                    value = @Queue(name = "direct.queue2"),
//                    exchange = @Exchange(name = "itcast.direct", type = ExchangeTypes.DIRECT),
//                    key = {"yellow", "red"}
//            )
//    )
//    public void listenDirectExchangeQueue2(String message) {
//        System.err.println("listenDirectExchangeQueue2——>message：【" + message + "】");
//    }

//    @RabbitListener(
//            bindings = @QueueBinding(
//                    value = @Queue(name = "topic.queue1"),
//                    exchange = @Exchange(name = "itcast.topic", type = ExchangeTypes.TOPIC),
//                    key = "china.#"
//            )
//    )
//    public void listenTopicExchangeQueue1(String message) {
//        System.err.println("listenTopicExchangeQueue1——>message：【" + message + "】");
//    }
//
//
//    @RabbitListener(
//            bindings = @QueueBinding(
//                    value = @Queue(name = "topic.queue2"),
//                    exchange = @Exchange(name = "itcast.topic", type = ExchangeTypes.TOPIC),
//                    key = "#.news"
//            )
//    )
//    public void listenTopicExchangeQueue2(String message) {
//        System.out.println("listenTopicExchangeQueue2==>message：【" + message + "】");
//    }

    @RabbitListener(queues = "object.queue")
    public void listenObjectQueue(Map<String, Object> message) {
        System.out.println("listenObjectQueue==>message：【" + message + "】");
    }

}
