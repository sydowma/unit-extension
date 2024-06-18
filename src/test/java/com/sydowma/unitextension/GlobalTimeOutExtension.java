package com.sydowma.unitextension;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.concurrent.*;

public class GlobalTimeOutExtension implements BeforeEachCallback, AfterEachCallback {

    private static final ScheduledExecutorService SCHEDULER = Executors.newSingleThreadScheduledExecutor(
            (runnable) ->
            {
                final Thread thread = new Thread(runnable);
                thread.setDaemon(true);
                thread.setName("interrupting-test-callback");

                return thread;
            });

    private ScheduledFuture<?> timer = null;

    @Override
    public void afterEach(final ExtensionContext context)
    {
        if (null != timer)
        {
            timer.cancel(false);
            if (!timer.isDone())
            {
                try
                {
                    timer.get();
                }
                catch (final InterruptedException | ExecutionException ignore)
                {
                }
            }

            timer = null;
        }
    }

    @Override
    public void beforeEach(final ExtensionContext context)
    {
        timer = null;

        context.getStore(ExtensionContext.Namespace.create(context.getUniqueId())).put("start_time", System.currentTimeMillis());

        timer = SCHEDULER.scheduleWithFixedDelay(() -> print(context), 1000, 1000, TimeUnit.MILLISECONDS);

    }

    private void print(ExtensionContext context) {
        // estimated time
        Object startTime = context.getStore(ExtensionContext.Namespace.create(context.getUniqueId())).get("start_time");
        System.out.println(context.getRequiredTestMethod().getName() + " Estimated time " + (System.currentTimeMillis() - (long) startTime));
    }
}
