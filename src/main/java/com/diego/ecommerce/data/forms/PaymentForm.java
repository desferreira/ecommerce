package com.diego.ecommerce.data.forms;


public class PaymentForm {

    /**
     * Cartão responsável pelo pagamento
     */
    public String cardNumber;

    /**
     * Valor do pagamento
     */
    public Double paymentValue;

    /**
     * Id do cliente responsável pelo pagamento
     */
    public Long clientId;

    /**
     * Id da ordem de compra
     */
    public Long orderId;

    /**
     * Tipo de pagamento
     */
    public int paymentType;

}
