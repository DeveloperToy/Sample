package developer.toy.sample.controller.validate;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import developer.toy.sample.model.Sample1Model;
import developer.toy.sample.model.ValidateSampleModel;

@Component
public class ValidateSample implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		// TODO 自動生成されたメソッド・スタブ
		addressValidate((ValidateSampleModel) target);
	}
	
	private void addressValidate(ValidateSampleModel target) {
		if("1".equals(target.getValue1())) {
			if(StringUtils.isEmpty(target.getValue2())) {
//				//とりあえず、エクセプションで試す
//				throw new Exception();
			}
		}
	}
}
