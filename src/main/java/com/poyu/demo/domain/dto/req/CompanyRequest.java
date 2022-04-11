package com.poyu.demo.domain.dto.req;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CompanyRequest {
    @NotNull(message = "company name required")
    @NotBlank
    private String name;
    @NotNull(message = "company address required")
    @NotBlank
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
