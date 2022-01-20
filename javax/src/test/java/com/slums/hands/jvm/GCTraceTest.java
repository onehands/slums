package com.slums.hands.jvm;

import org.junit.Test;

/**
 * @author: onehands
 * @description: sth
 * @date: 2022/1/15 12:12
 * @version: 1.0
 */
public class GCTraceTest {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * 尝试分配三个2MB大小和一个4MB大小的对象，在运行
     * 时通过-Xms20M、-Xmx20M、-Xmn10M这三个参数限制了Java堆大小为20MB，不可扩展，其中
     * 10MB分配给新生代，剩下的10MB分配给老年代。-XX：Survivor-Ratio=8决定了新生代中Eden区与一
     * 个Survivor区的空间比例是8∶1，从输出的结果也清晰地看到“eden space 8192K、from space 1024K、to
     * space 1024K”的信息，新生代总可用空间为9216KB（Eden区+1个Survivor区的总容量）
     */
    @Test
    public void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB]; // 出现一次Minor GC
    }
}
