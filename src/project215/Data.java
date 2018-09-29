package project215;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Data extends JFrame implements WindowListener,ActionListener {
	public JLabel l, l2, l3, l4, l5;
	public JLabel header;
	public JTable table;
	public JScrollPane scroll;
	public static void main (String [] args) throws Exception {
		String thisLine = null;
		String arb[] = new String[50];
	    int i=0;
	    FileReader fr = null;
	    BufferedReader br = null;
	      try {
	         // open input stream test.txt for reading purpose.
	    	 fr = new FileReader("criminaldata.txt");
	         br = new BufferedReader(fr);
	         while ((thisLine = br.readLine()) != null) {
	            System.out.println(thisLine);
	            arb[i] = thisLine;
	            i++;
	         }
	         br.close();
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	    
		InfoCriminal[] ic = new InfoCriminal[i];
		for(i=0; i< ic.length;i++)
		    ic[i] = new InfoCriminal();
		for (i=0;i<ic.length;i++) {
			int index1 = arb[i].indexOf(',');
			ic[i].setName(arb[i].substring(0, index1));
			
			int index2 = index1 + 1;
			int index3 = arb[i].indexOf(',', index2);
			ic[i].setAge((arb[i].substring(index2, index3)));
			int index4 = index3 + 1;
			int index5 = arb[i].indexOf(',', index4);
			ic[i].setCrime(arb[i].substring(index4, index5));
			int index6 = index5 + 1;
			int index7 = arb[i].indexOf(',', index6);
			ic[i].setStatus(arb[i].substring(index6, index7));
			ic[i].setJail(arb[i].substring(index7+1, arb[i].length()));
			
		}
		for (i=0;i<ic.length;i++) {
			System.out.println(ic[i].getName() + " " + ic[i].getAge() + " years old ");
			System.out.println("Convicted for " + ic[i].getCrime() );
		}
		Data d = new Data("Criminal Data", ic);
		d.setSize(1300,500);
        d.setVisible(true);
	
	}
	public Data(String title, InfoCriminal [] ic) {
		super(title);
    	setLayout(null);;
    	addWindowListener(this);
    	int align = 25;
    	header = new JLabel("Criminal Database", SwingConstants.CENTER);
    	DefaultTableModel m = new DefaultTableModel(ic.length, 6){
    		String s[] = {"Serial", "Criminal Name", "Age", "Crime Committed", "Status", "Jailed In"};
    		public String getColumnName(int index){
    			return s[index];
    		}
    	};
    	table = new JTable(m);
    	scroll = new JScrollPane();
    	scroll.getViewport().add(table);
    	
    	add(scroll);
    	scroll.setBounds(100, 100, 1000, 300);
    	
		header.setBackground(Color.GREEN);
		header.setOpaque(true);
		add(header);
		header.setAlignmentX(CENTER_ALIGNMENT);
		header.setBounds(500,0,150,50);
    	for (int i=0; i<ic.length;i++) {
    		table.setValueAt(i+1, i, 0);
    		table.setValueAt(ic[i].getName(), i, 1);
    		table.setValueAt((ic[i].getAge()), i, 2);
    		table.setValueAt(ic[i].getCrime(), i, 3);
    		table.setValueAt(ic[i].getStatus(), i, 4);
    		table.setValueAt(ic[i].getJail(), i, 5);
    	}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		dispose();
        System.exit(0);
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
