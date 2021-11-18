package shoppingMall;

import java.awt.*;

import java.awt.event.*;


import javax.swing.*;


public class GuiMenu {
	String menus [] = {"����", "�ֹ�����", "��ٱ���", "�α׾ƿ�",};
	void addMenu() {
		ActionListener listener = new ButtonListener();
		MainGUI.menuPanel.setLayout(new GridLayout(5,1,0,10));
		MainGUI.menuPanel.setPreferredSize(new Dimension(150, 650));
		addLogo();
		for(int i=0;i<4;i++) {
			String menuname = menus[i];										//���� �޴���ư �߰�, �����̾ȹٲ�;
			JButton button = new JButton(menuname);
			button.addActionListener(listener);
			button.setBackground(Color.white);
			MainGUI.menuPanel.add(button);
			
		}
		MainGUI.menuPanel.setBackground(Color.white);
	}
	void addLogo() {
		ImageIcon logo = new ImageIcon("./images/bonobono.png");			//���뺸���̹��� ����
		Image img = logo.getImage();
		Image changeImg= img.getScaledInstance(120,100, Image.SCALE_SMOOTH);
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
			else if(buttonName.equals("�ֹ�����"))
				JOptionPane.showMessageDialog(null, "�ֹ�����");
			else if(buttonName.equals("��ٱ���")) {
				MainGUI.leftView.setVisible(false);
				MainGUI.basketpanel.setVisible(true);
			}
			else if(buttonName.equals("�α׾ƿ�"))
				JOptionPane.showMessageDialog(null, "�α׾ƿ�");
		}
		
	}
}