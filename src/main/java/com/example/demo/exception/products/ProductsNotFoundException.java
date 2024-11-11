package com.example.demo.exception.products;

public class ProductsNotFoundException extends RuntimeException {
    private int status;

    public ProductsNotFoundException(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return super.getMessage();
    }
}
