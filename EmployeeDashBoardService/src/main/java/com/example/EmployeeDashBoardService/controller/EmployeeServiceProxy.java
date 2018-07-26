package com.example.EmployeeDashBoardService.controller;

import java.util.Collection;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.EmployeeDashBoardService.domain.model.EmployeeInfo;

@FeignClient(name = "EmployeeSearchService")
@RibbonClient(name = "EmployeeSearchService")
public interface EmployeeServiceProxy {
	
 @RequestMapping("/employee/find/{id}")
 public EmployeeInfo findById(@PathVariable(value = "id") Long id);
 
 @RequestMapping("/employee/findall")
 public Collection < EmployeeInfo > findAll();
 
}