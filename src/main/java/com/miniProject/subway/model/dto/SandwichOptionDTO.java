package com.miniProject.subway.model.dto;

public class SandwichOptionDTO {

    private String sandwichCode;

    private String optionCode;

    private String topping;

    public SandwichOptionDTO() {
    }

    public SandwichOptionDTO(String sandwichCode, String optionCode, String topping) {
        this.sandwichCode = sandwichCode;
        this.optionCode = optionCode;
        this.topping = topping;
    }

    public String getSandwichCode() {
        return sandwichCode;
    }

    public void setSandwichCode(String sandwichCode) {
        this.sandwichCode = sandwichCode;
    }

    public String getOptionCode() {
        return optionCode;
    }

    public void setOptionCode(String optionCode) {
        this.optionCode = optionCode;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    @Override
    public String toString() {
        return "SandwichOptionDTO{" +
                "sandwichCode='" + sandwichCode + '\'' +
                ", optionCode='" + optionCode + '\'' +
                ", topping='" + topping + '\'' +
                '}';
    }
}
