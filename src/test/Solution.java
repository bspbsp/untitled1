package test;
import java.util.Scanner;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

public class Solution {
    public static int[][] seaBattle = new int[12][12];// матрица, в которую ИИ расставляет свои корабли
    public static int[][] seaBattlePrint = new int[12][12];// промежуточная матрица для считывания выстрелов и вывода поля боя
    public static String vertLineSearchNumber="ABCDEFGHIJ";
    public static int four_ship_vert_head = 0;//координаты корабля по верт.
    public static int four_ship_horiz_head = 0;//координаты корабля по горизонт
    public static int summ = 0;//сумма для проверки возможности установки корабля,
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
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
            //System.out.println("Dice - " + dice + " " + " Proverka - " + summ + " Vert - " + four_ship_vert_head + " Horiz - " + four_ship_horiz_head);

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
           // System.out.println("Dice - " + dice + " " + " Proverka - " + summ + " Vert - " + four_ship_vert_head + " Horiz - " + four_ship_horiz_head);


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
        placeShips(8,9,2,1);
        placeShips(8,9,2,1);
        placeShips(8,9,2,1);


        /*for (int[] ints : seaBattle) {
            for (int t = 0; t < seaBattle[0].length; t++) {
                System.out.print(" " + ints[t] + " ");
            }
            System.out.println();

        }*/
        System.out.println("Заполненное поле");// вывод в консоль поля, заполненного ИИ
        for (int priVert = 1; priVert < 11; priVert++) {
            for (int priHoriz = 1; priHoriz <11; priHoriz++) {
                if (seaBattle[priVert][priHoriz]==0) {System.out.print("[ ]");}
                else {System.out.print(ANSI_RED + "[X]"+ ANSI_RESET);}


            }
            System.out.println();



        }





        Scanner playerShoot = new Scanner(System.in);// считывание выстрела игрока


        for (int numberOfShoots = 0; numberOfShoots < 10; numberOfShoots++) {
            System.out.println("Введите координаты выстрела, например, G6");

            String playerShootStr = playerShoot.nextLine();
            System.out.print("\033[H\033[J");
        String playerShootVert = playerShootStr.substring(0, 1);// выделяет координаты по вертикали (первая буква)
        String playerShootVertUpper=playerShootVert.toUpperCase();
        String playerShootHoriz = playerShootStr.replaceAll("[^0-9]", "");// выделяет горизонтальные координаты (числа)
        int playerShootHorizInt = Integer.parseInt (playerShootHoriz);// преобразует горизонт в число
        int playerShootHorizVertInt= vertLineSearchNumber.indexOf(playerShootVertUpper)+1;// возвращает номер вертикальной строки в зависимости от координаты выстрела
        System.out.println("По вертикали - "+playerShootVertUpper+ "("+playerShootHorizVertInt+")"+" по горизонтали - "+playerShootHorizInt);


        if ((seaBattle[playerShootHorizVertInt][playerShootHorizInt])>0) {
                System.out.println("ПОПАДАНИЕ");
                    seaBattlePrint[playerShootHorizVertInt][playerShootHorizInt]=1;


            for (int priVertPrint = 1; priVertPrint < 11; priVertPrint++) {
                for (int priHorizPrint = 1; priHorizPrint <11; priHorizPrint++) {
                    if (seaBattlePrint[priVertPrint][priHorizPrint] == 0) {
                        System.out.print("[ ]");
                    } else {
                        System.out.print(ANSI_RED + "[X]" + ANSI_RESET);
                    }
                }
                System.out.println();
            }
        }
                else {
                System.out.println("МИМО");


            for (int priVertPrint = 1; priVertPrint < 11; priVertPrint++) {
                for (int priHorizPrint = 1; priHorizPrint <11; priHorizPrint++) {
                    if (seaBattlePrint[priVertPrint][priHorizPrint] == 0) {
                        System.out.print("[ ]");
                    } else {
                        System.out.print(ANSI_RED + "[X]" + ANSI_RESET);
                    }
                }
                System.out.println();
            }
                }
            }
        }
    }





