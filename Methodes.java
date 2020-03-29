//package jeu;

import java.util.Scanner;

public class Methodes {
    
    
    public static void afficherPlateau (String[][] plateau) {
   	 int colonne = 0, ligne = 0;
   	 
   	 for (int ligneD = 0; ligneD < plateau.length; ligneD++)
   		 for (int colonneD = 0; colonneD < plateau.length; colonneD++) {
   			 if (ligneD == 0 && plateau[ligneD][colonneD] == "B")
   				 plateau[ligneD][colonneD] = "DB";    //si le joueur blanc a atteint la premierre ligne alors il devient une dame
   			 
   			 if (ligneD == 9 && plateau[ligneD][colonneD] == "N")
   				 plateau[ligneD][colonneD] = "DN";    //pareil pour le joueur noir
   		 }
   	 
   	 System.out.print("\t");
   	 for (int x = 0; x < plateau.length; x++)    			 //affichage des colonnes
   		 System.out.print(" " + colonne++ + "\t");
   	 
   	 System.out.println("\n");
   	 for (int x = 0; x < plateau.length; x++) {
   		 System.out.print(ligne++ + "\t");   				 //affichage des lignes et cases
   		 for (int y = 0; y < plateau.length; y++) {
   			 if ((x%2 == 0 && y%2 != 0) || (x%2 != 0 && y%2 == 0))
   				 System.out.print("|" + plateau[x][y] + "|" + "\t");
   			 else
   				 System.out.print("\t");
   		 }
   		 System.out.println("\n");
   	 }
    }
    
    
    
