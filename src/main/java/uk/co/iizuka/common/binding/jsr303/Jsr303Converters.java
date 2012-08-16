/*
 * $HeadURL: https://svn.iizuka.co.uk/common/binding/jsr303/tags/1.0.0-beta-1/src/main/java/uk/co/iizuka/common/binding/jsr303/Jsr303Converters.java $
 * 
 * (c) 2011 IIZUKA Software Technologies Ltd.  All rights reserved.
 */
package uk.co.iizuka.common.binding.jsr303;

import java.util.Collection;

import javax.validation.ConstraintViolation;

import org.hobsoft.entangle.Converter;

/**
 * 
 * 
 * @author Mark Hobson
 * @version $Id: Jsr303Converters.java 101060 2012-05-03 13:40:20Z mark@IIZUKA.CO.UK $
 */
public final class Jsr303Converters
{
	// constants --------------------------------------------------------------
	
	private static final Converter<Collection<ConstraintViolation<?>>, String> VIOLATIONS_TO_STRING =
		new ConstraintViolationsToStringConverter();

	// constructors -----------------------------------------------------------
	
	private Jsr303Converters()
	{
		throw new AssertionError();
	}
	
	// public methods ---------------------------------------------------------
	
	public static Converter<Collection<ConstraintViolation<?>>, String> violationsToString()
	{
		return VIOLATIONS_TO_STRING;
	}
}
