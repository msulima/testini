package com.github.pushman.testini.runner.configuration

import com.github.pushman.testini.runner.TestRunner

abstract class TestRunnerConfigurationBase extends
TestRunner with
TestClassProvider with
TestSuiteContext with
TestRunnerTestMethodProvider with
TestRunnerTestDescriptionProvider with
TestRunnerValidator with
TestRunnerMethodInvokerProvider
