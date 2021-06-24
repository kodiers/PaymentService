package com.tfl.estore.events;

import com.tfl.estore.core.events.PaymentProcessedEvent;
import com.tfl.estore.data.PaymentEntity;
import com.tfl.estore.data.PaymentsRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class PaymentEventsHandler {

    private final PaymentsRepository paymentsRepository;

    public PaymentEventsHandler(PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
    }

    @EventHandler
    public void on(PaymentProcessedEvent event) {
        PaymentEntity entity = new PaymentEntity();
        entity.setPaymentId(event.getPaymentId());
        entity.setOrderId(event.getOrderId());
        paymentsRepository.save(entity);
    }
}
