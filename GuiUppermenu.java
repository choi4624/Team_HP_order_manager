package shoppingMall;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GuiUppermenu {
	    JPanel upperMenu = new JPanel();
		JLabel sortMenuLabel = new JLabel();
		JLabel selectedSort = new JLabel();
		String sortMenus[] = {"�� ����", "����", "������", "����", "���� ���", "�ֽż�"};
		String menuColor[] = {"Color.red", "Color.magenta", "Color.green", "Color.blue", "Color.cyan", "Color.orange"};
	void addMenu() {
		upperMenu.setPreferredSize(new Dimension(1050,130));
		sortMenuLabel.setPreferredSize(new Dimension(1000,55));
		sortMenuLabel.setLayout(null);
		upperMenu.setBackground(Color.white);
		for(int i=0; i<sortMenus.length; i++) {
			JButton button = new JButton(sortMenus[i]);
			sortMenuLabel.add(button);
			int xcode = 10;										//��ư�� ������ġ ���ϱ�
			xcode += i*(165);
			button.setBounds(xcode, 5, 150, 50);
			button.setBackground(Color.white);
			if(i == 0) {
				button.setForeground(Color.red);
				}
				else if(i==1) {
					button.setForeground(Color.magenta);
				}
				else if(i==2) {
					button.setForeground(Color.green);
				}
				else if(i==3) {
					button.setForeground(Color.blue);
				}
				else if(i==4) {
					button.setForeground(Color.cyan);
				}
				else if(i==5) {
					button.setForeground(Color.ORANGE);
				}					
		}
		upperMenu.add(sortMenuLabel);
		
		selectedSort.setPreferredSize(new Dimension(1000, 130));
		selectedSort.setLayout(null);
		JButton reset = new JButton("�ʱ�ȭ");
		
		for(int i=0;i<sortMenus.length; i++) {
			int xcode = 90;										//��ư�� ������ġ ���ϱ�
			xcode += i*(140);

			JLabel sortLabel = new JLabel("["+sortMenus[i]+"] :");
			if(i == 0) {
			sortLabel.setForeground(Color.red);
			}
			else if(i==1) {
				sortLabel.setForeground(Color.magenta);
			}
			else if(i==2) {
				sortLabel.setForeground(Color.green);
			}
			else if(i==3) {
				sortLabel.setForeground(Color.blue);
			}
			else if(i==4) {
				sortLabel.setForeground(Color.cyan);
			}
			else if(i==5) {
				sortLabel.setForeground(Color.ORANGE);
			}
			selectedSort.add(sortLabel);
			sortLabel.setBounds(xcode, 0, 200, 50);
		}
		selectedSort.add(reset);
		reset.setBounds(950, 0, 50 ,50);
		upperMenu.add(selectedSort);
		MainGUI.leftView.add(upperMenu);
	}
	
}