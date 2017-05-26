package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultCaret;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

import javax.swing.JFrame;

import java.awt.*;
import javax.swing.*;


/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a ‘dummy’ class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature – as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author Person A and Person B
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {
	private static final long serialVersionUID =  -7031008862559936404L;
	private static final int numCustomerDetails = 6;
	private static final int numPizzaDetails = 5;
	
	public static final int WIDTH = 1600;
	public static final int HEIGHT = 900;
	
	private PizzaRestaurant restaurant;
	private JFrame mainFrame;
	private DefaultTableModel tableModel;
	private JTable table;
	
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		mainFrame = new JFrame(title);
	}
	
	@Override
	public void run() {
		try {
			CreateGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	private void CreateGUI() throws CustomerException {
		mainFrame.setSize(WIDTH, HEIGHT);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new BorderLayout()); 
		
		mainFrame.getContentPane().add(DisplayCustomerInformation(), BorderLayout.CENTER); // displays log content
		
		// buttons		
		mainFrame.getContentPane().add(CreateLoadLogFileButton(), BorderLayout.SOUTH);
		

		
		mainFrame.repaint();
		
		mainFrame.setVisible(true);
	}
	
	// customer name, mobile, type, x y location, delivery distance
	private JScrollPane DisplayCustomerInformation() throws CustomerException {
		String columnNames[] = {"Customer Name", "Mobile Number", "Customer Type", "Location (X,Y)", "Delivery Distance"};
		
		String rowData[][] = new String[0][5];
			
		tableModel = new DefaultTableModel(rowData, columnNames); 
		table = new JTable(tableModel);
	    JScrollPane scrollPanel = new JScrollPane(table);
		return scrollPanel;
	}
	
	//
	private void DisplayOrderInformation() {
		
	}
	
	private JButton CreateLoadLogFileButton() {
		JButton button = new JButton("Select File");
	    button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ae) {
	          JFileChooser fileChooser = new JFileChooser();
	          int returnValue = fileChooser.showOpenDialog(null);
	          if (returnValue == JFileChooser.APPROVE_OPTION) {
	            File selectedFile = fileChooser.getSelectedFile();
	            restaurant = new PizzaRestaurant();
	            try {
					restaurant.processLog(selectedFile.getAbsolutePath());
					
					for (int i = 0; i < restaurant.getNumCustomerOrders(); i++) {
						tableModel.addRow(new String[] {restaurant.getCustomerByIndex(i).getName(),
														restaurant.getCustomerByIndex(i).getMobileNumber(),
														restaurant.getCustomerByIndex(i).getCustomerType(),
														Integer.toString(restaurant.getCustomerByIndex(i).getLocationX()) +", "+ Integer.toString(restaurant.getCustomerByIndex(i).getLocationY()),
														Double.toString(restaurant.getCustomerByIndex(i).getDeliveryDistance())}
										 );
					}
									
				} catch (CustomerException | PizzaException | LogHandlerException e) {
					e.printStackTrace();
				}
	          }
	        }
	      });
	    
	    return button;
	}
}
