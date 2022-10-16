package com.tyc.Java3Monolithic.controllermvc;

import com.tyc.Java3Monolithic.mvcmodels.HomeModel;
import com.tyc.Java3Monolithic.service.UrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeMvcController {
    private final UrunService urunService;

    @GetMapping("/home")
    ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        HomeModel homeModel = HomeModel.builder()
                .menulistesi(Arrays.asList("Ana Sayfa", "Ürünler", "Hakkýmýzda", "Ýletiþim"))
                .baslik("Satýþ Yönetim Sistemi")
                .avatar("https://www.w3schools.com/howto/img_avatar.png")
                .kullaniciadi("Yasin")
                .urunler(urunService.findAll())
                .build();
        modelAndView.addObject("model", homeModel);
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
