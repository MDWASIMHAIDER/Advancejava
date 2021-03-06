package com.nt.jdbc;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GuiAppUsingThreeStatement extends JFrame implements ActionListener{
	public static final String INSERT_STUDENT_QUERY="INSERT INTO STUDENT VALUES(?,?,?)";
	private JLabel lno,lname,lm1,lm2,lm3,lres;
	private JTextField tname,tm1,tm2,tm3,tres;
	private JButton bdetails,bresult;
	private JComboBox tno;
	private Statement st;
	private ResultSet rs1,rs2;
	private CallableStatement cs;
	private Connection con;
	private PreparedStatement ps;
	public GuiAppUsingThreeStatement() {
		System.out.println("o param constructor");
		//super class method directly invoked in child class
		setTitle("MINI PROJECT ");
		setBackground(Color.green);
		setLayout(new FlowLayout());
		setSize(650,450);
		lno=new JLabel("Student Id:");
		add(lno);
		tno=new JComboBox();
		add(tno);
		bdetails=new JButton("details");
		bdetails.addActionListener(this);
		add(bdetails);
		lname=new JLabel("Name");
		add(lname);
		tname=new JTextField(10);
		add(tname);
		lm1=new JLabel("marks1");
		add(lm1);
		tm1=new JTextField();
		add(tm1);
		lm2=new JLabel("marks2");
		add(lm2);
		tm2=new JTextField();
		add(tm2);
		lm3=new JLabel("marks3");
		add(lm3);
		tm3=new JTextField();
		add(tm3);
		bresult=new JButton("result");
		bresult.addActionListener(this);
		add(bresult);
		lres=new JLabel("result");
		add(lres);
		tres=new JTextField(10);
		add(tres);
		//disabling text field for editing
		tname.setEditable(false);
		tm1.setEditable(false);
		tm2.setEditable(false);
		tm3.setEditable(false);
		tres.setEditable(false);
		setVisible(true);
		this.addWindowListener(new MyWindowAdapter());
		loadItems();
	}//constructor
	
	private void loadItems() {
		System.out.println("load item ()");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			if(con!=null)
				st=con.createStatement();
			if(st!=null)
				rs1=st.executeQuery("select sno from student_marks");
				if(rs1!=null) {
					while(rs1.next()) {
						tno.addItem(rs1.getInt(1));
						
					}//while
				}//if
				if(con!=null)
					ps=con.prepareStatement("select *from student_marks where sno=?");
					if(con!=null) {
						cs=con.prepareCall("{call find_pass_fail(?,?,?,?)}");
						cs.registerOutParameter(4,Types.VARCHAR);
					}//if
		   }//try
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(ClassNotFoundException cnf) {
				cnf.printStackTrace();
			}
		}//load item
		@Override
		public void actionPerformed(ActionEvent ae) {
			int m1=0,m2=0,m3=0;
			String result=null;
			System.out.println("actionperformed");
			if(ae.getSource()==bdetails) {
				System.out.println("details button is clicked");
				try{
					//get the selected value from combobox
					int no=(Integer)tno.getSelectedItem();
					//set value to query param
					if(ps!=null) {
						ps.setInt(1,no);
						//execute query
						rs2=ps.executeQuery();
					}
					//set result obj record to text boxes
					if(rs2!=null) {
						if(rs2.next()) {
							tname.setText(rs2.getString(2));
							tm1.setText(rs2.getString(3));
							tm2.setText(rs2.getString(4));
							tm3.setText(rs2.getString(5));
						}//if
					}//if
				}//try
				catch(SQLException se) {
					se.printStackTrace();
				}
			}//if
			else {
				System.out.println("result btn is clicked");
				try {
					//read text box vlaues m1,m2,m3
					m1=Integer.parseInt(tm1.getText());
					m2=Integer.parseInt(tm2.getText());
					m3=Integer.parseInt(tm3.getText());
					//set value to in parameter
					if(cs!=null) {
						cs.setInt(1,m1);
						cs.setInt(2, m2);
						cs.setInt(3, m3);
						//execute pl sql peocedure
						cs.execute();
						//gather value from out param and get result
						result=cs.getString(4);
						//set result to text box
						tres.setText(result);
						
					}//if
					
				}//try
				catch(SQLException se) {
					se.printStackTrace();
				}//catch
			}//else 
		}//actionperformed
	
		public static void main(String[] args) {
			System.out.println("main method");
			GuiAppUsingThreeStatement gts=new GuiAppUsingThreeStatement();
		}//main
		private class MyWindowAdapter extends WindowAdapter{
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("window closing");
				try {
					if(rs1!=null)
						rs1.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
				try {
					if(rs2!=null)
						rs2.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
				try {
					if(cs!=null)
						cs.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
				try {
					if(st!=null)
						st.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
				try {
					if(ps!=null)
						ps.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
				try {
					if(con!=null)
						con.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
			}
		}
}//class
