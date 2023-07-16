package com.example.EmployeeSystem.Service;

import com.example.EmployeeSystem.Entity.Employee;
import com.example.EmployeeSystem.Repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    private EmpRepo repo;
     public void addEmp(Employee e){
         repo.save(e);
     }

     public List<Employee> getEmp(){
         return repo.findAll();
     }

     public Employee getById(int id){

         Optional<Employee> em=repo.findById(id);
         if(em.isPresent()){
             return em.get();
         }
         return null;
     }
     public void delete(int id){
         repo.deleteById(id);
     }
}
