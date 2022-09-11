package vn.plusplus.springboot.controller;

import org.springframework.web.bind.annotation.*;
import vn.plusplus.springboot.controller.request.RegisterReq;
import vn.plusplus.springboot.controller.request.UpdateReq;

@RestController
@RequestMapping(value = "/api")
public class HomeController {

    @RequestMapping(value = "/request-mapping/{name}", method = RequestMethod.GET)
    public Object getExampleMethod(@PathVariable(value = "name") String name){
        String response = "Xin chao: " + name;
        return response;
    }

    @GetMapping(value = "/get-mapping")
    public Object getExampleMethod2(){
        return "Any object 2";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Object register(@RequestBody RegisterReq req){
        System.out.println(req.getUsername());
        System.out.println(req.getEmail());
        //Tim kiem trong DB xem da ton tai username
        //Neu chua thi insert 1 ban ghi user voi thong tin da dang ky
        //Neu co roi thi bao lai co loi: Username da dang ky

        return "Dang ky thanh cong";
    }

    @PostMapping(value = "/login")
    public String login(@RequestBody RegisterReq req){
        /* Kiem tra username co ton tai hay khong,
        Neu ton tai thi kiem tra password, neu khong ton tai thi bao loi chua dang ky
        Neu password dung thi bao thanh cong, neu password sai thi bao loi thong tin khong hop le
        * */
        if("1234".equals(req.getPassword())){
            return "Dang nhap thanh cong";
        } else {
            return "Thong tin khong hop le";
        }
    }


    @PutMapping(value = "/updateEmail")
    public String updateEmail(@RequestBody UpdateReq req){
        /*Tim ban ghi co username trong request
        Cap nhat email cua ban ghi theo email trong request
        * */

        return "Thanh cong";
    }

    @DeleteMapping(value = "/remove")
    public String removeUserByUsername(@RequestParam(name = "username") String username){
        System.out.println("Removing user: " + username);
        return "Thanh cong";
    }

}