    public static boolean bouger (String[][] plateau , String joueur) {
   	 Scanner sc = new Scanner(System.in);
   	 int colonneD, ligneD;
   	 int colonneA, ligneA;
   	 String ennemi;
   	 boolean dame;
   	 int ligneDif, colonneDif;
   	 
   	 if (joueur == "N")
   		 ennemi = "B";   		 //détermine qui joue
   	 else
   		 ennemi = "N";
   	 
   	 if (verifPrise(plateau, joueur, ennemi) == true)
   		 return true;   									 //le return permet de mettre fin à la methode, si il y a eu une prise le toure se finit
   	 
   	 else {
   		 if (joueur == "N") {
   			 
   			 do {
   				 
   				 
   				 do {
   					 do {
   						 try {
   							 System.out.print("\nNoir, quel pièce voulez-vous bouger ?\nColonne : ");
   							 colonneD = Integer.parseInt(sc.nextLine());
   							 System.out.print("ligne : ");
   							 ligneD = Integer.parseInt(sc.nextLine());
   						 }
   						 catch (Exception e) {
   							 colonneD = -1;
   							 ligneD = -1;
   						 }
   						 
   					 } while (colonneD < 0 || colonneD > 9 || ligneD < 0 || ligneD > 9);
   				 } while (plateau[ligneD][colonneD] != "N" && plateau[ligneD][colonneD] != "DN" || ((ligneD%2 == 0 && colonneD%2 == 0) || (ligneD%2 != 0 && colonneD%2 != 0)));
   				 
   				 
   				 if (plateau[ligneD][colonneD] == "N")
   					 dame = false;
   				 else
   					 dame = true;
   				 
   				 do {
   					 try {
   						 System.out.print("\nOù voulez-vous la déplacer ?\nColonne : ");
   						 colonneA = Integer.parseInt(sc.nextLine());
   						 System.out.print("ligne : ");
   						 ligneA = Integer.parseInt(sc.nextLine());
   					 }
   					 catch (Exception e) {
   						 colonneA = -1;
   						 ligneA = -1;
   					 }
   					 
   				 } while (colonneA < 0 || colonneA > 9 || ligneA < 0 || ligneA > 9);
   				 
   				 
   				 ligneDif = ligneA - ligneD;
   				 ligneDif = valAbs(ligneDif);
   				 
   				 colonneDif = colonneA - colonneD;
   				 colonneDif = valAbs(colonneDif);
   				 
   				 
   			 } while (plateau[ligneA][colonneA] != " " ||     //la case doit être libre
   					 
   					 (ligneA > ligneD + 1 ||    //on ne peut pas sauter une ligne
   					 ligneA <= ligneD ||     //on ne peut pas reculer
   					 
   					 colonneA > colonneD + 1 ||    //on ne peut pas "sauter" une colonne
   					 colonneA < colonneD - 1) &&    //dans un sens ni dans l'autre
   					 dame == false ||    //si on est pas une dame
   					 
   					 (ligneDif != colonneDif) &&    //il faut se déplacer en diagonale
   					 dame == true ||    //si on est une dame
   			 
   					 ((ligneA%2 == 0 && colonneA%2 == 0) || (ligneA%2 != 0 && colonneA%2 != 0)));    //ne peut être que sur une case noir
   			 
   			 
   			 plateau[ligneA][colonneA] = plateau[ligneD][colonneD];   	 //"bouge" le pion
   			 plateau[ligneD][colonneD] = " ";
   			 
   			 if (verifPrise(plateau, joueur, ennemi) == true)
   				 return true;
   		 }
   		 
   		 
   		 
   		 else if (joueur == "B") {
   			 
   			 do {
   				 
   				 
   				 do {
   					 do {
   						 try {
   							 System.out.print("\nBlanc, quel pièce voulez-vous bouger ?\nColonne : ");
   							 colonneD = Integer.parseInt(sc.nextLine());
   							 System.out.print("ligne : ");
   							 ligneD = Integer.parseInt(sc.nextLine());
   						 }
   						 catch (Exception e) {
   							 colonneD = -1;
   							 ligneD = -1;
   						 }
   						 
   					 } while (colonneD < 0 || colonneD > 9 || ligneD < 0 || ligneD > 9);
   				 } while (plateau[ligneD][colonneD] != "B" && plateau[ligneD][colonneD] != "DB" || ((ligneD%2 == 0 && colonneD%2 == 0) || (ligneD%2 != 0 && colonneD%2 != 0)));
   			 
   				 
   				 if (plateau[ligneD][colonneD] == "B")
   					 dame = false;
   				 else
   					 dame = true;
   				 
   				 do {
   					 try {
   						 System.out.print("\nOù voulez-vous la déplacer ?\nColonne : ");
   						 colonneA = Integer.parseInt(sc.nextLine());
   						 System.out.print("ligne : ");
   						 ligneA = Integer.parseInt(sc.nextLine());
   					 }
   					 catch (Exception e) {
   						 colonneA = -1;
   						 ligneA = -1;
   					 }
   					 
   				 } while (colonneA < 0 || colonneA > 9 || ligneA < 0 || ligneA > 9);
   				 
   				 
   				 ligneDif = ligneA - ligneD;
   				 ligneDif = valAbs(ligneDif);
   				 
   				 colonneDif = colonneA - colonneD;
   				 colonneDif = valAbs(colonneDif);
   				 
   				 
   			 } while (plateau[ligneA][colonneA] != " " ||     //la case doit être libre
   					 
   					 (ligneA < ligneD - 1 ||    //on ne peut pas sauter une ligne
   					 ligneA >= ligneD ||     //on ne peut pas reculer
   					 
   					 colonneA > colonneD + 1 ||    //on ne peut pas "sauter" une colonne
   					 colonneA < colonneD - 1) &&    //dans un sens ni dans l'autre
   					 dame == false ||    //si on est pas une dame
   					 
   					 (ligneDif != colonneDif) &&    //il faut se déplacer en diagonale
   					 dame == true ||    //si on est une dame
   							 
   					 ((ligneA%2 == 0 && colonneA%2 == 0) || (ligneA%2 != 0 && colonneA%2 != 0)));    //ne peut être que sur une case noir
   			 
   			 
   			 plateau[ligneA][colonneA] = plateau[ligneD][colonneD];   	 //"bouge" le pion
   			 plateau[ligneD][colonneD] = " ";
   			 
   			 if (verifPrise(plateau, joueur, ennemi) == true)
   				 return true;
   			 
   		 }
   		 
   		 
   		 System.out.println();
   		 
   		 return true;
   	 }
    }

    
    
