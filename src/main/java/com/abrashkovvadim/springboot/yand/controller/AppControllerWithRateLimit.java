package com.abrashkovvadim.springboot.yand.controller;

import io.github.bucket4j.Bucket;

public interface AppControllerWithRateLimit {

    Bucket getBucket(String method);
}
