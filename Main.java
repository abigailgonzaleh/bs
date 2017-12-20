
//Begoña Montes GÃ³mez A01329896
//Estefania Pitol Martinez A01551688
//Abigail Gonzalez Hidalgo A00819967
import java.util.Scanner;
import java.util.Random;
import java.io.*;
import java.util.*;
public class Main{

// cuando declaras variables fuera del main deben de ser public,static
	public static Random rd= new Random();
	public static Scanner sc =new Scanner(System.in);
	
	public static String compu [] []= new String [12][12]; 
	public static String compuMod[][]=new String[12][12];

	public static String usuario2[][]=new String [12][12];
	public static String usuarioMod[][]=new String [12][12];
	public static char letras [] = {'A','B','C','D','E','F','G','H','I','J','K','L'};
	public static int barcos =0;
	public static int barcosu =0;
	public static int b2=0;
	public static int b4=0; 
	public static int b6=0;
	public static int b8=0;
	public static int b10=0;
	public static int cb2=0;
	public static int cb4=0; 
	public static int cb6=0;
	public static int cb8=0;
	public static int cb10=0;

	public static String search; 

	public static int global1=0, global2=0;
	public static int origen1=0, origen2=0;
	public static int direccion=0;

	public static boolean buscando=false;

	public static void main(String args[]){


		System.out.println("1. Nueva partida");
		System.out.println("2.Continuar partida");
		int op=sc.nextInt();
		
		switch(op){
			case 1:


				//tablero de la compu

			for(int i=0;i<12;i++){
				for(int j=0;j<12;j++){
					compu[i][j]="-";
					compuMod[i][j]="-";
				}
			}




			compu = llenar(compu,10);
			compu = llenar(compu,8);
			compu = llenar(compu,6);
			compu = llenar(compu,4);
			compu = llenar(compu,2);

				//imprime(compu);



				//TABLERO PERSONA


			for(int i=0;i<12;i++)
				for(int j=0;j<12;j++)
					usuario2[i][j]="-";
				
				usuario2 = llenar2(usuario2);
				usuarioMod = usuario2;
				
				while(barcos<5 && barcosu<5){
					juega(compu);
					if(barcos<5)
						juegacompu(usuario2);
					imprime(compuMod);
					imprime(usuario2);
					System.out.println("Te quedan " + (5-barcosu) + " barcos.");
					System.out.println("A la computadora le quedan " + (5-barcos) + " barcos.");

				}

				if(barcos==5){
					System.out.println("Ganaste");
				}
				else System.out.println("Perdiste");

				
				case 2:
				load();
				while(barcos<5 && barcosu<5){
					juega(compu);
					if(barcos<5)
						juegacompu(usuario2);
					imprime(compuMod);
					imprime(usuario2);
					System.out.println("Te quedan " + (5-barcosu) + " barcos.");
					System.out.println("A la computadora le quedan " + (5-barcos) + " barcos.");  
				}

				break;

				case 0:
				giveup();
				break;

				default:
				System.out.println("OPCION NO VALIDA");
				break;

			}
		}

