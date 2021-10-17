package test;

import java.sql.SQLOutput;

public class Solution {
    public static int[][] seaBattle = new int[12][12];
    public static int four_ship_vert_head = 0;//координаты корабля по верт.
    public static int four_ship_horiz_head = 0;//координаты корабля по горизонт
    public static int summ = 0;//сумма для проверки возможности установки корабля,

    public static void placeShips(int otstupVert, int otstupHoriz, int dlinaProverka, int dlinaKorabl) {

        int dice = ((int) (Math.random() * 100));
        if (dice < 50) {//случайно определяет будет ли корабль стоять вертикально или горизонтально
            do {//проверяет координаты корабля и клеточки вокруг на возможность установки
                summ = 0;
                four_ship_vert_head = ((int) (Math.random() * otstupVert)) + 1;//задает случайнвые координаты корабля (5)
                four_ship_horiz_head = ((int) (Math.random() * otstupHoriz)) + 1;                                      //   (9)
                for (int i = (four_ship_vert_head - 1); i < four_ship_vert_head + dlinaProverka; i++) {// (5)суммирует все клетки "тела" корабля и клетки вокруг него, тем самым проверя есть там уже что
                    for (int j = four_ship_horiz_head - 1; j < four_ship_horiz_head + 2; j++) {// (2)или нет
                        summ = summ + seaBattle[i][j];
                    }
                }
            } while (summ != 0);
            System.out.println("Dice - " + dice + " " + " Proverka - " + summ + " Vert - " + four_ship_vert_head + " Horiz - " + four_ship_horiz_head);

            for (int pal = 0; pal < dlinaKorabl; pal++) {//устанавливает "тело" корабля в массив (4)

                seaBattle[four_ship_vert_head + pal][four_ship_horiz_head] = dlinaKorabl; //(4)
            }

        } else {// все то же самое, но наоборот, вертикаль/горизонталь установки корабля
            do {
                summ = 0;
                four_ship_vert_head = ((int) (Math.random() * otstupHoriz)) + 1;//(9)
                four_ship_horiz_head = ((int) (Math.random() * otstupVert)) + 1;//(5)
                for (int i = (four_ship_vert_head - 1); i < four_ship_vert_head + 2; i++) {//(2)
                    for (int j = four_ship_horiz_head - 1; j < four_ship_horiz_head + dlinaProverka; j++) {//(5)
                        summ = summ + seaBattle[i][j];
                    }
                }
            } while (summ != 0);
            System.out.println("Dice - " + dice + " " + " Proverka - " + summ + " Vert - " + four_ship_vert_head + " Horiz - " + four_ship_horiz_head);


            for (int pal = 0; pal < dlinaKorabl; pal++) {//(4)

                seaBattle[four_ship_vert_head][four_ship_horiz_head + pal] = dlinaKorabl;//(4)
            }

        }

    }
    public static void main(String[] args) {
        System.out.println("Sea Battle 0.001");

        // проверка и установка корабля 4 палубы
        placeShips(5,9,5,4);
        placeShips(6,9,4,3);
        placeShips(6,9,4,3);
        placeShips(7,9,3,2);
        placeShips(7,9,3,2);
        placeShips(7,9,3,2);
        placeShips(8,9,2,1);


        for (int[] ints : seaBattle) {
            for (int t = 0; t < seaBattle[0].length; t++) {
                System.out.print(" " + ints[t] + " ");
            }
            System.out.println();
        }
    }
}

