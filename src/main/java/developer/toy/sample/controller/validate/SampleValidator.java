package developer.toy.sample.controller.validate;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import developer.toy.sample.controller.ValidateRestController;
import developer.toy.sample.model.Sample1Model;
import developer.toy.sample.model.ValidateSampleModel;

@Component
public class SampleValidator implements Validator{

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SampleValidator.class);

//	@Autowired
//	private Sample1Model sampleModel;
	
	@SuppressWarnings("unchecked ")
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO 自動生成されたメソッド・スタブ
		 return ValidateSampleModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors)
	{
		logger.debug("[debug]バリデータ　開始");
		ValidateSampleModel vsm = (ValidateSampleModel) target;

		valu1Validate(vsm, errors);
//	    errors.rejectValue("message", 
//	    	      "error.required", "メッセージは必須です");
		logger.debug("[debug]バリデータ　終了");

	}
	
	private void valu1Validate(ValidateSampleModel target, Errors errors)
	{
		if("1".equals(target.getValue1())) {
			if(StringUtils.isEmpty(target.getValue2())) {
			    logger.debug("value2が空の場合、エラーメッセージです");
				//とりあえず、エクセプションで試す
//				throw new Exception("value1が1の場合のException");
			    errors.rejectValue("message", 
			    	      "error.required", "value2が空の場合、エラーメッセージです");
			}
		}
	}
}
