package com.miya10kei.rand

import picocli.CommandLine
import spock.lang.Specification

class GenerateCommandSpec extends Specification {
  private CommandLine cmd
  private StringWriter sw

  def setup() {
    cmd = new CommandLine(new GenerateCommand()).tap {
      sw = new StringWriter()
      setOut(new PrintWriter(sw))
    }
  }

  def "When set mix = 0 and max = 5, Expect to generate a random value that is 1 or more and 5 or less"() {
    when:
    def exitCode = cmd.execute("--min", "1", "--max", "5")

    then:
    assert exitCode == 0
    def actual = extractValue(sw.toString())
    assert 0 <= actual
    assert actual <= 5

    where:
    i << (1..10)
  }

  def "When execute without arguments, Expect to generate a random value"() {
    when:
    def exitCode = cmd.execute()

    then:
    assert exitCode == 0
    def actual = extractValue(sw.toString())
    assert 0 <= actual
    assert actual <= 1000

    where:
    i << (1..10)
  }

  def "When execute with number argument, Expect to generate the random values"() {
    when:
    def exitCode = cmd.execute("-n", "11")

    then:
    assert exitCode == 0
    sw.toString().split("\n").with { lines ->
      assert lines.size() == 11
      lines.eachWithIndex { it, i ->
        assert it.matches(/^\s?${i + 1}: \d+$/)
      }
    }
  }

  private static def extractValue(String line) {
    def value = (line =~ /^\s?\d+:\s(\d+)\s+$/)[0][1]
    return Integer.parseInt(value)
  }

}
