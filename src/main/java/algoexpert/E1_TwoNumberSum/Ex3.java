package algoexpert.E1_TwoNumberSum;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex3 {

    public static boolean validarMatrizMagica() {
        int[][] matriz = {
                {0, 2, 3, 4},
                {2, 3, 5, 0},
                {0, 0, 1, 6},
                {8, 1, 1, 0}
        };

        int valorAComparar = 10;
        int resultadoTemporal;

        /**
         * Comparar los resultados en cada una de las filas
         */
        for (int fila = 0; fila <= 3; fila++) {

            resultadoTemporal = 0;

            for (int columna = 0; columna <= 3; columna++) { // 1(0,0), 2(0,1), 3(0,2), 4 (0,3) = 10
                resultadoTemporal = resultadoTemporal + matriz[fila][columna];
            }
            if (valorAComparar == 0) {
                valorAComparar = resultadoTemporal;
            }
            if (valorAComparar != resultadoTemporal) {
                return false;
            }
        }

        /**
         * Comparar los resultados en cada una de las columnas
         */
        for (int columna = 0; columna <= 3; columna++) {
            resultadoTemporal = 0;
            for (int fila = 0; fila <= 3; fila++) {
                resultadoTemporal = resultadoTemporal + matriz[fila][columna];
            }
            if (valorAComparar != resultadoTemporal) {
                return false;
            }
        }


        return true;

    }

    public static void main(String[] args) {
//        System.out.println("Matriz magica ?:" + validarMatrizMagica());
//        String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//        String date = simpleDateFormat.format(new Date());
//        System.out.println(date);
        Test test = new Test();
        test.setA(2.0);

        Double b = test.getA();

//        b = b + 3.0;

        System.out.println(test.getA().equals(b));


    }

    static class Test {
        public Double getA() {
            return a;
        }

        public void setA(Double a) {
            this.a = a;
        }

        private Double a;

    }
}
