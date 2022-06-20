package com.Echidnar.Mishop.servlet;

import com.Echidnar.Mishop.entity.Category;
import com.Echidnar.Mishop.service.CateService;
import com.Echidnar.Mishop.utils.DateTool;
import com.Echidnar.Mishop.utils.PageTool;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.List;


@WebServlet("/cate")
public class CateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private CateService cateService = new CateService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String func = request.getParameter("func");
        switch (func){
            case "findAllcate":
                findAllCate(request,response);
                break;
            case "insertCate":
                insertCate(request,response);
                break;
            default:
                break;
        }
    }

    //添加类别
    private void insertCate(HttpServletRequest request, HttpServletResponse response) {
        //获取分类信息
        String cname = request.getParameter( "cname" );
        String state = request.getParameter( "state" );
        String order_number = request.getParameter( "order_number");
        String description = request.getParameter( "description");
        String create_time = request.getParameter( "create_time");
        //构建分类对象
        Category category = new Category(cname,Integer.valueOf(state),Integer.valueOf(order_number),description, (Data) DateTool.stringToDate(create_time));
        //调用service方法，将分类对象传递到dao中
        boolean isSuccess = cateService.insertCate(category);
        if (isSuccess){
            //添加成功，跳转到分类页面，重新展示数据
            response.sendRedirect("cate?func=findAllCate");
        }
    }

    //分页查找所有分类信息的方法
    private void findAllCate(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //构建分页工具类
        String currentPage = request.getParameter( "currentPage");//从页面中获取当前页码
        int totalCount = cateService.selectCateCount();
        PageTool pageTool = new PageTool(currentPage, totalCount);
        //调用service方法，传递工具类，来得到分页数据
        List<Category> cates = cateService.findAllCate(PageTool);
        //将cates与pageTool存放在reques域对象中，转发到分类的展示页面，进行数据展示
        request.setAttribute( "cates",cates);
        request.setAttribute( "pageTool",pageTool);
        request.getRequestDispatcher("admin/category_list.jsp").forward(request,response);

    }
}
