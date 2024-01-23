package com.miniProject.subway.model.dto;

public class OrderSandwichDTO {

    private String sandwichCode;
    private int orderCode;
    private String sandwichName;
    private String breadName;
    private int sandwichPrice;

    public OrderSandwichDTO() {
    }

    public OrderSandwichDTO(String sandwichCode, int orderCode, String sandwichName, String breadName, int sandwichPrice) {
        this.sandwichCode = sandwichCode;
        this.orderCode = orderCode;
        this.sandwichName = sandwichName;
        this.breadName = breadName;
        this.sandwichPrice = sandwichPrice;
    }

    public String getSandwichCode() {
        return sandwichCode;
    }

    public void setSandwichCode(String sandwichCode) {
        this.sandwichCode = sandwichCode;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public String getSandwichName() {
        return sandwichName;
    }

    public void setSandwichName(String sandwichName) {
        this.sandwichName = sandwichName;
    }

    public String getBreadName() {
        return breadName;
    }

    public void setBreadName(String breadName) {
        this.breadName = breadName;
    }

    public int getSandwichPrice() {
        return sandwichPrice;
    }

    public void setSandwichPrice(int sandwichPrice) {
        this.sandwichPrice = sandwichPrice;
    }

    @Override
    public String toString() {
        return "OrderSandwichDTO{" +
                "sandwichCode='" + sandwichCode + '\'' +
                ", orderCode=" + orderCode +
                ", sandwichName='" + sandwichName + '\'' +
                ", breadName='" + breadName + '\'' +
                ", sandwichPrice=" + sandwichPrice +
                '}';
    }
}