    public static boolean verifPrise (String[][] plateau, String joueur, String ennemi) {
   	 boolean prise = false;
   	 boolean[][][] directionPossible = new boolean[10][10][4];   	 //hg = 0    hd = 1    bg = 2    bd = 3    <- indices dans le tableau
   	 String ennemiD;
   	 String joueurD;
   	 boolean autrePion = false;
   	 boolean stopCheckHG = false, stopCheckHD = false, stopCheckBG = false, stopCheckBD = false;
   	 int[][][][] priseDame = new int[10][10][4][2];   	 //ligne joueur - colonne joueur - direction - ligne et colonne de pièce prise
   	 
   	 if (ennemi == "B") {
   		 ennemiD = "DB";
   		 joueurD = "DN";
   	 }
   	 else {
   		 ennemiD = "DN";
   		 joueurD = "DB";
   	 }
   	 
   	 for (int ligneD = 0; ligneD < plateau.length; ligneD++) {
   		 System.out.println();
   		 for (int colonneD = 0; colonneD < plateau.length; colonneD++) {
   			 
   			 
   			 if (plateau[ligneD][colonneD] == joueur) {
   			 
   				 if (colonneD > 1 && colonneD < 8 && ligneD > 1 && ligneD < 8) {
   					 if ((plateau[ligneD - 1][colonneD - 1] == ennemi || plateau[ligneD - 1][colonneD - 1] == ennemiD) && plateau[ligneD - 2][colonneD - 2] == " " && plateau[ligneD][colonneD] != "N") {    //diagonale haut gauche
   						 System.out.println("Une prise est possible en haut à gauche de la pièce " + colonneD + " " + ligneD);
   						 prise = true;
   						 directionPossible[ligneD][colonneD][0] = true;
   					 }
   					 
   					 if ((plateau[ligneD - 1][colonneD + 1] == ennemi || plateau[ligneD - 1][colonneD + 1] == ennemiD) && plateau[ligneD - 2][colonneD + 2] == " " && plateau[ligneD][colonneD] != "N") {    //diagonale haut droite
   						 System.out.println("Une prise est possible en haut à droite de la pièce " + colonneD + " " + ligneD);
   						 prise = true;
   						 directionPossible[ligneD][colonneD][1] = true;
   					 }
   						 
   					 if ((plateau[ligneD + 1][colonneD - 1] == ennemi || plateau[ligneD + 1][colonneD - 1] == ennemiD) && plateau[ligneD + 2][colonneD - 2] == " " && plateau[ligneD][colonneD] != "B") {     //diagonale bas gauche
   						 System.out.println("Une prise est possible en bas à gauche de la pièce " + colonneD + " " + ligneD);
   						 prise = true;
   						 directionPossible[ligneD][colonneD][2] = true;
   					 }
   						 
   					 if ((plateau[ligneD + 1][colonneD + 1] == ennemi || plateau[ligneD + 1][colonneD + 1] == ennemiD) && plateau[ligneD + 2][colonneD + 2] == " " && plateau[ligneD][colonneD] != "B") {    //diagonale bas droite
   						 System.out.println("Une prise est possible en bas à droite de la pièce " + colonneD + " " + ligneD);
   						 prise = true;
   						 directionPossible[ligneD][colonneD][3] = true;
   					 }
   				 }
   				 
   				 
   				 else if (colonneD < 2 && ligneD < 2 && (plateau[ligneD + 1][colonneD + 1] == ennemi || plateau[ligneD + 1][colonneD + 1] == ennemiD) && plateau[ligneD + 2][colonneD + 2] == " " && plateau[ligneD][colonneD] != "B") {    //diagonale bas droite
   						 System.out.println("Une prise est possible en bas à droite de la pièce " + colonneD + " " + ligneD);
   						 prise = true;
   						 directionPossible[ligneD][colonneD][3] = true;
   				 }
   				 
   				 
   				 else if(colonneD > 1 && colonneD < 8 && ligneD < 2) {
   					 if ((plateau[ligneD + 1][colonneD - 1] == ennemi || plateau[ligneD + 1][colonneD - 1] == ennemiD) && plateau[ligneD + 2][colonneD - 2] == " " && plateau[ligneD][colonneD] != "B") {     //diagonale bas gauche
   						 System.out.println("Une prise est possible en bas à gauche de la pièce " + colonneD + " " + ligneD);
   						 prise = true;
   						 directionPossible[ligneD][colonneD][2] = true;
   					 }
   					 
   					 if ((plateau[ligneD + 1][colonneD + 1] == ennemi || plateau[ligneD + 1][colonneD + 1] == ennemiD) && plateau[ligneD + 2][colonneD + 2] == " " && plateau[ligneD][colonneD] != "B") {    //diagonale bas droite
   						 System.out.println("Une prise est possible en bas à droite de la pièce " + colonneD + " " + ligneD);
   						 prise = true;
   						 directionPossible[ligneD][colonneD][3] = true;
   					 }
   				 }
   				 
   				 
   				 else if (colonneD > 7 && ligneD < 2 && (plateau[ligneD + 1][colonneD - 1] == ennemi || plateau[ligneD + 1][colonneD - 1] == ennemiD) && plateau[ligneD + 2][colonneD - 2] == " " && plateau[ligneD][colonneD] != "B") {   		 //diagonale bas gauche
   					 System.out.println("Une prise est possible en bas à gauche de la pièce " + colonneD + " " + ligneD);
   					 prise = true;
   					 directionPossible[ligneD][colonneD][2] = true;
   				 }
   				 
   				 
   				 else if (colonneD > 7 && ligneD > 1 && ligneD < 8) {
   					 if ((plateau[ligneD - 1][colonneD - 1] == ennemi || plateau[ligneD - 1][colonneD - 1] == ennemiD) && plateau[ligneD - 2][colonneD - 2] == " " && plateau[ligneD][colonneD] != "N") {    //diagonale haut gauche
   						 System.out.println("Une prise est possible en haut à gauche de la pièce " + colonneD + " " + ligneD);
   						 prise = true;
   						 directionPossible[ligneD][colonneD][0] = true;
   					 }
   					 
   					 if ((plateau[ligneD + 1][colonneD - 1] == ennemi || plateau[ligneD + 1][colonneD - 1] == ennemiD) && plateau[ligneD + 2][colonneD - 2] == " " && plateau[ligneD][colonneD] != "B") {     //diagonale bas gauche
   						 System.out.println("Une prise est possible en bas à gauche de la pièce " + colonneD + " " + ligneD);
   						 prise = true;
   						 System.out.println(ligneD + " : ligne ; colonne : "+ colonneD);
   						 directionPossible[ligneD][colonneD][2] = true;
   					 }
   				 }
   				 
   				 
   				 else if (colonneD > 7 && ligneD > 7 && (plateau[ligneD - 1][colonneD - 1] == ennemi || plateau[ligneD - 1][colonneD - 1] == ennemiD) && plateau[ligneD - 2][colonneD - 2] == " " && plateau[ligneD][colonneD] != "N") {   	 //diagonale haut gauche
   					 System.out.println("Une prise est possible en haut à gauche de la pièce " + colonneD + " " + ligneD);
   					 prise = true;
   					 directionPossible[ligneD][colonneD][0] = true;
   				 }
   				 
   				 
   				 else if (colonneD > 1 && colonneD < 8 && ligneD > 7) {
   					 if ((plateau[ligneD - 1][colonneD - 1] == ennemi || plateau[ligneD - 1][colonneD - 1] == ennemiD) && plateau[ligneD - 2][colonneD - 2] == " " && plateau[ligneD][colonneD] != "N") {    //diagonale haut gauche
   						 System.out.println("Une prise est possible en haut à gauche de la pièce " + colonneD + " " + ligneD);
   						 prise = true;
   						 directionPossible[ligneD][colonneD][0] = true;
   					 }
   					 
   					 if ((plateau[ligneD - 1][colonneD + 1] == ennemi || plateau[ligneD - 1][colonneD + 1] == ennemiD) && plateau[ligneD - 2][colonneD + 2] == " " && plateau[ligneD][colonneD] != "N") {    //diagonale haut droite
   						 System.out.println("Une prise est possible en haut à droite de la pièce " + colonneD + " " + ligneD);
   						 prise = true;
   						 directionPossible[ligneD][colonneD][1] = true;
   					 }
   				 }
   				 
   				 
   				 else if (colonneD < 2 && ligneD > 7 && (plateau[ligneD - 1][colonneD + 1] == ennemi || plateau[ligneD - 1][colonneD + 1] == ennemiD) && plateau[ligneD - 2][colonneD + 2] == " " && plateau[ligneD][colonneD] != "N") {   	 //diagonale haut droite
   					 System.out.println("Une prise est possible en haut à droite de la pièce " + colonneD + " " + ligneD);
   					 prise = true;
   					 directionPossible[ligneD][colonneD][1] = true;
   				 }
   				 
   				 
   				 else if (colonneD < 2 && ligneD > 1 && ligneD < 8) {
   					 if ((plateau[ligneD - 1][colonneD + 1] == ennemi || plateau[ligneD - 1][colonneD + 1] == ennemiD) && plateau[ligneD - 2][colonneD + 2] == " " && plateau[ligneD][colonneD] != "N") {    //diagonale haut droite
   						 System.out.println("Une prise est possible en haut à droite de la pièce " + colonneD + " " + ligneD);
   						 prise = true;
   						 directionPossible[ligneD][colonneD][1] = true;
   					 }
   					 
   					 if ((plateau[ligneD + 1][colonneD + 1] == ennemi || plateau[ligneD + 1][colonneD + 1] == ennemiD) && plateau[ligneD + 2][colonneD + 2] == " " && plateau[ligneD][colonneD] != "B") {    //diagonale bas droite
   						 System.out.println("Une prise est possible en bas à droite de la pièce " + colonneD + " " + ligneD);
   						 prise = true;
   						 directionPossible[ligneD][colonneD][3] = true;
   					 }
   				 }
   			 
   			 }
   			 
   			 
   			 else if (plateau[ligneD][colonneD] == joueurD) {   	 //si la pièce est une dame
   				 
   				 for (int n = 1; n <= ligneD && n <= colonneD && stopCheckHG == false; n++) {
   					 if (ligneD - n - 1 > 0 && colonneD - n - 1 > 0 && autrePion == false) {
   						 if ((plateau[ligneD - n][colonneD - n] == ennemi || plateau[ligneD - n][colonneD - n] == ennemiD) && plateau[ligneD - (n + 1)][colonneD - (n + 1)] == " ") {    //diagonale haut gauche
   							 System.out.println("Une prise est possible en haut à gauche de la dame " + colonneD + " " + ligneD);
   							 prise = true;
   							 stopCheckHG = true;
   							 directionPossible[ligneD][colonneD][0] = true;
   							 priseDame[ligneD][colonneD][0][0] = ligneD - n;
   							 priseDame[ligneD][colonneD][0][1] = colonneD - n;
   						 }
   						 
   						 if ((plateau[ligneD - n][colonneD - n] != " " && plateau[ligneD - (n + 1)][colonneD - (n + 1)] != " ") || plateau[ligneD - n][colonneD - n] == joueur || plateau[ligneD - n][colonneD - n] == joueurD)    //on ne peut pas avoir de prise pour une dame si deux pièce se suivent
   							 stopCheckHG = true;
   					 }
   				 }
   					 
   				 for (int n = 1; n < ligneD && n < plateau.length && stopCheckHD == false; n++) {
   					 if (ligneD - n - 1 > 0 && colonneD + n + 1 < 9) {
   						 if ((plateau[ligneD - n][colonneD + n] == ennemi || plateau[ligneD - n][colonneD + n] == ennemiD) && plateau[ligneD - (n + 1)][colonneD + (n + 1)] == " ") {    //diagonale haut droite
   							 System.out.println("Une prise est possible en haut à droite de la dame " + colonneD + " " + ligneD);
   							 prise = true;
   							 stopCheckHD = true;
   							 directionPossible[ligneD][colonneD][1] = true;
   							 priseDame[ligneD][colonneD][1][0] = ligneD - n;
   							 priseDame[ligneD][colonneD][1][1] = colonneD + n;
   						 }
   						 
   						 if ((plateau[ligneD - n][colonneD + n] != " " && plateau[ligneD - (n + 1)][colonneD + (n + 1)] != " ") || plateau[ligneD - n][colonneD + n] == joueur || plateau[ligneD - n][colonneD + n] == joueurD)    //on ne peut pas avoir de prise pour une dame si deux pièce se suivent
   							 stopCheckHD = true;
   					 }
   				 }
   						 
   				 for (int n = 1; n < plateau.length && n <= colonneD && stopCheckBG == false; n++) {
   					 if (ligneD + n + 1 < 9 && colonneD - n - 1 > 0) {
   						 if ((plateau[ligneD + n][colonneD - n] == ennemi || plateau[ligneD + n][colonneD - n] == ennemiD) && plateau[ligneD + (n + 1)][colonneD - (n + 1)] == " ") {     //diagonale bas gauche
   							 System.out.println("Une prise est possible en bas à gauche de la dame " + colonneD + " " + ligneD);
   							 prise = true;
   							 stopCheckBG = true;
   							 directionPossible[ligneD][colonneD][2] = true;
   							 priseDame[ligneD][colonneD][2][0] = ligneD + n;
   							 priseDame[ligneD][colonneD][2][1] = colonneD - n;
   						 }
   						 
   						 if ((plateau[ligneD + n][colonneD - n] != " " && plateau[ligneD + (n + 1)][colonneD - (n + 1)] != " ") || plateau[ligneD + n][colonneD - n] == joueur || plateau[ligneD + n][colonneD - n] == joueurD)    //on ne peut pas avoir de prise pour une dame si deux pièce se suivent
   							 stopCheckBG = true;
   					 }
   				 }
   				 
   				 for (int n = 1; n < plateau.length && stopCheckBD == false; n++) {
   					 if (ligneD + n + 1 < 9 && colonneD + n + 1 < 9) {
   						 if ((plateau[ligneD + n][colonneD + n] == ennemi || plateau[ligneD + n][colonneD + n] == ennemiD) && plateau[ligneD + (n + 1)][colonneD + (n + 1)] == " ") {    //diagonale bas droite
   							 System.out.println("Une prise est possible en bas à droite de la dame " + colonneD + " " + ligneD);
   							 prise = true;
   							 stopCheckBD = true;
   							 directionPossible[ligneD][colonneD][3] = true;
   							 priseDame[ligneD][colonneD][3][0] = ligneD + n;
   							 priseDame[ligneD][colonneD][3][1] = colonneD + n;
   						 }
   						 
   						 if ((plateau[ligneD + n][colonneD + n] != " " && plateau[ligneD + (n + 1)][colonneD + (n + 1)] != " ") || plateau[ligneD + n][colonneD + n] == joueur || plateau[ligneD + n][colonneD + n] == joueurD)    //on ne peut pas avoir de prise pour une dame si deux pièce se suivent
   							 stopCheckBD = true;
   					 }
   				 }
   				 
   				 
   			 }
   			 
   			 
   		 }
   	 }
   	 
   	 if (prise == true) {
   		 Methodes.afficherPlateau(plateau);
   		 prise(plateau, directionPossible, joueur, joueurD, priseDame);
   		 return true;
   	 }
   	 
   	 
   	 return false;
    }
    
    
    
