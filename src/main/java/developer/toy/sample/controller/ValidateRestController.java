package developer.toy.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import developer.toy.sample.controller.validate.ValidateSample;
import developer.toy.sample.controller.validate.ValidateSample2;
import developer.toy.sample.model.Sample1Model;
import developer.toy.sample.model.ValidateSampleModel;

@RestController
public class ValidateRestController {

//	@Autowired
//	private 
	@Autowired
	private ValidateSampleModel validateSampleModel;
	
	@Autowired
	private ValidateSample validate;
	
	@Autowired
	private Errors errors;

	@InitBinder(validate)
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("id", "name");
		validate.validate(validateSampleModel, errors);
	}
	 	
	@RequestMapping("/validateSample1")
	public String doSample1(ValidateSampleModel req) {
		System.out.println(req.toString());
		return "called validateSample1";
	}

	@RequestMapping("/validateSample2")
	public String doSample2() {
		return "called validateSample2";
	}

	@RequestMapping(value="/validateSample3",
					method=RequestMethod.POST,
					headers="Accept=application/json",
					consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,
					produces=MediaType.APPLICATION_JSON_UTF8_VALUE
					)
	public ValidateSampleModel doSample3(@RequestParam("token") String token,
							@Validated @RequestBody ValidateSampleModel req) {
		System.out.println(req.toString());
		return req;
	}
}
