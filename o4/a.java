package o4;

import kotlin.jvm.internal.d;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.s;
import s4.c;
/* loaded from: classes.dex */
public abstract class a {
    public static final Class a(c cVar) {
        l.d(cVar, "<this>");
        Class b6 = ((d) cVar).b();
        if (b6.isPrimitive()) {
            String name = b6.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    return !name.equals("double") ? b6 : Double.class;
                case 104431:
                    return !name.equals("int") ? b6 : Integer.class;
                case 3039496:
                    return !name.equals("byte") ? b6 : Byte.class;
                case 3052374:
                    return !name.equals("char") ? b6 : Character.class;
                case 3327612:
                    return !name.equals("long") ? b6 : Long.class;
                case 3625364:
                    return !name.equals("void") ? b6 : Void.class;
                case 64711720:
                    return !name.equals("boolean") ? b6 : Boolean.class;
                case 97526364:
                    return !name.equals("float") ? b6 : Float.class;
                case 109413500:
                    return !name.equals("short") ? b6 : Short.class;
                default:
                    return b6;
            }
        }
        return b6;
    }

    public static final c b(Class cls) {
        l.d(cls, "<this>");
        return s.b(cls);
    }
}
