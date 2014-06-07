import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JButton;
import java.sql.*;
import java.awt.print.*;
import java.awt.Graphics.*;
import java.awt.image.*;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import javax.swing.GrayFilter;
class Connectivity
{
public static Connection getConnection() throws Exception {
    String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
    String url = "jdbc:odbc:abc";
    String username = "HR";
    String password = "hr";
    Class.forName(driver);
    Connection conn = DriverManager.getConnection(url, username, password);
    return conn;
  }
}
class NoSeats extends JFrame implements ActionListener
{
	Label l;String uname;
	JButton b;
	NoSeats(String uname)
	{
		this.uname=uname;
		setTitle("Sorry");
		setSize(200,200);
		setLayout(new FlowLayout());
		l=new Label(" There are no seats available for the requested bus");
		b=new JButton("Ok! Replan");
		b.addActionListener(this);
		add(l);
		add(b);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s=ae.getActionCommand();
		if(s.equals("Ok! Replan"))
		{
			dispose();
			JFrame frame1 = new Roadways(uname);
   		 frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension minSize = new Dimension(500,500);
		frame1.setMinimumSize(minSize);	
    		 frame1.pack();
   		 frame1.setVisible(true);
		}
	}
}
			
class WrongPassword extends JFrame implements ActionListener
{
	Label l;
	JButton b;
	String s;
	WrongPassword()
	{
	setTitle("Invalid Login");
	setSize(200,200);
	setLayout(new FlowLayout());
	l=new Label("Wrong Password entered buddy!!!");
	b=new JButton("ok");
	b.addActionListener(this);
	add(l);
	add(b);
	}
	public void actionPerformed(ActionEvent ae)
	{
		s=ae.getActionCommand();
		if(s.equals("ok"))
		{	
			dispose();
		}
	}
}
class WrongUname extends JFrame implements ActionListener
{
	Label l;
	JButton b;
	String s;
	WrongUname()
	{
	setTitle("Invalid Login");
	setSize(200,200);
	setLayout(new FlowLayout());
	l=new Label("Wrong Username entered!!!");
	b=new JButton("ok");
	b.addActionListener(this);
	add(l);
	add(b);
	}
	public void actionPerformed(ActionEvent ae)
	{
		s=ae.getActionCommand();
		if(s.equals("ok"))
		{	
			dispose();
		}
	}
}
class NewUser extends JFrame implements ActionListener
{
	Label l;
	JButton b;
	NewUser()
	{	
		setTitle("User Created");
		
		setLayout(null);
		JLabel l= new JLabel("New User Created");
		java.awt.Font font = new java.awt.Font("Arial",Font.BOLD,20);
		l.setFont(font);
		
		b=new JButton("ok");
		b.addActionListener(this);
		add(l);
		add(b);
		l.setBounds(30,10,250,30);
		b.setBounds(75,50,100,25);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s=ae.getActionCommand();
		if(s.equals("ok"))
		{
		dispose();
		JFrame frame1 = new Login();
   		 frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension minSize = new Dimension(500,500);
		frame1.setMinimumSize(minSize);	
    		 frame1.pack();
   		 frame1.setVisible(true);
		}
	}
}
					
class Signup extends JFrame implements ActionListener,TextListener,ItemListener
{
	Label l1,l2,l3,l4,l5,l6,l7;
	TextField t1,t2,t3,t4,t5,t6;
	Choice ch;
	JButton b1;
	String id;
	Connectivity cn=new Connectivity();
	Signup()
	{
		setTitle("New User Sign up");
		setLayout(null);
		
		l1=new Label("Username");
		l2=new Label("Password");
		l3=new Label("Confirm Password");
		l4=new Label("Name");
		l5=new Label("Phone number");
		l6=new Label("Email-id");
		l7=new Label("ID Proof");
		t1=new TextField(15);
		t2=new TextField(15);
		t3=new TextField(15);
		t4=new TextField(30);
		t5=new TextField(12);
		t6=new TextField(30);
		ch=new Choice();
		ch.addItem("Passport number");
		ch.addItem("License number");
		ch.addItem("Aadhar card number");
		ch.addItem("SSN");
		ch.addItem("Pan card number");
		b1=new JButton("Submit");
		b1.addActionListener(this);
		t2.addTextListener(this);
		t3.addTextListener(this);
		ch.addItemListener(this);
		
		JLabel label = new JLabel("SSS TRAVELS");
		java.awt.Font font = new java.awt.Font("Arial",Font.BOLD,30);
		label.setFont(font);
		add(label);
		add(l1);add(t1);
		add(l2);add(t2);
		add(l3);add(t3);
		add(l4);add(t4);
		add(l5);add(t5);
		add(l7);add(ch);
		add(l6);add(t6);
		add(b1);
		label.setBounds(250,0,300,100);
		l1.setBounds(30,100,75,30);
		t1.setBounds(160,100,120,25);
		l2.setBounds(30,150,75,30);
		t2.setBounds(160,150,120,25);
		l3.setBounds(30,200,120,30);
		t3.setBounds(160,200,120,25);
		l4.setBounds(30,250,75,30);
		t4.setBounds(160,250,120,25);
		l5.setBounds(30,300,100,30);
		t5.setBounds(160,300,120,25);
		l6.setBounds(30,350,75,30);
		t6.setBounds(160,350,250,25);
		l7.setBounds(30,400,75,25);
		ch.setBounds(160,400,200,25);
		b1.setBounds(100,450,100,25);
	}
	public void itemStateChanged(ItemEvent i)
		{
			if(i.getSource()==ch)
			{
				id=ch.getSelectedItem();
			}
	
		}
	public void actionPerformed(ActionEvent ae)
	{	String s=ae.getActionCommand();	
		if(s.equals("Submit"))
		{
		String s1=t1.getText();
		String s2=t2.getText();
		String s3=t4.getText();
		String s4=t5.getText();
		long phno=Long.parseLong(s4);
		String s5=t6.getText();
		 Connection conn = null;
		  Statement stmt = null;
    		  ResultSet rs = null;
    		try {
      			conn = cn.getConnection();
	 		String query = "insert into passenger values('"+s1+"','"+s2+"','"+id+"','"+s3+"',"+phno+",'"+s5+"')";
			stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
	
    			   stmt.executeUpdate(query);
      			conn.commit();
		 } catch (Exception e) {
      				e.printStackTrace();
    				} finally {
     					 try{
        						
       						 stmt.close();
        						conn.close();
					}
					catch(SQLException e)
						{}
     					  }
		dispose();
		JFrame frame1 = new NewUser();
   		 frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension minSize = new Dimension(250,250);
		frame1.setMinimumSize(minSize);	
    		 frame1.pack();
   		 frame1.setVisible(true);		
		}
	}
		
