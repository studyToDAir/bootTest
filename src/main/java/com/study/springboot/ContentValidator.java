package com.study.springboot;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContentValidator implements Validator {

	// 검증 대상
	@Override
	public boolean supports(Class<?> clazz) {
		return ContentDto.class.isAssignableFrom(clazz);
	}

	// 본격적인 검증
	@Override
	public void validate(Object target, Errors errors) {
		
		ContentDto dto = (ContentDto)target;
		
		String sWriter = dto.getWriter();
		if(sWriter == null || sWriter.trim().length() == 0) {
			System.out.println("writer가 null이거나 내용이 없습니다.");
			errors.rejectValue("writer", "trouble");
		}

		String sContent = dto.getContent();
		if(sContent == null || sContent.trim().length() == 0) {
			System.out.println("content가 null이거나 내용이 없습니다.");
			errors.rejectValue("content", "trouble");
		}
	}

}
