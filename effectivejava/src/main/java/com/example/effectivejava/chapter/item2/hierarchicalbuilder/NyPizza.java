package com.example.effectivejava.chapter.item2.hierarchicalbuilder;

import java.util.Objects;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/11/29 10:46
 */
public class NyPizza extends Pizza{
    public enum Size {SMALL, MEDIUM, LARGE}
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {

        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        public NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    public String toString() {
        return "New York Pizza with" + toppings;
    }
}
