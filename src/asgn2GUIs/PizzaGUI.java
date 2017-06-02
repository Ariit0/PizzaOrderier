package asgn2GUIs;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;

import asgn2Restaurant.PizzaRestaurant;


import javax.swing.JFrame;

import java.awt.*;
import javax.swing.*;


/**
 * This class is the graphical user interface for the rest of the system. 
 * Currently it is a �dummy� class which extends JFrame and implements Runnable and ActionLister. 
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to 
 * interact with the rest of the system. You may choose to implement this class as you like, including changing 
 * its class signature � as long as it  maintains its core responsibility of acting as a GUI for the rest of the system. 
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 * 
 * 
 * @author George Delosa (n9751696) and Ari Luangamath (n9446826)
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {
	private static final long serialVersionUID =  -7031008862559936404L;
	public static final int WIDTH = 1600;
	public static final int HEIGHT = 900;
	
	private PizzaRestaurant restaurant;
	private JFrame mainFrame;
	private DefaultTableModel customerTableModel;
	private DefaultTableModel pizzaTableModel;
	private JTable table;
	private JTabbedPane tabPane;
	private JPanel headerPanel;
	private JPanel buttonPanel;
	private Box totalsBox;

	private JButton profitButton;
	private JButton distanceButton;
	private JButton resetButton;

    private JTextField totalProfit;
	private JTextField totalDistance;
	
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
		} catch (Exception exception) {
		    exception.getMessage();
            exception.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

    /**
     * Creates all elements of the GUI
     * @throws CustomerException
     */
	private void CreateGUI() throws CustomerException {
		mainFrame.setSize(WIDTH, HEIGHT);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new BorderLayout());

		tabPane = new JTabbedPane();
		headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		totalsBox = Box.createVerticalBox();

		mainFrame.getContentPane().add(tabPane);
		mainFrame.getContentPane().add(headerPanel, BorderLayout.NORTH);
		mainFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		mainFrame.getContentPane().add(totalsBox, BorderLayout.EAST);

        profitButton = new JButton("Calculate Total Profit");
        distanceButton = new JButton("Calculate Total Distance Travelled");
        resetButton = new JButton("Reset");

        totalProfit = new JTextField();
        totalProfit.setFont(new Font("Arial", Font.BOLD, 20));
        totalDistance = new JTextField();
        totalDistance.setFont(new Font("Arial", Font.BOLD, 20));

        totalProfit.setEditable(false);
        totalDistance.setEditable(false);

        profitButton.setEnabled(false);
        distanceButton.setEnabled(false);
        resetButton.setEnabled(false);

		// tabs
		tabPane.addTab("Customer Orders", DisplayCustomerInformation());
		tabPane.addTab("Pizza Orders", DisplayPizzaInformation());

		// header
        JLabel headerLabel = new JLabel("Pizza Palace Log System");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 36));
        headerPanel.add(headerLabel);
		
		// buttons
        buttonPanel.add(ProcessLogFileButton());
        buttonPanel.add(CalculateTotalProfitButton());
        buttonPanel.add(CalculateTotalDistanceButton());
        buttonPanel.add(ResetLogs());

        // totals
        JLabel profitLabel = new JLabel("Total Profit");
        JLabel distanceLabel = new JLabel("Total Distance Travelled    ");
        profitLabel.setFont(new Font("Arial", Font.BOLD, 20));
        distanceLabel.setFont(new Font("Arial", Font.BOLD, 20));
        totalsBox.add(Box.createVerticalStrut(300));
        totalsBox.add(profitLabel);
        totalsBox.add(totalProfit);
        totalsBox.add(distanceLabel);
        totalsBox.add(totalDistance);
        totalsBox.add(Box.createVerticalStrut(300));
		
		mainFrame.repaint();
		
		mainFrame.setVisible(true);
	}

    /**
     * JScrollPane which displays customer log file information in a table format
     * @return Scrollable JTable
     */
	private JScrollPane DisplayCustomerInformation() {
		String columns[] = {"Customer Name", "Mobile Number", "Customer Type", "Location (X,Y)", "Delivery Distance"};
		String rowData[][] = new String[0][5];
			
		customerTableModel = new DefaultTableModel(rowData, columns);
		table = new JTable(customerTableModel);
	    JScrollPane scrollPanel = new JScrollPane(table);
		return scrollPanel;
	}

    /**
     * JScrollPane which displays pizza log file information in a table format
     * @return Scrollable JTable
     */
	private JScrollPane DisplayPizzaInformation() {
		String columnNames[] = {"Pizza Type", "Quantity", "Order Price", "Order Cost", "Order Profit"};
		String rowData[][] = new String[0][5];
			
		pizzaTableModel = new DefaultTableModel(rowData, columnNames); 
		table = new JTable(pizzaTableModel);
	    JScrollPane scrollPanel = new JScrollPane(table);
		return scrollPanel;
	}

    /**
     * JButton which enables file selection for log file input
     * @return Button for log file selection
     */
	private JButton ProcessLogFileButton() {
		JButton button = new JButton("Load Log File");
	    button.addActionListener((ActionEvent ae) -> {
	        JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
	            restaurant = new PizzaRestaurant();
	            try {
                    ResetTables();
					restaurant.processLog(selectedFile.getAbsolutePath());
					FillTables();
					profitButton.setEnabled(true);
					distanceButton.setEnabled(true);
					resetButton.setEnabled(true);
                    JOptionPane.showMessageDialog(null, "Successfully Loaded Log File",
                            "Success!", JOptionPane.INFORMATION_MESSAGE);
				} catch (CustomerException | PizzaException | LogHandlerException exception) {
                        JOptionPane.showMessageDialog(null, "Log file must be .txt " +
                                        "following the format specifications in Section 5.3",
                                        "Invalid File", JOptionPane.ERROR_MESSAGE);
					exception.printStackTrace();
	            }
            }
        });
	    
	    return button;
	}

    /**
     * Functionality of calculating the total profit for the log file
     * @return Button which performs the calculation
     */
	private JButton CalculateTotalProfitButton() {
        profitButton.addActionListener((ActionEvent ae) -> {
            totalProfit.setText("$ " + Double.toString(round(restaurant.getTotalProfit(), 2)));
            JOptionPane.showMessageDialog(null, "Successfully Calculated Total Profit",
                    "Success!", JOptionPane.INFORMATION_MESSAGE);
        });

        return profitButton;
    }

    /**
     * Functionality of calculating the total distance travelled for the log file
     * @return Button which performs the calculation
     */
    private JButton CalculateTotalDistanceButton() {
        distanceButton.addActionListener((ActionEvent ae) -> {
            totalDistance.setText(round(restaurant.getTotalDeliveryDistance(), 2) + " Units");
            JOptionPane.showMessageDialog(null, "Successfully Calculated Total Distance Travelled",
                    "Success!", JOptionPane.INFORMATION_MESSAGE);
        });

        return distanceButton;
    }

    /**
     * Functionality of resetting all information process from the log file
     * @return Button which performs the functionality
     */
    private JButton ResetLogs() {
        resetButton.addActionListener((ActionEvent ae) -> {
            ResetTables();
            JOptionPane.showMessageDialog(null, "Successfully Reset Log File Data",
                    "Success!", JOptionPane.INFORMATION_MESSAGE);
        });

	    return resetButton;
    }

    /**
     * Functionality which specifically clears table rows and disable buttons
     * @return Button which performs the functionality
     */
	private void ResetTables() {
	    profitButton.setEnabled(false);
	    distanceButton.setEnabled(false);
	    resetButton.setEnabled(false);

	    totalDistance.setText("");
	    totalProfit.setText("");
		// clear rows, row count for customer and pizzas should be the same
		for (int i = customerTableModel.getRowCount() -1; i >= 0; i--) {
            customerTableModel.removeRow(i);
            pizzaTableModel.removeRow(i);
        }
	}

    /**
     * Fills the tables with the processed log file's contents if valid
     * @throws CustomerException
     * @throws PizzaException
     */
	private void FillTables() throws CustomerException, PizzaException {
		// fill table, order count for customer and pizzas should be the same
		for (int i = 0; i < restaurant.getNumCustomerOrders(); i++) {
			customerTableModel.addRow(new String[] {
                    restaurant.getCustomerByIndex(i).getName(),
                    restaurant.getCustomerByIndex(i).getMobileNumber(),
                    restaurant.getCustomerByIndex(i).getCustomerType(),
                    Integer.toString(restaurant.getCustomerByIndex(i).getLocationX()) +", "+
                            Integer.toString(restaurant.getCustomerByIndex(i).getLocationY()),
                    Double.toString(round(restaurant.getCustomerByIndex(i).getDeliveryDistance(), 2))}
            );

            pizzaTableModel.addRow(new String[] {
                    restaurant.getPizzaByIndex(i).getPizzaType(),
                    Integer.toString(restaurant.getPizzaByIndex(i).getQuantity()),
                    Double.toString(restaurant.getPizzaByIndex(i).getOrderPrice()),
                    Double.toString(restaurant.getPizzaByIndex(i).getOrderCost()),
                    Double.toString(round(restaurant.getPizzaByIndex(i).getOrderProfit(), 2))}
            );
		}
	}

    /**
     * Rounds floating point numbers to the number of places indicated
     * @param value Value to be rounded
     * @param numPlaces Round value by number of places
     * @return Rounded value
     */
    private static double round(double value, int numPlaces) {
        if (numPlaces < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bigDecimal = new BigDecimal(value);
        bigDecimal = bigDecimal.setScale(numPlaces, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
}
