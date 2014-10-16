package com.samsung.datagrid;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samsung.datagrid.bean.User;
import com.samsung.datagrid.bean.UserDB;
import com.samsung.util.XmlUtils;

/**
 * Servlet implementation class DataGridRetrieveServlet
 */
@WebServlet("/DataGridRetrieveServlet")
public class DataGridRetrieveServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    private static final String ADD_USER = "addUser";
    
    private static final String DELETE_USER = "deleteUser";
    
    private static final String UPDATE_USER = "updateUser";
    
    private static final String RETRIEVE_USER_LIST = "retrieveUser";
    
    private PrintWriter writer;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataGridRetrieveServlet()
    {
        super();
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
        this.writer = response.getWriter();
        String oprator = request.getParameter("oprator");
        
        switch (oprator)
        {
            case ADD_USER:
                addUser(request);
                break;
            case UPDATE_USER:
                updateUser(request);
                break;
            case DELETE_USER:
                deleteUser(request);
                break;
            case RETRIEVE_USER_LIST:
                retrieveUserList();
                break;
            default:
                break;
        }
        
    }
    
    private void retrieveUserList()
    {
        output(XmlUtils.object2Xml(UserDB.getUserCollection()));
    }
    
    private void deleteUser(HttpServletRequest request)
    {
        User user = fillUserFromRequest(request);
        if (findUser(user))
        {
            UserDB.getUserCollection().remove(user);
        }
        output(XmlUtils.object2Xml(""));
    }
    
    private void updateUser(HttpServletRequest request)
    {
        User user = fillUserFromRequest(request);
        if (findUser(user))
        {
            UserDB.getUserCollection().remove(user);
            UserDB.getUserCollection().add(user);
        }
        output(XmlUtils.object2Xml(""));
    }
    
    private boolean findUser(User currentUser)
    {
        for (User user : UserDB.getUserCollection())
        {
            if (currentUser.getUserId().equals(user.getUserId()))
            {
                return true;
            }
        }
        return false;
    }
    
    private void addUser(HttpServletRequest request)
    {
        User user = fillUserFromRequest(request);
        UserDB.getUserCollection().add(user);
        output(XmlUtils.object2Xml(""));
    }
    
    private User fillUserFromRequest(HttpServletRequest request)
    {
        User user = new User();
        user.setUserId(request.getParameter("userId"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        user.setPassword(request.getParameter("password"));
        user.setSex(request.getParameter("sex"));
        return user;
    }
    
    private void output(String xml)
    {
        writer.print(xml);
    }
}
