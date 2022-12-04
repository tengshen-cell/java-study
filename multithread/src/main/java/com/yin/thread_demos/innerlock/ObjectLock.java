package com.yin.thread_demos.innerlock;

import com.yin.util.ByteUtil;
import com.yin.util.Print;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author 滕广银
 * @description memory test
 * @date 2022/12/4 19:27
 */
public class ObjectLock {
    private Integer amount = 0;

    public void increase() {
        synchronized (this) {
            amount++;
        }
    }

    public Integer getAmount() {
        return amount;
    }

    public String hexHash() {
        int hashCode = this.hashCode();
        byte[] bytes = ByteUtil.int2Bytes_LE(hashCode);
        return ByteUtil.byteToHex(bytes);
    }

    public String binaryHash() {
        int hashCode = this.hashCode();

        byte[] bytes = ByteUtil.int2Bytes_LE(hashCode);
        StringBuffer buffer = new StringBuffer();
        for (byte b : bytes) {
            buffer.append(ByteUtil.byte2BinaryString(b));
            buffer.append(" ");
        }
        return buffer.toString();
    }

    public String hexThreadId() {
        long threadId = Thread.currentThread().getId();
        byte[] bytes = ByteUtil.long2bytes_LE(threadId);
        return ByteUtil.byteToHex(bytes);
    }

    public String binaryThreadId() {
        long threadId = Thread.currentThread().getId();
        byte[] bytes = ByteUtil.long2bytes_LE(threadId);
        StringBuffer buffer = new StringBuffer();
        for (byte b : bytes) {
            buffer.append(ByteUtil.byte2BinaryString(b));
            buffer.append(" ");
        }
        return buffer.toString();
    }

    public void printSelf() {
        Print.fo("lock hexHash=" + hexHash());

        Print.fo("lock binaryHash=" + binaryHash());

        String printable = ClassLayout.parseInstance(this).toPrintable();

        Print.fo("lock = " + printable);
    }

    public void printObjectStruct() {
        String printable = ClassLayout.parseInstance(this).toPrintable();
        Print.fo("lock = " + printable);
    }
}
