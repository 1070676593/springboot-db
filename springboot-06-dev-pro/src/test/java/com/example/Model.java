package com.example;

/**
 * @CalssName: Model
 * @Author: zsx
 * @Date: 2020/4/17 10:11
 **/
public class Model {
    public static void main(String[] args) {
        ack:
        for (int i=0;i<30;i++){
            for (int j=0;j<30;j++){
                if(j == 3){
                    break ack;
                }
                System.out.println("j==="+j);
            }
            System.out.println("i==="+i);
        }
        System.out.println("for循环完成");
    }
}
