import java.util.Scanner;

public class main {

	public static void main(String[] args) {	
		Scanner entrada=new Scanner(System.in);
	    
	    int x,y;//largo y alto
	    int m = 0;
	    String nombre = null;//nombre de usuario
	    int tInicial = 0;//tamanio inicial del snake
	    int largo=0;
	    String[][] tablero;
	    String[] snake;
	    int posicionX;
	    int posicionY;
	    int randomX,randomY;
	    boolean jugar;
	    String movimiento;
	    int punteo=0;
	    String[] historial=new String[1];
	    int[] historial2=new int[3];
	   boolean menu=true;
	   
	    while(menu) {
	    System.out.println("Elige una opcion");
	    System.out.println("1. Inicio del juego"+"\n"+"2. Datos del estudiante"+"\n"+
					"3. Historial de partidas jugadas"+"\n"+"4. Salir");
	    int opcion=entrada.nextInt();
	       
			while((opcion<1)||(opcion>4)) {
				System.out.println("Opcion no valida");
			
				opcion=entrada.nextInt();			
			}
			
			switch(opcion) {
			case 1:				
	   
	      System.out.println("Introduce tu nombre");
				nombre=entrada.next();
				
	      System.out.println("Introduce el tamanio del tablero");
				m=entrada.nextInt();
				
	      while(m<10) {
					System.out.println("el largo minimo debe ser de 10");
					System.out.println("Introduce un largo");
					m=entrada.nextInt();
				}
				
	      System.out.println("Introduce el tamanio inicial del Snake");
	      tInicial=entrada.nextInt();
	      
	      while((tInicial<=0)||(tInicial>=m)){
	        System.out.println("El tamanio minimo debe ser 1 y no mayor que "+(m-1));
	        System.out.println("Introduce el tamanio inicial del Snake");
	        tInicial=entrada.nextInt();
	      }
	      largo=tInicial;
	      
	      
	      snake=new String[1];
	      posicionX=m/2;
	      posicionY=m/2;
	      randomX=(int)(Math.random()*(m))-1;
	      randomY=(int)(Math.random()*(m))-1;
	      tablero=new String[m+2][m+2];
	      
	      jugar=true;
	      
	      while(jugar) {
	    	   System.out.println(punteo+"         "+nombre);
	    	   for(int i=0;i<m+2;i++) {
				System.out.println();
				for(int j=0;j<m+2;j++) {	
					if((i==0)||(j==0)||(i==m+1)||(j==m+1)) {
						tablero[i][j]="#";
					}
					else {
	          if((i==posicionY)&&(j==posicionX)){
	          
	        	for(int k=0;k<tInicial;k++) {
	        		snake[k]="@";
	        		System.out.print(snake[k]);
	          	}
	            
	  }
	          else{
	            if((i==randomX)&&(j==randomY)){
	            	tablero[i][j]="*";
	            }
	            else{
	            	tablero[i][j]=" ";
	            }
	          }
	}
	        System.out.print(tablero[i][j]+" ");
				}
			}
	      
	      switch(movimiento=entrada.next()){
	      	case"a":
	      		posicionX=posicionX-1;
        		
	      		break;
	      	case "d":
	      		posicionX=posicionX+1;
	      		break;
	      	case "w":
	      		posicionY=posicionY-1;
	      		if(tInicial>1) {
        		}
	      		break;
	      	case "s":
	      		posicionY=posicionY+1;
	      		break;
	      }
	      
	     if((posicionX==0)||(posicionY==0)||(posicionX==m+1)||(posicionY==m+1)) {
	    	 System.out.println("perdiste");
	    	 jugar=false;
	     }
	     if((posicionX==randomY)&&(posicionY==randomX)) {
	    	  tInicial=tInicial+1;
	    	  snake=new String[tInicial];
	    	  randomX=(int)(Math.random()*(m))-1;
		      randomY=(int)(Math.random()*(m))-1;
		      
	      }
	    
	    }
	      
				break;
			
			case 2:
	      System.out.println("Eulalio Ernesto Tzul Perez"+"\n"+"Carne: 201602904");
			
				break;
			
			case 3:
				historial[0]=nombre;
				historial2[0]=punteo;
				historial2[1]=m;
				historial2[2]=largo;
				System.out.println("nombre jugador: "+historial[0]);
				System.out.println("Punteo: "+historial2[0]);
				System.out.println("tamaño del tablero: "+historial2[1]);
				System.out.println("tamaño inicial del snake: "+historial2[2]);
				break;
			
			case 4:
				menu=false;
				break;
			}
	    }
		
	}

}
