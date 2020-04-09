package com.example.springreact.web;

import com.example.springreact.domain.Mobile;
import com.example.springreact.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/board")
@CrossOrigin
public class MobileController {

    @Autowired
    private MobileService mobileService;

    @PostMapping("/")
    public ResponseEntity<?> addMobile (@Valid @RequestBody Mobile mobile, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap();
            for (FieldError error : bindingResult.getFieldErrors())
                errorMap.put(error.getField(), error.getDefaultMessage());
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Mobile newMobile = mobileService.saveOrUpdateMobile(mobile);
        return new ResponseEntity<Mobile>(newMobile, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Mobile> getMobileList () {
        return mobileService.getAll();
    }

    @GetMapping("/{id}")
    public Mobile getMobile (@PathVariable Long id) {
        return mobileService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Iterable<Mobile> deleteMobile (@PathVariable Long id) {
        mobileService.deleteById(id);
        return mobileService.getAll();
    }
}
