import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex01 {

	public static void main(String[] args) {
		Dimension dim = new Dimension(400,150);
		
		JFrame frame = new JFrame("�ູ�� �Ǹ���");
		frame.setLocation(200,400);
		frame.setPreferredSize(dim);
		
		String header[] = {"��ǰ��", "����", "����", "�����"};
		String contents[][] = {
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""}
		};
		JTable table = new JTable(contents, header);
		JScrollPane scrollpane =new JScrollPane(table);
		
		frame.add(scrollpane);
		
		System.out.println(table.getColumnName(0));
		
		frame.pack();
		frame.setVisible(true);
	}

}
