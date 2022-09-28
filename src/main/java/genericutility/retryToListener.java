package genericutility;

import java.lang.reflect.Constructor;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class retryToListener implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor,
			java.lang.reflect.Method testMethod) 
	{
		annotation.setRetryAnalyzer(genericutility.retryimplemenetation.class);		
	}

}
