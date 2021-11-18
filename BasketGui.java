package shoppingMall;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class BasketGui {
		ActionListener Listener = new ButtonListener();
		String header[] = {"��ǰ��", "����", "����", "�����"};
		String contents[][] = {
				{"�Ƶ�ٽ�����", "100", "90000", "�����б�"},
				{"�Ｑ������", "50", "8000", "������б�"},							//������ ������ �߰��ϴ� ������ ���� ������Ʈ.
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
		JButton payButton = new JButton("�����ϱ�");
		JTable basketTable = new JTable(contents, header);
		JScrollPane scrollPane =new JScrollPane(basketTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
		ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JTextField orderInfo = new JTextField("��ۿ�����: 2021/11/30, �� ����: 99000");
		
	void addBasket() {
		basketTable.setPreferredSize(new Dimension(950,700));
		basketTable.getColumnModel().getColumn(0).setPreferredWidth(40);  //JTable �� �÷� ���� ����
		basketTable.getColumnModel().getColumn(1).setPreferredWidth(20);
		basketTable.getColumnModel().getColumn(2).setPreferredWidth(300);
		basketTable.getColumnModel().getColumn(3).setPreferredWidth(200);
		scrollPane.setPreferredSize(new Dimension(1000,500));
		clearBasket.addActionListener(Listener);
		payButton.addActionListener(Listener);
		MainGUI.basketpanel.setBounds(20, 30, 1000, 630);
		MainGUI.basketpanel.add(scrollPane);
		MainGUI.basketpanel.add(orderInfo);
		MainGUI.basketpanel.add(clearBasket);
		MainGUI.basketpanel.add(payButton);
	}
	

	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonName = e.getActionCommand();
			if(buttonName.equals("�����ϱ�")) {
				JOptionPane.showMessageDialog(null, "�����Ͻðڽ��ϱ�? �����̿ϼ���");
			}
			else if(buttonName.equals("��ٱ��� ����"))
				JOptionPane.showMessageDialog(null, "�ֹ������� ��� ���, �̿ϼ�");
			
		}
}
}