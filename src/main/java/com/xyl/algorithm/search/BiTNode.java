package com.xyl.algorithm.search;

import lombok.Data;

@Data
public class BiTNode {

    private int data;

    private BiTNode leftChild;

    private BiTNode rightChild;

    public BiTNode(){}

    public BiTNode(int data){
        this.data = data;
    }

}
