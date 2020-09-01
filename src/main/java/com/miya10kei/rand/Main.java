package com.miya10kei.rand;

import picocli.CommandLine;

public class Main {
  public static void main(String... args) {
    var exitCode = new CommandLine(new RandCommand()).execute(args);
    System.exit(exitCode);
  }
}
