package com.company.Model;

/**
 * Created by MakeMeSm1Le- on 16.02.2017.
 */
public class Expression {

    private Block leftBlock;
    private Block rightBlock;
    private Integer cofitient;

    public Expression(Integer cofitient,Block lBlock, Block rBlock){
        this.cofitient = cofitient;
        leftBlock = lBlock;
        rightBlock = rBlock;
    }

    public void setCofitient(Integer cofitient) {
        this.cofitient = cofitient;
    }

    public Integer getCofitient() {
        return cofitient;
    }
    public Block getLeftBlock() {
        return leftBlock;
    }

    public void setLeftBlock(Block leftBlock) {
        this.leftBlock = leftBlock;
    }

    public Block getRightBlock() {
        return rightBlock;
    }

    public void setRightBlock(Block rightBlock) {
        this.rightBlock = rightBlock;
    }

    @Override
    public String toString() {
        return leftBlock.toString() + " = " + rightBlock.toString();
    }
}