	public void textValueChanged(TextEvent t)
	{
		t2.setEchoChar('*');
		t3.setEchoChar('*');
	}
}	
		
class Login extends JFrame implements ActionListener,TextListener
{
	Label l1,l2,l3,l4;
	TextField t1,t2;
	JButton b1,b2;
	String uname,pass;
	
	Connectivity cn=new Connectivity();
	Login()
	{
		setTitle("Login");
		setSize(500,500);
		setLayout(null);
		l1=new Label("New user?Sign up");
		//l2=new Label("Login");
		l3=new Label("Username");
		l4=new Label("Password");
		t1=new TextField(15);
		t2=new TextField(15);
		b1=new JButton("Login");
		b2=new JButton("Sign up");
		b1.addActionListener(this);
		b2.addActionListener(this);
		t2.addTextListener(this);
		
		JLabel label = new JLabel("SSS TRAVELS");
		java.awt.Font font = new java.awt.Font("Arial",Font.BOLD,30);
		label.setFont(font);
		JLabel l2 = new JLabel("Login");
		java.awt.Font font1 = new java.awt.Font("Arial",Font.ITALIC,22);
		label.setFont(font1);
		add(label);
		add(l1);      
		add(l2);
		add(l3);	add(t1);
		add(l4);	add(t2);
		
		add(b1);	add(b2);
		label.setBounds(175,0,200,100);
		l2.setBounds(20,100,50,30);
		l3.setBounds(30,150,75,20);
		t1.setBounds(125,150,100,25);
		l4.setBounds(30,200,75,20);
		t2.setBounds(125,200,100,25);
		b1.setBounds(30,250,100,25);
		l1.setBounds(30,280,150,20);
		b2.setBounds(30,310,100,25);
		setVisible(true);
	}
	public void textValueChanged(TextEvent te)
	{
		t2.setEchoChar('*');
	}
	


	public void actionPerformed(ActionEvent ae)
	{
		String s=ae.getActionCommand();
		if(s.equals("Sign up"))
		{	
			dispose();
			JFrame frame1 = new Signup();
   		 frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension minSize = new Dimension(700,700);
		frame1.setMinimumSize(minSize);	
    		 frame1.pack();
   		 frame1.setVisible(true);
		}
		if(s.equals("Login"))
		{
			uname=t1.getText();
			pass=t2.getText();
			Connection conn = null;
		  Statement stmt = null;
    		  ResultSet rs = null;
    		try {
      			conn = cn.getConnection();
	 		String query = "select username from passenger where username='"+uname+"'";
			String query1=" select password from passenger where password ='"+pass+"'";
			stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
	
    			  rs=stmt.executeQuery(query);
      			conn.commit();
			String s1=null,s2=null;
     			 while (rs.next()) {
       					 s1 = rs.getString("username");
       					}
	
				if(s1!=null)
				{
				rs=stmt.executeQuery(query1);
				conn.commit();
				
				while (rs.next()) {
       					 s2 = rs.getString("password");
       					}
				if(s2!=null)
				{
					dispose();setVisible(false);
					JFrame frame1 = new Roadways(uname);
   		 			frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					Dimension minSize = new Dimension(750,750);
					frame1.setMinimumSize(minSize);	
    		 			frame1.pack();
   					 frame1.setVisible(true);
				}
				else
				{
				t1.setText("");t2.setText("");
				JFrame frame1 = new WrongPassword();
   		 		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Dimension minSize = new Dimension(200,200);
				frame1.setMinimumSize(minSize);	
    		 		frame1.pack();
   		 		frame1.setVisible(true);
				}
				}
				else
				{
				t1.setText("");t2.setText("");
				JFrame frame1 = new WrongUname();
   		 		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Dimension minSize = new Dimension(200,200);
				frame1.setMinimumSize(minSize);	
    		 		frame1.pack();
   		 		frame1.setVisible(true);
				}			
				 } catch (Exception e) {
      				e.printStackTrace();
    				} finally {
     					 try{
        						//rs.close();
       						 stmt.close();
        						conn.close();
					}
					catch(SQLException e)
						{}
     					  }
			
			
		}
	}
}

