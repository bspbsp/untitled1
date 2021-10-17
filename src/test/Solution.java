package test;

import java.sql.SQLOutput;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Sea Battle 0.001");
        int[][] seaBattle = new int[12][12];
        int four_ship_vert_head = 0;//координаты корабля по верт.
        int four_ship_horiz_head = 0;//координаты корабля по горизонт
        int summ = 0;//сумма для проверки возможности установки корабля, еще один тест
        int dice = ((int) (Math.random() * 100));
        // проверка и установка корабля 4 палубы
        if (dice < 50) {//случайно определяет будет ли корабль стоять вертикально или горизонтально
            do {//проверяет координаты корабля и клеточки вокруг на возможность установки
                summ = 0;
                four_ship_vert_head = ((int) (Math.random() * 5)) + 1;//задает случайнвые координаты корабля
                four_ship_horiz_head = ((int) (Math.random() * 9)) + 1;
                for (int i = (four_ship_vert_head - 1); i < four_ship_vert_head + 5; i++) {//суммирует все клетки "тела" корабля и клетки вокруг него, тем самым проверя есть там уже что
                    for (int j = four_ship_horiz_head - 1; j < four_ship_horiz_head + 2; j++) {// или нет
                        summ = summ + seaBattle[i][j];
                    }
                }
            } while (summ != 0);
            System.out.println("Dice - " + dice + " " + " Proverka - " + summ + " Vert - " + four_ship_vert_head + " Horiz - " + four_ship_horiz_head);

            for (int pal = 0; pal < 4; pal++) {//устанавливает "тело" корабля в массив

                seaBattle[four_ship_vert_head + pal][four_ship_horiz_head] = 4;
            }

        } else {// все то же самое, но наоборот, вертикаль/горизонталь установки корабля
            do {
                summ = 0;
                four_ship_vert_head = ((int) (Math.random() * 9)) + 1;
                four_ship_horiz_head = ((int) (Math.random() * 5)) + 1;
                for (int i = (four_ship_vert_head - 1); i < four_ship_vert_head + 2; i++) {
                    for (int j = four_ship_horiz_head - 1; j < four_ship_horiz_head + 5; j++) {
                        summ = summ + seaBattle[i][j];
                    }
                }
            } while (summ != 0);
            System.out.println("Dice - " + dice + " " + " Proverka - " + summ + " Vert - " + four_ship_vert_head + " Horiz - " + four_ship_horiz_head);


            for (int pal = 0; pal < 4; pal++) {

                seaBattle[four_ship_vert_head][four_ship_horiz_head + pal] = 4;
            }

        }

        //проверка и установка двух трехпалубных
        for (int tri = 0; tri < 2; tri++) {

            int dice2 = ((int) (Math.random() * 100));
            if (dice2 < 50) {
                do {
                    summ = 0;
                    four_ship_vert_head = ((int) (Math.random() * 6)) + 1;
                    four_ship_horiz_head = ((int) (Math.random() * 9)) + 1;
                    for (int i = (four_ship_vert_head - 1); i < four_ship_vert_head + 4; i++) {
                        for (int j = four_ship_horiz_head - 1; j < four_ship_horiz_head + 2; j++) {
                            summ = summ + seaBattle[i][j];
                        }
                    }
                } while (summ != 0);
                System.out.println("Dice - " + dice2 + " " + " Proverka - " + summ + " Vert - " + four_ship_vert_head + " Horiz - " + four_ship_horiz_head);


                for (int pal = 0; pal < 3; pal++) {

                    seaBattle[four_ship_vert_head + pal][four_ship_horiz_head] = 3;
                }

            } else {
                do {
                    summ = 0;
                    four_ship_vert_head = ((int) (Math.random() * 9)) + 1;
                    four_ship_horiz_head = ((int) (Math.random() * 6)) + 1;
                    for (int i = (four_ship_vert_head - 1); i < four_ship_vert_head + 2; i++) {
                        for (int j = four_ship_horiz_head - 1; j < four_ship_horiz_head + 4; j++) {
                            summ = summ + seaBattle[i][j];
                        }
                    }
                } while (summ != 0);
                System.out.println("Dice - " + dice2 + " " + " Proverka - " + summ + " Vert - " + four_ship_vert_head + " Horiz - " + four_ship_horiz_head);


                for (int pal = 0; pal < 3; pal++) {

                    seaBattle[four_ship_vert_head][four_ship_horiz_head + pal] = 3;
                }
            }
        }

        // конец трепалубных

        // начало двупалубных
        for (int dva = 0; dva < 3; dva++) {

            int dice3 = ((int) (Math.random() * 100));
            if (dice3 < 50) {
                do {
                    summ = 0;
                    four_ship_vert_head = ((int) (Math.random() * 7)) + 1;
                    four_ship_horiz_head = ((int) (Math.random() * 9)) + 1;
                    for (int i = (four_ship_vert_head - 1); i < four_ship_vert_head + 3; i++) {
                        for (int j = four_ship_horiz_head - 1; j < four_ship_horiz_head + 2; j++) {
                            summ = summ + seaBattle[i][j];
                        }
                    }
                } while (summ != 0);
                System.out.println("Dice - " + dice3 + " " + " Proverka - " + summ + " Vert - " + four_ship_vert_head + " Horiz - " + four_ship_horiz_head);


                for (int pal = 0; pal < 2; pal++) {

                    seaBattle[four_ship_vert_head + pal][four_ship_horiz_head] = 2;
                }
            } else {
                do {
                    summ = 0;
                    four_ship_vert_head = ((int) (Math.random() * 9)) + 1;
                    four_ship_horiz_head = ((int) (Math.random() * 7)) + 1;
                    for (int i = (four_ship_vert_head - 1); i < four_ship_vert_head + 2; i++) {
                        for (int j = four_ship_horiz_head - 1; j < four_ship_horiz_head + 3; j++) {
                            summ = summ + seaBattle[i][j];
                        }
                    }
                } while (summ != 0);
                System.out.println("Dice - " + dice3 + " " + " Proverka - " + summ + " Vert - " + four_ship_vert_head + " Horiz - " + four_ship_horiz_head);


                for (int pal = 0; pal < 2; pal++) {

                    seaBattle[four_ship_vert_head][four_ship_horiz_head + pal] = 2;
                }
            }
        }
        //конец двупалубных

        //начало однопалубных
        for (int raz = 0; raz < 4; raz++) {
            do {
                summ = 0;
                four_ship_vert_head = ((int) (Math.random() * 9)) + 1;
                four_ship_horiz_head = ((int) (Math.random() * 9)) + 1;
                for (int i = (four_ship_vert_head - 1); i < four_ship_vert_head + 2; i++) {
                    for (int j = four_ship_horiz_head - 1; j < four_ship_horiz_head + 2; j++) {
                        summ = summ + seaBattle[i][j];
                    }
                }
            } while (summ != 0);
            System.out.println("Dice - " + " " + " Proverka - " + summ + " Vert - " + four_ship_vert_head + " Horiz - " + four_ship_horiz_head);


            for (int pal = 0; pal < 1; pal++) {

                seaBattle[four_ship_vert_head + pal][four_ship_horiz_head] = 1;
            }

        }
        //конец однопалубных

        // вывод на экран поля боя
        for (int[] ints : seaBattle) {
            for (int t = 0; t < seaBattle[0].length; t++) {
                System.out.print(" " + ints[t] + " ");
            }
            System.out.println();
        }
    }
}

