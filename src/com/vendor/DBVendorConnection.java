package com.vendor;

import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.Statement;
import java.time.Instant;
import java.sql.SQLException;

import java.sql.*;

public class DBVendorConnection {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/vendorprocurement";
	String SQL = "";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "password";
	boolean ExistingUser = false;

	Connection conn = null;
	Statement stmt = null;
	String loggeduser = "";
	String loggedpass = "";
	private String companyname;
	private String companytype;
	private String registrationno;
	private String industry;
	private String contactpersonname;
	private String companywebsite;
	private Date dateregistered;

	private String address;

	
	private String city;
	private String state;
	private String zipcode;
	private String country;
	private String phone;
	private String cellular;
	private String email;

	private String registrationid;
	private String username;

	private String productname;
	private int Avgmonthlyproduction;

	private int noofsales1;
	private int noofsales2;
	private int noofsales3;

	private double profit1;
	private double profit2;
	private double profit3;

	private double otherincome1;
	private double otherincome2;
	private double otherincome3;

	EmailHelper emailHelper = null;

	public DBVendorConnection() {
		emailHelper = new EmailHelper();
	}
	
	public void SendAlert(String Email, String Title, String Body) {
		emailHelper.SendEmail(Email, Title, Body + " " + Instant.now());
	}

	// update contact
	public void DBUpdateContact(String VID, String ContactPerson, String Address, String City,
			String State, String ZIP, String Country, String OfficePhone, String CellPhone, String Email) {

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Updating statement...");
			stmt = conn.createStatement();

			SQL = "UPDATE contact SET ContactPerson = '" + ContactPerson + "', " +
					 "Address = '" + Address + "', City = '" + City + "', State = '" + State + "', " +
					 "ZIP = '" + ZIP + "', Country = '" + Country + "',  phone = '" + OfficePhone + "', " +
					 "cellphone = '" + CellPhone + "', Email = '" + Email + "' WHERE VENDORID = '" + VID + "'";
				

			System.out.print("Vendor ID iS " + VID);

			stmt.execute(SQL);
			// Registration Data Updated
			// STEP 6: Clean-up environment
			stmt.close();
			conn.close();

			//emailHelper.SendEmail(Email, "Your contact information has been updated", "Update made to contact " + Instant.now());

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}

