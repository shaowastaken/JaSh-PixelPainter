import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
//import org.apache.commons.lang3.*;

public class Gui extends JFrame implements ActionListener, MouseListener, WindowListener {

    public boolean pressed = false;
    public int bits;
    JPanel pCenter, pColor, pWest, pNorth, pSouth;
    JButton btnC1, btnC2, btnC3, btnC4, btnC5, btnC6, btnC7, btnC8,btnC9,btnC10,btnC11,btnC12, btnC13,btnC14,btnC15,btnC16, btnSave,btnChange, btnResize;
    Color clr = Color.BLACK;
    JLabel lb;
    JFileChooser f;
    public Gui(int b) {
        Dimension screensize =Toolkit.getDefaultToolkit().getScreenSize();
        setTitle("JaSh - PixelPainter");
        if(screensize.width>=1920) {
            setSize(1140, 1005);
        } else  {
            setSize(760, 630);
        }
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setIconImage(new ImageIcon(this.getClass().getResource("assets/JaShdefinitivo.jpg")).getImage());
        f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.setDialogTitle("Select folder");
        bits = b;
        pNorth = new JPanel();
        lb = new JLabel("CHOOSE THE COLOR AND PAINT");
        lb.setFont(new Font("Arial", Font.PLAIN, 32));
        pNorth.add(lb);

        pWest = new JPanel(new BorderLayout());
        pColor = new JPanel(new GridLayout(9, 2));

        btnC1 = new JButton();
        btnC2 = new JButton();
        btnC3 = new JButton();
        btnC4 = new JButton();
        btnC5 = new JButton();
        btnC6 = new JButton();
        btnC7 = new JButton();
        btnC8 = new JButton();
        btnC9 = new JButton();
        btnC10 = new JButton();
        btnC11 = new JButton();
        btnC12 = new JButton();
        btnC13 = new JButton();
        btnC14 = new JButton();
        btnC15 = new JButton();
        btnC16 = new JButton();

        btnC1.addActionListener(this);
        btnC2.addActionListener(this);
        btnC3.addActionListener(this);
        btnC4.addActionListener(this);
        btnC5.addActionListener(this);
        btnC6.addActionListener(this);
        btnC7.addActionListener(this);
        btnC8.addActionListener(this);
        btnC9.addActionListener(this);
        btnC10.addActionListener(this);
        btnC11.addActionListener(this);
        btnC12.addActionListener(this);
        btnC13.addActionListener(this);
        btnC14.addActionListener(this);
        btnC15.addActionListener(this);
        btnC16.addActionListener(this);

        btnC1.setBackground(new Color(0, 0, 0));
        btnC2.setBackground(new Color(255, 255, 255));
        btnC3.setBackground(new Color(255, 0, 0));
        btnC4.setBackground(new Color(255, 165, 0));
        btnC5.setBackground(new Color(255, 255, 0));
        btnC6.setBackground(new Color(0, 255, 0));
        btnC7.setBackground(new Color(0, 0, 255));
        btnC8.setBackground(new Color(255, 0, 255));
        btnC9.setBackground(new Color(1, 152, 16));
        btnC10.setBackground(new Color(0, 255, 255));
        btnC11.setBackground(new Color(66, 49, 137));
        btnC12.setBackground(new Color(95, 95, 95));
        btnC13.setBackground(new Color(101, 67, 33));
        btnC14.setBackground(new Color(253, 221, 202));
        btnC15.setBackground(new Color(255, 192, 203));
        btnC16.setBackground(new Color(174, 160, 75));

        btnChange = new JButton("Change color");
        btnChange.addActionListener(this);

        pColor.setBackground(Color.gray);
        pColor.add(btnC1);
        pColor.add(btnC2);
        pColor.add(btnC3);
        pColor.add(btnC4);
        pColor.add(btnC5);
        pColor.add(btnC6);
        pColor.add(btnC7);
        pColor.add(btnC8);
        pColor.add(btnC9);
        pColor.add(btnC10);
        pColor.add(btnC11);
        pColor.add(btnC12);
        pColor.add(btnC13);
        pColor.add(btnC14);
        pColor.add(btnC15);
        pColor.add(btnC16);
        pColor.add(new JLabel());
        pColor.add(btnChange);

        Icon ic = new ImageIcon("assets/Empty.png");
        pCenter = new JPanel(new GridLayout(bits, bits));
        JCheckBox btn = null;
        for (int i = 0; i < Math.pow(bits, 2); i++) {
            btn = new JCheckBox();
            btn.addMouseListener(this);
            btn.setIcon(ic);
            btn.setBackground(Color.white);
            pCenter.add(btn);
            btn.setName("btn" + i);
        }
        pWest.add(new JPanel(), BorderLayout.NORTH);
        pWest.add(new JPanel(), BorderLayout.WEST);
        pWest.add(new JPanel(), BorderLayout.EAST);
        pWest.add(new JPanel(), BorderLayout.SOUTH);
        pWest.add(pColor, BorderLayout.CENTER);

        pSouth = new JPanel();
        btnSave = new JButton("SAVE");
        btnSave.addActionListener(this);
        btnResize= new JButton("RESIZE");
        btnResize.addActionListener(this);
        pSouth.add(btnSave);
        pSouth.add(btnResize);

        add(pNorth, BorderLayout.NORTH);
        add(pWest, BorderLayout.WEST);
        add(pCenter, BorderLayout.CENTER);
        add(pSouth, BorderLayout.SOUTH);

        addWindowListener(this);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }


