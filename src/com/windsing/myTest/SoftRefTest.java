package com.windsing.myTest;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

import com.windsing.testSource.People;

public class SoftRefTest {

	public static People p;

	// 软引用
	@SuppressWarnings("unchecked")
	public static void testSoftRef() {

		// 创建一个强引用
		p = new People();
		System.out.println("强引用P：" + p);
		System.out.println("p.anme = " + p.name);

		// 创建引用队列，队列里面保存的是失去强引用的软引用对象
		ReferenceQueue<People> refq = new ReferenceQueue<People>();

		// 使用强引用对象和引用队列，创建一个软引用。
		SoftReference<People> pSoftRef = new SoftReference<People>(p, refq);
		System.out.println("软引用pSoftRef：" + pSoftRef.get());
		System.out.println("pSoftRef.get().name = " + pSoftRef.get().name);

		while ((pSoftRef = (SoftReference<People>) refq.poll()) != null) {
			// 清除ref
			System.out.println("refq");
		}

		System.out.println("清空P对象，手动GC");
		p = null;
		System.gc();
		System.out.println("软引用pSoftRef：" + pSoftRef.get());

	}

	// 弱引用
	public static void testWeakRef() {
		p = new People();
		System.out.println("\n" + "强引用p：" + p);

		WeakReference<People> pWeakRef = new WeakReference<>(p);
		System.out.println("弱引用pWeakRef：" + pWeakRef.get());
		System.out.println("pWeakRef.get().name = " + pWeakRef.get().name);

		System.out.println("清空P对象，手动GC");
		p = null;
		System.gc();
		System.out.println("弱引用pWeakRef：" + pWeakRef.get());

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testSoftRef();
		// testWeakRef();
	}

}
