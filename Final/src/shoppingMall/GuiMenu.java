package shoppingMall;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import store.Order;


public class GuiMenu {
	String menus [] = {"����", "�ֹ�����", "��ٱ���", "�α׾ƿ�",};
	int count=0;
	void addMenu() {
		ActionListener listener = new ButtonListener();
		MainGUI.menuPanel.setLayout(new GridLayout(5,1,0,10));
		MainGUI.menuPanel.setPreferredSize(new Dimension(150, 650));
		addLogo();
		for(int i=0;i<4;i++) {
			String menuname = menus[i];										
			JButton button = new JButton(menuname);
			button.addActionListener(listener);
			button.setBackground(Color.white);
			MainGUI.menuPanel.add(button);
			
		}
		MainGUI.menuPanel.setBackground(Color.white);
	}
	void addLogo() {
		ImageIcon logo = new ImageIcon("./images/logo.png");			//���뺸���̹��� ����
		Image img = logo.getImage();
		Image changeImg= img.getScaledInstance(150,110, Image.SCALE_SMOOTH);
		ImageIcon logo2 = new ImageIcon(changeImg);
		JButton logobutton = new JButton(logo2);
		logobutton.setBorderPainted(false);
		logobutton.setBackground(Color.white);
		MainGUI.menuPanel.add(logobutton);
	}
	
	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonName = e.getActionCommand();
			if(buttonName.equals("����")) {
				MainGUI.basketpanel.setVisible(false);
				MainGUI.leftView.setVisible(true);
			}
			else if(buttonName.equals("�ֹ�����")) {
				JOptionPane.showMessageDialog(null, "�ֹ�����");
			}
			else if(buttonName.equals("��ٱ���")) {
				MainGUI.basket.basketlabels.removeAll();
				MainGUI.basket.updateBasket();

				MainGUI.leftView.setVisible(false);
				MainGUI.basketpanel.setVisible(true);
			}
			else if(buttonName.equals("�α׾ƿ�")) {
				MainGUI.loggedinuser = null;
				MainGUI.mainFrame.setVisible(false);
				MainGUI.login.main(menus);
			}
		}
	}
}