package com.soebes.katas.nodes;

public class MultiplicationNode extends Node
{
    private Node left;

    private Node right;

    public MultiplicationNode( Node left, Node right )
    {
        super();
        this.left = left;
        this.right = right;
    }

    public double evaluate()
    {
        return this.left.evaluate() * this.right.evaluate();
    }

}
