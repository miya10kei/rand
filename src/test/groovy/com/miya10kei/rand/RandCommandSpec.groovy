package com.miya10kei.rand

import picocli.CommandLine
import spock.lang.Specification

class RandCommandSpec extends Specification {
  private CommandLine cmd
  private StringWriter sw

  def setup() {
    cmd = new CommandLine(new RandCommand()).tap {
      sw = new StringWriter()
      setOut(new PrintWriter(sw))
    }
  }

  def When_Pass11Values_Expect_OutputWithCorrectFormat() {
    given:
    def args = (0..10).collect { "val${it}" }.toArray() as String[]

    when:
    def exitCode = cmd.execute(args)

    then:
    assert exitCode == 0
    sw.toString().split("\n").with {
      assert it.length === 11
      it.each {
        assert it.matches(/^\s*\d+:\sval\d{1,2}$/)
      }
    }
  }

  def When_NotPassValue_Expect_ExistCodeIs2() {
    when:
    def exitCode = cmd.execute(new String[]{})

    then:
    assert exitCode == 2
  }
}
