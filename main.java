//package jeu;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
   	 boolean game = true;
   	 int pointN = 0;
   	 int pointB = 0;
   	 String joueur = "N";
   	 Scanner sc = new Scanner(System.in);
   	 String[][] plateau = new String[10][10];   		 //création du plateaux et des variables
   	 
   	 
   	 for (int x = 0; x < plateau.length; x++)
   		 for (int y = 0; y < plateau.length; y++) {   	 //remplissage du tableaux
   			 if (((x%2 == 0 && y%2 != 0) || (x%2 != 0 && y%2 == 0)) && x < 4)
   				 plateau [x][y] = "N";
   			 else if (((x%2 == 0 && y%2 != 0) || (x%2 != 0 && y%2 == 0)) && x > 5)
   				 plateau [x][y] = "B";
   			 else
   				 plateau [x][y] = " ";
   		 }

//   	 plateau[4][5] = "B";
//   	 plateau[3][6] = "N";
   	 
   	 System.out.println("   	_ ______ _	_ 	_____  ______ 	_____      	__  __ ______  _____ \r\n" +
   						"  	| |  ____| |  | |   |  __ \\|  ____|   |  __ \\   /\\   |  \\/  |  ____|/ ____|\r\n" +
   						"  	| | |__  | |  | |   | |  | | |__  	| |  | | /  \\  | \\  / | |__  | (___  \r\n" +
   						"  _   | |  __| | |  | |   | |  | |  __| 	| |  | |/ /\\ \\ | |\\/| |  __|  \\___ \\ \r\n" +
   						" | |__| | |____| |__| |   | |__| | |____	| |__| / ____ \\| |  | | |____ ____) |\r\n" +
   						"  \\____/|______|\\____/	|_____/|______|   |_____/_/	\\_\\_|  |_|______|_____/ \n");
   	 
   	 System.out.println("\nVoici les règles :\n\tchaque joueur déplace, chacun leur tour, un de leur pion en diagonale.\n\tSi un pion se trouve en face d'un pion adverse et q'une case vide se trouve derrière, une prise est alors possible.\n\tLors d'une prise le pion du joueur passe derrière le pion adverse qui est retiré du plateau.\n\tUne prise est absolument prioritaire sur toute autre action et ne se fait qu'en avant (en diagonale),\n\tseul les dames peuvent faire des prises dans toutes les direction sans limite de distance.\n\tUn pion se transforme en dame quand il arrive à l'autre bout du plateau (ex: un pion blanc sur la ligne 0 devient une dames),\n\til peut alors se déplacer sur les diagonales comme il l'entend.\n\tLe but est de prendre tous les pion adverse.\n\nBonne partie, et que le meilleur gagne !\n");
   	 System.out.println();
   	 
   	 while (game == true) {
   		 
   		 if (joueur == "N")
   			 joueur = "B";
   		 else
   			 joueur = "N";
   		 
   		 Methodes.afficherPlateau(plateau);
   		 
   		 Methodes.bouger(plateau, joueur);
   		 
   		 pointB = 0;
   		 pointN = 0;
   		 
   		 for (String x[] : plateau)
   			 for (String y : x) {
   				 if (y == "B" || y == "DB")
   					 pointB++;
   				 
   				 if (y == "N" || y == "DN")
   					 pointN++;
   				 
   			 }
   		 
   		 if (pointB == 0) {
   			 game = false;
   			 Methodes.afficherPlateau(plateau);
   			 System.out.println("\nGAME OVER\n  _   _  ____ _____ _____                	_____      	_____ _   _ ______ \r\n" +
   					 " | \\ | |/ __ \\_   _|  __ \\    	/\\    	/ ____|   /\\   / ____| \\ | |  ____|\r\n" +
   					 " |  \\| | |  | || | | |__) |  	/  \\  	| |  __   /  \\ | |  __|  \\| | |__   \r\n" +
   					 " | . ` | |  | || | |  _  /  	/ /\\ \\ 	| | |_ | / /\\ \\| | |_ | . ` |  __|  \r\n" +
   					 " | |\\  | |__| || |_| | \\ \\ 	/ ____ \\	| |__| |/ ____ \\ |__| | |\\  | |____ \r\n" +
   					 " |_| \\_|\\____/_____|_|  \\_\\   /_/	\\_\\	\\_____/_/	\\_\\_____|_| \\_|______|");
   		 }
   		 if (pointN == 0) {
   			 game = false;
   			 Methodes.afficherPlateau(plateau);
   			 System.out.println("\nGAME OVER\n  ____  _           	_   _  _____               	_____      	_____ _   _ ______ \r\n" +
   					 " |  _ \\| |    	/\\   | \\ | |/ ____|   	/\\    	/ ____|   /\\   / ____| \\ | |  ____|\r\n" +
   					 " | |_) | |   	/  \\  |  \\| | |       	/  \\  	| |  __   /  \\ | |  __|  \\| | |__   \r\n" +
   					 " |  _ <| |  	/ /\\ \\ | . ` | |      	/ /\\ \\ 	| | |_ | / /\\ \\| | |_ | . ` |  __|  \r\n" +
   					 " | |_) | |____ / ____ \\| |\\  | |____ 	/ ____ \\	| |__| |/ ____ \\ |__| | |\\  | |____ \r\n" +
   					 " |____/|______/_/	\\_\\_| \\_|\\_____|   /_/	\\_\\	\\_____/_/	\\_\\_____|_| \\_|______|");
   		 }
   	 }
   	 
   	 

   	 sc.close();
    }
    

}





