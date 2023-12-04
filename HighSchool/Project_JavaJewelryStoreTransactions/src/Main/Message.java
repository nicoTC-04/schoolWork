package Main;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTable;
import java.awt.Font;

import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
//Segunda Pantalla
public class Message extends JFrame implements MouseListener{

	private JPanel contentPane;
	
	//Variables para tabla abajo
	private String[] columnNames = {"<html><b>Tipo</b></html>", "<html><b>Codigo</b></html>", "<html><b>De</b></html>", "<html><b>Para</b></html>", "<html><b>Fecha</b></html>", ""};
	private int[][] indexes;
	private listaPedidos lista;
	private int[] ordenado;
	private Object[][] tableData;
	private DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	private Password password = new Password();
	private boolean Check;
	private String Show;
	private DefaultTableModel model;
	private JTable table;
	private JButton nuevoPedido;
	private Sort sort;
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Message frame = new Message();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Message() {
		//Algo de setup para las fechas en la tabla y la imagen de delete
		format.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		
		//cambair el cursor en el frame
		addMouseMotionListener(new MouseMotionListener() {
		    @Override
		    public void mouseMoved(MouseEvent e) {
		    	Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
		    	setCursor(cursor);	
		    }
		    
		    //metodo Obligatorio que no importa
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//iniciar el frame
		setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("recursos\\Icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 50, 450, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Imagen de logo
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon("recursos\\Logo.png"));
		lblLogo.setBounds(59, 18, 300, 145);
		getContentPane().add(lblLogo);
		
		//Boton de cambiar contraseña
		JButton changePsswrd = new JButton("Cambiar Contraseña");
		changePsswrd.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		changePsswrd.setBounds(280, 525, 136, 27);
		contentPane.add(changePsswrd);
		
		//cambiar el cursor en el boton
		changePsswrd.addMouseMotionListener(new MouseMotionListener() {
		    @Override
		    public void mouseMoved(MouseEvent e) {
		    	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		    	setCursor(cursor);
		    }

		    //metodo innecesario
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//evento de cuando se le da click al boton para cambiar la contraseña
		changePsswrd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String code = (String) JOptionPane.showInputDialog(null, "¿Cual es la nueva contraseña?", "Nueva Contraseña", JOptionPane.QUESTION_MESSAGE, new ImageIcon("recursos\\lock.png"), null, null);
				
				if(code!=null) {
					try {
						Check = password.change(code);
						if(Check) {
							Show = "Cambio de contraseña exitoso";
						} else {
							Show = "La contraseña no es valida";
						}
						JOptionPane.showMessageDialog(null, Show);
					} catch(Exception j){
						JOptionPane.showMessageDialog(null, j);
					}
				}
			}
		});
		
		//Boton para agregar nuevo pedido
		JButton nuevoPedido = new JButton("Agregar Pedido");
		nuevoPedido.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		nuevoPedido.setBounds(19, 525, 121, 27);
		contentPane.add(nuevoPedido);
		
		//cambiar el cursor en el boton
		nuevoPedido.addMouseMotionListener(new MouseMotionListener() {
		    @Override
		    public void mouseMoved(MouseEvent e) {
		    	Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		    	setCursor(cursor);
		    }

		    //metodo innecesario
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//evento de cuando se le da click al boton para cambiar la contraseña
		nuevoPedido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				pedidoForm form = new pedidoForm();
				form.setVisible(true);
			}
		});
		
		//añadir la tabla con el metodo addTabla
		addTabla();
	}

	
	//metodo para volver a leer todo y agregar la tabla nueva despues de cambiar el xml
	public void addTabla() {
		
		//reiniciar valores de la lista
		lista = new listaPedidos();
		ordenado = new int[lista.getCount()];
		tableData = new Object[lista.getCount()+1][6];
		
		
		//copiar fechas en 2 arreglos para ordenarlos despues
		indexes = new int[2][lista.getCount()];
		
		for(int j=0; j<lista.getCount(); j++) {
			indexes[0][j] = lista.getFecha(j);
			indexes[1][j] = j;
			ordenado[j] = lista.getFecha(j);
		}

			//ordenar el arreglo "ordenado" con un objeto de la clase Sort
			sort = new Sort(ordenado);
			ordenado = sort.getArr();
			
			//ordenar las fechas y generar una matriz con los valores ordenados
			tableData[0] = columnNames;
			for(int k=0; k<ordenado.length; k++) {
				for(int h=0; h<indexes[0].length; h++) {
					if(ordenado[k]==indexes[0][h]) {
						tableData[k+1][0] = lista.getTipo(h);
						tableData[k+1][1] = lista.getCodigo(h);
						tableData[k+1][2] = lista.getDe(h);
						tableData[k+1][3] = lista.getPara(h);
						tableData[k+1][4] = format.format(lista.getFecha(h)*1000L);
						tableData[k+1][5] = "<html><p style=\"color:red\"><b>&nbsp;X</b></p></html>";
						break;
					}
				}
			}
			
			//generar tabla usando la matriz anterior
			model = new DefaultTableModel(tableData, columnNames);
			table = new JTable(model);
			
			//formattear tabla
			table.setEnabled(false);
			table.setFont(new Font("Times New Roman", Font.PLAIN, 13));
			table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
			table.setBounds(19, 180, 395, 20*(lista.getCount()+1));
			table.getColumnModel().getColumn(5).setPreferredWidth(20);
			table.setRowHeight(20);
			//mouse listener para cuando se le de click al boton de eliminar
			table.addMouseListener(this);
			
			//cambiar el cursor cuando esta sobre las X
			table.addMouseMotionListener(new MouseMotionListener() {
			    @Override
			    public void mouseMoved(MouseEvent e) {
			    	int fila = table.rowAtPoint(e.getPoint());
					int columna = table.columnAtPoint(e.getPoint());
					if(columna == 5 && fila > 0) {
						Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
						setCursor(cursor);
					} else {
						Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
						setCursor(cursor);
					}
			    }

			    //metodo innecesario
				@Override
				public void mouseDragged(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			
			//añadir tabla al frame
			contentPane.add(table);
			repaint();

			
	}
	
	//evento al hacer click en la table
	@Override
	public void mouseClicked(MouseEvent e) {
		int fila = table.rowAtPoint(e.getPoint());
		int columna = table.columnAtPoint(e.getPoint());
		
		//solo cuando se da click en la columna donde estan las X
		if(columna == 5 && fila > 0) {
			int proceed = JOptionPane.showConfirmDialog(null, "Seguro que deseas eliminar el pedido?", "Eliminar", JOptionPane.YES_NO_OPTION);
			
			if(proceed == 0) {
				//for para buscar en que indice del xml esta el pedido que se desea eliminar
				for(int h=0; h<indexes[0].length; h++) {
					if(ordenado[fila-1]==indexes[0][h]) {
						//metodo delete del objeto lista
						boolean deleted = lista.delete(indexes[1][h]);
						
						//mandar mensaje si se pudo eliminar
						if(deleted) {
							JOptionPane.showMessageDialog(null, "Eliminado exitosamente");
						} else {
							JOptionPane.showMessageDialog(null, "No se pudo eliminar el pedido");
						}
						
						//eliminar y añadir una nueva tabla con los nuevos valores
						contentPane.remove(table);
						addTabla();
						break;
					}
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	//eventos innecesarios auto-generados con el mouseListener
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
