package vn.plusplus.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import vn.plusplus.springboot.controller.request.RegisterReq;
import vn.plusplus.springboot.controller.request.TransferReq;
import vn.plusplus.springboot.interfaces.UserServiceImpl;
import vn.plusplus.springboot.repository.AccountJPArepo;
import vn.plusplus.springboot.repository.AccountJpa;

import java.util.Objects;

@RestController
@RequestMapping(value = "/jpa")
public class JpaController {

    @Autowired
    AccountJPArepo accountJPArepo;
    @Autowired
    UserServiceImpl userService;

    @GetMapping(value = "/account")
    public AccountJpa getAccountByPhone(@RequestParam(name = "phone") String phone){
        AccountJpa data = accountJPArepo.findByActivePhone(phone);
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

    @DeleteMapping(value = "/account/{phone}")
    public String deletedByPhone(@PathVariable String phone){
        AccountJpa data = accountJPArepo.findByPhoneJpa(phone);
        if(Objects.nonNull(data)){
            accountJPArepo.delete(data);
        }
        return "Success";
    }

    @PostMapping(value = "account/transfer")
    public String transferMoney(@RequestBody TransferReq req){
        userService.transferMoney(req.getFromPhone(), req.getToPhone(), req.getMoney());
        return "SUCCESS";
    }

    @GetMapping(value = "/account/search")
    public Page findAll(@RequestParam(name = "page") Integer pageNum,
                        @RequestParam(name = "size") Integer pageSize,
                        @RequestParam(name = "sortBy") String sortBy,
                        @RequestParam(name = "orderBy") String orderBy){
        Sort sort = Sort.by(Sort.Direction.ASC, sortBy);
        if(orderBy.equals("DESC")) {
            sort = Sort.by(Sort.Direction.DESC, sortBy);
        }
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize, sort);
        return accountJPArepo.findAll(pageRequest);
    }

}
