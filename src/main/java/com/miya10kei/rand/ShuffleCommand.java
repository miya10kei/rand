package com.miya10kei.rand;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Spec;

@Command(name = "shuffle", description = "Shuffle the given values")
public class ShuffleCommand implements Callable<Integer> {
  @Spec
  private CommandSpec spec;
  @Parameters(arity = "1..*", description = "The Values you want to shuffle")
  private List<String> values;
  @Option(names = {"-h", "--help"}, usageHelp = true, description = "Display this help message")
  private boolean usageHelpRequested;

  @Override
  public Integer call() {
    Collections.shuffle(values);
    for (int i = 0; i < values.size(); i++) {
      spec.commandLine().getOut().printf(format(), i + 1, values.get(i));
    }
    return 0;
  }

  private String format() {
    return "%" + digits() + "d: %s\n";
  }

  private int digits() {
    return String.valueOf(values.size()).length();
  }
}
