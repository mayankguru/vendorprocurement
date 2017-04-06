package com.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vendor.VendorInformation;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		VendorInformation vendor = new VendorInformation();

		vendor.setUsername(request.getParameter("username"));
		vendor.setPassword(request.getParameter("password"));
		vendor.setRegistrationno(request.getParameter("registrationno"));
		vendor.setCompanyname(request.getParameter("companyname"));
		vendor.setCompanytype(request.getParameter("companytype"));
		vendor.setIndustry(request.getParameter("industry"));
		vendor.setContactpersonname(request.getParameter("contactpersonname"));
		if (request.getParameter("dateregistered") != null && request.getParameter("dateregistered") != "") {
			vendor.setDateregistered(Date.valueOf(request.getParameter("dateregistered")));
		}
		vendor.setCompanywebsite(request.getParameter("companywebsite"));

		vendor.setAddress(request.getParameter("address"));
		vendor.setCity(request.getParameter("city"));
		vendor.setState(request.getParameter("state"));
		vendor.setZipcode(request.getParameter("zipcode"));
		vendor.setCountry(request.getParameter("country"));
		vendor.setPhone(request.getParameter("phone"));
		vendor.setCellular(request.getParameter("cellular"));
		vendor.setEmail(request.getParameter("email"));

		vendor.setProductname(request.getParameter("productname"));

		try {
			vendor.setAvgmonthlyproduction(new Integer(request.getParameter("avgmonthlyproduction")));
		} catch (Exception ex) {
		}

		try {
			vendor.setNoofsales1(new Integer(request.getParameter("noofsales1")));
		} catch (Exception ex) {
		}
		try {
			vendor.setNoofsales2(new Integer(request.getParameter("noofsales2")));
		} catch (Exception ex) {
		}
		try {
			vendor.setNoofsales3(new Integer(request.getParameter("noofsales3")));
		} catch (Exception ex) {
		}

		try {
			vendor.setProfit1(new Double(request.getParameter("profit1")));
		} catch (Exception ex) {
		}
		try {
			vendor.setProfit2(new Double(request.getParameter("profit2")));
		} catch (Exception ex) {
		}
		try {
			vendor.setProfit3(new Double(request.getParameter("profit3")));
		} catch (Exception ex) {
		}

		try {
			vendor.setOtherincome1(new Double(request.getParameter("otherincome1")));
		} catch (Exception ex) {
		}
		try {
			vendor.setOtherincome2(new Double(request.getParameter("otherincome2")));
		} catch (Exception ex) {
		}
		try {
			vendor.setOtherincome3(new Double(request.getParameter("otherincome3")));
		} catch (Exception ex) {
		}

		HttpSession session = request.getSession(true);
		session.setAttribute("register", vendor);

		RequestDispatcher rs = request.getRequestDispatcher("openRegistration.jsp");
		rs.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
