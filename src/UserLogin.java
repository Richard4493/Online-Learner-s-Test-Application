import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLogin extends JFrame {

    private JTextField tf,id;
    private JPasswordField pf;
    private JButton btn;
    private JLabel lbl1,lbl2,lbl3,lbl4;
    private JPanel ul;

    public static void main(String[] args) {

        UserLogin frame = new UserLogin();
        frame.setVisible(true);
    }

    /* Create the frame. */
    public UserLogin() {
        setBounds(450, 190, 1000, 600);
        setResizable(false);
        ul = new JPanel();
        setContentPane(ul);
        ul.setLayout(null);

        lbl1 = new JLabel("Login");
        lbl1.setForeground(Color.BLACK);
        lbl1.setFont(new Font("Standard", Font.PLAIN, 45));
        lbl1.setBounds(420, 15, 270, 90);
        ul.add(lbl1);

        tf = new JTextField();
        tf.setFont(new Font("Standard", Font.PLAIN, 32));
        tf.setBounds(480, 170, 280, 70);
        ul.add(tf);
        tf.setColumns(10);

        id = new JTextField();
        id.setFont(new Font("Standard", Font.PLAIN, 32));
        id.setBounds(480, 250, 280, 70);
        ul.add(id);

        pf = new JPasswordField();
        pf.setFont(new Font("Standard", Font.PLAIN, 32));
        pf.setBounds(480, 350, 280, 70);
        ul.add(pf);

        lbl2 = new JLabel("Username");
        lbl2.setBackground(Color.BLACK);
        lbl2.setForeground(Color.BLACK);
        lbl2.setFont(new Font("Standard", Font.PLAIN, 31));
        lbl2.setBounds(250, 165, 190, 50);
        ul.add(lbl2);

        lbl4 = new JLabel("ID");
        lbl4.setBackground(Color.BLACK);
        lbl4.setForeground(Color.BLACK);
        lbl4.setFont(new Font("Standard", Font.PLAIN, 31));
        lbl4.setBounds(250, 250, 150, 50);
        ul.add(lbl4);

        lbl3 = new JLabel("Password");
        lbl3.setForeground(Color.BLACK);
        lbl3.setBackground(Color.CYAN);
        lbl3.setFont(new Font("Standard", Font.PLAIN, 31));
        lbl3.setBounds(250, 350, 190, 50);
        ul.add(lbl3);

        btn = new JButton("Login");
        btn.setFont(new Font("Standard", Font.PLAIN, 26));
        btn.setBounds(550, 450, 160, 70);
        ul.add(btn);
        btn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String idn = id.getText();
                String userName = tf.getText();
                String password = pf.getText();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/login",
                            "root", "Richard@123");

                    PreparedStatement st = (PreparedStatement) connection
                            .prepareStatement("Select  id,name,password from user where id=? and name=? and password=?");

                    st.setString(1,idn);
                    st.setString(2, userName);
                    st.setString(3, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        dispose();
                        JOptionPane.showMessageDialog(btn, "You have successfully logged in to the test");
                        new LTest();
                    } else {
                        JOptionPane.showMessageDialog(btn, "Wrong Username or Password, Try again");
                        tf.setText("");
                        id.setText("");
                        pf.setText("");
                    }
                } catch (Exception ea) {
                    ea.printStackTrace();
                }
            }
        });

    }
}

