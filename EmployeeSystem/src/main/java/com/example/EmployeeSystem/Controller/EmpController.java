package com.example.EmployeeSystem.Controller;

import com.example.EmployeeSystem.Entity.Employee;
import com.example.EmployeeSystem.Service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmpController {
    @Autowired
    private EmpService service;
    @GetMapping("/")
    public String home(){
        return "index";
    }
   /* @GetMapping("/loginpage")
    public String login(){

        return "employee";
    }*/
    @GetMapping("/loginpage")
    public String employee(Model m){
        List<Employee> emp=service.getEmp();
        m.addAttribute("emp",emp);
        return "employee";
    }
    @GetMapping("/AddEmp")
    public String AddEmployee(){

        return "addEmp";
    }
    @PostMapping("/register")
    public String AddEmployee(@ModelAttribute Employee e, HttpSession session){

        service.addEmp(e);
        System.out.println(e);
        session.setAttribute("msg","Employee Added Successfully");
        return "redirect:/";
    }
     @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model m){
       Employee e=service.getById(id);
       m.addAttribute("emp",e);
        return "edit";
     }
     @PostMapping("/update")
     public String updateEmp(@ModelAttribute Employee e){
        service.addEmp(e);
        return "redirect:loginpage";
     }
     @GetMapping("/delete/{id}")
     public String delete(@PathVariable int id){
        service.delete(id);
         return "redirect:loginpage";
     }
}
