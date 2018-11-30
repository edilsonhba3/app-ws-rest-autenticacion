package com.ws.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ws.rest.model.dto.ObjectResponse;
import com.ws.rest.model.entities.User;
import com.ws.rest.model.service.UserService;
import com.ws.rest.util.PropertiesUtil;

@RestController
public class AutenticationController
{
    @Autowired
    private UserService userService;
    
    @PostMapping("/autentication")
    public ResponseEntity<Object> createNewUser(@RequestParam String email, @RequestParam String pass) 
    {
    	ResponseEntity<Object> responseEntity = null;
        ObjectResponse response = new ObjectResponse();
                
        try 
        {
        	User userFounded = userService.findByEmailAndPassword(email, pass);
            if (userFounded != null) 
            {
            	response.setCode(PropertiesUtil.CODE_SUCCESS);
            	response.setStatus(PropertiesUtil.SUCCESS);
            	response.setResponse(userFounded);
                responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
            }
            else
           {
            	response.setCode(PropertiesUtil.CODE_NOT_FOUND);
            	response.setStatus(PropertiesUtil.ERROR);
            	response.setResponse(PropertiesUtil.NOT_FOUND);
                responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
           }
           
		} 
        catch (Exception e) 
        {
        	response.setCode(PropertiesUtil.CODE_ERROR);
        	response.setStatus(PropertiesUtil.ERROR);
        	response.setResponse(e.getMessage());
        	responseEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}        
        return responseEntity;
    }

}
