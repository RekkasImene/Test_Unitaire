package com.test;

import static org.junit.Assert.*;
import com.exception.NoSquareException;
import com.model.Matrix;
import com.service.MatrixMathematics;

public class MatrixMathematicsTest {

    @org.junit.Test
    public void determinantTest() throws NoSquareException
    {
            double [][] data={{4,7},{5,9}};
            Matrix matrixMathematic= new Matrix(data);
            assertEquals(1,MatrixMathematics.determinant(matrixMathematic),0);
    }

    @org.junit.Test
    public void determinantTest2() throws NoSquareException
    {

        //double [][] data1= {{2, 1, 3}, {1, 0, 2}, {2, 0, -2}};
        double [][] data1= {{4, 7, 5}, {21, 3, 6}, {11, 12, 13}};
        Matrix matrixMathematic1= new Matrix(data1);
        assertEquals(-486,MatrixMathematics.determinant(matrixMathematic1),0);
    }

   @org.junit.Test
    public void determinantTest3() throws NoSquareException
    {
        double [][]data2 ={{1}};
        Matrix  matrixMathematic2= new Matrix(data2);
        assertEquals(1,MatrixMathematics.determinant(matrixMathematic2),0);

    }

    @org.junit.Test (expected = NoSquareException.class)
    public void determinantTest4() throws NoSquareException
    {
        double [][]data={{1,4},{3,1},{2,1}};
        Matrix matrixMathematic= new Matrix(data);
        MatrixMathematics.determinant(matrixMathematic);
    }

}