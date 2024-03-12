package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class RedesController {
	
	public RedesController () {
		super(); 
	}
	
	private String os() {
		String os = System.getProperty("os.name");
		System.out.println(os);
		return os; 
	}
	
	public void IP() {
		if(os().contains("Windows")) {
			String [] process = {"IPCONFIG"}; 
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream(); 
				InputStreamReader leitor = new InputStreamReader(fluxo); 
				BufferedReader buffer = new BufferedReader(leitor);  
				String linha = buffer.readLine();
				while(linha != null) {
					if(linha.contains("Adaptador")) {
						System.out.println(linha);
					}
					if(linha.contains("IPv4")) {
						System.out.println(linha);
					}
					linha = buffer.readLine();	
				}
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}  	   
		}else if(os().contains("Linux")) {
			String [] process = {"ifconfig"}; 
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream(); 
				InputStreamReader leitor = new InputStreamReader(fluxo); 
				BufferedReader buffer = new BufferedReader(leitor);  
				String linha = buffer.readLine();
				while(linha != null) {
					if(linha.contains("Adaptador")) {
						System.out.println(linha);
					}
					if(linha.contains("IPv4")) {
						System.out.println(linha);
					}
					linha = buffer.readLine();	
				}
				buffer.close();
				leitor.close();
				fluxo.close();
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}  	   
		}else{
			JOptionPane.showMessageDialog(null, "Identificação de Sistema Operacional não pode identificar o sistema atual");
		}
		}
	
	public void ping() {
		if(os().contains("Windows")) {
			String process = "ping -4 -n 10 www.google.com.br"; 
			
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream(); 
				InputStreamReader leitor = new InputStreamReader(fluxo); 
				BufferedReader buffer = new BufferedReader(leitor);  
				String linha = buffer.readLine();
				String soma; 
				int soma1 = 0; 
				int qt = 0; 
				
				while(linha != null) {
					String [] vetor = linha.split(" ");
					int tamanho = vetor.length; 
				
					
					for(int i=0; i<tamanho; i++) {
						if (vetor[i].contains("ms,")) {
							linha = buffer.readLine();	
							
						}else if(vetor[i].contains("ms")) {
												
							soma = (vetor[i]); 	
							String [] aux1 = soma.split("tempo=");

							int tamanho2 = aux1.length;	
							
							for(int j=0; j<tamanho2; j++) {
								String [] aux2 = aux1[j].split("ms");
								int tamanho3 = aux2.length; 
								
								for(int k=0; k<tamanho3; k++) {
									if (aux2[k]!="" && aux2[k]!=",") {
										soma1 = soma1 + Integer.parseInt(aux2[k]);
										qt++; 
										System.out.println("Tempo médio do Ping "+ soma1/qt);
									}
								}
							}
						}
					}
					
					linha = buffer.readLine();	
				}
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}  	   
		}else if(os().contains("Linux")) {
			String process = "ping -4 -c 10 www.google.com.br"; 
			
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream(); 
				InputStreamReader leitor = new InputStreamReader(fluxo); 
				BufferedReader buffer = new BufferedReader(leitor);  
				String linha = buffer.readLine();
				String soma; 
				int soma1 = 0; 
				int qt = 0; 
				
				while(linha != null) {
					String [] vetor = linha.split(" ");
					int tamanho = vetor.length; 
				
					
					for(int i=0; i<tamanho; i++) {
						if (vetor[i].contains("ms,")) {
							linha = buffer.readLine();	
							
						}else if(vetor[i].contains("ms")) {
												
							soma = (vetor[i]); 	
							String [] aux1 = soma.split("tempo=");

							int tamanho2 = aux1.length;	
							
							for(int j=0; j<tamanho2; j++) {
								String [] aux2 = aux1[j].split("ms");
								int tamanho3 = aux2.length; 
								
								for(int k=0; k<tamanho3; k++) {
									if (aux2[k]!="" && aux2[k]!=",") {
										soma1 = soma1 + Integer.parseInt(aux2[k]);
										qt++; 
										System.out.println("Tempo médio do Ping "+ soma1/qt);
									}
								}
							}
						}
					}
					
					linha = buffer.readLine();	
				}
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}  	   
		}else{
			JOptionPane.showMessageDialog(null, "Identificação de Sistema Operacional não pode identificar o sistema atual");
		}
		}
	
	}
	
	