	public void DBUpdateProduct(String VID, String ProductName, int AvgMonthlyProduction, String Email) {

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Updating statement...");
			stmt = conn.createStatement();

			SQL = "UPDATE product SET ProductName = '" + ProductName + "',  AvgMonthlyProduction = " +
					" " + AvgMonthlyProduction + "  WHERE VENDORID = '" + VID + "'";

			System.out.print("Vendor ID iS " + VID);

			stmt.execute(SQL);
			// Product Data Updated
			// STEP 6: Clean-up environment
			stmt.close();
			conn.close();

			//emailHelper.SendEmail(Email, "Your product information has been updated", "Update made to product " + Instant.now());

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
		// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}

	public void DBUpdateRegistration(String VID, String cName, String cType, String Indus, String CompanyWebsite,
			java.util.Date DateRegistered, String Email) {

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Updating statement...");
			stmt = conn.createStatement();

			SQL = "UPDATE REGISTRATION SET COMPANYNAME = '" + cName + "', COMPANYTYPE = '" + cType + "', Industry = '"
					+ Indus + "', CompanyWebsite = '" + CompanyWebsite + "', DateRegistered = '" + DateRegistered.toString() + "' "
					+ "WHERE VENDORID = '" + VID + "'";

			System.out.print("Vendor ID iS " + VID);

			stmt.execute(SQL);
			// Registration Data Updated
			// STEP 6: Clean-up environment
			stmt.close();
			conn.close();

			//emailHelper.SendEmail(Email, "Your registration information has been updated", "Update made to registration " + Instant.now());

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}

	public void DBUpdateSales(String VID, int NoOfSales1, int NoOfSales2, int NoOfSales3, double Profit1,
			double Profit2, double Profit3, double OtherIncome1, double OtherIncome2, double OtherIncome3, String Email) {

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Updating statement...");
			stmt = conn.createStatement();

			SQL = "UPDATE sales SET NoOfSales1 = " + NoOfSales1 + ", NoOfSales2 = " + NoOfSales2 + ", " +
					 "NoOfSales3 = " + NoOfSales3 + ",  ProfitBeforeInterest1 = " + Profit1 + ", " +
					 "ProfitBeforeInterest2 = " + Profit2  + ", ProfitBeforeInterest3 = " + Profit3 + ", "  +
					 "OtherIncome1 = " + OtherIncome1 + ", OtherIncome2 = " + OtherIncome2 + ", " +
					 "OtherIncome3 = " + OtherIncome3 + "  WHERE VENDORID = '" + VID + "'";

			System.out.print("Vendor ID iS " + VID);

			stmt.execute(SQL);
			// Sales Data Updated
			// STEP 6: Clean-up environment
			stmt.close();
			conn.close();

			//emailHelper.SendEmail(Email, "Your sales information has been updated", "Update made to sales " + Instant.now());

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}

	public void DBInsertLoginInfo(String UserName, String Password, String VendorID, String Email) {

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			SQL = "INSERT INTO VENDORLOGIN (UserName, Password, VendorID) " + " VALUES ( '" + UserName + "',  '"
					+ Password + "','" + VendorID + "')";

			stmt.execute(SQL);
			// Login Data Inserted
			// STEP 6: Clean-up environment
			stmt.close();
			conn.close();

			//emailHelper.SendEmail(Email, "Your login information has been saved", "Login Information Saved" + Instant.now());

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}

	public void DBInsertSales(String VendorID, int NoOfSales1, int NoOfSales2, int NoOfSales3, double Profit1,
			double Profit2, double Profit3, double OtherIncome1, double OtherIncome2, double OtherIncome3, String Email) {

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			SQL = "INSERT INTO SALES (VendorID, NoOfSales1, NoOfSales2, NoOfSales3,ProfitBeforeInterest1,ProfitBeforeInterest2,ProfitBeforeInterest3, OtherIncome1,OtherIncome2,OtherIncome3) "
					+ " VALUES ( '" + VendorID + "', " + NoOfSales1 + ", " + NoOfSales2 + ", " + NoOfSales3 + ", "
					+ Profit1 + ", " + Profit2 + "," + Profit3 + "," + OtherIncome1 + ", " + OtherIncome2 + ", "
					+ OtherIncome3 + ")";

			stmt.execute(SQL);
			// Sales Data Inserted
			// STEP 6: Clean-up environment
			stmt.close();
			conn.close();

			//emailHelper.SendEmail(Email, "Your sales information has been saved", "Sales Information Saved " + Instant.now());

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}

	public void DBInsertProduct(String ProductName, String VendorID, int AvgMonthlyProduction, String Email) {

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			SQL = "INSERT INTO PRODUCT (ProductName, VendorID, AvgMonthlyProduction) " + " VALUES ('" + ProductName
					+ "', '" + VendorID + "', " + AvgMonthlyProduction + ")";

			stmt.execute(SQL);
			// Product Data Inserted
			// STEP 6: Clean-up environment
			stmt.close();
			conn.close();

			//emailHelper.SendEmail(Email, "Your product information has been saved", "Product Information Saved " + Instant.now());

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}

	public void DBInsertContact(String ContactPerson, String VendorID, String Address,String City, String State,
			String ZipCode, String Country, String Phone, String Cellular, String Email) {

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			// ContactPerson = "Sankalp";

			SQL = "INSERT INTO CONTACT (ContactPerson, VendorID, Address, City, State, Zip, Country, Phone, CellPhone, Email) "
					+ " VALUES ('" + ContactPerson + "', '" + VendorID + "', '" + Address + "', '" + City + "', '"
					+ State + "', '" + ZipCode + "', '" + Country + "', " + " '" + Phone + "', '" + Cellular + "', '"
					+ Email + "')";

			stmt.execute(SQL);
			// Contact Data Inserted
			// STEP 6: Clean-up environment
			stmt.close();
			conn.close();

			//emailHelper.SendEmail(Email, "Your contact information has been saved", "Contact Information Saved " + Instant.now());

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}

	public void DBInsertVendorRegistration(String VendorID, String CompanyName, String CompanyType, String Industry,
			String CompanyWebsite, java.util.Date DateRegistered, String Email) {

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			System.out.println("VendorID is " + VendorID);
			System.out.println("CompanyName is " + CompanyName);
			System.out.println("CompanyType is " + CompanyType);

			SQL = "INSERT INTO REGISTRATION VALUES ('" + VendorID + "' , '" + CompanyName + "', '" + CompanyType
					+ "', + '" + Industry + "', + '" + CompanyWebsite + "', + '" + DateRegistered.toString() + "')";

			stmt.execute(SQL);
			// Registration Data Inserted
			// STEP 6: Clean-up environment
			stmt.close();
			conn.close();

			//emailHelper.SendEmail(Email, "Your registration information has been saved", "Registration Information Saved " + Instant.now());

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}

	public VendorInformation DBRetrieveVendorInfo(String UserName) {
		VendorInformation vend = new VendorInformation();
		try {

			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			SQL = "SELECT r.vendorid, r.companyname, r.companytype, r.industry, r.companywebsite, r.dateregistered, c.contactperson,c.address,c.city, c.state,c.zip, c.country, c.phone, c.cellphone, "
					+ "c.email, p.productname, p.avgmonthlyproduction, "
					+ "s.noofsales1,s.noofsales2,s.noofsales3,s.profitbeforeinterest1,s.profitbeforeinterest2,s.profitbeforeinterest3, "
					+ "s.otherincome1, s.otherincome2, s.otherincome3 "
					+ "FROM contact c,registration r,sales s,product p, vendorlogin v " + "WHERE "
					+ "r.vendorid = c.VendorID AND r.vendorid = p.VendorID AND  r.vendorid = s.VendorID AND  r.vendorid = v.vendorid "
					+ "AND v.username = '" + UserName + "' ORDER BY r.vendorid";

			ResultSet rs = stmt.executeQuery(SQL);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				// vend.setCompanyname(rs.getString("companyname"));

				username = UserName;

				registrationno = rs.getString("vendorid");
				companyname = rs.getString("companyname");

				// vend.setCompanytype(rs.getString("companytype"));

				companytype = rs.getString("companytype");

				// vend.setIndustry(rs.getString("industry"));
				industry = (rs.getString("industry"));

				companywebsite = rs.getString("companywebsite");

				try {
					dateregistered = Date.valueOf(rs.getString("dateregistered").substring(0, 10));
				} catch (Exception ex) {
				}

				// vend.setContactpersonname(rs.getString("contactperson"));
				contactpersonname = (rs.getString("contactperson"));

				// vend.setAddress(rs.getString("address"));
				address = (rs.getString("address"));

				// vend.setCity(rs.getString("city"));
				city = (rs.getString("city"));

				// vend.setState(rs.getString("state"));
				state = (rs.getString("state"));

				// vend.setZipcode(rs.getString("zip"));

				zipcode = (rs.getString("zip"));

				// vend.setCountry(rs.getString("country"));

				country = (rs.getString("country"));

				// vend.setPhone(rs.getString("phone"));

				phone = (rs.getString("phone"));

				// vend.setCellular(rs.getString("cellphone"));

				cellular = (rs.getString("cellphone"));

				// vend.setEmail(rs.getString("email"));

				email = (rs.getString("email"));

				// vend.setProductname(rs.getString("productname"));

				productname = (rs.getString("productname"));

				// vend.setAvgmonthlyproduction(new
				// Integer(rs.getString("avgmonthlyproduction")));
				
				

				try {
					Avgmonthlyproduction = (new Integer(rs.getString("avgmonthlyproduction")));
				} catch (Exception ex) {
				}

				// vend.setNoofsales1(new Integer(rs.getString("noofsales1")));
				try {
					noofsales1 = (new Integer(rs.getString("noofsales1")));
				} catch (Exception ex) {
				}

				// vend.setNoofsales2(new Integer(rs.getString("noofsales2")));
				try {
					noofsales2 = (new Integer(rs.getString("noofsales2")));
				} catch (Exception ex) {
				}

				// vend.setNoofsales3(new Integer(rs.getString("noofsales3")));
				try {
					noofsales3 = (new Integer(rs.getString("noofsales3")));
				} catch (Exception ex) {
				}
				// vend.setProfit1(new
				// Double(rs.getString("profitbeforeinterest1")));

				// vend.setProfit2(new
				// Double(rs.getString("profitbeforeinterest2")));
				try {
					profit1 = (new Double(rs.getString("profitbeforeinterest1")));
				} catch (Exception ex) {
				}
				try {
					profit2 = (new Double(rs.getString("profitbeforeinterest2")));
				} catch (Exception ex) {
				}
				try {
					profit3 = (new Double(rs.getString("profitbeforeinterest3")));
				} catch (Exception ex) {
				}

				// vend.setProfit3(new
				// Double(rs.getString("profitbeforeinterest3")));

				// vend.setOtherincome1(new
				// Double(rs.getString("otherincome1")));
				try {
					otherincome1 = (new Double(rs.getString("otherincome1")));
				} catch (Exception ex) {
				}
				try {
					otherincome2 = (new Double(rs.getString("otherincome2")));
				} catch (Exception ex) {
				}
				try {
					otherincome3 = (new Double(rs.getString("otherincome3")));
				} catch (Exception ex) {
				}

				// vend.setOtherincome2(new
				// Double(rs.getString("otherincome2")));

				// vend.setOtherincome3(new
				// Double(rs.getString("otherincome3")));

			}

			System.out.print(vend.getCompanyname());

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

		return vend;
	}

	public String DBRetrieveLoginInfo(String userid, String pass) {

		String vendorID = "";

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			SQL = "SELECT username, password, VendorID FROM vendorlogin WHERE username = '" + userid
					+ "' AND password = '" + pass + "' ORDER BY username";
			ResultSet rs = stmt.executeQuery(SQL);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name

				vendorID = rs.getString("VendorID");
			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

		// test email
		if (vendorID != "") {
			EmailHelper emailHelper = new EmailHelper();
			emailHelper.SendEmail("shyammayank9@gmail.com", "Login Alert", "You logged in as " + userid + " to Vendor Site successfully on " + Instant.now());
		}
		return vendorID;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCompanytype() {
		return companytype;
	}

	public void setCompanytype(String companytype) {
		this.companytype = companytype;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getCompanywebsite() {
		return companywebsite;
	}

	public void setCompanywebsite(String companywebsite) {
		this.companywebsite = companywebsite;
	}

	public Date getDateRegistered() {
		return dateregistered;
	}

	public void setDateRegistered(Date dateregistered) {
		this.dateregistered = dateregistered;
	}

	public String getContactpersonname() {
		return contactpersonname;
	}

	public void setContactpersonname(String contactpersonname) {
		this.contactpersonname = contactpersonname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCellular() {
		return cellular;
	}

	public void setCellular(String cellular) {
		this.cellular = cellular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getNoofsales1() {
		return noofsales1;
	}

	public void setNoofsales1(int noofsales1) {
		this.noofsales1 = noofsales1;
	}

	public int getNoofsales2() {
		return noofsales2;
	}

	public void setNoofsales2(int noofsales2) {
		this.noofsales2 = noofsales2;
	}

	public int getNoofsales3() {
		return noofsales3;
	}

	public void setNoofsales3(int noofsales3) {
		this.noofsales3 = noofsales3;
	}

	public double getProfit1() {
		return profit1;
	}

	public void setProfit1(double profit1) {
		this.profit1 = profit1;
	}

	public double getProfit2() {
		return profit2;
	}

	public void setProfit2(double profit2) {
		this.profit2 = profit2;
	}

	public double getProfit3() {
		return profit3;
	}

	public void setProfit3(double profit3) {
		this.profit3 = profit3;
	}

	public double getOtherincome1() {
		return otherincome1;
	}

	public void setOtherincome1(double otherincome1) {
		this.otherincome1 = otherincome1;
	}

	public double getOtherincome2() {
		return otherincome2;
	}

	public void setOtherincome2(double otherincome2) {
		this.otherincome2 = otherincome2;
	}

	public double getOtherincome3() {
		return otherincome3;
	}

	public void setOtherincome3(double otherincome3) {
		this.otherincome3 = otherincome3;
	}

	public int getAvgmonthlyproduction() {
		return Avgmonthlyproduction;
	}

	public void setAvgmonthlyproduction(int getAvgmonthlyproduction) {
		this.Avgmonthlyproduction = getAvgmonthlyproduction;
	}

	public String getRegistrationno() {
		return registrationno;
	}

	public void setRegistrationno(String registrationno) {
		this.registrationno = registrationno;
	}

	public String getUserName() {
		return username;
	}
}