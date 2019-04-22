package com.example.swypr;


public class Block<Integer> {
    public Integer componentID;
    public Block<Integer> up = null;
    public Block<Integer> down = null;
    public Block<Integer> left = null;
    public Block<Integer> right = null;

    public Block(Integer id){
        componentID = id;
    }


    public Integer getComponentID(){
        return componentID;
    }
}