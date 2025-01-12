package com.google.gson.internal;

import com.google.gson.stream.JsonWriter;
import java.io.Writer;
/* loaded from: classes.dex */
public abstract class l {

    /* loaded from: classes.dex */
    private static final class a extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f5820a;

        /* renamed from: b  reason: collision with root package name */
        private final C0061a f5821b = new C0061a();

        /* renamed from: com.google.gson.internal.l$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static class C0061a implements CharSequence {

            /* renamed from: a  reason: collision with root package name */
            char[] f5822a;

            C0061a() {
            }

            @Override // java.lang.CharSequence
            public char charAt(int i6) {
                return this.f5822a[i6];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f5822a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i6, int i7) {
                return new String(this.f5822a, i6, i7 - i6);
            }
        }

        a(Appendable appendable) {
            this.f5820a = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int i6) {
            this.f5820a.append((char) i6);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i6, int i7) {
            C0061a c0061a = this.f5821b;
            c0061a.f5822a = cArr;
            this.f5820a.append(c0061a, i6, i7 + i6);
        }
    }

    public static void a(com.google.gson.f fVar, JsonWriter jsonWriter) {
        l3.l.U.d(jsonWriter, fVar);
    }

    public static Writer b(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }
}
