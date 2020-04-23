package com.belymenko.employee.consumer;

import com.belymenko.employee.model.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@Slf4j
@RequiredArgsConstructor
@EnableBinding(Sink.class)
public class EmployeeConsumer {

    @StreamListener(target = Sink.INPUT)
    public void consume(Message<Employee> message) {
        log.info(String.format("ThreadId: %d - %s", Thread.currentThread().getId(), message.getPayload()));
    }
}
