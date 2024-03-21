package bdescuela;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Frame.ICONIFIED;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Login {

    JFrame frame = new JFrame();

    JLabel lblFondo = new JLabel();
    JLabel lblX = new JLabel();
    JLabel lblM = new JLabel();
    JLabel lblTitulo = new JLabel();
    JLabel lblLogo = new JLabel();
    JLabel lblNombre = new JLabel();
    JLabel lblPass = new JLabel();
    JLabel lblTexto = new JLabel();

    JTextField txtNombre = new JTextField();
    JPasswordField pwdPass = new JPasswordField();

    JButton btnLogin = new JButton();

    JSeparator separador = new JSeparator();

    ImageIcon imgFondo = new ImageIcon("fondo.png");
    ImageIcon imgLogo = new ImageIcon("logoEscuela.png");

    int xMouse;
    int yMouse;

    Conectar con = new Conectar();
    Connection reg = con.conexion();

    public Login() {

        lblX.setForeground(new Color(204, 204, 204));
        lblX.setText("X");
        lblX.setFont(new Font("Dialog", Font.BOLD, 14));
        lblX.setBounds(460, 9, 15, 15);
        lblX.addMouseListener(mouse);

        lblM.setForeground(new Color(204, 204, 204));
        lblM.setText("_");
        lblM.setFont(new Font("Dialog", Font.BOLD, 16));
        lblM.setBounds(440, 0, 15, 25);
        lblM.addMouseListener(mouse);

        lblTitulo.setForeground(Color.white);
        lblTitulo.setText("Inicio de sesión");
        lblTitulo.setFont(new Font("Dialog", Font.BOLD, 14));
        lblTitulo.setBounds(10, 9, 150, 25);

        lblLogo.setBounds(50, 30, 75, 75);
        lblLogo.setIcon(new ImageIcon(imgLogo.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH)));

        lblFondo.setBounds(0, 0, 490, 350);
        lblFondo.setIcon(new ImageIcon(imgFondo.getImage().getScaledInstance(490, 350, Image.SCALE_SMOOTH)));

        lblNombre.setForeground(Color.white);
        lblNombre.setText("Nombre");
        lblNombre.setFont(new Font("Dialog", Font.BOLD, 13));
        lblNombre.setBounds(27, 110, 65, 15);

        lblPass.setForeground(Color.white);
        lblPass.setText("Contraseña");
        lblPass.setFont(new Font("Dialog", Font.BOLD, 13));
        lblPass.setBounds(6, 140, 90, 15);

        txtNombre.setBounds(100, 109, 350, 20);
        txtNombre.setForeground(Color.black);
        txtNombre.setOpaque(false);

        pwdPass.setBounds(100, 139, 350, 20);
        pwdPass.setForeground(Color.black);
        pwdPass.setOpaque(false);

        btnLogin.setBounds(120, 175, 120, 20);
        btnLogin.setText("Iniciar sesión");
        btnLogin.setFocusable(false);
        btnLogin.setBackground(new Color(204, 204, 204));
        btnLogin.addMouseListener(mouse);

        separador.setBounds(40, 220, 400, 5);

        lblTexto.setForeground(Color.white);
        lblTexto.setText("Inscripciones 2021");
        lblTexto.setFont(new Font("Dialog", Font.BOLD, 18));
        lblTexto.setBounds(150, 260, 200, 30);

        frame.add(lblX);
        frame.add(lblM);
        frame.add(lblTitulo);
        frame.add(lblLogo);
        frame.add(lblNombre);
        frame.add(lblPass);
        frame.add(txtNombre);
        frame.add(pwdPass);
        frame.add(btnLogin);
        frame.add(separador);
        frame.add(lblTexto);
        frame.add(lblFondo);

        frame.setTitle("Inicio de sesión");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("logoEscuela.png"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 330);
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

            } else if (e.getSource() == btnLogin) {

                loguear();

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

    private void loguear() {
        //PrincipalPage pp = new PrincipalPage();
        String name = txtNombre.getText();
        String pass = String.valueOf(pwdPass.getPassword());
        String sql = "SELECT usuario,contrasena FROM users WHERE usuario = '" + name + "' AND contrasena = '" + pass + "'";
        String user = "";
        String contra = "";

        try {

            Statement sentencia = reg.createStatement();
            ResultSet rs = sentencia.executeQuery(sql);

            while (rs.next()) {

                user = rs.getString(1);
                contra = rs.getString(2);

            }

            if (user == "") {

                JOptionPane.showMessageDialog(null,
                        "Datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                return;

            } else {

                frame.dispose();
                PrincipalPage pp = new PrincipalPage();

            }

        } catch (Exception e) {

            System.out.println("Error" + e );
            //JOptionPane.showMessageDialog(null,
              //      "Error", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

}
