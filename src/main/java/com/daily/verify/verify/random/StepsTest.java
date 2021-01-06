package com.daily.verify.verify.random;

/**
 * 上台阶问题
 * 步长 1-2 跳过7
 * 多少种跳法
 */
public class StepsTest {
    public static void main(String[] args) {
        int p = 31;
        for (int i = 1; i <= p; i++) {
            System.out.print(i);
            System.out.print("--------》");
            if (i % 7 == 0) {
                System.out.println("无效数据");
            } else {
                System.out.println(setp(i));
            }
        }
    }

    private static int setp(int n) {
        int n1 = n / 7;
        int n2 = n % 7;
        if (n1 > 0) {
            int b2 = fbnq(6);
            int b3 = fbnq(n2 - 1);
            int b4 = fbnq(5);
            return (int) (b3 * (Math.pow(b4, n1 - 1)) * b2);
        } else {
            return fbnq(n2);
        }
    }

    //Fn+1 = Fn + Fn-1
    private static int fbnq(int n2) {
        int f0 = 1;
        int f1 = 1;
        int f2 = 2;
        if (n2 <= 1) {
            return 1;
        } else {
            for (int i = 1; i < n2; i++) {
                f2 = f1 + f0;
                f0 = f1;
                f1 = f2;
            }
        }
        return f2;
    }
}
