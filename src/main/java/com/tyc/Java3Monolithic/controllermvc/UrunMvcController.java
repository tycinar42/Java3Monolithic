package com.tyc.Java3Monolithic.controllermvc;

import com.tyc.Java3Monolithic.dto.request.UrunSaveRequestDto;
import com.tyc.Java3Monolithic.mvcmodels.UrunModel;
import com.tyc.Java3Monolithic.repository.entity.Urun;
import com.tyc.Java3Monolithic.service.UrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.tyc.Java3Monolithic.constants.EndPoints.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(URUN)
public class UrunMvcController {
    private final UrunService urunService;

    // http://localhost:9090/urun/save
    @PostMapping("/save")
    public ModelAndView save(UrunSaveRequestDto dto) {
        urunService.save(dto);

        return new ModelAndView("redirect:/home");
    }
}
