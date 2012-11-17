package com.github.pushman.testini.testCases.providers.spring

import com.github.pushman.testini.testCases.{TestCase, ParameterisedTestCasesProvider}
import org.junit.runners.model.{FrameworkMethod, TestClass}
import java.lang.String
import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext

case class SpringTestCasesProvider(testClass: TestClass) extends ParameterisedTestCasesProvider(testClass) {

  val configLocation: String = "classpath:/" + testClass.getName.replace(".", "/") + ".xml"
  val context: ApplicationContext = new ClassPathXmlApplicationContext(configLocation)

  def computeTestKits(method: FrameworkMethod) =
    Option(testCaseForMethod(method)).map(_.kits)

  def testCaseForMethod(method: FrameworkMethod): TestCase =
    context.getBean(method.getMethod.getName, classOf[TestCase])
}