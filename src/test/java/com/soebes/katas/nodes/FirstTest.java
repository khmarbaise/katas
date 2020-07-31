package com.soebes.katas.nodes;

import org.junit.jupiter.api.Test;

class FirstTest {
    @Test
    void f() {
        ValueNode v1 = new ValueNode(1.0);
        ValueNode v2 = new ValueNode(2.0);
        ValueNode v3 = new ValueNode(3.0);

        // 1 + 2 * 3
        MultiplicationNode m = new MultiplicationNode(v2, v3);
        AdditionNode add = new AdditionNode(v1, m);

        System.out.println("1 + 2 * 3 =" + add.
            evaluate());
    }
}
