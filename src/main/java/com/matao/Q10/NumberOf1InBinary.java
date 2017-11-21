package com.matao.Q10;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * <p>
 * Author: matao
 * <p>
 * n & (n-1)  可以去掉n的二进制表示中的最后一个是1的位置
 */
public class NumberOf1InBinary {

    // 先判断整数二进制中最右边一位是否为1， 接着把输入的数再右移判断倒数第二位
    // 此方法若n为负数，会死循环
    public int numberOf1Bad(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                ++count;
            }
            n >>= 1;
        }
        return count;
    }

    // 先判断整数二进制中最右边一位是否为1， 接着把1左移，对倒数第二位进行判断
    public int numberOf1Good(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                ++count;
            }
            flag <<= 1;
        }
        return count;
    }

    // Best
    public int numberOf1Best(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }
}