		public static void juegacompu(String [][] usuario){
			int a=0, b=0;
			if(buscando==false){
				direccion = 0;
				do{
					a=rd.nextInt(12);
					b=rd.nextInt(12);
				}while(usuario2[a][b].compareTo("O")==0|| usuario2[a][b].compareTo("X")==0);
				if(usuario2[a][b].compareTo("-")==0)
					usuario2[a][b]="O";
				else if(usuario2[a][b].compareTo("-")!=0 && usuario2[a][b].compareTo("O")!=0 && usuario2[a][b].compareTo("X")!=0){
					switch(Integer.parseInt(usuario2[a][b])){
						case 2:
						cb2++;
						if(cb2 == 2){
							System.out.println("Te han hundido el barco 2");
							buscando = false;
							barcosu++;
						}
						break;
						case 4:
						cb4++;
						if(cb4 == 4){
							System.out.println("Te han hundido el barco 4");
							buscando = false;
							barcosu++;
						}
						break;
						case 6:
						cb6++;
						if(cb6 == 6){
							System.out.println("Te han hundido el barco 6");
							buscando = false;
							barcosu++;
						}
						break;
						case 8:
						cb8++;
						if(cb8 == 8){
							System.out.println("Te han hundido el barco 8");
							buscando = false;
							barcosu++;
						}
						break;
						case 10:
						cb10++;
						if(cb10 == 10){
							System.out.println("Te han hundido el barco 10");
							buscando = false;
							barcosu++;
						}
						break;
					}
					search = usuario2[a][b];
					usuario2[a][b]="X";
					buscando=true;
					global1=a;
					global2=b;
					origen1=a;
					origen2=b;

				}
			}
			else{
				if(direccion==0){
					if(global1>0 && usuario2[global1-1][global2].compareTo("X")!=0 && usuario2[global1-1][global2].compareTo("O")!=0)
						global1--;
					else{
						global1=origen1;
						global2=origen2;
						if(direccion<3){
							direccion++;
						}
					}
				}
				if(direccion==1){
					if(global1<11 && usuario2[global1+1][global2].compareTo("X")!=0 && usuario2[global1+1][global2].compareTo("O")!=0)
						global1++;
					else{
						global1=origen1;
						global2=origen2;
						if(direccion<3){
							direccion++;
						}
					}
				}
				if(direccion==2){
					if(global2>0 && usuario2[global1][global2-1].compareTo("X")!=0 && usuario2[global1][global2-1].compareTo("O")!=0)
						global2--;
					else{
						global1=origen1;
						global2=origen2;
						if(direccion<3){
							direccion++;
						}
					}
				}
				if(direccion==3){
					if(global2<11 && usuario2[global1][global2+1].compareTo("X")!=0 && usuario2[global1][global2+1].compareTo("O")!=0)
						global2++;
					else{
						global1=origen1;
						global2=origen2;
						buscando = false;
					}					
				}
				if(usuario2[global1][global2].compareTo("-")==0){
					usuario2[global1][global2] = "O";
					global1=origen1;
					global2=origen2;
					if(direccion<3){
						direccion++;
					}
				}
				else if(usuario2[global1][global2].compareTo("-")!=0 && usuario2[global1][global2].compareTo("O")!=0 && usuario2[global1][global2].compareTo("X")!=0) {
					switch(Integer.parseInt(usuario2[global1][global2])){
						case 2:
						cb2++;
						if(cb2 == 2){
							System.out.println("Te han hundido el barco 2");
							buscando = false;
							barcosu++;
						}
						break;
						case 4:
						cb4++;
						if(cb4 == 4){
							System.out.println("Te han hundido el barco 4");
							buscando = false;
							barcosu++;
						}
						break;
						case 6:
						cb6++;
						if(cb6 == 6){
							System.out.println("Te han hundido el barco 6");
							buscando = false;
							barcosu++;
						}
						break;
						case 8:
						cb8++;
						if(cb8 == 8){
							System.out.println("Te han hundido el barco 8");
							buscando = false;
							barcosu++;
						}
						break;
						case 10:
						cb10++;
						if(cb10 == 10){
							System.out.println("Te han hundido el barco 10");
							buscando = false;
							barcosu++;
						}
						break;
					}
					usuario2[global1][global2] = "X";
				}
				else{
					buscando = false;
				}
			}
		}

