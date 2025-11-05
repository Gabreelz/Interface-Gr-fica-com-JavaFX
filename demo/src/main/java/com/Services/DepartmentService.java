package com.Services;

import java.util.List;

import com.Entities.Department;
import com.exemplo.model.dao.DaoFactory;
import com.exemplo.model.dao.DepartmentDao;

public class DepartmentService {

    private DepartmentDao dao = DaoFactory.createDepartmentDao();
    
    public List<Department> findAll() {
        return dao.findAll();
    }

    public void safeOrUpdate(Department obj){
        if(obj.getId() == null){
            dao.insert(obj);
        }
        else {
            dao.update(obj);
        }
    }
}
