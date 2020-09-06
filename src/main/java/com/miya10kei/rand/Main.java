package com.miya10kei.rand;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Option;
import picocli.CommandLine.Spec;

@Command(name = "rand")
public class Main implements Runnable {
  @Spec
  private CommandSpec spec;

  @Option(names = {"-h", "--help"}, usageHelp = true, description = "Display this help message")
  private boolean usageHelpRequested;

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