		public static String [][] llenar (String tablero[][], int tam){

			boolean imposible = false;
			int x2, nose, x3;
			
			do{

				imposible=false;
				 x2=rd.nextInt(2); // me dice si es horizontal o vertical
				 nose = rd.nextInt(13-tam);// me va a dar las coordenadas donde se puede empezar
				 x3 = rd.nextInt(12);// la fila o columan donde se harÃ¡
				 if(x2==0){
				 	for(int i=nose;i<nose+tam;i++){
				 		if(tablero[i][x3]!="-")
				 			imposible = true;
				 	}
				 }
				 if(x2==1){
				 	for(int i=nose;i<nose+tam;i++){
				 		if(tablero[x3][i]!="-")
				 			imposible = true;
				 	}
				 }


				}
				while(imposible==true);

				if(x2==0){
					for(int i=nose;i<nose+tam;i++){
						tablero[i][x3]=(""+tam);
					}
				}

				if(x2==1){
					for(int i=nose;i<nose+tam;i++){
						tablero[x3][i]=(""+tam);
					}
				}

				return tablero;



			}
			public static String[][] llenar2(String usuario[][]){
				boolean funciona = false;

				for(int tamanio=10;tamanio>=2;tamanio-=2)
				{
					int c1, c2;
					do {
						funciona=false;

						System.out.println("Ingresa la coordenada de tu barco de tamanio "+ tamanio);
						String coord;
						do{
							coord=sc.next();
						}while(coord.length()<2);
						coord=coord.toUpperCase();


						c1=coord.charAt(0)-'A';

						if(c1>11|| c1<0)
							funciona=true;

						c2=coord.charAt(1)-48;


						if(coord.length()==2)
						{

					//c1= coord.charAt(0)-'A';
							c2=coord.charAt(1)- 48;
						}	

				//en caso de que sea 10
						else{
							if(coord.charAt(2)=='0')
							{
								c2=coord.charAt(1) - 48;
								c2=c2+9;
							}

							else if(coord.charAt(2)=='1'){
								c2=coord.charAt(1) - 48;
								c2=c2+10;	
							}	
					// en caso de que sea 11

							else
								funciona=true;


						}
						if(c2>11|| c2<0)
							funciona=true;
						if(funciona)
							System.out.println("La coordenada no es valida");

					} while(funciona==true);



					System.out.println("Orientacion?");
					System.out.println("1. Hacia arriba");
					System.out.println("2. Hacia abajo");
					System.out.println("3. Hacia la izquierda");
					System.out.println("4. Hacia la derecha");
					int op2;
					do{
						op2= sc.nextInt();
						if(op2 <= 0 || op2 >= 5 )
							System.out.println("Ingresa un numero valido.");
					}while(op2 <= 0 || op2 >= 5 );
					boolean bandera =true;

					switch(op2){

						case 1: System.out.println("Seleccionaste: arriba");
						if(c1-tamanio>=-1)
						{
							for(int b=0;b<tamanio;b++){
								if(usuario[c1-b][c2]=="-")
								{

								}
								else
									bandera=false;
							}
							
							if(bandera)
							{
								for(int c=0;c<tamanio;c++){
									usuario[c1-c][c2] = (""+tamanio);
								}
							}

							else{
								System.out.println("Tus barcos se enciman, intenta otra orientacion");
								tamanio=tamanio+2;
							}

						}

						else{
							System.out.println("Tu barco se sale del tablero, intenta otra orientacion");
							tamanio=tamanio+2;
						}

						break;

						case 2:System.out.println("Seleccionaste: abajo");
						if(c1+tamanio<=12)
						{
							for(int b=0;b<tamanio;b++){
								if(usuario[c1+b][c2]=="-")
								{

								}
								else
									bandera=false;
							}
							
							if(bandera)
							{
								for(int c=0;c<tamanio;c++){
									usuario[c1+c][c2] = (""+tamanio);
								}
								
							}

							else{
								System.out.println("Tus barcos se enciman, intenta otra orientacion");
								tamanio=tamanio+2;
							}

						}

						else{
							System.out.println("Tu barco se sale del tablero, intenta otra orientacion");
							tamanio=tamanio+2;
						}
						break;

						case 3:System.out.println("Seleccionaste: izquierda");
						if(c2-tamanio>=-1)
						{
							for(int b=0;b<tamanio;b++){
								if(usuario[c1][c2-b]=="-")
								{

								}
								else
									bandera=false;
							}
							
							if(bandera)
							{
								for(int c=0;c<tamanio;c++){
									usuario[c1][c2-c] = (""+tamanio);
								}
								
							}

							else{
								System.out.println("Tus barcos se enciman, intenta otra orientacion");
								tamanio=tamanio+2;
							}


						}

						else{
							System.out.println("Tu barco se sale del tablero, intenta otra orientacion");
							tamanio=tamanio+2;
						}


						break;

						case 4:System.out.println("Seleccionaste: abajo");
						if(c2+tamanio<=12)
						{
							for(int b=0;b<tamanio;b++){
								if(usuario[c1][c2+b]=="-")
								{

								}
								else
									bandera=false;
							}
							
							if(bandera)
							{
								for(int c=0;c<tamanio;c++){
									usuario[c1][c2+c] = (""+tamanio);
								}
								
							}

							else{
								System.out.println("Tus barcos se enciman, intenta otra orientacion");
								tamanio=tamanio+2;
							}


						}

						else{
							System.out.println("Tu barco se sale del tablero, intenta otra orientacion");
							tamanio=tamanio+2;
						}
						break;

					}
					imprime(usuario);
				}
				return usuario;
			}

