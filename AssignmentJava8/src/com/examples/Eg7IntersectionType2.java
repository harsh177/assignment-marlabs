package com.examples;

import java.util.function.Consumer;

public class Eg7IntersectionType2 {
public static void main(String[] args) {
	with((Anon & Quacks & Waddles)i->i,d->{
		d.quack();
		d.waddle();
	});
}

interface Quacks {
    default void quack() {
        System.out.println("Quack");
    }
}

interface Waddles {
    default void waddle() {
        System.out.println("Waddle");
    }
}

public interface Anon {
    Object f(Object o);
}

public static <T extends Anon> void with(T t, Consumer<T> consumer) {
    consumer.accept(t);
}

}
