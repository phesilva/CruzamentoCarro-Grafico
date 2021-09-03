package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.concurrent.Semaphore;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CarroThread;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tela extends JFrame {

	private JPanel contentPane;
	private ImageIcon imgIcon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela frame = new tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		//variavel com as direcoes
		int[] painelDirecao = {1,2,3,4};
		
		String[] direcoes = {"Cima para baixo","Esquerda para direita","Direita para esquerda","Baixo para cima"};
		Semaphore semaforo = new Semaphore(1);
		
		for(int i = 1; i<5;i++) {
			CarroThread carro = new CarroThread(direcoes[i-1], semaforo);
			carro.start();
		}
	}

	/**
	 * Create the frame.
	 */
	public tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setUndecorated(true); // tira a borda superior com os três botões do windows
		
		Icon ico = new ImageIcon("src/carrinho.gif");
		JLabel label = new JLabel(ico);
		
		JButton btnNewButton = new JButton("Iniciar Cruzamento");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(151, 242, 229, 56);
		contentPane.add(btnNewButton);
		this.setSize(550,550);
		this.setResizable(false);
	}
	//metodo pra movimentar com o cursor do mouse o carrinho
	private void imagemMouseDragged(java.awt.event.MouseEvent evt) {
		
	}
	//tentativa de colocar a imagem pra ser inserida por um metodo sad#
	public void ImgPanel() {
		imgIcon = new ImageIcon("carrinho.gif");
	}
}
