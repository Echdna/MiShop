package com.Echidnar.Mishop.service;

import com.Echidnar.Mishop.dao.CateDao;
import com.Echidnar.Mishop.entity.Category;
import com.Echidnar.Mishop.utils.PageTool;

import java.util.List;

public class CateService {

    private CateDao cateDao = new CateDao();

    public int selectCateCount() {
        return cateDao.selectCateCount();
    }

    public List<Category> findAllCate(PageTool pageTool){
        return cateDao.findAllCate(pageTool);
    }

    public boolean insertCate(Category category) {
        int row = cateDao.insertCate(category);
        if (row > 0) {
            return true;
        }
        return false;
    }

}
