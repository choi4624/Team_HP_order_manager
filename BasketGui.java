package shoppingMall;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class BasketGui {
		String header[] = {"��ǰ��", "����", "����", "�����"};
		String contents[][] = {
				{"�Ƶ�ٽ�����", "100", "90000��", "�����б�"},
				{"�Ｑ������", "50", "8000��", "������б�"},							//������ ������ �߰��ϴ� ������ ���� ������Ʈ.
				{"������ǻ��", "20", "900000", "�������б�"},
				{"��������ǻ��", "10", "2000000", "�������б�"},
				{"������ǻ��", "20", "900000", "�������б�"},
				{"������ǻ��", "20", "900000", "�������б�"},
				{"������ǻ��", "20", "900000", "�������б�"},
				{"������ǻ��", "20", "900000", "�������б�"},
				{"������ǻ��", "20", "900000", "�������б�"},
				{"������ǻ��", "20", "900000", "�������б�"},
				{"������ǻ��", "20", "900000", "�������б�"},
				{"������ǻ��", "20", "900000", "�������б�"},
				{"������ǻ��", "20", "900000", "�������б�"},
				{"������ǻ��", "20", "900000", "�������б�"},
				{"������ǻ��", "20", "900000", "�������б�"},
				{"������ǻ��", "20", "900000", "�������б�"},
				{"������ǻ��", "20", "900000", "�������б�"}
		};
		JButton clearBasket = new JButton("��ٱ��� ����");
		JButton paybutton = new JButton("�����ϱ�");
		JTable basketTable = new JTable(contents, header);
		JScrollPane scrollPane =new JScrollPane(basketTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JTextField orderInfo = new JTextField("��ۿ�����: 2021/11/30, �� ����: 99000");
		
	void addBasket() {
		basketTable.setPreferredSize(new Dimension(950,700));
		scrollPane.setPreferredSize(new Dimension(1000,500));
//		MainGUI.basketpanel.setBackground(Color.white);
		MainGUI.basketpanel.setBounds(20, 30, 1000, 630);
		MainGUI.basketpanel.add(scrollPane);
		MainGUI.basketpanel.add(orderInfo);
		MainGUI.basketpanel.add(clearBasket);
		MainGUI.basketpanel.add(paybutton);
	}
}