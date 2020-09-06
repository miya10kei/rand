package com.miya10kei.rand

import picocli.CommandLine
import spock.lang.Specification

class ShuffleCommandSpec extends Specification {
  private CommandLine cmd
  private StringWriter sw

  def setup() {
    cmd = new CommandLine(new ShuffleCommand()).tap {
      sw = new StringWriter()
      setOut(new PrintWriter(sw))
    }
  }

  def "When pass 11 values, Expect output with correct format"() {
    given:
    def args = (0..10).collect { "val${it}" }.toArray() as String[]

    when:
    def exitCode = cmd.execute(args)

    then:
    assert exitCode == 0
    sw.toString().split("\n").with { lines ->
      assert lines.length === 11
      lines.eachWithIndex { it, i ->
        assert it.matches(/^\s?${i + 1}+:\sval\d{1,2}$/)
      }
    }
  }

  def "When not pass value, Expect exit code is 2"() {
    when:
    def exitCode = cmd.execute(new String[]{})

    then:
    assert exitCode == 2
  }
}
