<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="com.vendor.VendorInformation" %>
    <%@ page import ="com.vendor.DBVendorConnection" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><H1>Vendor Registration</H1></title>
<link rel="stylesheet" type="text/css" href="./styles/style1.css">
<% VendorInformation register1 = (VendorInformation) session.getAttribute("register");%>
</head>
<body>

<% 
String UserName = register1.getUsername();
String Password = register1.getPassword();
String registerno = register1.getRegistrationno();
String companyname = register1.getCompanyname();
String companytype = register1.getCompanytype();
String industry = register1.getIndustry();
String website = register1.getCompanywebsite();
Date dateregistered = register1.getDateRegistered();

String contactperson = register1.getContactpersonname();
String address = register1.getAddress();
String city = register1.getCity();
String state = register1.getState();
String zipcode = register1.getZipcode();
String country = register1.getCountry();
String phone = register1.getPhone();
String cellular = register1.getCellular();
String email = register1.getEmail();

String productname = register1.getProductname();
int avgmonthlyproduction = register1.getAvgmonthlyproduction();

int NoOfSales1 = register1.getNoofsales1();
int NoOfSales2 = register1.getNoofsales2();
int NoOfSales3 = register1.getNoofsales3();

double profit1 = register1.getProfit1();
double profit2 = register1.getProfit2();
double profit3 = register1.getProfit3();

double OtherIncome1 = register1.getOtherincome1();
double OtherIncome2 = register1.getOtherincome2();
double OtherIncome3 = register1.getOtherincome3();
 



address.trim();

DBVendorConnection dbvendor = new DBVendorConnection();

dbvendor.DBInsertVendorRegistration(registerno, companyname, companytype, industry, website, dateregistered,email);

dbvendor.DBInsertContact(contactperson, registerno, address, city, state, zipcode, country, phone, cellular, email);

dbvendor.DBInsertProduct(productname, registerno, avgmonthlyproduction,email);

dbvendor.DBInsertSales(registerno, NoOfSales1, NoOfSales2, NoOfSales3, profit1, profit2, profit3, OtherIncome1, OtherIncome2, OtherIncome3,email);

dbvendor.DBInsertLoginInfo(UserName, Password, registerno,email);

dbvendor.SendAlert(email, "Welcome to Marco Health!", "Welcome to Marco Health! Your registration information has been saved.");

System.out.print("All Records Inserted");

response.sendRedirect("index.jsp");
%>

</body>
<a href="index.jsp" class="backtohome"><i class="fa fa-home" aria-hidden="true"></i> Back To Home Page</a>
</html>

