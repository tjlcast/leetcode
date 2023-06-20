package com.jialtang.patterns;

public class SingletonPattern {
  public static void main(String[] args) {
    Singleton build = Singleton.build();
    String say = build.say();
    System.out.println(say);

    Singleton build1 = Singleton.build();
    System.out.println(build1.say());

    if (build == build1) {
      System.out.println("They are same.");
    }
  }

  static class Singleton {
    private static Singleton singleton;

    public static Singleton build() {
      synchronized (Singleton.class) {
        if (singleton == null) {
          synchronized (Singleton.class) {
            singleton = new Singleton();
          }
        }
      }
      return singleton;
    }

    private Singleton() {}

    public String say() {
      return "Hello world";
    }
  }
}
