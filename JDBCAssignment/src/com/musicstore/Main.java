package com.musicstore;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.bo.*;
import com.dao.*;
import com.db.ConnectDB;
import com.model.*;

public class Main {

	public static void main(String[] args) {
		Connection conn;	
		
		Scanner scanner = new Scanner(System.in);
		String input ="";
		int inputInt;
		Date inputDate;
		double inputDouble;
		
		OutletBO outBO = new OutletBO();
		ProductBO prodBO = new ProductBO();
		CustomerBO cusBO = new CustomerBO();
		EmployeeBO empBO = new EmployeeBO();
		InventoryBO invBO = new InventoryBO();
		SaleBO saleBO = new SaleBO();
		ReturnBO retBO = new ReturnBO();
		
		Outlet outlet = new Outlet();
		Product product = new Product();
		Customer customer = new Customer();
		Employee employee = new Employee();
		Inventory inventory = new Inventory();
		Sale sale = new Sale();
		Return ret = new Return();
		
			System.out.println("MAIN MENU");
			
			System.out.println(retBO.getQuantity(ret, 12, 3, 5));
			/*
			 * System.out.println("Date of the sale "); Calendar cal1 =
			 * Calendar.getInstance(); System.out.println("Year of sale:"); inputInt =
			 * scanner.nextInt(); cal1.set(Calendar.YEAR, inputInt);
			 * 
			 * System.out.println("Month of sale:"); inputInt = scanner.nextInt();
			 * cal1.set(Calendar.MONTH, inputInt-1);
			 * 
			 * System.out.println("Day of sale:"); inputInt = scanner.nextInt();
			 * cal1.set(Calendar.DAY_OF_MONTH, inputInt);
			 * 
			 * 
			 * System.out.println("Customer Id: "); inputInt = scanner.nextInt(); Date date1
			 * = new Date(cal1.getTimeInMillis()); System.out.println(date1);
			 */
		
		do {
			
			System.out.println("Please, select one option of above: ");
			System.out.println("-----------------------------------");
			System.out.println("1. Sale/return processing ");
			System.out.println("2. Outlet/employee/customer/product maintenance ");
			System.out.println("3. Reports ");
			System.out.println("4. Quit");
			
			input = scanner.nextLine();
			
			String msg;
				switch(input) {
				
					case "1":
							
						
								System.out.println("   SALES/RETURNS MENU");
								System.out.println("   1. Process a sale");
								System.out.println("   2. Process a return");
								System.out.println("   3. View a sale");
								System.out.println("   4. View a return");
								System.out.println("   5. Return to main menu");
								System.out.println("   6. Quit");
								input = scanner.nextLine();
								
								switch(input) {
									case "1":
										System.out.println("This is Process a sale\n");
										
										System.out.println("Outlet number of the sale: ");
										int inputIntOut = scanner.nextInt();
										if(outBO.getRowsById( inputIntOut)!=0) {
											sale.setOutletNumber(inputIntOut);
										}else {
											System.out.println("Outlet number NOT found");
											break;
										}
										
										System.out.println("Employee number of the sale: ");
										inputInt = scanner.nextInt();
										if(empBO.getRowsById( inputInt)!=0) {
											if(empBO.getEmpOutlet(inputInt) == inputIntOut) {
												sale.setEmpNumber(inputInt);
											}else {
												System.out.println("Employee NOT found in that outlet");
												break;
											}
											
										}else {
											System.out.println("Employee number NOT found");
											break;
										}
										
										System.out.println("Customer Id of the sale: ");
										inputInt = scanner.nextInt();
										if(cusBO.getRowsById(customer, inputInt)!=0) {
											sale.setCostumerId(inputInt);
										}else {
											System.out.println("Customer Id NOT found");
											break;
										}
										
										System.out.println("Product Code of the sale: ");
										int inputIntProd = scanner.nextInt();
										if(prodBO.getRowsById(product, inputIntProd)!=0) {
											sale.setProductCode(inputIntProd);
										}else {
											System.out.println("Product Code NOT found");
											break;
										}
										
										System.out.println("Quantity: ");
										inputInt = scanner.nextInt();
										 if((invBO.getRowsById(inventory, sale.getOutletNumber(), sale.getProductCode())) != 0) {
										 	 if (inputInt <= invBO.getQuantity(inventory,inputIntOut, inputIntProd) ) {
												   if(inputInt>0) { 
													 sale.setQuantity(inputInt);
												 
												 
												 inventory.setQuantity(invBO.getQuantity(inventory, inputIntOut, inputIntProd)-inputInt);
												 invBO.modifyInventory(inventory, inputIntOut, inputIntProd);
												 }else {
												 System.out.println("Must be a positive number");
												 }
											 }else {
												System.out.println("Quantity not avaliable");
											 }
										 	}
										 
										 Date saleDate = new Date(System.currentTimeMillis());
										 sale.setSaleDate(saleDate);
										 Time saleTime = new Time(System.currentTimeMillis());
										 sale.setSaleTime(saleTime);
										 	
											 msg = saleBO.ProcessSale(sale);
												System.out.println(msg);
										
										break;
										
									case "2":
											System.out.println("This is Process a return\n");
											
											System.out.println("Reason: ");
											String inputr = scanner.nextLine();
											ret.setReason(inputr);
											
											System.out.println("Outlet number where the sale was done: ");
											int inputIntRet = scanner.nextInt();
											if(outBO.getRowsById( inputIntRet)!=0) {
												ret.setOutletNumber(inputIntRet);
											}else {
												System.out.println("Outlet number NOT found");
												break;
											}
											
											System.out.println("Customer Id of the sale: ");
											int inputIntCos = scanner.nextInt();
											if(cusBO.getRowsById(customer, inputIntCos)!=0) {
												ret.setCostumerId(inputIntCos);
											}else {
												System.out.println("Customer Id NOT found");
												break;
											}
											
											System.out.println("Product Code of the sale: ");
											int inputIntPrd = scanner.nextInt();
											if(prodBO.getRowsById(product, inputIntPrd)!=0) {
												ret.setProductCode(inputIntPrd);
											}else {
												System.out.println("Product Code NOT found");
												break;
											}
											
												 
												 
											
											Date returnDate = new Date(System.currentTimeMillis());
											 ret.setReturnDate(returnDate);
											Time returnTime = new Time(System.currentTimeMillis());
											 ret.setReturnTime(returnTime);
											
											 System.out.println("Quantity to return: ");
											 inputInt = scanner.nextInt();
											 if(saleBO.getQuantity(sale, inputIntRet, inputIntCos, inputIntPrd)!=0) {
												 if(saleBO.getQuantity(sale, inputIntRet, inputIntCos, inputIntPrd)>=inputInt){
													 if(saleBO.getQuantity(sale, inputIntRet, inputIntCos, inputIntPrd)
															 >=retBO.getQuantity(ret, inputIntRet, inputIntCos, inputIntPrd)) {
														 ret.setQuantity(inputInt);
													 }else {
														 System.out.println("Quantity of return EXCEEDS quantity of sale OR "
														 		+ "there is no product to return");
														 break;
													 }
													
													 
												 }else {
													 System.out.println("Quantity of return EXCEEDS quantity of sale");
													 break;
												 }
											 }else {
												 System.out.println("sale to return NOT FOUND");
												 break;
											 }
											 
											 
											
											msg= retBO.ProcessReturn(ret);
											System.out.println(msg);
										break;
										
									case "3":
										System.out.println(" This isView a sale\n");
										
										System.out.println("Date of the sale ");
										Calendar cal = Calendar.getInstance();
										System.out.println("Year of sale:");
										inputInt = scanner.nextInt();
										cal.set(Calendar.YEAR, inputInt);
										
										System.out.println("Month of sale:");
										inputInt = scanner.nextInt();
										cal.set(Calendar.MONTH, inputInt-1);
										
										System.out.println("Day of sale:");
										inputInt = scanner.nextInt();
										cal.set(Calendar.DAY_OF_MONTH, inputInt);
											

										System.out.println("Customer Id: ");
										inputInt = scanner.nextInt();
										Date date = new Date(cal.getTimeInMillis());
										msg =saleBO.viewSale(sale, date,  inputInt);
										System.out.println(msg);
										
										break;
										
									case "4":
										System.out.println(" This isView a return\n");

										System.out.println("Date of the sale ");
										Calendar calRet = Calendar.getInstance();
										System.out.println("Year of sale:");
										inputInt = scanner.nextInt();
										calRet.set(Calendar.YEAR, inputInt);
										
										System.out.println("Month of sale:");
										inputInt = scanner.nextInt();
										calRet.set(Calendar.MONTH, inputInt-1);
										
										System.out.println("Day of sale:");
										inputInt = scanner.nextInt();
										calRet.set(Calendar.DAY_OF_MONTH, inputInt);
											

										System.out.println("Customer Id: ");
										inputInt = scanner.nextInt();
										Date dateRet = new Date(calRet.getTimeInMillis());
										msg =retBO.viewReturn(ret, dateRet,  inputInt);
										System.out.println(msg);
										
										break;
										
									case "5":
										System.out.println("\n");
										break;
										
									case "6":
										System.exit(0);
										break;
										
									default:
										System.out.println("That is not and option\\n");
										break;	
									}			
						break;
						
					case "2":
								
								
								System.out.println("   MAINTENANCE MENU");
								System.out.println("   1. Add/modify/drop outlet");
								System.out.println("   2. Add/modify/drop employee");
								System.out.println("   3. Add/modify/drop customer");
								System.out.println("   4. Add/modify/drop product");
								System.out.println("   5. Process new shipment of products for an outlet");
								System.out.println("   6. Process returns");
								System.out.println("   7. Return to menu");
								System.out.println("   8. Quit");
								input = scanner.nextLine();
								
								
								switch(input) {
								
										case "1":
											
												
												System.out.println("OUTLET MENU");
												System.out.println("      1. Add Outlet");
												System.out.println("      2. Modify Outlet");
												System.out.println("      3. Drop Outlet");
												System.out.println("      4. Return to main menu");
												input = scanner.nextLine();
												
												switch(input) {
												case "1":
													
													
													System.out.println("This is to add an Outlet");
													
													System.out.println("Name of the Outlet: ");
													input =scanner.nextLine();
													if(outBO.getRows(input)==0) {
	
														outlet.setName(input);
														
														
														System.out.println("Address of the Outlet: ");
														input =scanner.nextLine();
														outlet.setAddress(input);
														
														System.out.println("city of the Outlet: ");
														input =scanner.nextLine();
														outlet.setCity(input);
														
														System.out.println("State of the Outlet: ");
														input =scanner.nextLine();
														outlet.setState(input);
														
														System.out.println("Zip of the Outlet: ");
														input =scanner.nextLine();
														outlet.setZip(input);
														
														System.out.println("Phone of the Outlet: ");
														
														try {
															inputInt =scanner.nextInt();
														}catch(InputMismatchException e) {
															System.out.println("That is NOT a number");
															break;
														}
														outlet.setPhone(inputInt);
														
														msg = outBO.addOutlet(outlet);
														System.out.println(msg);
														
													}else {
														System.out.println("That name already exists");
													}	
													break;
													
												case "2":
													System.out.println("This is to moddify an Outlet");
													System.out.println("Name of the Outlet to Modify: ");
													String inputNameOut = scanner.nextLine();
													if(outBO.getRows( inputNameOut)==0) {
														
														System.out.println("Outlet NAME NOT FOUND IN THE DATABASE");
													}else {
													
														System.out.println("Mofify the Name of the Outlet: ");
														input = scanner.nextLine();
														outlet.setName(input);
														
														System.out.println("Mofify the Address of the Outlet: ");
														input =scanner.nextLine();
														outlet.setAddress( input );
														
														System.out.println("Mofify the city of the Outlet: ");
														input =scanner.nextLine();
														outlet.setCity( input );
														
														System.out.println("Mofify the State of the Outlet: ");
														input = scanner.nextLine();
														outlet.setState( input );
														
														System.out.println("Mofify the Zip of the Outlet: ");
														input  =scanner.nextLine();
														outlet.setZip( input );
														
														System.out.println("Mofify the Phone of the Outlet: ");
														
														try {
															 inputInt =scanner.nextInt();
														}catch(InputMismatchException e) {
															System.out.println("That is NOT a number");
															break;
														}
														outlet.setPhone(inputInt);
														msg = outBO.modifyOutlet(outlet, inputNameOut);
														System.out.println(msg);
													}
													break;
													
												case "3":
													System.out.println("This is to Drop an Outlet");
													System.out.println("Number of the Outlet to Drop: ");
													int numOutlet;
													try {
													numOutlet =scanner.nextInt();
													}catch(InputMismatchException e){
														System.out.println("That is NOT a number");
														break;
													}
													if(outBO.getRowsById(numOutlet) ==0){
														System.out.println("OUTLET_NUMBER NOT FOUND");
													}else {
													
														
														msg = outBO.dropOutlet(numOutlet);
														System.out.println(msg);
													}
													break;
													
												case "4":
													System.out.println(" ");
													break;
													
												default:
														System.out.println("That is not an option");
												
												}
										break;
										
									case "2":
											String inputEmployee;
											System.out.println("EMPLOYEE MENU");
											System.out.println("      1. Add Employee");
											System.out.println("      2. Modify Employe");
											System.out.println("      3. Drop Employe");
											System.out.println("      4. Return to main menu");
											inputEmployee = scanner.nextLine();
											
											switch(inputEmployee) {
											case "1":
												
													
													System.out.println("This is to add an Employee");
													
													System.out.println("Name of the Employee: ");
													input =scanner.nextLine();
													if(empBO.getRows( input)==0) {
	
														employee.setEmpName(input);
														
														System.out.println("OULTET NUMBER of the Employee: ");
														try {
														inputInt = scanner.nextInt();
														}catch(InputMismatchException e) {
															System.out.println("That is NOT a number");
															break;
														}
														if(outBO.getRowsById(inputInt)==0) {
															System.out.println("Outlet NAME NOT FOUND IN THE DATABASE");
														}
															else {
															employee.setOutletNumber(inputInt);
														
		
															 msg = empBO.addEmployee(employee);
															System.out.println(msg);
															}
													}else {
														System.out.println("That employee already exists");
													}	
													break;
													
												case "2":
													System.out.println("This is to moddify an Employee");
													
													System.out.println("Name of the Employee to Modify: ");
													String inputEmpName = scanner.nextLine();
													if(empBO.getRows( inputEmpName)==0) {
														
														System.out.println("Employee NAME NOT FOUND IN THE DATABASE");
													}else {
														System.out.println(" Modify the name of the Employee: ");
														input = scanner.nextLine();
														employee.setEmpName(input);
														
														System.out.println("Modify the Outlet number of the Employee: ");
														try {
															inputInt = scanner.nextInt();
															}catch(InputMismatchException e) {
																System.out.println("That is NOT a number");
																break;
															}
														if(outBO.getRowsById( inputInt)==0) {
															System.out.println("Outlet NAME NOT FOUND IN THE DATABASE");
														}
														else {
														employee.setOutletNumber(inputInt);
											
														 msg = empBO.modifyEmployee(employee, inputEmpName);
														System.out.println(msg);
																}
	
													}
													break;
													
												case "3":
													System.out.println("This is to Drop an Employee");
													System.out.println("Number of the Employee to Drop: ");
													int numEmployee;
													try {
													numEmployee =scanner.nextInt();
													}catch(InputMismatchException e){
														System.out.println("That is NOT a number");
														break;
													}
													if(empBO.getRowsById(numEmployee) ==0){
														System.out.println("OUTLET_NUMBER NOT FOUND");
													}else {
														msg = empBO.dropEmployee(numEmployee);
														System.out.println(msg);
													}
													break;
													
												case "4":
													System.out.println(" ");
													break;
													
												default:
														System.out.println("That is not an option");
												
												}
										break;
										
									case "3":
												
												System.out.println("CUSTOMER MENU");
												System.out.println("      1. Add Customer");
												System.out.println("      2. Modify Customer");
												System.out.println("      3. Drop Customer");
												System.out.println("      4. Return to main menu");
												input = scanner.nextLine();
												
												switch(input) {
												case "1":
													
													System.out.println("This is to add an Customer");
													
													System.out.println("Name of the Customer: ");
													input =scanner.nextLine();
													if(cusBO.getRows(customer, input)==0) {
	
														customer.setCustomerName(input);
														
														System.out.println("Address of the Customer: ");
														input =scanner.nextLine();
														customer.setAddress(input);
														
														System.out.println("city of the Customer: ");
														input =scanner.nextLine();
														customer.setCity(input);
														
														System.out.println("State of the Customer: ");
														input =scanner.nextLine();
														customer.setState(input);
														
														System.out.println("Zip of the Customer: ");
														input =scanner.nextLine();
														customer.setZip(input);
														
														System.out.println("Phone of the Customer: ");
														
														try {
															inputInt =scanner.nextInt();
														}catch(InputMismatchException e) {
															System.out.println("That is NOT a number");
															break;
														}
														customer.setPhone(inputInt);
														
		
														 msg = cusBO.addCustomer(customer);
														System.out.println(msg);
													}else {
														System.out.println("That name already exists");
													}	
													break;
													
												case "2":
													System.out.println("This is to moddify an Customer");
													System.out.println("Name of the Customer to Modify: ");
													String inputNameCus = scanner.nextLine();
													if(cusBO.getRows(customer, inputNameCus)==0) {
														
														System.out.println("Customer NAME NOT FOUND IN THE DATABASE");
													}else {
													
														System.out.println("Mofify the Name of the Customer: ");
														input = scanner.nextLine();
														customer.setCustomerName(input);
														
														System.out.println("Mofify the Address of the Customer: ");
														input =scanner.nextLine();
														customer.setAddress( input );
														
														System.out.println("Mofify the city of the Customer: ");
														input =scanner.nextLine();
														customer.setCity( input );
														
														System.out.println("Mofify the State of the Customer: ");
														input = scanner.nextLine();
														customer.setState( input );
														
														System.out.println("Mofify the Zip of the Customer: ");
														input  =scanner.nextLine();
														customer.setZip( input );
														
														System.out.println("Mofify the Phone of the Customer: ");
														
														try {
															 inputInt =scanner.nextInt();
														}catch(InputMismatchException e) {
															System.out.println("That is NOT a number");
															break;
														}
														customer.setPhone(inputInt);
														msg = cusBO.modifyCustomer(customer, inputNameCus);
														System.out.println(msg);
													}
													break;
													
												case "3":
													System.out.println("This is to Drop an Customer");
													System.out.println("Number of the Customer to Drop: ");
													int numCustomer;
													try {
													numCustomer =scanner.nextInt();
													}catch(InputMismatchException e){
														System.out.println("That is NOT a number");
														break;
													}
													if(cusBO.getRowsById(customer, numCustomer) ==0){
														System.out.println("CUSTOMER_ID NOT FOUND");
													}else {
													
														
														msg = cusBO.dropCustomer(numCustomer);
														System.out.println(msg);
													}
													break;
													
												case "4":
													System.out.println(" ");
													break;
													
												default:
														System.out.println("That is not an option");
												
												}
											break;
										
									case "4":
												
												System.out.println("PRODUCT MENU");
												System.out.println("      1. Add Product");
												System.out.println("      2. Modify Product");
												System.out.println("      3. Drop Productr");
												System.out.println("      4. Return to main menu");
												input = scanner.nextLine();
												
												switch(input) {
												case "1":
													
													
													System.out.println("This is to add an Product");
													
													System.out.println("Title of the Product: ");
													input =scanner.nextLine();
													if(prodBO.getRows(product, input)==0) {
	
														product.setTitle(input);
														
														System.out.println("Artist of the Product: ");
														input =scanner.nextLine();
														product.setArtist(input);
														
														System.out.println("Cost of the Product: ");
														
														try {
															inputDouble =scanner.nextDouble();
														}catch(InputMismatchException e) {
															System.out.println("That is NOT a number");
															break;
														}
														product.setCost(inputDouble);
														
														System.out.println("Sale_price of the Product: ");
														
														try {
															inputDouble =scanner.nextDouble();
														}catch(InputMismatchException e) {
															System.out.println("That is NOT a number");
															break;
														}
														product.setSalePrice(inputDouble);
		
		
														 msg = prodBO.addProduct(product);
														System.out.println(msg);
														
													}else {
														System.out.println("That product already exists");
													}	
													break;
													
												case "2":
													System.out.println("This is to moddify an Product");
													System.out.println("Name of the Product to Modify: ");
													String inputTitleProd = scanner.nextLine();
													if(prodBO.getRows(product, inputTitleProd)==0) {
														
														System.out.println("Product NAME NOT FOUND IN THE DATABASE");
													}else {
														System.out.println(" Modify the Title of the Product: ");
														input = scanner.nextLine();
														product.setTitle(input);
														
														System.out.println("Modify the Artist of the Product: ");
														input =scanner.nextLine();
														product.setArtist(input);
														
														System.out.println("Modify the Cost of the Product: ");
														
														try {
															inputInt =scanner.nextInt();
														}catch(InputMismatchException e) {
															System.out.println("That is NOT a number");
															break;
														}
														product.setCost(inputInt);
														
														System.out.println("Modify the Sale_price of the Product: ");
														
														try {
															inputInt =scanner.nextInt();
														}catch(InputMismatchException e) {
															System.out.println("That is NOT a number");
															break;
														}
														product.setSalePrice(inputInt);
		
		
														 msg = prodBO.modifyProduct(product,inputTitleProd);
														System.out.println(msg);
														
													}
													break;
													
												case "3":
													System.out.println("This is to Drop an Product");
													System.out.println("Number of the Product to Drop: ");
													int numProduct;
													try {
													numProduct =scanner.nextInt();
													}catch(InputMismatchException e){
														System.out.println("That is NOT a number");
														break;
													}
													if(prodBO.getRowsById(product, numProduct) ==0){
														System.out.println("PRDOCUCT_CODE NOT FOUND");
													}else {
													
														
														msg = prodBO.dropProduct(numProduct);
														System.out.println(msg);
													}
													break;
													
												case "4":
													System.out.println(" ");
													break;
													
												default:
														System.out.println("That is not an option");
												
												}
											break;
										
									case "5":
										System.out.println(" This is Process new shipment of products for an outlet");
										int inputOutN;
										int inputProdCod;
										int qty;
										try {
											
											System.out.println("Outlet Number: ");
											inputOutN = scanner.nextInt();
										}catch(InputMismatchException e){
												System.out.println("That is NOT a number");
												break;
											}
										if(outBO.getRowsById( inputOutN)==0) {
											System.out.println("OUTLET_NUMBER	  NOT FOUND");
										
										}else {
											try {
												
												System.out.println("Product Code: ");
												inputProdCod = scanner.nextInt();
												System.out.println("Quantity: ");
												qty = scanner.nextInt();
											}catch(InputMismatchException e){
													System.out.println("That is NOT a number");
													break;
												}
											 if((prodBO.getRowsById(product, inputProdCod) ==0)){
												System.out.println("PRODUCT_CODE  NOT FOUND");
											}else {
	
													if(invBO.getRowsById(inventory, inputOutN, inputProdCod)== 0 ){
														
														
														inventory.setOutletNumber(inputOutN);
														inventory.setProductCode(inputProdCod);
														inventory.setQuantity(qty);
														
														msg = invBO.addInventory(inventory);
														System.out.println(msg);
														
													}else {
														
														inventory.setQuantity(invBO.getQuantity(inventory, inputOutN, inputProdCod)+qty);
														
														msg = invBO.modifyInventory(inventory, inputOutN, inputProdCod);
														System.out.println(msg);
													}
											}
										
										}
										
										
										break;
										
										
									case "6":
										System.out.println(" This is Process returns");
										break;
										
									case "7":
										System.out.println("\n");
										break;
										
									case "8":
										System.exit(0);
										break;
										
									default:
										System.out.println("That is not and option\\n");
										break;	
								}
								
						break;
						
					case "3":
						
							String inputR;
							
							System.out.println("   REPORTS MENU");
							System.out.println("   1. Produce yearly sales report for outlet");
							System.out.println("   2. Produce sales report for employee");
							System.out.println("   3. Produce the list of the top 10 selling items");
							System.out.println("   4. Quit");
							
							inputR = scanner.nextLine();
							
							switch(inputR) {
								case "1":
									System.out.println("This is Produce yearly sales report for outlet\n");
									System.out.println("Outlet Number: ");
									int inputOut = scanner.nextInt();
									
									System.out.println("Year: ");
									int inputYear = scanner.nextInt();
									
									System.out.println(saleBO.SYReport(inputYear, inputOut));
									break;
									
								case "2":
									System.out.println("This is Produce sales report for employee\n");
									System.out.println("Employee number: ");
									inputInt = scanner.nextInt();
									System.out.println(saleBO.SEReport(inputInt));
									break;
									
								case "3":
									System.out.println(" This is Produce the list of the top 10 selling items\n");
									System.out.println(saleBO.topProducts());
									break;
									
								case "4":
									System.exit(0);
									break;
									
								default:
									System.out.println("that is not an option");
							}
						break;		
					
					case "4":
						System.exit(0);
						break;
						
					default:
						System.out.println("that is not an option");
							
					}
				
		}while(input != "4");
			
			
		
		
		
		
	}

}
