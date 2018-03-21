package developer.toy.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {
	
	@RequestMapping("/sample1")
	public String doSample1() {
		return "called sample1";
	}

	@RequestMapping("/sample2")
	public String doSample2() {
		return "called sample2";
	}
}
