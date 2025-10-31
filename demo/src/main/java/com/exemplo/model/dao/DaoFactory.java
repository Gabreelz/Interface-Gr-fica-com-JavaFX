package com.exemplo.model.dao;

import com.exemplo.db.DB;
import com.exemplo.model.imple.DepartmentDaoJDBC;
import com.exemplo.model.imple.SellerDaoJDBC;

public class DaoFactory {
    public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}
}
