/*
 * $HeadURL: https://svn.iizuka.co.uk/common/binding/jsr303/tags/1.0.0-beta-1/src/main/java/uk/co/iizuka/common/binding/jsr303/ConstraintViolationsToStringConverter.java $
 * 
 * (c) 2011 IIZUKA Software Technologies Ltd.  All rights reserved.
 */
package uk.co.iizuka.common.binding.jsr303;

import java.util.Collection;

import javax.validation.ConstraintViolation;

import uk.co.iizuka.common.binding.Converter;

/**
 * 
 * 
 * @author Mark Hobson
 * @version $Id: ConstraintViolationsToStringConverter.java 101060 2012-05-03 13:40:20Z mark@IIZUKA.CO.UK $
 */
class ConstraintViolationsToStringConverter implements Converter<Collection<ConstraintViolation<?>>, String>
{
	// Converter methods ------------------------------------------------------
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String convert(Collection<ConstraintViolation<?>> violations)
	{
		if (violations == null)
		{
			return null;
		}
		
		StringBuilder builder = new StringBuilder();
		
		for (ConstraintViolation<?> violation : violations)
		{
			if (builder.length() > 0)
			{
				builder.append("; ");
			}
			
			builder.append(violation.getMessage());
		}
		
		return builder.toString();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<ConstraintViolation<?>> unconvert(String string)
	{
		throw new UnsupportedOperationException();
	}
}
