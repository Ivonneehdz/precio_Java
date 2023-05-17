
/*NOMBRE:Ivonne Estefan�a Hern�ndez P�rez
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
		
		String n�meroEntero[] = precio.split(".");
		String n�meroDecimal = n�meroEntero[1];
		int conversi�nDecimal = Integer.parseInt(n�meroDecimal);
		int conversi�nEntero = Integer.parseInt(n�meroEntero[0]);
		this.precioLetra = conversi�nN�meroEntero(conversi�nEntero) + " " +  conversi�nDecimal + "/100 M.N";
	}

	public String getPrecio() {
		return precio;
	}

	public String getPrecioLetra() {
		return precioLetra;
	}

	private String conversi�nN�meroEntero(int conversi�nEntero) {
		int n�meroEnteroM�dulo = conversi�nEntero % 1000;
		String n�meroM�dulo = Integer.toString( n�meroEnteroM�dulo);
		int n�meroEntero = conversi�nEntero / 1000;
		String n�meroM�duloEntero = Integer.toString(n�meroEntero);
		
		
		//if (valorEntero == 1000) {
		//	return "mil";
		//}else 
		if (conversi�nEntero >= 1000 && conversi�nEntero < 2000) {
			return " mil " +  conversi�nN�meroCompleta(n�meroM�dulo);
		}else if (conversi�nEntero> 1000) {
			return  conversi�nN�meroCompleta(n�meroM�duloEntero ) + " mil " + conversi�nN�meroCompleta(n�meroM�dulo);
		} else {
			return  conversi�nN�meroCompleta(n�meroM�dulo );
		}
	}


	private String conversi�nN�meroCompleta(String  n�meroIngresado) {
		int parteN�mero = Integer.parseInt(n�meroIngresado);
		int resultadoCentena = (parteN�mero/100);
		int resultadoM�duloCentena = (parteN�mero%100);
		int resultadoDecena=  resultadoM�duloCentena / 10;
		int resultadoM�duloDecena = (parteN�mero%10);
		String n�meroCentena = Integer.toString(resultadoCentena);
		String n�meroDecena = Integer.toString (resultadoDecena);
		if (parteN�mero == 100) {
			return "cien";
		}
		else {
			return conversi�nN�meroCentena (resultadoCentena ) + conversi�nN�meroDecena(n�meroDecena);
		}

	}
	private String conversi�nN�meroCentena(int valorEntero) {
		return CENTENAS[valorEntero];

	}
	

	private String conversi�nN�meroDecena(String  n�meroIngresado) {
		String parteUnoN�mero = n�meroIngresado.substring(0);
		String parteDosN�mero = n�meroIngresado.substring(1);
		int parteUnoN�m = Integer.parseInt(parteUnoN�mero);
		int parteDosN�m = Integer.parseInt(parteDosN�mero);
		if (parteUnoN�m == 1 && (parteDosN�m >= 1 && parteDosN�m <= 9)) {
			return UNIDADESESPECIALES[parteDosN�m];
			
		}else if (parteUnoN�m == 1 && parteDosN�m ==0) {
			return "diez" ;
		}else if (parteUnoN�m == 2 && parteDosN�m ==0){
			return "veinte";
		}else {
			return DECENAS [parteUnoN�m] + UNIDADES[parteDosN�m];
		}
			
	}
	

}