			public static void juega(String [][] compu){
				boolean funciona = false;

				int c1, c2;
				String coord;

				do {
					funciona=false;
					do{
						System.out.println("Ingresa la coordenada donde vas a atacar");

						coord=sc.next();
						while(comandos(coord)){
							coord = sc.next();
						}
					}while(coord.length()<2);
				//checar// mando a llamar el metodo checar
					coord= coord.toUpperCase();


					c1=coord.charAt(0)-'A';

					if(c1>11|| c1<0)
						funciona=true;

					c2=coord.charAt(1)-48;


					if(coord.length()==2)
					{

					//c1= coord.charAt(0)-'A';
						c2=coord.charAt(1)- 48;
					}	

				//en caso de que sea 10
					else{
						if(coord.charAt(2)=='0')
						{
							c2=coord.charAt(1) - 48;
							c2=c2+9;
						}

						else if(coord.charAt(2)=='1'){
							c2=coord.charAt(1) - 48;
							c2=c2+10;	
						}	
					// en caso de que sea 11

						else
							funciona=true;


					}
					if(c2>11|| c2<0)
						funciona=true;
					if(funciona)
						System.out.println("La coordenada no es valida");

				} while(funciona==true);
				
				System.out.println("Coordenadas donde atacaras: "+c1+" - "+c2);
				if(compu[c1][c2].compareTo("-")!=0 && compu[c1][c2].compareTo("O")!=0 && compu[c1][c2].compareTo("X")!=0)

				{
					System.out.println("HIT");


					switch(Integer.parseInt(compu[c1][c2]))
					{
						case 2:
						compu[c1][c2]="X";
						compuMod[c1][c2]="X";
						b2++;
						if(b2==2)
						{
							barcos++;
							System.out.println("Bien, destruiste el barco 2");
						}
						break;
						case 4:
						compu[c1][c2]="X";
						compuMod[c1][c2]="X";
						b4++;
						if(b4==4)
						{
							barcos++;
							System.out.println("Bien, destruiste el barco 4");
						}
						break;
						case 6:
						compu[c1][c2]="X";
						compuMod[c1][c2]="X";
						b6++;
						if(b6==6)
						{
							barcos++;
							System.out.println("Bien, destruiste el barco 6");
						}
						break;
						case 8:
						compu[c1][c2]="X";
						compuMod[c1][c2]="X";
						b8++;
						if(b8==8)
						{
							barcos++;
							System.out.println("Bien, destruiste el barco 8");
						}
						break;
						case 10:
						compu[c1][c2]="X";
						compuMod[c1][c2]="X";
						b10++;
						if(b10==10)
						{
							barcos++;
							System.out.println("Bien, destruiste el barco 10");
						}
						break;
					}
					System.out.println("Numero de destruidos "+barcos);
				}
				else
					if(compu[c1][c2]=="X")
					{

					}
					else{
						compu[c1][c2]="O";
						compuMod[c1][c2] = "O";
						System.out.println("MISS");

					}

				}

