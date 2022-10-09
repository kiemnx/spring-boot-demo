package vn.plusplus.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.plusplus.springboot.controller.request.RegisterReq;
import vn.plusplus.springboot.repository.AccountJPArepo;
import vn.plusplus.springboot.repository.AccountJpa;

import java.util.Objects;

@RestController
@RequestMapping(value = "/jpa")
public class JpaController {

    @Autowired
    AccountJPArepo accountJPArepo;

    @GetMapping(value = "/account")
    public AccountJpa getAccountByPhone(@RequestParam(name = "phone") String phone){
        AccountJpa data = accountJPArepo.findByPhoneJpa(phone);
        return data;
    }

    @PostMapping(value = "/account")
    public AccountJpa saveAccount(@RequestBody RegisterReq req){
        AccountJpa accountJpa = new AccountJpa();
        accountJpa.setEmailJpa(req.getEmail());
        accountJpa.setPhoneJpa(req.getPhone());
        accountJpa.setPassword(req.getPassword());
        accountJpa = accountJPArepo.save(accountJpa);
        return accountJpa;
    }

    @PutMapping(value = "/account")
    public AccountJpa updateAccount(@RequestBody RegisterReq req){
        AccountJpa data = accountJPArepo.findByPhoneJpa(req.getPhone());
        if(Objects.isNull(data)){
            System.out.println("Khong tim thay account tuong ung SDT: " + req.getPhone());
            return null;
        }
        data.setEmailJpa(req.getEmail());
        data = accountJPArepo.save(data);
        return data;
    }

}
