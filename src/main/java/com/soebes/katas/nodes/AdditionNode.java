package com.soebes.katas.nodes;

public class AdditionNode
    extends OpNode
{
    private Node left;

    private Node right;

    public AdditionNode( Node left, Node right )
    {
        super();
        this.left = left;
        this.right = right;
    }

    public double evaluate()
    {
        return this.left.evaluate() + this.right.evaluate();
    }

}
