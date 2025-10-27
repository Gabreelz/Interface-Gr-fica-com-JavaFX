package com.Services;

import java.util.ArrayList;
import java.util.List;

import com.Entities.Department;

public class DepartmentService {
    
    public List<Department> findAll() {
        // Lógica para buscar todos os departamentos (exemplo fictício)
        List<Department> list = new ArrayList<>();
        list.add(new Department(1, "Sales"));
        list.add(new Department(2, "Marketing"));
        list.add(new Department(3, "IT"));
        return list;
    }
}
