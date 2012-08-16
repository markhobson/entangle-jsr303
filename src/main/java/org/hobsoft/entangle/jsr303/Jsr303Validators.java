/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hobsoft.entangle.jsr303;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.hobsoft.entangle.Validator;

/**
 * 
 * 
 * @author Mark Hobson
 * @version $Id: Jsr303Validators.java 101063 2012-05-03 14:10:47Z mark@IIZUKA.CO.UK $
 */
public final class Jsr303Validators
{
	// types ------------------------------------------------------------------
	
	/**
	 * Lazy initialization holder class.
	 */
	private static class LazyValidator
	{
		// constants --------------------------------------------------------------
		
		private static final javax.validation.Validator VALIDATOR;
		
		static
		{
			ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
			VALIDATOR = validatorFactory.getValidator();
		}
	}

	// constructors -----------------------------------------------------------
	
	private Jsr303Validators()
	{
		throw new AssertionError();
	}
	
	// public methods ---------------------------------------------------------
	
	public static <T> Validator<Object, ConstraintViolation<T>> property(final Class<T> beanType,
		final String propertyName)
	{
		return new Validator<Object, ConstraintViolation<T>>()
		{
			public Set<ConstraintViolation<T>> validate(Object value)
			{
				return getValidator().validateValue(beanType, propertyName, value);
			}
		};
	}
	
	// private methods --------------------------------------------------------
	
	private static javax.validation.Validator getValidator()
	{
		return LazyValidator.VALIDATOR;
	}
}
