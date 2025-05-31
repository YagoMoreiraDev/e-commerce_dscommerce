package com.cloud.yagodev.ecommerce_dscommerce.domain.enums;

public enum OrderStatus {
    //aguardando pagamento
    WAITING_PAYMENT,
    //pago
    PAID,
    //enviado
    SHIPPED,
    //entregue
    DELIVERED,
    //cancelado
    CANCELED
}
