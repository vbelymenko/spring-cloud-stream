package com.belymenko.employee.producer;


import com.belymenko.employee.model.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

@Slf4j
@RequiredArgsConstructor
@EnableBinding(Source.class)
public class EmployeeProducer {

    private final Source sourceChannel;

    public void produce(Employee employee) {
        sourceChannel.output().send(MessageBuilder.withPayload(employee).build());
        log.info(String.format("Send => %s", employee));
    }
}
