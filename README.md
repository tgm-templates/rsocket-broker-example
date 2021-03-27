Alibaba RSocket Broker Example
==============================

# Modules

* service-api: Service API
* rsocket-requester: RSocket服务消费端
* rsocket-responder: RSocket服务提供者

# How to start?

* Start the RSocket Broker: `docker-compose up -d`
* Start the rsocket-responder
* Start the rsocket-requester
* Execute curl to check service: `curl http://localhost:8181/user/1`

# References

* Alibaba RSocket Broker: https://github.com/alibaba/alibaba-rsocket-broker