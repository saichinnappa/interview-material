package com.practice.leetcode.strings;

/**
 * 1108. Defanging an IP Address
 * <p>
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 * <p>
 * A defanged IP address replaces every period "." with "[.]".
 * Example 1:
 * <p>
 * Input: address = "1.1.1.1"
 * Output: "1[.]1[.]1[.]1"
 */
public class DefangedIPAddress {
    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
    }

    public static String defangIPaddr(String address) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : address.toCharArray()) {
            if (ch == '.')
                stringBuilder.append("[.]");
            else
                stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}


