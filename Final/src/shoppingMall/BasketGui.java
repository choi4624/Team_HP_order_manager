package shoppingMall;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


import store.*;


public class BasketGui {	
		ActionListener Listener = new ButtonListener();
		JPanel basketlabels = new JPanel();
		JButton clearBasket = new JButton("��ٱ��� ����");
		JButton payButton = new JButton("�����ϱ�");
		public int lastorderId;
		
		JTextField orderinfo  = new JTextField();
		static LocalDate Date = LocalDate.now();
		static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY LLLL dd");
		public static String todaydate = Date.format(formatter);

	public void addBasket() {
		lastorderId = Store.orderMgr.mList.get
				(Store.orderMgr.mList.size()-1).orderId;
		basketlabels.setPreferredSize(new Dimension(800, 1300));
		basketlabels.setLayout(new GridLayout(0,3,0,5));
		basketlabels.setBackground(Color.gray);
		
		JScrollPane scroll = new JScrollPane(basketlabels,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(900, 500));
		updateBasket();
		clearBasket.addActionListener(Listener);
		clearBasket.setSize(400, 100);
		payButton.addActionListener(Listener);
		payButton.setSize(400,100);
		MainGUI.basketpanel.add(scroll);
		MainGUI.basketpanel.setBounds(20, 30, 1000, 630);
		
		MainGUI.basketpanel.add(clearBasket);
		MainGUI.basketpanel.add(payButton);
	}
	

	class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonName = e.getActionCommand();
			Order od = null;
			od = User.myOrderList.get(User.myOrderList.size()-1);
			lastorderId = Store.orderMgr.mList.get(Store.orderMgr.mList.size()-1).orderId;
			od.calcTotal();
			
			int total = od.total;
					// od.returntotal(); 
			if(buttonName.equals("�����ϱ�")) {
				int result = JOptionPane.showConfirmDialog(null,
				"���ó�¥: "+todaydate + "\n��ۿ�����: "+
				od.deliveryDate + "\n�� ����: "+ total+
				"�����Ͻðڽ��ϱ�?"
				);
				if(result == JOptionPane.CLOSED_OPTION) {
					return;
				}
				else if(result == JOptionPane.YES_OPTION) {
					
					for(int alpha = 0; alpha < od.orderedItemList.size(); alpha++ )
						{
						Item itm = od.orderedItemList.get(alpha);
						store.Order.addProduct(itm.prCode, od.orderedItemCount.get(alpha));
						
						//��¥ ��� 
						LocalDate testDate = LocalDate.now();
						DateTimeFormatter Ndate = DateTimeFormatter.ofPattern("yyyyMMdd");
					    LocalDate tempDate = testDate.plusDays(itm.prDeliver);
					    String odDate = od.deliveryDate;
					    
					    LocalDate StockDate = LocalDate.parse(odDate, Ndate); 
					    int periodDate = (int) ChronoUnit.DAYS.between(tempDate,StockDate);
					    System.out.printf("%d", periodDate);
					    if (periodDate <= 0) {
					    	String formatDate = LocalDate.from(tempDate).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
					    	od.deliveryDate = formatDate;
					    }
						/* LocalDate curDate = LocalDate.now();
						LocalDate Date = curDate.plusDays(itm.prDeliver);
						
						SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				        String strDate = od.deliveryDate;
				        LocalDate date = LocalDate.parse(strDate, formatter);
				        int periodDate = (int) ChronoUnit.DAYS.between(Date, date);
				        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyymmdd");
						String prDate = Date.format(formatter); 
				        
						if(periodDate > 0)
							od.deliveryDate = prDate;	
							
							  testDate = LocalDate.now();
		 prCode2 = scan.next();
	     newStock = scan.nextInt();
	     tempDate = scan.next();
	     DateTimeFormatter Ndate = DateTimeFormatter.ofPattern("yyyyMMdd");
	     StockDate = LocalDate.parse(tempDate, Ndate); 
	    
	     periodDate = (int) ChronoUnit.DAYS.between(testDate,StockDate);
	        System.out.print(periodDate);
						*/
						}
					
					
					od.user = (User)Store.userMgr.find(MainGUI.loggedinuser.userId);
					int odindex = store.User.myOrderList.size()-1;
					store.User.myOrderList.add(odindex, od);
					Order.fileUpdate(od);
					System.out.println("���� ���");
					
					System.out.printf("%d %s %s, %s, %s, %s", od.orderId, od.address, od.deliveryDate, od.orderDate, od.orderedItemList, od.orderedItemCount);
					System.out.printf("%s", MainGUI.loggedinuser.phoneNum);
					System.out.println(od.user.userId);
					System.out.println("od ���");
					System.out.println(od.toString());
					/*Order order = new Order();
					//�����Ͻðڽ��ϱ�? �� �������� ������ ����
						order.orderCreate(od);*/
					lastorderId++;
					
				}
				else if(result==JOptionPane.NO_OPTION) {
					return;
				}
			}
			
			
			else if(buttonName.equals("��ٱ��� ����")) {
				int result = JOptionPane.showConfirmDialog(null,
						"���� ����ðڽ��ϱ�?","Confirm",JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.CLOSED_OPTION) {
					return;
					}
				else if(result == JOptionPane.YES_OPTION) {
						od.orderedItemList.clear();
						od.orderedItemCount.clear();
					}
				else
					return;
				
			}
		}
	}
	ImageIcon getImg(String imgnum, int num) {
		ImageIcon pruductImg = new ImageIcon("./images/"+imgnum);
		Image img = pruductImg.getImage();
		Image changeImg= img.getScaledInstance(num,num, Image.SCALE_SMOOTH);	
		ImageIcon productimg = new ImageIcon(changeImg);
		return productimg;
	}
	
	public void updateBasket() {
		Order od = null;
		if(!MainGUI.loggedinuser.myOrderList.isEmpty()) {
			od = MainGUI.loggedinuser.myOrderList.get(MainGUI.loggedinuser.myOrderList.size()-1);
			if(od.orderId == lastorderId+1){
				for(int i=0; i<od.orderedItemList.size();i++) {
					Item itm = od.orderedItemList.get(i);
					JLabel products = new JLabel();
					products.setSize(600,150);
					
					String count = Integer.toString(od.orderedItemCount.get(i));
					String pname = itm.prName;
					String price = Integer.toString(itm.prPrice);
					
					JButton name = new JButton("<HTML>"
					+pname+"<br>"+price+"<br>"+count+"</HTML>");
					
					name.setFont(new Font("Serif",Font.BOLD, 20));
					name.setSize(200,120);
					name.setBackground(Color.white);
					
					
					ImageIcon productimg = getImg(itm.primg, 80);
					JButton primage = new JButton(productimg);
					primage.setSize(150, 120);
					primage.setBackground(Color.white);
					
			
					JButton address = new JButton("��۹�ȣ: " + od.address);
					address.setSize(130,120);
					address.setBorderPainted(false);
					address.setBackground(Color.white);
					address.setFont(new Font("Serif",Font.BOLD, 20));
					
					basketlabels.add(primage);
					basketlabels.add(name);
					basketlabels.add(address);
				}
			}
		}
	}
}