				public static void imprime( String [][] matriz){
					System.out.print(" ");

					for(int k=0;k<12;k++)
						System.out.printf("%3s",k);

					System.out.println();

				for(int i=0;i<12;i++){ // filas 
					System.out.print(letras[i]);
					for(int j=0;j<12;j++) // columnas
					System.out.printf("%3s",matriz[i][j]);
					System.out.println();
				}

				System.out.println();

			}
			public static void save(){
				String arch_out;
				System.out.println("Nombre de la partida?");
				arch_out = sc.next();
				String stmp;
				File arch_sal = new File(arch_out);

				try {
					PrintWriter writer = new PrintWriter (arch_sal, "UTF-8");                    
					for (int i=0; i<12; i++){
						for(int j = 0; j<12; j++){
							writer.println(compu[i][j]);
						}

					}

					for (int i=0; i<12; i++){
						for(int j = 0; j<12; j++)
							writer.println(usuario2[i][j]);

					}
					for (int i=0; i<12; i++){
						for(int j = 0; j<12; j++)
							writer.println(compuMod[i][j]);

					}

					writer.close();
				} 
				catch (IOException e) {
					System.err.println(e);
					System.exit(1);
				}
				System.out.println("Tu partida ha sido guardada exitosamente!");
			}

			public static void load(){
				String arch_in;
				System.out.println("Nombre de la partida?");
				arch_in = sc.next();
				String line;
				System.out.println("Esto borrara toda la informacion existente, ... quieres continuar?");
				if (sc.next().equalsIgnoreCase("si")){
					System.out.println("Confirmado!");
					try{
						BufferedReader in = new BufferedReader(new FileReader(arch_in));
						line=arch_in;
						if (line == null)
							System.out.println("Error en la partida de entrada");
						else{

							for (int i=0; i<12;i++){
								for(int j = 0; j<12; j++){                                  
									compu[i][j] = in.readLine();                                
								}                       
							}
							for(int a = 0; a<12; a++){
								for(int b = 0; b<12; b++){
									usuario2 [a][b] = in.readLine();     
								}
							}
							for(int c = 0; c<12; c++){
								for(int d = 0; d<12; d++){
									compuMod [c][d] = in.readLine();    
								}
							}
							imprime(compuMod);

							imprime(usuario2);


						}
						in.close();
					}
					catch(IOException e){
						System.out.println("No se encontro la partida!");
					}
				}                                                       
				else    
					System.out.println("No confirmo");
			}

			public static void giveup(){
				System.out.println("Perdedor!");
				System.exit(0);
			}

			public static void board(){
				imprime(compu);

			}

			public static boolean checarSave(String nose){
				if(nose.compareTo("#save")==0){
					return true;
				}
				return false;
			}

			public static boolean checarLoad(String nose){
				if(nose.compareTo("#load")==0){
					return true;
				}
				return false;
			}

			public static boolean checarGiveUp(String nose){
				if(nose.compareTo("#giveup")==0){
					return true;
				}
				return false;
			}

			public static boolean checarBoard(String nose){
				if(nose.compareTo("#board")==0){
					return true;
				}
				return false;
			}

			public static boolean comandos(String nose){
				if(checarSave(nose)){
					save();
					return true;
				}
				if(checarLoad(nose)){
					load();
					return true;
				}
				if(checarGiveUp(nose)){
					giveup();
					return true;
				}
				if(checarBoard(nose)){
					board();
					return true;
				}
				return false;
			}

		}

