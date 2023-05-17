
/*NOMBRE:Ivonne Estefanía Hernández Pérez
 * GRUPO:412
 * ACTIVIDAD: Reto 1 del ordinario, 
 * */

//import java.util.StringTokenizer;

public class Precio {
	private String precio;
	private String precioLetra;
	private final String[] DECENAS = { "","","veinti", "treinta", "cuarenta", "cincuenta", "sesenta","setenta",
			"ochenta", "noventa" };
	private final String[] UNIDADES = { "", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve" };
	private final String[] UNIDADESESPECIALES = {"once", "doce", "trece", "catorce", "quince", "dieciseis", "diecisiete", "dieciocho",
			"diecinueve"};
	private final String[] CENTENAS = { "", "ciento ", "doscientos ", "trecientos ", "cuatrocientos ", "quinientos ",
			"seiscientos ", "setecientos ", "ochocientos ", "novecientos " };
	public void setPrecio(String precio) {
		this.precio=precio; 
		
		String númeroEntero[] = precio.split(".");
		String númeroDecimal = númeroEntero[1];
		int conversiónDecimal = Integer.parseInt(númeroDecimal);
		int conversiónEntero = Integer.parseInt(númeroEntero[0]);
		this.precioLetra = conversiónNúmeroEntero(conversiónEntero) + " " +  conversiónDecimal + "/100 M.N";
	}

	public String getPrecio() {
		return precio;
	}

	public String getPrecioLetra() {
		return precioLetra;
	}

	private String conversiónNúmeroEntero(int conversiónEntero) {
		int númeroEnteroMódulo = conversiónEntero % 1000;
		String númeroMódulo = Integer.toString( númeroEnteroMódulo);
		int númeroEntero = conversiónEntero / 1000;
		String númeroMóduloEntero = Integer.toString(númeroEntero);
		
		
		//if (valorEntero == 1000) {
		//	return "mil";
		//}else 
		if (conversiónEntero >= 1000 && conversiónEntero < 2000) {
			return " mil " +  conversiónNúmeroCompleta(númeroMódulo);
		}else if (conversiónEntero> 1000) {
			return  conversiónNúmeroCompleta(númeroMóduloEntero ) + " mil " + conversiónNúmeroCompleta(númeroMódulo);
		} else {
			return  conversiónNúmeroCompleta(númeroMódulo );
		}
	}


	private String conversiónNúmeroCompleta(String  númeroIngresado) {
		int parteNúmero = Integer.parseInt(númeroIngresado);
		int resultadoCentena = (parteNúmero/100);
		int resultadoMóduloCentena = (parteNúmero%100);
		int resultadoDecena=  resultadoMóduloCentena / 10;
		int resultadoMóduloDecena = (parteNúmero%10);
		String númeroCentena = Integer.toString(resultadoCentena);
		String númeroDecena = Integer.toString (resultadoDecena);
		if (parteNúmero == 100) {
			return "cien";
		}
		else {
			return conversiónNúmeroCentena (resultadoCentena ) + conversiónNúmeroDecena(númeroDecena);
		}

	}
	private String conversiónNúmeroCentena(int valorEntero) {
		return CENTENAS[valorEntero];

	}
	

	private String conversiónNúmeroDecena(String  númeroIngresado) {
		String parteUnoNúmero = númeroIngresado.substring(0);
		String parteDosNúmero = númeroIngresado.substring(1);
		int parteUnoNúm = Integer.parseInt(parteUnoNúmero);
		int parteDosNúm = Integer.parseInt(parteDosNúmero);
		if (parteUnoNúm == 1 && (parteDosNúm >= 1 && parteDosNúm <= 9)) {
			return UNIDADESESPECIALES[parteDosNúm];
			
		}else if (parteUnoNúm == 1 && parteDosNúm ==0) {
			return "diez" ;
		}else if (parteUnoNúm == 2 && parteDosNúm ==0){
			return "veinte";
		}else {
			return DECENAS [parteUnoNúm] + UNIDADES[parteDosNúm];
		}
			
	}
	

}