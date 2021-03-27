package com.alibaba.user;

import io.cloudevents.CloudEvent;
import reactor.core.publisher.Mono;


public interface UserService {

    Mono<User> findById(Integer id);

    Mono<CloudEvent> processLoginEvent(CloudEvent loginEvent);

}
