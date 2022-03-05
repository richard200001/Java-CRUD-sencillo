package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public class ClienteVistaGUI extends JFrame {
    private JButton bIngresar, bMostrar, bBorrar, bActu, bfiltro, blimpiar;
    private JLabel lNombre, lCc;
    private JTextField tfNombre, tfCc;
    private JTextArea area;
    private JScrollPane barra;
    private JPanel pDatos, pBotones;
    private int contador;
    
    public ClienteVistaGUI()
    {
      super("Programa de Comunicación con BD"); //Se pone el nombre al frame
      initComponents(); //método que construye todos los componentes del frame
    }

    //metodo llamado desde el constructor para crear el frame
    public void initComponents()
    {
        tfNombre = new JTextField(10);
        tfCc = new JTextField(10);
        lNombre = new JLabel("Nombre: ");
        lCc = new JLabel("CC: ");
        pDatos = new JPanel();
        pDatos.setLayout(new GridLayout(1,4,2,2)); //grid de 1X4 con separación de 2 horizontal y 2 vertical entre los elementos del grid
        //Se adicionan los campos y las etiquetas al panel de datos
        pDatos.add(lNombre);
        pDatos.add(tfNombre);
        pDatos.add(lCc); 
        pDatos.add(tfCc);
        
        //se define el tamaño del área de texto y se agrega a la barra.
        area = new JTextArea(20,10);
        barra = new JScrollPane(area);
        
        bIngresar = new JButton("Ingresar");
        bMostrar  = new JButton("Mostrar Registros");
        bBorrar   = new JButton("Borrar");
        bActu     = new JButton("Actualizar");
        bfiltro     = new JButton("Filtrar");
        blimpiar    = new JButton("Limpiar");
        
        //Se adicionan los botones al panel botones
        pBotones = new JPanel();
        pBotones.setLayout(new GridLayout(2,4,2,2)); //grid de 1X4 con separación de 2 horizontal y 2 vertical entre los elementos del grid
        pBotones.add(bIngresar);
        pBotones.add(bActu);
        pBotones.add(bBorrar);
        pBotones.add(bMostrar);
        pBotones.add(bfiltro);
        pBotones.add(blimpiar);
        
        //Al frame se le define una distribución BorderLayout(tiene 5 áreas - una superior - 3 en el centro y una inferior)
        setLayout(new BorderLayout());
        
        //se adicionan los paneles al frame
        
        add(pDatos,BorderLayout.NORTH);
        add(barra,BorderLayout.CENTER);
        add(pBotones,BorderLayout.SOUTH);
        
        pack();//se ajusta el frame al tamaño de los componentes adicionados
        setVisible(true); //se hace visible el frame
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Cuando se cierra la ventana se libra la memoria
    }
    
    
    //métodos para acceder a los atributos privados del frame

    public JButton getBfiltro() {
        return bfiltro;
    }

    public JButton getBlimpiar() {
        return blimpiar;
    }
    
    public JButton getbIngresar() {
        return bIngresar;
    }

    public JButton getbMostrar() {
        return bMostrar;
    }

    public JButton getbBorrar() {
        return bBorrar;
    }

    public JButton getbActu() {
        return bActu;
    }
    
    public String getNombre(){
        return tfNombre.getText().trim();//trim - elimina dos espacio al inicio y al final de la cadena
    }
    
    public String getcc(){
        return tfCc.getText().trim();//trim - elimina dos espacio al inicio y al final de la cadena
    }
    
    public void mostrarCampos(List lista){
        contador=0;
        lista.forEach((unRegistro) -> {
            area.append(unRegistro.toString()); //adiciona el nuevo texto al texto ya existente
            
            contador++;
            System.out.println(contador);
            if(contador%2==0 && contador!=0){
                area.append("\n");
            }
        });
        contador=0;
    }
    
    public void mostrarSalida(String valor)
    {
        area.setText(valor); //Borra lo que hay y le adiciona un nuevo texto
    }
    
    public void borrar()
    {
        area.setText(""); //Borra lo que hay y le adiciona un nuevo texto
    }
    
    public void filtro(List lista)
    {
        
      
      
        
         contador=0;
        lista.forEach((unRegistro) -> {
            //area.append(unRegistro.toString()); //adiciona el nuevo texto al texto ya existente
            
            //System.out.println(unRegistro);
            //String s=tfNombre.getText();
            String s1=String.valueOf(tfCc.getText());
            //String s2=String.valueOf(unRegistro);
            //System.out.println(tfNombre.getText()+"jaja");
           // System.out.println(s1+"jaja1");
          // System.out.println(s2);(unRegistro.toString()).contains(tfNombre.getText()+s1) || 
           // System.out.println(s1+"  "+tfNombre.getText());
            if((unRegistro.toString()).contains(tfNombre.getText()+s1) || (unRegistro.toString().contains(tfNombre.getText()) && unRegistro.toString().contains(s1) )){
              
                    area.append(unRegistro.toString());
               // System.out.println("AY CARAMBA");
               contador++;
                System.out.println(contador);
                if(contador%2==0 && contador!=0){
                    area.append("\n");
                }
             
                
            }
            
        });
          contador=0;
    }
    
    // escuchas de acción
    
    public void asignarEscuchas(ActionListener evento){
        bMostrar.addActionListener(evento);
        bIngresar.addActionListener(evento);
        bBorrar.addActionListener(evento);
        bActu.addActionListener(evento);
        bfiltro.addActionListener(evento);
        blimpiar.addActionListener(evento);
    }
}
