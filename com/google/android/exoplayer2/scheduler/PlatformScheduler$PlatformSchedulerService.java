package com.google.android.exoplayer2.scheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.PersistableBundle;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.s0;
import v1.c;
/* loaded from: classes.dex */
public final class PlatformScheduler$PlatformSchedulerService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        PersistableBundle extras = jobParameters.getExtras();
        int f6 = new c(extras.getInt("requirements")).f(this);
        if (f6 == 0) {
            s0.N0(this, new Intent((String) a.e(extras.getString("service_action"))).setPackage((String) a.e(extras.getString("service_package"))));
            return false;
        }
        StringBuilder sb = new StringBuilder(33);
        sb.append("Requirements not met: ");
        sb.append(f6);
        n.h("PlatformScheduler", sb.toString());
        jobFinished(jobParameters, true);
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
