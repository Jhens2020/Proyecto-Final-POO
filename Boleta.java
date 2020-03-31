import java.awt.*;
import javax.swing.*;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;

//import java.awt.event.*;
import javax.swing.table.*;

import herencia.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Boleta extends JFrame {

    private static final long serialVersionUID = 1L;
    

    int comprobanteIdF = 0;
    FacturaDatos facturaDatos = new FacturaDatos();
    String[] comprobanteColumnsF = { "Id","Cliente","Productos","Fecha","Precio Unitario", "Precio Total","Ruc"};
    String[][] comprobanteMatrizF = new String[0][comprobanteColumnsF.length];
    DefaultTableModel model3 = new DefaultTableModel(comprobanteMatrizF, comprobanteColumnsF);
    JTable comprobanteTableF = new JTable(model3);
    JScrollPane comprobanteSPF = new JScrollPane();

    int comprobanteId = 0;
    BoletaDatos boletaDatos = new BoletaDatos();
    String[] comprobanteColumns = { "Id","Cliente","Productos","Fecha","Precio Unitario", "Precio Total","Documento"};
    String[][] comprobanteMatriz = new String[0][comprobanteColumns.length];
    DefaultTableModel model4 = new DefaultTableModel(comprobanteMatriz, comprobanteColumns);
    JTable comprobanteTable = new JTable(model4);
    JScrollPane comprobanteSP = new JScrollPane();

    public Boleta() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("CRUD");
        JMenu m2 = new JMenu("AYUDA");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Factura");
        JMenuItem m12 = new JMenuItem("Boleta");
        JMenuItem m19 = new JMenuItem("Salir");

        //Crud Factura
        JPanel comprobantePanelF = new JPanel();
        comprobantePanelF.setLayout(new BoxLayout(comprobantePanelF, BoxLayout.Y_AXIS));

        JLabel comprobanteLblClienteF = new JLabel("Ingrese el Cliente:");
        JTextField comprobanteTxtClienteF = new JTextField();

        JLabel comprobanteLblProductosF = new JLabel("Ingrese los Productos:");
        JTextField comprobanteTxtProductosF = new JTextField();

        JLabel comprobanteLblFechaF = new JLabel("Ingrese la Fecha:");
        JTextField comprobanteTxtFechaF = new JTextField();

        JLabel comprobanteLblPrecioUF = new JLabel("Ingrese el Precio Unitario:");
        JTextField comprobanteTxtPrecioUF = new JTextField();

        JLabel comprobanteLblPrecioTF = new JLabel("Ingrese el Precio Total:");
        JTextField comprobanteTxtPrecioTF = new JTextField();

        JLabel comprobanteLblRuc = new JLabel("Ingrese el ruc");
        JTextField comprobanteTxtRuc = new JTextField();

        JButton btnadd3 = new JButton("Agregar");
        JButton button3;
        button3 = new JButton("Eliminar");

        comprobanteSPF.setViewportView(comprobanteTableF);

        comprobantePanelF.add(comprobanteLblClienteF);
        comprobantePanelF.add(comprobanteTxtClienteF);

        comprobantePanelF.add(comprobanteLblProductosF);
        comprobantePanelF.add(comprobanteTxtProductosF);

        comprobantePanelF.add(comprobanteLblFechaF);
        comprobantePanelF.add(comprobanteTxtFechaF);

        comprobantePanelF.add(comprobanteLblPrecioUF);
        comprobantePanelF.add(comprobanteTxtPrecioUF);

        comprobantePanelF.add(comprobanteLblPrecioTF);
        comprobantePanelF.add(comprobanteTxtPrecioTF);

        comprobantePanelF.add(comprobanteLblRuc);
        comprobantePanelF.add(comprobanteTxtRuc);

        comprobantePanelF.add(btnadd3);
        comprobantePanelF.add(button3);
        comprobantePanelF.add(comprobanteSPF);

        btnadd3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprobanteIdF++;
                Factura d = new Factura();

                // crea la tabla
                d.setId(comprobanteIdF);
                d.setCliente(comprobanteTxtClienteF.getText());
                d.setProductos(comprobanteTxtProductosF.getText());
                d.setFecha(comprobanteTxtFechaF.getText());
                d.setPrecioU(comprobanteTxtPrecioUF.getText());
                d.setPrecioT(comprobanteTxtPrecioTF.getText());
                d.setRuc(comprobanteTxtRuc.getText());

                facturaDatos.create(d);

                List<Factura> miLista = facturaDatos.list();
                comprobanteMatrizF = new String[miLista.size()][comprobanteColumnsF.length];
                for (int i = 0; i < miLista.size(); i++) {
                    comprobanteMatrizF[i][0] = miLista.get(i).getId() + "";
                    comprobanteMatrizF[i][1] = miLista.get(i).getCliente() + "";
                    comprobanteMatrizF[i][2] = miLista.get(i).getProductos() + "";
                    comprobanteMatrizF[i][3] = miLista.get(i).getFecha() + "";
                    comprobanteMatrizF[i][4] = miLista.get(i).getPrecioU() + "";
                    comprobanteMatrizF[i][5] = miLista.get(i).getPrecioT() + "";
                    comprobanteMatrizF[i][6] = miLista.get(i).getRuc() + "";
                }
                model3 = new DefaultTableModel(comprobanteMatrizF, comprobanteColumnsF);
                comprobanteTableF = new JTable(model3);
                comprobanteSPF.setViewportView(comprobanteTableF);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (comprobanteTableF.getSelectedRow() != -1) {
                    String ids = null;
                    int[] row = comprobanteTableF.getSelectedRows();
                    ids = (String) comprobanteTableF.getValueAt(row[0], 0);
                    System.out.println("Table element selected es: " + ids);
                    int id = Integer.parseInt(ids);
                    comprobanteTxtClienteF.setText(" " + id);

                    model3.removeRow(comprobanteTableF.getSelectedRow());
                    try {
                        facturaDatos.delete(id);
                    } catch (java.util.ConcurrentModificationException e2) {
                        System.out.println("Contacto si exist e2=" + e2);
                    }
                }
            }
        });
        //end Crud Conprobante

        //crud Boleta

        JPanel comprobantePanel = new JPanel();
        comprobantePanel.setLayout(new BoxLayout(comprobantePanel, BoxLayout.Y_AXIS));

        JLabel comprobanteLblCliente = new JLabel("Ingrese el Cliente:");
        JTextField comprobanteTxtCliente = new JTextField();

        JLabel comprobanteLblProductos = new JLabel("Ingrese los Productos:");
        JTextField comprobanteTxtProductos = new JTextField();

        JLabel comprobanteLblFecha = new JLabel("Ingrese la Fecha:");
        JTextField comprobanteTxtFecha = new JTextField();

        JLabel comprobanteLblPrecioU = new JLabel("Ingrese el Precio Unitario:");
        JTextField comprobanteTxtPrecioU = new JTextField();

        JLabel comprobanteLblPrecioT = new JLabel("Ingrese el Precio Total:");
        JTextField comprobanteTxtPrecioT = new JTextField();

        JLabel comprobanteLblDocumento = new JLabel("Ingrese el Documento");
        JTextField comprobanteTxtDocumento = new JTextField();

        JButton btnadd3B = new JButton("Agregar");
        JButton button3B;
        button3B = new JButton("Eliminar");

        comprobanteSP.setViewportView(comprobanteTable);

        comprobantePanel.add(comprobanteLblCliente);
        comprobantePanel.add(comprobanteTxtCliente);

        comprobantePanel.add(comprobanteLblProductos);
        comprobantePanel.add(comprobanteTxtProductos);

        comprobantePanel.add(comprobanteLblFecha);
        comprobantePanel.add(comprobanteTxtFecha);

        comprobantePanel.add(comprobanteLblPrecioU);
        comprobantePanel.add(comprobanteTxtPrecioU);

        comprobantePanel.add(comprobanteLblPrecioT);
        comprobantePanel.add(comprobanteTxtPrecioT);

        comprobantePanel.add(comprobanteLblDocumento);
        comprobantePanel.add(comprobanteTxtDocumento);

        comprobantePanel.add(btnadd3B);
        comprobantePanel.add(button3B);
        comprobantePanel.add(comprobanteSP);

        btnadd3B.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comprobanteId++;
                Boleta1 d = new Boleta1();

                // crea la tabla
                d.setId(comprobanteId);
                d.setCliente(comprobanteTxtCliente.getText());
                d.setProductos(comprobanteTxtProductos.getText());
                d.setFecha(comprobanteTxtFecha.getText());
                d.setPrecioU(comprobanteTxtPrecioU.getText());
                d.setPrecioT(comprobanteTxtPrecioT.getText());
                d.setDocumento(comprobanteTxtDocumento.getText());

                boletaDatos.create(d);

                List<Boleta1> miLista = boletaDatos.list();
                comprobanteMatriz = new String[miLista.size()][comprobanteColumns.length];
                for (int i = 0; i < miLista.size(); i++) {
                    comprobanteMatriz[i][0] = miLista.get(i).getId() + "";
                    comprobanteMatriz[i][1] = miLista.get(i).getCliente() + "";
                    comprobanteMatriz[i][2] = miLista.get(i).getProductos() + "";
                    comprobanteMatriz[i][3] = miLista.get(i).getFecha() + "";
                    comprobanteMatriz[i][4] = miLista.get(i).getPrecioU() + "";
                    comprobanteMatriz[i][5] = miLista.get(i).getPrecioT() + "";
                    comprobanteMatriz[i][6] = miLista.get(i).getDocumento() + "";
                }
                model4 = new DefaultTableModel(comprobanteMatriz, comprobanteColumns);
                comprobanteTable = new JTable(model4);
                comprobanteSP.setViewportView(comprobanteTable);
            }
        });

        button3B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (comprobanteTable.getSelectedRow() != -1) {
                    String ids = null;
                    int[] row = comprobanteTable.getSelectedRows();
                    ids = (String) comprobanteTable.getValueAt(row[0], 0);
                    System.out.println("Table element selected es: " + ids);
                    int id = Integer.parseInt(ids);
                    comprobanteTxtCliente.setText(" " + id);

                    model4.removeRow(comprobanteTable.getSelectedRow());
                    try {
                        boletaDatos.delete(id);
                    } catch (java.util.ConcurrentModificationException e2) {
                        System.out.println("Contacto si exist e2=" + e2);
                    }
                }
            }
        });
        //end crud Boleta
        m11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("Ir a fACTURA");
                JOptionPane.showMessageDialog(null, comprobantePanelF, "Factura", JOptionPane.PLAIN_MESSAGE);
            }
        });
        m12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("Ir a Boleta");
                JOptionPane.showMessageDialog(null, comprobantePanel, "Boleta", JOptionPane.PLAIN_MESSAGE);
            }
        });
        m19.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        m1.add(m11);
        m1.add(m12);
        m1.add(m19);

        JPanel footPanel = new JPanel();
        JLabel footLblCopy = new JLabel("ProyectoFinal-POO");
        footPanel.add(footLblCopy);

        add(BorderLayout.NORTH, mb);
        add(BorderLayout.SOUTH, footPanel);
    }

    public static void main(String args[]) {
        Boleta ex = new Boleta();
        ex.setVisible(true);
    }

}