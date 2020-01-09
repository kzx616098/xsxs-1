package cn.xinzhi.xsxs.test;

import java.util.Random;

public class test1 {
    public static void main(String[] args) {
        Random r = new Random();
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            rs.append(r.nextInt(10));
        }
        String s = rs.toString();
        System.out.println(s);
    }
}
