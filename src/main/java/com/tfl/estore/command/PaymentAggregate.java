package com.tfl.estore.command;

import com.tfl.estore.core.events.PaymentProcessedEvent;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class PaymentAggregate {

    @TargetAggregateIdentifier
    private String orderId;
    private String paymentId;

    public PaymentAggregate() {
    }

    @EventSourcingHandler
    public void on(PaymentProcessedEvent event) {
        this.orderId = event.getOrderId();
        this.paymentId = event.getPaymentId();
    }
}
