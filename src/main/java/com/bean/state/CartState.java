package com.bean.state;

public enum CartState {
    empty(0, "未支付"), full(1, "已支付");
    private String  msg;
    private Integer num;

    CartState(Integer num, String msg) {
        this.num = num;
        this.msg = msg;
    }
    public Integer getNum() {
        return this.num;
    }

    public String getMsg() {
        return this.msg;
    }

    public static CartState getStatus(int num) {
        if (num == 1) {
            return CartState.empty;
        } else {
            return CartState.full;
        }
    }


}