class PrintPage extends JFrame implements ActionListener,TextListener,Printable
         {
	    
	Label l1,l2,l3,l4,l5,l6,l7,l8,l9;
	TextField t1,t2,t3,t4,t6,t7,t8,t9;
	TextField t5;String display,display1,display2,display3,display4;
	String uname;int ticketno;String name;String busno;String date;
	String source,destination,noofseats,phno,emailid;
	PrintPage(String uname,int ticketno)
	        {
		setTitle("PrintPage");
		setSize(380,430);
		setLayout(null);
		this.uname=uname;
		this.ticketno=ticketno;
		l1=new Label(" Reservation number: ");
		l2=new Label("Name:");
		
		l4=new Label("Contact Number:");
		l5=new Label("Email-Id:");
		l6=new Label("Bus No.");
		l7=new Label("Date:");
		l3=new Label("No of seats");
		l8=new Label("Origin");
		l9=new Label("Destination");
		
		t1=new TextField(35);
		t2=new TextField(13);
		t3=new TextField(13);
		t4=new TextField(35);
		t5=new TextField(3);
		t6=new TextField(35);
		t7=new TextField(35);
		t8=new TextField(33);
		t9=new TextField(32);		
		
		JButton b=new JButton("Print");
		
		JLabel label = new JLabel("SSS TRAVELS");
		java.awt.Font font = new java.awt.Font("Arial",Font.BOLD,30);
		label.setFont(font);
		add(label);
		add(l1);add(t3);
		add(l2);add(t1);
		
		add(l4);add(t2);
		add(l5);add(t4);
		add(l6);add(t6);
		add(l7);add(t7);
		add(l3);add(t5);
		add(l8);add(t8);
		add(l9);add(t9);
		add(b);
		label.setBounds(250,0,300,50);
		l1.setBounds(30,100,120,30);
		t3.setBounds(170,100,50,20);
		l7.setBounds(240,100,50,20);
		t7.setBounds(300,100,75,20);
		l2.setBounds(30,150,50,20);
		t1.setBounds(120,150,50,20);
		l4.setBounds(240,150,100,20);
		t2.setBounds(380,150,100,20);
		l6.setBounds(30,200,50,20);
		t6.setBounds(120,200,50,20);
		l3.setBounds(240,200,100,20);
		t5.setBounds(360,200,50,20);
		l8.setBounds(30,250,75,20);
		t8.setBounds(120,250,125,20);
		l9.setBounds(265,250,75,20);
		t9.setBounds(340,250,125,20);
		l5.setBounds(30,300,75,20);
		t4.setBounds(120,300,200,20);
		b.setBounds(100,350,100,25);		
		b.addActionListener(this);
		t1.addTextListener(this);
		t2.addTextListener(this);
		t3.addTextListener(this);
		t4.addTextListener(this);
		t6.addTextListener(this);
		t7.addTextListener(this);
		t8.addTextListener(this);
		t9.addTextListener(this);
		
		int a=ticketno;
		Integer temp=new Integer(a);
		String ticket_no=temp.toString();
		t3.setText(ticket_no);	
		Connection conn = null;
		Statement stmt = null;
    		ResultSet rs = null;
    			try {
      			conn = Connectivity.getConnection();
			
	 		String query ="select name,busno,traveldate,source,destination,noofseats from booking where ticketno="+ticketno+"";
			String query1 ="select phno,emailid from passenger where username='"+uname+"'";
			
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
    			rs=stmt.executeQuery(query);
      			conn.commit();
			rs.absolute(1);
		
			while(true)
			{
				name=rs.getString(1);
				busno=rs.getString(2);
				date=rs.getString(3);
				source=rs.getString(4);
				destination=rs.getString(5);
				noofseats=rs.getString(6);
				boolean b1=rs.next();
				
				if(b1==false)
				break;
			}
			rs=stmt.executeQuery(query1);
      			conn.commit();
			rs.absolute(1);
			while(true)
			{
				phno=rs.getString(1);
				emailid=rs.getString(2);
				boolean b2=rs.next();
				if(b2==false)
				break;
			}
			
			t1.setText(name);t6.setText(busno);
			t7.setText(date);t8.setText(source);t9.setText(destination);
			t5.setText(noofseats);t2.setText(phno);t4.setText(emailid);
		 } catch (Exception e) {
      				e.printStackTrace();
    				} finally {
     					 try{
        						
       						stmt.close();
        					conn.close();
					}
					catch(SQLException e)
						{}
     					  }
		setVisible(true);
	         }


	public void actionPerformed(ActionEvent ae)
	         {
			display=("\t\tSSS TRAVELS\n");
display1=("Bus no.="+t6.getText()+"               Travel Date:"+t7.getText()+"\n");
display2=("Ticket no.="+t3.getText()+"            Name="+t1.getText()+"      No. of seats="+t5.getText()+"\n");
display3=("Source="+t8.getText()+"                Destination="+t9.getText()+"");
//display4=(display+"\n"+display1+"\n"+display2+"\n"+display3);


			String string=ae.getActionCommand();
			if(string.equals("Print"))
			 {
				 PrinterJob job = PrinterJob.getPrinterJob();
         			job.setPrintable(this);
         			boolean ok = job.printDialog();
         			if (ok) {
            			 try {
                  			job.print();
            				 } catch (PrinterException ex) {

            				 }
        			 }
		}
		System.exit(0);
		}
	public int print(Graphics g, PageFormat pf, int page) throws
                                                        PrinterException {

        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }

        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        /* Now we perform our rendering */
        g.drawString(display, 100, 100);
	g.drawString(display1, 100, 125);
	g.drawString(display2, 100, 150);
	g.drawString(display3, 100, 200);
        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }

	public void textValueChanged(TextEvent te)
	         {
		
	         }
         
         } 	 


