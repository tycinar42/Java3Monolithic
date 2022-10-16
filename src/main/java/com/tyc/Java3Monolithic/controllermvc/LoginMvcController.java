package com.tyc.Java3Monolithic.controllermvc;

import com.tyc.Java3Monolithic.repository.entity.Musteri;
import com.tyc.Java3Monolithic.service.MusteriService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginMvcController {
    private final MusteriService musteriService;
    @GetMapping("/loginpage")
    public ModelAndView loginGirisSayfasi() {
        /**
         * 1-Once ModelAndView nesnesi olusturulur.
         * 2-ModelAndView nesnesinin hangi sayfayi yonetecegini atariz
         */
        String username = "Kullanici Adi: ";
        String password = "Sifre: ";
        ModelAndView modelAndView = new ModelAndView();
        // "" ici template'deki sayfa adiyla ayni olmalidir.
        modelAndView.setViewName("login");
        modelAndView.addObject("Bilgeadam",
                "Ankara Java-3 Grubu");
        modelAndView.addObject("username", username);
        modelAndView.addObject("password", password);
        return modelAndView;
    }
    @PostMapping("/dologin")
    public ModelAndView doLogin(String txtusername, String txtpassword) {
        if(musteriService.isExistUser(txtusername, txtpassword)) {
            return new ModelAndView("redirect:/home");
        } else System.out.println("Kullanýcý adý veya þifre hatalý");
        return null;
    }
    @GetMapping("/registerpage")
    public ModelAndView register() {
        //return new ModelAndView("register");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }
    @PostMapping("/doregister")
    public ModelAndView doRegister(String email, String username, String password) {
        musteriService.save(Musteri.builder()
                        .email(email)
                        .username(username)
                        .psw(password)
                .build());
        return new ModelAndView("redirect:loginpage");
    }
}
