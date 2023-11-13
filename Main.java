package org.generation.italy;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String scelta,singlav;
		String[] arrayinterventi ={"sostituzione pastiglie freni","cambio dell'olio","sostituzione filtro dell'aria","cambio cinghia di distribuzione","regolazione minimo"};
		int[] arraycosti= {50,30,20,150,25};
		String[] ricambi = {"pastiglie freno Bosch","pastiglie freno Brembo","filtro aria Opel","filtro aria Mercedes","olio diesel GW312"};
		int[] costiric= {200,500,65,90,18};
		int numlav=0,tot=0;
		ArrayList<String> lavori= new ArrayList<>();
		ArrayList<Integer> costilavori= new ArrayList<>();
		ArrayList<Integer> quanti= new ArrayList<>();
		do
		{
			
			System.out.println("Inserire l'intervento effettuato: ");
			singlav=sc.nextLine();
			
			for(int i=0;i<arrayinterventi.length;i++)			//for per controllare se l'input ha riscontri nell'array dei lavori
			{
				if (singlav.equals(arrayinterventi[i]))
					{
					System.out.println("Inserire la durata dell'intervento: ");
					quanti.add(Integer.parseInt(sc.nextLine()));
					lavori.add(singlav);							// se il lavoro in input c'è nell'array allora lo aggiungo all'arraylist
					costilavori.add(arraycosti[i]);					// aggiungo il costo del lavoro all'indice i ad un altro arraylist
					numlav=numlav+1;								// aumento il contatore dei lavori per evitare scontrini nulli
					}
				else
				{
					if (singlav.equals(ricambi[i]))
					{
						System.out.println("Inserire la quantità dei ricambi: ");
						quanti.add(Integer.parseInt(sc.nextLine()));
						lavori.add(singlav);							// se il lavoro in input c'è nell'array allora lo aggiungo all'arraylist
						costilavori.add(costiric[i]);					// aggiungo il costo del ricambio all'indice i ad un altro arraylist
						numlav=numlav+1;								// aumento il contatore dei lavori per evitare scontrini nulli
					}
				}
			}
			System.out.println("Che vuoi fare adesso?");
			System.out.println("Vuoi inserire un altro intervento? ");
			scelta=sc.nextLine();
			if (scelta.equals("no"))
				break;
		}
		while(scelta.equals("si"));
		
		if (numlav==0)
			System.out.println("Scontrino nullo! ");
		else 
		{
		System.out.println("FATTURA GENERATA:"+"\n"+"DESCRIZIONE"+"\t"+"QUANTITA'"+"\t"+"COSTO");
		for(int i=0;i<lavori.size();i++)
		{
			System.out.println(lavori.get(i)+ "\t" +quanti.get(i)+"\t"+costilavori.get(i)*quanti.get(i)+"\n"); 
			tot=tot+(costilavori.get(i)*quanti.get(i));
		}
		for(int i=0;i<costilavori.size();i++)
			tot=tot+costilavori.get(i);
		System.out.println("Totale fattura: "+tot+"€");	
		}
		
		
		
	}

}