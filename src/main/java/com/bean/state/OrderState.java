package com.bean.state;

public enum OrderState {
    unPay(0, "未支付"), pay(1, "已支付"), send(2, "发货"), receive(3, "已收");
    private Integer num;
    private String  msg;

    OrderState(Integer num, String msg) {
        this.msg = msg;
        this.num = num;
    }

    public Integer getNum() {
        return this.num;
    }

    public String getMsg() {
        return this.msg;
    }

    public static OrderState getStatus(int num) {
        if (num == 0) {
            return OrderState.unPay;
        }
        if (num == 1) {
            return OrderState.pay;
        }
        if (num == 2) {
            return OrderState.send;
        }
        if (num == 3) {
            return OrderState.receive;
        }
         return null;
    }
}

