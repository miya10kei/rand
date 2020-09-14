package com.miya10kei.rand;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Spec;

@Command(name = "rand", mixinStandardHelpOptions = true)
public class Main implements Runnable {
  @Spec
  private CommandSpec spec;

  /**
   * main.
   */
  public static void main(String... args) {
    var exitCode = new CommandLine(new Main())
        .addSubcommand(new ShuffleCommand())
        .addSubcommand(new GenerateCommand())
        .execute(args);
    System.exit(exitCode);
  }

  @Override
  public void run() {
    spec.commandLine().usage(spec.commandLine().getOut());
  }
}