class BookingCancel extends JFrame implements ActionListener,TextListener
         {
	String str;String uname;
	Label l1;int ticketno;String temp;
	TextField t1,t2;
	JButton b1,b2;
	BookingCancel(String uname)
	       {
		setTitle("Cancellation");
		setSize(350,150);
		setLayout(new FlowLayout());
		this.uname=uname;
		l1=new Label("Enter Reservation number");
		t1=new TextField(20);
		t2=new TextField(40);	
		b1=new JButton("Cancel My Reservation"); 
		b2=new JButton("Back");	       	
		
		JLabel label = new JLabel("SSS Travels");
		java.awt.Font font = new java.awt.Font("Arial",Font.BOLD,24);
		label.setFont(font);
		add(label);
		add(l1);add(t1);add(b1);
		add(t2);
		add(b2);
		
		t1.addTextListener(this);
		t2.addTextListener(this);
		b1.addActionListener(this);       
		b2.addActionListener(this);
  
		setVisible(true);
	       }

	public void textValueChanged(TextEvent te)
	        {
			temp=t1.getText();
			ticketno=Integer.parseInt(temp);
	        }

	public void actionPerformed(ActionEvent ae)
	         {
		str=ae.getActionCommand();
		if(str.equals("Cancel My Reservation"))
		    {		
			Connection conn = null;
		  	Statement stmt = null;
    		  	ResultSet rs = null;
    			try {
      				conn = Connectivity.getConnection();
				String query ="delete from booking where username='"+uname+"' and ticketno="+ticketno+"";
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
    				stmt.executeUpdate(query);
      				conn.commit();
		 		} catch (Exception e) {
      				e.printStackTrace();
    				} finally {
     					 try{
        						
       						stmt.close();
        					conn.close();
					}
					catch(SQLException e)
						{}
     					  }
		            t2.setText("Reservation Successfully Cancelled");
	                      }
		
		else if(str.equals("Back"))
		     {
			dispose();
			JFrame frame1 = new Roadways(uname);
   		 frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension minSize = new Dimension(400,400);
		frame1.setMinimumSize(minSize);	
    		 frame1.pack();
   		 frame1.setVisible(true);
		     }
	          }
         }	

class BookingPrint extends JFrame implements ActionListener,TextListener
         {
	String str;String uname;
	int ticketno;
	String ticket_no;	
	Label l1;
	TextField t1;
	JButton b1,b2;
	BookingPrint(String uname)
	       {
		this.uname=uname;
		setTitle("Print your Booking");
		setSize(250,150);
		setLayout(new FlowLayout());

		l1=new Label("Enter Reservation number");
		t1=new TextField(20);
		b1=new JButton("Print My Reservation"); 
		b2=new JButton("Exit");
		
		JLabel label = new JLabel("SSS Travels");
		java.awt.Font font = new java.awt.Font("Arial",Font.BOLD,24);
		label.setFont(font);
		add(label);
       		add(l1);add(t1);add(b1);add(b2);
			
		t1.addTextListener(this);
		b1.addActionListener(this);       
		b2.addActionListener(this); 
		
		setVisible(true);
	       }

	public void textValueChanged(TextEvent te)
	        {
			ticket_no=t1.getText();
			ticketno=Integer.parseInt(ticket_no);
	        }

	public void actionPerformed(ActionEvent ae)
	         {
		str=ae.getActionCommand();
		if(str.equals("Print My Reservation"))
		   {
			
			JFrame frame1 = new PrintPage(uname,ticketno);
   		 frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension minSize = new Dimension(750,750);
		frame1.setMinimumSize(minSize);	
    		 frame1.pack();
   		 frame1.setVisible(true);
		    }			

		else if(str.equals("Exit"))
		    {
			System.exit(0);
		    }  
	         }
         }	
		


