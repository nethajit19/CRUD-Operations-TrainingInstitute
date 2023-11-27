package com.example.TrainingInstitute.Controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.TrainingInstitute.Model.Employee;
import com.example.TrainingInstitute.Service.EmployeeService;

@Controller 
public class EmployeeController {
	
	@Autowired
	private EmployeeService empserv;
	
	@GetMapping("/")
	public String homePage()
	{
		return "index";
	}
	
	@GetMapping("/Employee/view")
	public String viewPage(Model model)
	{
		model.addAttribute("allEmployee", empserv.showAllDetails());
		return "/emp/view";
	}
	
	
	@GetMapping("/Employee/add")
	public String addPage(Model model)
	{
		model.addAttribute("empobj", new Employee());
		return "/emp/add";
	}
	
	String UPLOAD_DIRECTORY = "src/main/resources/static/images/";
	
	@PostMapping("/Employee/add")
	public String addEmployee(@ModelAttribute("empobj") Employee emp,@RequestParam("images") MultipartFile file)  throws IOException
	{
		emp.setImg(file.getOriginalFilename());
		Employee newEmp=empserv.addNewEmployee(emp);
		
		String dir_path= UPLOAD_DIRECTORY+newEmp.getEmpid()+"/";
		
		Path fileNameAndPath=Paths.get(dir_path,file.getOriginalFilename());
		
		if(!Files.exists(fileNameAndPath))
		{
			new File(dir_path).mkdir();
			Files.write(fileNameAndPath, file.getBytes());
			
		}
		
		return "redirect:/Employee/view";
		}
	
	
	@GetMapping("/Employee/edit/{id}")
	public String editpage(@PathVariable("id") long id,Model model)
	{
		model.addAttribute("empobj",empserv.searchemp(id));
		return "/emp/edit";
	}
	
	@PostMapping("/Employee/edit")
	public String editEmployee(@ModelAttribute("empobj") Employee emp,@RequestParam("images") MultipartFile file) throws IOException
	{
		emp.setImg(file.getOriginalFilename());
		Employee newEmp=empserv.addNewEmployee(emp);
		
		String dir_path=UPLOAD_DIRECTORY+newEmp.getEmpid()+"/";
		
		
	Path fileNameAndPath=Paths.get(dir_path);
	
	try (InputStream inputstream =file.getInputStream())
	{
		Path path=fileNameAndPath.resolve(file.getOriginalFilename());
		Files.copy(inputstream, path, StandardCopyOption.REPLACE_EXISTING);
	}
	
	catch (IOException ioe) 
	{
		throw new IOException("There is some error during img upload :" +ioe);
		
	}
	
		return "redirect:/Employee/view";
	}
	
	@GetMapping("/Employee/delete/{id}")
	public String deletePage(@PathVariable("id") Long emid)
	{
		empserv.deletePage(emid);
		return "redirect:/Employee/view";
	}
	
	
	

		
}



	
	
	
	
	
	
	
	
		
	
	
	
	
	


