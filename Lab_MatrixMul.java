/* 1*/ import java.util.Arrays;
/* 2*/ public class Lab_MatrixMul {
        /* 3*/ public static void main(String[] args) {
            /* 4*/ int[][] inputA = { { 5, 6, 7 }, { 4, 8, 9 } };
            /* 5*/ int[][] inputB = { { 6, 4 }, { 5, 7 }, { 1, 1 } };
            /* 6*/ MyData matA = new MyData(inputA);
            /* 7*/ MyData matB = new MyData(inputB);
            /* 8*/ int matC_r = matA.data.length;
            /* 9*/ int matC_c = matB.data[0].length;
            /*10*/ MyData matC = new MyData(matC_r, matC_c);
            /*11*/ // Q4 construct 2D array for each "thread"
                    Thread t1 = new Thread(new MatrixMulThread(matC_r, matC_c, matA, matB, matC));
                    t1.start();
                    
            // with respected to each cell in matC,
            // then start each thread
            /*12*/ // Q5 join each thread
                    try {
                        t1.join();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
        /*13*/ matC.show();
/*14*/         }
/*15*/ }
/*16*/ class MatrixMulThread implements Runnable {
    /*17*/ int processing_row; int processing_col;
    /*18*/ MyData datA; MyData datB; MyData datC;
    /*19*/ MatrixMulThread(int tRow, int tCol,MyData a, MyData b, MyData c) {
/*20*/ // Q1 code here
                processing_row = tRow;
                processing_col = tCol;
                datA = a;
                datB = b;
                datC = c;
    /*21*/ }
/*23*/ /* Q2 */public void run() { 
/*24*/ // Q3    
                    for (int i = 0; i < processing_row; i++) {
                        for (int j = 0; j < processing_col; j++) {
                            datC.data[i][j] = 0;
                            for (int k = 0; k < datB.data.length; k++) {
                                datC.data[i][j] += datA.data[i][k] * datB.data[k][j];
                            }
                        }
                    }
// System.out.println("perform sum of
// multiplication of assigned row and col");
/*25*/         }
/*26*/ } //class

/*27*/ class MyData {
    /*28*/ int[][] data;
    /*29*/ MyData(int[][] m) { data = m; }
    /*30*/ MyData(int r, int c) {
        /*31*/ data = new int[r][c];
        /*32*/ for (int[] aRow : data)
        /*33*/ Arrays.fill(aRow, 9);
        // 9 will be overwritten anyway
    /*34*/ }
    /*35*/ void show() {
               System.out.println(Arrays.deepToString(data));
    /*36*/ }
/*37*/ } //class