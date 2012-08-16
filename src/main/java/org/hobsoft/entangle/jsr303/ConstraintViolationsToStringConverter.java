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

import java.util.Collection;

import javax.validation.ConstraintViolation;

import org.hobsoft.entangle.Converter;

/**
 * 
 * 
 * @author Mark Hobson
 */
class ConstraintViolationsToStringConverter implements Converter<Collection<ConstraintViolation<?>>, String>
{
	// Converter methods ------------------------------------------------------
	
	/**
	 * {@inheritDoc}
	 */
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
	public Collection<ConstraintViolation<?>> unconvert(String string)
	{
		throw new UnsupportedOperationException();
	}
}
