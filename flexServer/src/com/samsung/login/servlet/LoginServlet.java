package com.samsung.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samsung.login.bean.Admin;
import com.samsung.util.XmlUtils;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    /**
     * Default constructor.
     */
    public LoginServlet()
    {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        this.doPost(request, response);
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        
        PrintWriter writer = response.getWriter();
        if ("lyndan".equals(userId) && "123".equals(password))
        {
           Admin user = new Admin();
           user.setPassword("123");
           user.setUserId("lyndan");
            writer.print(XmlUtils.object2Xml(user)); 
        }
        else
        {
            writer.print(XmlUtils.object2Xml(new Admin()));
            
        }
        
        // System.out.println(object);
        // User user = new User();
        // user.setId(1);
        // user.setFirstName("lee");
        // user.setLastName("haha");
        // user.setEmail("li.linhan@163.com");
        // response.getWriter().print(XmlUtils.object2Xml(user));
    }
    
}
