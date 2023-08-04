/**
 * #=== Created by Dazzler7Soft.Eng.Udg ===#
 * Date : 02-Aug-2023
 * Time : 12:25 PM
 * Project Name : Spring-Security-Legacy
 */
package lk.dazzler.devo.java.spring.security.legacy.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/")
public class CommonController {

    @GetMapping
    public String getRequest(){
        return "Get request called - Spring Security Legacy";
    }

    @GetMapping("/admin")
    public String getAdminRequest(){
        return "Welcome Administrator - Spring Security Legacy";
    }

    @GetMapping("/customer")
    public String getCustomerRequest(){
        return "Welcome Customer - Spring Security Legacy";
    }
}
