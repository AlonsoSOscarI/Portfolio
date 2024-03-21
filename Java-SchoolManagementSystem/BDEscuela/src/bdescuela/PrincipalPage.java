package bdescuela;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Frame.ICONIFIED;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import Animacion.Animacion;
import com.itextpdf.awt.*;
import com.itextpdf.text.*;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class PrincipalPage {

    // <editor-fold defaultstate="collapsed" desc="Objetos">   
    JFrame frame = new JFrame();
    JPanel pnlBotones = new JPanel();
    JPanel pnlPrincipal = new JPanel();
    JPanel pnlAltas = new JPanel();
    JPanel pnlConsultas = new JPanel();
    JPanel pnlModificar = new JPanel();
    JPanel pnlBajas = new JPanel();
    JPanel pnlImprimir = new JPanel();
    JPanel pnlIngresos = new JPanel();

    JLabel lblFondo = new JLabel();
    JLabel lblLogo1 = new JLabel();
    JLabel lblTexto = new JLabel();
    JLabel lblX = new JLabel();
    JLabel lblM = new JLabel();
    JLabel lblAltas = new JLabel();
    JLabel lblNum = new JLabel();
    JLabel lblNombre = new JLabel();
    JLabel lblEdad = new JLabel();
    JLabel lblDireccion = new JLabel();
    JLabel lblPadre = new JLabel();
    JLabel lblTelefono = new JLabel();
    JLabel lblRfc = new JLabel();
    JLabel lblGrado = new JLabel();
    JLabel lblTaller = new JLabel();
    JLabel lblExtraescolar = new JLabel();
    JLabel lblAño = new JLabel();

    static JTextField txtNum = new JTextField();
    JTextField txtNombre = new JTextField();
    JTextField txtEdad = new JTextField();
    JTextField txtDireccion = new JTextField();
    JTextField txtPadre = new JTextField();
    JTextField txtTelefono = new JTextField();
    JTextField txtRfc = new JTextField();
    JTextField txtBuscar = new JTextField();

    String[] grados = {"Seleccionar", "Primaria", "Secundaria", "Preparatoria"};
    JComboBox boxGrado = new JComboBox(grados);
    String[] talleres = {"Seleccionar", "Hotelería", "Administración", "Computación"};
    JComboBox boxTaller = new JComboBox(talleres);
    String[] Extraescolares = {"Seleccionar", "Fútbol", "Volleyball", "Música", "Básquetbol", "Boxeo"};
    JComboBox boxExtraescolar = new JComboBox(Extraescolares);
    String[] años = {"Seleccionar", "1", "2", "3", "4", "5", "6"};
    JComboBox boxAño = new JComboBox(años);
    String[] busquedas = {"Todos", "numero", "nombre", "edad", "grado", "taller", "extraescolar", "borrados"};
    JComboBox boxBusquedas = new JComboBox(busquedas);

    JCheckBox cbBecado = new JCheckBox();

    JButton btnAltas = new JButton();
    JButton btnConsultas = new JButton();
    JButton btnModificar = new JButton();
    JButton btnEliminar = new JButton();
    JButton btnImprimir = new JButton();
    JButton btnIngresos = new JButton();
    JButton btnIngresar = new JButton();
    JButton btnUpdate = new JButton();
    JButton btnDelete = new JButton();
    JButton btnPrint = new JButton();
    JButton btnPrintI = new JButton();

    DefaultTableModel modelConsultas = new DefaultTableModel();
    JTable tablaConsultas = new JTable(modelConsultas);
    JScrollPane scrollConsultas = new JScrollPane(tablaConsultas);

    DefaultTableModel modelIngresos = new DefaultTableModel();
    JTable tablaIngresos = new JTable(modelIngresos);
    JScrollPane scrollIngresos = new JScrollPane(tablaIngresos);

    DefaultTableModel modelI = new DefaultTableModel();
    JTable tablaI = new JTable(modelI);
    JScrollPane scrollI = new JScrollPane(tablaI);

    ImageIcon imgFondo = new ImageIcon("fondo.png");
    ImageIcon imgLogo = new ImageIcon("logoEscuela.png");

    Conectar con = new Conectar();
    Connection reg = con.conexion();

    int[] nobeca = {1500, 2000, 2500, 3000};
    int[] sibeca = {1000, 1500, 2000, 2500};
    String[] ventas = new String[3];

    int xMouse;
    int yMouse;
    int num;
    int total = 0;

    String grado;
    int monto;

    // </editor-fold>  
    public PrincipalPage() {

        lblFondo.setBounds(0, 0, 730, 430);
        lblFondo.setIcon(new ImageIcon(imgFondo.getImage().getScaledInstance(730, 430, Image.SCALE_SMOOTH)));

        lblX.setForeground(new Color(204, 204, 204));
        lblX.setText("X");
        lblX.setFont(new Font("Dialog", Font.BOLD, 14));
        lblX.setBounds(710, 9, 15, 15);
        lblX.addMouseListener(mouse);

        lblM.setForeground(new Color(204, 204, 204));
        lblM.setText("_");
        lblM.setFont(new Font("Dialog", Font.BOLD, 16));
        lblM.setBounds(690, 0, 15, 25);
        lblM.addMouseListener(mouse);

        lblLogo1.setBounds(0, 30, 115, 115);
        lblLogo1.setIcon(new ImageIcon(imgLogo.getImage().getScaledInstance(115, 115, Image.SCALE_SMOOTH)));
        lblLogo1.addMouseListener(mouse);

        btnAltas.setBounds(5, 170, 100, 20);
        btnAltas.setText("Altas");
        btnAltas.setFocusable(false);
        btnAltas.setBackground(new Color(204, 204, 204));
        btnAltas.addMouseListener(mouse);

        btnConsultas.setBounds(5, 210, 100, 20);
        btnConsultas.setText("Consultar");
        btnConsultas.setFocusable(false);
        btnConsultas.setBackground(new Color(204, 204, 204));
        btnConsultas.addMouseListener(mouse);

        btnModificar.setBounds(5, 250, 100, 20);
        btnModificar.setText("Modificar");
        btnModificar.setFocusable(false);
        btnModificar.setBackground(new Color(204, 204, 204));
        btnModificar.addMouseListener(mouse);

        btnEliminar.setBounds(5, 290, 100, 20);
        btnEliminar.setText("Bajas");
        btnEliminar.setFocusable(false);
        btnEliminar.setBackground(new Color(204, 204, 204));
        btnEliminar.addMouseListener(mouse);

        btnImprimir.setBounds(5, 330, 100, 20);
        btnImprimir.setText("Imprimir");
        btnImprimir.setFocusable(false);
        btnImprimir.setBackground(new Color(204, 204, 204));
        btnImprimir.addMouseListener(mouse);

        btnIngresos.setBounds(5, 370, 100, 20);
        btnIngresos.setText("Ingresos");
        btnIngresos.setFocusable(false);
        btnIngresos.setBackground(new Color(204, 204, 204));
        btnIngresos.addMouseListener(mouse);

        lblTexto.setForeground(Color.white);
        lblTexto.setText("Inscripciones 2022");
        lblTexto.setFont(new Font("Dialog", Font.BOLD, 20));
        lblTexto.setBounds(225, 10, 200, 40);

        pnlBotones.setBounds(0, 0, 110, 430);
        pnlBotones.setBackground(new Color(0, 102, 51));
        pnlBotones.add(btnAltas);
        pnlBotones.add(btnConsultas);
        pnlBotones.add(btnModificar);
        pnlBotones.add(btnEliminar);
        pnlBotones.add(btnImprimir);
        pnlBotones.add(btnIngresos);
        pnlBotones.add(lblLogo1);
        pnlBotones.setLayout(null);

        pnlPrincipal.addMouseListener(mouse);
        pnlPrincipal.addMouseMotionListener(mouse);
        pnlPrincipal.setBounds(110, 50, 630, 380);
        pnlPrincipal.add(lblTexto);
        pnlPrincipal.setBackground(new Color(0, 134, 64));
        pnlPrincipal.setLayout(null);
        frame.add(pnlPrincipal);

        pnlAltas.setVisible(false);
        pnlAltas.addMouseListener(mouse);
        pnlAltas.addMouseMotionListener(mouse);
        pnlAltas.setBounds(110, 50, 730, 380);
        pnlAltas.setBackground(new Color(0, 134, 64));
        pnlAltas.setLayout(null);
        frame.add(pnlAltas);

        pnlConsultas.setVisible(false);
        pnlConsultas.addMouseListener(mouse);
        pnlConsultas.addMouseMotionListener(mouse);
        pnlConsultas.setBounds(110, 50, 730, 380);
        pnlConsultas.setBackground(new Color(0, 134, 64));
        pnlConsultas.setLayout(null);
        frame.add(pnlConsultas);

        pnlModificar.setVisible(false);
        pnlModificar.addMouseListener(mouse);
        pnlModificar.addMouseMotionListener(mouse);
        pnlModificar.setBounds(110, 50, 730, 380);
        pnlModificar.setBackground(new Color(0, 134, 64));
        pnlModificar.setLayout(null);
        frame.add(pnlModificar);

        pnlBajas.setVisible(false);
        pnlBajas.addMouseListener(mouse);
        pnlBajas.addMouseMotionListener(mouse);
        pnlBajas.setBounds(110, 50, 730, 380);
        pnlBajas.setBackground(new Color(0, 134, 64));
        pnlBajas.setLayout(null);
        frame.add(pnlBajas);

        pnlImprimir.setVisible(false);
        pnlImprimir.addMouseListener(mouse);
        pnlImprimir.addMouseMotionListener(mouse);
        pnlImprimir.setBounds(110, 50, 730, 380);
        pnlImprimir.setBackground(new Color(0, 134, 64));
        pnlImprimir.setLayout(null);
        frame.add(pnlImprimir);

        pnlIngresos.setVisible(false);
        pnlIngresos.addMouseListener(mouse);
        pnlIngresos.addMouseMotionListener(mouse);
        pnlIngresos.setBounds(110, 50, 730, 380);
        pnlIngresos.setBackground(new Color(0, 134, 64));
        pnlIngresos.setLayout(null);
        frame.add(pnlIngresos);

        frame.add(lblX);
        frame.add(lblM);
        frame.add(pnlBotones);
        frame.add(lblFondo);

        frame.setTitle("Inscripciones 2021");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("logoEscuela.png"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(730, 430);
        frame.addMouseListener(mouse);
        frame.addMouseMotionListener(mouse);
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.setVisible(true);

    }

    MouseAdapter mouse = new MouseAdapter() {

        @Override
        public void mouseDragged(MouseEvent e) {

            int x = e.getXOnScreen();

            int y = e.getYOnScreen();

            frame.setLocation(x - xMouse, y - yMouse);

        }

        @Override
        public void mousePressed(MouseEvent e) {

            xMouse = e.getX();
            yMouse = e.getY();

        }

        @Override
        public void mouseClicked(MouseEvent e) {

            if (e.getSource() == lblX) {

                System.exit(0);

            } else if (e.getSource() == lblM) {

                frame.setState(ICONIFIED);

            } else if (e.getSource() == lblLogo1) {

                PanelPrincipal();

            } else if (e.getSource() == btnAltas) {

                limpiar();
                PanelAltas();

            } else if (e.getSource() == btnConsultas) {

                PanelConsultas();

            } else if (e.getSource() == btnModificar) {

                limpiar();

                try {

                    num = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese número de control", "Modificar", JOptionPane.QUESTION_MESSAGE));

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(null,
                            "Por favor, ingrese el número de control", "Error", JOptionPane.ERROR_MESSAGE);
                    PanelPrincipal();
                    return;

                }

                if (!BuscarAlumno(num)) {

                    PanelPrincipal();
                    limpiar();
                    return;

                }

                PanelModificar();

            } else if (e.getSource() == btnEliminar) {

                limpiar();
                PanelBajas();

            } else if (e.getSource() == btnImprimir) {

                PanelImprimir();

            } else if (e.getSource() == btnIngresos) {

                PanelIngresos();

            } else if (e.getSource() == btnIngresar) {

                int reply = JOptionPane.showConfirmDialog(null, "Información correcta?", "¿?", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {

                    DarAlta();

                }

            } else if (e.getSource() == btnUpdate) {

                int reply = JOptionPane.showConfirmDialog(null, "Información correcta?", "¿?", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {

                    ModificarAlumno(num);

                }

            } else if (e.getSource() == btnDelete) {

                int num2;

                try {

                    num2 = Integer.parseInt(txtNum.getText());

                } catch (Exception exe) {

                    JOptionPane.showMessageDialog(null,
                            "Por favor, ingrese el número de control", "Error", JOptionPane.ERROR_MESSAGE);
                    PanelPrincipal();
                    return;

                }

                EliminarAlumno(num2);

            } else if (e.getSource() == btnPrint) {

                imprimirFicha();

            } else if (e.getSource() == btnPrintI) {

                ImprimirIngresos();

            }

        }

        @Override
        public void mouseEntered(MouseEvent e) {

            if (e.getSource() == lblX) {

                lblX.setForeground(Color.white);

            } else if (e.getSource() == lblM) {

                lblM.setForeground(Color.white);

            }

        }

        @Override
        public void mouseExited(MouseEvent e) {

            if (e.getSource() == lblX) {

                lblX.setForeground(new Color(204, 204, 204));

            } else if (e.getSource() == lblM) {

                lblM.setForeground(new Color(204, 204, 204));

            }

        }

    };

    public void PanelPrincipal() {

        pnlIngresos.setVisible(false);
        pnlBajas.setVisible(false);
        pnlModificar.setVisible(false);
        pnlConsultas.setVisible(false);
        pnlAltas.setVisible(false);
        pnlImprimir.setVisible(false);
        pnlPrincipal.setVisible(true);

    }

    public void PanelAltas() {

        lblAltas.setText("Dar Alta");
        lblAltas.setForeground(Color.white);
        lblAltas.setFont(new Font("Dialog", Font.BOLD, 20));
        lblAltas.setBounds(265, 10, 200, 40);

        lblNum.setText("Número control");
        lblNum.setForeground(Color.white);
        lblNum.setFont(new Font("Dialog", Font.BOLD, 12));
        lblNum.setBounds(55, 80, 100, 15);

        lblNombre.setText("Nombre");
        lblNombre.setForeground(Color.white);
        lblNombre.setFont(new Font("Dialog", Font.BOLD, 12));
        lblNombre.setBounds(160, 80, 100, 15);

        lblEdad.setText("Edad");
        lblEdad.setForeground(Color.white);
        lblEdad.setFont(new Font("Dialog", Font.BOLD, 12));
        lblEdad.setBounds(265, 80, 100, 15);

        lblDireccion.setText("Dirección");
        lblDireccion.setForeground(Color.white);
        lblDireccion.setFont(new Font("Dialog", Font.BOLD, 12));
        lblDireccion.setBounds(370, 80, 100, 15);

        lblPadre.setText("Padre/Tutor");
        lblPadre.setForeground(Color.white);
        lblPadre.setFont(new Font("Dialog", Font.BOLD, 12));
        lblPadre.setBounds(475, 80, 100, 15);

        lblTelefono.setText("Teléfono");
        lblTelefono.setForeground(Color.white);
        lblTelefono.setFont(new Font("Dialog", Font.BOLD, 12));
        lblTelefono.setBounds(55, 140, 100, 15);

        lblRfc.setText("RFC");
        lblRfc.setForeground(Color.white);
        lblRfc.setFont(new Font("Dialog", Font.BOLD, 12));
        lblRfc.setBounds(160, 140, 100, 15);

        lblGrado.setText("Grado");
        lblGrado.setForeground(Color.white);
        lblGrado.setFont(new Font("Dialog", Font.BOLD, 12));
        lblGrado.setBounds(265, 140, 100, 15);

        lblTaller.setText("Taller");
        lblTaller.setForeground(Color.white);
        lblTaller.setFont(new Font("Dialog", Font.BOLD, 12));
        lblTaller.setBounds(370, 140, 100, 15);

        lblExtraescolar.setText("Extraescolar");
        lblExtraescolar.setForeground(Color.white);
        lblExtraescolar.setFont(new Font("Dialog", Font.BOLD, 12));
        lblExtraescolar.setBounds(475, 140, 100, 15);

        lblAño.setText("Año");
        lblAño.setForeground(Color.white);
        lblAño.setFont(new Font("Dialog", Font.BOLD, 12));
        lblAño.setBounds(265, 200, 100, 15);

        txtNum.setForeground(Color.white);
        txtNum.setForeground(Color.black);
        txtNum.setFont(new Font("Dialog", Font.BOLD, 12));
        txtNum.setBounds(55, 107, 87, 20);

        txtNombre.setForeground(Color.white);
        txtNombre.setForeground(Color.black);
        txtNombre.setFont(new Font("Dialog", Font.BOLD, 12));
        txtNombre.setBounds(160, 107, 87, 20);

        txtEdad.setForeground(Color.white);
        txtEdad.setForeground(Color.black);
        txtEdad.setFont(new Font("Dialog", Font.BOLD, 12));
        txtEdad.setBounds(265, 107, 87, 20);

        txtDireccion.setForeground(Color.white);
        txtDireccion.setForeground(Color.black);
        txtDireccion.setFont(new Font("Dialog", Font.BOLD, 12));
        txtDireccion.setBounds(370, 107, 87, 20);

        txtPadre.setForeground(Color.white);
        txtPadre.setForeground(Color.black);
        txtPadre.setFont(new Font("Dialog", Font.BOLD, 12));
        txtPadre.setBounds(475, 107, 87, 20);

        txtTelefono.setForeground(Color.white);
        txtTelefono.setForeground(Color.black);
        txtTelefono.setFont(new Font("Dialog", Font.BOLD, 12));
        txtTelefono.setBounds(55, 165, 87, 20);

        txtRfc.setForeground(Color.white);
        txtRfc.setForeground(Color.black);
        txtRfc.setFont(new Font("Dialog", Font.BOLD, 12));
        txtRfc.setBounds(160, 165, 87, 20);

        boxGrado.setBounds(265, 165, 87, 20);
        boxGrado.setEditable(false);
        boxGrado.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (boxGrado.getSelectedItem() == "Primaria") {

                    boxTaller.setEnabled(false);
                    boxExtraescolar.setEnabled(false);
                    boxAño.setEnabled(true);

                } else if (boxGrado.getSelectedItem() == "Secundaria") {

                    boxTaller.setEnabled(true);
                    boxExtraescolar.setEnabled(false);
                    boxAño.setEnabled(false);

                } else if (boxGrado.getSelectedItem() == "Preparatoria") {

                    boxTaller.setEnabled(false);
                    boxExtraescolar.setEnabled(true);
                    boxAño.setEnabled(false);

                }
            }
        });

        boxTaller.setBounds(370, 165, 87, 20);
        boxTaller.setEditable(false);
        boxTaller.setEnabled(false);

        boxExtraescolar.setBounds(475, 165, 87, 20);
        boxExtraescolar.setEditable(false);
        boxExtraescolar.setEnabled(false);

        boxAño.setBounds(265, 225, 87, 20);
        boxAño.setEditable(false);
        boxAño.setEnabled(false);

        cbBecado.setBounds(265, 265, 87, 20);
        cbBecado.setText("Becado");
        cbBecado.setForeground(Color.white);
        cbBecado.setFont(new Font("Dialog", Font.BOLD, 12));
        cbBecado.setOpaque(false);

        btnIngresar.setBounds(265, 300, 120, 20);
        btnIngresar.setText("Registrar");
        btnIngresar.setFocusable(false);
        btnIngresar.setBackground(new Color(204, 204, 204));
        btnIngresar.addMouseListener(mouse);

        pnlAltas.add(lblAltas);
        pnlAltas.add(lblNum);
        pnlAltas.add(lblNombre);
        pnlAltas.add(lblEdad);
        pnlAltas.add(lblDireccion);
        pnlAltas.add(lblPadre);
        pnlAltas.add(lblTelefono);
        pnlAltas.add(lblRfc);
        pnlAltas.add(lblGrado);
        pnlAltas.add(lblTaller);
        pnlAltas.add(lblExtraescolar);
        pnlAltas.add(lblAño);
        pnlAltas.add(txtNum);
        pnlAltas.add(txtNombre);
        pnlAltas.add(txtEdad);
        pnlAltas.add(txtDireccion);
        pnlAltas.add(txtPadre);
        pnlAltas.add(txtTelefono);
        pnlAltas.add(txtRfc);
        pnlAltas.add(boxGrado);
        pnlAltas.add(boxTaller);
        pnlAltas.add(boxExtraescolar);
        pnlAltas.add(boxAño);
        pnlAltas.add(cbBecado);
        pnlAltas.add(btnIngresar);

        pnlPrincipal.setVisible(false);
        pnlIngresos.setVisible(false);
        pnlBajas.setVisible(false);
        pnlModificar.setVisible(false);
        pnlConsultas.setVisible(false);
        pnlImprimir.setVisible(false);
        pnlAltas.setVisible(true);

    }

    public void PanelConsultas() {

        tablaConsultas.setPreferredScrollableViewportSize(new Dimension(600, 230));
        scrollConsultas.setBounds(10, 0, 600, 230);
        tablaConsultas.setOpaque(false);
        ((DefaultTableCellRenderer) tablaConsultas.getDefaultRenderer(Object.class)).setOpaque(false);
        scrollConsultas.setOpaque(false);
        scrollConsultas.getViewport().setOpaque(false);
        tablaConsultas.setShowGrid(false);
        tablaConsultas.setForeground(Color.white);
        tablaConsultas.setFont(new Font("Arial", Font.PLAIN, 14));
        tablaConsultas.setSelectionForeground(Color.white);

        DesplegarAlumnos();

        boxBusquedas.setBounds(215, 240, 87, 20);
        boxBusquedas.setEditable(false);
        boxBusquedas.addItemListener(item);

        txtBuscar.setForeground(Color.white);
        txtBuscar.setForeground(Color.black);
        txtBuscar.setFont(new Font("Dialog", Font.BOLD, 12));
        txtBuscar.setBounds(215, 280, 87, 20);
        txtBuscar.addKeyListener(key);

        pnlConsultas.add(scrollConsultas);
        pnlConsultas.add(boxBusquedas);
        pnlConsultas.add(txtBuscar);

        pnlPrincipal.setVisible(false);
        pnlAltas.setVisible(false);
        pnlIngresos.setVisible(false);
        pnlBajas.setVisible(false);
        pnlModificar.setVisible(false);
        pnlImprimir.setVisible(false);
        pnlConsultas.setVisible(true);

    }

    public void PanelModificar() {

        lblAltas.setText("Modificar");
        lblAltas.setForeground(Color.white);
        lblAltas.setFont(new Font("Dialog", Font.BOLD, 20));
        lblAltas.setBounds(265, 10, 200, 40);

        lblNum.setText("Número control");
        lblNum.setForeground(Color.white);
        lblNum.setFont(new Font("Dialog", Font.BOLD, 12));
        lblNum.setBounds(55, 80, 100, 15);

        lblNombre.setText("Nombre");
        lblNombre.setForeground(Color.white);
        lblNombre.setFont(new Font("Dialog", Font.BOLD, 12));
        lblNombre.setBounds(160, 80, 100, 15);

        lblEdad.setText("Edad");
        lblEdad.setForeground(Color.white);
        lblEdad.setFont(new Font("Dialog", Font.BOLD, 12));
        lblEdad.setBounds(265, 80, 100, 15);

        lblDireccion.setText("Dirección");
        lblDireccion.setForeground(Color.white);
        lblDireccion.setFont(new Font("Dialog", Font.BOLD, 12));
        lblDireccion.setBounds(370, 80, 100, 15);

        lblPadre.setText("Padre/Tutor");
        lblPadre.setForeground(Color.white);
        lblPadre.setFont(new Font("Dialog", Font.BOLD, 12));
        lblPadre.setBounds(475, 80, 100, 15);

        lblTelefono.setText("Teléfono");
        lblTelefono.setForeground(Color.white);
        lblTelefono.setFont(new Font("Dialog", Font.BOLD, 12));
        lblTelefono.setBounds(55, 140, 100, 15);

        lblRfc.setText("RFC");
        lblRfc.setForeground(Color.white);
        lblRfc.setFont(new Font("Dialog", Font.BOLD, 12));
        lblRfc.setBounds(160, 140, 100, 15);

        lblGrado.setText("Grado");
        lblGrado.setForeground(Color.white);
        lblGrado.setFont(new Font("Dialog", Font.BOLD, 12));
        lblGrado.setBounds(265, 140, 100, 15);

        lblTaller.setText("Taller");
        lblTaller.setForeground(Color.white);
        lblTaller.setFont(new Font("Dialog", Font.BOLD, 12));
        lblTaller.setBounds(370, 140, 100, 15);

        lblExtraescolar.setText("Extraescolar");
        lblExtraescolar.setForeground(Color.white);
        lblExtraescolar.setFont(new Font("Dialog", Font.BOLD, 12));
        lblExtraescolar.setBounds(475, 140, 100, 15);

        lblAño.setText("Año");
        lblAño.setForeground(Color.white);
        lblAño.setFont(new Font("Dialog", Font.BOLD, 12));
        lblAño.setBounds(265, 200, 100, 15);

        txtNum.setForeground(Color.white);
        txtNum.setForeground(Color.black);
        txtNum.setFont(new Font("Dialog", Font.BOLD, 12));
        txtNum.setBounds(55, 107, 87, 20);

        txtNombre.setForeground(Color.white);
        txtNombre.setForeground(Color.black);
        txtNombre.setFont(new Font("Dialog", Font.BOLD, 12));
        txtNombre.setBounds(160, 107, 87, 20);

        txtEdad.setForeground(Color.white);
        txtEdad.setForeground(Color.black);
        txtEdad.setFont(new Font("Dialog", Font.BOLD, 12));
        txtEdad.setBounds(265, 107, 87, 20);

        txtDireccion.setForeground(Color.white);
        txtDireccion.setForeground(Color.black);
        txtDireccion.setFont(new Font("Dialog", Font.BOLD, 12));
        txtDireccion.setBounds(370, 107, 87, 20);

        txtPadre.setForeground(Color.white);
        txtPadre.setForeground(Color.black);
        txtPadre.setFont(new Font("Dialog", Font.BOLD, 12));
        txtPadre.setBounds(475, 107, 87, 20);

        txtTelefono.setForeground(Color.white);
        txtTelefono.setForeground(Color.black);
        txtTelefono.setFont(new Font("Dialog", Font.BOLD, 12));
        txtTelefono.setBounds(55, 165, 87, 20);

        txtRfc.setForeground(Color.white);
        txtRfc.setForeground(Color.black);
        txtRfc.setFont(new Font("Dialog", Font.BOLD, 12));
        txtRfc.setBounds(160, 165, 87, 20);

        boxGrado.setBounds(265, 165, 87, 20);
        boxGrado.setEditable(false);
        boxGrado.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (boxGrado.getSelectedItem() == "Primaria") {

                    boxTaller.setEnabled(false);
                    boxExtraescolar.setEnabled(false);
                    boxAño.setEnabled(true);

                } else if (boxGrado.getSelectedItem() == "Secundaria") {

                    boxTaller.setEnabled(true);
                    boxExtraescolar.setEnabled(false);
                    boxAño.setEnabled(false);

                } else if (boxGrado.getSelectedItem() == "Preparatoria") {

                    boxTaller.setEnabled(false);
                    boxExtraescolar.setEnabled(true);
                    boxAño.setEnabled(false);

                }
            }
        });

        boxTaller.setBounds(370, 165, 87, 20);
        boxTaller.setEditable(false);
        boxTaller.setEnabled(false);

        boxExtraescolar.setBounds(475, 165, 87, 20);
        boxExtraescolar.setEditable(false);
        boxExtraescolar.setEnabled(false);

        boxAño.setBounds(265, 225, 87, 20);
        boxAño.setEditable(false);
        boxAño.setEnabled(false);

        cbBecado.setBounds(265, 265, 87, 20);
        cbBecado.setText("Becado");
        cbBecado.setForeground(Color.white);
        cbBecado.setFont(new Font("Dialog", Font.BOLD, 12));
        cbBecado.setOpaque(false);

        btnUpdate.setBounds(265, 300, 120, 20);
        btnUpdate.setText("Modificar");
        btnUpdate.setFocusable(false);
        btnUpdate.setBackground(new Color(204, 204, 204));
        btnUpdate.addMouseListener(mouse);

        pnlModificar.add(lblAltas);
        pnlModificar.add(lblNum);
        pnlModificar.add(lblNombre);
        pnlModificar.add(lblEdad);
        pnlModificar.add(lblDireccion);
        pnlModificar.add(lblPadre);
        pnlModificar.add(lblTelefono);
        pnlModificar.add(lblRfc);
        pnlModificar.add(lblGrado);
        pnlModificar.add(lblTaller);
        pnlModificar.add(lblExtraescolar);
        pnlModificar.add(lblAño);
        pnlModificar.add(txtNum);
        pnlModificar.add(txtNombre);
        pnlModificar.add(txtEdad);
        pnlModificar.add(txtDireccion);
        pnlModificar.add(txtPadre);
        pnlModificar.add(txtTelefono);
        pnlModificar.add(txtRfc);
        pnlModificar.add(boxGrado);
        pnlModificar.add(boxTaller);
        pnlModificar.add(boxExtraescolar);
        pnlModificar.add(boxAño);
        pnlModificar.add(cbBecado);
        pnlModificar.add(btnUpdate);

        pnlPrincipal.setVisible(false);
        pnlAltas.setVisible(false);
        pnlConsultas.setVisible(false);
        pnlIngresos.setVisible(false);
        pnlBajas.setVisible(false);
        pnlImprimir.setVisible(false);
        pnlModificar.setVisible(true);

    }

    public void PanelBajas() {

        lblAltas.setText("Dar Baja");
        lblAltas.setForeground(Color.white);
        lblAltas.setFont(new Font("Dialog", Font.BOLD, 20));
        lblAltas.setBounds(265, 10, 200, 40);

        lblNum.setText("Número control");
        lblNum.setForeground(Color.white);
        lblNum.setFont(new Font("Dialog", Font.BOLD, 12));
        lblNum.setBounds(265, 130, 100, 15);

        txtNum.setForeground(Color.white);
        txtNum.setForeground(Color.black);
        txtNum.setFont(new Font("Dialog", Font.BOLD, 12));
        txtNum.setBounds(265, 170, 87, 20);

        btnDelete.setBounds(265, 210, 120, 20);
        btnDelete.setText("Eliminar");
        btnDelete.setFocusable(false);
        btnDelete.setBackground(new Color(204, 204, 204));
        btnDelete.addMouseListener(mouse);

        pnlBajas.add(lblAltas);
        pnlBajas.add(lblNum);
        pnlBajas.add(txtNum);
        pnlBajas.add(btnDelete);

        pnlPrincipal.setVisible(false);
        pnlAltas.setVisible(false);
        pnlConsultas.setVisible(false);
        pnlModificar.setVisible(false);
        pnlIngresos.setVisible(false);
        pnlImprimir.setVisible(false);
        pnlBajas.setVisible(true);

    }

    public void PanelImprimir() {

        lblAltas.setText("Imprimir Ficha");
        lblAltas.setForeground(Color.white);
        lblAltas.setFont(new Font("Dialog", Font.BOLD, 20));
        lblAltas.setBounds(265, 10, 200, 40);

        lblNum.setText("Número control");
        lblNum.setForeground(Color.white);
        lblNum.setFont(new Font("Dialog", Font.BOLD, 12));
        lblNum.setBounds(265, 130, 100, 15);

        txtNum.setForeground(Color.white);
        txtNum.setForeground(Color.black);
        txtNum.setFont(new Font("Dialog", Font.BOLD, 12));
        txtNum.setBounds(265, 170, 87, 20);

        btnPrint.setBounds(265, 210, 120, 20);
        btnPrint.setText("Imprimir");
        btnPrint.setFocusable(false);
        btnPrint.setBackground(new Color(204, 204, 204));
        btnPrint.addMouseListener(mouse);

        pnlImprimir.add(lblAltas);
        pnlImprimir.add(lblNum);
        pnlImprimir.add(txtNum);
        pnlImprimir.add(btnPrint);

        pnlPrincipal.setVisible(false);
        pnlAltas.setVisible(false);
        pnlConsultas.setVisible(false);
        pnlModificar.setVisible(false);
        pnlBajas.setVisible(false);
        pnlImprimir.setVisible(true);

    }

    public void PanelIngresos() {

        tablaIngresos.setPreferredScrollableViewportSize(new Dimension(600, 230));
        scrollIngresos.setBounds(10, 0, 600, 230);
        tablaIngresos.setOpaque(false);
        ((DefaultTableCellRenderer) tablaIngresos.getDefaultRenderer(Object.class)).setOpaque(false);
        scrollIngresos.setOpaque(false);
        scrollIngresos.getViewport().setOpaque(false);
        tablaIngresos.setShowGrid(false);
        tablaIngresos.setForeground(Color.white);
        tablaIngresos.setFont(new Font("Arial", Font.PLAIN, 14));
        tablaIngresos.setSelectionForeground(Color.white);


        CalcularTotal();

        DesplegarIngresos();

        btnPrintI.setBounds(240, 265, 120, 20);
        btnPrintI.setText("Imprimir");
        btnPrintI.setFocusable(false);
        btnPrintI.setBackground(new Color(204, 204, 204));
        btnPrintI.addMouseListener(mouse);

        pnlIngresos.add(scrollIngresos);
        pnlIngresos.add(btnPrintI);

        pnlPrincipal.setVisible(false);
        pnlAltas.setVisible(false);
        pnlConsultas.setVisible(false);
        pnlModificar.setVisible(false);
        pnlBajas.setVisible(false);
        pnlImprimir.setVisible(false);
        pnlIngresos.setVisible(true);

    }

    public void DarAlta() {

        if (!validacion()) {

            return;

        }

        String SQL = "";
        String SQL2 = "";
        int numero, edad, telefono;
        String nombre, direccion, padre, rfc, grado, taller, extraescolar;

        numero = Integer.parseInt(txtNum.getText());
        nombre = txtNombre.getText();
        edad = Integer.parseInt(txtEdad.getText());
        direccion = txtDireccion.getText();
        padre = txtPadre.getText();
        telefono = Integer.parseInt(txtTelefono.getText());
        rfc = txtRfc.getText();
        grado = (String) boxGrado.getSelectedItem();
        taller = (String) boxTaller.getSelectedItem();
        extraescolar = (String) boxExtraescolar.getSelectedItem();

        if (boxGrado.getSelectedItem() == "Primaria") {

            SQL = "INSERT INTO alumnos (numero, nombre, edad, direccion, padre, telefono, rfc, grado) VALUES (?,?,?,?,?,?,?,?)";
            SQL2 = "INSERT INTO ingresos (numero, monto) VALUES (?,?)";

            try {

                PreparedStatement ps = reg.prepareStatement(SQL);

                ps.setInt(1, numero);
                ps.setString(2, nombre);
                ps.setInt(3, edad);
                ps.setString(4, direccion);
                ps.setString(5, padre);
                ps.setInt(6, telefono);
                ps.setString(7, rfc);
                ps.setString(8, grado);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null,
                        "Alumno Registrado", "Añadir", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {

                System.out.println(e + "aqui");
                JOptionPane.showMessageDialog(null,
                        "Error al intentar registar alumno", "Error", JOptionPane.ERROR_MESSAGE);

                limpiar();
                return;

            }

            try {
                //Añadiendo a tabla ingresos
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                limpiar();
                Logger.getLogger(PrincipalPage.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {

                PreparedStatement ps = reg.prepareStatement(SQL2);

                System.out.println(boxAño.getSelectedItem());

                if (boxAño.getSelectedIndex() <= 3) {

                    System.out.println("if año 1-3");

                    if (cbBecado.isSelected()) {

                        ps.setInt(1, numero);
                        ps.setInt(2, sibeca[0]);
                        ps.executeUpdate();
                        System.out.println(" 1-3 becado = true");

                    } else {

                        ps.setInt(1, numero);
                        ps.setInt(2, nobeca[0]);
                        ps.executeUpdate();
                        System.out.println(" 1-3 becado = false");

                    }

                } else {

                    System.out.println("if año 4-6");

                    if (cbBecado.isSelected()) {

                        ps.setInt(1, numero);
                        ps.setInt(2, sibeca[1]);
                        ps.executeUpdate();
                        System.out.println(" 4-6 becado = true");

                    } else {

                        ps.setInt(1, numero);
                        ps.setInt(2, nobeca[1]);
                        ps.executeUpdate();
                        System.out.println(" 4-6 becado = false");

                    }

                }

                JOptionPane.showMessageDialog(null,
                        "Pago registrado", "Añadir", JOptionPane.INFORMATION_MESSAGE);

                limpiar();
            } catch (Exception e) {

                System.out.println(e + "aqui");
                JOptionPane.showMessageDialog(null,
                        "Error al intentar registar pago", "Error", JOptionPane.ERROR_MESSAGE);
                limpiar();
                return;

            }

        } else if (boxGrado.getSelectedItem() == "Secundaria") {

            SQL = "INSERT INTO alumnos (numero, nombre, edad, direccion, padre, telefono, rfc, grado, taller) VALUES (?,?,?,?,?,?,?,?,?)";
            SQL2 = "INSERT INTO ingresos (numero, monto) VALUES (?,?)";

            try {

                PreparedStatement ps = reg.prepareStatement(SQL);

                ps.setInt(1, numero);
                ps.setString(2, nombre);
                ps.setInt(3, edad);
                ps.setString(4, direccion);
                ps.setString(5, padre);
                ps.setInt(6, telefono);
                ps.setString(7, rfc);
                ps.setString(8, grado);
                ps.setString(9, taller);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null,
                        "Alumno Registrado", "Añadir", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {

                System.out.println(e + "aqui");
                JOptionPane.showMessageDialog(null,
                        "Error al intentar registar alumno", "Error", JOptionPane.ERROR_MESSAGE);

                limpiar();
                return;

            }

            try {
                //Añadiendo a tabla ingresos
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                limpiar();
                Logger.getLogger(PrincipalPage.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {

                PreparedStatement ps = reg.prepareStatement(SQL2);

                System.out.println(boxAño.getSelectedItem());

                if (cbBecado.isSelected()) {

                    ps.setInt(1, numero);
                    ps.setInt(2, sibeca[2]);
                    ps.executeUpdate();
                    System.out.println("sec becado = true");

                } else {

                    ps.setInt(1, numero);
                    ps.setInt(2, nobeca[2]);
                    ps.executeUpdate();
                    System.out.println("sec becado = false");

                }

                JOptionPane.showMessageDialog(null,
                        "Pago registrado", "Añadir", JOptionPane.INFORMATION_MESSAGE);

                limpiar();
            } catch (Exception e) {

                System.out.println(e + "aqui");
                JOptionPane.showMessageDialog(null,
                        "Error al intentar registar pago", "Error", JOptionPane.ERROR_MESSAGE);
                limpiar();
                return;

            }

        } else if (boxGrado.getSelectedItem() == "Preparatoria") {

            SQL = "INSERT INTO alumnos (numero, nombre, edad, direccion, padre, telefono, rfc, grado, extraescolar) VALUES (?,?,?,?,?,?,?,?,?)";
            SQL2 = "INSERT INTO ingresos (numero, monto) VALUES (?,?)";

            try {

                PreparedStatement ps = reg.prepareStatement(SQL);

                ps.setInt(1, numero);
                ps.setString(2, nombre);
                ps.setInt(3, edad);
                ps.setString(4, direccion);
                ps.setString(5, padre);
                ps.setInt(6, telefono);
                ps.setString(7, rfc);
                ps.setString(8, grado);
                ps.setString(9, extraescolar);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null,
                        "Alumno Registrado", "Añadir", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception e) {

                System.out.println(e + "aqui");
                JOptionPane.showMessageDialog(null,
                        "Error al intentar registar alumno", "Error", JOptionPane.ERROR_MESSAGE);

                limpiar();
                return;

            }

            try {
                //Añadiendo a tabla ingresos
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                limpiar();
                Logger.getLogger(PrincipalPage.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {

                PreparedStatement ps = reg.prepareStatement(SQL2);

                System.out.println(boxAño.getSelectedItem());

                if (cbBecado.isSelected()) {

                    ps.setInt(1, numero);
                    ps.setInt(2, sibeca[3]);
                    ps.executeUpdate();
                    System.out.println("prep becado = true");

                } else {

                    ps.setInt(1, numero);
                    ps.setInt(2, nobeca[3]);
                    ps.executeUpdate();
                    System.out.println("prep becado = false");

                }

                JOptionPane.showMessageDialog(null,
                        "Pago registrado", "Añadir", JOptionPane.INFORMATION_MESSAGE);

                limpiar();
            } catch (Exception e) {

                System.out.println(e + "aqui");
                JOptionPane.showMessageDialog(null,
                        "Error al intentar registrar pago", "Error", JOptionPane.ERROR_MESSAGE);
                limpiar();
                return;

            }

        }

    }

    public void DesplegarAlumnos() {

        String SQLselect = "SELECT * FROM alumnos WHERE borrado = '1'";
        String[] datos = new String[10];

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("N Control");
        modelo.addColumn("Nombre");
        modelo.addColumn("Edad");
        modelo.addColumn("Dirección");
        modelo.addColumn("Padre");
        modelo.addColumn("Teléfono");
        modelo.addColumn("RFC");
        modelo.addColumn("Grado");
        modelo.addColumn("Taller");
        modelo.addColumn("Extraescolar");
        tablaConsultas.setModel(modelo);

        try {

            Statement sentencia = reg.createStatement();
            ResultSet rs = sentencia.executeQuery(SQLselect);

            while (rs.next()) {

                datos[0] = Integer.toString(rs.getInt(1)); //numero 
                datos[1] = rs.getString(2);
                datos[2] = Integer.toString(rs.getInt(3)); //edad
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = Integer.toString(rs.getInt(6));//telefono
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);

                modelo.addRow(datos);

            }

            tablaConsultas.setModel(modelo);

        } catch (Exception e) {

            System.out.println("Error método desplegarAlumnos" + e);

        }

    }

    public void DesplegarAlumnosBorrados() {

        String SQLselect = "SELECT * FROM alumnos WHERE borrado = '0'";
        String[] datos = new String[10];

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("N Control");
        modelo.addColumn("Nombre");
        modelo.addColumn("Edad");
        modelo.addColumn("Dirección");
        modelo.addColumn("Padre");
        modelo.addColumn("Teléfono");
        modelo.addColumn("RFC");
        modelo.addColumn("Grado");
        modelo.addColumn("Taller");
        modelo.addColumn("Extraescolar");
        tablaConsultas.setModel(modelo);

        try {

            Statement sentencia = reg.createStatement();
            ResultSet rs = sentencia.executeQuery(SQLselect);

            while (rs.next()) {

                datos[0] = Integer.toString(rs.getInt(1)); //numero 
                datos[1] = rs.getString(2);
                datos[2] = Integer.toString(rs.getInt(3)); //edad
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = Integer.toString(rs.getInt(6));//telefono
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);

                modelo.addRow(datos);

            }

            tablaConsultas.setModel(modelo);

        } catch (Exception e) {

            System.out.println("Error método desplegarAlumnos" + e);

        }

    }

    public boolean BuscarAlumno(int num) {

        String SQL = "SELECT * FROM alumnos WHERE numero = '" + num + "' AND borrado = '1'";
        String SQL2 = "SELECT * FROM ingresos WHERE numero = '" + num + "'";
        String valida;
        boolean si;

        try {

            Statement sentencia = reg.createStatement();
            ResultSet rs = sentencia.executeQuery(SQL);

            while (rs.next()) {

                txtNum.setText(Integer.toString(rs.getInt(1))); //numero 
                txtNombre.setText(rs.getString(2));
                txtEdad.setText(Integer.toString(rs.getInt(3))); //edad
                txtDireccion.setText(rs.getString(4));
                txtPadre.setText(rs.getString(5));
                txtTelefono.setText(Integer.toString(rs.getInt(6)));//telefono
                txtRfc.setText(rs.getString(7));
                grado = rs.getString(8);

                si = true;

            }

            if (txtNombre.getText().length() == 0) {

                JOptionPane.showMessageDialog(null,
                        "Número de Control inexistente", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("txtNum = 0");
                si = false;
                return false;

            }

            si = true;

        } catch (Exception e) {

            System.out.println("Error método BuscarAlumno" + e);
            si = false;
            return false;

        }

        try {

            Statement sentencia = reg.createStatement();
            ResultSet rs = sentencia.executeQuery(SQL2);

            while (rs.next()) {

                monto = rs.getInt(3);

                si = true;

            }

            si = true;

        } catch (Exception e) {

            System.out.println("Error método BuscarAlumno" + e);
            si = false;
            return false;

        }

        System.out.println("BuscarAlumno " + si);
        return si;

    }

    KeyAdapter key = new KeyAdapter() {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key >= 65 && key <= 90) || (key >= 48 && key <= 57) || (key >= 96 && key <= 105)) {

                LikeAlumnos((String) boxBusquedas.getSelectedItem(), txtBuscar.getText());
                System.out.println((String) boxBusquedas.getSelectedItem());

            }

        }

    };

    ItemListener item = new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {

            if (e.getItem() == "Todos") {

                DesplegarAlumnos();

            } else if (e.getItem() == "borrados") {

                DesplegarAlumnosBorrados();

            }

        }

    };

    public void LikeAlumnos(String where, String txt) {

        String[] datos = new String[10];
        String SQLwherenombre = "SELECT * FROM alumnos WHERE " + where + " LIKE '%" + txt + "%' AND borrado = '1'";

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("N Control");
        modelo.addColumn("Nombre");
        modelo.addColumn("Edad");
        modelo.addColumn("Dirección");
        modelo.addColumn("Padre");
        modelo.addColumn("Teléfono");
        modelo.addColumn("RFC");
        modelo.addColumn("Grado");
        modelo.addColumn("Taller");
        modelo.addColumn("Extraescolar");
        tablaConsultas.setModel(modelo);

        try {

            Statement sentencia = reg.createStatement();
            ResultSet rs = sentencia.executeQuery(SQLwherenombre);

            while (rs.next()) {

                datos[0] = Integer.toString(rs.getInt(1)); //numero 
                datos[1] = rs.getString(2);
                datos[2] = Integer.toString(rs.getInt(3)); //edad
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = Integer.toString(rs.getInt(6));//telefono
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);

                modelo.addRow(datos);

            }

            if (datos[0] == null) {

                DesplegarAlumnos();
                JOptionPane.showMessageDialog(null,
                        "Sin coincidencias", "Error", JOptionPane.ERROR_MESSAGE);
                return;

            }

            tablaConsultas.setModel(modelo);

        } catch (Exception e) {

            System.out.println("Error método verTabla" + e);
            JOptionPane.showMessageDialog(null,
                    "Error", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void ModificarAlumno(int num) {

        int numero, edad, telefono;
        String SQL = "";
        String SQL2 = "";
        String nombre, direccion, padre, rfc, grado, taller, extraescolar;

        numero = Integer.parseInt(txtNum.getText());
        nombre = txtNombre.getText();
        edad = Integer.parseInt(txtEdad.getText());
        direccion = txtDireccion.getText();
        padre = txtPadre.getText();
        telefono = Integer.parseInt(txtTelefono.getText());
        rfc = txtRfc.getText();
        grado = (String) boxGrado.getSelectedItem();
        taller = (String) boxTaller.getSelectedItem();
        extraescolar = (String) boxExtraescolar.getSelectedItem();

        if (boxGrado.getSelectedItem() == "Primaria") {

            SQL = "UPDATE alumnos SET numero='" + numero + "', nombre='" + nombre + "', edad='" + edad + "',direccion='" + direccion + "', padre='" + padre + "', telefono='" + telefono + "', rfc='" + rfc + "', grado='" + grado + "', taller='" + "NO" + "', extraescolar='" + "NO" + "' WHERE numero='" + num + "'";

            if (boxAño.getSelectedIndex() <= 3) {

                System.out.println("if año 1-3");

                if (cbBecado.isSelected()) {

                    SQL2 = "UPDATE ingresos SET monto='" + sibeca[0] + "' WHERE numero='" + num + "'";

                    System.out.println(" 1-3 becado = true");

                } else {

                    SQL2 = "UPDATE ingresos SET monto='" + nobeca[0] + "' WHERE numero='" + num + "'";
                    System.out.println(" 1-3 becado = false");

                }

            } else {

                System.out.println("if año 4-6");

                if (cbBecado.isSelected()) {

                    SQL2 = "UPDATE ingresos SET monto='" + sibeca[1] + "' WHERE numero='" + num + "'";

                } else {

                    SQL2 = "UPDATE ingresos SET monto='" + nobeca[1] + "' WHERE numero='" + num + "'";
                    System.out.println(" 4-6 becado = false");

                }

            }

        } else if (boxGrado.getSelectedItem() == "Secundaria") {

            SQL = "UPDATE alumnos SET numero='" + numero + "', nombre='" + nombre + "', edad='" + edad + "',direccion='" + direccion + "', padre='" + padre + "', telefono='" + telefono + "', rfc='" + rfc + "', grado='" + grado + "', taller='" + taller + "', extraescolar='" + "NO" + "' WHERE numero='" + num + "'";

            if (cbBecado.isSelected()) {

                SQL2 = "UPDATE ingresos SET monto='" + sibeca[2] + "' WHERE numero='" + num + "'";

            } else {

                SQL2 = "UPDATE ingresos SET monto='" + nobeca[2] + "' WHERE numero='" + num + "'";

                System.out.println(" 4-6 becado = false");

            }

        } else if (boxGrado.getSelectedItem() == "Preparatoria") {

            SQL = "UPDATE alumnos SET numero='" + numero + "', nombre='" + nombre + "', edad='" + edad + "',direccion='" + direccion + "', padre='" + padre + "', telefono='" + telefono + "', rfc='" + rfc + "', grado='" + grado + "', taller='" + "NO" + "', extraescolar='" + extraescolar + "' WHERE numero='" + num + "'";

            if (cbBecado.isSelected()) {

                SQL2 = "UPDATE ingresos SET monto='" + sibeca[3] + "' WHERE numero='" + num + "'";

            } else {

                SQL2 = "UPDATE ingresos SET monto='" + nobeca[3] + "' WHERE numero='" + num + "'";
                System.out.println(" 4-6 becado = false");

            }

        }

        try {

            PreparedStatement ps2 = reg.prepareStatement(SQL2);

            ps2.executeUpdate();

            PreparedStatement ps = reg.prepareStatement(SQL);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Alumno Modificado", "Hecho", JOptionPane.INFORMATION_MESSAGE);
            PanelPrincipal();
            limpiar();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Error al intentar modificar alumno", "Error", JOptionPane.ERROR_MESSAGE);
            PanelPrincipal();
            limpiar();
            System.out.println(e);

        }

    }

    public void EliminarAlumno(int num) {

        int reply = JOptionPane.showConfirmDialog(null, "Acción Irreversible, ¿está seguro/a?", "¿?", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.NO_OPTION) {

            return;

        }

        String SQL = "UPDATE alumnos SET borrado = '0' WHERE numero='" + num + "'";

        try {

            PreparedStatement ps = reg.prepareStatement(SQL);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Alumno Eliminado", "Hecho", JOptionPane.INFORMATION_MESSAGE);
            PanelPrincipal();
            limpiar();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Error al intentar eliminar alumno", "Error", JOptionPane.ERROR_MESSAGE);
            PanelPrincipal();
            limpiar();
            System.out.println(e);

        }

    }

    public void imprimirFicha() {

        int valida;

        try {

            valida = Integer.parseInt(txtNum.getText());

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null,
                    "Por favor, ingrese el número de control", "Error", JOptionPane.ERROR_MESSAGE);
            PanelPrincipal();
            limpiar();
            return;

        }

        if (!BuscarAlumno(Integer.parseInt(txtNum.getText()))) {

            JOptionPane.showMessageDialog(null,
                    "Por favor, ingrese el número de control", "Error", JOptionPane.ERROR_MESSAGE);
            PanelPrincipal();
            return;

        }

        try {
            Document documento = new Document();

            //try {
            FileOutputStream ficheroPDF = new FileOutputStream("Ficha alumno " + valida + ".pdf");
            PdfWriter.getInstance(documento, ficheroPDF);

            documento.open();

            Paragraph titulo = new Paragraph("Ficha de inscripción \n\n", FontFactory.getFont("arial", 22, Font.BOLD, BaseColor.GREEN));

            documento.add(titulo);
            PdfPTable tabla = new PdfPTable(4);
            tabla.addCell("Número Control");
            tabla.addCell("Nombre");
            tabla.addCell("Grado");
            tabla.addCell("Monto");

            tabla.addCell(txtNum.getText());
            tabla.addCell(txtNombre.getText());
            tabla.addCell(grado);
            tabla.addCell(Integer.toString(monto));
            documento.add(tabla);

            documento.close();

        } catch (Exception ex) {

            Logger.getLogger(PrincipalPage.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void DesplegarIngresos() {

        String SQLselect = "SELECT * FROM ingresos";
        String[] datos = new String[3];

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("IDIngreso");
        modelo.addColumn("Número Control");
        modelo.addColumn("Monto");

        tablaIngresos.setModel(modelo);

        try {

            Statement sentencia = reg.createStatement();
            ResultSet rs = sentencia.executeQuery(SQLselect);

            while (rs.next()) {

                datos[0] = Integer.toString(rs.getInt(1)); //numero 
                datos[1] = rs.getString(2);
                datos[2] = Integer.toString(rs.getInt(3)); //edad

                modelo.addRow(datos);

            }

            String[] dt = new String[3];
            dt[0] = null;
            dt[1] = null;
            dt[2] = "Total: " + total;
            modelo.addRow(dt);

            tablaIngresos.setModel(modelo);
            //ImprimirIngresos();

        } catch (Exception e) {

            System.out.println("Error método desplegar ingresos" + e);

        }

    }

    public void ImprimirIngresos() {

        MessageFormat header = new MessageFormat("Reporte de ingresos");
        MessageFormat footer = new MessageFormat("Pagina{0, number, integer}");

        try {

            tablaIngresos.setForeground(Color.black);
            tablaIngresos.print(JTable.PrintMode.FIT_WIDTH, header, footer);

        } catch (PrinterException ex) {
            Logger.getLogger(PrincipalPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tablaIngresos.setForeground(Color.white);

    }

    public void CalcularTotal() {

        String SQL = "SELECT SUM(monto) from ingresos";

        try {

            Statement sentencia = reg.createStatement();
            ResultSet rs = sentencia.executeQuery(SQL);

            while (rs.next()) {

                total = rs.getInt(1);

            }

            System.out.println("" + total);
        } catch (Exception e) {

        }

    }

    public void limpiar() {

        txtNum.setText(null);
        txtNombre.setText(null);
        txtEdad.setText(null);
        txtDireccion.setText(null);
        txtPadre.setText(null);
        txtTelefono.setText(null);
        txtRfc.setText(null);
        boxGrado.setSelectedIndex(0);
        boxTaller.setSelectedIndex(0);
        boxExtraescolar.setSelectedIndex(0);
        boxAño.setSelectedIndex(0);
        cbBecado.setSelected(false);

    }

    public boolean validacion() {

        boolean val;
        System.out.println("Validacion");

        if (txtNum.getText().length() != 0 || txtNombre.getText().length() != 0 || txtEdad.getText().length() != 0 || txtDireccion.getText().length() != 0 || txtPadre.getText().length() != 0 || txtTelefono.getText().length() != 0 || txtRfc.getText().length() != 0) {

            if (boxGrado.getSelectedItem() != "Seleccionar") {

                val = true;

                if ((boxGrado.getSelectedItem() == "Primaria" && boxAño.getSelectedItem() != "Seleccionar") || (boxGrado.getSelectedItem() == "Secundaria" && boxTaller.getSelectedItem() != "Seleccionar") || (boxGrado.getSelectedItem() == "Preparatoria" && boxExtraescolar.getSelectedItem() != "Seleccionar")) {

                    val = true;

                } else {

                    JOptionPane.showMessageDialog(null,
                            "Por favor, seleccione las categorías correctas", "Error", JOptionPane.ERROR_MESSAGE);
                    val = false;

                }

            } else {

                JOptionPane.showMessageDialog(null,
                        "Por favor, seleccione las categorías correctas", "Error", JOptionPane.ERROR_MESSAGE);
                val = false;

            }

        } else {

            JOptionPane.showMessageDialog(null,
                    "Por favor, rellene todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
            val = false;

        }

        try {

            int valida = Integer.parseInt(txtEdad.getText());
            int valida2 = Integer.parseInt(txtTelefono.getText());

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Solo números para Edad y Teléfono", "Error", JOptionPane.ERROR_MESSAGE);
            val = false;

        }
        
        if(Integer.parseInt(txtEdad.getText()) < 6) {
            
            JOptionPane.showMessageDialog(null,
                    "La edad debe ser mayor a 6 años", "Error", JOptionPane.ERROR_MESSAGE);
            val = false;
            
        }

        return val;

    }

}
