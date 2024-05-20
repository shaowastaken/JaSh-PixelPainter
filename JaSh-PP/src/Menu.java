import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Menu extends JFrame implements ActionListener {

    JPanel pTop, pCenter;
    JComboBox cb1;
    JButton btnStart;
    JLabel lb1;
    public Menu(){

        setTitle("JaSh - PixelPainter");
        setSize(400,200);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setIconImage(new ImageIcon(this.getClass().getResource("assets/JaShdefinitivo.jpg")).getImage());
        pTop = new JPanel(new FlowLayout(FlowLayout.CENTER, 20,30));

        lb1 = new JLabel("Choose the number of pixels before starting drawing");
        lb1.setFont(new Font("Arial", Font.PLAIN, 16));
        pTop.add(lb1);

        pCenter = new JPanel(new FlowLayout(FlowLayout.CENTER, 20,0));

        cb1 = new JComboBox<>();
        cb1.addItem("8");
        cb1.addItem("16");
        cb1.addItem("32");
        cb1.addItem("64");
        btnStart = new JButton("START");
        btnStart.addActionListener(this);
        pCenter.add(cb1);
        pCenter.add(btnStart);

        add(pTop, BorderLayout.NORTH);
        add(pCenter, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Gui g = new Gui(Integer.parseInt((String) cb1.getSelectedItem()));
        dispose();
    }
}
