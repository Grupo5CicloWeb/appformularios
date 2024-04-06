package pe.edu.cibertec.appformularios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImcController {

    @GetMapping("/calculadora-imc")
    public String calculadoraImc(){
        return "imc";
    }
}
