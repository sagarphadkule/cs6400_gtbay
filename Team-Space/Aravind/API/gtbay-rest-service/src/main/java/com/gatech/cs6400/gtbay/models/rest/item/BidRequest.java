package com.gatech.cs6400.gtbay.models.rest.item;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

public class BidRequest {

    @NotNull
    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
