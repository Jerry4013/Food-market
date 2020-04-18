package soen487.foodmarket.forms;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class OrderForm {

    @NotEmpty(message = "buyer Id cannot be empty")
    private Integer buyerId;

    @NotEmpty(message = "name cannot be empty")
    private String buyerName;

    @NotEmpty(message = "phone cannot be empty")
    private String buyerPhone;

    @NotEmpty(message = "address cannot be empty")
    private String buyerAddress;

    @NotEmpty(message = "cart cannot be empty")
    private String items;
}