    private BufferedImage takeImg(Component com) {
        BufferedImage img = new BufferedImage(com.getWidth(), com.getHeight(), BufferedImage.TYPE_INT_RGB);
        com.paint(img.getGraphics());
        return img;
    }

    private void saveImg(Component com, String fileName) throws Exception {

        f.showSaveDialog(null);
        fileName= f.getSelectedFile().getPath()+(char) 92 +fileName;
        BufferedImage img = takeImg(com);
        ImageIO.write(img, "png", new File(fileName));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnResize) {
            Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();

            if (screensize.width >= 1920) {
                setSize(1140, 1005);
            } else {
                setSize(760, 630);
            }
        }
        if (e.getSource() == btnSave) {
            boolean usableName = true;
            int op = JOptionPane.showConfirmDialog(this, "Are you sure that you want to save the image?", "Save the image", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (op == JOptionPane.YES_OPTION) {

                String name = JOptionPane.showInputDialog(this, "Give a name to the image", "Name the image", JOptionPane.INFORMATION_MESSAGE);
                if (!isBlank(name)) {
                    if (name.length() <= 200) {
                        for (int i = 0; i < name.length(); i++) {
                            if (name.charAt(i) == '<' || name.charAt(i) == '>' || name.charAt(i) == ':' || name.charAt(i) == '"' || name.charAt(i) == '/' || (int) name.charAt(i) == 92 || name.charAt(i) == '|' || name.charAt(i) == '?' || name.charAt(i) == '*' || name.charAt(i) == ' ') {
                                usableName = false;
                            }
                        }
                        if (usableName == false) {
                            JOptionPane.showMessageDialog(this, "The name contains a special character", "ERROR", JOptionPane.WARNING_MESSAGE);
                        } else {
                            name += ".png";
                           // System.out.println(name);
                            try {
                                saveImg(pCenter, name);
                            } catch (Exception ex) {

                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "The length of the name exceed 200 chars", "ERROR", JOptionPane.WARNING_MESSAGE);
                    }


                } else {
                    JOptionPane.showMessageDialog(this, "The name inserted is not a valid name", "ERROR", JOptionPane.WARNING_MESSAGE);
                }

            }
        } else {
            if (e.getSource() == btnC1 || e.getSource() == btnC2 || e.getSource() == btnC3 || e.getSource() == btnC4 || e.getSource() == btnC5 || e.getSource() == btnC6 || e.getSource() == btnC7 || e.getSource() == btnC8|| e.getSource() == btnC9|| e.getSource() == btnC10|| e.getSource() == btnC11|| e.getSource() == btnC12|| e.getSource() == btnC13|| e.getSource() == btnC14|| e.getSource() == btnC15|| e.getSource() == btnC16) {
                JButton btnS = (JButton) e.getSource();
                clr = btnS.getBackground();

            }else{
               if(e.getSource()==btnChange){
                   ChangeColors chCol = new ChangeColors(this);
               }
            }
            /*else{
            JCheckBox source = (JCheckBox) e.getSource();
            source.setBackground(clr);
        }*/
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!(e.getSource() == btnC1 || e.getSource() == btnC2 || e.getSource() == btnC3 || e.getSource() == btnC4 || e.getSource() == btnC5 || e.getSource() == btnC6 || e.getSource() == btnC7 || e.getSource() == btnC8|| e.getSource() == btnC9|| e.getSource() == btnC10|| e.getSource() == btnC11|| e.getSource() == btnC12|| e.getSource() == btnC13|| e.getSource() == btnC14|| e.getSource() == btnC15|| e.getSource() == btnC16)) {
            JCheckBox source = (JCheckBox) e.getSource();
            source.setBackground(clr);


        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        pressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        pressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (!(e.getSource() == btnC1 || e.getSource() == btnC2 || e.getSource() == btnC3 || e.getSource() == btnC4 || e.getSource() == btnC5 || e.getSource() == btnC6 || e.getSource() == btnC7 || e.getSource() == btnC8|| e.getSource() == btnC9|| e.getSource() == btnC10|| e.getSource() == btnC11|| e.getSource() == btnC12|| e.getSource() == btnC13|| e.getSource() == btnC14|| e.getSource() == btnC15|| e.getSource() == btnC16) && pressed == true) {
            JCheckBox source = (JCheckBox) e.getSource();
            source.setBackground(clr);


        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

        int confirm = JOptionPane.showConfirmDialog(this, "Are You Sure to Close Application?", "Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }else{

        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }
}
