package it.emdevs.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@GetMapping("prova")
	public String test() {
		return "prova";
	}
}
