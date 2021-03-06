package com.cs304.frontend.views;

import com.cs304.data_managers.ProductDM;
import com.cs304.data_objects.Product;
import com.cs304.frontend.Error_Pop;
import com.cs304.frontend.Success_Pop;
import net.miginfocom.swing.MigLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Pro_Sto extends JFrame {


	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void New_Sto() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pro_Sto frame = new Pro_Sto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pro_Sto() {
		String Fname;
		String Lname;
		int pnum;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[150px][grow][][][][]", "[25px][25px][][][][][][][][]"));

		JLabel lblNewLabel_3 = new JLabel("Prod ID");
		contentPane.add(lblNewLabel_3, "cell 0 2,alignx right");

		textField = new JTextField();
		contentPane.add(textField, "cell 1 2 2 1,growx");
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Quanitity");
		contentPane.add(lblNewLabel_2, "cell 0 3,alignx right");

		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 1 3 2 1,growx");
		textField_1.setColumns(10);

		JButton btnNewButton_3 = new JButton("View PRODUCT List");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Pop_Pro pp = new Pop_Pro();
				pp.New_Pop();
			}
		});
		getContentPane().add(btnNewButton_3, "cell 1 7,growx,aligny top");




		JButton btnNewButton_8 = new JButton("Stock Prod");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProductDM pdm = new ProductDM();
				if (textField.getText().equals("") || textField_1.getText().equals(""))
				{
					Error_Pop ep = new Error_Pop();
					ep.New_Pop();

				}
				else
				{

					pdm.addProductStock(textField.getText(),textField_1.getText());
					Success_Pop sp = new Success_Pop();
					sp.New_Pop();
				}
			}});
		getContentPane().add(btnNewButton_8, "cell 0 7,growx,aligny top");

		JButton btnNewButton_9 = new JButton("Back to Main");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Main_selections ms = new Main_selections();
				setVisible(false);
				dispose();
				ms.New_Window();
			}
		});
		getContentPane().add(btnNewButton_9, "cell 2 7,growx,aligny top");



	}

}
