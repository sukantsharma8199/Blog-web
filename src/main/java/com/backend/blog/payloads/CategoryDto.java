package com.backend.blog.payloads;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDto {
	
	private int CategoryID;
	
	@NotEmpty(message = "it must be fiel")
	private String  categoryTital;
	@NotEmpty(message = "you have to fill")
	private String categorydescription;

}
