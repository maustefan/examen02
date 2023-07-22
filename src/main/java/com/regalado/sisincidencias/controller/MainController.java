package com.regalado.sisincidencias.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class MainController {
	@GetMapping("/incidencias")
    public String getIncidencias(Model model) {
		return "incidencias";
	}

}
