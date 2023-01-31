package youTube.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryAnnoforsuite implements IAnnotationTransformer {
	
	public void transform(ITestAnnotation arg0, Class TestClass, Constructor TestConstrouctor, Method testMethod) {
		arg0.setRetryAnalyzer(RetryAnalyzerYT.class);
	}
	
}
