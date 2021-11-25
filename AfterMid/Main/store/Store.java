package store;

import java.util.Scanner;
import mgr.*;

public class Store {
	Scanner scan = new Scanner(System.in);
	static Manager<Item> itemMgr = new Manager<>();
	static Manager<User> userMgr = new Manager<>();
	static Manager<Admin> adminMgr = new Manager<>();
	static Manager<Order> orderMgr = new Manager<>();
	static Manager<Stock> stockMgr = new Manager<>();
	static Manager<Cart> cartMgr = new Manager<>();
	
	public void run() {
		readAllManager();
		writeAllManager();
		readAllManager2();
		Menu menu = new Menu();
		//menu.loginMenu(scan);
	}

	private void readAllManager2() {
		itemMgr.readAll("products2.txt", new Factory<Item>() {
			public Item create() {
				return new Item();
			}
		});
		userMgr.readAll("user2.txt", new Factory<User>() {
			public User create() { 
				return new User();
				}
		});
		adminMgr.readAll("admin2.txt", new Factory<Admin>() {
			public Admin create() {
				return new Admin();
			}
		});
		orderMgr.readAll("order2.txt", new Factory<Order>(){
			public Order create() { 
				return new Order();
				}
		});
		stockMgr.readAll("stock2.txt", new Factory<Stock>() {
			public Stock create() {
				return new Stock();
			}
		});
	}

	void readAllManager() {
		itemMgr.readAll("products.txt", new Factory<Item>() {
			public Item create() {
				return new Item();
			}
		});
		userMgr.readAll("user.txt", new Factory<User>() {
			public User create() { 
				return new User();
				}
		});
		adminMgr.readAll("admin.txt", new Factory<Admin>() {
			public Admin create() {
				return new Admin();
			}
		});
		orderMgr.readAll("order.txt", new Factory<Order>(){
			public Order create() { 
				return new Order();
				}
		});
		stockMgr.readAll("stock.txt", new Factory<Stock>() {
			public Stock create() {
				return new Stock();
			}
		});
	}
	
	void writeAllManager()
	{
		itemMgr.writeAll("products2.txt", new Factory<Item>() {
			public Item create() {
				return new Item();
			}
		});
		userMgr.writeAll("user2.txt", new Factory<User>() {
			public User create() { 
				return new User();
				}
		});
		adminMgr.writeAll("admin2.txt", new Factory<Admin>() {
			public Admin create() {
				return new Admin();
			}
		});
		orderMgr.writeAll("order2.txt", new Factory<Order>(){
			public Order create() { 
				return new Order();
				}
		});
		stockMgr.writeAll("stock2.txt", new Factory<Stock>() {
			public Stock create() {
				return new Stock();
			}
		});
	}
	
	public static void main(String args[]) {
		Store store = new Store();
		store.run();
	}
}