class BookingDetails extends JFrame implements ActionListener,TextListener,ItemListener
         {
	Label l1,l2,l3,l4,l5,l6;
	TextField t1,t2,t3,t4,t6;
	TextArea t5;
	
	String uname;int busno;String source;String dest;int noofseats;
	String date,month,year;String name1;int ticketno;String ticket_no;

	BookingDetails(String uname,int busno,String source,String dest,int temp,String date,
			String month,String year)
	        {
		this.uname=uname;
		this.busno=busno;
		this.source=source;
		this.dest=dest;
		noofseats=temp;
		this.date=date;
		this.month=month;
		this.year=year;
		
		setTitle("Customer Details");
		//setSize(380,390);
		setLayout(null);

		//l1=new Label("Please Ensure that you enter all the blank fields in the Form given Below");
		l2=new Label("Name*:");		
		l3=new Label("Address*:");
		l6=new Label("No. of seats :");
		l4=new Label("ticket number");
		
		t1=new TextField(35);
		t2=new TextField(13);
		t3=new TextField(13);
	
		t5=new TextArea(50,50);
		t6=new TextField(05);
		
		JButton btn = new JButton("Confirm booking");
		
		JLabel label = new JLabel("SSS TRAVELS");
		java.awt.Font font = new java.awt.Font("Arial",Font.BOLD,40);
		label.setFont(font);
		JLabel label1 = new JLabel("All fields with * are mandatory");
		java.awt.Font font1 = new java.awt.Font("Arial",Font.ITALIC,22);
		label.setFont(font1);
		add(label);
		add(label1);
		add(l2);add(t1);
		add(l3);add(t5);
		add(l6);add(t6);
		add(l4);add(t2);
		
		add(btn);
		
		label.setBounds(250,0,200,90);
		label1.setBounds(30,100,400,30);
		l2.setBounds(30,150,50,20);
		t1.setBounds(120,150,250,20);
		l3.setBounds(30,200,75,20);
		t5.setBounds(120,200,250,100);
		l4.setBounds(30,350,75,20);
		t2.setBounds(120,350,50,20);
		l6.setBounds(30,400,80,20);
		t6.setBounds(130,400,50,20);
		btn.setBounds(80,450,150,20);		
		btn.addActionListener(this);
		t1.addTextListener(this);
		t2.addTextListener(this);
		t3.addTextListener(this);
		
		t5.addTextListener(this);
		t6.addTextListener(this);
		
		Connection conn = null;
		  Statement stmt = null;
    		  ResultSet rs = null;
    			try {
      			conn = Connectivity.getConnection();
			
	 		String query ="select cnt from count";
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
    			rs=stmt.executeQuery(query);
      			conn.commit();
			rs.absolute(1);
			while(true)
			{
				ticketno=rs.getInt(1);
				boolean b=rs.next();
				if(b==false)
				break;	
			}

		 } catch (Exception e) {
      				e.printStackTrace();
    				} finally {
     					 try{
        						
       						stmt.close();
        					conn.close();
					}
					catch(SQLException e)
						{}
     					  }
			





		int x=noofseats;
		Integer a=new Integer(x);
		String no_of_seats=a.toString();
		t6.setText(no_of_seats);
		int y=ticketno;
		Integer temp2=new Integer(y);
		String ticket_no=temp2.toString();
		t2.setText(ticket_no);
		setVisible(true);
	         }
		public void textValueChanged(TextEvent te)
		{}
		public void itemStateChanged(ItemEvent ie)
		{}

	public void actionPerformed(ActionEvent ae)
	         {	
			String s=ae.getActionCommand();
			
			if(s.equals("Confirm booking"))
			{
			
			name1=t1.getText();
			
		Connection conn = null;
		  Statement stmt = null;
    		  ResultSet rs = null;
    			try {
      			conn = Connectivity.getConnection();
			
	 		String query ="insert into booking values('"+uname+"','"+name1+"',"+ticketno+","+busno+",'"+source+"','"+dest+"',"+noofseats+",'"+date+month+year+"')";
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
    			stmt.executeUpdate(query);
      			conn.commit();
		 } catch (Exception e) {
      				e.printStackTrace();
    				} finally {
     					 try{
        						
       						stmt.close();
        					conn.close();
					}
					catch(SQLException e)
						{}
     					  }
			}
			
			dispose();
			JFrame frame2 = new PrintPage(uname,ticketno);
   		 frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension minSize = new Dimension(750,750);
		frame2.setMinimumSize(minSize);	
    		 frame2.pack();
   		 frame2.setVisible(true);	
	                } 
	 

}
class Availability extends JFrame implements ActionListener,TextListener,ItemListener
         {
	String str,s;int a=0,b=0,z=0;String uname;
	Label l1,l2,l3,l4,l5,l6,l7,l8,l9;
	TextField t1,t2,t3,t4,t5,t6,t7,t8;
	Choice ch10;
	Connectivity cn=new Connectivity();
	String source=null;
	 String dest=null;
	  String type=null;
	  String date=null;
	  String month=null;
	  String year=null;
	  int busno=0;
	  int cost=0;int count=0;
	 int availableseats=0;
	  int price=0;int temp;	
	Availability(String uname,String source,String dest,String type,String date,String month,String
			year,int busno,int cost,int availableseats)
	       {
		this.uname=uname;
		this.source=source;
		this.dest=dest;
		this.type=type;
		this.date=date;
		this.month=month;
		this.year=year;
		this.busno=busno;
		this.cost=cost;
		this.availableseats=availableseats;	
		
		setTitle("Booking");
		setLayout(null);
		
		l1=new Label("Bus Type");
		l2=new Label("Bus No.");
		l3=new Label("Source");
		l4=new Label("Destination");
		l5=new Label("Date");
		l6=new Label("Available Tickets");
		l8=new Label("No of passengers");
		l7=new Label("Fare  Rs");
		l9=new Label("Cost per ticket" );
		JLabel label = new JLabel("SSS Travels");
		java.awt.Font font = new java.awt.Font("Arial",Font.BOLD,30);
		label.setFont(font);
		ch10=new Choice();
		ch10.addItem("0");
		ch10.addItem("1");ch10.addItem("2");ch10.addItem("3");ch10.addItem("4");ch10.addItem("5");ch10.addItem("6");

		t1=new TextField(10);
		t2=new TextField(5);
		t3=new TextField(10);
		t4=new TextField(10);
		t5=new TextField(10);
		t6=new TextField(4);
		t7=new TextField(4);
		t8=new TextField(5);
		
		JButton btn = new JButton("Reset my plan");
		JButton btn1=new JButton("Book");
		add(label);
		add(l1);add(t1);add(l2);add(t2);
		add(l3);add(t3);add(l4);add(t4);
		add(l5);add(t5);add(l6);add(t6);add(l9);add(t8);
		add(l8);add(ch10);
		add(l7);add(t7);
		add(btn);add(btn1);
	
		label.setBounds(250,0,200,50);
		l2.setBounds(30,100,75,25);
		t2.setBounds(105,100,75,25);
		l1.setBounds(265,100,60,25);
		t1.setBounds(340,100,75,25);
		l3.setBounds(30,150,60,25);
		t3.setBounds(100,150,150,25);
		l4.setBounds(265,150,70,25);
		t4.setBounds(340,150,150,25);
		l5.setBounds(30,200,50,25);
		t5.setBounds(100,200,75,25);
		l6.setBounds(265,200,120,25);	
		t6.setBounds(395,200,50,25);
		l9.setBounds(30,250,100,25);
		t8.setBounds(140,250,50,25);
		l8.setBounds(260,250,125,25);
		ch10.setBounds(395,250,50,25);
		l7.setBounds(130,300,50,25);
		t7.setBounds(195,300,50,25);
		btn1.setBounds(80,350,100,25);
		btn.setBounds(200,350,150,25);
		
		btn.addActionListener(this);
		btn1.addActionListener(this);
		ch10.addItemListener(this);
		t1.addTextListener(this);
		t2.addTextListener(this);
		t3.addTextListener(this);
		t4.addTextListener(this);
		t5.addTextListener(this);
		t6.addTextListener(this);
		t7.addTextListener(this);
		t8.addTextListener(this);
		z=busno;
		Integer p=new Integer(z);
		String bus_no=p.toString();
		t1.setText(type);
		t2.setText(bus_no);
	t3.setText(source);
	t4.setText(dest);
	t5.setText(date+month+year);
	//System.out.println(Connectivity1.availableseats);
	a=availableseats;
	Integer x=new Integer(a);
	String seats=x.toString();
	t6.setText(seats);
	b=cost;
	Integer num=new Integer(b);
	String cost1=num.toString();
	t8.setText(cost1);	
		
		

		

		setVisible(true);

	       }
	
	
	
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==ch10)
		{
			s=ch10.getSelectedItem();
			temp=Integer.parseInt(s);
			Connection conn = null;
		  	Statement stmt=null;
    		  	ResultSet rs=null;
    			try {
			conn = Connectivity.getConnection();
			String query="update bus set availableseats="+(a-temp)+"where busno="+z+"";
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt.executeUpdate(query);
      			conn.commit();
			} catch (SQLException e) {
				
      				e.printStackTrace();
    				}
		catch(Exception e)
		{
			System.out.println(e);
		}
			 finally {
     					 try{
        						
       						 stmt.close();
        						
						//stmt1.close();
						conn.close();
						
					}
					catch(SQLException e)
						{}
     					  }


			int ava_seats=a-temp;
			Integer num1=new Integer(ava_seats);
			String available_seats=num1.toString();
			t6.setText(available_seats);
			price=temp*cost;
			int l=price;
			Integer m=new Integer(l);
			String fare=m.toString();
			t7.setText(fare);
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	        {
		Connection conn = null;
		  	Statement stmt=null;Statement stmt1=null;
    		  	ResultSet rs=null;
		str=ae.getActionCommand();
		
		if(str.equals("Book"))
		    {
			try {
			conn = Connectivity.getConnection();
			String query="select cnt from count";
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=stmt.executeQuery(query);
      			conn.commit();
			rs.absolute(1);
			while(true)
			{
				count=rs.getInt(1);
				boolean b=rs.next();
				if(b==false)
				break;
			}
			count++;
			String query2="delete from count";
			String query1="insert into count values("+count+")";
			stmt1=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt1.executeUpdate(query2);
			stmt1.executeUpdate(query1);
			conn.commit();
			} catch (SQLException e) {
				
      				e.printStackTrace();
    				}
		catch(Exception e)
		{
			System.out.println(e);
		}
			 finally {
     					 try{
        						
       						 stmt.close();
        						
						//stmt1.close();
						conn.close();
						
					}
					catch(SQLException e)
						{}
     					  }
			dispose();
			//BookingDetails bd=new BookingDetails();
			JFrame frame2 = new BookingDetails(uname,busno,source,dest,temp,date,month,year);
   		 frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension minSize = new Dimension(600,600);
		frame2.setMinimumSize(minSize);	
    		 frame2.pack();
   		 frame2.setVisible(true);
		    }
	     	else if(str.equals("Reset my plan"))
			{	
		JFrame frame1 = new Roadways(uname);
   		 frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension minSize = new Dimension(750,750);
		frame1.setMinimumSize(minSize);	
    		 frame1.pack();
   		 frame1.setVisible(true);
    				dispose();
		
		  
		}			
			}
			
	       

	public void textValueChanged(TextEvent te)
	       {
		
	int x=Integer.parseInt(s);
	price=(x*cost);
	int y=price;
	Integer p=new Integer(y);
	String s1=p.toString();
	t7.setText(s1);
		
	        }

         }