    public static void prise (String[][] plateau, boolean[][][] directionPossible, String joueur, String joueurD, int[][][][] priseDame) {
   	 Scanner sc = new Scanner(System.in);
   	 int colonneD, ligneD;
   	 int colonneA, ligneA;
   	 int directionJ;   			 //direction choisie par le joueur
   	 boolean prisePossible;
   	 int ligneDif, colonneDif;
   		 
   	 for (int i = 0; i < 10; i++)
   		 System.out.println();
   	 
   	 if (joueur == "B")
   		 System.out.println("\nBlanc, effectuez l'une des prises possibles");
   	 else
   		 System.out.println("\nNoir, effectuez l'une des prises possibles");
   	 
   	 do {
   		 
   		 
   		 do {
   			 do {
   				 try {
   					 System.out.print("\nQuel pièce voulez-vous bouger ?\nColonne : ");
   					 colonneD = Integer.parseInt(sc.nextLine());
   					 System.out.print("ligne : ");
   					 ligneD = Integer.parseInt(sc.nextLine());
   				 }
   				 catch (Exception e) {
   					 colonneD = -1;
   					 ligneD = -1;
   				 }
   				 
   			 } while (colonneD < 0 || colonneD > 9 || ligneD < 0 || ligneD > 9);
   		 } while (plateau[ligneD][colonneD] != joueur && plateau[ligneD][colonneD] != joueurD || ((ligneD%2 == 0 && colonneD%2 == 0) || (ligneD%2 != 0 && colonneD%2 != 0)));
   		 
   		 
   		 do {
   			 try {
   				 System.out.print("\nOù voulez-vous la déplacer ?\nColonne : ");
   				 colonneA = Integer.parseInt(sc.nextLine());
   				 System.out.print("ligne : ");
   				 ligneA = Integer.parseInt(sc.nextLine());
   			 }
   			 catch (Exception e) {
   				 colonneA = -1;
   				 ligneA = -1;
   			 }
   			 
   		 } while (colonneA < 0 || colonneA > 9 || ligneA < 0 || ligneA > 9);
   		 
   		 
   		 ligneDif = ligneA - ligneD;
   		 ligneDif = valAbs(ligneDif);
   		 
   		 colonneDif = colonneA - colonneD;
   		 colonneDif = valAbs(colonneDif);
   		 
   		 
   		 if (ligneA < ligneD && colonneA < colonneD)
   			 directionJ = 0;
   		 
   		 else if (ligneA < ligneD && colonneA > colonneD)
   			 directionJ = 1;
   			 
   		 else if (ligneA > ligneD && colonneA < colonneD)
   			 directionJ = 2;
   		 
   		 else //if (ligneA > ligneD && colonneA > colonneD)
   			 directionJ = 3;
   			 
   		 
   		 if (directionPossible[ligneD][colonneD][directionJ] == true)
   			 prisePossible = true;
   		 
   		 else
   			 prisePossible = false;
   		 
   		 
   	 } while (plateau[ligneA][colonneA] != " " ||     //la case doit être libre
   			 
   			 (plateau[ligneD][colonneD] == joueur &&   	 //si on n'est pas une dame
   			 ((ligneA != ligneD + 2 &&   	 //deux au dessus ou
   			 ligneA != ligneD - 2) ||   	 //deux en dessous
   			 
   			 (colonneA != colonneD + 2 &&    //deux à droite ou
   			 colonneA != colonneD - 2))) ||    //deux à gauche
   			 
   			 
   			 (ligneDif != colonneDif) ||   			 //il faut se déplacer en diagonale
   			 
   			 prisePossible == false ||
   			 
   			 ((ligneA%2 == 0 && colonneA%2 == 0) || (ligneA%2 != 0 && colonneA%2 != 0)));    //ne peut être que sur une case noire
   	 
   	 
   	 plateau[ligneA][colonneA] = plateau[ligneD][colonneD];
   	 plateau[ligneD][colonneD] = " ";
   	 
   	 
   	 if (ligneA < ligneD && colonneA < colonneD) {
   		 if (plateau[ligneA][colonneA] == joueur)
   			 plateau[ligneD - 1][colonneD - 1] = " ";
   		 else
   			 plateau[priseDame[ligneD][colonneD][0][0]][priseDame[ligneD][colonneD][0][1]] = " ";
   	 }
   			 
   	 
   	 else if (ligneA < ligneD && colonneA > colonneD) {
   		 if (plateau[ligneA][colonneA] == joueur)
   			 plateau[ligneD - 1][colonneD + 1] = " ";
   		 else
   			 plateau[priseDame[ligneD][colonneD][1][0]][priseDame[ligneD][colonneD][1][1]] = " ";
   	 }
   		 
   	 else if (ligneA > ligneD && colonneA < colonneD) {
   		 if (plateau[ligneA][colonneA] == joueur)
   			 plateau[ligneD + 1][colonneD - 1] = " ";
   		 else
   			 plateau[priseDame[ligneD][colonneD][2][0]][priseDame[ligneD][colonneD][2][1]] = " ";
   	 }
   	 
   	 else { //if (ligneA > ligneD && colonneA > colonneD)
   		 if (plateau[ligneA][colonneA] == joueur)
   			 plateau[ligneD + 1][colonneD + 1] = " ";
   		 else
   			 plateau[priseDame[ligneD][colonneD][3][0]][priseDame[ligneD][colonneD][3][1]] = " ";
   	 }
   	 
   	 if (joueur == "B")
   		 verifPrise(plateau, joueur, "N");
   	 else
   		 verifPrise(plateau, joueur, "B");
   	 
   	 
    }
    
    
    
    public static int valAbs (int a) {
   	 if (a < 0)
   		 a = -a;
   	 return a;
    }
    
    
    
    

}





