package com.weavus.creditweb.controller.payment;
import com.weavus.creditweb.dto.CreditInfo;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.ui.Model;

@Controller
public class PaymentController {

    @GetMapping("/")
    public String init(Model model) {
        //簡単なgetForObjectを使用
//        String apiUrl = "http://localhost:8081/creditInfo/1222-2222-0321-7823";
//        RestTemplate restTemplate = new RestTemplate();
//        CreditInfo creditInfo = restTemplate.getForObject(apiUrl, CreditInfo.class);
//        model.addAttribute("creditInfo", creditInfo);
//        System.out.println(creditInfo.getName());
//
//        return "index"; // テンプレート名を返す
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CreditInfo> response =
                restTemplate.exchange("http://localhost:8081/creditInfo/1222-2222-0321-7823", HttpMethod.GET,null, CreditInfo.class);

        CreditInfo creditInfo= response.getBody();

        model.addAttribute("creditInfo", creditInfo);


        return "index";
    }
    @GetMapping("/payment/proc")
    public String proc(String card, long price, Model model) {

        System.out.println(card);
        System.out.println(price);


        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CreditInfo> response =
                restTemplate.exchange("http://localhost:8081/creditInfo/1222-2222-0321-7823",HttpMethod.GET,null, CreditInfo.class);

        CreditInfo creditInfo= response.getBody();

        model.addAttribute("creditInfo", creditInfo);


        return "index";
    }

}