class Roadways extends JFrame implements ActionListener,TextListener,ItemListener
      {
	String str;String uname;
	Label l1,l2,l3,l4,l5;
	  String source=null;
	 String dest=null;
	  String type=null;
	  String date=null;
	  String month=null;
	  String year=null;
	  int busno=0;
	  int cost=0;
	 int availableseats=0;
	  int price=0;
	Image img;	
	JButton b1,b2,b3;
	Choice ch1,ch2,ch3,ch4,ch5,ch9;
	//Connectivity1 cn=new Connectivity1();
	Roadways(String uname)
	      {	
		this.uname=uname;
		setTitle("Roadways");

		setLayout(null);
	
		
		JLabel label = new JLabel("SSS Travels");
		java.awt.Font font = new java.awt.Font("Arial",Font.BOLD,45);
		label.setFont(font);
		JLabel label1 = new JLabel("Plan My Travel");
		java.awt.Font font1 = new java.awt.Font("Arial",Font.ITALIC,30);
		label1.setFont(font1);
		
		
		
		ch1=new Choice();
		ch1.addItem(" ");
		ch1.addItem("Bengaluru");
		ch1.addItem("Chennai");
		
		
		ch1.addItem("Hyderabad");
		
		ch1.addItem("Mumbai");
		
		ch2=new Choice();
		ch2.addItem(" ");
		ch2.addItem("Bengaluru");
		ch2.addItem("Chennai");
		
		ch2.addItem("Hyderabad");
		
		ch2.addItem("Mumbai");
		
		ch3=new Choice();
		
		ch3.addItem("DD");
ch3.addItem("01");
ch3.addItem("02");
ch3.addItem("03");
ch3.addItem("04");
ch3.addItem("05");
ch3.addItem("06");
ch3.addItem("07");
ch3.addItem("08");
ch3.addItem("09");
ch3.addItem("10");
ch3.addItem("11");
ch3.addItem("12");
ch3.addItem("13");
ch3.addItem("14");
ch3.addItem("15");
ch3.addItem("16");
ch3.addItem("17");
ch3.addItem("18");
ch3.addItem("19");
ch3.addItem("20");
ch3.addItem("21");
ch3.addItem("22");
ch3.addItem("23");
ch3.addItem("24");
ch3.addItem("25");
ch3.addItem("26");
ch3.addItem("27");
ch3.addItem("28");
ch3.addItem("29");
ch3.addItem("30");
ch3.addItem("31");
		ch4=new Choice();
		ch4.addItem("MM");
ch4.addItem("jan");
ch4.addItem("feb");
ch4.addItem("mar");
ch4.addItem("apr");
ch4.addItem("may");
ch4.addItem("jun");
ch4.addItem("jul");
ch4.addItem("aug");
ch4.addItem("sep");
ch4.addItem("oct");
ch4.addItem("nov");
ch4.addItem("dec");
		ch5=new Choice();
		ch5.addItem("YYYY");
ch5.addItem("2011");ch5.addItem("2012");
//ch6=new Choice();
		
		/*ch6.addItem("DD");
ch6.addItem("01");
ch6.addItem("02");
ch6.addItem("03");
ch6.addItem("04");
ch6.addItem("05");
ch6.addItem("06");
ch6.addItem("07");
ch6.addItem("08");
ch6.addItem("09");
ch6.addItem("10");
ch6.addItem("11");
ch6.addItem("12");
ch6.addItem("13");
ch6.addItem("14");
ch6.addItem("15");
ch6.addItem("16");
ch6.addItem("17");
ch6.addItem("18");
ch6.addItem("19");
ch6.addItem("20");
ch6.addItem("21");
ch6.addItem("22");
ch6.addItem("23");
ch6.addItem("24");
ch6.addItem("25");
ch6.addItem("26");
ch6.addItem("27");
ch6.addItem("28");
ch6.addItem("29");
ch6.addItem("30");
ch6.addItem("31");

		ch7=new Choice();
		ch7.addItem("MM");
ch7.addItem("jan");
ch7.addItem("feb");
ch7.addItem("mar");
ch7.addItem("apr");
ch7.addItem("may");
ch7.addItem("jun");
ch7.addItem("jul");
ch7.addItem("aug");
ch7.addItem("sep");
ch7.addItem("oct");
ch7.addItem("nov");
ch7.addItem("dec");
		ch8=new Choice();
		ch8.addItem("YYYY");
ch8.addItem("2011");ch8.addItem("2012");*/
ch9=new Choice();
ch9.addItem(" ");
ch9.addItem("Volvo AC");
ch9.addItem("Non-AC");
ch9.addItem("Semi-sleeper");
ch9.addItem("Hi-tech");

		l1=new Label("Type of bus");
		
		l3=new Label("from:");
		l4=new Label("to:");
		l5=new Label("Travel date:");
			
		
		
		b1=new JButton("Check Availability");
		b2=new JButton("Print Booking");
		b3=new JButton("Cancel Booking");
	
	
		add(label);add(label1);
		add(l3);
		add(ch1);
		add(l4);add(ch2);
        		add(l5);add(ch3);add(ch4);add(ch5);
		
		
		add(l1);add(ch9);
		
		
		add(b1);
		add(b2);add(b3);
			

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		
		
		ch1.addItemListener(this);
		ch2.addItemListener(this);
		ch3.addItemListener(this);
		ch4.addItemListener(this);
		ch5.addItemListener(this);
		
		ch9.addItemListener(this);
		
		label.setBounds(250,0,500,100);
		label1.setBounds(30,150,500,30);
		l3.setBounds(30,225,50,50);
		ch1.setBounds(90,235,100,250);
		l4.setBounds(200,225,50,50);
		ch2.setBounds(250,235,100,250);
		l5.setBounds(30,330,75,50);
		ch3.setBounds(125,340,75,200);
		ch4.setBounds(205,340,75,200);
		ch5.setBounds(295,340,75,200);
		l1.setBounds(30,440,75,50);
		ch9.setBounds(125,450,100,200);
		b1.setBounds(100,550,150,30);
		b2.setBounds(20,600,150,30);
		b3.setBounds(200,600,150,30);
		/*final ImageIcon imageIcon=new ImageIcon("bus.gif");
		Image image=imageIcon.getImage();	*/
				
      	         }
	/*public void paintComponent(Graphics g)
	{
		
		g.drawImage(image,320,150,this);
		super.paintComponent(g);
	}*/
	public void itemStateChanged(ItemEvent ie)
	{
		if(ie.getSource()==ch1)
		{
			source=ch1.getSelectedItem();
			
		}
		if(ie.getSource()==ch2)
		{
			dest=ch2.getSelectedItem();
		}
		if(ie.getSource()==ch3)
		{
			date=ch3.getSelectedItem();
		}
		if(ie.getSource()==ch4)
		{
			month=ch4.getSelectedItem();
		}
		if(ie.getSource()==ch5)
		{
			year=ch5.getSelectedItem();
		}
		if(ie.getSource()==ch9)
		{
			type=ch9.getSelectedItem();
		}

	}
	public void actionPerformed(ActionEvent ae) 
	{	
		str=ae.getActionCommand();
		if(str.equals("Check Availability"))
		   {	
			//System.out.println(source);
			Connection conn = null;
		  	Statement stmt=null,stmt1=null;
    		  	ResultSet rs1=null;
    			try {
			
      			conn = Connectivity.getConnection();
			//System.out.println(conn);
	 		String query = "select busno from bus where source='"+source+"'and destination='"+dest+"'and bustype='"+type+"'";
			String query1 = " select cost from bus where source='"+source+"'and destination='"+dest+"'and bustype='"+type+"'";
			String query2 = " select availableseats from bus where source='"+source+"'and destination='"+dest+"'and bustype='"+type+"'"; 
			
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				//System.out.println(stmt);	
    			   rs1=stmt.executeQuery(query);
      			conn.commit();
		
			rs1.absolute(1);
			//System.out.println(rs1);
			while(true)
			{	//System.out.println("hi");
				busno=rs1.getInt(1);
				boolean b=rs1.next();
				//System.out.println(busno);	
				if(b==false)
				break;
			}
			rs1=null;
			rs1=stmt.executeQuery(query1);
			rs1.absolute(1);
			
			conn.commit();
			while(true)
			{
				cost=rs1.getInt(1);
				boolean b=rs1.next();			
				//System.out.println(cost);
				if(b==false)
				break;
			}
			
			rs1=null;
			rs1=stmt.executeQuery(query2);
			rs1.absolute(1);
			
			conn.commit();
			while(true)
			{	
				availableseats=rs1.getInt(1);
				boolean b=rs1.next();
				//System.out.println(availableseats);
				if(b==false)
				break;
				
			}
			if(availableseats==0)
			{
				setVisible(false);dispose();
			JFrame frame1 = new NoSeats(uname);
   		 frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension minSize = new Dimension(500,500);
		frame1.setMinimumSize(minSize);	
    		 frame1.pack();
   		 frame1.setVisible(true);
			}
		
		

		 } catch (SQLException e) {
				
      				e.printStackTrace();
    				}
		catch(Exception e)
		{
			System.out.println(e);
		}
			 finally {
     					 try{
        						
       						 stmt.close();
        						
						//stmt1.close();
						conn.close();
						
					}
					catch(SQLException e)
						{}
     					  }
			if(availableseats!=0)
			{
			setVisible(false);
			JFrame frame2 = new Availability(uname,source,dest,type,date,month,
			year,busno,cost,availableseats);
   		 frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension minSize = new Dimension(750,750);
		frame2.setMinimumSize(minSize);	
    		 frame2.pack();
   		 frame2.setVisible(true);
			}
		   }
		
		else if(str.equals("Print Booking"))
		    {
			setVisible(false);
			
			JFrame frame5 = new BookingPrint(uname);
   		 frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension minSize = new Dimension(400,400);
		frame5.setMinimumSize(minSize);	
    		 frame5.pack();
   		 frame5.setVisible(true);
		    }
		
		else if(str.equals("Cancel Booking"))	
		      {
			setVisible(false);
			//BookingCancel c=new BookingCancel();
			JFrame frame6 = new BookingCancel(uname);
   		 frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension minSize = new Dimension(400,400);
		frame6.setMinimumSize(minSize);	
    		 frame6.pack();
   		 frame6.setVisible(true);
		      }	
	          }

	public void textValueChanged(TextEvent te)
	         {
		//t2.setEchoChar('*'); 
	         }
             }               

class RoadwayTravels
        {
	public static void main(String []k)
	        {	
		JFrame frame1 = new Login();
   		 frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension minSize = new Dimension(500,500);
		frame1.setMinimumSize(minSize);	
    		 frame1.pack();
   		 frame1.setVisible(true);
		
	         }
         }
 		