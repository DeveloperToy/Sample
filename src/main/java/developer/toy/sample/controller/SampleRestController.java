package developer.toy.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import developer.toy.sample.model.Sample1Model;

@RestController
public class SampleRestController
{

	@RequestMapping("/sample1")
	public String doSample1( Sample1Model req )
	{
		System.out.println( req.toString() );
		return "called sample1";
	}

	@RequestMapping("/sample2")
	public String doSample2( Sample1Model req )
	{
		System.out.println( req.toString() );
		return "called sample2";
	}
}