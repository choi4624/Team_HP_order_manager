package shoppingMall;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.*;

public class ProductGui {
	ArrayList<String> items = new ArrayList<>();
	ArrayList<String> names = new ArrayList<>();

	JPanel productPanel = new JPanel();
	JScrollPane scroll = new JScrollPane(productPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	// 1. products.txt ������ ��� ������ �и��ؼ� arr�� ����
	// 2. arr�� 2��°, 13��°, 24��° ... get�ؼ� names�� ����
	public String[] readProduct() throws IOException {
		File file = new File("products.txt");
		String[] splitstr = null;

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "euc-kr"));
		String line = null;
		splitstr = null;
		while ((line = br.readLine()) != null) {
			splitstr = null;
			splitstr = line.split("\t");

			for (int i = 0; i < splitstr.length; i++) {
				splitstr[i] = splitstr[i].trim();
			}
		}
		System.out.println(splitstr);
		return splitstr;
	}

	public ArrayList<String> getName(String[] splitstr) {
		ArrayList<String> names = new ArrayList<>();
		for (int i = 2; i < splitstr.length; i += 11) {
			String name = splitstr[i];
			names.add(name);
		}
		return names;
	}
	
	public ArrayList<String> getPrice(String[] splitstr) {
		ArrayList<String> prices = new ArrayList<>();
		for(int i=3;i<splitstr.length;i+=11) {
			String price = splitstr[i];
			prices.add(price);
		}
		return prices;
	}

	void addproduct() throws IOException {
		productPanel.setPreferredSize(new Dimension(1000, 1000));
		productPanel.setLayout(new GridLayout(0, 5, 3, 3)); // row, col, hgap, vgap

		for (int i = 0; i < 12; i++) { // �ٲٱ�
			String imgnum = Integer.toString(i + 1);
			ImageIcon pruductImg = new ImageIcon(imgnum + ".jpg");
			Image img = pruductImg.getImage();
			Image changeImg = img.getScaledInstance(180, 180, Image.SCALE_SMOOTH);
			ImageIcon productimg = new ImageIcon(changeImg);

			JLabel product = new JLabel(productimg);
			String[] splitstr = readProduct();
			ArrayList<String> name = getName(splitstr);
			// String name = new String("����");
			String price = new String("3000"); // �� �κ� ����

			JButton b = new JButton(name + " " + price + "��", productimg);
			b.setHorizontalTextPosition(SwingConstants.CENTER);
			b.setVerticalTextPosition(SwingConstants.BOTTOM);
			b.setBorderPainted(false);
			b.setFocusPainted(false);
			product.setBackground(Color.white);
			b.setBackground(Color.WHITE);

			productPanel.add(b);
		}

		scroll.setPreferredSize(new Dimension(1000, 550));
		MainGUI.leftView.add(scroll);

	}

}
