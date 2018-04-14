package developer.toy.sample.controller;

import org.slf4j.LoggerFactory;
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

import developer.toy.sample.controller.validate.SampleValidator;
import developer.toy.sample.model.ValidateSampleModel;

@RestController
public class ValidateRestController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ValidateRestController.class);
	
//	@Autowired
//	private ValidateSampleModel validateSampleModel;
//	
	@Autowired
	private SampleValidator validator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validator);
	}
	 	
	@RequestMapping("/validateSample1")
	public String doSample1(ValidateSampleModel req) {

		logger.info("validateSample1 開始");

		System.out.println(req.toString());

		logger.info("validateSample1 終了");

		return "called validateSample1";
	}

	@RequestMapping("/validateSample2")
	public String doSample2() {

		logger.info("validateSample2 開始");
		logger.info("validateSample2 終了");
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
		logger.info("validateSample3 開始");
		
		System.out.println(req.toString());

		logger.info("validateSample3 終了");

		return req;
	}
}
