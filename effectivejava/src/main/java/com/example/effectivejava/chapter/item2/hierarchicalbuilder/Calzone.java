package com.example.effectivejava.chapter.item2.hierarchicalbuilder;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/11/29 11:27
 */
public class Calzone extends Pizza{
    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false;

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        public Calzone build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
    Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    public String toString() {
        return String.format("Calzone with %s and sauce on the %s", toppings, sauceInside ?
                "inside" : "outside");
    }
}
