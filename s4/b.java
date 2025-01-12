package s4;

import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public interface b extends a {
    Object call(Object... objArr);

    Object callBy(Map map);

    List getParameters();

    g getReturnType();

    List getTypeParameters();

    h getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
