package com.alibaba.spring.boot.rsocket.demo;

import com.alibaba.user.User;
import com.alibaba.user.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cloudevents.CloudEvent;
import io.cloudevents.CloudEventAttributes;
import io.cloudevents.core.builder.CloudEventBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/{id}")
    public Mono<User> user(@PathVariable Integer id) {
        return userService.findById(id);
    }


    @GetMapping("/fire/login")
    public Mono<String> cloudEvent() throws Exception {
        User user = new User(1, "leijuan");
        CloudEvent event = CloudEventBuilder.v1()
                .withId(UUID.randomUUID().toString())
                .withSource(URI.create("https://example.com/users"))
                .withType("com.alibaba.user.User")
                .withData("application/json", objectMapper.writeValueAsBytes(user)) //
                .build();
        return userService.processLoginEvent(event).map(CloudEventAttributes::getId);
    }
}
