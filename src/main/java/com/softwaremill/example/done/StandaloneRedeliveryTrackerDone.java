package com.softwaremill.example.done;

import com.softwaremill.example.UncaughtExceptionHandling;
import com.softwaremill.kmq.RedeliveryTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;

import static com.softwaremill.example.done.StandaloneConfigDone.KAFKA_CLIENTS;
import static com.softwaremill.example.done.StandaloneConfigDone.KMQ_CONFIG;

class StandaloneRedeliveryTrackerDone {
    private final static Logger LOG = LoggerFactory.getLogger(StandaloneRedeliveryTrackerDone.class);

    public static void main(String[] args) throws InterruptedException, IOException {
        UncaughtExceptionHandling.setup();

        Closeable redelivery = RedeliveryTracker.start(KAFKA_CLIENTS, KMQ_CONFIG);
        LOG.info("Redelivery tracker started");

        System.in.read();

        redelivery.close();
        LOG.info("Redelivery tracker stopped");
    }
}