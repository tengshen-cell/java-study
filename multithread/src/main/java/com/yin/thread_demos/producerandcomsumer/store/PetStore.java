package com.yin.thread_demos.producerandcomsumer.store;

import com.yin.thread_demos.petstore.goods.IGoods;
import com.yin.util.Print;

import java.util.ArrayList;

/**
 * @author 滕广银
 * @description TODO
 * @date 2022/12/4 10:30
 */
public class PetStore {
    public static final int CONSUME_GAP = 1000;
    public static final int PRODUCE_GAP = 1000;

    private static PetStore instance = new PetStore();

    private PetStore() {

    }

    public static PetStore inst() {
        return instance;
    }

    private ArrayList<IGoods> goodsList = new ArrayList<IGoods>();

    public void consume() {
        Print.cfo("goodsList.size=" + goodsList.size());
        IGoods goods = goodsList.get(0);
        if (goods == null) {
            Print.cfo("队列已经空了！");
            return;
        }

        Print.cfo(goods + "");
        goodsList.remove(goods);
    }

    public void produce() {

    }

}
