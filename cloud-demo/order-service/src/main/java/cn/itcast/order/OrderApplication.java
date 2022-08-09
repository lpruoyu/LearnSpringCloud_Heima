package cn.itcast.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import programmer.lp.feign.clients.UserClient;

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
//@EnableFeignClients(defaultConfiguration = {DefaultFeignConfiguration.class})
@EnableFeignClients(clients = UserClient.class)
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

//    @Bean
//    public IRule iRule() {
//        return new RandomRule();
//    }

}