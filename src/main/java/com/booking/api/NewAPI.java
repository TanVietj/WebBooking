package com.booking.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.dto.NewDTO;

 
		
@RestController

public class NewAPI {

       @PostMapping("/test")

       public String testAPI(NewDTO dto) {

             return "success"	;

   }

}