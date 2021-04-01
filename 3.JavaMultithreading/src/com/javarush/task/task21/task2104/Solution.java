package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (n == this) return true;
        if (!(n instanceof Solution)) return false;

        Solution n1 = (Solution) n;
        return (n1.first==first) && (n1.last==last);
    }

    public int hashCode() {
        return first.hashCode() + last.hashCode();
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        Solution s1 = new Solution("Donald", "Duck");
        Solution s2 = new Solution("Donald", "Duck");

        System.out.println(s1.equals(s2));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