class LTest implements ActionListener {
    JFrame fr;
    JRadioButton rb1, rb2, rb3, rb4, rb5;
    JButton b1,b4, b5;
    JLabel lb1, lb2, lb3;
    ButtonGroup bg;
    String ques[] = {"1.On a road designated as one way", "2. You can overtake a vehicle in front", "3.It is permissible to exceed the speed limit…?", "4.Learner's licence is valid for how long?", "5.A PUCC (Pollution Under Control Certificate) is valid for how long from the date of issue?", "6.What shape is a mandatory traffic sign?", "7.Your insurance has expired. How long can you legally drive your vehicle before you renew it?", "8.Traveling at 60 km/h, how far will your vehicle travel in a single second?", "9.How many vehicle lengths should you leave to the vehicle in front when driving at 45 km/h?", "10.A cautionary traffic sign is what shape?", "11.To ride a motorcycle without gears, a person must be at least what age?", "12.involved in a motor accident, how long do you have to report it to the nearest police station?", "13.If you drive while drunk, you can face a term of imprisonment of - months?", "14.If a sign is rectangular in shape, what does it convey?", "15.When refueling your vehicle, you must not…?", "16.near an educational institution, what is the maximum speed", "17.When you buy a new car, the tax which you pay lasts for how long?", "18.When driving on a ghat road, the maximum speed permitted is…?", "19.towing another vehicle, you may use a rope that is no longer than ____ from your vehicle", "20.The maximum number of persons permitted on a tractor is…?"," "};
    String op1[] = {"Parking is prohibited", "Through Left", "On empty roads", "1 Year", "4 Months", "circular", "0 days", "12.2 m", "4", "triangular", "16", "24 hrs", "4", "instruction", "chat", "13 kmph", "10 yr", "25", "1M", "3"," "};
    String op2[] = {"Overtaking is prohibited ", "Through Right", "While overtaking", "6 Months", "8 Months", "square", "3 days", "4.3 m", "3", "circular", "15", "72 hrs", "1", "warning", "smoke", "14 kmph", "5 yr", "55", "3M", "4"," "};
    String op3[] = {"Should not drive in reverse", "Through narrow way", "Under no conditions", "8 Months", "12 Months", "triangle", "1 week", "8.6 m", "1", "square", "14", "48 hrs", "3", "ad", "drink", "35 kmph", "15 yr", "45", "5M", "1"," "};
    String op4[] = {"None of above", "By Honking rapidly", "in a perfect condition", "Lifelong", "20 Months", "rectangle", "1 month", "16.6 m", "2", "oval", "17", "12 hrs", "6", "information", "eat", "25 kmph", "20 yr", "35", "2M", "2",""};
    String ans[] = {"Should not drive in reverse", "Through Right", "Under no conditions", "6 Months", "12 Months", "circular", "0 days", "16.6 m", "2", "triangular", "16", "24 hrs", "6", "information", "smoke", "25 kmph", "15 yr", "35", "5M", "1"," "};
    String co[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
    int cn = 0;
    int qc = 0;
    int ca = 0;
    int wa = 0;

    LTest() {
        fr = new JFrame();
        fr.setLayout(null);
        fr.setSize(1600, 1200);
        Container c = fr.getContentPane();
        c.setBackground(Color.BLACK);
        lb1 = new JLabel(ques[0]);
        lb1.setBounds(150, 50, 1500, 30);
        fr.add(lb1);
        lb1.setFont(new Font("CLASSIC", Font.ITALIC, 30));
        lb1.setForeground(Color.WHITE);
        lb2 = new JLabel("Questions Completed:");
        lb2.setBounds(800, 600, 600, 30);
        lb2.setFont(new Font("CLASSIC", Font.ITALIC, 30));
        lb2.setForeground(Color.WHITE);
        fr.add(lb2);
        lb3 = new JLabel("Score :");
        lb3.setBounds(800, 680, 600, 30);
        lb3.setFont(new Font("CLASSIC", Font.ITALIC, 30));
        lb3.setForeground(Color.WHITE);
        fr.add(lb3);
        rb1 = new JRadioButton(op1[cn]);
        rb1.setBounds(450, 220, 300, 50);
        rb1.setFont(new Font("Standard", Font.PLAIN, 20));
        fr.add(rb1);
        rb2 = new JRadioButton(op2[cn]);
        rb2.setBounds(1000, 220, 300, 50);
        rb2.setFont(new Font("Standard", Font.PLAIN, 20));
        fr.add(rb2);
        rb3 = new JRadioButton(op3[cn]);
        rb3.setBounds(450, 400, 300, 50);
        rb3.setFont(new Font("Standard", Font.PLAIN, 20));
        fr.add(rb3);
        rb4 = new JRadioButton(op4[cn]);
        rb4.setBounds(1000, 400, 300, 50);
        rb4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        fr.add(rb4);
        bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        bg.add(rb4);
        bg.add(rb5);
        rb1.addActionListener(this);
        rb2.addActionListener(this);
        rb3.addActionListener(this);
        rb4.addActionListener(this);
        b1 = new JButton("Submit >>");
        b1.setBounds(775, 500, 200, 40);
        b1.setFont(new Font("Standard", Font.PLAIN, 20));
        fr.add(b1);
        b4 = new JButton(co[0]);
        b4.setBounds(1200, 600, 50, 30);
        fr.add(b4);
        b5 = new JButton(co[0]);
        b5.setBounds(1200, 680, 50, 30);
        fr.add(b5);
        b1.addActionListener(this);
        fr.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String en = "";
            if (rb1.isSelected())
                en = rb1.getText();
            if (rb2.isSelected())
                en = rb2.getText();
            if (rb3.isSelected())
                en = rb3.getText();
            if (rb4.isSelected())
                en = rb4.getText();
            if (en.equals(ans[cn])) {
                JOptionPane.showMessageDialog(null, "Right Answer");
                ca++;
                b5.setText(co[ca]);
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Answer");
                wa++;
            }
            qc++;
            b4.setText(co[qc]);
            cn++;
            lb1.setText(ques[cn]);
            rb1.setText(op1[cn]);
            rb2.setText(op2[cn]);
            rb3.setText(op3[cn]);
            rb4.setText(op4[cn]);
            if (ca == 12) /* person passes the test if he scores 12 out of 20 */ {
                JOptionPane.showMessageDialog(null, "CONGO!!,YOU PASSED THE TEST");
                fr.dispose();
            }
            if (wa == 9) /* person fails the test if he scores less than 12 out of  20(20-9=11) */ {
                JOptionPane.showMessageDialog(null, "FAILED!!Better Luck Next Time");
                fr.dispose();
            }

        }

    }
}