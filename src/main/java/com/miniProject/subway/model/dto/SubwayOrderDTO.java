package com.miniProject.subway.model.dto;

public class SubwayOrderDTO {

        private int orderCode;
        private  String memberId;
        private int totalPrice;

        public SubwayOrderDTO() {
        }

        public SubwayOrderDTO(int orderCode, String memberId, int totalPrice) {
                this.orderCode = orderCode;
                this.memberId = memberId;
                this.totalPrice = totalPrice;
        }

        public int getOrderCode() {
                return orderCode;
        }

        public void setOrderCode(int orderCode) {
                this.orderCode = orderCode;
        }

        public String getMemberId() {
                return memberId;
        }

        public void setMemberId(String memberId) {
                this.memberId = memberId;
        }

        public int getTotalPrice() {
                return totalPrice;
        }

        public void setTotalPrice(int totalPrice) {
                this.totalPrice = totalPrice;
        }

        @Override
        public String toString() {
                return "SubwayOrderDTO{" +
                        "orderCode=" + orderCode +
                        ", memberId='" + memberId + '\'' +
                        ", totalPrice=" + totalPrice +
                        '}';
        }
}
