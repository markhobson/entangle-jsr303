/*
 * $HeadURL: https://svn.iizuka.co.uk/common/binding/jsr303/tags/1.0.0-beta-1/src/main/java/uk/co/iizuka/common/binding/jsr303/Jsr303Validators.java $
 * 
 * (c) 2011 IIZUKA Software Technologies Ltd.  All rights reserved.
 */
package uk.co.iizuka.common.binding.jsr303;

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
