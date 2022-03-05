
import controlador.ControladorCliente;
import modelo.ClienteCRUD;
import vista.ClienteVistaGUI;

public class Principal {
    public static void main(String[] args) {
        ClienteVistaGUI vista = new ClienteVistaGUI();
        ClienteCRUD modelo = new ClienteCRUD();
        ControladorCliente controlador = new ControladorCliente(vista,modelo);
    }
}