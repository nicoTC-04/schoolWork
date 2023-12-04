package Main;

public class Sort {
	private int[] array;
	
	//Constructor donde se inserta el arreglo
	public  Sort(int[] arreglo) {
		this.array = arreglo;
	}
	
	//Donde se regresa el arreglo y se hace todo el sort
	public int[] getArr() {
		this.mergeSort(this.array, 0, this.array.length - 1);
		return this.array;
	}
	
	//Metodo que crea los mini-arrays que se ordenan
	private void mergeSort(int[] arr, int izq, int der) {
		int medio;
		
		//Se detiene cuando no se puede dividir mas el arreglo
		if(izq < der) {
			medio = (izq + der) / 2;
			
			mergeSort(arr, izq, medio);   //Arreglo de la izquierda
			mergeSort(arr, medio + 1, der);   //Arreglo de la derecha
			
			merge(arr, izq, medio, der);   //Combinar los 2 subarreglos
		}
	}
	
	//Metodo principal que ordena todo
	private void merge(int[] arr, int izq, int medio, int der) {
		//Tamaños de los 2 sub-arreglos
		int bajo = medio - izq + 1;
		int alto = der - medio;
		
		//Crear los 2 sub-arreglos
		int[] I = new int[bajo];
		int[] D = new int[alto];
		
		int i = 0, j = 0;
		
		//Llenar los 2 sub-arreglos
		for(i=0; i<bajo; i++) {
			I[i] = arr[izq+i];
		}
		for(j=0; j<alto; j++) {
			D[j] = arr[medio+1+j];
		}
		
		//comparar y acomodar los 2 arreglos
		int k = izq;
		i = 0;
		j = 0;
		
		while(i<bajo && j<alto) {
			if(I[i] <= D[j]) {
				arr[k] = I[i];
				i++;
			} else {
				arr[k] = D[j];
				j++;
			}
			k++;
		}
		
		while(i<bajo) {
			arr[k] = I[i];
			i++;
			k++;
		}
		
		while(j<alto) {
			arr[k] = D[j];
			j++;
			k++;
		}
	}
}
