package controller;

import java.util.concurrent.Semaphore;

public class CarroThread extends Thread{
	int Carro;
	String Direcao;
	Semaphore semaforo;
	double tempoInicial, tempoFinal, tempoTotal;
	
	// passando parametros do metodo 
	public CarroThread(String Direcao, Semaphore semaforo){
		this.Carro = (int)this.getId();
		this.Direcao = Direcao;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		try {
			//permitindo o acesso ao recurso
			semaforo.acquire();
		}catch(Exception a) {
			a.printStackTrace();
		}finally {
			semaforo.release();
		}
		//carro podendo cruzar 
		CarroCruzando();
	}
	private void CarroCruzando() {
		tempoFinal = System.nanoTime();
		tempoTotal = tempoFinal - tempoInicial;
		tempoTotal = tempoTotal / Math.pow(10, 9);
		//System.out.println("O carro"+Carro+"Ficou aguardando no cruzamento"+tempoTotal+"segundos e cruzou na direção"+Direcao);
	}
}
