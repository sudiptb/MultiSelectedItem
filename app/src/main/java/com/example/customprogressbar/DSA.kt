package com.example.customprogressbar

class TreeNode<T>(val value: T){

    private val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) = children.add(child)



}