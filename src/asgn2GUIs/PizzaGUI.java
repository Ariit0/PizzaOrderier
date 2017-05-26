package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.JPanel;
import javax.swing.text.DefaultCaret;

import asgn2Customers.Customer;
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
	public static final int WIDTH = 1600;
	public static final int HEIGHT = 900;
	
	private PizzaRestaurant restaurant;
	private JFrame mainFrame;
	private JPanel pnlOne;
	
	/**
	 * Creates a new Pizza GUI with the specified title 
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		mainFrame = new JFrame(title);
	}
	
	@Override
	public void run() {
		CreateGUI();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	private void CreateGUI() {
		mainFrame.setSize(WIDTH, HEIGHT);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new BorderLayout()); 
		
		JButton button = new JButton("Select File");
	    button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ae) {
	          JFileChooser fileChooser = new JFileChooser();
	          int returnValue = fileChooser.showOpenDialog(null);
	          if (returnValue == JFileChooser.APPROVE_OPTION) {
	            File selectedFile = fileChooser.getSelectedFile();
	            System.out.println(selectedFile.getName());
	          }
	        }
	      });
		
		// panels
		pnlOne = createPanel(Color.WHITE);
		
		// buttons
		mainFrame.add(button);
		
		mainFrame.repaint();
		
		mainFrame.setVisible(true);
	}

	private JPanel createPanel(Color c) {
		JPanel temp;
		temp = new JPanel();
		temp.setBackground(c);
		
		return temp;
	}

}
