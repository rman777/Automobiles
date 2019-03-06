package com.automobiles.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.automobiles.constant.Constant;
import com.automobiles.customexception.CustomException;
import com.automobiles.model.ExcelData;
import com.automobiles.model.Role;
import com.automobiles.model.User;
import com.automobiles.repository.ExcelJpaRepository;
import com.automobiles.repository.RoleJpaRepository;
import com.automobiles.repository.UserJpaRepository;

@CrossOrigin("*")
@RestController
public class UserController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserJpaRepository userJpaRepository;
	
	@Autowired
	RoleJpaRepository roleJpaRepository;
	
	@Autowired
	ExcelJpaRepository excelJpaRepository;
	
	// Save Register User Data
	@PostMapping("/register")
	public ResponseEntity<Object> saveUserData(@RequestBody User user) {
		if(userJpaRepository.findByUsermobile(user.getUsermobile()).isPresent()) {
			 return new ResponseEntity<Object>(new CustomException(Constant.FAIL,Constant.USER_ALREADY_EXIST), HttpStatus.OK);
		}else {
			 user.setUserpassword(passwordEncoder.encode(user.getUserpassword()));
			 user.setUsercreated(Constant.DATETIME);
			 user.setUserlastlogin(Constant.DATETIME);
			 userJpaRepository.save(user);
			 return new ResponseEntity<Object>(new CustomException(Constant.SUCCESS,Constant.USER_REGISTER_SUCCESS), HttpStatus.OK);
		}
	}
	
	// Get All User List Data
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUserData() {
		List<User> users = userJpaRepository.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.OK);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	
	// Get Single User Data by Id
	@GetMapping("/getUser/{userid}")
	public ResponseEntity<?> getUserData(@PathVariable int userid) {
		Optional<User> user = userJpaRepository.findById(userid);
        if (user.isPresent()) {
        	User result = user.get();
        	  return new ResponseEntity<User>(result,HttpStatus.OK);  
        }
        return new ResponseEntity<Object>(new CustomException(Constant.FAIL,"User with id " + userid 
                + " not found"), HttpStatus.OK);
	}
	
	// Delete User Data by Id
	@DeleteMapping("/deleteUser/{userid}")
	public ResponseEntity<?> deleteUser(@PathVariable int userid) {
		Optional<User> user = userJpaRepository.findById(userid);
		 if (user.isPresent()) {
	        	userJpaRepository.deleteById(userid);
	        	  return new ResponseEntity<User>(HttpStatus.OK);  
	        }
	        return new ResponseEntity<Object>(new CustomException(Constant.FAIL,"User with id " + userid 
	                + " not found"), HttpStatus.OK);
	}
	
	// Check User Login
	@PostMapping("/chkLogin")
	public ResponseEntity<?> chkLogin(@RequestBody User user) {
		String usermobile = user.getUsermobile();
		String userpassword = user.getUserpassword();
		Optional<User> finduser = userJpaRepository.findByUsermobile(usermobile);
		if(finduser.isPresent()) {
			User check = finduser.get();
			if(passwordEncoder.matches(userpassword, check.getUserpassword())) {
				check.setUserlastlogin(Constant.DATETIME);
				  userJpaRepository.save(check); // This is for Update Last Login Column from User Table.
				 return new ResponseEntity<Object>(new CustomException(Constant.SUCCESS,Constant.USER_LOGIN_SUCCESS), HttpStatus.OK); 
			}else {
				return new ResponseEntity<Object>(new CustomException(Constant.FAIL,Constant.USER_LOGIN_FAIL), HttpStatus.OK);
			}	   
		}else {
			 return new ResponseEntity<Object>(new CustomException(Constant.FAIL,Constant.USER_LOGIN_FAIL), HttpStatus.OK);  
		}
	}
	
	// Change Password
	@PutMapping("/changePassword")
	public ResponseEntity<?> changeUserPassword(@RequestBody User user) {

		Optional<User> optionalUser = userJpaRepository.findById(user.getUserid());
		if(optionalUser.isPresent()) {
			User result = optionalUser.get();
			result.setUserpassword(passwordEncoder.encode(user.getUserpassword()));
			userJpaRepository.save(result);
			return new ResponseEntity<Object>(new CustomException(Constant.SUCCESS,Constant.PASSWORD_CHANGE_SUCCESS), HttpStatus.OK); 
			
		}else {
			return new ResponseEntity<Object>(new CustomException(Constant.FAIL,Constant.PASSWORD_CHANGE_FAIL), HttpStatus.OK); 
		}
		
	}
	
	
	// Upload Excel File
	@RequestMapping(value="/import",method=RequestMethod.POST)
	public ResponseEntity<?> mapReapExcelDatatoDB(@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {
	    XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);
	    for(int i=0;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	    	ExcelData exceldata = new ExcelData();
	        XSSFRow row = worksheet.getRow(i);
	        if(row.getCell(0) != null && row.getCell(1) != null) {
	        	exceldata.setPartname((row.getCell(0).getStringCellValue().isEmpty())?"-":row.getCell(0).getStringCellValue());
	        	exceldata.setPartqty((int) row.getCell(1).getNumericCellValue());
	        	 excelJpaRepository.save(exceldata); 
	        }
	         
	    }
	    return new ResponseEntity<Object>(new CustomException(Constant.SUCCESS,Constant.EXCEL_READ_DATA_SUCCESS), HttpStatus.OK);
	}
	
	
	// Get All User Role List Data
	@GetMapping("/getAllRole")
	public ResponseEntity<List<Role>> getAllRole() {
		List<Role> role = roleJpaRepository.findAll();
        if (role.isEmpty()) {
            return new ResponseEntity<List<Role>>(HttpStatus.OK);
        }
        return new ResponseEntity<List<Role>>(role, HttpStatus.OK);
	}
	
	
	
}
