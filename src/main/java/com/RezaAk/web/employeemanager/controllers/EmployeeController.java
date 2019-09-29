package com.RezaAk.web.employeemanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.RezaAk. web.employeemanager.models.Employee;
import com.RezaAk. web.employeemanager.services.EmployeeService;

@Controller
public class EmployeeController {
	private final EmployeeService employeeService;
	
	public EmployeeController (EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@RequestMapping("/")
    public String index(Model model) {
		model.addAttribute("employees", employeeService.allEmployees());
        return "index.jsp";
    }
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String createEmployee(@RequestParam("firstname") String first, @RequestParam("lastname") String last) {
		Employee e = new Employee();
		e.setFirst_name(first);
		e.setLast_name(last);
		employeeService.createEmployee(e);
		return "redirect:/";
	}
	
	@RequestMapping("/{managerid}/{employeeid}")
	public String setManager(@PathVariable("managerid") Long managerid, @PathVariable("employeeid") Long employeeid) {
		Employee e1 = employeeService.findEmployee(managerid);
		Employee e2 = employeeService.findEmployee(employeeid);
		e2.setManager(e1);
		employeeService.createEmployee(e2);
		return "redirect:/";
	}
	
	@RequestMapping("/manager/{id}")
    public String manager(@PathVariable("id") Long id, Model model) {
		Employee manager = employeeService.findEmployee(id);
		model.addAttribute("m", manager);
		model.addAttribute("employees", manager.getEmployees());
        return "manager.jsp";
    }
}
