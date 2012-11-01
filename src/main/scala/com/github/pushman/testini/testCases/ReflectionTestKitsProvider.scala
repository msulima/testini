package com.github.pushman.testini.testCases

import org.junit.runners.model.FrameworkMethod
import com.github.pushman.testini.data.TestKit
import com.github.pushman.testini.util.TestKitConverter

case class ReflectionTestKitsProvider(methodExecutor: MethodExecutor, methodFinder: TestKitProviderMethodFinder)
  extends TestKitProvider {

  override def provideTestKits(method: FrameworkMethod): Option[Seq[TestKit]] =
    methodFinder.findProviderMethod(method.getMethod) collect {
      case providerMethod =>
        extractTestKits(methodExecutor.execute(method, providerMethod))
    }

  def extractTestKits(invocationResult: Any): Seq[TestKit] =
    TestKitConverter.forceConvertFrom(invocationResult)
}