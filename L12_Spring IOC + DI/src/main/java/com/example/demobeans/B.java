package com.example.demobeans;

import com.sun.istack.internal.NotNull;

public class B extends A{

    @NotNull
    private int test;

    @Override
    public int compare() {
        return 0;
    }
}
