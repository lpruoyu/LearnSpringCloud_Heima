package cn.itcast.user.web;

import cn.itcast.user.pojo.User;
import cn.itcast.user.properties.PatternProperties;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
//@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PatternProperties properties;

    // 注入nacos中的配置属性
//    @Value("${pattern.dateformat}")
//    private String dateformat;

    // 编写controller，通过日期格式化器来格式化现在时间并返回
    @GetMapping("now")
    public String now() {
        return LocalDateTime.now().format(
                DateTimeFormatter.ofPattern(properties.getDateformat())
        );
    }


    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }
}
