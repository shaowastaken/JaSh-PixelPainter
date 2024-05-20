//import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ChangeColors extends JFrame implements ActionListener, WindowListener {

    JRadioButton btnC1, btnC2, btnC3, btnC4, btnC5, btnC6, btnC7, btnC8, btnC9, btnC10, btnC11, btnC12, btnC13, btnC14, btnC15, btnC16;
    JButton btnChange, btnSave;
    JPanel pColor, pModify, pMCenter;
    JLabel lb;
    JTextField tfInput;
    ButtonGroup bg;
    Gui gui;

    ChangeColors(Gui g) {
        setTitle("JaSh - PixelPainter");
        setSize(800, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 2));
        setIconImage(new ImageIcon(this.getClass().getResource("assets/JaShdefinitivo.jpg")).getImage());
        addWindowListener(this);
        gui = g;
        bg = new ButtonGroup();
        pColor = new JPanel(new GridLayout(8, 2));

        btnC1 = new JRadioButton();
        btnC2 = new JRadioButton();
        btnC3 = new JRadioButton();
        btnC4 = new JRadioButton();
        btnC5 = new JRadioButton();
        btnC6 = new JRadioButton();
        btnC7 = new JRadioButton();
        btnC8 = new JRadioButton();
        btnC9 = new JRadioButton();
        btnC10 = new JRadioButton();
        btnC11 = new JRadioButton();
        btnC12 = new JRadioButton();
        btnC13 = new JRadioButton();
        btnC14 = new JRadioButton();
        btnC15 = new JRadioButton();
        btnC16 = new JRadioButton();

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

        btnC1.setBackground(gui.btnC1.getBackground());
        btnC2.setBackground(gui.btnC2.getBackground());
        btnC3.setBackground(gui.btnC3.getBackground());
        btnC4.setBackground(gui.btnC4.getBackground());
        btnC5.setBackground(gui.btnC5.getBackground());
        btnC6.setBackground(gui.btnC6.getBackground());
        btnC7.setBackground(gui.btnC7.getBackground());
        btnC8.setBackground(gui.btnC8.getBackground());
        btnC9.setBackground(gui.btnC9.getBackground());
        btnC10.setBackground(gui.btnC10.getBackground());
        btnC11.setBackground(gui.btnC11.getBackground());
        btnC12.setBackground(gui.btnC12.getBackground());
        btnC13.setBackground(gui.btnC13.getBackground());
        btnC14.setBackground(gui.btnC14.getBackground());
        btnC15.setBackground(gui.btnC15.getBackground());
        btnC16.setBackground(gui.btnC16.getBackground());


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

        bg.add(btnC1);
        bg.add(btnC2);
        bg.add(btnC3);
        bg.add(btnC4);
        bg.add(btnC5);
        bg.add(btnC6);
        bg.add(btnC7);
        bg.add(btnC8);
        bg.add(btnC9);
        bg.add(btnC10);
        bg.add(btnC11);
        bg.add(btnC12);
        bg.add(btnC13);
        bg.add(btnC14);
        bg.add(btnC15);
        bg.add(btnC16);

        pModify = new JPanel(new BorderLayout());
        pMCenter = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 50));
        lb = new JLabel("Change the colors of the palette");
        lb.setHorizontalAlignment(JLabel.CENTER);
        lb.setFont(new Font("Arial", Font.PLAIN, 16));
        tfInput = new JTextField(10);
        btnChange = new JButton("CHANGE");
        btnChange.addActionListener(this);
        btnSave = new JButton("SAVE");
        btnSave.addActionListener(this);

        pMCenter.add(tfInput);
        pMCenter.add(btnChange);
        pMCenter.add(btnSave);

        pModify.add(lb, BorderLayout.NORTH);
        pModify.add(pMCenter, BorderLayout.CENTER);

        add(pColor);
        add(pModify);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean valid = true;
        String s = tfInput.getText();
        int co, lo, r;
        btnC1.setText("");
        btnC2.setText("");
        btnC3.setText("");
        btnC4.setText("");
        btnC5.setText("");
        btnC6.setText("");
        btnC7.setText("");
        btnC8.setText("");
        btnC9.setText("");
        btnC10.setText("");
        btnC11.setText("");
        btnC12.setText("");
        btnC13.setText("");
        btnC14.setText("");
        btnC15.setText("");
        btnC16.setText("");
        if (!isBlank(s)) {
            for (int i = 0; i < s.length(); i++) {
                if ((s.toUpperCase().charAt(i) != '0' && s.toUpperCase().charAt(i) != '1' && s.toUpperCase().charAt(i) != '2' && s.toUpperCase().charAt(i) != '3' && s.toUpperCase().charAt(i) != '4' && s.toUpperCase().charAt(i) != '5' && s.toUpperCase().charAt(i) != '6' && s.toUpperCase().charAt(i) != '7' && s.toUpperCase().charAt(i) != '8' && s.toUpperCase().charAt(i) != '9' && s.toUpperCase().charAt(i) != 'A' && s.toUpperCase().charAt(i) != 'B' && s.toUpperCase().charAt(i) != 'C' && s.toUpperCase().charAt(i) != 'D' && s.toUpperCase().charAt(i) != 'E' && s.toUpperCase().charAt(i) != 'F') || s.length() != 6) {
                    valid = false;
                }
            }
            if (valid == true) {
                co = Integer.valueOf(s.substring(0, 2), 16);
                lo = Integer.valueOf(s.substring(2, 4), 16);
                r = Integer.valueOf(s.substring(4, 6), 16);
                Color c = new Color(co, lo, r);
                if (e.getSource() == btnChange) {
                    if (btnC1.isSelected()) {
                        btnC1.setBackground(c);
                    } else {
                        if (btnC2.isSelected()) {
                            btnC2.setBackground(c);
                        } else {
                            if (btnC3.isSelected()) {
                                btnC3.setBackground(c);
                            } else {
                                if (btnC4.isSelected()) {
                                    btnC4.setBackground(c);
                                } else {
                                    if (btnC5.isSelected()) {
                                        btnC5.setBackground(c);
                                    } else {
                                        if (btnC6.isSelected()) {
                                            btnC6.setBackground(c);
                                        } else {
                                            if (btnC7.isSelected()) {
                                                btnC7.setBackground(c);
                                            } else {
                                                if (btnC8.isSelected()) {
                                                    btnC8.setBackground(c);
                                                } else {
                                                    if (btnC9.isSelected()) {
                                                        btnC9.setBackground(c);
                                                    } else {
                                                        if (btnC10.isSelected()) {
                                                            btnC10.setBackground(c);
                                                        } else {
                                                            if (btnC11.isSelected()) {
                                                                btnC11.setBackground(c);
                                                            } else {
                                                                if (btnC12.isSelected()) {
                                                                    btnC12.setBackground(c);
                                                                } else {
                                                                    if (btnC13.isSelected()) {
                                                                        btnC13.setBackground(c);
                                                                    } else {
                                                                        if (btnC14.isSelected()) {
                                                                            btnC14.setBackground(c);
                                                                        } else {
                                                                            if (btnC15.isSelected()) {
                                                                                btnC15.setBackground(c);
                                                                            } else {
                                                                                if (btnC16.isSelected()) {
                                                                                    btnC16.setBackground(c);
                                                                                } else {

                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }

                                                }

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (e.getSource() == btnSave) {
                        gui.btnC1.setBackground(btnC1.getBackground());
                        gui.btnC2.setBackground(btnC2.getBackground());
                        gui.btnC3.setBackground(btnC3.getBackground());
                        gui.btnC4.setBackground(btnC4.getBackground());
                        gui.btnC5.setBackground(btnC5.getBackground());
                        gui.btnC6.setBackground(btnC6.getBackground());
                        gui.btnC7.setBackground(btnC7.getBackground());
                        gui.btnC8.setBackground(btnC8.getBackground());
                        gui.btnC9.setBackground(btnC9.getBackground());
                        gui.btnC10.setBackground(btnC10.getBackground());
                        gui.btnC11.setBackground(btnC11.getBackground());
                        gui.btnC12.setBackground(btnC12.getBackground());
                        gui.btnC13.setBackground(btnC13.getBackground());
                        gui.btnC14.setBackground(btnC14.getBackground());
                        gui.btnC15.setBackground(btnC15.getBackground());
                        gui.btnC16.setBackground(btnC16.getBackground());
                        dispose();
                    }
                }
            } else {
                if (valid == false && (e.getSource() == btnChange || e.getSource() == btnSave)) {
                    JOptionPane.showMessageDialog(this, "The color code is not valid", "ERROR", JOptionPane.WARNING_MESSAGE);
                    tfInput.setText("");
                }
            }

        } else {
            if (e.getSource() == btnChange || e.getSource() == btnSave) {
                JOptionPane.showMessageDialog(this, "The color code is not valid", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.dispose();
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
