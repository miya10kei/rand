package com.miya10kei.rand;

import java.util.concurrent.Callable;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Option;
import picocli.CommandLine.Spec;

@Command(name = "generate", description = "generate random value", mixinStandardHelpOptions = true)
public class GenerateCommand implements Callable<Integer> {
  @Spec
  private CommandSpec spec;
  @Option(names = "--min", description = "Minimum value", defaultValue = "0")
  private int min;
  @Option(names = "--max", description = "Maximum value", defaultValue = "1000")
  private int max;
  @Option(names = {"-n", "--number"}, description = "Number of values", defaultValue = "1")
  private int number;

  @Override
  public Integer call() {
    number = number <= 0 ? 1 : number;
    for (int i = 0; i < number; i++) {
      var value = (int) (Math.random() * (max - min + 1) + min);
      spec.commandLine().getOut().printf(format(), i + 1, value);
    }
    return 0;
  }

  private String format() {
    return "%" + digits() + "d: %d\n";
  }

  private int digits() {
    return String.valueOf(number).length();
  }
}
