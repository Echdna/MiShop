package com.Echidnar.Mishop.dao;

import com.Echidnar.Mishop.entity.Category;
import com.Echidnar.Mishop.utils.PageTool;

import java.sql.SQLException;
import java.util.List;

public class CateDao {
    private QueryRunner qRunner = new QueryRunner(Druidutils.getDataSource());

    public int selectCateCount() {
        int count = 0;
        try {
            long c = (Long) qRunner.query("select count(*) from category", new ScalarHandler());
            count = (int)c;
        } catch (SQLException e) {
            //TOD0 Auto-generated catch block
            e.printStackTrace();
        }
        return count;
    }

    public List<Category> findAllCate(PageTool pageTool) {
        List<Category> cates = null;
        try{
            cates = qRunner.query( "select * from category limit ?,?" , new BeanListHandler<Category>(Category.class),
                    pageTool.getStartIndex(),pageTool.getPageCount());
        }catch (SQLException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cates;
    }


    public int insertCate(Category category) {
        int row = 0;
        try{
            row = qRunner.update("insert into category values (null,?,?,?,?,?)",
                    category.getCname(), category.getState(), category.getOrder_number(),category.getDescription(),category.getCreate_time());
    }catch (SQLException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
    return row;
    }
}

