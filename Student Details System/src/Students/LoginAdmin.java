package Students;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class LoginAdmin extends JFrame implements ActionListener
{
	Label title = new Label("Student Details System");
	JLabel usid = new JLabel("User ID: ");
	JTextField usidt =new JTextField();
	JLabel pass = new JLabel("Password: ");
	TextField passt=new TextField();
	
	JButton logine=new JButton("Login");
	JButton cancel=new JButton("Back");
	
	LoginAdmin()
	{
		setSize(750,680);
		setLocation(400,160);
		setTitle("Students Details System");
		getContentPane().setLayout(null);
		this.getContentPane().setBackground(new Color(238,130,238));
		Font font1 =new Font("Verdana",Font.PLAIN,20);
		
		title.setBounds(200,50,380,40);
		title.setAlignment(Label.CENTER);
		title.setFont(new Font("Serif", Font.BOLD, 30));
		getContentPane().add(title);
		
		
		usid.setBounds(200,190,200,50);
		getContentPane().add(usid);
		usid.setFont(font1);
		
		usidt.setBounds(400,190,200,50);
		getContentPane().add(usidt);
		
		
		
		pass.setBounds(200,250,200,50);
		getContentPane().add(pass);
		pass.setFont(font1);
		
		passt.setEchoChar('*');
		passt.setBounds(400,250,200,50);
		getContentPane().add(passt);


		logine.setBounds(210,400,100,50);
		getContentPane().add(logine);
		logine.addActionListener(this);

		cancel.setBounds(400,400,100,50);
		getContentPane().add(cancel);
		
		JLabel adminloginlbl = new JLabel("Admin Login");
		adminloginlbl.setFont(new Font("Serif", Font.BOLD, 24));
		adminloginlbl.setBounds(352, 129, 169, 35);
		getContentPane().add(adminloginlbl);
		cancel.addActionListener(this);

	
	
	}
	public void actionPerformed(ActionEvent e)
	{
		String s1=usidt.getText();
		String s2=passt.getText();
		
		if(e.getActionCommand()=="Login")
		{
			try 
			{
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Nayana@19");
	            String sql = "select * from admintbl where username=? and password=?";
                PreparedStatement ps = con.prepareStatement(sql);
                String user;
				ps.setString(1, s1);
                String pwd;
				ps.setString(2, s2);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    String uname = rs.getString("username");
                    String pass = rs.getString("password");
                    if ((s1.equals(uname) && s2.equals(pass)))
                    {
                            JOptionPane.showMessageDialog(null,
                                    "Admin Login Successful.");
                            AdminDash oa =new AdminDash();
                            oa.setLocationRelativeTo(null);
        					oa.setVisible(true);
        					dispose();
                           
                    }
                    else {
                            JOptionPane.showMessageDialog(null,
                                    "No user found!.");

                        }

                 }  
               
			}
			catch(Exception err)
			{
				System.out.println(err);
			}
		}
				   
		if(e.getActionCommand()=="Back")
		{
			FrontPage s= new FrontPage();
			s.setLocationRelativeTo(null);
			s.setVisible(true);
			dispose();
			}
	}
	public static void main(String args[])
	{
		LoginAdmin le = new LoginAdmin();
		le.setLocationRelativeTo(null);
		le.setDefaultCloseOperation(3);
		le.setVisible(true);
		
	}
}
