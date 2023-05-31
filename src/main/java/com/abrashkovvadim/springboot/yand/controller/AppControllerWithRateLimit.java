package com.abrashkovvadim.springboot.yand.controller;

import io.github.bucket4j.Bucket;

public interface AppControllerWithRateLimit {

    public Bucket getBucket();
}
