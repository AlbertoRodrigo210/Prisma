package prisma;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Prisma {
	/**declaro las variables del objeto de la clase Prisma
	 * @param base lo usamos para que el usuario introduzca la base del prisma
	 * @param alturaprisma lo usamos para introducir la altura del prisma
	 * @param nombre lo usamos para guardar la palabra prisma y el número que indique el orden en el que se ha introducido los datos
	 * @return
	 * */
	private double base;
	private double alturaprisma;
	private String nombre;
	
	static Prisma prismas;
	static ArrayList<Prisma> listaprisma= new ArrayList<>();
	static List<Double> listaarea= new ArrayList<>();
	public static void main (String [] args) {
		
		leerValor();
		
		imprimirValor();
	
	}
	
	/** aquí muestra el área con los datos introducidos del usuario
	 * @return aquí ordenamos la lista y luego la mostramos
	 * */
	private static void imprimirValor() {
		/**Ordenamos la lista que contiene los áreas*/
		listaarea.sort(null);
		/**y luego lo invertimos para poder mostrar de mayor a menor*/
		Collections.reverse(listaarea);
		
		System.out.println("\nAquí aparecen ordenados de mayor a menor");
		/**con los dos forreah mostraremos las áreas*/
		for (Double d: listaarea) { 
			
			for (Prisma e: listaprisma) {
				/**si las dos áreas de distintas listas son iguales hace lo siguiente*/
			if (e.areaTotal(e.getBase(), e.getAlturaprisma()) == d) {
				/**muestra el nombre que le hemos asignado a esa área*/
				System.out.println(e.getNombre());
			}
			}
			System.out.println("El área total: "+d);
		}
	
	}
	
	/**aquí el usuario introduce los datos
	 * @return este método es para introducir los datos y guardarlos en el objeto
	 * */
	private static void leerValor() {
		Scanner tec = new Scanner(System.in);
		
		System.out.println("------------------------------------------------------------");
		System.out.println("Introduce la cantidad de veces que quieres calcular el área: ");
		/** Ahora pedimos al usuario que introduzca la variable numero
		 * @numero el usuario introduce el número de veces que quiere calcular el área total de un prisma
		 * */
		int numero = tec.nextInt();
		for (int i = 0; i < numero; i++ ) {
		System.out.println("\n____________________________________________________________");
		System.out.println("Introduce los datos para calcular el prisma");
		/**introducimos los datos necesarios para todos los calculos*/
		double base = 0;
		
		boolean seguir1 = true;
		//introducir solo números
		while (seguir1) {
			try {
				System.out.println("Introduce la longitud de la base del triángulo: ");
				base = tec.nextDouble(); 
				seguir1 = false;
	
			} catch (java.util.InputMismatchException e) {
		
				System.err.println("\nIntroduce solo números, por favor"); 
				tec.nextLine();
															}
						}
		
		double alturaprisma = 0;
		
		seguir1 = true;
		//introducir solo números
		while (seguir1) {
			try {
				System.out.println("Introduce la altura del prisma: ");
				alturaprisma = tec.nextDouble();
				seguir1 = false;
	
			} catch (java.util.InputMismatchException e) {
		
				System.err.println("\nIntroduce solo números, por favor"); 
				tec.nextLine();
															}
						}
		
		/**usamos el string nombre para poner el orden en el que se han insertado los datos concadenandolo con la palabra Prisma*/
		String nombre = "Prisma" + (i+1);
		
		/**creamos el objeto*/
		prismas = new Prisma(base, alturaprisma); 
		/**hacemos las modificaciones en cada uno de ellos*/
		prismas.setBase(base);
		prismas.setAlturaprisma(alturaprisma);
		prismas.setNombre(nombre);
		/**y lo añadimos a la lista*/
		listaprisma.add(prismas);
		
		System.out.println("El área total "+prismas.getNombre()+" es "+prismas.areaTotal(base, alturaprisma));
		/**añadimos a una lista distinta el área calculado*/
		listaarea.add(prismas.areaTotal(base, alturaprisma));
		}
		
		
		tec.close();
	}
	
	/**creo el constructor*/
	Prisma(double base, double alturaprisma) {
		this.base = base;
		this.alturaprisma = alturaprisma;
	}
	
	
	/**hago los getters and setters
	 * @return aquí es para guardar los nuevos objetos o para mostrarlos por ejemplo
	 * */
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getAlturaprisma() {
		return alturaprisma;
	}
	public void setAlturaprisma(double alturaprisma) {
		this.alturaprisma = alturaprisma;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	/**creo todos los métodos necesarios para calcular el areaTotal
	 * @return este es el último método que se usa en este programa
	 * @param base necesita la base introducido
	 * @param alturaprisma necesita la altura del prisma introducido 
	 * */
	public double areaTotal(double base, double alturaprisma) {
		double areatotal = 2 * this.areaBase(base) + this.areaLateral(base, alturaprisma);
		return areatotal;
	}

	/**aquí calculamos el área lateral
	 * @return calcula el área total para despues poder  calcula el area total
	 * @param base necesita la base introducido
	 * @param alturaprisma necesita la altura del prisma introducido
	 * */
	public double areaLateral(double base, double alturaprisma) { 
		double arealateral = this.perimetro(base) * alturaprisma;
		return arealateral;
	}

	/**aquí calculamos el perímetro
	 * @return para calcular el areatotal necesitamos el perímetro
	 * @param base necesita la base introducido
	 * */
	public double perimetro(double base) { 
		 double perimetro = 3 * base;
		return perimetro;
	}

	/**aquí calculamos el area base
	 * @return para calcular el areatotal también se necesita el areabase
	 * @param base necesita la base introducida
	 * */
	public double areaBase(double base) { 
		double areabase = (base * this.alturaTriangulo(base)) / 2;
		return areabase;
	}

	/**aquí calculamos la altura del triángulo
	 * @return pero para calcular el areaBase necesito la alturaTriangulo
	 * @param base necesita la base introducida
	 * */
	public double alturaTriangulo(double base) {
		double alturatriangulo = (Math.sqrt(3) * base) /2;
		return alturatriangulo;
	}
	
}