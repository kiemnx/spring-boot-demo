package vn.plusplus.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.plusplus.springboot.utils.Account;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/ui")
public class UIController {
    @GetMapping(value = { "/", "/index" })
    public String index(Model model) {
        Account account = new Account();
        account.setUsername("kiemnx");
        account.setEmail("abc@gmail.com");

        Account account2 = new Account();
        account2.setUsername("khanh");
        account2.setEmail("khanh@gmail.com");

        List<Account> accountList = new ArrayList<>();
        accountList.add(account);
        accountList.add(account2);

        model.addAttribute("message", "Java Themyleaf");
        model.addAttribute("linkUrl", "https://24h.com.vn");
        /*Get user info from Database*/
        model.addAttribute("account", accountList);
        model.addAttribute("counter", 100);

        return "index";
    }

}
