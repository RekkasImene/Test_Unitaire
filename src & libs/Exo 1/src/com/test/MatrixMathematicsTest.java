package com.test;

import com.exception.NoSquareException;
import com.model.Matrix;
import com.service.MatrixMathematics;

import static org.junit.Assert.*;

public class MatrixMathematicsTest {

    @org.junit.Test
    public void determinant() throws NoSquareException {
        //double [][]data={{4,7},{21,3}};
        double [][] data1= {{2, 1, 3}, {1, 0, 2}, {2, 0, -2}};
        Matrix m= new Matrix(data1);

        assertEquals(MatrixMathematics.determinant(m),6,0);
    }