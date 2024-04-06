package pe.edu.cibertec.appformularios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pe.edu.cibertec.appformularios.model.ImcModel;

@Controller
public class ImcController {

    @GetMapping("/calculadora-imc")
    public String calculadoraImc(Model model){
        model.addAttribute("imcmodel",
                new ImcModel());
        return "imc";
    }

    @PostMapping("/calcularimc")
    public String calcularImc(Model model,
                              @ModelAttribute("imcmodel")
                              ImcModel imcModel){
        double tallam = imcModel.getTalla() / 100;
        double valorImc = imcModel.getPeso() / (tallam * tallam);
        String diagnosticoImc ="";
        String colorMensaje ="alert-danger";
        if(valorImc <= 18.5){
            diagnosticoImc = "por debajo del peso.";
            colorMensaje ="alert-dark";
        }else if(valorImc <= 25){
            diagnosticoImc = "con peso normal.";
            colorMensaje ="alert-primary";
        }else if(valorImc <= 30){
            diagnosticoImc = "con sobrepeso.";
            colorMensaje ="alert-warning";
        }else if(valorImc <= 35){
            diagnosticoImc = "con obesidad leve.";
        }else if(valorImc <= 39){
            diagnosticoImc = "con obesidad media.";
        }else {
            diagnosticoImc = "con obesidad mórbida.";
        }
        model.addAttribute("resultado",
                "Su valor IMC es: " +
                        String.format("%.2f",valorImc)+
                 ", usted se encuentra "+diagnosticoImc);
        model.addAttribute("colormensaje",
                colorMensaje);
        model.addAttribute("imcmodel",
                new ImcModel());
        return "imc";
    }



}
